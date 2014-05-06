/**
 * 
 */
package com.pedroalmir.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.pedroalmir.model.Ant;
import com.pedroalmir.model.graph.Edge;
import com.pedroalmir.model.graph.Graph;
import com.pedroalmir.model.graph.Node;
import com.pedroalmir.model.problem.AntConfiguration;
import com.pedroalmir.model.solution.IterationSolution;
import com.pedroalmir.model.solution.Solution;

/**
 * Ant System Controller
 * 
 * @author Pedro Almir
 */
public class AntSystemControllerTSP {
	/** The problem definition that should be solved by this algorithm. */
	private Graph graph;
	
	/** The number/count of cities. */
	int nodeCount;
	
	/** AntConfiguration */
	private AntConfiguration configuration;
	
	/** Random */
	private Random random;
	
	/** List of ants */
	private List<Ant> ants;
	
	/** */
	private Solution solution;
	
	/** */
	private double theBest;
	private Ant theBestAnt;
	
	/**
	 * Constructor
	 * 
	 * @param graph
	 * @param problem
	 */
	public AntSystemControllerTSP(Graph graph, Node initialNode, AntConfiguration configuration) {
		super();
		this.graph = graph;
		this.theBest = Double.MAX_VALUE;
		this.configuration = configuration;
		this.nodeCount = graph.getNodes().size();
		
		this.random = new Random();
		this.ants = new LinkedList<Ant>();
		
		/* Ant Initialization */
		int antNumber = 1;
		for(int i = 0; i < this.configuration.getNumAgents(); i++, antNumber++){
			this.ants.add(new Ant("Ant number: " + antNumber, initialNode));
			
		}
		/* Pheromone initialization */
		resetSystem();
	}
	
	/** 
	 * Execute 
	 * @return solution
	 * */
	public Solution execute(){
		int execution = 0;
		/* Loop by executions */
		List<Solution> solutions = new LinkedList<Solution>();
		while(execution < this.configuration.getMaxExecutions()){
			int iteration = 0;
			/* Loop by iterations */
			LinkedList<IterationSolution> itSolutions = new LinkedList<IterationSolution>();
			
			long begin = System.currentTimeMillis();
			while(iteration < this.configuration.getMaxIterations()){
				/* Construção do caminho para todas as formigas. */
				construction();
				/* Evaporação do feromônio */
				makeEvaporation();
				/* Atualização do feromônio */
				makeActualization();
				/*  */
				itSolutions.add(getBetterResultAndResetSystem(iteration));
				iteration++;
			}
			long end = System.currentTimeMillis();
			
			/* Reset System */
			resetSystem();
			IterationSolution theBest = findTheBest(itSolutions);
			
			Solution solutionIT = new Solution("AntSystem-TSP", this.configuration, theBest.getDistance(), end-begin);
			solutionIT.setIterationSolutions(itSolutions);
			solutionIT.setTheBestAnt(theBest.getTheBestAnt());
			
			solutions.add(solutionIT);
			execution++;
		}
		this.solution = findTheBest(solutions);
		/* Just for debug */
		//System.out.println(this.solution);
		return this.solution;
	}
	
	/**
	 * Reset System
	 */
	private void resetSystem() {
		/* Pheromone initialization */
		double t0 = this.configuration.getInitialPheromone();
		for(Edge edge : this.graph.getEdges()){
			if(t0 > 0){
				double nextDouble = this.random.nextDouble();
				double pheromone = (nextDouble > 0d) ? (nextDouble * t0) : t0;
				edge.setPheromone(pheromone);
			}else{
				/* Valor randomicos entre 0.0 e 1.0 */
				double nextDouble = this.random.nextDouble();
				double pheromone = (nextDouble > 0d) ? (nextDouble) : 0.1;
				edge.setPheromone(pheromone);
			}
		}
	}

	/* ######################################################################## */
	/* ########################	     Construction      ######################## */
	/* ######################################################################## */
	
	/** Construction */
	private void construction(){
		for(Ant ant : this.ants){
			Edge nextEdge = chooseNextNode(ant);
			Node node = nextEdge.getEnd();
			
			while(node != null){
				ant.setActualNode(node);
				ant.getTabuList().add(node);
				ant.getEdgeList().add(nextEdge);
				
				nextEdge = chooseNextNode(ant);
				if(nextEdge != null){
					node = nextEdge.getEnd();
				}else{
					node = null;
				}
			}
		}
	}
	
	/** Choose Next Node */
	@SuppressWarnings("unchecked")
	private Edge chooseNextNode(Ant ant) {
		/* TSP restriction */
		if(ant.getTabuList().size() == this.nodeCount){
			return null;
		}
		
		LinkedList<Edge> edges = (LinkedList<Edge>) ant.getActualNode().getAdjacentEdges().clone();
		Iterator<Edge> iterator = edges.iterator();
		/* Try remove loops */
		while(iterator.hasNext()){
			Edge e = iterator.next();
			if((ant.getTabuList().contains(e.getBegin()) && ant.getTabuList().contains(e.getEnd()))){
				iterator.remove();
				continue;
			}
			if(!e.getBegin().equals(ant.getActualNode())){
				iterator.remove();
				continue;
			}
		}
		
		if(edges.isEmpty()){
			return null;
		}
		
		/* Calculando o acumulado da formula de probabilidade */
		List<Auxiliar> values = new LinkedList<Auxiliar>();
		double amount = 0L;
		for(Edge e : edges){
			amount += Math.pow(e.getPheromone(), this.configuration.getAlpha()) * Math.pow(getHeuristicValue(e), this.configuration.getBeta());
		}
		
		/* Valores individuais da formula */
		double sum = 0L;
		for(Edge e : edges){
			double pheromoneNode = Math.pow(e.getPheromone(), this.configuration.getAlpha());
			double heuristic = Math.pow(getHeuristicValue(e), this.configuration.getBeta());
			
			/* */
			values.add(new Auxiliar(e.getEnd(), e, ((pheromoneNode * heuristic)/amount)));
			sum += ((pheromoneNode * heuristic)/amount);
		}
		
		/* Ordenando os valores */
		Collections.sort(values, new Comparator<Auxiliar>() {
			@Override
			public int compare(Auxiliar o1, Auxiliar o2) {
				return o1.getProbabilidade().compareTo(o2.getProbabilidade());
			}
		});
		
		/* Aqui estou normalizando os valores. Agora a soma de todos é igual a 1. 
		 * Depois eu crio a lista com os valores acumulados. */
		int count = 0;
		for(Auxiliar d : values){
			d.setProbabilidade(d.getProbabilidade()/sum);
			if(count > 0){
				d.setProbabilidade(values.get(count-1).getProbabilidade() + d.getProbabilidade());
			}
			count++;
		}
		
		/* Valor randomico escolhido */
		double randomValue = random.nextDouble();
		for(Auxiliar d : values){
			if(randomValue <= d.getProbabilidade().doubleValue()){
				return d.getAresta();
			}
		}
		
		return null;
	}


	/* ######################################################################## */
	/* ########################	     Evaporation       ######################## */
	/* ######################################################################## */
	

	/** Evaporation */
	private void makeEvaporation(){
		for(Edge e : this.graph.getEdges()){
			e.setPheromone((1 - this.configuration.getPheromonePersistence()) * e.getPheromone());
		}
	}
	
	/* ######################################################################## */
	/* ########################	     Actualization     ######################## */
	/* ######################################################################## */
	
	/** Actualization */
	private void makeActualization(){
		for(Ant ant : this.ants){
			for(Edge e : ant.getEdgeList()){
				e.setPheromone(e.getPheromone() + this.configuration.getQ()/calcQualityOfResult(ant));
				//e.setPheromone(e.getPheromone() + 1/calcQualityOfResult(ant));
			}
		}
	}
	
	/* ######################################################################## */
	/* ########################	       Heuristic  	   ######################## */
	/* ######################################################################## */
	
	/** Get Heuristic Value */
	private double getHeuristicValue(Edge edge) {
		return 1/edge.getDistance();
	}
	
	/* ######################################################################## */
	/* ##################        Quality of Result  	   #################### */
	/* ######################################################################## */
	
	/** Calc Quality of Result */
	private double calcQualityOfResult(Ant ant) {
		double quality = 0.0;
		/*for(Node node : ant.getTabuList()){
			quality += (Double) node.getInformations().get("distance");
		}*/
		for(Edge edge : ant.getEdgeList()){
			quality += edge.getDistance();
		}
		return quality;
	}
	
	/* ######################################################################## */
	/* ########################	       Solutions       ######################## */
	/* ######################################################################## */
	
	/**
	 * @param solutions
	 * @return
	 */
	private Solution findTheBest(List<Solution> solutions) {
		double best = Double.MAX_VALUE;
		Solution bestSolution = null;
		for (Solution solution : solutions) {
			if(solution.getCost() < best){
				best = solution.getCost();
				bestSolution = solution;
			}
		}
		return bestSolution;
	}

	/**
	 * @param itSolutions
	 * @return
	 */
	private IterationSolution findTheBest(LinkedList<IterationSolution> itSolutions) {
		double best = Double.MAX_VALUE;
		IterationSolution bestSolution = null;
		for (IterationSolution iterationSolution : itSolutions) {
			if(iterationSolution.getBetterSolution() < best){
				best = iterationSolution.getBetterSolution();
				bestSolution = iterationSolution;
			}
		}
		return bestSolution;
	}

	/**
	 * @param iteration
	 * @return
	 */
	private IterationSolution getBetterResultAndResetSystem(int iteration){
		double betterSolution = Double.MAX_VALUE;
		double worstSolution = Double.MIN_VALUE;
		
		double average = 0.0;
		double standardDeviation = 0.0;
		
		double somaSolucoesIteracao = 0.0;
		double somaSolucoesAoQuadradoIteracao = 0.0;
		
		double distance = 0.0;
		Ant theBestAnt = null;
		
		for(Ant ant : this.getAnts()){
			double distanceAux = this.calcQualityOfResult(ant);
			
			if(distanceAux < betterSolution){
				betterSolution = distanceAux;
				distance = distanceAux;
				theBestAnt = ant.clone();
			}
			
			if(distanceAux > worstSolution){
				worstSolution = distanceAux;
			}
			
			somaSolucoesIteracao += distanceAux;
			somaSolucoesAoQuadradoIteracao += Math.pow(distanceAux, 2);
			/* Reset Ant */
			ant.reset();
		}
		
		average = somaSolucoesIteracao/this.getAnts().size();
		double variancia = (somaSolucoesAoQuadradoIteracao/this.getAnts().size()) - Math.pow(average, 2);
		standardDeviation = Math.sqrt(variancia);
		
		IterationSolution iterationSolution = new IterationSolution(iteration, betterSolution, worstSolution, average, standardDeviation, theBestAnt);
		iterationSolution.setDistance(distance);
		
		if(iterationSolution.getBetterSolution() < this.theBest){
			iterationSolution.setTheBest(iterationSolution.getBetterSolution());
			this.setTheBest(iterationSolution.getBetterSolution());
			this.setTheBestAnt(iterationSolution.getTheBestAnt());
		}else{
			iterationSolution.setTheBest(this.theBest);
			iterationSolution.setTheBestAnt(this.theBestAnt);
		}
		
		return iterationSolution;
	}
	
	/* ######################################################################## */
	/* ########################	         Bean	   	   ######################## */
	/* ######################################################################## */

	/**
	 * @return the graph
	 */
	public Graph getGraph() {
		return graph;
	}

	/**
	 * @param graph the graph to set
	 */
	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	/**
	 * @return the random
	 */
	public Random getRandom() {
		return random;
	}

	/**
	 * @param random the random to set
	 */
	public void setRandom(Random random) {
		this.random = random;
	}

	/**
	 * @return the ants
	 */
	public List<Ant> getAnts() {
		return ants;
	}

	/**
	 * @param ants the ants to set
	 */
	public void setAnts(List<Ant> ants) {
		this.ants = ants;
	}

	/**
	 * Classe auxiliar
	 * 
	 * @author Pedro Almir
	 */
	class Auxiliar{
		private Node no;
		private Edge aresta;
		private Double probabilidade;
		
		/**
		 * @param no
		 * @param probabilidade
		 */
		public Auxiliar(Node no, Edge aresta, Double probabilidade) {
			super();
			this.no = no;
			this.aresta = aresta;
			this.probabilidade = probabilidade;
		}
		/**
		 * @return the no
		 */
		public Node getNo() {
			return no;
		}
		/**
		 * @param no the no to set
		 */
		public void setNo(Node no) {
			this.no = no;
		}
		/**
		 * @return the probabilidade
		 */
		public Double getProbabilidade() {
			return probabilidade;
		}
		/**
		 * @param probabilidade the probabilidade to set
		 */
		public void setProbabilidade(Double probabilidade) {
			this.probabilidade = probabilidade;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Auxiliar [probabilidade=" + probabilidade + "]";
		}
		/**
		 * @return the aresta
		 */
		public Edge getAresta() {
			return aresta;
		}
		/**
		 * @param aresta the aresta to set
		 */
		public void setAresta(Edge aresta) {
			this.aresta = aresta;
		}
	}

	/**
	 * @return the solution
	 */
	public Solution getSolution() {
		return solution;
	}

	/**
	 * @param solution the solution to set
	 */
	public void setSolution(Solution solution) {
		this.solution = solution;
	}

	/**
	 * @return the theBest
	 */
	public double getTheBest() {
		return theBest;
	}

	/**
	 * @param theBest the theBest to set
	 */
	public void setTheBest(double theBest) {
		this.theBest = theBest;
	}

	/**
	 * @return the theBestAnt
	 */
	public Ant getTheBestAnt() {
		return theBestAnt;
	}

	/**
	 * @param theBestAnt the theBestAnt to set
	 */
	public void setTheBestAnt(Ant theBestAnt) {
		this.theBestAnt = theBestAnt;
	}
}
