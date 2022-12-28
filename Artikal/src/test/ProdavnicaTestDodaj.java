package test;

import static org.junit.jupiter.api.Assertions.*;
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

import zad.Prodavnica;
import zad.Artikal;



	@RunWith(Parameterized.class)
	public class ProdavnicaTestDodaj {

		public Artikal a;
		public Prodavnica p;

		@Rule
		public final TestRule timeout=Timeout.seconds(6);

		@BeforeClass
		public static void proveriOperativniSistem()
		{
			Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
		}

		public ProdavnicaTestDodaj(Artikal a)
		{
			this.a=a;
		}

		@Parameters
		public static Collection<Object[]> lista()
		{
			return Arrays.asList(new Object[][] {
				{new Artikal("Maramice",150,3)},
				{new Artikal("Maramice",150,3)},
				{new Artikal("Maramice",150,3)},
				{new Artikal("Maramice",150,3)},
				{new Artikal("Maramice",150,3)},
				{new Artikal("Maramice",100,2)},
			});
		}

		@Before
		public void init()
		{
			p=new Prodavnica();
		}

		@Test(expected = NullPointerException.class)
		public void testDodajStudent() {
			a=null;
			p.dodajArtikal(a);
		}

		@Test(expected = RuntimeException.class)
		public void testDodajStudent2() {
			p.dodajArtikal(a);
			p.dodajArtikal(a);
		}

//		@Test
//		public void testDodajArtikal3() {
//			assertFalse(p.lista.contains(a));
//			p.dodajArtikal(a);
//			assertTrue(p.lista.contains(a));
//		}

		@After
		public void destroy()
		{
			p=null;
		}

}
