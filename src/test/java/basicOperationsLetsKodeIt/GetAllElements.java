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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GetAllElements {
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
    public void printAllElements() throws InterruptedException {
        WebElement element = driver.findElement(By.id("multiple-select-example"));
        Select select = new Select(element);
        select.selectByIndex(0);
        Thread.sleep(3000);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByIndex(2);
        Thread.sleep(3000);
        List<WebElement> selectedOptions = select.getAllSelectedOptions();//create list called webelement which include all selected options
        for (WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
