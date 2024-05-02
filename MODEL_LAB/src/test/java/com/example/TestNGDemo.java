package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGDemo {
    WebDriver driver;
    @BeforeTest
    public void BeforeMethod()
    {

      WebDriverManager.chromedriver().setup();;
      driver=new ChromeDriver();
    }
@Test
public void Test2()
{
 driver.get("https://google.com");
}
@Test
public void Test1() throws InterruptedException
{ 
    driver.get("https://bing.com");
  //   driver.findElement(By.name("q")).sendKeys("Sung Jin woo"+Keys.ENTER);
  //   // driver.findElement(By.linkText("Images")).click();
  //   // Thread.sleep(Duration.ofSeconds(5));
  // Assert.assertEquals("Sung Jin woo - Google Search", driver.getTitle());
}
@AfterTest
public void AfterMethod()
{
  driver.quit();

}
}
