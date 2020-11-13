package ec.edu.espol.workshops.second;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import static org.junit.Assert.assertEquals;
import ec.edu.espol.workshops.second.CarInsurance.*;

public class StepDefs {
	private String sexo;
	private boolean married;
	private boolean license;
	private int price;
	private int age;
	private String ci;
	
	@Given("the customer's age is {int}")
	public void the_customer_age_is(int age) {
		this.age = age;
	}
	@And("I am using the ci {String}")
	public void the_customer_ci_is(String ci) {
		this.ci = ci;
	}
	@And("I am using the sexo {String}")
	public void the_customer_sexo_is(String sexo) {
		this.sexo = sexo;
	}
	@And("I am using the marital status \"t\" ")
	public void the_customer_is_married() {
		this.married = true;
	}
	@And("I am using the marital status \"n\" ")
	public void the_customer_is_not_married() {
		this.married = false;
	}
	@When("I Calculate the premium")
	public void i_calculate_the_premium() {
		CarInsurance cInsurance = new CarInsurance(this.age, this.sexo, "yes", this.ci);
		price = cInsurance.calculatePremium();
	}
	@Then("I should be told {string}")
	public void i_should_be_told(String expectedpremium) {
		assertEquals(expectedpremium, price);
	}
	
}