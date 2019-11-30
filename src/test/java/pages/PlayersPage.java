package pages;

import models.Player;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class PlayersPage
{
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@id='payment-system-transaction-grid']/table")
    private WebElement playersTable;

    @FindBy(xpath = "//div[@id='payment-system-transaction-grid']/table/tbody/tr")
    private List<WebElement> playersTableRows;

    @FindBy(xpath = "//th[@id='payment-system-transaction-grid_c9']/a")
    private WebElement registrationDateColumnSorting;


    public PlayersPage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 5);
        PageFactory.initElements(webDriver, this);
    }

    public void clickRegistrationDateColumnSorting()
    {
        registrationDateColumnSorting.click();
        wait.until(visibilityOf(webDriver.findElement(By.xpath("//div[@class='grid-view grid-view-loading']"))));
    }

    public List<Player> getPlayersOnFirstPaginatorPage() throws ParseException {
        wait.until(visibilityOf(webDriver.findElement(By.xpath("//div[@class='grid-view']"))));
        List<Player> players = new ArrayList<>();
        for (WebElement tr : playersTableRows)
        {
            List<WebElement> playerInfo = tr.findElements(By.tagName("td"));
            int column = 1;
            Player user = new Player()
                    .setUsername(playerInfo.get(column++).getText())
                    .setExternalId(playerInfo.get(column++).getText())
                    .setName(playerInfo.get(column++).getText())
                    .setLastName(playerInfo.get(column++).getText())
                    .setEmail(playerInfo.get(column++).getText())
                    .setPhone(playerInfo.get(column++).getText())
                    .setHall(playerInfo.get(column++).getText())
                    .setBalance(playerInfo.get(column++).getText())
                    .setRegistrationDate(playerInfo.get(column++).getText())
                    .setLastVisit(playerInfo.get(column++).getText())
                    .setLastVisitIp(playerInfo.get(column++).getText())
                    .setVerifiedPlayer(playerInfo.get(column++).getText())
                    .setOnline(playerInfo.get(column++).getText())
                    .setStatus(playerInfo.get(column++).getText());
            players.add(user);
        }
        return players;
    }


    public boolean playersTableLoaded()
    {
        try
        {
            wait.until(visibilityOf(playersTable));
        }
        catch (TimeoutException e)
        {
            return false;
        }
        return true;
    }

}