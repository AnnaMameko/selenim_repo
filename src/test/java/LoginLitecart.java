import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.WebElement;


public class LoginLitecart {

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
    public void login() throws InterruptedException {
        driver.get("http://localhost/litecart/admin/login.php?redirect_url=%2Flitecart%2Fadmin%2F");
        Thread.sleep(5000);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        Thread.sleep(5000);
        driver.findElement(By.name("login")).submit();
        Thread.sleep(5000);

    }

    @After
    public void stop(){
        driver.quit();
    }
}
