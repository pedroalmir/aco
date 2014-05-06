package com.pedroalmir.controller;

import java.util.LinkedList;

import com.pedroalmir.model.graph.Edge;
import com.pedroalmir.model.graph.Graph;
import com.pedroalmir.model.graph.Node;
import com.pedroalmir.model.problem.AntConfiguration;
import com.pedroalmir.model.solution.Solution;

/**
 * @author Pedro Almir
 *
 */
public class Main {
	/** Exponent for the pheromone vales. */
	public static final double ALPHA = 1.0d;
	/** Exponent for the inverse route values. */
	public static final double BETA = 2.0d;
	/**
	 * Used for the calculation of the pheromone trail value 
	 * in correlation to the cost/distance of the edge.
	 * Must be between 0 and 1
	 */
	public static final double Q = 1.0d; 
	/** 
	 * The persistence (percentaged) the pheromone trails stay after each step. 
	 * Must be between 0 and 1.
	 * */
	public static final double PHEROMONE_TRAIL_PERSISTENCE = 0.3d;
	/** The initial values of the pheromone trails. */
	public static final double INITIAL_PHEROMONE_TRAILS = 0.1d;
	/** The number of ants used. */
	public static final int NUM_ANTS = 30;
	public static final int MAX_ITERATIONS = 50;
	/** Result folder */
	public static final String RESULT_FOLDER = "C:/workspace/aco/results/";
	
	public static void main(String[] args) {
		Graph graph = questionOne();
		AntConfiguration configuration = new AntConfiguration(ALPHA, BETA, Q, PHEROMONE_TRAIL_PERSISTENCE, INITIAL_PHEROMONE_TRAILS, NUM_ANTS, MAX_ITERATIONS);
		AntSystemControllerTSP controllerTSP = new AntSystemControllerTSP(graph, graph.getNodes().get(1), configuration);
		Solution solution = controllerTSP.execute();
		System.out.println(solution.toString());
		solution.printThis(RESULT_FOLDER + "questionOne_XII.csv");
	}
	
	/**
	 * @return
	 */
	private static Graph questionOne(){
		/* Nodes */
		LinkedList<Node> nodes = new LinkedList<Node>();
		Node node1 = new Node(1l, "C1"), node2 = new Node(2l, "C2"), node3 = new Node(3l, "C3");
		Node node4 = new Node(4l, "C4"), node5 = new Node(5l, "C5"), node6 = new Node(6l, "C6");
		nodes.add(node1); nodes.add(node2); nodes.add(node3); nodes.add(node4); nodes.add(node5); nodes.add(node6);
		
		LinkedList<Edge> edges = new LinkedList<Edge>();
		/* Arestas - Node1 */
		Edge edge12 = new Edge(1l, node1, node2, 7d);
		Edge edge13 = new Edge(2l, node1, node3, 4d);
		Edge edge14 = new Edge(3l, node1, node4, 3d);
		Edge edge15 = new Edge(4l, node1, node5, 11d);
		Edge edge16 = new Edge(5l, node1, node6, 1d);
		edges.add(edge12); edges.add(edge13); edges.add(edge14); edges.add(edge15); edges.add(edge16);
		/* Arestas - Node2 */
		Edge edge21 = new Edge(6l, node2, node1, 7d);
		Edge edge23 = new Edge(7l, node2, node3, 2d);
		Edge edge24 = new Edge(8l, node2, node4, 8d);
		Edge edge25 = new Edge(9l, node2, node5, 10d);
		Edge edge26 = new Edge(10l, node2, node6, 8d);
		edges.add(edge21); edges.add(edge23); edges.add(edge24); edges.add(edge25); edges.add(edge26);
		/* Arestas - Node3 */
		Edge edge31 = new Edge(11l, node3, node1, 4d);
		Edge edge32 = new Edge(12l, node3, node2, 2d);
		Edge edge34 = new Edge(13l, node3, node4, 9d);
		Edge edge35 = new Edge(14l, node3, node5, 9d);
		Edge edge36 = new Edge(15l, node3, node6, 3d);
		edges.add(edge31); edges.add(edge32); edges.add(edge34); edges.add(edge35); edges.add(edge36);
		/* Arestas - Node4 */
		Edge edge41 = new Edge(16l, node4, node1, 3d);
		Edge edge42 = new Edge(17l, node4, node2, 8d);
		Edge edge43 = new Edge(18l, node4, node3, 9d);
		Edge edge45 = new Edge(19l, node4, node5, 5d);
		Edge edge46 = new Edge(20l, node4, node6, 4d);
		edges.add(edge41); edges.add(edge42); edges.add(edge43); edges.add(edge45); edges.add(edge46);
		/* Arestas - Node5 */
		Edge edge51 = new Edge(21l, node5, node1, 11d);
		Edge edge52 = new Edge(22l, node5, node2, 10d);
		Edge edge53 = new Edge(23l, node5, node3, 9d);
		Edge edge54 = new Edge(24l, node5, node4, 5d);
		Edge edge56 = new Edge(25l, node5, node6, 3d);
		edges.add(edge51); edges.add(edge52); edges.add(edge53); edges.add(edge54); edges.add(edge56);
		/* Arestas - Node6 */
		Edge edge61 = new Edge(26l, node6, node1, 1d);
		Edge edge62 = new Edge(27l, node6, node2, 8d);
		Edge edge63 = new Edge(28l, node6, node3, 3d);
		Edge edge64 = new Edge(29l, node6, node4, 4d);
		Edge edge65 = new Edge(30l, node6, node5, 3d);
		edges.add(edge61); edges.add(edge62); edges.add(edge63); edges.add(edge64); edges.add(edge65);
		
		return new Graph(1l, "Question One", nodes, edges);
	}
}
