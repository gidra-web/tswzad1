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

import radnici.Radnik;
import radnici.Zaposleni;
@RunWith(Parameterized.class)
public class TestPronadjiRadnika {
public Radnik r;
public Zaposleni z;
@Rule
public final TestRule timeout = Timeout.seconds(6);
@BeforeClass
public static void proveriOS() {
	Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	
}
public TestPronadjiRadnika(Radnik r) {
	this.r = r;
}
@Parameters
public static Collection<Object[]> radnik(){
	return Arrays.asList(new Object[][] {
		{new Radnik("Filipe",40,50)},
		{new Radnik("Filipe",40,50)},
		{new Radnik("Filipe",40,50)},
		{new Radnik("Filipe",40,50)},
	});
}
@Before
public void init() {
	z = new Zaposleni();
}

@Test
public void testPronadjiRadnik() {
	String ime = null;
	z.pronadjiRadnik(ime);
}


@After
public void destroy() {
	z = null;
}
}
