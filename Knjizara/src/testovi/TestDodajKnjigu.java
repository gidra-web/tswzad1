package testovi;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


import knjiga.Knjiga;
import knjiga.Knjizara;


@RunWith(Parameterized.class)

public class TestDodajKnjigu {
	Knjiga k;
	Knjizara kn;
	@Rule
	public final TestRule timeout = Timeout.seconds(6);
	@BeforeClass
	public static void proveriOS() {
		Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}
	public TestDodajKnjigu(Knjiga k) {
		this.k = k;
	}
	@Parameters
	public static Collection<Object[]> lista (){
		return Arrays.asList(new Object[][] {
			{new Knjiga("Starac i more",20,1000)},
			{new Knjiga("Starac i more",20,1000)},
			{new Knjiga("Starac i more",20,1000)},
			{new Knjiga("Starac i more",20,1000)},
		});
	}
	@Before 
	public void init() {
		kn = new Knjizara();
	}
	
	
	@Test(expected = NullPointerException.class)
	public void testDodajKnjigu() {
		k = null;
		kn.dodajKnjigu(k);
	}
	@Test(expected = RuntimeException.class)
	public void testDodajKnjigu2() {
		
		kn.dodajKnjigu(k);
		kn.dodajKnjigu(k);
	}
	
	@Test
	public void testDodajKnjigu3() {
		kn.knjiga.remove(k);
		assertFalse(kn.knjiga.contains(k));
		kn.dodajKnjigu(k);
		assertTrue(kn.knjiga.contains(k));
		

		
	}
	
	
	@After
	public void destroy() {
		kn = null;
	}
	

}
