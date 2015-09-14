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
	Stage start(String bean, Object...args);
	
	/**
	 * Resets the controller.
	 */
	Stage reset();
}
