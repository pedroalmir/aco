package com.pedroalmir.controller;

import java.util.ArrayList;
import java.util.LinkedList;

import com.pedroalmir.model.enums.StrategyAS;
import com.pedroalmir.model.graph.Edge;
import com.pedroalmir.model.graph.Graph;
import com.pedroalmir.model.graph.Node;
import com.pedroalmir.model.problem.AntConfiguration;

/**
 * @author Pedro Almir
 *
 */
public class DataFactory {
	
	/**
	 * Create the list of configurations to apply in question one
	 * @return list of configurations
	 */
	public static ArrayList<AntConfiguration> createConfigurationsOfQuestionOne(){
		ArrayList<AntConfiguration> configs = new ArrayList<AntConfiguration>();
		/* ALPHA - BETA - Q - Pheromone Persistence - Initial Pheromone Trails - Number of Ants - Iterations - Executions - Strategy */
		/* Situation I */
		configs.add(new AntConfiguration("Ant System - Cycle - I", 1.0, 1.0, 1.0, 0.5, 0.1, 3, 10, 10, StrategyAS.ANT_CYCLE));
		configs.add(new AntConfiguration("Ant System - Density - I", 1.0, 1.0, 1.0, 0.5, 0.1, 3, 10, 10, StrategyAS.ANT_DENSITY));
		configs.add(new AntConfiguration("Ant System - Quantity - I", 1.0, 1.0, 1.0, 0.5, 0.1, 3, 10, 10, StrategyAS.ANT_QUANTITY));
		/* Situation II */
		configs.add(new AntConfiguration("Ant System - Cycle - II", 1.0, 1.0, 1.0, 0.5, 0.1, 10, 10, 10, StrategyAS.ANT_CYCLE));
		configs.add(new AntConfiguration("Ant System - Density - II", 1.0, 1.0, 1.0, 0.5, 0.1, 10, 10, 10, StrategyAS.ANT_DENSITY));
		configs.add(new AntConfiguration("Ant System - Quantity - II", 1.0, 1.0, 1.0, 0.5, 0.1, 10, 10, 10, StrategyAS.ANT_QUANTITY));
		/* Situation III */
		configs.add(new AntConfiguration("Ant System - Cycle - III", 1.0, 1.0, 1.0, 0.5, 0.1, 30, 10, 10, StrategyAS.ANT_CYCLE));
		configs.add(new AntConfiguration("Ant System - Density - III", 1.0, 1.0, 1.0, 0.5, 0.1, 30, 10, 10, StrategyAS.ANT_DENSITY));
		configs.add(new AntConfiguration("Ant System - Quantity - III", 1.0, 1.0, 1.0, 0.5, 0.1, 30, 10, 10, StrategyAS.ANT_QUANTITY));
		/* Situation IV */
		configs.add(new AntConfiguration("Ant System - Cycle - IV", 1.0, 1.0, 1.0, 0.5, 0.1, 3, 50, 10, StrategyAS.ANT_CYCLE));
		configs.add(new AntConfiguration("Ant System - Density - IV", 1.0, 1.0, 1.0, 0.5, 0.1, 3, 50, 10, StrategyAS.ANT_DENSITY));
		configs.add(new AntConfiguration("Ant System - Quantity - IV", 1.0, 1.0, 1.0, 0.5, 0.1, 3, 50, 10, StrategyAS.ANT_QUANTITY));
		/* Situation V */
		configs.add(new AntConfiguration("Ant System - Cycle - V", 1.0, 1.0, 1.0, 0.5, 0.1, 10, 50, 10, StrategyAS.ANT_CYCLE));
		configs.add(new AntConfiguration("Ant System - Density - V", 1.0, 1.0, 1.0, 0.5, 0.1, 10, 50, 10, StrategyAS.ANT_DENSITY));
		configs.add(new AntConfiguration("Ant System - Quantity - V", 1.0, 1.0, 1.0, 0.5, 0.1, 10, 50, 10, StrategyAS.ANT_QUANTITY));
		/* Situation VI */
		configs.add(new AntConfiguration("Ant System - Cycle - VI", 1.0, 1.0, 1.0, 0.5, 0.1, 30, 50, 10, StrategyAS.ANT_CYCLE));
		configs.add(new AntConfiguration("Ant System - Density - VI", 1.0, 1.0, 1.0, 0.5, 0.1, 30, 50, 10, StrategyAS.ANT_DENSITY));
		configs.add(new AntConfiguration("Ant System - Quantity - VI", 1.0, 1.0, 1.0, 0.5, 0.1, 30, 50, 10, StrategyAS.ANT_QUANTITY));
		/* Situation VII */
		configs.add(new AntConfiguration("Ant System - Cycle - VII", 1.0, 2.0, 1.0, 0.5, 0.1, 3, 10, 10, StrategyAS.ANT_CYCLE));
		configs.add(new AntConfiguration("Ant System - Density - VII", 1.0, 2.0, 1.0, 0.5, 0.1, 3, 10, 10, StrategyAS.ANT_DENSITY));
		configs.add(new AntConfiguration("Ant System - Quantity - VII", 1.0, 2.0, 1.0, 0.5, 0.1, 3, 10, 10, StrategyAS.ANT_QUANTITY));
		/* Situation VIII */
		configs.add(new AntConfiguration("Ant System - Cycle - VIII", 1.0, 2.0, 1.0, 0.5, 0.1, 10, 10, 10, StrategyAS.ANT_CYCLE));
		configs.add(new AntConfiguration("Ant System - Density - VIII", 1.0, 2.0, 1.0, 0.5, 0.1, 10, 10, 10, StrategyAS.ANT_DENSITY));
		configs.add(new AntConfiguration("Ant System - Quantity - VIII", 1.0, 2.0, 1.0, 0.5, 0.1, 10, 10, 10, StrategyAS.ANT_QUANTITY));
		/* Situation IX */
		configs.add(new AntConfiguration("Ant System - Cycle - IX", 1.0, 2.0, 1.0, 0.5, 0.1, 30, 10, 10, StrategyAS.ANT_CYCLE));
		configs.add(new AntConfiguration("Ant System - Density - IX", 1.0, 2.0, 1.0, 0.5, 0.1, 30, 10, 10, StrategyAS.ANT_DENSITY));
		configs.add(new AntConfiguration("Ant System - Quantity - IX", 1.0, 2.0, 1.0, 0.5, 0.1, 30, 10, 10, StrategyAS.ANT_QUANTITY));
		/* Situation X */
		configs.add(new AntConfiguration("Ant System - Cycle - X", 1.0, 2.0, 1.0, 0.5, 0.1, 3, 50, 10, StrategyAS.ANT_CYCLE));
		configs.add(new AntConfiguration("Ant System - Density - X", 1.0, 2.0, 1.0, 0.5, 0.1, 3, 50, 10, StrategyAS.ANT_DENSITY));
		configs.add(new AntConfiguration("Ant System - Quantity - X", 1.0, 2.0, 1.0, 0.5, 0.1, 3, 50, 10, StrategyAS.ANT_QUANTITY));
		/* Situation XI */
		configs.add(new AntConfiguration("Ant System - Cycle - XI", 1.0, 2.0, 1.0, 0.5, 0.1, 10, 50, 10, StrategyAS.ANT_CYCLE));
		configs.add(new AntConfiguration("Ant System - Density - XI", 1.0, 2.0, 1.0, 0.5, 0.1, 10, 50, 10, StrategyAS.ANT_DENSITY));
		configs.add(new AntConfiguration("Ant System - Quantity - XI", 1.0, 2.0, 1.0, 0.5, 0.1, 10, 50, 10, StrategyAS.ANT_QUANTITY));
		/* Situation XII */
		configs.add(new AntConfiguration("Ant System - Cycle - XII", 1.0, 2.0, 1.0, 0.5, 0.1, 30, 50, 10, StrategyAS.ANT_CYCLE));
		configs.add(new AntConfiguration("Ant System - Density - XII", 1.0, 2.0, 1.0, 0.5, 0.1, 30, 50, 10, StrategyAS.ANT_DENSITY));
		configs.add(new AntConfiguration("Ant System - Quantity - XII", 1.0, 2.0, 1.0, 0.5, 0.1, 30, 50, 10, StrategyAS.ANT_CYCLE));
		return configs;
	}
	
	/**
	 * Create the list of configurations to apply in question two
	 * @return list of configurations
	 */
	public static ArrayList<AntConfiguration> createConfigurationsOfQuestionTwo(){
		ArrayList<AntConfiguration> configs = new ArrayList<AntConfiguration>();
		configs.add(new AntConfiguration("Ant System - Cycle", 1.0, 1.0, 1.0, 0.5, 0.1, 3, 10, 10, StrategyAS.ANT_CYCLE));
		return configs;
	}
	
	/**
	 * Create the list of configurations to apply in question three
	 * @return list of configurations
	 */
	public static ArrayList<AntConfiguration> createConfigurationsOfQuestionThree(){
		ArrayList<AntConfiguration> configs = new ArrayList<AntConfiguration>();
		configs.add(new AntConfiguration("Ant System - Cycle", 1.0, 2.0, 1.0, 0.5, 0.1, 30, 10, 10, StrategyAS.ANT_CYCLE));
		return configs;
	}
	
	/**
	 * Create graph of Question one
	 * @return the graph
	 */
	public static Graph createGraphOfQuestionOne(){
		/* Nodes */
		LinkedList<Node> nodes = new LinkedList<Node>();
		nodes.add(new Node(1l, "C1")); nodes.add(new Node(2l, "C2")); nodes.add(new Node(3l, "C3")); 
		nodes.add(new Node(4l, "C4")); nodes.add(new Node(5l, "C5")); nodes.add(new Node(6l, "C6"));
		
		double[][] matrix = new double[][]{
				{0, 7, 4, 3, 11, 1},
				{7, 0, 2, 8, 10, 8},
				{4, 2, 0, 9, 9, 3},
				{3, 8, 9, 0, 5, 4},
				{11, 10, 9, 5, 0, 3},
				{1, 8, 3, 4, 3, 0}};
		
		LinkedList<Edge> edges = new LinkedList<Edge>();
		long globalCount = 1;
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				if(i != j && matrix[i][j] != 0){
					edges.add(new Edge(globalCount++, nodes.get(i), nodes.get(j), matrix[i][j]));
					edges.add(new Edge(globalCount++, nodes.get(j), nodes.get(i), matrix[i][j]));
				}
			}
		}
		return new Graph(1l, "Question One", nodes, edges);
	}
	
	/**
	 * Create graph of Question two
	 * @return the graph
	 */
	public static Graph createGraphOfQuestionTwo(){
		/* Nodes */
		LinkedList<Node> nodes = new LinkedList<Node>();
		nodes.add(new Node(1l, "C1")); nodes.add(new Node(2l, "C2")); nodes.add(new Node(3l, "C3")); 
		nodes.add(new Node(4l, "C4")); nodes.add(new Node(5l, "C5")); nodes.add(new Node(6l, "C6"));
		nodes.add(new Node(7l, "C7")); nodes.add(new Node(8l, "C8")); nodes.add(new Node(9l, "C9")); 
		nodes.add(new Node(10l, "C10"));
		
		double[][] matrix = new double[][]{
				{0, 30, 84, 56, 0, 70, 0, 75, 0, 80}, 
				{30, 0, 65, 0, 0, 0, 70, 0, 0, 40},
				{84, 65, 0, 74, 52, 55, 0, 135, 143, 48}, 
				{56, 0, 74, 0, 135, 0, 0, 20, 0, 0}, 
				{0, 0, 52, 135, 0, 70, 0, 122, 98, 80}, 
				{70, 0, 55, 0, 70, 0, 63, 0, 82, 35}, 
				{0, 70, 0, 0, 0, 63, 0, 0, 120, 57}, 
				{75, 0, 135, 20, 122, 0, 0, 0, 0, 0}, 
				{0, 0, 143, 0, 98, 82, 120, 0, 0, 0}, 
				{80, 40, 48, 0, 80, 35, 57, 0, 0, 0}};
		
		LinkedList<Edge> edges = new LinkedList<Edge>();
		long globalCount = 1;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(i != j && matrix[i][j] != 0){
					edges.add(new Edge(globalCount++, nodes.get(i), nodes.get(j), matrix[i][j]));
					edges.add(new Edge(globalCount++, nodes.get(j), nodes.get(i), matrix[i][j]));
				}
			}
		}
		return new Graph(2l, "Question Two", nodes, edges);
	}
	
	/**
	 * @return
	 */
	public static Graph createGraphOfQuestionThree(){
		/* Nodes */
		LinkedList<Node> nodes = new LinkedList<Node>();
		nodes.add(new Node(1l, "C1")); nodes.add(new Node(2l, "C2")); nodes.add(new Node(3l, "C3")); 
		nodes.add(new Node(4l, "C4")); nodes.add(new Node(5l, "C5")); nodes.add(new Node(6l, "C6"));
		nodes.add(new Node(7l, "C7")); nodes.add(new Node(8l, "C8")); nodes.add(new Node(9l, "C9")); 
		nodes.add(new Node(10l, "C10")); nodes.add(new Node(11l, "C11")); nodes.add(new Node(12l, "C12"));
		nodes.add(new Node(13l, "C13")); nodes.add(new Node(14l, "C14"));
		
		double[][] matrix = new double[][]{
				{0, 11, 20, 27, 40, 43, 39, 28, 18, 10, 18, 30, 30, 32}, 
				{11, 0, 9, 16, 29, 32, 28, 19, 11, 4, 17, 23, 21, 24}, 
				{20, 9, 0, 7, 20, 22, 19, 15, 10, 11, 21, 21, 13, 18}, 
				{27, 16, 7, 0, 13, 16, 12, 13, 13, 18, 26, 21, 11, 17}, 
				{40, 29, 20, 13, 0, 3, 2, 21, 25, 31, 38, 27, 16, 20}, 
				{43, 32, 22, 16, 3, 0, 4, 23, 28, 33, 41, 30, 17, 20}, 
				{39, 28, 19, 12, 2, 4, 0, 22, 25, 29, 38, 28, 13, 17}, 
				{28, 19, 15, 13, 21, 23, 22, 0, 9, 22, 18, 7, 25, 30}, 
				{18, 11, 10, 13, 25, 28, 25, 9, 0, 13, 12, 12, 23, 28}, 
				{10, 4, 11, 18, 31, 33, 29, 22, 13, 0, 20, 27, 20, 23}, 
				{18, 17, 21, 26, 38, 41, 38, 18, 12, 20, 0, 15, 35, 39}, 
				{30, 23, 21, 21, 27, 30, 28, 7, 12, 27, 15, 0, 31, 37}, 
				{30, 21, 13, 11, 16, 17, 13, 25, 23, 20, 35, 31, 0, 5},
				{32, 24, 18, 17, 20, 20, 17, 30, 28, 23, 39, 37, 5, 0}};
		
		LinkedList<Edge> edges = new LinkedList<Edge>();
		long globalCount = 1;
		for(int i = 0; i < 14; i++){
			for(int j = 0; j < 14; j++){
				if(i != j && matrix[i][j] != 0){
					edges.add(new Edge(globalCount++, nodes.get(i), nodes.get(j), matrix[i][j]));
					edges.add(new Edge(globalCount++, nodes.get(j), nodes.get(i), matrix[i][j]));
				}
			}
		}
		return new Graph(3l, "Question Three", nodes, edges);
	}
}
