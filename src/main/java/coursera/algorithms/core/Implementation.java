/**
 * 
 */
package coursera.algorithms.core;

import java.io.Serializable;

/**
 * Algorithm implementation meta data.
 * @author Ernesto Espinosa.
 */
public class Implementation implements Serializable {

	private static final long serialVersionUID = 4675L;
	
	private String className;
	private String description;
	private String beanName;
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBeanName() {
		return beanName;
	}
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
}
