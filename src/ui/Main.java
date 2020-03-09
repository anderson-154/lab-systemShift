package ui;
import model.*;

import java.util.Scanner;

import customExceptions.EmptyInputException;
import customExceptions.UnreservedException;
import customExceptions.doubleUserIdException;

public class Main {
	
	public static ControlShift ShiftControl;
	public static Shift shifts;
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int option;
		int option2;
		do {
			System.out.println("Menu");
			System.out.println("1.Add user ");
			System.out.println("2.Register shift ");
			System.out.println("3.Attend shift");
			System.out.println("4.Exit the program");
			System.out.print("Please choose an option: ");
			
			option = Integer.parseInt(sc.nextLine());
			
			switch(option) {
			case 1:
				System.out.println("write your identification, id");
				String id = sc.nextLine();
				System.out.println("write your name");
				String name = sc.nextLine();
				System.out.println("write your last name");
				String lastName = sc.nextLine();
				System.out.println("write your tel");
				String tel = sc.nextLine();
				System.out.println("write your direction");
				String direction = sc.nextLine();
				System.out.println("write your type identification");
				String typeId = sc.nextLine();
				
				try {
					ShiftControl.registerNewUser(id, name, lastName, tel, direction, typeId);	
				}catch( EmptyInputException | doubleUserIdException e) {
					System.out.println(e.getMessage());
				}
				
			break;
			
			case 2:
				System.out.println("write your identification, id");
				id = sc.nextLine();;
				ShiftControl.searchUserAndAssigned(id);
			case 3:
				boolean attended= false;
				try {
					ShiftControl.attendShift(attended);
				}catch(UnreservedException e) {
					System.out.println(e.getMessage());
				}
				
				
			break;
			
			case 4:
				System.out.print("Thank you. Bye!");
			break;
			
			}
		}while(option!=4);
		sc.close();
	}
}
