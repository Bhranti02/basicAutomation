package basicOperationsLetsKodeIt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void windowHandlingPractice() throws InterruptedException {
        String parentHandle = driver.getWindowHandle();
        System.out.println("This is parentHandle");

        //new window open
        driver.findElement(By.id("openwindow")).click();
        Set<String> handles = driver.getWindowHandles();
        Thread.sleep(2000);
        System.out.println(handles);

        for (String handle : handles) {
            System.out.println(handle);
            if (!handles.equals(parentHandle)) {
                driver.switchTo().window(handle);
                Thread.sleep(3000);
                driver.findElement(By.xpath("//*[@id='navbar-inverse-collapse']/div/div/a")).click();
                Thread.sleep(3000);
                driver.close();
                break;
            }
        }

        Thread.sleep(3000);
        driver.switchTo().window(parentHandle);
        driver.findElement(By.id("name")).sendKeys("Test");
        Thread.sleep(2000);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

