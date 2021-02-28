/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import businessLayer.*;
import java.text.ParseException;

/**
 *
 * @author Picaso
 */
public class clientsDAL {
    public List<clients> GetClients() throws FileNotFoundException, ParseException
    {
        List<clients> clientsList = new ArrayList<>();	
        File file = new File("C:\\Users\\user-pc\\Documents\\clients.txt");
	Scanner sc = new Scanner(file);
	
        while(sc.hasNextLine())
	{         
            String[] line = sc.nextLine().split(",");
            //SimpleDateFormat dt = new SimpleDateFormat("MM/dd/yyyy");
            
            clientsList.add(new clients(line[0], line[1], line[2], Integer.parseInt(line[3]), Integer.parseInt(line[4]), line[5], line[6], line[7], Double.parseDouble(line[8])));
	}
        
	return clientsList;
    }
}
