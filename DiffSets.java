
import java.util.*;
import javax.sound.midi.*;
import java.net.*;

public class DiffSets
{
	public static void main(String[] args)
	{	
		int a =  Integer.parseInt(args[0]);
		int b =  Integer.parseInt(args[1]);
		int iter = Integer.parseInt(args[2]);
//		int a = 10;
//		int b = 20;
//		int iter = 3;
		int maxValue = Math.max(a, b);
		System.out.println("a = "+a+ "  b = "+b);
//		System.out.println("b = "+b);
		float average_time = 0;
		float sum_time = 0;
		for (int n =0; n< iter; n++) 
		{
			List<Integer> listA = new ArrayList<Integer>();
			List<Integer> listB = new ArrayList<Integer>();
			for (int i=0; i<a; i++) 
			{
				listA.add((int)(Math.random() * maxValue));
			}
			for (int i=0; i<b; i++) 
			{
				listB.add((int)(Math.random() * maxValue));
			}
//			System.out.println("ListA: "+listA);
//			System.out.println("ListB "+listB);
//			System.out.println("Diffset: "+ getDiff(listA, listB));
			long st = System.nanoTime();
			getDiff(listA, listB);
			sum_time = sum_time + (System.nanoTime()-st);
			
		}
		average_time = sum_time/iter;
		System.out.println(average_time);
	}


	 private static List<Integer> getDiff(List<Integer> list1, List<Integer> list2) {
//		  long st = System.nanoTime();
			List<Integer> diff = new ArrayList<Integer>();
			List<Integer> maxList = list1;
			List<Integer> minList = list2;
			if(list2.size()>list1.size())
			{
				 maxList = list2;
				 minList = list1;
			}
			Map<Integer,Integer> map = new HashMap<Integer,Integer>(maxList.size());
			for (Integer inte : maxList) {
				 map.put(inte, 1);
			}
			for (Integer inte : minList) {
				 if(map.get(inte)!=null)
				 {
					  map.put(inte, 2);
					  continue;
				 }
				 diff.add(inte);
			}
			for(Map.Entry<Integer, Integer> entry:map.entrySet())
			{
				 if(entry.getValue()==1)
				 {
					  diff.add(entry.getKey());
				 }
			}
//		  System.out.println("total times "+(System.nanoTime()-st));
		  return diff;
		  
	 }
}