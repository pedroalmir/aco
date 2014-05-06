/**
 * 
 */
package com.pedroalmir.model.problem;

/**
 * @author Pedro Almir
 *
 */
public class AntConfiguration {
	
	private final double alpha;
	private final double beta;
	private final double q;
	private final double pheromonePersistence;
	private final double initialPheromone;
	private final int numAgents;
	private final int maxIterations;
	private final int maxExecutions;
	
	/**
	 * @param alpha
	 * @param beta
	 * @param q
	 * @param pheromonePersistence
	 * @param initialPheromone
	 * @param numAgents
	 * @param maxIterations
	 * @param maxExecutions
	 */
	public AntConfiguration(double alpha, double beta, double q, double pheromonePersistence, 
			double initialPheromone, int numAgents, int maxIterations, int maxExecutions) {
		super();
		this.alpha = alpha;
		this.beta = beta;
		this.q = q;
		this.pheromonePersistence = pheromonePersistence;
		this.initialPheromone = initialPheromone;
		this.numAgents = numAgents;
		this.maxIterations = maxIterations;
		this.maxExecutions = maxExecutions;
	}
	
	/**
	 * @param alpha
	 * @param beta
	 * @param q
	 * @param pheromonePersistence
	 * @param initialPheromone
	 * @param numAgents
	 * @param maxIterations
	 */
	public AntConfiguration(double alpha, double beta, double q, double pheromonePersistence, 
			double initialPheromone, int numAgents, int maxIterations) {
		super();
		this.alpha = alpha;
		this.beta = beta;
		this.q = q;
		this.pheromonePersistence = pheromonePersistence;
		this.initialPheromone = initialPheromone;
		this.numAgents = numAgents;
		this.maxIterations = maxIterations;
		this.maxExecutions = 1;
	}
	
	/**
	 * @return the alpha
	 */
	public double getAlpha() {
		return alpha;
	}
	/**
	 * @return the beta
	 */
	public double getBeta() {
		return beta;
	}
	/**
	 * @return the q
	 */
	public double getQ() {
		return q;
	}
	/**
	 * @return the pheromonePersistence
	 */
	public double getPheromonePersistence() {
		return pheromonePersistence;
	}
	/**
	 * @return the initialPheromone
	 */
	public double getInitialPheromone() {
		return initialPheromone;
	}

	/**
	 * @return the numAgents
	 */
	public int getNumAgents() {
		return numAgents;
	}

	/**
	 * @return the maxIterations
	 */
	public int getMaxIterations() {
		return maxIterations;
	}

	/**
	 * @return the maxExecutions
	 */
	public int getMaxExecutions() {
		return maxExecutions;
	}
}
