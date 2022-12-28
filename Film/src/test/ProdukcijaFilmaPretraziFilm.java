package test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

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

import zad.Film;
import zad.ProdukcijaFilma;

@RunWith(Parameterized.class)
public class ProdukcijaFilmaPretraziFilm {

	private ProdukcijaFilma pf;
	private Film f;
	
	@Rule 
	public final TestRule timeout= Timeout.seconds(6);
	
	@BeforeClass
	public static void proveriOperativniSistem()
	{
		Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}
	
	@Before
	public void init()
	{
		pf = new ProdukcijaFilma();
	}
	
	public ProdukcijaFilmaPretraziFilm(Film f)
	{
		this.f=f;
	}
	
	@Parameters
	public static Collection<Object[]> film(){
		return Arrays.asList(new Object[][] {
			{new Film("Titanik",2,300)},
			{new Film("Titanik",1,250)},
			{new Film("Titanik",3,350)},
			{new Film("Titanik",4,100)}
		});
	}
	
	@Test
	public void pronadjiFilmTest()
	{
		String naslov=null;
		assertNull(pf.pronadjiFilm(naslov));
	}
	
	@Test
	public void pronadjiFilmTest2()
	{
		assertFalse(pf.film.contains(f));
		pf.dodajFilm(f);
		LinkedList<Film> film = new LinkedList<Film>();
		film.add(f);
		assertEquals(film,pf.pronadjiFilm("Titanik"));
	}
	
	@Test
	public void pronadjiFilmTest3()
	{
		assertFalse(pf.film.contains(f));
		pf.dodajFilm(f);
		LinkedList<Film> film = new LinkedList<Film>();
		film.add(f);
		assertEquals(film,pf.pronadjiFilm("Titanik - NotExistingName"));
	}
	
	@After
	public void destroy()
	{
		pf=null;
	}

}
