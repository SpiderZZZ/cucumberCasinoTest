package cucumberCasinoGUITests.Steps;

import io.cucumber.core.api.Scenario;
import models.Player;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.PlayersPage;
import java.text.ParseException;
import java.util.*;
import static org.junit.Assert.*;
import static selenium.webdriver.WebDriverFactory.createWebDriver;


public class CasinoSteps {

    private WebDriver webDriver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private PlayersPage playersPage;

    @Before
    public void startBrowser()
    {
        webDriver = createWebDriver();
        loginPage = new LoginPage(webDriver);
        mainPage = new MainPage(webDriver);
        playersPage = new PlayersPage(webDriver);
    }

    @Given("I am at casino login page with title {string}")
    public void iAmAtCasinoLoginPage(String pageTitle) {
        loginPage.openLoginPage();
        assertEquals(loginPage.getTitle(), pageTitle);
    }

    @When("I fill the field {string} with value {string}")
    public void iFillTheFieldWithValue(String fieldName, String value) {
        loginPage.sendTextToElementWithId(String.format("UserLogin_%s",fieldName),value);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickSubmitButton();
    }

    @Then("User {string} is authorized")
    public void userIsAuthorized(String username) {
        assertEquals(username, mainPage.getAuthorizedUserName());
    }

    @And("I should see admin navigation panel")
    public void iShouldSeeAdminNavigationPanel() {
        assertTrue(mainPage.navigationPanelLoaded());
    }

    @And("I click to the menu {string}")
    public void iClickToTheMenu(String menu) {
        mainPage.openMenuItem(menu);
    }

    @And("I click to the submenu {string} in menu {string}")
    public void iClickToTheSubmenu(String submenu, String menu) {
        mainPage.openSubmenuItem(menu, submenu);
    }

    @Then("Players management page loaded")
    public void playersManagementPageLoaded() {
        assertTrue(playersPage.playersTableLoaded());
    }

    @And("Click on registration date column name")
    public void clickOnRegistrationColumnName() throws ParseException {
        playersPage.clickRegistrationDateColumnSorting();
    }

    @Then("Players table sorted by registration date completed correctly")
    public void playersTablesSortingIsWell() throws ParseException {
        List<Player> playersFromPage = playersPage.getPlayersOnFirstPaginatorPage();
        List<Player> playerSortingByDate = new LinkedList<>(playersFromPage);
        playerSortingByDate.sort(Comparator.comparing(Player::getRegistrationDate));
        assertThat(playersFromPage,
                IsIterableContainingInOrder.contains(playerSortingByDate.toArray()));
    }

    @After
    public void closeBrowser(Scenario scenario)
    {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        webDriver.quit();
    }
}
