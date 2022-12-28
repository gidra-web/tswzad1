package Testovi;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import radnici.Radnik;
public class TestRadnik {
public Radnik r;
@Rule
public final TestRule timeout = Timeout.seconds(6);
@BeforeClass
public static void proveriOS() {
	Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
}
@Before
public void init() {
	r = new Radnik("Filip",200,40);
}
@Rule
public final TestName name = new TestName();
@Test
public void testGetCenaSata() {
	assertEquals("testGetCenaSata",name.getMethodName());
	int ocekivani = 200;
	int stvarni = r.getCenaSata();
	assertEquals(ocekivani,stvarni);
	
}

	@Test(expected = RuntimeException.class)
	public void testSetCenaSata() {
		assertEquals("testSetCenaSata",name.getMethodName());
		int ocekivani = 200;
		int stvarni = r.getCenaSata();
		assertEquals(ocekivani,stvarni);
		r.setCenaSata(-2);
		
	}
	@Test
	public void testSetCenaSata2() {
		assertEquals("testSetCenaSata2",name.getMethodName());
		int ocekivani = 200;
		int stvarni = r.getCenaSata();
		assertEquals(ocekivani,stvarni);
		r.setCenaSata(2);
		
	}
	@Test
	public void testGetBrSatiRada() {
		assertEquals("testGetBrSatiRada",name.getMethodName());
		int ocekivani = 40;
		int stvarni = r.getBrSatiRada();
		assertEquals(ocekivani,stvarni);
		
	}
	@Test(expected = RuntimeException.class)
	public void testSetBrSatiRada() {
		assertEquals("testSetBrSatiRada",name.getMethodName());
		int ocekivani = 40;
		int stvarni = r.getBrSatiRada();
		assertEquals(ocekivani,stvarni);
		r.setBrSatiRada(-2);
	}
	@Test(expected = RuntimeException.class)
	public void testSetBrSatiRada2() {
		assertEquals("testSetBrSatiRada2",name.getMethodName());
		int ocekivani = 40;
		int stvarni = r.getBrSatiRada();
		assertEquals(ocekivani,stvarni);
		r.setBrSatiRada(355);
	}
	@Test
	public void testSetBrSatiRada3() {
		assertEquals("testSetBrSatiRada3",name.getMethodName());
		int ocekivani = 40;
		int stvarni = r.getBrSatiRada();
		assertEquals(ocekivani,stvarni);
		
	}

	@Test(expected = RuntimeException.class)
	public void testSetIme() {
		assertEquals("testSetIme",name.getMethodName());
		String ocekivani = "Filip";
		String stvarni = r.getIme();
		assertEquals(ocekivani,stvarni);
		r.setIme(null);
	}
	@Test
	public void testSetIme2() {
		assertEquals("testSetIme2",name.getMethodName());
		String ocekivani = "Filip";
		String stvarni = r.getIme();
		assertEquals(ocekivani,stvarni);
		r.setIme("Filip");
	}

	@Test
	public void testGetIme() {
		assertEquals("testGetIme",name.getMethodName());
		String ocekivani = "Filip";
		String stvarni = r.getIme();
		assertEquals(ocekivani,stvarni);
		
	}

	@Test
	public void testIzracunajPlatu() {
		double ocekivani = r.getBrSatiRada() * r.getCenaSata() + 20000;
		double stvarni = r.izracunajPlatu();
		assertEquals(ocekivani,stvarni,0.001);
	}

	@Test
	public void testBolovanje() {
		assertFalse(r.bolovanje());
	}
	@Test
	public void testBolovanje2() {
		r.setBrSatiRada(0);
		r.setCenaSata(5);
		assertTrue(r.bolovanje());
	}
	@Test
	public void testEqualsObject() {
	Radnik rr = new Radnik("Filip",200,40);
	assertTrue(r.equals(rr));
	}

}
