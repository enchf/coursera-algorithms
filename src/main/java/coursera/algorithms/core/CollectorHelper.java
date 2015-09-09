/**
 * 
 */
package coursera.algorithms.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Extension of the untracked helper to collect execution stages.
 * @author Ernesto Espinosa.
 */
public class CollectorHelper extends UntrackedHelper {

	public enum Operation { 
		EXCHANGE
	}
	
	public static final int NO_TRACK = 0;
	public static final int PRE_TRACK = 1;
	public static final int POST_TRACK = 2;
	public static final int FULL_TRACK = 3;
	
	private List<Stage> stages;
	private Map<Operation,Integer> trackMap;
	private Algorithm trackedAlgorithm;
	
	private CollectorHelper() {
		stages = new ArrayList<Stage>();
		trackMap = new HashMap<Operation,Integer>();
	}
	
	public static CollectorBuilder create(Algorithm algorithm) {
		CollectorHelper helper = new CollectorHelper();
		
		helper.trackedAlgorithm = algorithm;
		
		return helper.new CollectorBuilder();
	}
	
	public class CollectorBuilder {
		
		public CollectorBuilder setTracking(Operation operation, int mode) {
			if (mode < 0 || mode > 3) throw new IllegalArgumentException("Invalid tracking mode: " + mode);
			CollectorHelper.this.trackMap.put(operation, mode);
			return this;
		}
		
		public CollectorHelper build() {
			return CollectorHelper.this;
		}
	}
	
	private void addStage() {
		stages.add(trackedAlgorithm.getStage());
	}
	
	private void track(Integer track, Runnable action) {
		int t = track != null ? track : 0;
		if (t == PRE_TRACK || t == FULL_TRACK) addStage();
		action.run();
		if (t == POST_TRACK || t == FULL_TRACK) addStage();
	}
	
	private Integer getTrack(Operation operation) {
		return trackMap.get(operation);
	}

	/** {@inheritDoc} */
	@Override
	public <T> void exchange(T[] array, int a, int b) {
		track(getTrack(Operation.EXCHANGE), () ->  super.exchange(array, a, b));
	}
}
