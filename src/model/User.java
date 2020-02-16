package model;

public class User {

	private String id;
	private String name;
	private String lastName;
	private String tel;
	private String direction;
	private String typeId;
	
	public User(String id, String name, String lastName, String tel, String direction, String typeId) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.tel = tel;
		this.direction = direction;
		this.typeId = typeId;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getLastName() {
		return lastName;
	}
	public String getTel() {
		return tel;
	}
	public String getDirection() {
		return direction;
	}
	public String getTypeId() {
		return typeId;
	}

}
