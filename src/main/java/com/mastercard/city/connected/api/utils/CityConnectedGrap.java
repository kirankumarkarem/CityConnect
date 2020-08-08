/**
 * 
 */
package com.mastercard.city.connected.api.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mastercard.city.connected.api.models.CityConnectedNode;

/**
 * @author Kirankumar K
 *
 */
public class CityConnectedGrap {
	private static final Logger logger = LoggerFactory.getLogger(CityConnectedGrap.class);

	public HashMap<CityConnectedNode, LinkedList<CityConnectedNode>> adjMap;
	private HashSet<String> distinctCities;

	public CityConnectedGrap() {
		adjMap = new HashMap<>();
		distinctCities = new HashSet<>();
	}

	public void insert(CityConnectedNode city1, CityConnectedNode city2) {
		if (adjMap.size() == 0) {
			adjMap.put(city1, new LinkedList<>());
			adjMap.put(city2, new LinkedList<>());
		}

		boolean found1 = false;
		boolean found2 = false;

		for (CityConnectedNode n : adjMap.keySet()) {
			if (city1.getCityName().equals(n.getCityName()) && !found1) {
				adjMap.get(n).add(city2);
				found1 = true;
			}
		}
		if (!found1) {
			LinkedList<CityConnectedNode> temp = new LinkedList<>();
			temp.add(city2);
			adjMap.put(city1, temp);
		}

		for (CityConnectedNode n : adjMap.keySet()) {
			if (city2.getCityName().equals(n.getCityName()) && !found2) {
				adjMap.get(n).add(city1);
				found2 = true;
			}
		}
		if (!found2) {
			LinkedList<CityConnectedNode> temp = new LinkedList<>();
			temp.add(city1);
			adjMap.put(city2, temp);
		}
	}

	public int numberOfNodes() {
		for (CityConnectedNode n : adjMap.keySet()) {
			String city = n.getCityName().replaceAll("\\s", "");
			distinctCities.add(city);
		}
		return distinctCities.size();
	}

	public boolean hasEdge(CityConnectedNode city1, CityConnectedNode city2) {
		return adjMap.containsKey(city1) && adjMap.get(city1) != null && adjMap.get(city1).contains(city2);
	}

	public void printGraph() {
		for (CityConnectedNode root : adjMap.keySet()) {
			logger.info("Traversing from node " + root.getCityName() + " - ");
			LinkedList<CityConnectedNode> destinations = adjMap.get(root);
			if (destinations != null) {
				for (CityConnectedNode adjacent : adjMap.get(root)) {
					logger.info("Adjacent City Name" + adjacent.getCityName() + " ");
				}
			}

		}
	}

}
