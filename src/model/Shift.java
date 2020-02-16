package model;

public class Shift {

	private User user;
	private int num;
	private char character;
	private boolean attended;
	private boolean active;
	
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
	public Shift(int num, char character, User user, boolean active) {
		super();
		this.num = num;
		this.character = character;
		this.user = user;
		this.active = active;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	/** join Cadena
	 * <p> des:</p>this method will join an integer with a character
	 * @return a String whit a code
	 */
	public String joinCadena() {
		String code;
		if(num<10) {
			code=""+character+"0"+num;
		}
		else {
			code=""+character+num;
		}
		return code;
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
			character='A';
		}
	}
}
