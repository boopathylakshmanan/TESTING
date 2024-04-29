package com.example;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {

    WebDriver driver;
    Logger logger = Logger.getLogger(getClass());

    @BeforeTest
    public void setUp() {
        PropertyConfigurator.configure("D:\\log_properties\\log4j2.properties");
        //logger.setLevel(Level.INFO); // Set log level to INFO
        logger.trace("Setting up WebDriver...");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        logger.trace("WebDriver initialized successfully.");
    }

    @Test
    public void test1() {
        logger.info("Starting test1...");
        driver.get("https://moneycontrol.com");
        logger.trace("Navigated to moneycontrol.com");
        driver.findElement(By.xpath("/html/body/div/div[1]/span/a")).click();
        logger.trace("Clicked on homepage link.");
    }

    @Test
    public void test2() throws IOException, InterruptedException {
        logger.info("Starting test2...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search_str\"]")));
        logger.trace("Search input found.");
        driver.findElement(By.xpath("//*[@id=\"search_str\"]"))
                .sendKeys("Reliance Industries" + Keys.ENTER);
        logger.trace("Searched for Reliance Industries.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"mc_mainWrapper\"]/div[3]/div[2]/div/table/tbody/tr[1]/td[1]/p/a")));
        logger.trace("Reliance Industries link found.");
        driver.findElement(By.xpath("//*[@id=\"mc_mainWrapper\"]/div[3]/div[2]/div/table/tbody/tr[1]/td[1]/p/a"))
                .click();
        logger.trace("Clicked on Reliance Industries link.");
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[@id=\"common_header\"]/div[1]/div[3]/nav/div/ul/li[10]")));
        logger.trace("Menu item found.");
        Actions actions = new Actions(driver);
        WebElement menu = driver.findElement(By.xpath("//*[@id=\"common_header\"]/div[1]/div[3]/nav/div/ul/li[10]"));
        WebElement submenu = driver.findElement(
                By.xpath("//*[@id=\"common_header\"]/div[1]/div[3]/nav/div/ul/li[10]/div/div/ul/li[2]/ul/li[5]"));

        actions.moveToElement(menu).pause(Duration.ofSeconds(2)).moveToElement(submenu).click().build().perform();
        logger.trace("Clicked on submenu item.");
        Select select = new Select(driver.findElement(By.xpath("//*[@id=\"ff_id\"]")));
        select.selectByVisibleText("Axis Mutual Fund");
        logger.trace("Selected Axis Mutual Fund.");
        Select select2 = new Select(driver.findElement(By.xpath("//*[@id=\"im_id\"]")));
        select2.selectByVisibleText("Axis Arbitrage Fund - Regular Plan (D)");
        logger.trace("Selected Axis Arbitrage Fund.");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"invamt\"]")).sendKeys("100,000");
        logger.trace("Entered investment amount.");
        driver.findElement(By.xpath("//*[@id=\"stdt\"]")).sendKeys("2021-08-02");
        logger.trace("Entered start date.");
        driver.findElement(By.xpath("//*[@id=\"endt\"]")).sendKeys("2023-08-17");
        logger.trace("Entered end date.");
        driver.findElement(By.xpath("//*[@id=\"mc_mainWrapper\"]/div[2]/div/div[3]/div[2]/div[2]/form/div[8]/input"))
                .click();
        logger.trace("Clicked on submit button.");
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         String path="D:\\q1.png";
         FileUtils.copyFile(file,new File(path));
    }

    @AfterTest
    public void tearDown() {
        logger.info("Quitting WebDriver...");
        driver.quit();
        logger.trace("WebDriver quit.");
    }
}
