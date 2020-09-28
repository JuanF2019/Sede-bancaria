/*
 * UNIVERSIDAD ICESI
 * TAREA INTEGRADORA 1 - ESTRUCTURAS DE DATOS
 * RODAS / DIAZ / MARTINEZ
 */

package model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class TestActiveClient {
	
	//------------------------------------------------------------------------------------
	
	//Relations

	private ActiveClient ac;
	private CreditCard card1;
	private CreditCard card2;
	private SavingsAccount sa1;
	private SavingsAccount sa2;
	
	//------------------------------------------------------------------------------------
	
	//Setup1
	
	void setup1() {
		
		ac = new ActiveClient("Valeryan", "A358489", LocalDate.of(1978, 4, 27), null);
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Setup2
	
	void setup2() {
		
		ac = new ActiveClient("Valeryan", "A358489", LocalDate.of(1978, 4, 27), null);
		
		card1 = new CreditCard("TC39857");
		
		sa1 = new SavingsAccount("CA23874");
		
		ac.getcCards()[0] = card1;
		
		ac.getsAccounts()[0] = sa1;
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Setup3
	
	void setup3() {
		
		ac = new ActiveClient("Valeryan", "A358489", LocalDate.of(1978, 4, 27), null);
		
		card1 = new CreditCard("TC39857");
		
		sa1 = new SavingsAccount("CA23874");
		
		card2 = new CreditCard("TC987432");
		
		sa2 = new SavingsAccount("CA23460");
		
		ac.getcCards()[0] = card1;
		
		ac.getsAccounts()[0] = sa1;
		
		ac.getcCards()[1] = card2;
		
		ac.getsAccounts()[1] = sa2;
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test pay credit card
	
	@Test
	void testPayCreditCard1() {
		
		setup1();
		
		assertFalse(ac.payCreditCard("39024FG4", 800000));
		
	}
	
	//****************************************
	
	@Test
	void testPayCreditCard2() {
		
		setup2();
		
		card1.setAssociatedCAccount(new CurrentAccount("AC9000"));
		
		card1.getCurrentAccount().setBalanceToPay(40000);
		
		assertFalse(ac.retrieveCredit("ABC-854", 10000));
		
	}
	
	//****************************************
	
	@Test
	void testPayCreditCard3() {
		
		setup2();
		
		card1.setAssociatedCAccount(new CurrentAccount("ABC123"));
		
		card1.getCurrentAccount().setBalanceToPay(15000);
		
		assertFalse(ac.retrieveCredit("A00356191", 50000));
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test retrieve credit
	
	@Test
	void testRetrieveCredit1() {
		
		setup1();
		
		assertFalse(ac.retrieveCredit("32487GG", 2000000));
		
	}
	
	//****************************************
	
	@Test
	void testRetrieveCredit2() {
		
		setup2();
		
		card1.setAssociatedCAccount(new CurrentAccount("A00356191"));
		
		card1.getCurrentAccount().setAvailableCredit(50000);
		
		assertFalse(ac.retrieveCredit("DGU39848", 25000));
		
	}
	
	//****************************************
	
	@Test
	void testRetrieveCredit3() {
		
		setup3();
		
		card2.setAssociatedCAccount(new CurrentAccount("AC34782"));
		
		card2.getCurrentAccount().setAvailableCredit(70000);
		
		assertFalse(ac.retrieveCredit("456-789-123", 1000));
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test retrieve savings
	
	@Test
	void retrieveSavings1() {
		
		setup1();
		
		assertFalse(ac.retrieveSavings("347CJOA", 130000));
		
	}
	
	//****************************************
	
	@Test
	void retrieveSavings2() {
		
		setup2();
		
		assertFalse(ac.retrieveSavings("3892JD", 9300));
		
		
		ac.addSavings("CA23874", 25000);
		
		assertTrue(ac.retrieveSavings("CA23874", 10000));
		
	}
	
	//****************************************
	
	@Test
	void retrieveSavings3() {
		
		setup3();
		
		ac.addSavings("CA23874", 25000);
		
		assertFalse(ac.retrieveSavings("CA23874", 100000));
		
		ac.addSavings("CA23460", 70000);
		
		assertTrue(ac.retrieveSavings("CA23460", 24000));
		
		assertTrue(ac.retrieveSavings("CA23460", 40000));
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test add savings
	
	@Test
	void testAddSavings1() {
		
		setup1();

		assertFalse(ac.addSavings("CA72", 25000));
		
	}
	
	//****************************************
	
	@Test
	void testAddSavings2() {
		
		setup2();
		
		assertTrue(ac.addSavings("CA23874", 17500));
		
		assertFalse(ac.addSavings("ON86734", 2400));
		
	}
	
	//****************************************
	
	@Test
	void testAddSavings3() {
		
		setup3();
		
		assertTrue(ac.addSavings("CA23874", 5000));
		
		assertTrue(ac.addSavings("CA23460", 78000));
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test create savings

	@Test
	void testCreateSavingsAccount1() {
		
		setup1();
		
		assertTrue(ac.createSavingsAccount("CA8976", "CN12324"));
		
	}
	
	//****************************************
	
	@Test
	void testCreateSavingsAccount2() {
		
		setup2();
		
		assertTrue(ac.createSavingsAccount("ASFJ998", ""));
		
		assertFalse(ac.createSavingsAccount("", "FHEI23FF"));
		
	}
	
	//****************************************
	
	@Test
	void testCreateSavingsAccount3() {
		
		setup3();
		
		assertFalse(ac.createSavingsAccount("NFSAO34","392483"));
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test create credit card
	
	@Test
	void testCreateCreditCard1() {
		
		setup1();
		
		assertTrue(ac.createCreditCard("CC374637",""));
		
	}
	
	//****************************************
	
	@Test
	void testCreateCreditCard2() {
		
		setup2();
		
		assertTrue(ac.createCreditCard("NEFNDI45","9347BM"));
		
		assertTrue(ac.createCreditCard("","4353F487"));
		
	}
	
	//****************************************
	
	@Test
	void testCreateCreditCard3() {
		
		setup3();
		
		assertTrue(ac.createCreditCard("TC987432",""));
		
		assertTrue(ac.createCreditCard("TC063542","HIH28347"));
		
		assertTrue(ac.createCreditCard("000003","32085DF"));
		
		assertFalse(ac.createCreditCard("NASN3487S","PEHCDGKE"));
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test get credit card numbers
	
	@Test
	void testGetCreditCardNumbers1() {
		
		setup1();
		
		assertNull(ac.getCreditCardNumbers());
		
	}
	
	//****************************************
	
	@Test
	void testGetCreditCardNumbers2() {
		
		setup2();
		
		assertTrue(ac.getCreditCardNumbers()[0].equals("TC39857"));
		
	}
	
	//****************************************
	
	@Test
	void testGetCreditCardNumbers3() {
		
		setup3();
		
		assertTrue(ac.getCreditCardNumbers()[0].equals("TC39857"));
		
		assertTrue(ac.getCreditCardNumbers()[1].equals("TC987432"));
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test get savings accounts numbers
	
	@Test
	void testGetSavingsAccountsNumbers1() {
		
		setup1();
		
		assertNull(ac.getSavingsAccountsNumbers());
		
	}
	
	//****************************************
	
	@Test
	void testGetSavingsAccountsNumbers2() {
		
		setup2();
		
		assertTrue(ac.getSavingsAccountsNumbers()[0].equals("CA23874"));
		
	}
	
	//****************************************
	
	@Test
	void testGetSavingsAccountsNumbers3() {
		
		setup3();
		
		assertTrue(ac.getSavingsAccountsNumbers()[0].equals("CA23874"));
		
		assertTrue(ac.getSavingsAccountsNumbers()[1].equals("CA23460"));
		
	}
	
	//------------------------------------------------------------------------------------
	
	//Test clone
	
	@Test
	void testClone1() {
		
		setup1();
		
		ActiveClient aux = ac.clone();
		
		assertTrue(aux.getId().equals(ac.getId()));
		
		assertTrue(aux.getName().equals(ac.getName()));
		
		assertTrue(aux.getBirthday().equals(ac.getBirthday()));
		
	}
	
	//****************************************
	
	@Test
	void testClone2() {
		
		setup2();
		
		ActiveClient aux = ac.clone();
		
		assertTrue(aux.getId().equals(ac.getId()));
		
		assertTrue(aux.getName().equals(ac.getName()));
		
		assertTrue(aux.getBirthday().equals(ac.getBirthday()));
		
	}
	
	//****************************************
	
	@Test
	void testClone3() {
		
		setup3();
		
		ActiveClient newone = new ActiveClient("Billie", "", LocalDate.of(1940, 2, 14), null);
		
		newone.createCreditCard("CC374637","");
		
		newone.createCreditCard("SDJSD092","");
		
		assertFalse(newone.getId().equals(ac.getId()));
		
		assertFalse(newone.getName().equals(ac.getName()));
		
		assertFalse(newone.getBirthday().equals(ac.getBirthday()));
		
	}
	
	//------------------------------------------------------------------------------------

}
