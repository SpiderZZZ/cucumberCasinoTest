package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class MainPage
{
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(xpath = "//li[contains(@class,'nav-profile')]//span")
    private WebElement AuthorizedUserName;

    @FindBy(id = "nav-container")
    private WebElement navigationPanel;

    public MainPage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 5);
        PageFactory.initElements(webDriver, this);
    }

    public String getTitle()
    {
        return webDriver.getTitle();
    }

    public String getAuthorizedUserName() {
        return AuthorizedUserName.getText();
    }

    public boolean navigationPanelLoaded()
    {
        try
        {
            wait.until(visibilityOf(navigationPanel));
        }
        catch (TimeoutException e)
        {
            return false;
        }
        return true;
    }

    public void openMenuItem(String menuName)
    {
        webDriver.findElement(By.xpath((String.format("//aside[@id='nav-container']//span[text()='%s']",menuName))))
                .click();
    }

    public void openSubmenuItem(String menuName, String submenuName)
    {
        WebElement playersButton = webDriver.findElement(By.xpath((String.format("//ul[@id='s-menu-%s']//a[contains(text(),'%s')]",
                menuName.toLowerCase(),
                submenuName))));
        wait.until(ExpectedConditions.elementToBeClickable(playersButton)).click();
    }

}