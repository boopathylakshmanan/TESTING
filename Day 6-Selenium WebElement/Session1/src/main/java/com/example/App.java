package com.example;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://economictimes.indiatimes.com/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='topnav']/div[10]/a")).click();
        Thread.sleep(3000);
        JavascriptExecutor js =  (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0, 800);");
        WebElement element1 = driver.findElement(By.xpath("//*[@id='amcSelection']"));
        Select select = new Select(element1);
        select.selectByVisibleText("Canara Robeco");
        Thread.sleep(3000);
        WebElement element2 = driver.findElement(By.xpath("//*[@id='schemenm']"));
        select = new Select(element2);
        select.selectByVisibleText("Canara Robeco Bluechip Equity Direct-G");
        Thread.sleep(3000);
        driver.findElement(By.linkText("Get Details")).click();
        Thread.sleep(3000);
        ArrayList<String> windowhandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowhandles.get(1));
        driver.findElement(By.xpath("//*[@id='installment_amt']/li/span")).click();
        driver.findElement(By.xpath("//*[@id='installment_amt']/li/span")).click();
        driver.findElement(By.xpath("//*[@id='installment_period']/li/span")).click();
        driver.findElement(By.xpath("//*[@id='installment_period']/li/ul/li[4]")).click();
        driver.findElement(By.xpath("//*[@id='mfNav']/div/ul/li[2]")).click();
        String res = driver.findElement(By.xpath("//*[@id='mfReturns']/div[2]/div[2]/ul/li[1]/table/tbody/tr[1]")).getText();
        System.out.println(res);
        

    }
}
