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
    private String address;
    private String eventType;
    private Date date;
    private int time;
    private int amountOfPeople;
    private String theme;
    private String decorations;
    private String foodSelection;
    private Double price;
    
    //Set variables.    
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
    
    public void setFoodSelections(String foodSelection)
    {
        this.foodSelection = foodSelection;
    }
    
    public void setPrice(Double price)
    {
        this.price = price;
    }
    
    //Get variables.    
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
    
    public String getFoodSelections()
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
    
    public clients(String address, String eventType, String date, int time, int amountOfPeople, String theme, String decorations, String foodSelection, Double price) throws ParseException
    {
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
}
