package com.lao.Interview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public  class DashboardPage extends BasePage {
    By searchInput = By.xpath("//input[@placeholder='Type what you want to search for']");
    By searchIcon = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]");
    By logoutLink = By.xpath("//a[normalize-space()='Logout']");

    public DashboardPage() {
        super();
    }

    public void searchAndAssert(String text) {
        WebElement searchBox = waitUntilVisible(searchInput);
        searchBox.sendKeys(text);
        Assert.assertEquals(searchBox.getDomProperty("value"), text, "Search text mismatch");
        waitUntilClickable(searchIcon).click();
    }

    public void logout() {
        waitUntilClickable(logoutLink).click();
    }
}
