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
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by anna.mameko on 6/23/2017.
 */
public class Task5_regularAndDiscountPrices {
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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='box-campaigns']/h3[contains(text(), 'Campaign')]")));

        WebElement mainPageProductName = driver.findElement(By.xpath(".//*[@id='box-campaigns']/div/ul/li/a[1]/div[2][contains(text(), 'Yellow Duck')]"));
        WebElement mainPageRegularPrice = driver.findElement(By.xpath(".//*[@id='box-campaigns']/div/ul/li/a[1]/div[4]/s[contains(text(), '$20')]"));
        WebElement mainPageDiscountPrice = driver.findElement(By.xpath(".//*[@id='box-campaigns']/div/ul/li/a[1]/div[4]/strong[contains(text(), '$18')]"));

        //mainPage

        Assert.assertTrue(mainPageProductName.getText().contains("Yellow Duck"));
        Assert.assertTrue(mainPageRegularPrice.getText().contains("$20"));
        Assert.assertTrue(mainPageDiscountPrice.getText().contains("$18"));
        Assert.assertEquals(mainPageRegularPrice.getCssValue("color"), "rgba(119, 119, 119, 1)");
        Assert.assertEquals(mainPageDiscountPrice.getCssValue("color"), "rgba(204, 0, 0, 1)");
        Assert.assertEquals(mainPageRegularPrice.getCssValue("text-decoration-line"), "line-through");
        Assert.assertEquals(mainPageDiscountPrice.getCssValue("font-weight"), "bold");
        System.out.println("mainPage view correct");

        mainPageProductName.click();

        WebElement itemPageProductName = driver.findElement(By.xpath(".//*[@id='box-product']/div[1]/h1[contains(text(), 'Yellow Duck')]"));
        WebElement itemPageRegularPrice = driver.findElement(By.xpath(".//*[@id='box-product']/div[2]/div[2]/div[2]/s[contains(text(), '$20')]"));
        WebElement itemPageDiscountPrice = driver.findElement(By.xpath(".//*[@id='box-product']/div[2]/div[2]/div[2]/strong[contains(text(), '$18')]"));

        Assert.assertTrue(itemPageProductName.getText().contains("Yellow Duck"));
        Assert.assertTrue(itemPageRegularPrice.getText().contains("$20"));
        Assert.assertTrue(itemPageDiscountPrice.getText().contains("$18"));
        Assert.assertEquals(itemPageRegularPrice.getCssValue("color"), "rgba(119, 119, 119, 1)");
        Assert.assertEquals(itemPageDiscountPrice.getCssValue("color"), "rgba(204, 0, 0, 1)");
        Assert.assertEquals(itemPageRegularPrice.getCssValue("text-decoration-line"), "line-through");
        Assert.assertEquals(itemPageDiscountPrice.getCssValue("font-weight"), "bold");
        System.out.println("itemPage view correct");

        /*
        Assert.assertEquals(mainPageProductNameText,itemPageProductNameText);
        Assert.assertEquals(mainPageRegularPriceText,itemPageRegularPriceText);
        Assert.assertEquals(mainPageRegularPriceColor,itemPageRegularPriceColor);
        Assert.assertEquals(mainPageRegularPriceLine,itemPageRegularPriceLine);
        Assert.assertEquals(mainPageDiscountPriceText,itemPageDiscountPriceText);
        //Assert.assertEquals(mainPageDiscountPriceColor,itemPageDiscountPriceColor);
        Assert.assertEquals(mainPageDiscountPriceFont,itemPageDiscountPriceFont);
        /*


        /*
        final Price price = new Price(mainPageDiscountPrice.getCssValue("color"), "font-weight");
        //final Price price2 = new Price(itemPageDiscountPrice.getCssValue("color"), "font-weight");

        Assert.assertEquals(price.getColour(), "rgba(204, 0, 0, 1)");
        //Assert.assertEquals(price2.getColour(), "rgba(204, 0, 0, 1)");

        System.out.println(price);
        */

    }

    @After
    public void stop(){
        driver.quit();
    }
}

