package stepDefinations;

import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepImplementations {

	
@Given("Load the url")	
public void loadURL(){
	System.out.println("url loaded ");
}	

@When("enter the username")
public void enterUsername(){
	
	/// driet.findele(),send
}

@And("enter the password")
public void enterpswd(){
	System.out.println("pswd entered");
}
	
@Then("click the login button")
public void clickLogin(){
	System.out.println("login buttooon clicked");
}

@Then("I should see the login page")
public void expectedPage(){
	System.out.println("login Page");
}
}
