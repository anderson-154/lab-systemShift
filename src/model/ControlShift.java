package model;

import java.util.ArrayList;

import customExceptions.EmptyInputException;

public class ControlShift {

	private ArrayList<Shift>shifts;
	private ArrayList<User>users;
	private Shift avaliable;
	private Shift attend;

	/**method constructor
	 * @param character
	 * @param num
	 */
	public ControlShift(char character, int num) {
		super();
		this.shifts = new ArrayList<Shift>();
		this.users = new ArrayList<User>();
		this.avaliable = new Shift(0, 'A');
		this.attend = new Shift(0, 'A' );

	}
	/**method add user
	 * <p>des:</p>this method adds a user to ArrayList from users
	 * <b>pre: </b>the ArrayList must be initialized
	 * <b>post: </b> the user has been register
	 * @param name user name user. name!=null && name!="".
	 * @param lastName user last name. lastName!=null && lastName!="".
	 * @param tel user tel. tel!=null && tel!="".
	 * @param direction user direction. direction!=null && direction!="".
	 * @param typeId user type id. typeId!=null && typeId!="".
	 * @return a message if the user has been register
	 * @throws EmptyInputException
	 */
	public String addUser (String id, String name, String lastName, String tel, String direction, String typeId)throws  EmptyInputException{
		String msg="";
		
		for(int i=0;i<users.size();i++)
			if(users.get(i).getId().equals(id)) {
				msg="the user already exists";	
			}
			else{
				users.add(new User(id, name, lastName, tel, direction, typeId));
			}
			return msg;
	}
	/**search user
	 *<p>des:</p> this method searching a user 
	 *<b>pre:</b> the user must have already been created
	 * @param id
	 * @return user found with the id
	 */
	public User searchUser(String id){
		User users1=null;
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getId().equals(id)) {
				users1= users.get(i);
			}
		}
		return users1;
	}
	/** shift active
	 *<p>des:</p> this method search for a user, and if he has an active turn
	 *<b>pre:</b>the user must have already been created
	 * @param user
	 * @return a shift that has a user
	 */
	public Shift ShiftActiveed(User user) {
		Shift shift1=null;
		for(int i=0;i<shifts.size();i++) {
			if(shifts.get(i).getUser().equals(user)) {
				shift1=shifts.get(i);
			}
		}
		return shift1;
	}
	/**Assigned shift to user
	 * <p>des:</p> this method assigned a shift to user
	 * <b>pre:</b> the user has been created
	 * @param id
	 * @throws NullPointerException
	 */
	public void assignedShiftToUser(String id)throws NullPointerException {
		User user = searchUser(id);
		boolean activeShift=false;
		if(user!=null) {
			for(int i=0;i<shifts.size();i++) {
				if(shifts.get(i).isActive() && shifts.get(i).getUser()==user) {
					activeShift=true;
					break;
				}
			}

			if(activeShift==false) {
				shifts.add(new Shift( avaliable.getNum(), avaliable.getCharacter(),  user,  true));
				avaliable.nextShift();
			}
		}
	}
	/**attend shift
	 * <b>des:</b>this method attend a shift to user
	 * <b>pre:</b>the shift must have already been assigned
	 * @param id
	 * @param active
	 */
	public void attendShift(String id, boolean active){
		User user =searchUser(id);
		boolean attendShift=false;
		if(user!=null){
			for(int i=0;i<shifts.size();i++){
				if(shifts.get(i).isActive() && shifts.get(i).getUser()==user) {
					attendShift=true;
					break;
				}
			}
			if(attendShift==false){
				shifts.add(new Shift( attend.getNum(),attend.getCharacter(),  user, false));
				attend.nextShift();
			}
		}
	}
}
