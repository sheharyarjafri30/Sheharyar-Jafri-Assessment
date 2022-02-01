package StepDefinition;

import java.io.IOException;
import java.net.MalformedURLException;

import CucumberPageObjectModel.baseclass;
import CucumberPageObjectModel.dashBoardPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestStepDefinition extends baseclass {
	dashBoardPage dashBoard;
	baseclass baseMethods;
	
	@Given("Browser is open and user navigate to {string}")
	public void browser_is_open_and_user_navigate_to(String string) throws MalformedURLException {
		 baseMethods = new baseclass();
		baseMethods.initialization1();
		baseMethods.openurl(string);
	}

	@Given("get and verify console logs")
	public void get_and_verify_console_logs() {
		 baseMethods = new baseclass();
		 dashBoard = new dashBoardPage();
	    dashBoard.getConsoleLogs();
	    baseMethods.closeBrowser();
	    

	}
	@Given("get and verify response code {string}")
	public void get_and_verify_response_code(String string) throws MalformedURLException, IOException {
		baseMethods = new baseclass();
		 dashBoard = new dashBoardPage();
	    dashBoardPage.getResponcecode(string);
	    baseMethods.closeBrowser();
	}
	@Given("get all links")
	public void get_all_links() throws MalformedURLException, IOException, InterruptedException {
		 dashBoard = new dashBoardPage();
	    dashBoardPage.clickAllHyperLinksByTagName();

	}
}
