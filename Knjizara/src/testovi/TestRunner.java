package testovi;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestsKnjizara.class,TestsKnjiga.class);
		Logger l = Logger.getLogger(TestRunner.class.toString());
		for(Failure f: result.getFailures()) {
			l.warning(f.toString());
		}
		l.info("vreme izvrsavanja"+result.getRunTime());
		l.info("Broj pokrenutih:"+result.getRunCount());
		l.info("Broj palih:"+result.getFailureCount());
		l.info("Broj proslih:"+(result.getRunCount()-result.getAssumptionFailureCount()-result.getFailureCount()-result.getIgnoreCount()));
		l.info("Broj preskocenih"+result.getIgnoreCount());
		if(result.wasSuccessful())
			l.info("Prosli su svi testovi");
		else
			l.info("Ima gresaka");
	}

}
