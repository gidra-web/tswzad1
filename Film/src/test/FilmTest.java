package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import zad.Film;
import zad.ProdukcijaFilma;

public class FilmTest {

	private Film F;
	
	@Rule
	public final TestRule timeout = Timeout.seconds(6);
	
	@Rule
	public final TestName name = new TestName();
	
	@BeforeClass
	public static void proveriOperativniSistem()
	{
		Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}
	
	@Rule
	public final ErrorCollector ec = new ErrorCollector();
	
	@Before
	public void init()
	{
		F= new Film("Titanik",3,200);
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test(expected = RuntimeException.class)
	public void setBrGledalacaTest()
	{
		assertEquals("setBrGledalacaTest",name.getMethodName());
		int or = 200;
		int sr = F.getBrGledalaca();
		assertEquals(or,sr);
		
		F.setBrGledalaca(-20);
	}
	
	@Test
	public void setBrGledalacaTest2()
	{
		int or = 200;
		int sr = F.getBrGledalaca();
		assertEquals(or,sr);
		
		F.setBrGledalaca(100);
		or =100;
		sr =F.getBrGledalaca();
		assertEquals(or,sr);
	}
	
	@Test(expected = RuntimeException.class)
	public void setTrajanjeTest()
	{
		assertEquals("setTrajanjeTest",name.getMethodName());
		int or = 3;
		int sr = F.getTrajanje();
		assertEquals(or,sr);
		
		F.setTrajanje(-10);
	}
	
	@Test
	public void setTrajanjeTest2()
	{
		int or = 3;
		int sr =F.getTrajanje();
		assertEquals(or,sr);
		
		F.setTrajanje(1);
		or =1;
		sr = F.getTrajanje();
		assertEquals(or,sr);
	}
	
	@Test
	public void getNaslovTest()
	{
		assertEquals("getNaslovTest",name.getMethodName());
		String or = "Titanik";
		String sr = F.getNaslov();
		assertEquals(or,sr);
	}
	
	@Test(expected = RuntimeException.class)
	public void setNaslovTest()
	{
		String or = "Titanik";
		String sr = F.getNaslov();
		assertEquals(or,sr);
		
		F.setNaslov(null);
	}
	
	@Test
	public void setNaslovTest2()
	{
		String or ="Titanik";
		String sr = F.getNaslov();
		assertEquals(or,sr);
		
		F.setNaslov("Naruto");
		or = "Naruto";
		sr = F.getNaslov();
		assertEquals(or,sr);
	}
	
	@Test
	public void izracunajHonorarTest()
	{
		double or = F.getBrGledalaca()*200;
		double sr = F.izracunajHonorar();
		assertEquals(or,sr,0.001);
	}
	
	@Test
	public void neuspesanFilmTest()
	{
		assertFalse(F.neuspesanFilm());
	}
	
	@Test
	public void neuspesanFilmTest2()
	{
		F.setBrGledalaca(0);
		assertTrue(F.neuspesanFilm());
	}
	
	@Test
	public void toStringTest()
	{
		String or = "Film [naslov=" +F.getNaslov()+ ", trajanje =" + F.getTrajanje()+ ", broj gledalaca=" + F.getBrGledalaca() + "]";
		String sr = F.toString();
		assertEquals(or,sr);
	}
	
	@Test
	public void equalsTest1()
	{
		Film f = new Film("Titanik",3,200);
		assertTrue(F.equals(f));
	}
	
	@Test
	public void equalsTest2()
	{
		ProdukcijaFilma pf = new ProdukcijaFilma();
		assertEquals(false,F.equals(pf));
	}
	
	@Test
	public void equalsTest3()
	{
		Film f = F;
		assertTrue(F.equals(f));
	}
	
	@Test
	public void equalsTest4()
	{
		Film f = new Film(null,2,300);
		assertFalse(F.equals(f));
	}
	
	@Test
	public void equalsTest5()
	{
		Film f1 = new Film(null,3,200);
		Film f2 = new Film(null,3,200);
		assertTrue(f1.equals(f2));
	}
	
	@Test
	public void equalsTest6()
	{
		Film f1 = new Film(null,3,200);
		Film f2 = new Film("Titanik",3,200);
		assertFalse(f1.equals(f2));
	}
	
	@Test
	public void equalsTest7()
	{
		Film f = new Film("Titanik",1,300);
		assertFalse(F.equals(f));
	}
	@Test
	public void equalsTest8()
	{
		Film f = new Film("Naruto",2,100);
		assertFalse(F.equals(f));
	}

}
