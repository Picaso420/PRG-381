/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Picaso
 */
public class UI {
    
    
    public enum NewEnum {
    Enter,
    View,
    Change,
    Cancel,
    Exit
    }
    
    

    public static void main (String [] args){
        
        boolean Loop = true;
        int Counter = 0;
        List<String> EventList = new ArrayList<String>();
        while (Loop = true) {
            
      System.out.println("----------------------------------------------------------------------");
      System.out.println("\t \t MENU");
      System.out.println("----------------------------------------------------------------------");
      System.out.println("\t 1. Enter a new event.");
      System.out.println("\t 2. view a event.");
      System.out.println("\t 3. change a event.");
      System.out.println("\t 4. cancel a event.");
      System.out.println("\t 5. Exit program");
      System.out.println("----------------------------------------------------------------------");
      System.out.println("\t Please chose a number:");
      System.out.println("----------------------------------------------------------------------");
      
      
      
      Scanner Input = new Scanner(System.in);
      
      String line = Input.nextLine();
      
      
      
           switch(line)
      {
          case "1":
                Counter++;
                System.out.println("\t \t Enter a new event: ");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("Type of event?");
                String TypeEvent = Input.nextLine();
                System.out.println("Date and time?");
                String DateTime = Input.nextLine();
                System.out.println("Venue Address?");
                String VenueAddress = Input.nextLine();
                System.out.println("Total number of people?");
                String NumPeople = Input.nextLine();
                System.out.println("Food Selection?");
                String FoodSelect = Input.nextLine();
                System.out.println("Decorations?");
                String Deco = Input.nextLine();
                System.out.println("----------------------------------------------------------------------");
                EventList.add(Counter + "@" + TypeEvent + "#" + DateTime + "$" + VenueAddress + "%" + NumPeople + "^" + FoodSelect + "*" + Deco);
                System.out.println(EventList.get(0));
      
                break;
          case "2":
                String temp = "";
                int temp2 = 0;
                System.out.println("\t \t View a event: ");
                System.out.println("----------------------------------------------------------------------");
                String num =  String.valueOf(Counter);
                System.out.println("\t \t Please enter order number: ");
                System.out.println("----------------------------------------------------------------------");             
                int OrderNumberView = Input.nextInt();
                for (int i = 0; i < EventList.size(); i++) {
                    temp = EventList.get(i);
                    int pos = temp.indexOf("@");
                    temp2 = Integer.parseInt(temp.substring(0,pos));
                    System.out.println(temp2);
                    if (temp2 == OrderNumberView){
                         System.out.println(EventList.get(i));
                    }                                    
                }
      
                break;
          case "3":
                String Ctemp = "";
                String Ctemp2 = "";
                System.out.println("\t \t Change a new event: ");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("\t \t Please enter order number: ");
                System.out.println("----------------------------------------------------------------------");
                String OrderNumberChange = Input.nextLine();
                String change =  String.valueOf(OrderNumberChange);
                for (int i = 0; i < EventList.size(); i++) {
                    Ctemp = EventList.get(i);
                    int pos = Ctemp.indexOf("@");
                    Ctemp2 = Ctemp.substring(0,pos);
                    if (Ctemp2 == OrderNumberChange){
                         EventList.remove(i);
                    }                   
                  
                }
                System.out.println("Type of event?");
                String TypeEventChange = Input.nextLine();
                System.out.println("Date and time?");
                String DateTimeChange = Input.nextLine();
                System.out.println("Venue Address?");
                String VenueAddressChange = Input.nextLine();
                System.out.println("Total number of people?");
                String NumPeopleChange = Input.nextLine();
                System.out.println("Food Selection?");
                String FoodSelectChange = Input.nextLine();
                System.out.println("Decorations?");
                String DecoChange = Input.nextLine();
                System.out.println("----------------------------------------------------------------------");
                EventList.add(Counter + "@" + TypeEventChange + "#" + DateTimeChange + "$" + VenueAddressChange + "%" + NumPeopleChange + "^" + FoodSelectChange + "*" + DecoChange);
                
                break;
          case "4":
                String CLtemp = "";
                String CLtemp2 = "";
                System.out.println("\t \t Cancel a event: ");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("\t \t Please enter order number: ");
                System.out.println("----------------------------------------------------------------------");
                String OrderNumberCancel = Input.nextLine();               
                for (int i = 0; i < EventList.size(); i++) {
                    CLtemp = EventList.get(i);
                    int pos = CLtemp.indexOf("@");
                    CLtemp2 = CLtemp.substring(0,pos);
                    if (CLtemp2 == OrderNumberCancel){
                         System.out.println(EventList.get(i));
                    } 
                }
                
                break;
          case "5":
                Loop = false;
                System.exit(0);
           
                break;
      }

       
     }
    
   }
}
