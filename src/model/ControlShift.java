package model;

import java.util.ArrayList;

import customExceptions.EmptyInputException;
import customExceptions.UnreservedException;
import customExceptions.doubleUserIdException;

public class ControlShift {

	private ArrayList<Shift>shifts;
	private ArrayList<User>users;
	private Shift avaliable;
	private Shift attend;

	/**method constructor
	 * @param character
	 * @param num
	 */
	public ControlShift() {
		super();
		shifts = new ArrayList<Shift>();
		users = new ArrayList<User>();
		avaliable = new Shift(0, (char)65);
		attend = new Shift(0, (char)65);

	}

	/**search user
	 *<p>des:</p> this method searching a user 
	 *<b>pre:</b> the user must have already been created
	 * @param id
	 * @return user found with the id
	 */
	public String searchUserAndAssigned(String id){
		String mss="user not found";
		User users1=null;
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getId().equals(id)) {
				
				shifts.add(new Shift(avaliable.getNum(),avaliable.getCharacter(),users.get(i),false));
				mss="Shift "+avaliable.getStringShift()+" asigned to user "+users.get(i).getName();
				avaliable.nextShift();
			}
		}
		return mss;
	}
	
	public boolean existUserWithId(String id) {
			
			boolean existingUser=false;
			
			for(int i=0; i<users.size();i++) {
				
				if(users.get(i).getId().equals(id)) {
					existingUser=true;
					break;
				}
			}
			
			return existingUser;
		}
	public String registerNewUser(String id, String typeId, String name, String lastName, String direction, String tel) throws EmptyInputException, doubleUserIdException {
			
			if((id.equals("") || typeId.equals("")) || (name.equals("") || lastName.equals("")) ){
				throw new EmptyInputException(id, typeId, name, lastName);
			}
			else if(existUserWithId(id)) {
				throw new doubleUserIdException(id);
			}
			else {
				users.add(new User(id, typeId, name, lastName, direction, tel));
			}
				
		return "User added correctly";
	}

	/**attend shift
	 * <b>des:</b>this method attend a shift to user
	 * <b>pre:</b>the shift must have already been assigned
	 * @param id
	 * @param active
	 * @throws UnreservedException 
	 */
	public void attendShift(boolean attended) throws UnreservedException{
		boolean attendShift=false;
			for(int i=0;i<shifts.size();i++){
				if(shifts.get(i).getStringShift().equals(avaliable.getStringShift())) {
					shifts.get(i).setAttended(attended);
					avaliable.nextShift();
					attendShift=true;
					break;
				}	
			}
			if(!attendShift){
				throw new UnreservedException(avaliable.getStringShift());
			}
		}
	
}
