/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ms2;

import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

/**
 *
 * @author mj061026
 */
public class App {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        // This is the scanner variable 
        
        boolean key = true;
        //  this is the key of the loop
        
        String[][] userType = {{"EMPLOYEE","STAFF"},{"12345","67890"}};
        // type of user that would be entering 
        
        
        
        while(key){
            
            System.out.println("Enter user and password");
            String input1 = sc.nextLine().trim();
            String input2 = sc.nextLine();
            // This is the input of the loop
            
            if (input1.toUpperCase().equalsIgnoreCase(userType[0][0]) && input2.equalsIgnoreCase(userType[1][0])){
                //This is to upper case and ignore case finding the array of username and passowrd on the list
                System.out.println("Hello " + userType[0][0]);
                employeeInterface();
                break;
            
            }
            // This is for Employee Interface 
            
            else if(input1.toUpperCase().equalsIgnoreCase(userType[0][1]) && input2.equalsIgnoreCase(userType[1][1])){
                //This is for finding the Staff in the operations 
                System.out.println("Welcome " + userType[0][1]);
                staffInterface();
                break;
                
            }
            // This is for the Staff Interface 
            
            else {
                
                System.out.println("Invalid username and password");
                break;
                // break is use to end the program as its invalid 
            
            }

        
        }
        
        
    }
    // This is the main method where it also gets conducted 
    
    
    public static void employeeInterface(){
        
        Scanner input = new Scanner(System.in);
        // the Scanner of this subject
        boolean key = true;
        // key of this local loop
        
        //System.out.println("employeeInterface worked");
        //This is system check if it did work or not 
        
        while(key){
            
            System.out.println("Find Employee Number type Enter if not type exit");
            String employeeAccess = input.nextLine().trim();
            //This is the input processor of this method 
            
            if(employeeAccess.toUpperCase().equalsIgnoreCase("EXIT")){
                System.out.println("Exit");
                break;
                //This exits the Employee 
            }
            
            else if(employeeAccess.toUpperCase().equalsIgnoreCase("ENTER")){
                //This is to get to this other operation finding the employee Numbers 
                System.out.println("Enter");
                searchEmployee();
                //This is for finding the searchEmployee() 
                break;
            
            }
            
            else {
                System.out.println("Invalid");
                //This is invalid output 
            }
            
        }
        
    } 
    //This is the employee interface to check if they would search or exit 
    
    public static void searchEmployee(){
        
        System.out.println("Hello World");
        //This is to test if the code did run or not 
        
        Scanner sc = new Scanner(System.in);
        //This is the Scanner for the input 
        
        System.out.println("Enter Employee ID");
        String input = sc.nextLine().trim();
        //This is for the input search bar you search for it 
        
        String file = "payroll.csv";
        //This is the file we are gonna use
        boolean found = false; 
        //this is the boolean for this operations 
        
        try(BufferedReader br = new BufferedReader (new FileReader(file)) ){
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(","); // 3. Split the row

                // 4. Compare Scanner input to the first column of the CSV
                if (columns.length > 0 && columns[0].trim().equalsIgnoreCase(input)) {
                    System.out.println("\n--- Record Found ---");
                    System.out.println("ID: " + columns[0]);
                    System.out.println("Name: " + columns[1]);
                    System.out.println("Birthday: " + columns[2]);
                    found = true;
                    break; 
                }
            }
        }
        //This is where you find Employee Data if your an Employee 
        
        catch(IOException e){
            System.out.println("Could not found in " + file);
        }
        //This is for catching errors or something of the file
        if(!found){
            
            System.out.println("Employee Number Did not exist in " + file);
        
        }
        //This is where it says it doesnt exist
    
    }
    
    public static void staffInterface(){
        
        Scanner sc = new Scanner(System.in);
        boolean key = true;
        // this is the scanner and the key for the operations 
        
        
        
        while(key){
            
            System.out.println("Process Payroll type PP or Exit type Exit");
            //This is to diagnose if the program worked or not    
            String input = sc.nextLine().trim();
            
            if (input.toUpperCase().equalsIgnoreCase("PP")){
                System.out.println("PP Successful");
                searchPayRoll();
                //This is the enter to accessing the Payroll
                break;
            }
            else if(input.toUpperCase().equalsIgnoreCase("EXIT")){
                System.out.println("Exit");
                //Exit way
                break;
                
            }
            
            else {
                
                System.out.println("Invalid");
            
            }
            
              
        }
    
    }
    
    public static void searchPayRoll(){
        
        Scanner sc = new Scanner(System.in);
        //Search entered
        System.out.println("Enter ID");
        String input = sc.nextLine().trim();
        String file = "payroll.csv";
        boolean found = false;
        //This is the preparation 
        
        try(BufferedReader br = new BufferedReader (new FileReader (file))){
            String line; 
            
            while((line = br.readLine()) != null ){
                
                String[] columns = line.split(","); // 3. Split the row

                // 4. Compare Scanner input to the first column of the CSV
                if (columns.length > 0 && columns[0].trim().equalsIgnoreCase(input)) {
                    System.out.println("\n--- Record Found ---");
                    System.out.println("ID: " + columns[0]);
                    System.out.println("Name: " + columns[1]);
                    System.out.println("Birthday: " + columns[2]);
                    System.out.println("Cut Off Date June 1 to June 15");
                    System.out.println("Total Hours worked: " + columns[3] +"Hours");
                    System.out.println("Gross Salary: " + columns[4]);
                    System.out.println("Net Salary: " + columns[5]);
                    System.out.println("");
                    
                    //this is for the June 1 to June 15
                    System.out.println("ID: " + columns[0]);
                    System.out.println("Name: " + columns[1]);
                    System.out.println("Birthday: " + columns[2]);
                    System.out.println("Cut Off June 16 to June 30");
                    System.out.println("Gross Salary " + columns[4]);
                    System.out.println("Deductions ");
                    System.out.println("Pag Ibig 4%");
                    System.out.println("PhilHealth 3%");
                    System.out.println("SSS -1,125");
                    System.out.println("-2,500 25% excess tax");
                           
                    //Deductions
                    /*
                    4% Pag Ibig
                    3% of PhilHealth
                    1,125 SSS
                    2,500 over 33,333-66,667 with 25% Excess Tax
                    */
                    
                    int salary = Integer.parseInt(columns[4].trim());
                    
                    double ibigHealth = salary *0.07;
                    
                    double sssDeduct = 1125;
                    double afterTax = salary - 2500;
                    double getExcess = (salary - afterTax)*0.25;
                    double totalDeductions = ibigHealth + sssDeduct + getExcess;
                    
                    double afterDeductions = salary - ibigHealth - sssDeduct - getExcess;
                    
                    columns[5] = String.valueOf(afterDeductions);
                    System.out.println("Total Deductions: " + totalDeductions );
                    System.out.println("Gross Salary: " + columns[5]);
                    
                    
                    found = true;
                    break; 
                }
                
            }
            
        }catch(IOException e){
            System.out.println("not found ");
        }
        if(!found){
            System.out.println("Did not exist in " + file);
        
        }
        
        
    }
    
    
    
    
    
}
