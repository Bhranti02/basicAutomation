package actionClassBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MouseHover {
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
    public void testMouseHover() throws InterruptedException {

        WebElement mainElement = driver.findElement(By.id("mousehover")); //we saved element of mouse hover into mainElement

        //action of mouse hover will be done by webdriver using pre-define Action class
        Actions action = new Actions(driver);  //creating object of actions class
        action.moveToElement(mainElement).perform(); //use perform to tell Actions class to perform after doing any action
        Thread.sleep(2000);

        WebElement subElement = driver.findElement(By.xpath("//a[text()='Top']"));
        subElement.click();
        Thread.sleep(2000);
        //action.moveToElement(subElement).click().perform(); //perform click using Actions class

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
