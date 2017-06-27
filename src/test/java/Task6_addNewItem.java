import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
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

public class Task6_addNewItem {

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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='app-']/a/span[2][contains(text(), 'Catalog')]")));

        driver.findElement(By.xpath(".//*[@id='app-']/a/span[2][contains(text(), 'Catalog')]")).click();
        driver.findElement(By.xpath(".//*[@id='main']/ul/li[3]/a")).click();

        //General tab
        driver.findElement(By.xpath(".//*[@id='category-id-0']/label")).isSelected();   //checkbox verification
        driver.findElement(By.xpath(".//*[@id='tab-general']/div/div[1]/div[4]/div/div/div[1]/label")).click();   //checkbox selection
        driver.findElement(By.name("date_valid_from")).sendKeys("02222017");
        driver.findElement(By.name("date_valid_to")).sendKeys("02222018");
        driver.findElement(By.name("code")).sendKeys("123");
        driver.findElement(By.name("name[en]")).sendKeys("newItem");
        driver.findElement(By.name("sku")).sendKeys("1");
        driver.findElement(By.name("gtin")).sendKeys("1");
        driver.findElement(By.name("taric")).sendKeys("1");
        driver.findElement(By.name("quantity")).sendKeys("1");
        driver.findElement(By.name("weight")).sendKeys("1");
        driver.findElement(By.name("dim_x")).sendKeys("1");
        driver.findElement(By.name("dim_y")).sendKeys("1");
        driver.findElement(By.name("dim_z")).sendKeys("1");

        //drop-down menu selection
        Select dropdown_delivery_status = new Select(driver.findElement(By.name("delivery_status_id")));
        dropdown_delivery_status.selectByValue("1");
        Select dropdown_sold_out_status = new Select(driver.findElement(By.name("sold_out_status_id")));
        dropdown_sold_out_status.selectByValue("2");

        //image uploading
        //You have to put “Product picture” file in project (resource) folder and use relative path instead of absolute:
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("qwerty.png").getFile());
        System.out.println(file.getAbsolutePath());
        driver.findElement(By.name("new_images[]")).sendKeys(file.getAbsolutePath().replaceAll("%20", " "));

        //Information tab
        driver.findElement(By.xpath(".//*[@id='main']/form/div/ul/li[2]/a")).click();
        Select dropdown_manufacturer_id = new Select(driver.findElement(By.name("manufacturer_id")));
        dropdown_manufacturer_id.selectByValue("1");
        Select dropdown_supplier_id = new Select(driver.findElement(By.name("supplier_id")));
        dropdown_supplier_id.selectByValue("");
        driver.findElement(By.name("keywords")).sendKeys("newItem");
        driver.findElement(By.name("short_description[en]")).sendKeys("newItem");
        driver.findElement(By.name("description[en]")).sendKeys("newItem");
        driver.findElement(By.name("attributes[en]")).sendKeys("newItem");
        driver.findElement(By.name("head_title[en]")).sendKeys("newItem");
        driver.findElement(By.name("meta_description[en]")).sendKeys("newItem");

        //Prices tab
        driver.findElement(By.xpath(".//*[@id='main']/form/div/ul/li[3]/a")).click();
        driver.findElement(By.name("purchase_price")).sendKeys("1");
        Select dropdown_purchase_price = new Select(driver.findElement(By.name("purchase_price_currency_code")));
        dropdown_purchase_price.selectByValue("EUR");
        Select dropdown_tax_class = new Select(driver.findElement(By.name("tax_class_id")));
        dropdown_tax_class.selectByValue("");
        driver.findElement(By.name("prices[USD]")).sendKeys("1");
        driver.findElement(By.name("gross_prices[USD]")).sendKeys("1");
        driver.findElement(By.name("prices[EUR]")).clear();
        driver.findElement(By.name("gross_prices[EUR]")).clear();
        driver.findElement(By.xpath(".//*[@id='main']/form/p/button[1]")).click();
        driver.findElement(By.linkText("newItem")).isDisplayed();

        //dropdown_delivery_status.selectByVisibleText("value");
        //dropdown_delivery_status.selectByIndex(1);

    }

   /// @After
    //public void stop(){
      //  driver.quit();
   // }
}
