package testovi;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

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

public class TestPronadjiStan {
	public Stan s;
	public AgencijaProdajeStanova a;
	@Rule
	public final TestRule timeout = Timeout.seconds(5);
	@BeforeClass
	public static void proveriOS() {
		Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}
	public TestPronadjiStan(Stan s) {
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
	@Test
	public void testPronadjiStan() {
		String adresa = null;
		a.pronadjiStan(adresa);
	}
	@Test
	public void testPronadjiStan2() {
		assertFalse(a.lista.contains(s));
		a.dodajStan(s);
		LinkedList<Stan> novaLista = new LinkedList<Stan>();
		novaLista.add(s);
		assertEquals(novaLista,a.pronadjiStan("Vojvode Stepe"));
	}
	@Test
	public void testPronadjiStan3() {
		assertFalse(a.lista.contains(s));
		a.dodajStan(s);
		LinkedList<Stan> novaListaa = new LinkedList<Stan>();
		novaListaa.add(s);
		assertEquals(novaListaa,a.pronadjiStan("Vojvode S"));
	}
	@After
	public void destroy()
	{
		a=null;
	}
}
