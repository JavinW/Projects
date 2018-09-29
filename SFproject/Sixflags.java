/*
August 14, 2018
Sixflags.java
a program that allows the user to input employee information,
search for an employee's information, create a work schedule
for an employee, and compile a full employee schedule.
@Author: Javin White
*/

import java.util.Scanner;
import java.util.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//add minor check feature (should be flags method - current.flags() )
//enhance with html output capabilities
//add date capabilities (method should create a schedule for specific dates)
//break up fullSchedule() into more methods and possibly  scheduleMaker() too
public class Sixflags {
	
	//instance variables private to the class
	private ArrayList<SFEmployee> employeeList = new ArrayList<SFEmployee>();
	private String InputFile;
// 	private ArrayList<String> sunday = new ArrayList<String>();
// 	private ArrayList<String> monday = new ArrayList<String>();
// 	private ArrayList<String> tuesday = new ArrayList<String>();
// 	private ArrayList<String> wednesday = new ArrayList<String>();
// 	private ArrayList<String> thursday = new ArrayList<String>();
// 	private ArrayList<String> friday = new ArrayList<String>();
// 	private ArrayList<String> saturday = new ArrayList<String>();	

// 	public void scheduleMaker(String available, String empName) {
// 		String working = available;
// 		String employeeName = empName;
// 		String[] workSched = working.split("/");
// 		for (int i = 0; i < workSched.length; i++) {
// 			if (workSched[i].equals("S")) {
// 				sunday.add(employeeName);
// 			} else if (workSched[i].equals("M")) {
// 				monday.add(employeeName);
// 			} else if (workSched[i].equals("T")) {
// 				tuesday.add(employeeName);
// 			} else if (workSched[i].equals("W")) {
// 				wednesday.add(employeeName);
// 			} else if (workSched[i].equals("Th")) {
// 				thursday.add(employeeName);
// 			} else if (workSched[i].equals("F")) {
// 				friday.add(employeeName);
// 			} else if (workSched[i].equals("Sa")) {
// 				saturday.add(employeeName);
// 			} else {
// 				System.out.println("Invalid employee schedule.");	//needs to be changed 
// 			} //end if/else series									//to throw exception
// 		} //end for loop
// 	} //end method
// 
// 
// 	public String employeeInfo(ArrayList<String[]> workers, boolean print) {
// 		Scanner emplInfo = new Scanner(System.in);
// 		System.out.println("Search by name: ");
// 		String nameToSearch = emplInfo.nextLine();
// 		System.out.println("\n");
// 		String schedule = printEmplInfo(nameToSearch, workers, print);
// 		return schedule;
// 	} //end method
// 	
// 	public String printEmplInfo(String nameToSearch, ArrayList<String[]> workers, boolean printing) {
// 		String eSchedule = "";
// 		for (int i = 0; i < workers.size(); i++){
// 			String[] employeeArray = workers.get(i);
// 			String employee = employeeArray[0];
// 			if (employee.equals(nameToSearch) && printing == true){
// 				System.out.println(employeeArray[0] + "\n" + employeeArray[1] + "\n" + 
// 				employeeArray[2] + "\n" + employeeArray[3] + "\n" + employeeArray[4] + "\n"
// 			+ employeeArray[5]);
// 			} else if (employee.equals(nameToSearch) && printing == false) {
// 				eSchedule = employeeArray[5];
// 			}
// 		} //end for loop
// 		return eSchedule;
// 	}	//end method
// 	
// 	public String employeeSched(ArrayList<String[]> workers) {
// 		String singleSched = employeeInfo(workers, false);
// 		return singleSched;
// 	} //end method		
// 	
	public void fullSchedule() {
		System.out.println("\n" + "SUNDAY" + "\n");
		for (int i = 0; i < sunday.size(); i++) {
			System.out.println(sunday.get(i));
		}
		System.out.println("\n" + "MONDAY" + "\n");

		for (int i = 0; i < monday.size(); i++) {
			System.out.println(monday.get(i));
		}
		System.out.println("\n" + "TUESDAY" + "\n");
		for (int i = 0; i < tuesday.size(); i++) {
			System.out.println(tuesday.get(i));
		}
		System.out.println("\n" + "WEDNESDAY" + "\n");
		for (int i = 0; i < wednesday.size(); i++) {
			System.out.println(wednesday.get(i));
		}
		System.out.println("\n" + "THURSDAY" + "\n");
		for (int i = 0; i < thursday.size(); i++) {
			System.out.println(thursday.get(i));
		}
		System.out.println("\n" + "FRIDAY" + "\n");
		for (int i = 0; i < friday.size(); i++) {
			System.out.println(friday.get(i));
		}
		System.out.println("\n" + "SATURDAY" + "\n");
		for (int i = 0; i < saturday.size(); i++) {
			System.out.println(saturday.get(i));
		}
	} //end method

// 	public void flags() {
// 		
// 
// 	} //end method


//fix delete feature. Should delete employee information from schedule lists
// 	public void deleteEmployee(ArrayList<String[]> workers) {
// 		Scanner scDelete = new Scanner(System.in);
// 		System.out.println("Enter name of employee to be deleted from the system: ");
// 		String nameToDelete = scDelete.nextLine();
// 		for (int i = 0;  i < workers.size(); i++) {
// 			String[] emplArray = workers.get(i);
// 			String nameMatch = emplArray[0];
// 			if (nameToDelete.equals(nameMatch)) {
// 				workers.remove(i);
// 				// for (int j = i + 1; j < workers.size() - 1; j++) {
// // 					workers.get(i) = workers.get(j);
// // 				}
// 			}
// 		}
// 	
// 	} //end method

	public Sixflags(String fileName) {
		try{
			InputFile = fileName;
			Scanner readFile = new Scanner(new File(InputFile));
			while (readFile.hasNextLine()) {
				readFile.useDelimiter(",|\\n");
				String name = readFile.next();
				String bDate = readFile.next();
				String age = readFile.next();
				String number = readFile.next();
				String working = readFile.next();
				String idNum = readFile.next();
				//System.out.println(name + bDate + age + number + working + idNum);
				SFEmployee newEmployee = new SFEmployee(name, bDate, age, number, working, idNum);
				employeeList.add(newEmployee);
			} //end while loop
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} //end try-catch
	} //end method 

	public void newEmployee() {
		Scanner gettingInfo = new Scanner(System.in);
		System.out.println("Enter the new employee's name (first last): ");
		String name = gettingInfo.nextLine();
		System.out.println("Enter the new employee's date of birth (MM/DD/YYYY): ");
		String bDate = gettingInfo.nextLine();
		System.out.println("Enter the new employee's age in years: ");
		String age = gettingInfo.nextLine();
		System.out.println("Enter the new employee's phone number (123-456-7890): ");
		String number = gettingInfo.nextLine();
		System.out.println("Enter the employee's general availability (S/M/T/W/Th/F/Sa): ");
		String working = gettingInfo.nextLine();
		String idNum = createID();
		SFEmployee newHire = new SFEmployee(name, bDate, age, number, working, idNum);
		employeeList.add(newHire);	
	} //end method

	public String createID() {
		Random randomInt = new Random();
		int lower = 100000;
		int upper = 999999;
		int badgeNum = randomInt.nextInt(upper - lower) + lower;
		String strIDNum = String.valueOf(badgeNum);
		return strIDNum;
 	} //end method

	public void addToList() {
		try {
			FileWriter writeToFile = new FileWriter("currEmployees.txt");
			for (int i = 0; i < employeeList.size(); i++) {
				String stringEmpl = employeeList.get(i).toString();
				writeToFile.write(stringEmpl);
				if (i != employeeList.size() - 1) {
					writeToFile.write("\n");
				} //end if
			} //end for
			writeToFile.flush();
			writeToFile.close();
 		} catch (IOException e) {
  			e.printStackTrace();
 		}
	} //end method
	
	public void employeeInfo(String searchName) {
		boolean found = false;
		int i = 0;
		while (found == false && i < employeeList.size()) {
			String employee = employeeList.get(i).getName();
			if (employee.equals(searchName)) {
				found = true;
				String info = employeeList.get(i).toString();
				String[] infoArray = info.split(",");
				for (int j = 0; j < infoArray.length; j++) {
					System.out.println(infoArray[j]);
					} //end for loop
			} else if (i == employeeList.size() - 1 && found == false) {
				System.out.println("Employee not found.");
				found = true;
			} else {
				found = false;
				i++;
			} //end if-else
		} //end while
	} //end method

// 	public void updateInfo() {
// 	
// 	
// 	} //end method
	
	public static void main(String[] args) {
		System.out.println("Welcome to the employee directory!" + "\n");
		Sixflags current = new Sixflags("currEmployees.txt");
 		Scanner keyboard = new Scanner(System.in);
 		boolean keepGoing = true;
 		while (keepGoing == true) {
			System.out.println("Options: " + "\n" + "New employee" + "\n" 
			+ "Show employee information" + "\n" + "Show employee schedule" + "\n" + 
			"Show full schedule" + "\n" + "Add employee flags" + "\n" + 
			"Update employee information" + "\n" + "Delete employee" +
			"\n" + "Quit program" + "\n");
			System.out.println("What would you like to do?");
			String input = keyboard.nextLine();			//add choice.toLowercase()
			String choice = input.toLowerCase();
			//System.out.println("This is the choice: " + choice);
			if (choice.equals("new employee")) {
				current.newEmployee();
			} else if (choice.equals("show employee information")) {
				System.out.println("Enter an employee's name: ");
				String employeeToSearch = keyboard.nextLine();
				System.out.println("\n");
				current.employeeInfo(employeeToSearch);
// 			} else if (choice.equals("Show employee schedule")) {
// 				String showSchedule = current.employeeSched(employeeList);
//  				System.out.println(showSchedule);
			} else if (choice.equals("show full schedule")) {   //stopped with this
 				current.fullSchedule();
// // 			} else if (choice.equals("add employee flags")) {
// // 				current.flags();
// 	// 		} else if (choice.equals("delete employee")) {
// // 				current.deleteEmployee(employeeList);
// 			} else if (choice.equals("update employee information")) {
// 					current.updateInfo();
			} else if (choice.equals("quit program")) {
				current.addToList();
				keepGoing = false;
			} else {
				System.out.println("Please enter a command exactly as written.");	
				keepGoing = true;			
			}
		} //end while loop	
		System.out.println("Thanks for using the employee directory!");
	} //end method
} //end Sixflags.java