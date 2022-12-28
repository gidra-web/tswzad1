package test;

import static org.junit.Assert.*;

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

import zad.Prodavnica;
import zad.Artikal;


	@RunWith(Parameterized.class)
	public class ProdavnicaTestPronadji {

		public Artikal a;
		public Prodavnica p;

		@Rule
		public final TestRule timeout=Timeout.seconds(6);

		@BeforeClass
		public static void proveriOperativniSistem()
		{
			Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
		}

		public ProdavnicaTestPronadji(Artikal a)
		{
			this.a=a;
		}
		
		@Parameters
	    public static Collection<Object[]> lista() {
	        return Arrays.asList(new Object[][] {
	        	{new Artikal("Koka",100,2)},
	        	{new Artikal("Koka",100,2)},
	        	{new Artikal("Koka",100,2)},
	        	{new Artikal("Koka",100,2)},
	        	{new Artikal("Koka",100,2)},
	        	{new Artikal("Koka",100,2)}
	    		});
	    }
		
		@Before
		public void init()
		{
			p=new Prodavnica();
		}
		
		@Test
		public void testProdavnicaPronadji() {
			Artikal a=null;
			p.pronadjiArtikle(a);
		}

		@Test
		public void testProdavnicaPronadji2() {		//???
			assertFalse(p.lista.contains(a));
			p.dodajArtikal(a);
			LinkedList<Artikal> lista = new LinkedList<Artikal>();
			lista.add(a);
			assertEquals(lista, p.pronadjiArtikle(a));
		}

		@Test
		public void testProdavnicaPronadji3() {		///????
			assertFalse(p.lista.contains(a));
			p.dodajArtikal(a);
			LinkedList<Artikal> listas = new LinkedList<Artikal>();
			listas.add(a);
			assertNotEquals(listas, p.pronadjiArtikle(a));
		}

		@After
		public void destroy()
		{
			p=null;
		}

}
