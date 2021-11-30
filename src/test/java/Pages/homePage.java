package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import Objects.homepageObjects;

public class homePage  {

    public WebDriver driver;

//    Function to launch the browser and navigate to Rental cover website
    public void LaunchBrowser(){
        String driverPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", driverPath + "/src/test/resources/Driver/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.rentalcover.com");
        driver.manage().window().maximize();
        System.out.println("Browser Launched and the title of the page is : "+ driver.getTitle());
    }

//    Return the Country Webelement
    public WebElement CountryField(){
        homepageObjects HomePage = new homepageObjects(driver);
        return HomePage.Country_Field();
    }

//    Click on the From date or To date input boxes ** Arguments : From or To
    public void DateEntryField(String DateType) throws InterruptedException {
        homepageObjects HomePage = new homepageObjects(driver);
        switch (DateType){
            case "From" :
                HomePage.From_Date().click();
                break;
            case "To"   :
                if(HomePage.To_date().isDisplayed()){
                    HomePage.To_date().click();
                } else{
                    System.out.println("To Date element is not visible waiting for 10 seconds");
                    Thread.sleep(10000);
                    HomePage.To_date().click();
                }
                break;
            default :
                System.out.println("Please enter a valid date type your DateType is : " +DateType);
                break;
        }
    }

//    Select the day from the Calendar element
    public void SelectDate(String Day){
        homepageObjects HomePage = new homepageObjects(driver);
        HomePage.Day_date(Day).click();
    }

//    Return the Month or Year of the displayed calendar element
    public WebElement Month_Year_Element(String MM_YY_Type) {
        homepageObjects HomePage = new homepageObjects(driver);
        switch (MM_YY_Type) {
            case "Month":
                return HomePage.Month_Year_Name("month");
            case "Year":
                return HomePage.Month_Year_Name("year");
            default:
                System.out.println("Please enter a valid Month/Year type");
                return null;
        }
    }

//    Verify the Next button on the Calendar Object and click
    public void NextButon() throws InterruptedException {
        homepageObjects HomePage = new homepageObjects(driver);
        if (HomePage.Next_Button().isDisplayed()){
            HomePage.Next_Button().click();
        } else{
            System.out.println("Next button us still not visible waiting 5 seconds");
            Thread.sleep(5000);
            HomePage.Next_Button().click();
        }
    }

//    Verify if Change option is available and then 4*4 Vehicle type is available and click on it
    public void SelectVehicleType() throws InterruptedException {
        homepageObjects HomePage = new homepageObjects(driver);
        if (HomePage.Change_Link().isDisplayed()) {
            HomePage.Change_Link().click();
            Thread.sleep(5000);
            if (HomePage.Vehicle_Type_Option().isDisplayed()) {
                System.out.println("4*4 Option is present hence selecting it.");
                HomePage.Vehicle_Type_Option().click();
            }
        }
    }

//    Verify the Get instant quote button is availale and click on it
    public void SubmitButton() throws InterruptedException {
        homepageObjects HomePage = new homepageObjects(driver);
        if(HomePage.Get_Quotation_Button().isDisplayed()){
            HomePage.Get_Quotation_Button().click();
        } else {
            Thread.sleep(5000);
            HomePage.Get_Quotation_Button().click();
        }
    }

//    Verify the Policy information page heading
    public String HeadingOfPage(){
        homepageObjects HomePage = new homepageObjects(driver);
        return HomePage.Policy_Information();
    }

}


