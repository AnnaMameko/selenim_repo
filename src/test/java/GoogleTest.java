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

public class GoogleTest {

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
    public void google_test() throws InterruptedException {
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        Thread.sleep(9000);
        driver.findElement(By.name("btnG")).click();
        Thread.sleep(9000);
    }

    @After
    public void stop(){
        driver.quit();
    }
}


        /*driver.findElement(By.xpath(".//*[@id='app-']/a/span[2][contains(text(), 'Appearance')]")).click();
        driver.findElement(By.tagName("h1"));
        driver.findElement(By.xpath(".//*[@id='doc-template']/a/span[contains(text(), 'Template')]")).click();*/

         /*JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("document.addEventListener(\"DOMContentLoaded\", function(){ return " +
                "document.querySelector(\"Appearence\",\"Template\" ) });");*/

         /*for (WebElement el: mainList) {
                 List<WebElement> subList = el.findElements(By.cssSelector(".docs li"));
        }*/