package tests;

import static org.junit.Assert.assertTrue;

import pages.GuiaMedicoPage;
import pages.HomePage;
import support.BrowserFactory;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SearchForDoctorsTest extends BrowserFactory {

  private final HomePage homePage = new HomePage();
  private final GuiaMedicoPage guiaMedicoPage = new GuiaMedicoPage();

  @Before
  public void beforeTest() throws IOException {
    driver = initialize();
    driver.get(property.getProperty("url"));
  }

  @After
  public void afterTest() {
    driver.quit();
  }

  @Test
  public void searchForDoctorRJ() {
    // Acessar o menu de Guia Médicos
    homePage.accessMainMenu("Guia Médico");
    // Validar que está na página de Guia Médicos
    guiaMedicoPage.verifyAccessGuiaMedico("Guia Médico");
    // Preencher campo de pesquisa com o CRM do médico
    guiaMedicoPage.fillInSearchField("444436");
    // Clicar no botão pesquisar
    guiaMedicoPage.clickSearchButton();
    // Escolher estado Rio de Janeiro
    guiaMedicoPage.fillInState("Rio de Janeiro");
    // Escolher cidade Rio de Janeiro
    guiaMedicoPage.fillInCity("Rio de Janeiro");
    // Selecionar Regiao da unimed
    guiaMedicoPage.selectRegion();
    // Clicar no botão continuar
    guiaMedicoPage.clickButtonContinue();

    // Validar nome do médico pesquisado pelo CRM, especialidade e estado
    assertTrue(guiaMedicoPage.verifyDoctorNameText("TANIA BRANDAO RIOS (CRM 444436)"));
    assertTrue(guiaMedicoPage.verifySpecialityText("Nefrologia"));
    assertTrue(guiaMedicoPage.verifyStateText("Rio de Janeiro"));
  }

  @Test
  public void searchForDoctorSP() {
    // Acessar o menu de Guia Médicos
    homePage.accessMainMenu("Guia Médico");
    // Validar que está na página de Guia Médicos
    guiaMedicoPage.verifyAccessGuiaMedico("Guia Médico");
    // Preencher campo de pesquisa com o CRM do médico
    guiaMedicoPage.fillInSearchField("106490");
    // Clicar no botão pesquisar
    guiaMedicoPage.clickSearchButton();
    // Escolher estado São Paulo
    guiaMedicoPage.fillInState("São Paulo");
    // Escolher cidade São Paulo
    guiaMedicoPage.fillInCity("São Paulo");
    // Selecionar Regiao da unimed
    guiaMedicoPage.selectRegion();
    // Clicar no botão continuar
    guiaMedicoPage.clickButtonContinue();

    // Validar nome do médico pesquisado pelo CRM, especialidade e estado
    assertTrue(guiaMedicoPage.verifyDoctorNameText("ZAHIR TANNOUS ELIAS SAWAN (CRM 106490)"));
    assertTrue(guiaMedicoPage.verifySpecialityText("Ginecologia e Obstetrícia"));
    assertTrue(guiaMedicoPage.verifyStateText("SP"));
  }
}
