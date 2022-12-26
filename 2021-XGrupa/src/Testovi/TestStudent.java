package Testovi;

import static org.junit.Assert.*;

import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import Studenti.Student;

public class TestStudent {

	public Student s;
	
	@Rule
	public final TestRule timeout=Timeout.seconds(6);
	
	@BeforeClass
	public static void proveriOperativniSistem()
	{
		Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}
	
	@Before
	public void init()
	{
		s=new Student("Sreten",3,120);
	}
	
	@Rule
	public final TestName name=new TestName();
	
	
	
	@Test
	public void testGetGodinaStudija() {
		assertEquals("testGetGodinaStudija", name.getMethodName());
		int ocekivaniRez=3;
		int stvarniRez=s.getGodinaStudija();
		assertEquals(ocekivaniRez, stvarniRez);
	}

	@Test(expected = RuntimeException.class)
	public void testSetGodinaStudija() {
		int ocekivaniRez=3;
		int stvarniRez=s.getGodinaStudija();
		assertEquals(ocekivaniRez, stvarniRez);
		
		s.setGodinaStudija(-1);
	}
	
	@Test
	public void testSetGodinaStudija2() {
		int ocekivaniRez=3;
		int stvarniRez=s.getGodinaStudija();
		assertEquals(ocekivaniRez, stvarniRez);
		
		s.setGodinaStudija(2);
	}

	@Test
	public void testGetBrojESPB() {
		assertEquals("testGetBrojESPB", name.getMethodName());
		int ocekivaniRez=120;
		int stvarniRez=s.getBrojESPB();
		assertEquals(ocekivaniRez, stvarniRez);
	}

	@Test(expected=RuntimeException.class)
	public void testSetBrojESPB() {
		int ocekivaniRez=120;
		int stvarniRez=s.getBrojESPB();
		assertEquals(ocekivaniRez, stvarniRez);
		
		s.setBrojESPB(250);
	}
	
	@Test
	public void testSetBrojESPB2() {
		int ocekivaniRez=120;
		int stvarniRez=s.getBrojESPB();
		assertEquals(ocekivaniRez, stvarniRez);
		
		s.setBrojESPB(180);
	}

	@Test
	public void testGetImeIPrezime() {
		assertEquals("testGetImeIPrezime", name.getMethodName());
		String ocekivaniRez="Sreten";
		String stvarniRez=s.getImeIPrezime();
		assertEquals(ocekivaniRez, stvarniRez);
	}

	@Test(expected=RuntimeException.class)
	public void testSetImeIPrezime() {
		String ocekivaniRez="Sreten";
		String stvarniRez=s.getImeIPrezime();
		assertEquals(ocekivaniRez, stvarniRez);
		
		s.setImeIPrezime(null);
	}
	
	@Test
	public void testSetImeIPrezime2() {
		String ocekivaniRez="Sreten";
		String stvarniRez=s.getImeIPrezime();
		assertEquals(ocekivaniRez, stvarniRez);
		
		s.setImeIPrezime("Milos");
	}

	@Test
	public void testProsekESPB() {
		assertEquals("testProsekESPB", name.getMethodName());
		double ocekivaniRez=s.getBrojESPB()/s.getGodinaStudija();
		double stvarniRez=s.prosekESPB();
		assertEquals(ocekivaniRez, stvarniRez,0.005);
	}

	@Test
	public void testRedovniDrugaGod() {
		assertTrue(s.redovniDrugaGod());
	}

	@Test
	public void testRedovniDrugaGod2() {
		s.setBrojESPB(40);
		assertFalse(s.redovniDrugaGod());
	}
	
	@Test
	public void testToString() {
		assertEquals("testToString", name.getMethodName());
		String ocekivaniRez="Student [ime i prezime=" + s.getImeIPrezime()+ ", godina studija =" + s.getGodinaStudija() + ", broj ESPB =" + s.getBrojESPB()+"]";
		String stvarniRez=s.toString();
		assertEquals(ocekivaniRez, stvarniRez);
	}

}
