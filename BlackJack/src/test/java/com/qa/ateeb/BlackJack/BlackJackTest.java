package com.qa.ateeb.BlackJack;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
//import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BlackJackTest {
	BlackJackApp blackjackclass = new BlackJackApp();

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { {2,18, 18}, {1,10, 10}, {20,21, 21}, {22,25, 0} });
	}

	private int intPut1;
	private int intPut2;
	private int intPected;

	public BlackJackTest(int input1, int input2, int expected) {

		intPut1 = input1;
		intPut2 = input2;
		intPected = expected;

	}

	@Test
	public void testApp() {

		assertEquals(intPected, blackjackclass.blackjack(intPut1, intPut2));

		// assertEquals(18, blackjackk.blackjack(2, 18));
		// assertEquals(10, blackjackk.blackjack(1, 10));
		// assertEquals(5, blackjackk.blackjack(5, 1));
		// assertEquals(21, blackjackk.blackjack(20, 21));
		//
		// assertEquals(0, blackjackk.blackjack(22, 25));

	}
}
