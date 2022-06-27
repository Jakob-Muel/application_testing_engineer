import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration
import java.util.*

open class BaseTestClass {

    lateinit var driver: WebDriver

    companion object {
        const val WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver"
        const val RESOURCES_DRIVER_CHROMEDRIVER = "resources/drivers/chromedriver"
        const val WEBDRIVER_GECKO_DRIVER = "webdriver.gecko.driver"
        const val RESOURCES_DRIVER_GECKODRIVER = "resources/drivers/geckodriver"
    }

    private fun setupChromeBrowser(locale: Locale): WebDriver {
        val prefs = HashMap<String, String>()
        prefs["intl.accept_languages"] = locale.language

        if (getOSName().contains("Windows")) {
            System.setProperty(WEBDRIVER_CHROME_DRIVER, "$RESOURCES_DRIVER_CHROMEDRIVER.exe")
        } else {
            System.setProperty(WEBDRIVER_CHROME_DRIVER, RESOURCES_DRIVER_CHROMEDRIVER)
        }
        val options = ChromeOptions()
        options.setHeadless(true)
        options.addArguments("--no-sandbox")
            .addArguments("--disable-dev-shm-usage")
            .addArguments("--lang=${locale.language}")
        options.setExperimentalOption("prefs", prefs)
        createDeviceSpecificChromeDriverOptions(options)
        return ChromeDriver(options)
    }

    fun getOSName(): String {
        return System.getProperty("os.name")
    }

    protected fun createDeviceSpecificChromeDriverOptions(options: ChromeOptions) {
        options.addArguments("--window-size=1920,1200")
    }

    protected fun createWebDriverInstance(): WebDriver {
        driver = setupChromeBrowser(Locale.GERMAN)
        return driver
    }

    fun handleCookies() {
        WebDriverWait(driver, Duration.ofSeconds(2))
            .until(ExpectedConditions.elementToBeClickable(By.id("saveChoice"))).click()
    }

}