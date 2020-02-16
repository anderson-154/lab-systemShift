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
	@Test
	public void testControlRegister() {
		
		setup1();

		assertTrue(controlShift.addUser(a));
		assertTrue(controlShift.addUser(b)); 
		assertTrue(controlShift.addUser(c));
	}
	

}
