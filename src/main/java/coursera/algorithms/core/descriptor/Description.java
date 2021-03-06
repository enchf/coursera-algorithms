/**
 * 
 */
package coursera.algorithms.core.descriptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Class simple description annotation.
 * @author Ernesto Espinosa.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Description {

	/**
	 * Type description as String.
	 * @return Type description.
	 */
	String value();
}
