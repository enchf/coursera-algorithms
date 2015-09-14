/**
 * 
 */
package coursera.algorithms.core;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import coursera.algorithms.core.descriptor.Description;
import coursera.algorithms.core.descriptor.Implementation;
import coursera.algorithms.core.util.ReflectionUtils;

/**
 * Controller base class for common operations.
 * @author Ernesto Espinosa.
 */
public abstract class BaseController<T extends Algorithm> implements Controller {

	private T algorithm;
	private Class<T> algorithmClass;
	protected @Autowired ListableBeanFactory beanFactory;
	private List<Implementation> implementations;
	
	public BaseController() {
		algorithmClass = ReflectionUtils.getDeclaredType(this.getClass(), 0);
	}
	
	/**
	 * Returns the tracked algorithm.
	 * @return Algorithm instance.
	 */
	protected T getAlgorithm() {
		return algorithm;
	}
	
	/**
	 * Sets the algorithm to be tracked.
	 * @param algorithm Algorithm instance.
	 */
	protected void setAlgorithm(T algorithm) {
		this.algorithm = algorithm;
	}
	
	/** {@inheritDoc} */
	@Override
	@RequestMapping("/unionfind/reset")
	public Stage reset() {
		checkForInitialization();
		this.getAlgorithm().reset();
		return this.getAlgorithm().getStage();
	}
	
	/** {@inheritDoc} */
	@Override
	@SuppressWarnings("unchecked")
	public Stage start(String bean, Object...args) {
		validateImplementation(bean);
		this.setAlgorithm((T) beanFactory.getBean(bean, args));
		return this.getAlgorithm().getStage();
	}
	
	/**
	 * Return the implementation beans of the tracked algorithm.
	 * @return List of algorithm meta data descriptors.
	 */
	@RequestMapping("/unionfind/implementations")
	public List<Implementation> implementations() {
		String[] beanNames;
		
		if (implementations == null) {
			beanNames = beanFactory.getBeanNamesForType(algorithmClass);
			implementations = new ArrayList<>(beanNames.length);
			
			for (String bean : beanNames) {
				implementations.add(transform(bean));
			}
		}
		
		return implementations;
	}
	
	/**
	 * Collects the algorithm metadata into an Implementation POJO.
	 * @param algorithm Algorithm to be inspected.
	 * @return Implementation POJO.
	 */
	private Implementation transform(String bean) {
		Implementation impl;
		Class<?> algClass;
		
		algClass = beanFactory.getType(bean);
		impl = new Implementation();
		impl.setClassName(algClass.getSimpleName());
		impl.setBeanName(bean);
		
		if (algClass.isAnnotationPresent(Description.class)) {
			impl.setDescription(algClass.getAnnotation(Description.class).value());
		}
		
		return impl;
	}
	
	/**
	 * Checks if the algorithm is properly set.
	 * @throws IllegalStateException if controller is not started.
	 */
	protected void checkForInitialization() {
		if (getAlgorithm() == null) throw new IllegalStateException();
	}
	
	/**
	 * Check that the requested bean is within the list of implementations.
	 */
	protected void validateImplementation(String impl) {
		for (Implementation item : implementations()) {
			if (item.getBeanName().equals(impl)) return;
		}
		
		throw new IllegalArgumentException("Invalid implementation name");
	}
}
