/**
 * 
 */
package coursera.algorithms.core;

/**
 * Web item controller.
 * @author Ernesto Espinosa.
 */
public interface Controller {
	
	/**
	 * Initializes the controller.
	 * @param args Initialization arguments.
	 */
	void start(String bean, Object...args);
	
	/**
	 * Resets the controller.
	 */
	void reset();
}
