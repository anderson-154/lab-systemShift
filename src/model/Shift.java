package model;

public class Shift implements Comparable<Shift> {

	private User user;
	private ShiftType shiftTypes;
	private int num;
	private char character;
	private boolean attended;
	private Shift nextShift;

	/**method constructor
	 * @param num
	 * @param character
	 */
	public Shift(int num, char character) {
		super();
		this.num = num;
		this.character = character;
	}
	/**method constructor
	 * @param num
	 * @param character
	 * @param user
	 * @param active
	 */
	public Shift(int num, char character, User user, boolean attended, ShiftType shiftTypes) {
		super();
		this.num = num;
		this.character = character;
		this.user = user;
		this.attended = attended;
		this.shiftTypes= shiftTypes;
	}
	

	public User getUser() {
		return user;
	}
	public int getNum() {
		return num;
	}

	public char getCharacter() {
		return character;
	}

	public boolean isAttended() {
		return attended;
	}

	public void setAttended(boolean attended) {
		this.attended = attended;
	}
	public ShiftType getShiftType() {
		return shiftTypes;
	}
	
	public Shift getNextShift() {
		return nextShift;
	}
	public void setNextShift(Shift nextShift) {
		this.nextShift = nextShift;
	}
	/** join Cadena
	 * <p> des:</p>this method will join an integer with a character
	 * @return a String whit a code
	 */	
	public String getStringShift() {
		String _num=""+num;
		return _num.length()==1 ? ""+character+"0"+num : ""+character+num;
	}
		
	/**next shift
	 * <p> des:</p>this method will advance a one shift 
	 */
	public void nextShift() {
		num++;
		if(num==100) {
			character++;
			num=0;
		}
		if(character==91) {
			character=65;
		}
	}
	public String toAssignUser(User user) {
		this.user=user;
		return "Shift "+getStringShift()+" asigned to user "+user.getName();
	}
	@Override
	public int compareTo(Shift o) {
		return shiftTypes.compareTo(o.shiftTypes);
	}
	
}
