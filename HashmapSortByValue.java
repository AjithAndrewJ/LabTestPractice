package library;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;

public class HashmapSortByValue {
	public static void main(String[] args) {
		
		HashMap<String,Integer> user = new HashMap<String,Integer>();
		 
        user.put("Alan",4);
        user.put("Ajith Andrew",2);
        user.put("Jagan",5);
        user.put("Manikandan",1);
        user.put("Rohit",3);
        
        List<Map.Entry<String,Integer> > list = new LinkedList<Map.Entry<String,Integer>>(user.entrySet());
        
	    Collections.sort(list,(o1,o2) -> o1.getValue().compareTo(o2.getValue()));
	
	    HashMap<String,Integer> user1 = new LinkedHashMap<String,Integer>();
	    
	    for (Map.Entry<String,Integer> a : list) {
	        user1.put(a.getKey(),a.getValue());
	    }
	         
        for (Map.Entry<String, Integer> en : user1.entrySet()) {
            System.out.println("Key = " + en.getKey() +", Value = " + en.getValue());
        }
    }
}
