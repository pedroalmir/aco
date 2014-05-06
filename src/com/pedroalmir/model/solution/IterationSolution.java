/**
 * 
 */
package com.pedroalmir.model.solution;

import com.pedroalmir.model.Ant;


/**
 * @author Pedro Almir
 *
 */
public class IterationSolution {
	
	private int iteration;
	private double betterSolution;
	private double worstSolution;
	private double average;
	private double standardDeviation;
	private double distance;
	
	/* Elitismo */
	private double theBest;
	private Ant theBestAnt;
	
	/**
	 * @param iteration
	 * @param betterSolution
	 * @param worstSolution
	 * @param average
	 * @param standardDeviation
	 */
	public IterationSolution(int iteration, double betterSolution, double worstSolution, double average, double standardDeviation, Ant theBestAnt) {
		super();
		this.iteration = iteration;
		this.betterSolution = betterSolution;
		this.worstSolution = worstSolution;
		this.average = average;
		this.standardDeviation = standardDeviation;
		this.theBestAnt = theBestAnt;
	}
	
	/**
	 * @return the iteration
	 */
	public int getIteration() {
		return iteration;
	}
	/**
	 * @param iteration the iteration to set
	 */
	public void setIteration(int iteration) {
		this.iteration = iteration;
	}
	/**
	 * @return the betterSolution
	 */
	public double getBetterSolution() {
		return betterSolution;
	}
	/**
	 * @param betterSolution the betterSolution to set
	 */
	public void setBetterSolution(double betterSolution) {
		this.betterSolution = betterSolution;
	}
	/**
	 * @return the worstSolution
	 */
	public double getWorstSolution() {
		return worstSolution;
	}
	/**
	 * @param worstSolution the worstSolution to set
	 */
	public void setWorstSolution(double worstSolution) {
		this.worstSolution = worstSolution;
	}
	/**
	 * @return the average
	 */
	public double getAverage() {
		return average;
	}
	/**
	 * @param average the average to set
	 */
	public void setAverage(double average) {
		this.average = average;
	}
	/**
	 * @return the standardDeviation
	 */
	public double getStandardDeviation() {
		return standardDeviation;
	}
	/**
	 * @param standardDeviation the standardDeviation to set
	 */
	public void setStandardDeviation(double standardDeviation) {
		this.standardDeviation = standardDeviation;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Iteration " + iteration + "\n");
		buffer.append("BetterSolution:    " + betterSolution + "\n");
		buffer.append("WorstSolution:     " + worstSolution + "\n");
		buffer.append("Average:           " + average + "\n");
		buffer.append("StandardDeviation: " + standardDeviation + "\n");
		
		return buffer.toString().replaceAll("\\.", ",");
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
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(double distance) {
		this.distance = distance;
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
