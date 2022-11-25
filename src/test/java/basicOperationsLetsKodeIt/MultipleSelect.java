package basicOperationsLetsKodeIt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class MultipleSelect {
    WebDriver driver;
    String baseURL;

    @Before
    public void setUP() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseURL = "https://courses.letskodeit.com/practice";
        driver.manage().window().maximize();
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void multipleSelect() throws InterruptedException {
        // driver.findElement(By.xpath("//option[text()=\'Apple\']")).click(); // own created
        // Thread.sleep(3000);
        // driver.findElement(By.id("multiple-select-example")).click();
        //Thread.sleep(3000);

        // WebElement is a predefine class, create object and store the options in element
        WebElement element = driver.findElement(By.id("multiple-select-example"));//element is a list which include all items under "multiple-select-example"
        Select select = new Select(element); //select is an object of list - element
        select.selectByIndex(0);
        Thread.sleep(3000);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByIndex(2);
        Thread.sleep(3000);
        select.deselectByIndex(0);
        Thread.sleep(3000);
        select.selectByVisibleText("Apple");
        Thread.sleep(2000);
        select.selectByValue("peach");
        Thread.sleep(2000);


    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
