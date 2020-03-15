package ui;
import model.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import customExceptions.EmptyInputException;
import customExceptions.doubleUserIdException;

public class Main {
	
	public static ControlShift ShiftControl = new ControlShift();
	public static ShiftType shiftTypes = new ShiftType(null, 0);
	public static Shift shifts;
	public static Calendar dateManual = Calendar.getInstance();
	public static Calendar dateCurrent = new GregorianCalendar();
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int option;
		do {
			System.out.println("Menu");
			System.out.println("1.Add user ");
			System.out.println("2.Register shift ");
			System.out.println("3.Attend shift");
			System.out.println("4.actualized date");
			System.out.println("5.generated report");
			System.out.println("6.generated users");
			System.out.println("7.generated shifts");
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
					System.out.println("the user has been register" );
				}catch( EmptyInputException | doubleUserIdException e) {
					System.out.println(e.getMessage());
					System.out.println("the user has not been register, the user exist");
				}
				
			break;
			
			case 2:
				System.out.println("register shift");
				if(ShiftControl.getShiftTypes().size()==0) {
					System.out.println("these are not type of shifts");
				}
				else {
					System.out.println("\n1 assign shift \n2 cancel");
					option = Integer.parseInt(sc.nextLine());
					try {
						if(option==1) {
							System.out.println("these are the type of shifts");
							System.out.println("selec the type of shift");
							System.out.println(ShiftControl.showShiftTypes()+"\n");
							int option2 = Integer.parseInt(sc.nextLine());
							
							ShiftType st= ShiftControl.getShiftTypes().get(option2-1);
							System.out.println("write your identification, id");
							id = sc.nextLine();
							ShiftControl.searchUserAndAssigned(id, st);
							System.out.println("has been assigned the shift to user:  "+id);
						}
					}catch(NullPointerException e) {
						System.out.println("the id not has been created");
					}catch(IndexOutOfBoundsException e) {
						System.out.println("this type of shift does not exist");
					}
				}
				break;
				
			case 3:
				System.out.println("choose option");
				System.out.println("1.Do you want to update the date manually?");
				System.out.println("2.Do you want show to current date?");
				int y;
				int m;
				int d;
				int h;
				int min;
				int sec; 
				option = Integer.parseInt(sc.nextLine());
				switch(option) {
					case 1:
						System.out.println("write the date");
						y = sc.nextInt();
						m = sc.nextInt();
						d = sc.nextInt();
						h = sc.nextInt();
						min = sc.nextInt();
						sec = sc.nextInt();
						//System.out.println(""+showDateManual( y,  m,  d,  h,  min,  sec));
					break;
					
					case 2:
						//System.out.println(""+showDateCurrent( y,  m,  d,  h,  min,  sec));
						
					break;
				}
			break;
			
			case 4:
				System.out.print("write the name");
				name = sc.nextLine();
				
				System.out.println("write the time");
				float duration = sc.nextFloat();
				sc.nextLine();
				
				ShiftControl.addShiftType( name,  duration);
				
			break;
			
			case 5:
				System.out.println("choose a option");
				System.out.println("1.show report");
				System.out.println("2.generateeed report");
				option = Integer.parseInt(sc.nextLine());
				if(option==1) {
					try {
						BufferedReader br = new BufferedReader(new FileReader("data/report.txt"));
						int size=sc.nextInt();
						//ShiftControl.generatedReporBinary(shifts , size);
						System.out.println(br.readLine());
						
					}catch(Exception e) {
						System.out.println("file not found");
					}
				}else {
					try {
						String rxt="------------";
						PrintWriter pw=new PrintWriter("data/reporv2.txt");
						pw.println(rxt);
						pw.close();
					}catch(Exception e){
						System.out.println("file not found");
					}
				}
				
				
			break;
			
			case 6:
				System.out.println("generated users ramdom");
				System.out.println("how many new users do you want to generate?");
				int n=sc.nextInt();
				
				System.out.println(ShiftControl.generarNombresAleatorios(n));
			break;
			
			case 7:
				System.out.println("generated users ramdom");
				System.out.println("how many new users do you want to generate?");
				int b=sc.nextInt();
				
			break;	
			
			}
		}while(option!=7);
		sc.close();
	}

}
