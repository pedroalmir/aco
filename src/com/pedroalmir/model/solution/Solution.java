/**
 * 
 */
package com.pedroalmir.model.solution;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import au.com.bytecode.opencsv.CSVWriter;

import com.pedroalmir.model.Ant;
import com.pedroalmir.model.graph.Node;
import com.pedroalmir.model.problem.AntConfiguration;

/**
 * @author Pedro Almir
 *
 */
public class Solution implements Comparable<Solution>{
	
	private String algorithm;
	
	private Ant theBestAnt;
	private double cost;
	
	private long executionTime;
	private AntConfiguration antConfiguration;
	
	private List<IterationSolution> iterationSolutions;
	
	/**
	 * @param betterTestCases
	 * @param capacidade
	 * @param numberOfClasses
	 * @param numberOfRequirements
	 * @param numberOfTests
	 * @param timeOfTests
	 * @param criticality
	 * @param executionTime
	 */
	public Solution(String algorithm, AntConfiguration antConfiguration, double cost, long executionTime) {
		super();
		this.algorithm = algorithm;
		this.antConfiguration = antConfiguration;
		this.cost = cost;
		this.executionTime = executionTime;
		this.iterationSolutions = new LinkedList<IterationSolution>();
	}
	
	/**
	 * 
	 */
	public Solution() {
		this.iterationSolutions = new LinkedList<IterationSolution>();
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Analise do Comportamento do Algoritmo: " + this.algorithm + "\n");
		buffer.append("Nós selecionados: " + this.printPath(this.theBestAnt) + "\n");
		buffer.append("Custo Total: " + String.format("%.4f", this.cost));
		return buffer.toString();
	}
	
	/**
	 * Print this in CSV File
	 * @param csvFile
	 */
	public void printThis(String csvFile){
        try {
        	//List<String[]> data = new ArrayList<String[]>();
			CSVWriter writer = new CSVWriter(new FileWriter(csvFile), ';');
			
			String[] emptyLine = new String[]{""};
			/* Default */
			writer.writeNext(new String[]{"Analise do Comportamento do Algoritmo: " + this.algorithm});
			writer.writeNext(emptyLine);
			
			if(this.antConfiguration != null){
				writer.writeNext(new String[]{"Numero de Formigas", this.antConfiguration.getNumAgents() + "", "Q", String.format("%.4f", this.antConfiguration.getQ()) + ""});
				writer.writeNext(new String[]{"Alfa", String.format("%.2f", this.antConfiguration.getAlpha()) + "", "Beta", String.format("%.2f", this.antConfiguration.getBeta()) + ""});
				writer.writeNext(new String[]{"Quantidade Inicial de Feromonio", String.format("%.2f", this.antConfiguration.getInitialPheromone()) + "", "Taxa de Evaporacao", String.format("%.2f", this.antConfiguration.getPheromonePersistence()) + ""});
				writer.writeNext(new String[]{"Maximo de Iteracoes", this.antConfiguration.getMaxIterations() + "", "Maximo de Execucoes", this.antConfiguration.getMaxExecutions() + ""});
				writer.writeNext(emptyLine);
				writer.writeNext(new String[]{"Nos Selecionados", this.printPath(this.theBestAnt) + "", "Tempo de Execucao", "[" + new SimpleDateFormat("mm:ss:SSS").format(this.executionTime) + "]"});
				writer.writeNext(new String[]{"Custo Total", String.format("%.4f", this.cost) + "", "Tempo de Execucao (ms)", this.executionTime + ""});
				
				writer.writeNext(emptyLine);
				
				int count = 1;
				String[] header = new String[this.iterationSolutions.size()+1];
				String[] betterSolution = new String[this.iterationSolutions.size()+1];
				String[] worstSolution = new String[this.iterationSolutions.size()+1];
				String[] average = new String[this.iterationSolutions.size()+1];
				String[] standardDeviation = new String[this.iterationSolutions.size()+1];
				String[] elitism = new String[this.iterationSolutions.size()+1];
				//String[] distance = new String[this.iterationSolutions.size()+1];
				
				header[0] 			 = "";
				betterSolution[0] 	 = "BetterSolution";
				worstSolution[0] 	 = "WorstSolution";
				average[0] 			 = "Average";
				standardDeviation[0] = "StandardDeviation";
				elitism[0] 			 = "Elitism";
				//distance[0] 		 = "Distance";
				

				for(IterationSolution it : this.iterationSolutions){
					header[count] 			 = "Iteracao " + count;
					betterSolution[count] 	 = "" + String.format("%.4f", it.getBetterSolution());
					worstSolution[count] 	 = "" + String.format("%.4f", it.getWorstSolution());
					average[count] 			 = "" + String.format("%.4f", it.getAverage());
					standardDeviation[count] = "" + String.format("%.4f", it.getStandardDeviation());
					elitism[count] 			 = "" + String.format("%.4f", it.getTheBest());
					
					//distance[count] 		 = "" + String.format("%.4f", it.getDistance());
					count++;
				}
				
				writer.writeNext(header);
				writer.writeNext(betterSolution);
				writer.writeNext(worstSolution);
				writer.writeNext(average);
				writer.writeNext(standardDeviation);
				writer.writeNext(elitism);
				
				//writer.writeNext(emptyLine);
				//writer.writeNext(distance);
			}
	        writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @param theBestAnt
	 * @return
	 */
	private String printPath(Ant theBestAnt) {
		ArrayList<String> path = new ArrayList<String>();
		for(Node node : theBestAnt.getTabuList()){
			path.add(node.getInformations().get("id").toString());
		}
		return Arrays.toString(path.toArray());
	}

	/**
	 * @return the executionTime
	 */
	public long getExecutionTime() {
		return executionTime;
	}
	/**
	 * @param executionTime the executionTime to set
	 */
	public void setExecutionTime(long executionTime) {
		this.executionTime = executionTime;
	}
	
	/**
	 * @return the algorithm
	 */
	public String getAlgorithm() {
		return algorithm;
	}

	/**
	 * @param algorithm the algorithm to set
	 */
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	/**
	 * @return the iterationSolutions
	 */
	public List<IterationSolution> getIterationSolutions() {
		return iterationSolutions;
	}

	/**
	 * @param iterationSolutions the iterationSolutions to set
	 */
	public void setIterationSolutions(List<IterationSolution> iterationSolutions) {
		this.iterationSolutions = iterationSolutions;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public int compareTo(Solution o) {
		return new Double(o.getCost()).compareTo(new Double(this.cost));
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

