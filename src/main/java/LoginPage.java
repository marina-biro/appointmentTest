import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends _BasePage {

    public LoginPage (WebDriver driver, WebDriverWait driverWait) {
        super(driver,driverWait);
    }

    private By makeAppointmentBtn = By.id("btn-make-appointment");
    private By userNameField = By.id("txt-username");
    private By passwordField = By.id("txt-password");
    private By loginBtn = By.xpath("//*[@id=\"btn-login\"]");

    public By getMakeAppointmentBtn() {
        return makeAppointmentBtn;
    }


    public By getUserNameField() {
        return userNameField;
    }


    public By getPasswordField() {
        return passwordField;
    }


    public By getLoginBtn() {
        return loginBtn;
    }



    public void clickMakeAppointmentBtn(){
        WebElement button = getDriver().findElement(makeAppointmentBtn);
        button.click();
    }

    public void populateLoginForm(){
        WebElement userName = getDriver().findElement(userNameField);
        userName.sendKeys("John Doe");
        WebElement password = getDriver().findElement(passwordField);
        password.sendKeys("ThisIsNotAPassword");
        WebElement clickLogin = getDriver().findElement(loginBtn);
        clickLogin.click();
    }


}
