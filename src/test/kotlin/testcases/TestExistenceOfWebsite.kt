package testcases

import BaseTestClass
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.testng.Assert
import org.testng.annotations.Test

class TestExistenceOfWebsite: BaseTestClass() {

    @Test
    fun test() {
        createWebDriverInstance()
        driver.get("http://uitestingplayground.com")
        Assert.assertEquals(driver.currentUrl, "http://uitestingplayground.com/")
    }
}

