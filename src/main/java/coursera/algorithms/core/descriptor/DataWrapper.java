/**
 * 
 */
package coursera.algorithms.core.descriptor;

import java.io.Serializable;

/**
 * Data wrapper helper for JSON responses.
 * @author Ernesto Espinosa.
 */
public class DataWrapper implements Serializable {

	private static final long serialVersionUID = 32829727737L;
	
	private Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
