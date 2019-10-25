package com.madhu.examples;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> i = new ArrayList<Integer>();
		i.add(10);
		i.add(20);
		i.add(30);
		StringBuilder b = new StringBuilder();
		b.append("(");
		Iterator it = i.iterator();
		while (it.hasNext()) {
			b.append(it.next());
			
			if(it.hasNext())
				b.append(",");
		}
		b.append(")");
		System.out.println(b.toString());
	}

}
