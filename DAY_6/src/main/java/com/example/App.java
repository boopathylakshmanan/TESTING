package com.example;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.moneycontrol.com/");
        Thread.sleep(15000);
        driver.findElement(By.id("search_str")).sendKeys("Reliance Industries");
        Thread.sleep(8000);
        driver.findElement(By.partialLinkText("Reliance Industries")).click();
        Thread.sleep(3000);
        String s=driver.findElement(By.xpath("//*[@id='stockName']/h1")).getText();
        if(s.equals("Reliance Industries"))
        {
            System.out.println("Got Stock Details of Reliance Industries");
        }
        else
        {
            System.out.println("Fails to get");
        }
        driver.findElement(By.linkText("Mutual Funds")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("SIP")).click();


	}

}