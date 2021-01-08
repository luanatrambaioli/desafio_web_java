package pages;

import support.BrowserFactory;
import support.Utilities;
import org.openqa.selenium.By;

public class HomePage extends BrowserFactory {

  private final Utilities util = new Utilities();

  // ELEMENTOS
  private final By NAVBAR = By.cssSelector("nav[id='menuPrincipal']");

  public void accessMainMenu(String menu) {
    util.waitForElementClickable(NAVBAR);
    driver.findElement(By.linkText(menu)).click();
  }
}
