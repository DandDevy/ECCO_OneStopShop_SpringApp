package ecco.onestopshop.models;

import java.util.Arrays;
import java.util.HashMap;

import org.hibernate.mapping.Set;


public class CounterEnergy 
{
	private String[] ENERGY_TYPE = new String[]{"Wind", "PV", "Hydro", "Manure","Chips", "Sawdust"};	
	private HashMap<String, Integer> counters;
	public CounterEnergy()
	{
		counters = new HashMap<>();	
		for(String energyposibility: ENERGY_TYPE)
		{
			counters.put(energyposibility, 0);	
		}
	}
	
	public void addPoints(String replayFromUser) 
	{
		String[] splittedReply = replayFromUser.split("@");
		
		if(Arrays.asList(ENERGY_TYPE).contains(splittedReply[0]))
		{
			counters.put(splittedReply[0], counters.get(splittedReply[0]) + Integer.parseInt(splittedReply[1]));
		}
		
		
	}
	
	public String getAccurateEnergy() 
	{
		String energyType = "";
		int maxPoints = Integer.MIN_VALUE;
		
		return counters.keySet().stream()
		.reduce( "" ,(tempMax, current )->  tempMax==""? current: (counters.get(current)> counters.get(tempMax)? current: tempMax ));
		
		
		
	}
	
	
}
