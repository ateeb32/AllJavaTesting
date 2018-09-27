package com.qa.ateeb.TaxTask;

public class Taxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int percentageTax(int salary){
		
		if (salary <= 14999) return 0;
		else if (salary == 15000 && salary <= 19999) return 10;
		else if (salary == 20000 && salary <= 29999) return 15;
		else if (salary == 30000 && salary <= 44999) return 20;
		else return 25;
	}
	
	public double calculation(int salary) {
		
		int output = salary * percentageTax(salary) / 100;
		return output;
		
	}

}
