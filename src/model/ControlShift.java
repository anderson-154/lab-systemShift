package model;

import java.util.ArrayList;
import java.util.Collections;

import customExceptions.EmptyInputException;
import customExceptions.UnreservedException;
import customExceptions.doubleUserIdException;

public class ControlShift {

	private ArrayList<Shift>shifts;
	private ArrayList<User>users;
	private ArrayList<ShiftType>shiftTypes;
	private Shift avaliable;
	private Shift firstShift;


	public ArrayList<Shift> getShifts() {
		return shifts;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public ArrayList<ShiftType> getShiftTypes() {
		return shiftTypes;
	}

	public Shift getAvaliable() {
		return avaliable;
	}

	/**method constructor
	 * @param character
	 * @param num
	 */
	public ControlShift() {
		super();
		shifts = new ArrayList<Shift>();
		users = new ArrayList<User>();
		avaliable = new Shift(0, (char)65);
		shiftTypes = new ArrayList<ShiftType>();

	}

	/**search user
	 *<p>des:</p> this method searching a user 
	 *<b>pre:</b> the user must have already been created
	 * @param id
	 * @return user found with the id
	 */
	public String searchUserAndAssigned(String id, ShiftType st){
		String mss="user not found";
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getId().equals(id)) {
				
				shifts.add(new Shift(avaliable.getNum(),avaliable.getCharacter(),users.get(i),false, st));
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
				}	
			}
			if(!attendShift){
				throw new UnreservedException(avaliable.getStringShift());
			}
		}
	
	
	public String showShiftTypes() {
		String mss="";
		for(int i =0; i<shiftTypes.size();i++) {
			mss=(i+1)+" "+shiftTypes.get(i).getName()+" "+shiftTypes.get(i).getDuration()+"\n"; 
		}
		return mss;
	}
	public String addShiftType(String name, float duration) {
		shiftTypes.add(new ShiftType(name, duration));
		
		return "shift type has been created";
	}
	public void bubbleSortByName() {
		if(firstShift!=null) {
			boolean change;
			do{
				
				change=false;
				Shift beforeCurrent=firstShift;
				Shift current= firstShift.getNextShift();
				Shift nextCurrent= current.getNextShift();
					
					if(beforeCurrent.compareTo(current)>0) {
						beforeCurrent.setNextShift(nextCurrent);
						current.setNextShift(beforeCurrent);
						
						firstShift=current;
						current=current.getNextShift();
						beforeCurrent=current;
						
					}
					while(nextCurrent!=null) {
						if(current.compareTo(nextCurrent)>0) {
							change=true;
							
							beforeCurrent.setNextShift(nextCurrent);
							current.setNextShift(nextCurrent.getNextShift());
							nextCurrent.setNextShift(current);
							
							beforeCurrent=beforeCurrent.getNextShift();
							nextCurrent=current.getNextShift();
						}else {
							beforeCurrent=current;
							current=nextCurrent;
							nextCurrent=nextCurrent.getNextShift();
						}
					}
			}while( change );
		}
	}
	public void generatedReporBinary() {
		Collections.sort(shifts);
	}
	
	public  String[] generarNombresAleatorios(int cantidad) {
		String[] nombresAleatorios = new String[cantidad];

		String[] id = { "2342342234", "435345345", "345345345", "345345345", "345345", "345345345", "657567567", "3454577",
				"34534667", "789789870", "34332423", "435346457", "867867867", "4564564645", "34534534534", "456456456", "3453454363",
				"34534657557", "234234234", "34534645546"};
		String[] typeId = { "cc", "cc", "cc", "cc", "cc", "ti", "ti", "cc",
				"c", "cc", "ti", "cc", "ti", "ti", "cc", "ti", "cc",
				"cc" };
		String[] name = { "Andrea", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo",
				"Bartolomé", "Baruc", "Baruj", "Candelaria", "Cándida", "Canela", "Caridad", "Carina", "Carisa",
				"Caritina", "Carlota", "Baltazar"};
		String[] lastName = { "Gomez", "Guerrero", "Cardenas", "Cardiel", "Cardona", "Cardoso", "Cariaga", "Carillo",
				"Carion", "Castiyo", "Castorena", "Castro", "Grande", "Grangenal", "Grano", "Grasia", "Griego",
				"Grigalva" };
		String[] direction = { "46546", "4564", "34534", "2423", "234", "234", "3432", "454",
				"90", "435", "234", "23", "323", "456", "345", "3453", "987",
				"79" };
		String[] tel = { "312325325", "1312532534", "3123154436", "3457568765", "3345769887", "3113235436", "3114354765", "3414353465",
				"42343465867", "234235467", "324235346", "423436655", "3443634645", "34234324", "342423554654", "34535346457", "311656765",
				"32435465457" };
		for (int i = 0; i < cantidad; i++) {
			nombresAleatorios[i] = id[(int) (Math.floor(Math.random() * ((id.length - 1) - 0 + 1) + 0))] + " "
					+ typeId[(int) (Math.floor(Math.random() * ((typeId.length - 1) - 0 + 1) + 0))] + " "
					+ name[(int) (Math.floor(Math.random() * ((name.length - 1) - 0 + 1) + 0))]+ " "
					+ typeId[(int) (Math.floor(Math.random() * ((typeId.length - 1) - 0 + 1) + 0))]+ " "
					+ lastName[(int) (Math.floor(Math.random() * ((name.length - 1) - 0 + 1) + 0))]+ " "
					+ direction[(int) (Math.floor(Math.random() * ((typeId.length - 1) - 0 + 1) + 0))]+ " "
					+ tel[(int) (Math.floor(Math.random() * ((typeId.length - 1) - 0 + 1) + 0))];
			users.add(new User(id, typeId, name, lastName, direction, tel));
		}
		
		return nombresAleatorios;
	}
	
}
