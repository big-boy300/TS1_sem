import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;


import java.time.Duration;

public class UserMainPage {

    private final WebDriver driver;

    public UserMainPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://demo.opencart.com/");
//        driver.get("https://www.opencart.com/index.php?route=cms/demo");
        PageFactory.initElements(driver, this);
    }

    public UserMainPage clickOn(String xpath){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        WebElement element = driver.findElement(By.xpath(xpath));
        wait.until(ExpectedConditions.visibilityOf(element));
        Utils.jsClick(element, driver);
        return this;
    }

    public UserMainPage clickOnShowingUpWindow(String xpath){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element = driver.findElement(By.xpath(xpath));
        wait.until(ExpectedConditions.visibilityOf(element));
        Utils.jsClick(element, driver);
        return this;
    }

    public UserMainPage chooseInSlidingArea(String xpath, String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Select selectVar = new Select(driver.findElement(By.xpath(xpath)));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        selectVar.selectByVisibleText(text);
        return this;
    }

    public boolean isPresentOnPage(String xpath){
        WebElement element = driver.findElement(By.xpath(xpath));
        return element.isDisplayed();
    }

    public UserMainPage fillTextArea(String xpath, String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement textArea = driver.findElement(By.xpath(xpath));
        wait.until(ExpectedConditions.visibilityOf(textArea));
        textArea.sendKeys(text);
        return this;
    }

    public UserMainPage clickOnTrial(String xpath){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath(xpath));
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"cms-demo\"]/div[2]/div/div[1]/div/img")));
        actions.click().perform();
//                wait.until(ExpectedConditions.visibilityOf(element));
//        Utils.jsClick(element, driver);
//        element.click();
        return this;
    }

}
