package testovi;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.Timeout;


import knjiga.Knjiga;

public class TestKnjiga {
	public Knjiga k;
	@Rule
	public final Timeout timeout = Timeout.seconds(6);
	@BeforeClass
	public static void proveriOS() {
		Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}
	@Before
	public void init() {
		k = new Knjiga("Starac i more",20,1000);
	}
	@Rule
	public final TestName name = new TestName();
	@Test
	public void testGetBrKnjiga() {
		assertEquals("testGetBrKnjiga",name.getMethodName());
		int ocekivani = 20;
		int stvarni = k.getBrKnjiga();
		assertEquals(ocekivani,stvarni);
	}

	@Test(expected = RuntimeException.class)
	public void testSetBrKnjiga() {
		assertEquals("testSetBrKnjiga",name.getMethodName());
		int ocekivani = 20;
		int stvarni = k.getBrKnjiga();
		assertEquals(ocekivani,stvarni);
		k.setBrKnjiga(-2);
	}
	@Test
	public void testSetBrKnjiga2() {
		assertEquals("testSetBrKnjiga2",name.getMethodName());
		int ocekivani = 20;
		int stvarni = k.getBrKnjiga();
		assertEquals(ocekivani,stvarni);
		k.setBrKnjiga(2);
	}

	@Test
	public void testGetCena() {
		assertEquals("testGetCena",name.getMethodName());
		int ocekivani = 1000;
		int stvarni = k.getCena();
		assertEquals(ocekivani,stvarni);
	}

	@Test(expected = RuntimeException.class)
	public void testSetCena() {
		assertEquals("testSetCena",name.getMethodName());
		int ocekivani = 1000;
		int stvarni = k.getCena();
		assertEquals(ocekivani,stvarni);
		k.setCena(-2);
	}
	@Test
	public void testSetCena2() {
		assertEquals("testSetCena2",name.getMethodName());
		int ocekivani = 1000;
		int stvarni = k.getCena();
		assertEquals(ocekivani,stvarni);
		k.setCena(200);
	}

	@Test
	public void testGetNaslov() {
		assertEquals("testGetNaslov",name.getMethodName());
		String ocekivani = "Starac i more";
		String stvarni = k.getNaslov();
		assertEquals(ocekivani,stvarni);
	}

	@Test(expected = RuntimeException.class)
	public void testSetNaslov() {
		assertEquals("testSetNaslov",name.getMethodName());
		String ocekivani = "Starac i more";
		String stvarni = k.getNaslov();
		assertEquals(ocekivani,stvarni);
		k.setNaslov(null);
	}
	@Test
	public void testSetNaslov2() {
		assertEquals("testSetNaslov2",name.getMethodName());
		String ocekivani = "Starac i more";
		String stvarni = k.getNaslov();
		assertEquals(ocekivani,stvarni);
		k.setNaslov("Basne");
	}

	@Test
	public void testProfit() {
		double ocekivani = k.getBrKnjiga() * k.getCena() *0.2;
		double stvarni = k.profit();
		assertEquals(ocekivani,stvarni,0.001);
		
	}

	@Test
	public void testMaliProfit() {
		assertFalse(k.maliProfit());
	}
	@Test
	public void testMaliProfit2() {
		assertFalse(k.maliProfit());
		k.setBrKnjiga(0);
		assertTrue(k.maliProfit());
	}

	@Test
	public void testToString() {
		String ocekivani = "Knjiga [naslov=" + k.getNaslov() + ", brKnjiga=" + k.getBrKnjiga() + ", cena knjige =" + k.getCena() + "]";
		String stvarni = k.toString();
		assertEquals(ocekivani,stvarni);
	}

}
