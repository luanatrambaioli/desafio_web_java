package support;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities extends BrowserFactory {

  private final int TIME_SECONDS = 10;

  public static void screenShot(WebDriver driver, String file) {
    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    try {
      FileUtils.copyFile(screenshot, new File(file));
    } catch (Exception e) {
      System.out.println("Houveram problemas ao copiar o file para a pasta: " + e.getMessage());
    }
  }

  public void waitForElement(By locator) {
    // Aguardar até 10 segundos para a presença do elemento
    WebDriverWait wait = new WebDriverWait(driver, TIME_SECONDS);
    wait.until(ExpectedConditions.presenceOfElementLocated(locator));
  }

  public void waitForElementClickable(By locator) {
    // Aguardar até 10 segundos para elemento ficar clicável
    WebDriverWait wait = new WebDriverWait(driver, TIME_SECONDS);
    wait.until(ExpectedConditions.elementToBeClickable(locator));
  }

  public String getTextForElement(By locator) {
    // Pegar texto do elemento
    return driver.findElement(locator).getText();
  }
}
