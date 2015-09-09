/**
 * 
 */
package coursera.algorithms.unionfind;

/**
 * Interface for Union-Find implementations.
 * @author Ernesto Espinosa.
 */
public interface UnionFind {

	/**
	 * Add connection between A and B.
	 * @param a Object A.
	 * @param b Object B.
	 */
	void union(int a, int b);
	
	/**
	 * Are A and B in the same component?
	 * @param a Object A.
	 * @param b Object B.
	 * @return True if they are in the same connected component, false otherwise.
	 */
	boolean connected(int a, int b);
	
	/**
	 * Component identifier for p (0 to N-1).
	 * @param p Object in the structure.
	 * @return Component identifier.
	 */
	int find(int p);
	
	/**
	 * Number of existing components.
	 * @return Number of existing components.
	 */
	int count();
}
