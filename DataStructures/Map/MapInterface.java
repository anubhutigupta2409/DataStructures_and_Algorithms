/*
A map interface represents mapping between a key and a value . It is not a subtype of collections framework therefore, it behaves
a bit different from it's subtypes. A Map contains unique keys.

About Map
1. A Map cannot contain duplicate keys and a key can map to atmost one value. HashMap and LinkedHashMap implementation allows null
key and null value while TreeMap doesnot.
2.TreeMap and LinkedHashMap have a predictable order while HashMap doesnot.

*/

import java.util.*;
import java.util.Map.Entry;

public class MapInterface
{
	public static void main(String args[])
	{
		//Example of using Map using the class HashMap
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("A",new Integer(24));
		map.put("H",28);
		map.put("P",6);
		map.put("M",16);
		//traversing using the Entry class and the entrySet()
		for(Entry<String,Integer> x : map.entrySet())
		{
			System.out.println(x.getKey()+" : "+x.getValue());
		}
		//printing as it is
		System.out.println("Map= "+map);
		//performing all the methods
		map.put("P",24);//if the key is already present the value is updated
		System.out.println(map);
		map.putIfAbsent("P",6);//if the key is already not associated with any value then change otherwise don't
		System.out.println(map);
		//get(K) returns the value correponding to the key and if key not present returns null
		System.out.println("For key:\"P\"= "+map.get("P")+" ,For key:\"B\"= "+map.get("B"));
		//getOrDefault(K,defaultVale) returns the value correponding to the key and if key not present returns defaultValue
		//passed as argument
		System.out.println("For key:\"P\"= "+map.getOrDefault("P",1)+" ,For key:\"B\"= "+map.getOrDefault("B",1));
		//to check if key is present or not
		System.out.println("Key P present: "+map.containsKey("P")+",Key B present: "+map.containsKey("B"));
		//if value is present or not
		System.out.println("Value 24 present: "+map.containsValue(24)+",Value 16 present: "+map.containsValue(16)+",Value 6 present: "+map.containsValue(6)+",Value 1 present: "+map.containsValue(1));

		//replacing values
		System.out.println("Map= "+map);
		map.replace("P",6);
		System.out.println("Changed:\n"+map);
		//replace(k,oldValue,newvalue)-->replaces the value only if our key was associated with the oldValue
		map.replace("P",7,24);
		System.out.println(map);
		map.replace("P",6,24);
		System.out.println("Changed:\n"+map);

		//removing
		map.remove("P");
		System.out.println("Changed:\n"+map);
		map.remove("M",16);
		System.out.println("Changed:\n"+map);

		//printing different sets
		System.out.println("Key Set="+map.keySet());
		System.out.println("Value Set="+map.values());
		System.out.println("Entry Set="+map.entrySet());
	}
}