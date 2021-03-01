/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLayer;

import java.io.*;
import java.util.*;
import DAL.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
/**
 *
 * @author Picaso
 */
public class clients {
    //Variable declarations.
    private int orderNumber;
    private String address;
    private String eventType;
    private Date date;
    private int time;
    private int amountOfPeople;
    private String theme;
    private String decorations;
    private String foodSelection;
    private Double price;
    private Double confirmationPrice;
    private boolean discountFlag = false;
    
    //Set variables.
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public void setEventType(String eventType)
    {
        this.eventType = eventType;
    }
    
    public void setDate(Date date)
    {
        this.date = date;
    }
    
    public void setTime(int time)
    {
        this.time = time;
    }
    
    public void setAmountOfPeople(int amountOfPeople)
    {
        this.amountOfPeople = amountOfPeople;
    }
    
    public void setTheme(String theme)
    {
        this.theme = theme; 
    }
    
    public void setDecorations(String decorations)
    {
        this.decorations = decorations;
    }
    
    public void setFoodSelection(String foodSelection)
    {
        this.foodSelection = foodSelection;
    }
    
    public void setPrice(Double price)
    {
        this.price = price;
    }
    
    //Get variables.
    public int getOrderNumber() {
        return orderNumber;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public String getEventType()
    {
        return eventType;
    }
    
    public Date getDate()
    {
        return date;
    }
    
    public int getTime()
    {
        return time;
    }
    
    public int getAmountOfPeople()
    {
        return amountOfPeople;
    }
    
    public String getTheme()
    {
        return theme;
    }
    
    public String getDecorations()
    {
        return decorations;
    }
    
    public String getFoodSelection()
    {
        return foodSelection;
    }
    
    public Double getPrice()
    {
        return price;
    }
    
    //Create clients method.
    public clients()
    {
        
    }
    
    public clients(int orderNumber, String address, String eventType, String date, int time, int amountOfPeople, String theme, String decorations, String foodSelection, Double price) throws ParseException
    {
        this.orderNumber = orderNumber;
        this.address = address;
        this.eventType = eventType;
        this.date = new SimpleDateFormat("MM/dd/yyyy").parse(date);
        this.time = time;
        this.amountOfPeople = amountOfPeople;
        this.theme = theme;
        this.decorations = decorations;
        this.foodSelection = foodSelection;
        this.price = price;
    }
    
    //Create list which contains all if the clients data.
    public List<clients> cleintsData() throws FileNotFoundException, ParseException
    {
        clientsDAL clientsData = new clientsDAL();
        
        List<clients> clientsList = clientsData.GetClients();
        
        if(clientsList.isEmpty())
        {
            return clientsList;
        } else 
        {
            return null;
        }
    }
    
    public int calcOrdeNumber() throws FileNotFoundException, ParseException
    {
        int count = 0;
        
        clientsDAL clientsData = new clientsDAL();
        List<clients> clientsList = clientsData.GetClients();
        
        for(int i = 0; i >= clientsList.size(); i++)
        {
            count++;
        }
        
        orderNumber = count;
        
        return orderNumber;
    }
    
    public Double Discount(int amountOfPeople) {
        Scanner scanner = new Scanner(System.in);
        double pricing = 20.00;//just for testing
        price = amountOfPeople * pricing;
        System.out.println("How many people will attend?");
                amountOfPeople=scanner.nextInt();
        if (amountOfPeople > 40) {
            discountFlag=true;
            double answer = price - (15 / 100 * price);
            price=answer;
        }
        else{
            discountFlag=false;
        }
        if (discountFlag) {
                    System.out.println("You qualified for the discount");
                }
        return price;
    }
    
    public Double calcConfirmationPrice()
    {
        confirmationPrice = price - (50 / 100 * price);
        
        return confirmationPrice;
    }
    
    //Calculation class creation.
    public void Calc() throws ParseException, FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please give the date in the following format: MM/dd/yyyy");
        Date userdate = new SimpleDateFormat("MM/dd/yyyy").parse(scanner.nextLine());

        //getting day of date
        SimpleDateFormat dfDay = new SimpleDateFormat("dd");
        String strDay = dfDay.format(userdate);//converts day of date to string      
        int intDay = Integer.parseInt(strDay);//converts string to int

        //getting month of date
        SimpleDateFormat dfMonth = new SimpleDateFormat("MM");
        String strMonth = dfMonth.format(userdate);
        int intMonth = Integer.parseInt(strMonth);

        //getting year of date
        SimpleDateFormat dfYear = new SimpleDateFormat("yyyy");
        String strYear = dfYear.format(userdate);
        int intYear = Integer.parseInt(strYear);

        //Getting current date
        Date ThisDate = new Date();
        LocalDate localDate = ThisDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int intThisDay = localDate.getDayOfMonth();//current day
        int intThisMonth = localDate.getMonthValue();
        int intThisYear = localDate.getYear();

        int calDay = intDay - intThisDay;//day after calculations
        int calMonth = intMonth - intThisMonth;
        int calYear = intYear - intThisYear;
        calcOrdeNumber();
        Discount(amountOfPeople);
        if (calYear < 0) {
            System.out.println("You can't book in the past");
        } else if (calYear == 0) {
            if (calMonth < 0) {
                System.out.println("You can't book in the past");
            } else if (calMonth == 0) {

                if (calDay < 0) {
                    System.out.println("You can't book in the past");
                } else if (calDay == 0) {
                    System.out.println("You can't book on current day");
                } else if (calDay >= 15) {
                    calcConfirmationPrice();
                }
            } else {
                calcConfirmationPrice();
            }
        } else {
            calcConfirmationPrice();
        }
    }
}
