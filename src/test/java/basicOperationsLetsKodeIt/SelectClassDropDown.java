package basicOperationsLetsKodeIt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SelectClassDropDown {
    WebDriver driver;
    String baseURL;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseURL = "https://courses.letskodeit.com/practice";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void selectDropDown() throws InterruptedException {
        driver.get(baseURL);
        driver.findElement(By.xpath("//*[@id='carselect']")).click(); // own created
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\'carselect\']/option[3]")).click();//option 1,2 or 3, not index,copied xpath from website
        Thread.sleep(3000);


        //Select class for understanding
        // WebElement element = driver.findElement(By.id("carselect"));//3 dropdown id stored under "carselect" get stored in a list which is element
        //select is a predefine class in webdriver,
        // Select select = new Select(element);
        // select.selectByIndex(2);
        //  Thread.sleep(3000);
        // select.selectByValue("benz");
        // Select.selectByVisibleText("BMW");
    }

    @After
    public void tearDown() {

        driver.quit();
    }


}
