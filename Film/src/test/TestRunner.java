package test;

import static org.junit.jupiter.api.Assertions.*;


import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args)
	{
		Result result = JUnitCore.runClasses(FilmTests.class,ProdukcijaFimTests.class);
		
		Logger l = Logger.getLogger(TestRunner.class.toString());
		
		for(Failure f: result.getFailures())
		{
			l.warning(f.toString());
		}
		
		l.info("Vreme za testove: " +result.getRunTime());
		l.info("Broj testova: " +result.getRunCount());
		l.info("Broj uspesnih: " +(result.getRunCount() - result.getIgnoreCount() - result.getFailureCount() - result.getAssumptionFailureCount()));
		l.info("Broj palih: " +result.getFailureCount());
		l.info("Broj preskocenih: " +result.getIgnoreCount());
		
		if(result.wasSuccessful())
			l.info("Svi testovi su uspesni");
		else
			l.warning("Ima gresaka");
	}

}
