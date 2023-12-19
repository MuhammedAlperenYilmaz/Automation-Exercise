
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.K;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

import java.time.Duration;

public class AutomationExercise {

    public static  void findWithXpath(WebDriver driver, String xpath, String... keysToSend) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
    }

    public static   void Actions (WebDriver driver, String xpath, String  ...keysToSend) {
        try {

            Actions actions = new Actions(driver);
            WebElement inputElement = driver.findElement(By.xpath(xpath));

            actions.click(inputElement);
            for (String keys : keysToSend) {
                actions.sendKeys(keys).sendKeys(Keys.TAB);
            }
            actions.perform();
        }
        catch (Exception e){
            Exception ex=e;
        }
    }
    public static void Click (WebDriver driver,String xpath) {
        Actions actions = new Actions(driver);
        WebElement inputElement = driver.findElement(By.xpath(xpath));
        actions.click(inputElement);
        actions.perform();

        try {

            Actions actions2 = new Actions(driver);
            WebElement inputElement2 = driver.findElement(By.xpath(xpath));
            actions.click(inputElement2);
            actions.perform();
        }
        catch (Exception e){
            Exception ex=e;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://automationexercise.com/");
        Click(driver,"//a[@href='/login']");
        Actions(driver, "//input[@data-qa='login-email']", "Test@tester.com", "123456");
        Click(driver,"//button[@data-qa='login-button']");

       Click(driver,"//a[@href='/products']");
       Click(driver,"//a[@href='#Men']");

       Click(driver,"//a[@href='/category_products/3']");

       Click(driver,"//a[@href='/product_details/43']");
        WebElement amount=driver.findElement(By.id("quantity"));
        amount.sendKeys(Keys.CONTROL+"a");
        amount.sendKeys(Keys.DELETE);
        amount.sendKeys("5");
        Click(driver,"//button[@class='btn btn-default cart']");
        Click(driver,"//a[@href='/view_cart']");
        Click(driver,"//a[@class='btn btn-default check_out']");
        Actions(driver,"//input[@name='name_on_card']","Test Tester","1234567891011121","123","12","1234");
        Click(driver,"//button[@data-qa='pay-button']");


        driver.close();
    }
}

