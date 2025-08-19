package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;
    public BasePage(){
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver),this);
    }

    public void waitForVisibility(By locator){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(By element){
        waitForVisibility(element);
        driver.findElement(element).click();
    }

    public void inpuTextField(By locator, String textToInput){
        waitForVisibility(locator);
        driver.findElement(locator).sendKeys(textToInput);
    }

    public String getAttribute(By locator, String attributeName){
        waitForVisibility(locator);
        return driver.findElement(locator).getAttribute(attributeName);
    }

    //Scrolling utility
    public void scroll(String direction, By locator){
        //TODO
    }
    //Calendar utility to select date
    public void selectDate(String date, String month, String year, By callocator){
        //TODO
    }

    //Select WebContent
    public void switchView(){

    }

}
