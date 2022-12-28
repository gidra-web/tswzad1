package testovi;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {
		Result result =JUnitCore.runClasses(TestsAgencija.class,TestsStan.class);
		Logger l = Logger.getLogger(TestRunner.class.toString());
		for(Failure f: result.getFailures()) {
			l.warning(f.toString());
		}
		l.info("Vreme izvrsavanja:"+result.getRunTime());
		l.info("Broj izvrsenih testova:"+result.getRunCount());
		l.info("Broj palih:"+result.getFailureCount());
		l.info("Broj uspesnih testova:"+(result.getRunCount()-result.getFailureCount()-result.getAssumptionFailureCount()-result.getIgnoreCount()));
		l.info("Broj preskocenih testova:"+result.getIgnoreCount());
		l.info("Broj dinamicki preskocenih testova:"+result.getAssumptionFailureCount());
		if(result.wasSuccessful())
			l.info("Svi testovi su prosli");
		else
			l.info("Ima gresaka");
		
	}

}
