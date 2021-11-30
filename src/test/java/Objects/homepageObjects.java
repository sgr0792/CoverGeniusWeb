package Objects;

import org.openqa.selenium.By;
import Pages.homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homepageObjects extends homePage {
    WebDriver driver;
    public homepageObjects(WebDriver driver){
        this.driver = driver;
    }
    public WebElement Country_Field(){
        return driver.findElement(By.xpath("//div[@class=\"Field-iconWrapper\"]//..//input[@placeholder=\"Select or type a country\"]"));
    }

    public WebElement From_Date(){
        return driver.findElement(By.xpath("//div[@class=\"QuoteForm-fromDate\"]"));
    }

    public WebElement To_date(){
        return driver.findElement(By.xpath("//div[@class=\"QuoteForm-toDate\"]"));
    }

    public WebElement Day_date(String Date){
        return driver.findElement(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//..//td[@data-handler=\"selectDay\"]//a[contains(.,"+Date+")]"));
    }

    public WebElement Month_Year_Name(String Value){
        return driver.findElement(By.xpath("//span[@class=\"ui-datepicker-"+Value+"\"][1]"));
    }

    public WebElement Next_Button(){
        return driver.findElement(By.xpath("//div[@class=\"ui-datepicker-group ui-datepicker-group-last\"]//a[@data-handler=\"next\"]//span[contains(.,\"Next\")]"));
    }

    public WebElement Change_Link(){
        return driver.findElement(By.xpath("//a[@aria-controls=\"QuoteForm-vehicleType-field\"]//strong"));
    }

    public WebElement Vehicle_Type_Option(){
        return driver.findElement(By.xpath("//select[@name=\"QuoteForm[VehicleType]\"]//option[contains(.,\"4x4\")]"));
    }

    public WebElement Get_Quotation_Button(){
        return driver.findElement(By.xpath("//button[@type=\"submit\"]//span[contains(.,\"Get Your Instant Quote\")]"));
    }

    public String Policy_Information(){
        return driver.findElement(By.xpath("//h2[@id=\"policy-inclusions\"]")).getText();
    }

}
