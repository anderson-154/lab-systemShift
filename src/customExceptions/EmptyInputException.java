package customExceptions;

@SuppressWarnings("serial")
public class EmptyInputException extends Exception{
	
	public EmptyInputException() {
		super("has not written any data");
	}
}
