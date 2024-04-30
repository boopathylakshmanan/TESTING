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
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     * @throws IOException 
     * @throws InterruptedException 
     */
    @Test
    public void test1() throws IOException, InterruptedException {
        SoftAssert assert1=new SoftAssert();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        FileInputStream fs = new FileInputStream("D:\\Excel data\\DAY_11.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int row = sheet.getLastRowNum();
        int col = sheet.getRow(0).getLastCellNum();
        driver.manage().window().maximize();
        for (int i = 1; i <= row; i++) { // Start from the second row
            Row row1 = sheet.getRow(i);
                if (row1.getCell(0).getStringCellValue().equals("get_url")) {
                    driver.get(row1.getCell(1).getStringCellValue());
                    Thread.sleep(3000);
                } else if (row1.getCell(0).getStringCellValue().equals("search")) {
                    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(row1.getCell(2).getStringCellValue())));
                    driver.findElement(By.xpath(row1.getCell(2).getStringCellValue())).sendKeys(row1.getCell(1).getStringCellValue());
                    Thread.sleep(3000);
                } else if (row1.getCell(0).getStringCellValue().equals("Go")) {
                    driver.findElement(By.xpath(row1.getCell(2).getStringCellValue())).click();
                    Thread.sleep(3000);
                }
                else if(row1.getCell(0).getStringCellValue().equals("search_click"))
                {
                   driver.findElement(By.xpath(row1.getCell(2).getStringCellValue())).click();
                   Thread.sleep(3000);
                }
                else if(row1.getCell(0).getStringCellValue().equals("expand"))
                {
                    driver.findElement(By.xpath(row1.getCell(2).getStringCellValue())).click();
                    Thread.sleep(3000);
                }
                else if(row1.getCell(0).getStringCellValue().equals("filter"))
                {
                    driver.findElement(By.xpath(row1.getCell(2).getStringCellValue())).click();
                    Thread.sleep(5000);
                }
                else if(row1.getCell(0).getStringCellValue().equals("add to cart"))
                {
                    driver.findElement(By.xpath(row1.getCell(2).getStringCellValue())).submit();
                }
                else if (row1.getCell(0).getStringCellValue().equals("view cart")) {
                    driver.findElement(By.xpath(row1.getCell(2).getStringCellValue())).click();
                    Thread.sleep(5000);
                }
                else if(row1.getCell(0).getStringCellValue().equals("checkout"))
                {
                    driver.findElement(By.xpath(row1.getCell(2).getStringCellValue())).click();
                }
                else if (row1.getCell(0).getStringCellValue().equals("assert")) {
                    assert1.assertTrue(driver.findElement(By.xpath(row1.getCell(2).getStringCellValue())).getText().contains("My Cart(1 Item)"));
                    File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                    String path="D:\\q1t1.png";
                    FileUtils.copyFile(file, new File(path));
                }
        }
       driver.quit();
    }
    @Test
    public void test2() throws IOException, InterruptedException {
        SoftAssert assert1=new SoftAssert();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        FileInputStream fs = new FileInputStream("D:\\Excel data\\DAY_11.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(1);
        int row = sheet.getLastRowNum();
        System.out.println(row);
        // Row row2=sheet.getRow(row);
        // System.out.println(row2.getCell(0).getStringCellValue());
        int col = sheet.getRow(0).getLastCellNum();
        driver.manage().window().maximize();
        for (int i = 1; i <=row; i++) { // Start from the second row
            Row row1 = sheet.getRow(i);
           
                if (row1.getCell(0).getStringCellValue().equals("get_url")) {
                    driver.get(row1.getCell(1).getStringCellValue());
                    Thread.sleep(3000);
                } 
                else if (row1.getCell(0).getStringCellValue().equals("category")) {
                    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(row1.getCell(2).getStringCellValue())));
                    driver.findElement(By.xpath(row1.getCell(2).getStringCellValue())).click();;
                    Thread.sleep(3000);
                } else if (row1.getCell(0).getStringCellValue().equals("click all")) {
                    driver.findElement(By.xpath(row1.getCell(2).getStringCellValue())).click();
                    Thread.sleep(5000);
                }
                else if(row1.getCell(0).getStringCellValue().equals("filter"))
                {
                    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(row1.getCell(2).getStringCellValue())));
                   driver.findElement(By.xpath(row1.getCell(2).getStringCellValue())).click();
                   Thread.sleep(3000);
                }
                else if(row1.getCell(0).getStringCellValue().equals("edible oil"))
                {
                    System.out.println("1");
                    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(row1.getCell(2).getStringCellValue())));
                   driver.findElement(By.xpath(row1.getCell(2).getStringCellValue())).click();
                   Thread.sleep(3000);
                   
                }
                else if(row1.getCell(0).getStringCellValue().equals("assert"))
                {
                    assert1.assertTrue(driver.findElement(By.xpath(row1.getCell(2).getStringCellValue())).getText().contains("Edible Oil"));
                    File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                    String path="D:\\q1t2.png";
                    FileUtils.copyFile(file, new File(path));
                }
            }
            driver.quit();
            }
            @Test
            public void test3() throws IOException, InterruptedException
            {
                SoftAssert assert1=new SoftAssert();
                WebDriverManager.chromedriver().setup();
                WebDriver driver = new ChromeDriver();
                FileInputStream fs = new FileInputStream("D:\\Excel data\\DAY_11.xlsx");
                XSSFWorkbook workbook = new XSSFWorkbook(fs);
                XSSFSheet sheet = workbook.getSheetAt(2);
                int row = sheet.getLastRowNum();
                System.out.println(row);
                // Row row2=sheet.getRow(row);
                // System.out.println(row2.getCell(0).getStringCellValue());
                int col = sheet.getRow(0).getLastCellNum();
                driver.manage().window().maximize();
                for (int i = 1; i <=row; i++) { // Start from the second row
                    Row row1 = sheet.getRow(i);
                   
                        if (row1.getCell(0).getStringCellValue().equals("get_url")) {
                            driver.get(row1.getCell(1).getStringCellValue());
                            Thread.sleep(3000);
                        } 
                        else if (row1.getCell(0).getStringCellValue().equals("user_click")) {
                            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(row1.getCell(2).getStringCellValue())));
                            driver.findElement(By.xpath(row1.getCell(2).getStringCellValue())).click();;
                            Thread.sleep(3000);
                        } else if (row1.getCell(0).getStringCellValue().equals("username")) {
                            driver.findElement(By.xpath(row1.getCell(2).getStringCellValue())).sendKeys(row1.getCell(1).getStringCellValue());
                            Thread.sleep(5000);
                        }
                        else if(row1.getCell(0).getStringCellValue().equals("Login"))
                        {
                            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
                            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(row1.getCell(2).getStringCellValue())));
                           driver.findElement(By.xpath(row1.getCell(2).getStringCellValue())).click();
                           Thread.sleep(3000);
                        }
                        else if(row1.getCell(0).getStringCellValue().equals("password"))
                        {
                            //System.out.println("1");
                            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
                            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(row1.getCell(2).getStringCellValue())));
                           driver.findElement(By.xpath(row1.getCell(2).getStringCellValue())).sendKeys(row1.getCell(1).getStringCellValue());
                           Thread.sleep(3000);
        
                        }
                        else if(row1.getCell(0).getStringCellValue().equals("click"))
                        {
                            driver.findElement(By.xpath(row1.getCell(2).getStringCellValue())).click();
                            Thread.sleep(3000);
                        }
                        else if(row1.getCell(0).getStringCellValue().equals("assert"))
                        {
                            assert1.assertTrue(driver.findElement(By.xpath(row1.getCell(2).getStringCellValue())).getText().contains("Invalid username or password"));
                            File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                            String path="D:\\q1t3.png";
                            FileUtils.copyFile(file, new File(path));
                        }
            }
            driver.quit();
    }
   
}
