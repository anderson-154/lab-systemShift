package model;

import java.util.ArrayList;

import customExceptions.EmptyInputException;

public class ControlShift {

	private ArrayList<Shift>shifts;
	private ArrayList<User>users;
	private Shift avaliable;
	private Shift attend;

	public ControlShift(char character, int num) {
		super();
		this.shifts = new ArrayList<Shift>();
		this.users = new ArrayList<User>();
		this.avaliable = new Shift(0, 'A');
		this.attend = new Shift(0, 'A' );

	}
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

	public User searchUser(String id){
		User users1=null;
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getId().equals(id)) {
				users1= users.get(i);
			}
		}
		return users1;
	}
	public Shift ShiftActiveed(User user) {
		Shift shift1=null;
		for(int i=0;i<shifts.size();i++) {
			if(shifts.get(i).getUser().equals(user)) {
				shift1=shifts.get(i);
			}
		}
		return shift1;
	}
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
