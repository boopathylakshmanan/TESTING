package com.example;
import java.time.Duration;

import javax.swing.text.html.parser.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class whatsapp {

 public static void main(String args[]) throws Exception
 {  WebDriverManager.chromedriver().setup();
   WebDriver driver=new ChromeDriver();
   driver.manage().window().maximize();
  //  Thread.sleep('3');
  driver.get("https://web.whatsapp.com/");
  Thread.sleep(10000);
  //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));

  // WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
  // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div/div[2]/div[4]/div")));
  // WebElement Just=driver.findElement(By.xpath("//*[text()='Just me']"));
  // Just.click();
   driver.close();
 }
}
