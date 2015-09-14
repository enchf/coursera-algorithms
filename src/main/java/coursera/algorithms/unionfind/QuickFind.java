/**
 * 
 */
package coursera.algorithms.unionfind;

import org.apache.commons.lang3.StringUtils;

import coursera.algorithms.core.Stage;
import coursera.algorithms.core.descriptor.Description;

/**
 * Eager approach for union-find.
 * Implemented through an integer array of size N where any elements p and q
 * are connected if and only if they have the same id in the array.
 * @author Ernesto Espinosa.
 */
@Description("Eager approach for union-find")
public class QuickFind implements UnionFind {
	
	private int id[];
	private int count;

	public QuickFind(int n) {
		id = new int[n];
		reset();
	}
	
	/**
	 * Attach the component where a belongs to the component of b.
	 * Changes all id's of a component to b id. 
	 * {@inheritDoc}
	 */
	@Override
	public void union(int a, int b) {
		int p,q;
		p = id[a];
		q = id[b];
		if (p == q) return;
		
		count--;
		for (int i = 0; i < id.length; i++) {
			if (id[i] == p) id[i] = q;
		}
	}

	/** {@inheritDoc} */
	@Override
	public boolean connected(int a, int b) {
		return id[a] == id[b];
	}

	/** {@inheritDoc} */
	@Override
	public int find(int p) {
		return id[p];
	}

	/** {@inheritDoc} */
	@Override
	public int count() {
		return count;
	}

	/**
	 * Returns the current ID array state.
	 */
	@Override
	public Stage getStage() {
		return new Stage(StringUtils.join(id, ' '), QuickFind.class);
	}
	
	/** {@inheritDoc} */
	@Override
	public void reset() {
		for (int i = 0; i < id.length; i++) id[i] = i;
		count = id.length;
	}
}
