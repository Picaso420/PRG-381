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
            clientsList.add(new clients(Integer.parseInt(line[0]), line[1], line[2], line[3], Integer.parseInt(line[4]), Integer.parseInt(line[5]), line[6], line[7], line[8], Double.parseDouble(line[9])));
	}
        
	return clientsList;
    }
}
