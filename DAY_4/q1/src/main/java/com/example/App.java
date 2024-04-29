package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
        WebDriver chromedriver=new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
        WebDriver fireFoxDriver=new FirefoxDriver();
        WebDriverManager.edgedriver().setup();
        WebDriver edgeDriver=new EdgeDriver();
    }
}
