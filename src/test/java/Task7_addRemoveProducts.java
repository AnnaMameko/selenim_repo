import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task7_addRemoveProducts {

    WebDriver driver;

    @Before
    public void start(){
        ChromeDriverManager.getInstance().setup();
        /*FirefoxDriverManager.getInstance().setup();
        OperaDriverManager.getInstance().setup();
        PhantomJsDriverManager.getInstance().setup();
        EdgeDriverManager.getInstance().setup();
        InternetExplorerDriverManager.getInstance().arch32().setup();*/

        driver = new ChromeDriver();
        /* driver = new FirefoxDriver();
        driver = new OperaDriver();
        driver = new PhantomJSDriver();
        driver = new EdgeDriver();
        driver = new InternetExplorerDriver(); */
    }

    @Test
    public void adminNavigateMenu_test() throws InterruptedException {

        //login
        driver.get("http://localhost/litecart_old/en/");

        //wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#box-most-popular li:first-child")));

        //add item to the cart
        for(int i = 0; i < 4; i++){
            int qty = Integer.parseInt(driver.findElement(By.cssSelector("#cart .quantity")).getText());
            driver.findElement(By.cssSelector("#box-most-popular li > a:first-child:not([href*='yellow'])")).click();
            //Select dropdown_size = new Select(driver.findElement(By.name("options[Size]")));
            //dropdown_size.selectByValue("Small");


           // Thread.sleep(3000);
            driver.findElement(By.name("add_cart_product")).click();
            wait.until(ExpectedConditions.textToBe(By.cssSelector("#cart .quantity"), String.valueOf(qty+1)));
            //Thread.sleep(3000);
            driver.navigate().back();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#box-most-popular li:first-child")));
           // Thread.sleep(3000);
        }

        driver.findElement(By.cssSelector("#cart .link ")).click();
        WebElement confirmOrder = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("confirm_order")));

      // WebElement confirmOrder = driver.findElement(By.name("confirm_order"));

        String url = driver.getCurrentUrl();
        while(!driver.findElements(By.cssSelector(".shortcut")).isEmpty()) {
            driver.findElements(By.cssSelector(".shortcut a")).get(0).click();
            driver.findElement(By.name("remove_cart_item")).click();
           // driver.get(url);
            driver.navigate().refresh();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".viewport")));
        }

        driver.findElement(By.name("remove_cart_item")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#checkout-cart-wrapper>p>em")));



    }

    @After
    public void stop(){
       driver.quit();
    }
}
