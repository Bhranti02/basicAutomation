package basicOperationsLetsKodeIt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ConfirmToAlert {
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
    public void confirmSwitch() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\'name\']")).sendKeys("Bhranti");
        driver.findElement(By.id("confirmbtn")).click();

        //to click ok on alert-box, we need to use alert class, we can not click on alert box, so we need to switch
        Alert alert = driver.switchTo().alert(); //driver switching to the alert box, marketing preference box
        //alert.accept();// to click on ok btn in alert box
        alert.dismiss();// to click on cancel btn
        Thread.sleep(2000);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}


