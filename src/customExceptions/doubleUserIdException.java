package customExceptions;

@SuppressWarnings("serial")
public class doubleUserIdException extends Exception{
	
	private String repeatedId;
	
	public doubleUserIdException(String id) {
		repeatedId=id;
	}
	
	@Override
	public String getMessage() {
		return "User with the id: "+repeatedId+" is already exists";
	}

}

