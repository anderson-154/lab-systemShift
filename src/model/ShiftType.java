package model;

public class ShiftType {

	private String name;
	private float duration;
	public ShiftType(String name, float duration) {
		super();
		this.name = name;
		this.duration = duration;
	}
	public String getName() {
		return name;
	}
	
	public float getDuration() {
		return duration;
	}
	
	
	
}
