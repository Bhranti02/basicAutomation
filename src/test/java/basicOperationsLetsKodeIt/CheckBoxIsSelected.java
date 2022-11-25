package basicOperationsLetsKodeIt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckBoxIsSelected {
    WebDriver driver;
    String baseURL;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseURL = "https://courses.letskodeit.com/practice";
        driver.manage().window().maximize();
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @Test
    public void tickCheckBoxElement() throws InterruptedException {
        driver.findElement(By.id("bmwcheck")).click();  // click will tick the box
        Thread.sleep(2000);

        //How to check if box is ticked or not // ans will be in true or false
        System.out.println(driver.findElement(By.id("bmwcheck")).isSelected());  // by using isSelected,it will check if box is ticked or not
        Thread.sleep(2000);

        System.out.println(driver.findElement(By.xpath("//*[@id=\'benzcheck']")).isSelected());//box not ticked,so ans will be false
        Thread.sleep(2000);
        //driver.findElement(By.id("hondacheck")).click();
        //Thread.sleep(2000);
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
