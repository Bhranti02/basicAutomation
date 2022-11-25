package basicOperationsLetsKodeIt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class KeyPressSignIn {
    WebDriver driver;
    String baseURL;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseURL = "https://courses.letskodeit.com/practice";
        driver.manage().window().maximize();
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testKeyPress() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\'navbar-inverse-collapse']/div/div/a")).click();
        driver.findElement(By.cssSelector(".parrot .form-control ")).sendKeys("test@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".parrot .form-control ")).sendKeys(Keys.TAB);  //to go on next tab
        driver.findElement(By.id("password")).sendKeys("abc123");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".content-style .dynamic-button ")).sendKeys(Keys.ENTER);  //to press enter after login details
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

