package pages;

import support.BrowserFactory;
import support.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class GuiaMedicoPage extends BrowserFactory {

  // ELEMENTOS
  private final By RESULT_DOCTOR_NAME = By.cssSelector("#resultado0 > div > h4#txt_nome_prestador");
  private final By RESULT_SPECIALTY = By.cssSelector("#resultado0 > div > p > span:nth-child(2)");
  private final By RESULT_STATE = By.cssSelector("#txt_endereco > p");
  private final By INPUT_STATE = By.id("react-select-2-input");
  private final By INPUT_CITY = By.id("react-select-3-input");
  private final By FIELD_STATE =
      By.xpath("//*[@class='css-151xaom-placeholder' and text()='Estado']");
  private final By FIELD_CITY =
      By.xpath("//*[@class='css-151xaom-placeholder' and text()='Cidade']");
  private final By RADIO_REGION = By.cssSelector("form[class*='escolher-unimed'] input");
  private final By BUTTON_CONTINUE = By.cssSelector("button[class='btn btn-success']");
  private final By TEXT_GUIA_MEDICO = By.cssSelector("h1[class='titulo-midia cor-clara']");
  private final By INPUT_PESQUISA = By.id("campo_pesquisa");
  private final By BUTTON_SEARCH = By.id("btn_pesquisar");
  private final By RADIO_UNIMED = By.cssSelector("input[type='radio']");
  private final Utilities util = new Utilities();

  public void verifyAccessGuiaMedico(String text) {
    util.getTextForElement(TEXT_GUIA_MEDICO).equals(text);
  }

  public void fillInSearchField(String text) {
    util.waitForElement(INPUT_PESQUISA);
    driver.findElement(INPUT_PESQUISA).clear();
    driver.findElement(INPUT_PESQUISA).sendKeys(text);
  }

  public void clickSearchButton() {
    util.waitForElementClickable(BUTTON_SEARCH);
    driver.findElement(BUTTON_SEARCH).click();
  }

  public void selectUnimedRadioButton() {
    util.waitForElementClickable(RADIO_UNIMED);
    driver.findElement(RADIO_UNIMED).click();
  }

  public void fillInState(String state) {
    util.waitForElementClickable(INPUT_STATE);
    driver.findElement(FIELD_STATE).click();
    driver.findElement(INPUT_STATE).clear();
    driver.findElement(INPUT_STATE).sendKeys(state);
    driver.findElement(INPUT_STATE).sendKeys(Keys.ENTER);
  }

  public void fillInCity(String city) {
    util.waitForElementClickable(INPUT_CITY);
    driver.findElement(FIELD_CITY).click();
    driver.findElement(INPUT_CITY).clear();
    driver.findElement(INPUT_CITY).sendKeys(city);
    driver.findElement(INPUT_CITY).sendKeys(Keys.ENTER);
  }

  public void selectRegion() {
    util.waitForElementClickable(RADIO_REGION);
    driver.findElement(RADIO_REGION).click();
  }

  public void clickButtonContinue() {
    util.waitForElementClickable(BUTTON_CONTINUE);
    driver.findElement(BUTTON_CONTINUE).click();
  }

  public boolean verifyDoctorNameText(String text) {
    util.waitForElement(RESULT_DOCTOR_NAME);
    return driver.findElement(RESULT_DOCTOR_NAME).getText().contains(text);
  }

  public boolean verifySpecialityText(String text) {
    util.waitForElement(RESULT_SPECIALTY);
    return driver.findElement(RESULT_SPECIALTY).getText().contains(text);
  }

  public boolean verifyStateText(String text) {
    util.waitForElement(RESULT_STATE);
    return driver.findElement(RESULT_STATE).getText().contains(text);
  }
}
