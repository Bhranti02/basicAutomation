package nopCommerceAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Register {

    WebDriver driver;
    String baseURL;

    @Before
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseURL = "https://demo.nopcommerce.com/";
        driver.manage().window().maximize();
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void registerOnNopcommerce() throws InterruptedException {
        driver.findElement(By.className("ico-register")).click();
        driver.findElement(By.xpath("//*[@id='FirstName']")).sendKeys("Raina");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='LastName']")).sendKeys("Patel");
        Thread.sleep(2000);
        driver.findElement(By.id("Email")).sendKeys("bpp" + Math.random() + "@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("Password")).sendKeys("abc123");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("abc123");
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(2000);

    }

    @After
    public void tearDown(){
        driver.quit();
    }


}
