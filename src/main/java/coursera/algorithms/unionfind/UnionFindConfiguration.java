/**
 * 
 */
package coursera.algorithms.unionfind;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Spring configuration class for Union Find implementations.
 * @author Ernesto Espinosa
 */
@Configuration
public class UnionFindConfiguration {

	/**
	 * Quick find implementation as a Bean.
	 * @param n Size of the component.
	 * @return Quick find implementation.
	 */
	@Bean
	@Scope("prototype")
	public QuickFind quickFind(int n) {
		return new QuickFind(n);
	}
}
