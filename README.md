├── com.lao.Interview
│   ├── BasePage.java                 // Initializes WebDriver 
│   ├── LoginPage.java               // Handles login page actions
│   ├── DashboardPage.java           // Contains actions for the dashboard (search, logout)
│   └── IntervueLoginSearchLogoutTest.java // Main test class with assertions
Stand alone Test Using TestNG
|
| _Login.Java //contains

Automates login, search, and logout flow on Intervue.io

Uses Page Object Model (POM) for better code organization

Implements explicit waits to ensure stability validations using TestNG

 Test Flow Covered    testLogin and SearchAndLogout()
Launches the browser and navigates to https://www.intervue.io

Clicks on the login button

Logs in using provided credentials

Performs a search on the dashboard

Verifies the search value

Clicks on the result icon

Logs out

Asserts redirection to the homepage
