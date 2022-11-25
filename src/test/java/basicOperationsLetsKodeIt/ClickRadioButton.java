package basicOperationsLetsKodeIt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ClickRadioButton {
    WebDriver driver;
    String baseURl;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        baseURl = "https://courses.letskodeit.com/practice";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testClickRadioButton() throws InterruptedException {
        driver.get(baseURl);
        driver.findElement(By.id("benzradio")).click();
        Thread.sleep(3000);

        try {                          //if any middle test fails put in try & catch ,so rest test can run
            driver.findElement(By.name("car")).click(); // exception : no such element found "car"
        } catch (Exception e) {
            System.out.println(e);
        }

        driver.findElement(By.name("cars")).click(); //"cars" name not unique, so it will click first cars & not go for 2nd or 3rd,click on bmw
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@value='honda']")).click();
        Thread.sleep(3000);


    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
