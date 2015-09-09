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
	 * Initialize the controller.
	 * @param data Initialization data.
	 */
	void init(String data);

	/**
	 * Resets the controller.
	 */
	void reset();
}
