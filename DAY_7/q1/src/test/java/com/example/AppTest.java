package com.example;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        driver.get("https://economictimes.indiatimes.com/et-now/results");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"topnav\"]/div[10]/a")));
        driver.findElement(By.xpath("//*[@id=\"topnav\"]/div[10]/a")).click();
    }
    @Test
    public void test2() {
        WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"amcSelection\"]")));
        Select select=new Select(driver.findElement(By.xpath("//*[@id=\"amcSelection\"]")));
        select.selectByVisibleText("Canara Robeco");
    }
    @Test
    public void test3() {
        WebDriverWait wait3=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"schemenm\"]")));
        Select select=new Select(driver.findElement(By.xpath("//*[@id=\"schemenm\"]")));
        select.selectByVisibleText("Canara Robeco Bluechip Equity Direct-G");
        driver.findElement(By.xpath("//*[@id=\"anchor3\"]")).click();
    }
    @Test
    public void test4() {
        for(String handle : driver.getWindowHandles())
        {
            if(!handle.equals(driver.getWindowHandle()))
            {
                driver.switchTo().window(handle);
                break;
            }
        }
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[3]/ul/li")));
        driver.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[3]/ul/li")).click();
        driver.findElement(By.xpath("//*[@id=\"installment_amt\"]/li/ul/li[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"installment_period\"]/li")).click();
        driver.findElement(By.xpath("//*[@id=\"installment_period\"]/li/ul/li[4]")).click();
    }
    @Test
    public void test5()
    {
        driver.findElement(By.xpath("//*[@id=\"mfNav\"]/div/ul/li[2]")).click();
        WebElement table=driver.findElement(By.xpath("//*[@id=\"mfReturns\"]/div[2]/div[2]/ul/li[1]/table/tbody/tr[1]"));
        List<WebElement> data=table.findElements(By.tagName("td"));
        for(WebElement it:data)
        {
            System.out.println(it.getText());
        }
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
