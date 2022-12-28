package Testovi;

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

import radnici.Radnik;
import radnici.Zaposleni;
@RunWith(Parameterized.class)
public class TestDodajRadnika {
public Radnik r;
public Zaposleni z;
@Rule
public final TestRule timeout = Timeout.seconds(6);
@BeforeClass
public static void proveriOs() {
	Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
}
public TestDodajRadnika(Radnik r) {
	this.r = r;
}
@Parameters
public static Collection<Object[]> radnik(){
	return Arrays.asList(new Object[][] {
		{new Radnik("Filipp",210,30)},
		{new Radnik("Filipp",220,30)},
		{new Radnik("Filipp",230,30)},
		{new Radnik("Filipp",240,30)},
	});
}
@Before
public void init() {
	z = new Zaposleni();
}

	@Test(expected = NullPointerException.class)
	public void testDodajRadnik() {
		r = null;
		z.dodajRadnik(r);
	}
	@Test(expected = RuntimeException.class)
	public void testDodajRadnik2() {
		
		z.dodajRadnik(r);
		z.dodajRadnik(r);
	}
	@Test
	public void testDodajRadnik3() {
		
		assertTrue(z.radnik.contains(r));
		
	}

	@After
	public void destroy() {
		z = null;
	}
}
