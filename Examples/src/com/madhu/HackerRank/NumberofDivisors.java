/**
 * 
 */
package com.madhu.HackerRank;

/**
 * @author ramachandranm1
 *
 */
import java.util.*;
interface AdvancedArithmetic{
  int divisor_sum(int n);
}

//Write your code here
class MyCalculator implements AdvancedArithmetic{

	@Override
	public int divisor_sum(int n) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i=1;i<=Math.sqrt(n);i++) {
			if(n%i==0)
			{
				System.out.println(String.format("i=%d, n/i=%d", i, n/i));
				if(n/i==i)
					sum += i;
				else
					sum = sum + i + n/i;
			}
		}
		return sum;
	}
	
}
class NumberofDivisors{
    public static void main(String []args){
        MyCalculator my_calculator = new MyCalculator();
        System.out.print("I implemented: ");
        ImplementedInterfaceNames(my_calculator);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(my_calculator.divisor_sum(n) + "\n");
      	sc.close();
    }
    /*
     *  ImplementedInterfaceNames method takes an object and prints the name of the interfaces it implemented
     */
    static void ImplementedInterfaceNames(Object o){
        Class[] theInterfaces = o.getClass().getInterfaces();
        for (int i = 0; i < theInterfaces.length; i++){
            String interfaceName = theInterfaces[i].getName();
            System.out.println(interfaceName);
        }
    }
}


