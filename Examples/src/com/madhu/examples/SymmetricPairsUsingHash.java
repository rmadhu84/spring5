/**
 * 
 */
package com.madhu.examples;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ramachandranm1
 *
 */
public class SymmetricPairsUsingHash {

	static final int H = 5;
	static final int W = 2;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int inputArr[][] = new int[H][W];
		inputArr[0][0] = 1;inputArr[0][1] = 2;
		inputArr[1][0] = 2;inputArr[1][1] = 1;
		inputArr[2][0] = 3;inputArr[2][1] = 4;
		inputArr[3][0] = 4;inputArr[3][1] = 3;
		inputArr[4][0] = 5;inputArr[4][1] = 2;
		
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				System.out.print(inputArr[i][j]);
				if(j==W-1)
					continue;
				else 
					System.out.print(",");
			}
			System.out.println();
		}
		
		symCheck(inputArr);

	}
	private static void symCheck(int[][] inputArr) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0;i<H;i++) {
			for(int j = 0 ;j<W;j++) {
				
				if(map.containsKey(inputArr[i][j+1])) {
					int a = map.get(inputArr[i][j+1]);
					if(inputArr[i][j] == a) {
						System.out.println(inputArr[i][j]+","+inputArr[i][j+1]);
					}
						
				}else {
					map.put(inputArr[i][j], inputArr[i][++j]);
				}
				if(j==W-1)
					continue;
			}
		}
		
		
	}

}
