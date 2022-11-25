package basicOperationsLetsKodeIt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class KeyPressWindowOpen {

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
        // driver.findElement(By.id("openwindow")).sendKeys(Keys.CONTROL + "a"); // to select the all area of website,1st way
        Thread.sleep(2000);
        //driver.findElement(By.id("openwindow")).sendKeys(Keys.chord(Keys.CONTROL, "a")); //to select all the area of website,2nd way
        Thread.sleep(2000);

        // String selectAll = Keys.chord(Keys.CONTROL, "a");  //3rd way using select-class
        // driver.findElement(By.id("openwindow")).sendKeys(selectAll);
        Thread.sleep(2000);

        Actions action = new Actions(driver);   //4th way using action class
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        Thread.sleep(3000);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
