/**
 * 
 */
package coursera.algorithms.core;

/**
 * Common functions in algorithms that can be tracked as stages.
 * @author Ernesto Espinosa.
 */
public interface Helper {

	/**
	 * Exchange the elements a and b of the array.
	 * @param array Array to have exchanged positions.
	 * @param a Element position to be exchanged.
	 * @param b Element position to be exchanged.
	 */
	<T> void exchange(T[] array, int a, int b);
}
