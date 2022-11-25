package nopCommerceAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DateOfBirthSelection {
    WebDriver driver;
    String baseURL;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseURL ="https://demo.nopcommerce.com/";
        driver.manage().window().maximize();
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void DOBDropDownSelection() throws InterruptedException {
        driver.findElement(By.className("ico-register")).click();
        driver.findElement(By.name("DateOfBirthDay")).click();
        Thread.sleep(2000);
    }



    @After
    public void tearDown(){
        driver.quit();
    }
}
