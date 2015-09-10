/**
 * 
 */
package coursera.algorithms.unionfind;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import coursera.algorithms.core.Controller;
import coursera.algorithms.core.Stage;

/**
 * Controller for the Union-Find interface.
 * @author Ernesto Espinosa.
 */
@RestController
public class UnionFindController implements Controller {

	/** {@inheritDoc} */
	@Override
	@RequestMapping("/unionfind/init")
	public void init(@RequestParam(value="data") String data) {
		
	}

	/** {@inheritDoc} */
	@Override
	@RequestMapping("/unionfind/reset")
	public void reset() {
		
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
		return null;
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
		return false;
	}
}
