package Testovi;

import java.util.logging.Logger;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {
		Result result=JUnitCore.runClasses(TestsStudent.class,TestsListaStudenata.class);
		
		Logger l=Logger.getLogger(TestRunner.class.toString());
		
		for(Failure f:result.getFailures())
		{
			l.warning(f.toString());
		}
		
		l.info("Vreme izvrsavanja: "+result.getRunTime());
		l.info("Broj izvrsenih testova: "+result.getRunCount());
		l.info("Broj uspesno izvrsenih testova: "+(result.getRunCount()-result.getIgnoreCount()-result.getFailureCount()-result.getAssumptionFailureCount()));
		l.info("Broj neuspesnih tesotva: "+result.getFailureCount());
		l.info("Broj preskocenih testova: "+result.getIgnoreCount());
		l.info("Broj dinamicki preskocenih testova: "+result.getAssumptionFailureCount());
		
		if(result.wasSuccessful())
		{
			l.info("Uspesno su izvrseni svi testovi!");
		}
		else
		{
			l.warning("Imate greske u testovima");
		}

	}

}
