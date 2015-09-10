/**
 * 
 */
package coursera.algorithms.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Class simple description annotation.
 * @author Ernesto Espinosa.
 */
@Target(ElementType.TYPE)
public @interface Description {

	/**
	 * Type description as String.
	 * @return Type description.
	 */
	String value();
}
