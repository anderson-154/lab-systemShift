package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import customExceptions.EmptyInputException;
import model.ControlShift;
import model.User;
import model.Shift;
class testControlShift {

private ControlShift controlShift;

	public void setup1()throws EmptyInputException{
		controlShift = new ControlShift('A', 0);
		User a = new User("123456789", "Anderson","cardenas"," ", "calle2 #6a50","cedula");
		User b = new User("123456780", "juan","lopez","3184800200", "calle56 #a550","cedula");
		User c = new User("123456781", "carlos","zuñiga","3117045192", " ","cedula");
	}
	public void setup2()throws EmptyInputException{
		controlShift = new ControlShift('A', 0);
		User d = new User("123456789", "Anderson","cardenas","3182870200 ", "calle2 #6a50","cedula");
		User e = new User("789456123", "sol","carmona","3117547895", "carr5 #a98","tarjeta de identidad");
		User f = new User("468213792", "sofia","tabares","314587659", " carr8  #4a5","cedula");
	}
	@Test
	public void testControlRegister()throws EmptyInputException {
		
		setup1();

		assertTrue(controlShift.addUser(a));
		assertTrue(controlShift.addUser(b)); 
		assertTrue(controlShift.addUser(c));
	}
	

}
