/**
 * 
 */
package coursera.algorithms.core;

/**
 * Non-tracked helper for the algorithm classes.
 * @author Ernesto Espinosa.
 */
public class UntrackedHelper implements Helper {

	/** {@inheritDoc} */
	@Override
	public <T> void exchange(T[] array, int a, int b) {
		T t;
		t = array[a];
		array[a] = array[b];
		array[b] = t;
	}
}
