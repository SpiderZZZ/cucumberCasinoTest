package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    private WebDriver webDriver;

    @FindBy(id = "UserLogin_username")
    private WebElement username;

    @FindBy(id = "UserLogin_password")
    private WebElement password;

    @FindBy(name = "yt0")
    private WebElement submitButton;

    public LoginPage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void openLoginPage()
    {
        webDriver.navigate().to("http://test-app.d6.dev.devcaz.com/admin/login");
    }

    public void clickSubmitButton()
    {
        submitButton.click();
    }

    public String getTitle()
    {
        return webDriver.getTitle();
    }

    public void sendTextToElementWithId(String id, String text)
    {
        webDriver.findElement(By.id(id))
                .sendKeys(text);
    }
}