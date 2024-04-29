package com.example;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
       WebDriver driver=new ChromeDriver();
       driver.get("https://www.demoblaze.com/");
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
       WebElement element1=driver.findElement(By.linkText("Laptops"));
       element1.click();
       WebElement element2=driver.findElement(By.linkText("MacBook air"));
       element2.click();
       WebElement element3=driver.findElement(By.linkText("Add to cart"));
       element3.click();
       Thread.sleep(3000);
    //    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    //    Alert alert=wait.until(ExpectedConditions.alertIsPresent());
    //    alert.accept();
    driver.switchTo().alert().accept();
         WebElement element4=driver.findElement(By.id("cartur"));
       element4.click();
      String title=driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]")).getText();
      String price=driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[3]")).getText();
      System.out.println("Title:"+title+"\n"+"Price:"+price);
    }
}
