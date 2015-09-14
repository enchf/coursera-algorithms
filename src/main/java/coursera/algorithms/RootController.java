/**
 * 
 */
package coursera.algorithms;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.reflections.Reflections;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coursera.algorithms.core.Algorithm;
import coursera.algorithms.core.descriptor.Description;
import coursera.algorithms.core.descriptor.Descriptor;
import coursera.algorithms.core.descriptor.Descriptor.Player;

/**
 * Controller for the project welcome page.
 * @author Ernesto Espinosa.
 */
@RestController
public class RootController {
	
	private static final String TITLE = "Algorithms Implementation List";

	/**
	 * Get the list of algorithm players.
	 * @return List of algorithm players.
	 */
	@RequestMapping("/players")
	public Descriptor getAlgorithms() {
		Reflections inspector;
		Set<Class<? extends Algorithm>> algorithms;
		Descriptor descriptor;
		Player player;
		String packageName;
		
		inspector = new Reflections("coursera.algorithms");
		algorithms = inspector.getSubTypesOf(Algorithm.class);
		
		descriptor = new Descriptor();
		descriptor.setTitle(TITLE);
		
		for (Class<? extends Algorithm> clazz : algorithms) {
			if (clazz.isInterface() && !clazz.equals(Algorithm.class)) {
				packageName = clazz.getPackage().getName();
				player = descriptor.new Player();
				player.setLink(String.format("/%s/index.html", packageName.substring(packageName.lastIndexOf('.') + 1)));
				player.setName(StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(clazz.getSimpleName()), " "));
				
				if (clazz.isAnnotationPresent(Description.class)) {
					player.setDescription(clazz.getAnnotation(Description.class).value());
				}
				
				descriptor.addPlayer(player);
			}
		}
		
		return descriptor;
	}
}
