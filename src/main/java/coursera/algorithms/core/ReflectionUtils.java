/**
 * 
 */
package coursera.algorithms.core;

import java.lang.reflect.ParameterizedType;

/**
 * Reflection tasks helper.
 * @author Ernesto Espinosa.
 */
public class ReflectionUtils {

	/**
	 * Returns the declared type of a class at the position indicated.
	 * For example: class Foo implements Bar<String,Object> when applied the method at position 0
	 * will return String.class object.
	 * @param clazz Class to be inspected.
	 * @param position Position of the declared types.
	 * @return Declared class at position if any.
	 * @throws IndexOutOfBoundsException if position is out of bounds of the declared classes.
	 */
	@SuppressWarnings("unchecked")
	public static <T,E> Class<E> getDeclaredType(Class<T> clazz, int position) {
		return (Class<E>) ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[position];
	}
	
	/**
	 * Hidden constructor.
	 */
	private ReflectionUtils() {
		throw new UnsupportedOperationException();
	}
}
