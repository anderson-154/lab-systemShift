package model;

public class User {

	private String id;
	private String name;
	private String lastName;
	private String tel;
	private String direction;
	private String typeId;
	/**
	 * method constructor
	 * @param name user name user. name!=null && name!="".
	 * @param lastName user last name. lastName!=null && lastName!="".
	 * @param tel user tel. tel!=null && tel!="".
	 * @param direction user direction. direction!=null && direction!="".
	 * @param typeId user type id. typeId!=null && typeId!="".
	 */
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
	@Override
	public String toString() {
		String user;
		user =typeId+" "+id+".  "+name+" "+lastName+".   Address: "+tel+".   Phone Number: "+direction;
		return user;
	}

}
