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
        driver.get("https://www.google.de")
        Assert.assertEquals(driver.currentUrl, "https://www.google.de/")
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"))
            .sendKeys("something" + Keys.ENTER)
        Assert.assertEquals(driver.currentUrl, "https://www.google.de/")
    }
}

