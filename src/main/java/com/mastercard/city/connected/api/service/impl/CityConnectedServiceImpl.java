/**
 * 
 */
package com.mastercard.city.connected.api.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.mastercard.city.connected.api.constants.CityConnectedConstants;
import com.mastercard.city.connected.api.exceptions.CityConnectedApplicationException;
import com.mastercard.city.connected.api.models.CityConnectedNode;
import com.mastercard.city.connected.api.service.CityConnectedService;
import com.mastercard.city.connected.api.utils.CityConnectedGrap;

/**
 * @author Kirankumar K
 *
 */

@Service
public class CityConnectedServiceImpl implements CityConnectedService{
	
	public String getCityConnected(String origin, String destination) throws CityConnectedApplicationException
	{
		return readCityConnectedFile(origin,destination);
	}

	private String readCityConnectedFile(String origin, String destination) throws CityConnectedApplicationException {
		String results=null;
		try {
			File source=new File("City.txt");
			Scanner scanner=new Scanner(source);
			CityConnectedGrap cityConnectedGrap=createCityConnectedGrap(scanner);
			CityConnectedNode city1=new CityConnectedNode(origin);
			CityConnectedNode city2=new CityConnectedNode(destination);
			if(checkConnection(cityConnectedGrap,city1,city2))
				results=CityConnectedConstants.YES;
			else
					results=CityConnectedConstants.No;
		} catch (FileNotFoundException e) {
			throw new CityConnectedApplicationException(e);
		}
		return results;
	}

    public static CityConnectedGrap createCityConnectedGrap(Scanner scanner) throws CityConnectedApplicationException {
    	CityConnectedGrap graph = new CityConnectedGrap();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] cities = line.split(", ");
            if(cities.length <2)
            {
            	throw new CityConnectedApplicationException("File length should be more than equal 2");
            }
            CityConnectedNode city1 = new CityConnectedNode(cities[0]);
            CityConnectedNode city2 = new CityConnectedNode(cities[1]);
            graph.insert(city1, city2);
        }
        return graph;
    }
    
    public static boolean checkConnection(CityConnectedGrap graph, CityConnectedNode city1, CityConnectedNode city2) throws CityConnectedApplicationException {
        if (city1.getCityName().equals(city2.getCityName())) return true;
        
        CityConnectedNode firstNode = new CityConnectedNode(city1.getCityName());
        CityConnectedNode secondNode = new CityConnectedNode(city2.getCityName());
        for (CityConnectedNode n : graph.adjMap.keySet()) {
            if (city1.getCityName().equals(n.getCityName())) {
                firstNode = n;
            }
            if (city2.getCityName().equals(n.getCityName())) {
                secondNode = n;
            }
          
        }

       
        Queue<CityConnectedNode> queue = new LinkedList<CityConnectedNode>();
        queue.add(firstNode);
        HashMap<CityConnectedNode, Boolean> visited = new HashMap<>();
        for (CityConnectedNode n : graph.adjMap.keySet()) {
            visited.put(n, false);
        }
        visited.put(firstNode, true);

        while (!queue.isEmpty()) {
        	 if(!graph.adjMap.containsKey(secondNode) || !graph.adjMap.containsKey(firstNode))
             {
             	throw new CityConnectedApplicationException("City names doesn't match with the given file");
             }
            if (visited.get(secondNode)) {
                return true;
            }
            CityConnectedNode curr = queue.poll();
            Iterator<CityConnectedNode> iter = graph.adjMap.get(curr).iterator();
            while (iter.hasNext()) {
            	CityConnectedNode next = iter.next();
            	CityConnectedNode nextNode = new CityConnectedNode(next.getCityName());
                for (CityConnectedNode n : graph.adjMap.keySet()) {
                    if (next.getCityName().equals(n.getCityName())) {
                        nextNode = n;
                    }
                }
                if (!visited.get(nextNode)) {
                    queue.add(nextNode);
                    visited.put(nextNode, true);
                }
            }
        }
        return false;
    }


}
