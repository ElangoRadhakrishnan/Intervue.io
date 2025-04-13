package com.lao.Interview;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login {

  WebDriver driver;

  @BeforeClass
  public void setUp() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.intervue.io");
  }


  @Test
  public void testLoggingIntoApplication() throws InterruptedException {

    String current_window = driver.getWindowHandle();
    driver.findElement(By.cssSelector("a[class=\"ivhn-contact-link loginBtn\"]")).click();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    Set<String> Alltabs=driver.getWindowHandles();
    for(String Tab:Alltabs) {
        if(!Tab.equals(current_window)) {
            driver.switchTo().window(Tab);
            break;
        }
    }
    driver.findElement(By.xpath("(//div[@class=\"AccessAccount-ColoredButton-Text\"])[1]")).click();
    
Thread.sleep(2000);
    WebElement email = driver.findElement(By.xpath("//input[@id='login_email']"));
    email.sendKeys("neha@intervue.io");

    WebElement password = driver.findElement(By.xpath("//input[@id='login_password']"));
    password.sendKeys("Ps@neha@123");

    driver.findElement(By.xpath("//button[@type='submit']")).click();
   
    
    WebElement search = driver.findElement(By.cssSelector(".search_placeholder"));
    search.click();   

    WebElement search1 = driver.findElement(By.xpath("//input[@class='SearchBox__StyledInput-ctnsh0-4 lhwsuL']"));
    search1.sendKeys("hello");

    WebElement search2 =driver.findElement(By.xpath("//div[@class='SearchThrough__PlaceholderText-sc-8f4vh4-0 fEvpzS']"));
    search2.click();

    driver.findElement(By.xpath("//div[@class='userAvatar Avatar__AvatarDiv-sc-1jdwvse-0 fYvxTb']")).click();


  }
  @AfterClass
  public void tearDown() {
    
    driver.close();
  }

}
