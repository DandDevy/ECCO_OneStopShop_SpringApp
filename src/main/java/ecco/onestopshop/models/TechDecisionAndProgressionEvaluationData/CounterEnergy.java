/*
 * written by Daniel Ashcroft
 */

package ecco.onestopshop.models.TechDecisionAndProgressionEvaluationData;

import java.util.Arrays;
import java.util.HashMap;

import org.hibernate.mapping.Set;


/**
 * 
 * @author Eduardo Lamas Suárez
 * Class used to process the answers selected by the user
 * and being able to predict which energy type would fit him better
 * 
 *
 */
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
	
	/**
	 * Method that adds poing to an energy type counter
	 * @param replayFromUser, String with the response of the user, coded
	 */
	public void addPoints(String replayFromUser) 
	{
		String[] splittedReply = replayFromUser.split("@");
		
		if(Arrays.asList(ENERGY_TYPE).contains(splittedReply[0]))
		{
			counters.put(splittedReply[0], counters.get(splittedReply[0]) + Integer.parseInt(splittedReply[1]));
		}
		
		
	}
	
	/**
	 * Method that returns which energy type is more accurate for the user
	 * @return String with the energy type
	 */
	public String getAccurateEnergy() 
	{
		String energyType = "";
		int maxPoints = Integer.MIN_VALUE;
		
		return counters.keySet().stream()
		.reduce( "" ,(tempMax, current )->  tempMax==""? current: (counters.get(current)> counters.get(tempMax)? current: tempMax ));
		
		
		
	}
	
	
}
