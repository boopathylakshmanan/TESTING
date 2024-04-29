package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        WebDriver driver4=new ChromeDriver();
        driver4.manage().window().maximize();
        driver4.get("https://www.shoppersstop.com/");
        driver4.findElement(By.className("user-icon")).click();
    }
}
