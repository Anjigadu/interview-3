package com.dreamworks.restworks.interview.snap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class MergeInterval {

	public void mergeIntervals(List<Interval> listInterval)
	{

		// sort by start time (ascending order)
		Collections.sort(listInterval, new IntervalComparator());

		for(Interval i : listInterval) {
			System.out.println(i.start + " -> " + i.end);
		}

		Stack<Interval> stack = new Stack<>();
		
		stack.push(listInterval.get(0));
		
		for(int i=1; i< listInterval.size(); i++) {
			Interval itv = stack.peek();
			
			if(itv.end < listInterval.get(i).start){
				stack.push(listInterval.get(i));
			}
			else{
				itv.end = listInterval.get(i).end;				
			}
		}

		System.out.println("\n* Merged Intervals ");
		while(!stack.isEmpty()) {
			
			Interval i = stack.pop();
			System.out.println(i.start + " -> " + i.end);
		}		
	}

	class IntervalComparator implements Comparator<Interval>{  

		@Override
		public int compare(Interval interval1, Interval interval2) {

			if(interval1.start == interval2.start) {
				return 0;
			}
			else if(interval1.start > interval2.start) {
				return 1;
			}
			else{
				return -1;
			}
		}
	}
	
	public static void main(String[] args) {
		
		List<Interval> listInt = new ArrayList<Interval>();
		listInt.add(new Interval(1,3));
		listInt.add(new Interval(6,8));
		listInt.add(new Interval(5,7));
		listInt.add(new Interval(2,4));
		
		MergeInterval mi = new MergeInterval();
		mi.mergeIntervals(listInt);
	}

}
