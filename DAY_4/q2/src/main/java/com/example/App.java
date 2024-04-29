package com.example;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();
        // driver.get("https://www.shoppersstop.com/");
        // driver.findElement(By.className("user-icon")).click();
        driver.get("https://www.youtube.com");
        String id1=driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com");
        String id2=driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.yahoo.com");
        String id3=driver.getWindowHandle();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
          driver.switchTo().window(id1);
          System.out.println(driver.getTitle());
    }
}
