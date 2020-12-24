package ec.edu.espol.workshops.second;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PathCoverageTest {
	
   @Test
   public void testCalculatePremium() {
	    CarInsurance carinsurance1 = new CarInsurance("25", "mujer", "y", "0999999999");
	   int prima1 = carinsurance1.calculatePremium();
	   
	    CarInsurance carinsurance2 = new CarInsurance("0", "F", "y", "0999999999");
	   int prima2 = carinsurance2.calculatePremium();
	   
	   CarInsurance carinsurance3 = new CarInsurance("85", "F", "y", "0999999999");
	   int prima3 = carinsurance3.calculatePremium();
	   
	   CarInsurance carinsurance4 = new CarInsurance("25", "F", "y", "0999999");
	   int prima4 = carinsurance4.calculatePremium();

	   
	   
	   
	   CarInsurance carinsurance6 = new CarInsurance("20", "M", "n", "0999999999");
	   int prima6 = carinsurance6.calculatePremium();
	   
	   CarInsurance carinsurance7 = new CarInsurance("20", "F", "y", "0999999999");
	   int prima7 = carinsurance7.calculatePremium();
	   
	   CarInsurance carinsurance8 = new CarInsurance("70", "M", "n", "0999999999");
	   int prima8 = carinsurance8.calculatePremium();
	   
	   assertEquals(-1, prima1,0);
	   assertEquals(-1, prima2,0);
	   assertEquals(-1, prima3,0);
	   assertEquals(-1, prima4,0);
	   
	   assertEquals(2100, prima6,0);
	   assertEquals(400, prima7,0);
	   assertEquals(600, prima8,0);
   }
}
