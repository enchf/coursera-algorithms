/**
 * 
 */
package coursera.algorithms.unionfind;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import coursera.algorithms.core.BaseController;
import coursera.algorithms.core.Stage;
import coursera.algorithms.core.descriptor.DataWrapper;

/**
 * Controller for the Union-Find interface.
 * @author Ernesto Espinosa.
 */
@RestController
public class UnionFindController extends BaseController<UnionFind> {
	
	/** {@inheritDoc} */
	@RequestMapping("/unionfind/init")
	public Stage init(@RequestParam(value="algorithm") String implementation, @RequestParam(value="size") int n) {
		return start(implementation, n);
	}
	
	/**
	 * Executes a multiple union command.
	 * @param list List of elements to be joined in the form A-B,C-D,..., etc.
	 * @return List of stages wrapped.
	 */
	@RequestMapping("/unionfind/multiunion")
	public DataWrapper multiUnion(@RequestParam(value="list") String list) {
		List<Stage> stages;
		String[] tokens;
		int p,q;
		DataWrapper wrapper;
		
		stages = new ArrayList<>();
		wrapper = new DataWrapper();
		
		for (String item : list.split(",")) {
			tokens = item.trim().split("-");
			p = Integer.parseInt(tokens[0]);
			q = Integer.parseInt(tokens[1]);
			stages.add(union(p,q));
		}
		
		wrapper.setData(stages);
		
		return wrapper;
	}
	
	/**
	 * Joins p component with q component.
	 * Operation available only after initialization.
	 * @param p Element p.
	 * @param q Element q.
	 * @return Union-find status stage after the join.
	 */
	@RequestMapping("/unionfind/union")
	public Stage union(@RequestParam(value="p") int p, @RequestParam(value="q") int q) {
		getAlgorithm().union(p, q);
		return getAlgorithm().getStage();
	}
	
	/**
	 * Checks whether if p and q are connected or not.
	 * Operation available only after initialization.
	 * @param p Element p.
	 * @param q Element q.
	 * @return True if connected, false otherwise.
	 */
	@RequestMapping("/unionfind/connected")
	public boolean connected(@RequestParam(value="p") int p, @RequestParam(value="q") int q) {
		return getAlgorithm().connected(p, q);
	}
}
