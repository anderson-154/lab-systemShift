package customExceptions;

@SuppressWarnings("serial")
public class UnreservedException extends Exception{
	
	private String stringShift;
	
	public UnreservedException(String stringShift) {
		this.stringShift=stringShift;
	}
	
	@Override
	public String getMessage() {
		return"Shift "+stringShift+" has not been reserved";
	}

}