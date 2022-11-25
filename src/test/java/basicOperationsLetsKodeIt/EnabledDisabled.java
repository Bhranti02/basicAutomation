package basicOperationsLetsKodeIt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class EnabledDisabled {
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
    public void checkEnableDisable() throws InterruptedException {
        driver.findElement(By.id("disabled-button")).click();
        System.out.println("Box is disabled");

        driver.findElement(By.id("enabled-button")).click();
        if (driver.findElement(By.id("enabled-button")).isEnabled()) {
            driver.findElement(By.id("enabled-example-input")).clear();   // to clear if anything already written in box
            driver.findElement(By.id("enabled-example-input")).sendKeys("Bye Bye");
        }
        Thread.sleep(2000);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
