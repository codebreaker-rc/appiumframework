package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class Loginsteps {

    @When("I enter username as {string}")
    public void i_enter_username_as(String string) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("When steps executed");
        new LoginPage().enterUserText(string);
    }

    @When("I enter password as {string}")
    public void i_enter_password_as(String string) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("When steps executed");
    }

    @When("I login")
    public void i_login() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("When steps executed");
    }

    @Then("I should see Products page with title {string}")
    public void i_should_see_products_page_with_title(String string) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("When steps executed");
    }

}
