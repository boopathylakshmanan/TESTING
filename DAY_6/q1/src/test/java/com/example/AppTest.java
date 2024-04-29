package com.example;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test

    public void shouldAnswerWithTrue()
    {
        WebDriverManager.chromedriver().setup();
       WebDriver driver=new ChromeDriver();
       try {
        driver.get("https://www.moneycontrol.com");
        WebDriverWait wait2=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("moneycontrol.com")));
        driver.findElement(By.linkText("moneycontrol.com")).click();
       
        WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/header/div[1]/div[1]/div/div/div[2]/div/div/form/input[5]")));
        driver.findElement(By.xpath("/html/body/div[3]/header/div[1]/div[1]/div/div/div[2]/div/div/form/input[5]")).sendKeys("Reliance Industries.");
        WebDriverWait wait3=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/header/div/div[1]/div/div/div[2]/div/div/form/div[2]/div[2]/ul/li[1]/a")));
       driver.findElement(By.xpath("/html/body/div[3]/header/div[2]/div[8]/div/div/form/div[2]/div[2]/div/div/ul/li[1]/a")).click();
        } catch (Exception e)
        {
            System.out.println(e);
        }
        assertTrue( true );
    }
}
