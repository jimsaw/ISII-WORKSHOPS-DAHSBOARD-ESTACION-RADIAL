import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestEmployeeDetails {
	@Test
	   public void testCalculatePremium() {
		    CarInsurance carinsurance1 = new CarInsurance("35", "mujer", "y", "0999999999");
		   int prima1 = carinsurance1.calculatePremium();
		   
		    CarInsurance carinsurance2 = new CarInsurance("0", "F", "y", "0999999999");
		   int prima2 = carinsurance2.calculatePremium();
		   
		   CarInsurance carinsurance3 = new CarInsurance("85", "F", "y", "0999999999");
		   int prima3 = carinsurance3.calculatePremium();
		   

		   assertEquals(-1, prima1,0);
		   assertEquals(-1, prima2,0);
		   assertEquals(-1, prima3,0);

	   }
}