package basicOperationsLetsKodeIt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class IsDisplayed {
    WebDriver driver;
    String baseURL;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseURL ="https://courses.letskodeit.com/practice";
        driver.manage().window().maximize();
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void hideShowBox() throws InterruptedException {

        driver.findElement(By.id("hide-textbox")).click();
        System.out.println(driver.findElement(By.id("displayed-text")).isDisplayed());
        Thread.sleep(2000);

//        driver.findElement(By.id("show-textbox")).click();
//        System.out.println(driver.findElement(By.id("displayed-text")).isDisplayed()); //true or false ans
//        Thread.sleep(2000);

        driver.findElement(By.id("show-textbox")).click();
        if(driver.findElement(By.id("displayed-text")).isDisplayed()){                      // after finding display box,write in it
           driver.findElement(By.id("displayed-text")).sendKeys("Bhranti is doing well");
        }
        Thread.sleep(2000);

    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
