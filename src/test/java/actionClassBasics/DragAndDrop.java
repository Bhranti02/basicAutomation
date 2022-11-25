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

public class DragAndDrop {
    WebDriver driver;
    String baseURL;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseURL = "https://jqueryui.com/droppable/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @Test
    public void testDragAndDrop() throws InterruptedException {
        driver.switchTo().frame(0); //there was no class or id so use index number to move to frame

        WebElement from = driver.findElement(By.id("draggable"));
        WebElement to = driver.findElement(By.id("droppable"));

        Actions action = new Actions(driver);
        // Drag and Drop
        action.dragAndDrop(from, to).build().perform();
        Thread.sleep(3000);

        //click and hold,move to element, release, build and perform
        //action.clickAndHold(from).moveToElement(to).build().perform();
        //Thread.sleep(2000);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
