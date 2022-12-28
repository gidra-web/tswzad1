package Testovi;

import static org.junit.Assert.*;

import java.util.logging.Logger;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestsRadnik.class,TestsZaposleni.class);
		Logger l = Logger.getLogger(TestRunner.class.toString());
		
		for(Failure f: result.getFailures())
		{
			l.warning(f.toString());
		}
		l.info("Vreme izvrsavanja testa:"+result.getRunTime());
		l.info("Broj izvrsenih testova:"+result.getRunCount());
		l.info("Broj uspesno izvrsenih testova:"+(result.getRunCount()-result.getAssumptionFailureCount()-result.getFailureCount()-result.getIgnoreCount()));
		l.info("Broj neuspesnih testova"+result.getFailureCount());
		l.info("Broj preskocenih testova"+result.getIgnoreCount());
		l.info("Broj dinamicki preskocenih testova"+result.getAssumptionFailureCount());
		if(result.wasSuccessful())
			l.info("Uspesno su izvrseni svi testovi");
		else
			l.info("Ima gresaka");
		
	}

}
