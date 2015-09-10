/**
 * 
 */
package coursera.algorithms.core;

import java.io.Serializable;

/**
 * An Object representing a stage of an algorithm.
 * @author Ernesto Espinosa.
 */
public class Stage implements Serializable {

	private static final long serialVersionUID = 78354L;
	
	private String description;
	private Class<?> algorithm;
	private Object state;
	
	public Stage(String description, Class<?> algorithm) {
		super();
		this.description = description;
		this.algorithm = algorithm;
	}

	public String getDescription() {
		return description;
	}

	public Class<?> getAlgorithm() {
		return algorithm;
	}

	public Object getState() {
		return state;
	}

	public void setState(Object state) {
		this.state = state;
	}
}
