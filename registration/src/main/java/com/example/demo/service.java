package com.example.demo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.BreakIterator;

public class service {
    public static void main(String[] args) {
        try {
            WebDriver driver = new ChromeDriver();

            driver.get("http://sugang.deu.ac.kr:8080/DEUSugang_LogIn.aspx");

            WebElement id = driver.findElement(By.id("txtID"));
            WebElement pw = driver.findElement(By.id("txtPW"));

            id.sendKeys("본인 학번");
            pw.sendKeys("비밀번호");

            WebElement login = driver.findElement(By.id("ibtnLogin"));
            login.click();

            while (true) {

                WebElement sugang = driver.findElement(By.linkText("수강신청"));
                sugang.click();

                try {
                    Alert alert = driver.switchTo().alert();
                    alert.accept();
                    continue;
                } catch (NoAlertPresentException e) {

                }


                driver.quit();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
