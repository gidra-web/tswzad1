package testovi;

import static org.junit.Assert.*;

import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import stan.Stan;

public class TestStan {
	public Stan s;
@Rule
public final TestRule timeout = Timeout.seconds(6);
@BeforeClass
public static void proveriOS() {
	Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
}
@Rule
public final TestName name = new TestName();
@Before
public void init() {
	s= new Stan("Vidovdanska",80,1200);
}
	@Test
	public void testGetKvadratura() {
		assertEquals("testGetKvadratura",name.getMethodName());
		int ocekivani =80;
		int stvarni = s.getKvadratura();
		assertEquals(ocekivani,stvarni);
	}

	@Test(expected = RuntimeException.class)
	public void testSetKvadratura() {
		assertEquals("testSetKvadratura",name.getMethodName());
		int ocekivani =80;
		int stvarni = s.getKvadratura();
		assertEquals(ocekivani,stvarni);
		s.setKvadratura(-2);
	}
	@Test
	public void testSetKvadratura2() {
		assertEquals("testSetKvadratura2",name.getMethodName());
		int ocekivani =80;
		int stvarni = s.getKvadratura();
		assertEquals(ocekivani,stvarni);
		s.setKvadratura(20);
	}
	

	@Test
	public void testGetCenaPoKvadratu() {
		assertEquals("testGetCenaPoKvadratu",name.getMethodName());
		int ocekivani =1200;
		int stvarni = s.getCenaPoKvadratu();
		assertEquals(ocekivani,stvarni);
	}

	@Test(expected = RuntimeException.class)
	public void testSetCenaPoKvadratu() {
		assertEquals("testSetCenaPoKvadratu",name.getMethodName());
		int ocekivani =1200;
		int stvarni = s.getCenaPoKvadratu();
		assertEquals(ocekivani,stvarni);
		s.setCenaPoKvadratu(-2);
	}
	@Test(expected = RuntimeException.class)
	public void testSetCenaPoKvadratu2() {
		assertEquals("testSetCenaPoKvadratu2",name.getMethodName());
		int ocekivani =1200;
		int stvarni = s.getCenaPoKvadratu();
		assertEquals(ocekivani,stvarni);
		s.setCenaPoKvadratu(6000);
	}
	@Test
	public void testSetCenaPoKvadratu3() {
		assertEquals("testSetCenaPoKvadratu3",name.getMethodName());
		int ocekivani =1200;
		int stvarni = s.getCenaPoKvadratu();
		assertEquals(ocekivani,stvarni);
		s.setCenaPoKvadratu(4000);
	}
	@Test
	public void testGetAdresa() {
		assertEquals("testGetAdresa",name.getMethodName());
		String ocekivani = "Vidovdanska";
		String stvarni = s.getAdresa();
		assertEquals(ocekivani,stvarni);
	}

	@Test(expected = RuntimeException.class)
	public void testSetAdresa() {
		assertEquals("testSetAdresa",name.getMethodName());
		String ocekivani = "Vidovdanska";
		String stvarni = s.getAdresa();
		assertEquals(ocekivani,stvarni);
		s.setAdresa(null);
	}
	@Test
	public void testSetAdresa2() {
		assertEquals("testSetAdresa2",name.getMethodName());
		String ocekivani = "Vidovdanska";
		String stvarni = s.getAdresa();
		assertEquals(ocekivani,stvarni);
		s.setAdresa("Svetog Save");
	}
	@Test
	public void testIzracunajCenu() {
		double ocekivani = s.getCenaPoKvadratu() * s.getKvadratura();
		double stvarni = s.izracunajCenu();
		assertEquals(ocekivani,stvarni,0.001);
	}

	@Test
	public void testPovoljanStan() {
	assertFalse(s.povoljanStan());
	}
	@Test
	public void testPovoljanStan2() {
	assertFalse(s.povoljanStan());
	s.setCenaPoKvadratu(0);
	assertTrue(s.povoljanStan());
	}
	@Test
	public void testToString() {
		String ocekivani = "Stan [adresa=" + s.getAdresa() + ", kvadratura=" +
				s.getKvadratura() + ", cena po kvadratu=" + s.getCenaPoKvadratu() + "]";
		String stvarni = s.toString();
		assertEquals(ocekivani,stvarni);
	}

}
