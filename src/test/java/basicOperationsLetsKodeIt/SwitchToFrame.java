package basicOperationsLetsKodeIt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SwitchToFrame {
    WebDriver driver;
    String baseURL;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseURL = "https://courses.letskodeit.com/practice";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @Test
    public void testFrame() throws InterruptedException {
        //this won't work because search box is in iframe, so we need to switch to iframe first
        // driver.findElement(By.id("search")).sendKeys("python");
        //driver.findElement(By.xpath("//*[@class='fa fa-search']")).click();

        // Switch to frame by Id
        driver.switchTo().frame("courses-iframe");
        Thread.sleep(1000);

        // Switch to frame by name
        // driver.switchTo().frame("iframe-name");
        // Switch to frame by index-number
        // driver.switchTo().frame(0);
        WebElement searchBox = driver.findElement(By.cssSelector("input[placeholder='Search Course']"));  //storing driver.findelemet into webelement  searchbox
        searchBox.sendKeys("python");
        //searchBox.findElement(By.xpath("//*[@class='fa fa-search']")).click(); //after entering python,find & click on search symbol

        searchBox.sendKeys(Keys.ENTER); //after entering python, using keyboard press enter key
        Thread.sleep(3000);

        // to go back on main page from iframe
        driver.switchTo().defaultContent();
        driver.findElement(By.id("openwindow")).click(); //find openwindow & click on it
        Thread.sleep(6000);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
