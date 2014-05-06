/**
 * 
 */
package com.pedroalmir.model.problem;

import java.util.List;

import com.pedroalmir.model.graph.Graph;
import com.pedroalmir.model.graph.Node;

/**
 * Essa classe representa um problema de priorização de casos de teste,
 * mas pode ser reutilizada para outros problemas.
 * 
 * @author Pedro Almir
 *
 */
public class Problem {
	
	/** Número de formigas */
	private int numberAnt;
	/** Quantidade máxima de ferômonio (0, 0.1) */
	private double t0;
	/** Constante que amplifica a influência da concentração de feromonio */
	private double alfa;
	/** Constante que amplifica a influência da heurística */
	private double beta;
	/** Valor utilizado no calculo da probabilidade de escolha para o próximo vertice.
	 * No trabalho do Jonathas foi utilizado vários valores para essa constante afim de comparação quanto aos resultados obtidos.
	 * O professor Ricardo Lira sugeriu utilizar o maior valor da heuristica, dessa forma a probabilidade ficaria normalizada. */
	private double q;
	/** Número máximo de iterações */
	private int maxIterations;
	/** Número máximo de execuções */
	private int maxExecution;
	/** Taxa de Evaporação */
	private double p;
	/** Usa-se um q0 para fazer a escolha do proximo vertice (na construção do caminho) 
	 * de forma pseudo aleatória quando se usa Ant Colony System, no caso esta modelado 
	 * como um Ant System (AS). */
	private double q0;
	/** Indice utilizado para armazenar as soluções em um vetor, isso para cada execução. 
	 * TODO: Remover isso!! */
	private int k;
	/** Para problemas da mochila, esse valor guarda a capacidade máxima da mochila. */
	private double bound;
	/** Define se é um problema da mochila. Isso implica na escolha do possíveis nós. */
	private boolean knapsackProblem;
	/** Gráfico que representa o problema */
	private Graph graph;
	/** Begin nodes */
	private List<Node> beginNodes;
	/** Final nodes */
	private List<Node> finalNodes;
	
	/**
	 * 
	 */
	public Problem() {
		
	}
	
	
	/**
	 * @param numberAnt
	 * @param t0
	 * @param alfa
	 * @param beta
	 * @param q
	 * @param maxIterations
	 * @param maxExecution
	 * @param p
	 * @param q0
	 * @param graph
	 * @param beginNodes
	 * @param finalNodes
	 */
	public Problem(int numberAnt, double t0, double alfa, double beta, double q, int maxIterations, int maxExecution, double p,
			double q0) {
		super();
		this.numberAnt = numberAnt;
		this.t0 = t0;
		this.alfa = alfa;
		this.beta = beta;
		this.q = q;
		this.maxIterations = maxIterations;
		this.maxExecution = maxExecution;
		this.p = p;
		this.q0 = q0;
	}



	/**
	 * @param numberAnt
	 * @param t0
	 * @param alfa
	 * @param beta
	 * @param q
	 * @param maxIterations
	 * @param maxExecution
	 * @param p1
	 * @param q0
	 * @param cargaMaxima
	 */
	public Problem(int numberAnt, double t0, double alfa, double beta, double q, int maxIterations, int maxExecution, double p,
			double q0, double cargaMaxima) {
		super();
		this.numberAnt = numberAnt;
		this.t0 = t0;
		this.alfa = alfa;
		this.beta = beta;
		this.q = q;
		this.maxIterations = maxIterations;
		this.maxExecution = maxExecution;
		this.p = p;
		this.q0 = q0;
		this.k = 0;
		this.bound = cargaMaxima;
	}



	/**
	 * @return the numberAnt
	 */
	public int getNumberAnt() {
		return numberAnt;
	}
	/**
	 * @param numberAnt the numberAnt to set
	 */
	public void setNumberAnt(int numberAnt) {
		this.numberAnt = numberAnt;
	}
	/**
	 * @return the t0
	 */
	public double getT0() {
		return t0;
	}
	/**
	 * @param t0 the t0 to set
	 */
	public void setT0(double t0) {
		this.t0 = t0;
	}
	/**
	 * @return the alfa
	 */
	public double getAlfa() {
		return alfa;
	}
	/**
	 * @param alfa the alfa to set
	 */
	public void setAlfa(double alfa) {
		this.alfa = alfa;
	}
	/**
	 * @return the beta
	 */
	public double getBeta() {
		return beta;
	}
	/**
	 * @param beta the beta to set
	 */
	public void setBeta(double beta) {
		this.beta = beta;
	}
	/**
	 * @return the q
	 */
	public double getQ() {
		return q;
	}
	/**
	 * @param q the q to set
	 */
	public void setQ(double q) {
		this.q = q;
	}
	/**
	 * @return the maxIterations
	 */
	public int getMaxIterations() {
		return maxIterations;
	}
	/**
	 * @param maxIterations the maxIterations to set
	 */
	public void setMaxIterations(int maxIterations) {
		this.maxIterations = maxIterations;
	}
	/**
	 * @return the maxExecution
	 */
	public int getMaxExecution() {
		return maxExecution;
	}
	/**
	 * @param maxExecution the maxExecution to set
	 */
	public void setMaxExecution(int maxExecution) {
		this.maxExecution = maxExecution;
	}
	/**
	 * @return the q0
	 */
	public double getQ0() {
		return q0;
	}
	/**
	 * @param q0 the q0 to set
	 */
	public void setQ0(double q0) {
		this.q0 = q0;
	}
	/**
	 * @return the k
	 */
	public int getK() {
		return k;
	}
	/**
	 * @param k the k to set
	 */
	public void setK(int k) {
		this.k = k;
	}

	/**
	 * @return the bound
	 */
	public double getBound() {
		return bound;
	}

	/**
	 * @param bound the bound to set
	 */
	public void setBound(double bound) {
		this.bound = bound;
	}

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
	 * @return the p
	 */
	public double getP() {
		return p;
	}

	/**
	 * @param p the p to set
	 */
	public void setP(double p) {
		this.p = p;
	}

	/**
	 * @return the knapsackProblem
	 */
	public boolean isKnapsackProblem() {
		return knapsackProblem;
	}

	/**
	 * @param knapsackProblem the knapsackProblem to set
	 */
	public void setKnapsackProblem(boolean knapsackProblem) {
		this.knapsackProblem = knapsackProblem;
	}

	/**
	 * @return the finalNodes
	 */
	public List<Node> getFinalNodes() {
		return finalNodes;
	}

	/**
	 * @param finalNodes the finalNodes to set
	 */
	public void setFinalNodes(List<Node> finalNodes) {
		this.finalNodes = finalNodes;
	}

	/**
	 * @return the beginNodes
	 */
	public List<Node> getBeginNodes() {
		return beginNodes;
	}

	/**
	 * @param beginNodes the beginNodes to set
	 */
	public void setBeginNodes(List<Node> beginNodes) {
		this.beginNodes = beginNodes;
	}
}
