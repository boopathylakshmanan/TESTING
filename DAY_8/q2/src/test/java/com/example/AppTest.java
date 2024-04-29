package com.example;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    WebDriver driver;
    ExtentReports reports;
    ExtentTest test;
    Wait<WebDriver> wait;
    String URL = "https://www.demoblaze.com/";
    @BeforeTest
    public void bm() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("D:\\ExtentHtmlReporter\\report4.html");
        reports = new ExtentReports();
        reports.attachReporter(sparkReporter);
        test = reports.createTest("testname", "testdescription");
        
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    @Test
    public void Test1() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get(URL);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Laptops")).click();
        WebElement mac = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("MacBook air")));
        mac.click();

        WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to cart")));
        add.click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Cart")));
        cart.click();

        WebElement check = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr/td[2]")));

        if (check.getText().equals("MacBook air")) {
            System.out.println("Selected product verified");
        } else {
            System.out.println("Selected product is invalid");
        }
    }
    @Test(dataProvider = "dat1")
    public void Test2(String username,String password) throws InterruptedException {
        driver.get(URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Log in")).click();

        // login
        WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        user.sendKeys(username);
        driver.findElement(By.id("loginpassword")).sendKeys(password);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]")).click();

        WebElement profile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
        if (profile.getText().equals("Welcome Testalpha")) {
            System.out.println("Login Confirmed");
        } else {
            System.out.println("Login Failed");
        }
    }
    @AfterTest
    public void am(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Testcase failed: " + result.getName());
            test.log(Status.FAIL, "Test case failed reason: " + result.getThrowable());
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = "D:\\" + result.getName() + ".png"; // Changed path to save screenshots
            FileUtils.copyFile(file, new File(path));
            test.addScreenCaptureFromPath(path);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test case passed: " + result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test case Skipped: " + result.getName());
        }
        reports.flush(); // Added to ensure report is generated properly
        //driver.quit(); // Quitting driver after each test method
    }
    @DataProvider(name="dat1")
public Object[][] dp1() throws IOException
{
    FileInputStream fs=new FileInputStream("D:\\Excel data\\userdata.xlsx");
    XSSFWorkbook workbook=new XSSFWorkbook(fs);
    XSSFSheet sheet=workbook.getSheetAt(0);
    int rowCount=sheet.getLastRowNum();
    int colCount=sheet.getRow(0).getLastCellNum();
    Object[][] arr=new Object[rowCount][colCount];
     for(int i=0;i<rowCount;i++)
     {
        Row row=sheet.getRow(i+1);
        for(int j=0;j<colCount;j++)
        {
             arr[i][j]=row.getCell(j).getStringCellValue();
        }
     }

    return arr;
}
}
