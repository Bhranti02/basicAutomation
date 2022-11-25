package basicOperationsLetsKodeIt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AlertBoxSendKey {
    WebDriver driver;
    String baseURL;
    String username = "Het Richa";

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseURL ="https://courses.letskodeit.com/practice";
        driver.manage().window().maximize();
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void sendKey() throws InterruptedException {

        driver.findElement(By.id("name")).sendKeys("P Patel");
        Thread.sleep(3000);
        driver.findElement(By.className("inputs")).sendKeys("erppatel@yahoo.co.uk");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".inputs"));//just to find element by css,then to click use .click()
        System.out.println("found");
        //driver.findElement(By.id("name")).sendKeys(username);//global variable string username,work for any username
        //Thread.sleep(3000);

    }
    @After
    public void tearDown(){
        driver.quit();
    }


}
