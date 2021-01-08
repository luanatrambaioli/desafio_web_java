package support;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {

  public static WebDriver driver;
  public Properties property;
  public String userDir = System.getProperty("user.dir");

  // Classe para inicializar o driver
  public WebDriver initialize() throws IOException {
    property = new Properties();
    FileInputStream fInputStream =
        new FileInputStream(userDir + "/src/test/resources/config.properties");
    property.load(fInputStream);
    String browser = property.getProperty("browser").toLowerCase();

    if ("chrome".equals(browser)) {
      System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
      System.setProperty("webdriver.chrome.driver", userDir + "/drivers/chromedriver_linux");
      ChromeOptions options = new ChromeOptions();
      HashMap<String, Object> prefs = new HashMap<String, Object>();
      prefs.put("profile.default_content_setting_values.geolocation", 2);
      options.setExperimentalOption("prefs", prefs);
      options.addArguments("--start-maximized");
      options.addArguments("user-agent=luana");
      driver = new ChromeDriver(options);
    }
    else if ("firefox".equals(browser)) {
      System.setProperty("webdriver.gecko.driver", userDir + "/drivers/geckodriver.exe");
      FirefoxOptions fireOpt = new FirefoxOptions();
      fireOpt.addArguments("--start-maximized");
      fireOpt.addArguments("user-agent=luana");
      driver = new FirefoxDriver(fireOpt);
    }
    else {
      throw new NotFoundException("Navegador inválido. Por favor, escolher um browser válido");
    }

    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    return driver;
  }
}
