package testovi;

import static org.junit.Assert.*;

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

import stan.AgencijaProdajeStanova;
import stan.Stan;
@RunWith(Parameterized.class)
public class TestDodajStan {
public Stan s;
public AgencijaProdajeStanova a;
@Rule
public final TestRule timeout = Timeout.seconds(5);
@BeforeClass
public static void proveriOS() {
	Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
}
public TestDodajStan(Stan s) {
	this.s =s;
}
@Before
public void init() {
	a = new AgencijaProdajeStanova();
}
@Parameters
public static Collection<Object[]> lista(){
	return Arrays.asList(new Object[][] {
		{new Stan("Vojvode Stepe",80,2000)},
		{new Stan("Vojvode Stepe",80,2000)},
		{new Stan("Vojvode Stepe",80,2000)},
		{new Stan("Vojvode Stepe",80,2000)},
	});
}
	@Test(expected = NullPointerException.class)
	public void testDodajStan() {
		s = null;
		a.dodajStan(s);
	}
	@Test(expected = RuntimeException.class)
	public void testDodajStan2() {
		a.dodajStan(s);
		a.dodajStan(s);
	}
	@Test
	public void testDodajStan3() {
	assertFalse(a.lista.contains(s));
	a.dodajStan(s);
	assertTrue(a.lista.contains(s));
	}
	
	@After
	public void destroy() {
		a = null;
	}

}
