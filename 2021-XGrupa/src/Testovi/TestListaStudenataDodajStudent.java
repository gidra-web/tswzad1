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

import Studenti.ListaStudenata;
import Studenti.Student;

@RunWith(Parameterized.class)
public class TestListaStudenataDodajStudent {

	public Student s;
	public ListaStudenata l;
	
	@Rule
	public final TestRule timeout=Timeout.seconds(6);
	
	@BeforeClass
	public static void proveriOperativniSistem()
	{
		Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}
	
	public TestListaStudenataDodajStudent(Student s)
	{
		this.s=s;
	}
	
	@Parameters
	public static Collection<Object[]> lista()
	{
		return Arrays.asList(new Object[][] {
			{new Student("Sreten",150,3)},
			{new Student("Sreten",150,3)},
			{new Student("Sreten",150,3)},
			{new Student("Sreten",150,3)},
			{new Student("Sreten",150,3)},
			{new Student("Milos",100,2)},
		});
	}
	
	@Before
	public void init()
	{
		l=new ListaStudenata();
	}
	
	@Test(expected = NullPointerException.class)
	public void testDodajStudent() {
		s=null;
		l.dodajStudent(s);
	}
	
	@Test(expected = RuntimeException.class)
	public void testDodajStudent2() {
		l.dodajStudent(s);
		l.dodajStudent(s);
	}
	
	@Test
	public void testDodajStudent3() {
		assertFalse(l.lista.contains(s));
		l.dodajStudent(s);
		assertTrue(l.lista.contains(s));
	}
	
	@After
	public void destroy()
	{
		l=null;
	}

}
