package basicOperationsLetsKodeIt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandles {

    WebDriver driver;
    String baseURL;

    @Before
    public void setUP() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        baseURL = "https://courses.letskodeit.com/practice";
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void windowHandlingPractice() throws InterruptedException {
        String parentHandle = driver.getWindowHandle();
        System.out.println(parentHandle);
        System.out.println("This is my parent window handle");

        //new window open
        driver.findElement(By.id("openwindow")).click(); // opens new window so now 2 window handle so need to use windowHandles

        Set<String> handles = driver.getWindowHandles(); // we put all window handle in Set to store unique element
        System.out.println(handles);                     // print all handles
        Thread.sleep(2000);

        for (String handle : handles) {               //saying all windowHandles in handles, we put in handle one by one
            System.out.println(handle);
            if (!handle.equals(parentHandle)) {       // if it's not parent handle  (but child handle)
                driver.switchTo().window(handle);       //then switch to this child handle
                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[@id='navbar-inverse-collapse']/div/div/a")).click();  //click on sign in on new window
                Thread.sleep(4000);
                driver.close();                          // close the new window
                break;
            }
        }
        Thread.sleep(3000);

        driver.switchTo().window(parentHandle);            // switch to main window
        driver.findElement(By.id("name")).sendKeys("Test");
        Thread.sleep(2000);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

