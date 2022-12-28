package test;

import static org.junit.Assert.*;

import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

	import zad.Artikal;

	public class ArtikalTest {

		public Artikal a ;

		@Rule
		public final TestRule timeout=Timeout.seconds(6);
		
		@Rule
		public final ErrorCollector ec = new ErrorCollector();

		@BeforeClass
		public static void proveriOperativniSistem()
		{
			Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
		}

		@Before
		public void init()
		{
			a=new Artikal("Koka",500,20);
		}

		@Rule
		public final TestName name=new TestName();


		@Test
		public void testGetCena() {
			
			assertEquals("testGetCena", name.getMethodName());
			int ocekivaniRez=500;
			int stvarniRez=a.getCena();
			assertEquals(ocekivaniRez, stvarniRez);
		}

		@Test(expected = RuntimeException.class)
		public void testSetCena() {
			int ocekivaniRez=500;
			int stvarniRez=a.getCena();
			assertEquals(ocekivaniRez, stvarniRez);

			a.setCena(-1);
		}

		@Test
		public void testSetCena2() {
			int ocekivaniRez=500;
			int stvarniRez=a.getCena();
			try {
			assertEquals(ocekivaniRez, stvarniRez);
			}
			catch (Throwable t) {
				ec.addError(t);
			}

			a.setCena(2);
		}

		@Test
		public void testGetBrojKomada() {
			assertEquals("testGetBrojKomada", name.getMethodName());
			int ocekivaniRez=20;
			int stvarniRez=a.getBroj();
			assertEquals(ocekivaniRez, stvarniRez);
		}

		@Test(expected=RuntimeException.class)
		public void testSetBrojKomada() {
			int ocekivaniRez=20;
			int stvarniRez=a.getBroj();
			try {
			assertEquals(ocekivaniRez, stvarniRez);
			}
			catch(Throwable t) {
				ec.addError(t);
			}

			a.setBroj(-2);
		}

		@Test
		public void testSetBrojKomada2() {
			int ocekivaniRez=20;
			int stvarniRez=a.getBroj();
			assertEquals(ocekivaniRez, stvarniRez);

			a.setBroj(3);
		}
		@Test
		public void testGetNaziv() {
			assertEquals("testGetNaziv",name.getMethodName());
			String ocekivani = "Koka";
			String stvarni = a.getNaziv();
			assertEquals(ocekivani,stvarni);
		}

		@Test(expected = RuntimeException.class)
		public void testSetNaziv() {
			assertEquals("testSetNaziv",name.getMethodName());
			String ocekivani = "Koka";
			String stvarni = a.getNaziv();
			assertEquals(ocekivani,stvarni);
			a.setNaziv(null);
		}
		@Test
		public void testSetNaziv2() {
			assertEquals("testSetNaziv2",name.getMethodName());
			String ocekivani = "Koka";
			String stvarni = a.getNaziv();
			assertEquals(ocekivani,stvarni);
			a.setNaziv("Dop");
		}
		
		@Test
		public void testUkupnaCena() {
			assertEquals("testUkupnaCena",name.getMethodName());
			double ocekivani = a.getBroj() * a.getCena() * 1.18;
			double realni = a.ukupnaCena();
			assertEquals(ocekivani,realni,0.005);
		}

		@Test
		public void testViseOdJedan() {
			assertTrue(a.viseOdJedan());
		}

		@Test
		public void testViseOdJedan2() {
			a.setBroj(10);
			assertTrue(a.viseOdJedan());
		}

		@Test
		public void testToString() {
			assertEquals("testToString",name.getMethodName());
			String ocekivani = "Artikal [naziv=" + a.getNaziv()+ ", cena =" + a.getCena() + ", broj =" + a.getBroj()+ "]";
			String stvarni = a.toString();
			assertEquals(ocekivani,stvarni);
		}

}
