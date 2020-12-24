package ec.edu.espol.workshops.second;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
   public static void main(String[] args) {
	      Result resultPathTest = JUnitCore.runClasses(PathCoverageTest.class);
	      Result resultStatementTest = JUnitCore.runClasses(StatementCoverageTest.class);
			
	      for (Failure failure : resultPathTest.getFailures()) {
	         System.out.println(failure.toString());
	      }
			
	      for (Failure failure : resultStatementTest.getFailures()) {
		         System.out.println(failure.toString());
		  }
				
	      System.out.println(resultPathTest.wasSuccessful());
	      System.out.println(resultStatementTest.wasSuccessful());
	   }
}
