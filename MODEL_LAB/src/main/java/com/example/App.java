package com.example;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      WebDriverManager.chromedriver().setup();
       WebDriver driver =new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://www.google.com/");
      driver.close();

      

    }
}
