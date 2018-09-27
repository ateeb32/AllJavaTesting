package com.qa.ateeb.BlackJack;

public class BlackJackApp 
{
    public static void main(String[] args)
	{
		//System.out.println(blackjack(7, 7));
	}
	
	public int blackjack (int number1, int number2)
	{
		if (number1 < number2 && number2 <= 21) {
			return number2;
		}
		
		if (number1 > number2 && number1 <= 21) {
			return number1;
		}
		
		if (number1 > number2 && number1 <= 21) {
			return number2;
		}
		
		if (number1 < number2 && number2 <= 21) {
			return number1;
		}
		
		if (number1 > 21 && number2 > 21) {
			return 0;
		}
		
		if (number1 == number2 && number1 > 21) {
			return 0;
		}
		
		else  {
			return 0;
		}
		
	}
}
