/**
 * 
 */
package com.pedroalmir.model;

import java.util.LinkedList;
import java.util.List;

import com.pedroalmir.model.graph.Edge;
import com.pedroalmir.model.graph.Node;


/**
 * @author Pedro Almir
 *
 */
public class Ant implements Cloneable{
	/** ID */
	private Long id;
	/** Information */
	private String information;
	/** ActualNode */
	private Node actualNode;
	/** First Node */
	private Node firstNode;
	/** */
	private List<Node> tabuList;
	/** */
	private List<Edge> edgeList;
	
	/**
	 * @param ant
	 */
	public Ant(Ant ant) {
		this.id = ant.getId();
		this.information = ant.getInformation();
		this.actualNode = ant.getActualNode();
		this.firstNode = ant.getFirstNode();
		this.tabuList = ant.getTabuList();
		this.edgeList = ant.getEdgeList();
	}
	
	/**
	 * @param id
	 * @param information
	 * @param actualNode
	 */
	public Ant(String information, Node actualNode) {
		this.information = information;
		this.actualNode = actualNode;
		this.firstNode = actualNode;
		
		this.tabuList = new LinkedList<Node>();
		this.tabuList.add(actualNode);
		
		this.edgeList = new LinkedList<Edge>();
	}
	
	/**
	 * Reset ant
	 */
	public void reset(){
		this.actualNode = this.firstNode;
		this.tabuList = new LinkedList<Node>();
		this.tabuList.add(this.getActualNode());
		
		this.edgeList = new LinkedList<Edge>();
	}
	
	@Override
	public Ant clone() {
		return new Ant(this);
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the information
	 */
	public String getInformation() {
		return information;
	}
	/**
	 * @param information the information to set
	 */
	public void setInformation(String information) {
		this.information = information;
	}
	/**
	 * @return the actualNode
	 */
	public Node getActualNode() {
		return actualNode;
	}
	/**
	 * @param actualNode the actualNode to set
	 */
	public void setActualNode(Node actualNode) {
		this.actualNode = actualNode;
	}
	/**
	 * @return the tabuList
	 */
	public List<Node> getTabuList() {
		return tabuList;
	}
	/**
	 * @param tabuList the tabuList to set
	 */
	public void setTabuList(List<Node> tabuList) {
		this.tabuList = tabuList;
	}
	/**
	 * @return the firstNode
	 */
	public Node getFirstNode() {
		return firstNode;
	}

	/**
	 * @return the edgeList
	 */
	public List<Edge> getEdgeList() {
		return edgeList;
	}

	/**
	 * @param edgeList the edgeList to set
	 */
	public void setEdgeList(List<Edge> edgeList) {
		this.edgeList = edgeList;
	}

	/**
	 * @param information
	 * @param actualNode
	 * @param tabuList
	 */
	public Ant(String information, Node actualNode, List<Node> tabuList) {
		super();
		this.information = information;
		this.actualNode = actualNode;
		this.tabuList = tabuList;
	}
}
