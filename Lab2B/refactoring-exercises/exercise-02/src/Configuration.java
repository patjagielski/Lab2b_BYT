import java.util.*;

public class Configuration {
	private int interval;
	private int duration;
	private int departure;

	public Configuration(int _interval, int _duration, int _departure){
		this.interval = _interval;
		this.duration = _duration;
		this.departure = _departure;
	}

	/**
	 * Bad smell: Primitive Obsession, Data Clumps, Long Method
	 * Created the configuration object that the test work off of
	 * I could have broken each if into its own method call and then call those methods in load
	 * however many of the if statements looked for similar cases so i combined the if statements together to shorten the code and make it more readable
	 */
	public void load() throws ConfigurationException {
		if (this.getInterval() <= 0) {
			throw new ConfigurationException(this.getInterval()+" > 0");
		}
		if (this.getDuration() <= 0 || (this.getDuration() % this.getInterval()) != 0) {
			throw new ConfigurationException(String.valueOf(this.getDuration()));
		}
		if (this.getDeparture() <= 0 || (this.getDeparture() % this.getInterval()) != 0) {
			throw new ConfigurationException("departure offset");
		}
	}

	public int getInterval() {
		return interval;
	}

	public int getDuration() {
		return duration;
	}

	public int getDeparture() {
		return departure;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setDeparture(int departure) {
		this.departure = departure;
	}

//	public void load() throws ConfigurationException {
////		String valueString
////		int value;
//
////		valueString = props.getProperty("interval");
//		if (this.getInterval() <= 0) {
//			throw new ConfigurationException(this.getInterval()+" > 0");
//		}
//
////		value = this.getInterval();
////		if (value <= 0) {
////			throw new ConfigurationException("monitor interval > 0");
////		}
////		interval = value;
//
////		valueString = props.getProperty("duration");
//		if (this.getDuration() <= 0 || (this.getDuration() % this.getInterval()) != 0) {
//			throw new ConfigurationException(String.valueOf(this.getDuration()));
//		}
////		value = Integer.parseInt(valueString);
////		if (value <= 0) {
////			throw new ConfigurationException("duration > 0");
////		}
////		if ((value % interval) != 0) {
////			throw new ConfigurationException("duration % interval");
////		}
////		duration = value;
//
////		valueString = props.getProperty("departure");
//		if (this.getDeparture() <= 0 || (this.getDeparture() % this.getInterval()) != 0) {
//			throw new ConfigurationException("departure offset");
//		}
////		value = Integer.parseInt(valueString);
////		if (value <= 0) {
////			throw new ConfigurationException("departure > 0");
////		}
////		if ((value % interval) != 0) {
////			throw new ConfigurationException("departure % interval");
////		}
////		departure = value;
//	}

}



