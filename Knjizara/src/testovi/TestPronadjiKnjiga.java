package testovi;

import static org.junit.Assert.*;

import org.junit.Test;
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


import knjiga.Knjiga;
import knjiga.Knjizara;


@RunWith(Parameterized.class)


public class TestPronadjiKnjiga {
	Knjiga k;
	Knjizara kn;
	@Rule
	public final TestRule timeout = Timeout.seconds(6);
	@BeforeClass
	public static void proveriOS() {
		Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}
	public TestPronadjiKnjiga(Knjiga k) {
		this.k = k;
	}
	@Parameters
	public static Collection<Object[]> lista (){
		return Arrays.asList(new Object[][] {
			{new Knjiga("Starac i moree",20,1000)},
			{new Knjiga("Starac i moreec",20,1000)},
			{new Knjiga("Starac i moreeq",20,1000)},
			{new Knjiga("Starac i moreed",20,1000)},
		});
	}
	@Before 
	public void init() {
		kn = new Knjizara();
	}
	
	@Test
	public void testPronadjiKnjigu() {
		String naslov = null;
		kn.pronadjiKnjiga(naslov);
	}
	@Test
	public void testPronadjiKnjigu2() {
		assertFalse(kn.knjiga.contains(k));
		kn.dodajKnjigu(k);
		LinkedList<Knjiga> novaLista = new LinkedList<Knjiga>();
		novaLista.add(k);
		
		assertEquals(novaLista,kn.pronadjiKnjiga("Starac i moree"));
		
		
	}
	
	@After
	public void destroy() {
		kn = null;
	}

}
