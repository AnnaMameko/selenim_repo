import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

/**
 * Created by anna.mameko on 6/23/2017.
 */
public class Task4_sectionsOnAdminPage {
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
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).submit();

        //wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='app-']/a/span[2][contains(text(), 'Appearance')]")));

        //menu
        List<WebElement> mainList = driver.findElements(By.xpath(".//*[@id='app-']"));

        for (int j = 0; j < mainList.size(); j++) {
            WebElement element = driver.findElement(By.xpath(".//*[@id='app-'][" + (j+1) + "]"));
            element.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h1")));

            List<WebElement> subList = driver.findElements(By.cssSelector(".docs li"));

            if(subList.size() >= 2) {
                for (int i = 1; i < subList.size(); i++) {
                    WebElement child = driver.findElement(By.cssSelector(".docs li:nth-child(" + (i+1) + ")"));
                    child.click();
                }
            }
        }
    }
    @After
    public void stop(){
        driver.quit();
    }
}
