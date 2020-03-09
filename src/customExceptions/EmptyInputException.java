package customExceptions;

@SuppressWarnings("serial")
public class EmptyInputException extends Exception{
	
	private String emptyFields;
	
	public EmptyInputException(String id, String typeId, String name, String lastName) {
		emptyFields="";
		determineEmptyFields(id, typeId, name, lastName);
	}
	
	public void determineEmptyFields(String id,String idType, String name, String lastNames) {
		if(id.equals(""))
			emptyFields+="Empty id ";
		if(idType.equals(""))
			emptyFields+="Empty idType ";
		if(name.equals(""))
			emptyFields+="Empty name ";
		if(lastNames.equals(""))
			emptyFields+="Empty lastNames";
	}
	
	@Override
	public String getMessage() {
		return "Attemp to create a user with "+emptyFields;
	}

}
