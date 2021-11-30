package stepDefinition;

import Pages.homePage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class getQuote {

//    Create a global object of the parent Page
    homePage CommonObj = new homePage();

//    Launch the Browser and Navigate to Desired page.
    @Given("I launch the browser and open the Cover Genius portal")
    public void LaunchPortal() {
        CommonObj.LaunchBrowser();
    }

//    Enter the complete country name.
    @And("^I fill the form country field with (.*)$")
    public void SelectCounty(String CountryName) throws InterruptedException {
        CountryName = CountryName.replace("\"", "");
        System.out.println("Country to Select is : " +CountryName);
        CommonObj.CountryField().click();
        CommonObj.CountryField().sendKeys(CountryName);
        Thread.sleep(2000);
    }

//    Enter the To and From Date
    @And("^I enter the From Date (.*) and To Date (.*)$")
    public void ienterthedetails(String FromDate, String ToDate) throws InterruptedException {
        FromDate = FromDate.replace("\"", "");
        ToDate = ToDate.replace("\"", "");
        String[] Arr_FromDate = FromDate.split("/");
        String[] Arr_ToDate = ToDate.split("/");
        CommonObj.DateEntryField("From");
        CommonObj.SelectDate(Arr_FromDate[0]);
        CommonObj.DateEntryField("To");
        System.out.println("Entering the To_Date as : "+ToDate);
        if((!Arr_ToDate[1].equals(CommonObj.Month_Year_Element("Month").getText()))){
            System.out.println("Calendar Month in first half is : "+CommonObj.Month_Year_Element("Month").getText());
            System.out.println("Calendar Year in first half is : "+CommonObj.Month_Year_Element("Year").getText());
            CommonObj.NextButon();
        }
        CommonObj.SelectDate(Arr_ToDate[0]);
    }

//    Select the Vehicle type based on the vehicle type availability
    @When("I Verify the Vehicle Type and select 4*4 if it is available")
    public void i_verify_the_vehicle_type() throws InterruptedException {
        CommonObj.SelectVehicleType();

//        The Below code snippet can be used as an alternate to work on select functionality

//            Select DD = new Select(driver.findElement(By.xpath("//select[@name=\"QuoteForm[VehicleType]\"]")));
//            List<WebElement> optionname = DD.getOptions();
//            System.out.println(optionname.size());
//            for (int l = 0; l < optionname.size(); l++) {
//                System.out.println("entered for loop");
//                System.out.println(optionname.get(l).getText());
//            }
//        }
    }
//  Verify the Privacy information page is displayed and verify the content
    @Then("I Click on Get Instant Quote Button and Verify the policy information page")
        public void iClickOnButton () throws InterruptedException {
        CommonObj.SubmitButton();
            if (CommonObj.HeadingOfPage().contains("Policy Information")){
                System.out.println("Policy Information Page Exists and the Heading is : "+CommonObj.HeadingOfPage());
            }
            Thread.sleep(5000);
        }

//   Quit the Browser at the end of the execution
    @After
    public void closebrowser(){
        CommonObj.driver.quit();
    }

}
