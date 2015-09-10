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
	 * Resets the implementation to its initial stage.	
	 */
	void reset();
}
