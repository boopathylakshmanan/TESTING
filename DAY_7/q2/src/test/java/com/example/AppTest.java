package com.example;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {

    WebDriver driver;
    
    @BeforeTest
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        driver = new ChromeDriver(chromeOptions);
    }
    
    @Test
    public void test1() {
        driver.get("https://moneycontrol.com");
        driver.findElement(By.xpath("/html/body/div/div[1]/span/a")).click();;
    }
    @Test
    public void test2() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search_str\"]")));
         driver.findElement(By.xpath("//*[@id=\"search_str\"]")).sendKeys("Reliance Industries"+Keys.ENTER);
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mc_mainWrapper\"]/div[3]/div[2]/div/table/tbody/tr[1]/td[1]/p/a")));
         driver.findElement(By.xpath("//*[@id=\"mc_mainWrapper\"]/div[3]/div[2]/div/table/tbody/tr[1]/td[1]/p/a")).click();
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"common_header\"]/div[1]/div[3]/nav/div/ul/li[10]")));
         Actions actions = new Actions(driver);
         WebElement menu = driver.findElement(By.xpath("//*[@id=\"common_header\"]/div[1]/div[3]/nav/div/ul/li[10]"));
         WebElement submenu = driver.findElement(By.xpath("//*[@id=\"common_header\"]/div[1]/div[3]/nav/div/ul/li[10]/div/div/ul/li[2]/ul/li[5]"));
         
         actions.moveToElement(menu)
                .pause(Duration.ofSeconds(2))
                .moveToElement(submenu)
                .click()
                .build()
                .perform();
                Select select=new Select(driver.findElement(By.xpath("//*[@id=\"ff_id\"]")));
                select.selectByVisibleText("Axis Mutual Fund");
                Select select2=new Select(driver.findElement(By.xpath("//*[@id=\"im_id\"]")));
                select2.selectByVisibleText("Axis Arbitrage Fund - Regular Plan (D)");
                driver.findElement(By.xpath("//*[@id=\"invamt\"]")).sendKeys("100,000");
                driver.findElement(By.xpath("//*[@id=\"stdt\"]")).sendKeys("2021-08-02");
                driver.findElement(By.xpath("//*[@id=\"endt\"]")).sendKeys("2023-08-17");
                driver.findElement(By.xpath("//*[@id=\"mc_mainWrapper\"]/div[2]/div/div[3]/div[2]/div[2]/form/div[8]/input")).click();
                }
   
    @AfterTest
    public void tearDown() {
        //driver.quit();
    }
}
