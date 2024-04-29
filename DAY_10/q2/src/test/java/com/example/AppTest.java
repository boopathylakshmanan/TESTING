package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    WebDriver driver;
    @BeforeTest
    public void bt()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

    }
    @Test(dataProvider = "dat1")
    public void test1(String city) throws InterruptedException, IOException
    {
      driver.get("https://www.opentable.com/");
      WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
      wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mainContent\"]/header/div/span/div/div/div[2]/div[1]/div/input")));
      driver.findElement(By.xpath("//*[@id=\"mainContent\"]/header/div/span/div/div/div[2]/div[1]/div/input")).sendKeys(city);
      driver.findElement(By.xpath("//*[@id=\"mainContent\"]/header/div/span/div/div/div[2]/div[2]/button")).click();
      driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/section/div[6]/div/label[4]")).click();
      Thread.sleep(5000);
      driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div[2]/div/div[2]/div[1]/div[1]/a")).click();
      Set<String>st=driver.getWindowHandles();
      for(String it:st){
        if(!it.equals(driver.getWindowHandle()))
        {
         driver.switchTo().window(it);
         break;
        }
      }
      Select select=new Select(driver.findElement(By.xpath("//*[@id=\"restProfileMainContentDtpPartySizePicker\"]")));
      select.selectByIndex(3);
      driver.findElement(By.xpath("//*[@id=\"restProfileMainContentDtpDayPicker\"]/div/div")).click();
      for(int i=0;i<7;i++)
      {
        driver.findElement(By.xpath("//*[@id=\"restProfileMainContentDtpDayPicker-wrapper\"]/div/div/div/div/div[2]/button[2]")).click();
      }
      driver.findElement(By.xpath("//*[@id=\"restProfileMainContentDtpDayPicker-wrapper\"]/div/div/div/table/tbody/tr[3]/td[2]/button")).click();
      Select select2=new Select(driver.findElement(By.xpath("//*[@id=\"restProfileMainContenttimePickerDtpPicker\"]")));
      select2.selectByIndex(13);
      driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[1]/section[2]/div[5]/article[1]/div/div[5]/button")).click();
      File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      String path="D:\\q2.png";
      FileUtils.copyFile(file,new File(path));
     
    }
    @DataProvider(name="dat1")
    public Object[][] dp() throws IOException
    {
      FileInputStream fs=new FileInputStream("D:\\Excel data\\opentable.xlsx");
      XSSFWorkbook workbook=new XSSFWorkbook(fs);
      XSSFSheet sheet=workbook.getSheetAt(0);
      Object[][] arr=new Object[1][1];
      Row row=sheet.getRow(1);
      arr[0][0]=row.getCell(0).getStringCellValue();
      return arr;

    }
}
