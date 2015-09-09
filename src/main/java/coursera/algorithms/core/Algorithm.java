/**
 * 
 */
package coursera.algorithms.core;

/**
 * Helper interface to describe algorithm behaviour.
 * @author Ernesto Espinosa.
 */
public interface Algorithm {

	/**
	 * Return the current execution stage.
	 * @return Execution stage descriptor.
	 */
	Stage getStage();
	
	/**
	 * Parses input data string representation.
	 * @param data Data to be processed by the algorithm.
	 */
	void parseInput(String data);
}
