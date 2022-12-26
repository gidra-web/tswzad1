package Testovi;

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

import Studenti.ListaStudenata;
import Studenti.Student;

@RunWith(Parameterized.class)
public class TestListaStudenataZadataGodina {
	
	public Student s;
	public ListaStudenata l;
	
	@Rule
	public final TestRule timeout=Timeout.seconds(6);
	
	@BeforeClass
	public static void proveriOperativniSistem()
	{
		Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}
	
	public TestListaStudenataZadataGodina(Student s)
	{
		this.s=s;
	}
	
	@Parameters
	public static Collection<Object[]> lista()
	{
		return Arrays.asList(new Object[][] {
			{new Student("Sreten",100,2)},
			{new Student("Sreten",100,2)},
			{new Student("Sreten",100,2)},
			{new Student("Sreten",100,2)},
			{new Student("Sreten",100,2)},
			{new Student("Sreten",100,2)},
		});
	}
	
	@Before
	public void init()
	{
		l=new ListaStudenata();
	}
	
	
	@Test
	public void testStudentiZadateGodine() {
		int godinaStudija=0;
		l.studentiZadateGodine(godinaStudija);
	}
	
	@Test
	public void testStudentiZadateGodine2() {
		assertFalse(l.lista.contains(s));
		l.dodajStudent(s);
		LinkedList<Student> lista = new LinkedList<Student>();
		lista.add(s);
		assertEquals(lista, l.studentiZadateGodine(100));
	}
	
	@Test
	public void testStudentiZadateGodine3() {
		assertFalse(l.lista.contains(s));
		l.dodajStudent(s);
		LinkedList<Student> listas = new LinkedList<Student>();
		listas.add(s);
		assertNotEquals(listas, l.studentiZadateGodine(150));
	}
	
	@After
	public void destroy()
	{
		l=null;
	}


}
