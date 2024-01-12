package practice;

import java.util.*;
import java.util.Map.Entry;

public class New111 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> m=new HashMap();
		HashMap<String, Integer> h = new HashMap<String, Integer>();
		h.put("thar", 100);
		h.put("bgbsgjd", 20);
		h.put("css", 1);
		//System.out.println(h);
		List<Map.Entry<String, Integer>> l1 = new ArrayList<>(h.entrySet());
		System.out.println(l1);

		Collections.sort(l1, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
				// TODO Auto-generated method stub
				System.out.println(e1.getValue());
				System.out.println(e2.getValue());
				System.out.println(e1.getValue() - e2.getValue());
				return e1.getValue() - e2.getValue();
			}
		});
		/*
		 * for(Map.Entry<String,Integer> e:l1) {
		 * System.out.println(e.getKey()+" "+e.getValue()); }
		 */
		System.out.println(l1);
//[1,100,20]
	}

}
