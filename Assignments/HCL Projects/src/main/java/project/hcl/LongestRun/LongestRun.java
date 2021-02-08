package project.hcl.LongestRun;

import java.util.ArrayList;
import java.util.Scanner;

public class LongestRun {
	private Sequence sequence;
	private ArrayList<ArrayList<Integer>> longestRuns; 
	
//	public void setSeq(Sequence s) {
//		seq = s;
//	}
	
	public Sequence getSequence() {
		return sequence;
	}
	
	public void getSeqInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("ArrayList Size (Input 0 for a random size)");
		System.out.println("Size: ");
		int s = scan.nextInt();
		
		sequence = new Sequence(s);
		sequence.buildSequence();
	}
	
	public void searchSequence() {
		System.out.println("Sequence: " + sequence.getSequence());
		int seqSize = sequence.getSize();
		int tempStart = 0;
		int start = 0;
		int end = 0;
		int tempLongestSeq = 0;
		int longestSeq = 0;
		boolean running = false;
		ArrayList<Integer> seq = sequence.getSequence();
		
//		for(int i = 0; i < seqSize; i = i + tempLongestSeq) {
//			if(i+tempLongestSeq<seqSize) {
//				if(seq.get(i) <= seq.get(i+tempLongestSeq)) {
//					tempLongestSeq++;
//				}
//			}
//		}
		
		for(int i = 0; i< seqSize; i++) {
			if(i + 1 < seqSize) {
				if(seq.get(i) < seq.get(i+1)) {
					tempLongestSeq++;
					System.out.println(seq.get(i) + ", " + seq.get(i+1) + " Temp Longest: " + tempLongestSeq + " Real Longest" + longestSeq);
					if(!running) {
						tempStart = i;
					}
					running = true;
				}else if(running && (tempLongestSeq > longestSeq)) {
					System.out.println("Big run");
					start = tempStart;
					longestSeq = tempLongestSeq;
					tempLongestSeq = 0;
					running = false;
					end=i;
				} else {
					tempLongestSeq = 0;
					running = false;
				}
			}
		}
		System.out.println("Start" + start + "End" + end);
		System.out.println("Longest Subsequence: " + seq.subList(start, end+1));
	}
	
}