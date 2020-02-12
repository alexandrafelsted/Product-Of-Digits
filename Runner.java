package Package;

import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		//first input determines the amout of tests desired to input
		System.out.println("Enter the number of cases: ");
		int cases = in.nextInt();
		
		for (int i = 0; i < cases;i++) {
			System.out.println("Enter the number to test: ");
			int n = in.nextInt();
			//returns the prime factors of the number 'n'
			ArrayList<Integer> numbers = getPrimes(n);
			
			
			//if numbers is null that means the number is prime and we print -1
			if (numbers==null)
			{
				System.out.println(-1);
			}
			else//otherwise we will consolidate the primes into the optimal numbers and 
			{//print out the answer
				int smallest = consolidate(numbers);
				System.out.println(smallest);
			}
			
		}
	}//end of the main function
	
	/**
	 * This will consolidate an array of primes into the least amount of digits with the smallest values
	 * @param x the array to consolidate 
	 * @return a number in increasing order with the optimal digits
	 */
	public static int consolidate(ArrayList<Integer> x){
		
		//new array list to store new factors
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = x.size()-1; i >=0; i--)
		{
			if (x.get(i)>=5)
			{//if the number is too large to be multiplied, we add it to new array
				numbers.add(x.get(i));
			}
			else//
			{
				
				int temp = x.get(i);//store current element
				int count = 0;//position relative to i to check
				while (temp<6  &&  i>=count+1)
				{
					if (x.get(i-count)*temp<10)
					{
						count++;
						temp = temp * x.get(i-count);
						
					}
					
				}
				numbers.add(temp);
				i = i - count;
			}
		}
		
		
		//now get the array in increasing order
		
		numbers.sort(null);
		
		
		
		
		
		
		
		//turning the array list into an integer
		String tempNum = "";
		for (int i = 0; i < numbers.size();i++)
		{
			String temp = Integer.toString(numbers.get(i));
			tempNum = tempNum + temp;
			
		}
		
		int W = Integer.parseInt(tempNum);
		
		return W;
	}
	public static ArrayList<Integer> getPrimes(int N) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		boolean going = true;
		if (N>9)
		{
			while (going && N%2==0)//even
			{
			N = N/2;
			numbers.add(2);
			if (N<10)
			{
				numbers.add(N);
				N = 1;
				going = false;
			}
			
			}
			//now its not divisable by 2
			
			while(going && N%3==0)
			{
				N = N/3;
				numbers.add(3);
				if (N<10)
				{
					numbers.add(N);
					N = 1;
					going = false;
				}
			}
			
			while(going && N%5==0)
			{
				N = N/5;
				numbers.add(5);
				if (N<10)
				{
					numbers.add(N);
					N = 1;
					going = false;
				}
			}
			
			while(going && N%7==0)
			{
				N = N/7;
				numbers.add(7);
				if (N<10)
				{
					numbers.add(N);
					N = 1;
					going = false;
				}
			}
		
		}
		else
		{
			numbers.add(N);
		}
		
		
		
		
		if (N!=1)
		{
			return null;
		}
		
		return numbers;	
		
	}
}

