package nopCommerceAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FindElements {
    WebDriver driver;
    String baseURL;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseURL = "https://demo.nopcommerce.com/";
        driver.manage().window().maximize();
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void findElementsInNopcommerce() throws InterruptedException {
        System.out.println("Nopcommerce opened");
        driver.findElement(By.className("ico-register"));
        System.out.println("register button found");
        driver.findElement(By.cssSelector(".header-links"));
        System.out.println("Wishlist button found");
        // driver.findElement(By.linkText("/login?returnUrl=%2F")); //not working
        // System.out.println("login button found");
        driver.findElement(By.id("small-search-box-form"));
        System.out.println("searchbox");
        driver.findElement(By.xpath("//*[text()=\'Shopping cart\']"));
        System.out.println("shopping-cart");

    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
