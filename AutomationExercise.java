import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
public class AutomationExercise {
    public static void Actions (WebDriver driver, String xpath, String  ...keysToSend) {
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
            Exception exception=e;
        }
    }
    public static void Click (WebDriver driver,String xpath) {
        try {

            Actions actions = new Actions(driver);
            WebElement inputElement = driver.findElement(By.xpath(xpath));
            actions.click(inputElement);
            actions.perform();
        }
        catch (Exception e){
            Exception exception=e;
        }
    }
    public static void performLogin(WebDriver driver, String email, String password) {
        Click(driver, "//a[@href='/login']");
        Actions(driver, "//input[@data-qa='login-email']", email, password);
        Click(driver, "//button[@data-qa='login-button']");
    }

    public static void checkout(WebDriver driver, String quantity) {
        WebElement amount = driver.findElement(By.id("quantity"));
        amount.sendKeys(Keys.CONTROL + "a");
        amount.sendKeys(Keys.DELETE);
        amount.sendKeys(quantity);

        Click(driver, "//button[@class='btn btn-default cart']");
        Click(driver, "//a[@href='/view_cart']");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Click(driver, "//a[@class='btn btn-default check_out']");
    }
    public static void advert (WebDriver driver,String path)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath(path));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://automationexercise.com/");

        performLogin(driver, "Test@tester.com", "123456");
        advert(driver,"//a[@href='#Men']");
        advert(driver,"//a[@href='/product_details/43']");
        checkout(driver, "5");
        advert(driver,"//a[@href='/payment']");
        Actions(driver, "//input[@name='name_on_card']", "Test Tester", "1234567891011121", "123", "12", "1234");
        Click(driver, "//button[@data-qa='pay-button']");
        driver.close();
    }
}

