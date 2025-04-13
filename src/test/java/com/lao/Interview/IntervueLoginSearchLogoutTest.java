package com.lao.Interview;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public  class IntervueLoginSearchLogoutTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeMethod
    public void setup() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        BasePage.driver.get("https://www.intervue.io/");
    }

    @Test
    public void testLoginSearchAndLogout() {
        loginPage.clickInitialLogin();
        loginPage.clickAccessAccountButton();
        loginPage.login("neha@intervue.io", "Ps@neha@123");
        dashboardPage.searchAndAssert("Hello");
        dashboardPage.logout();
    }

    @AfterMethod
    public void tearDown() {
        if (BasePage.driver != null) {
            BasePage.driver.quit();
            BasePage.driver = null;
        }
    }
}