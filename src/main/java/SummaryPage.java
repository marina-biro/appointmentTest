import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryPage extends _BasePage {

    public SummaryPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    private By facility = By.id("facility");
    private By readmission = By.id("hospital_readmission");
    private By helthcareProgram = By.id("program");
    private By visitDate = By.id("visit_date");
    private By comment = By.id("comment");


    public String facilityConf(){
        return getDriver().findElement(facility).getText();
    }

    public String readmissionConf(){
        return getDriver().findElement(readmission).getText();
    }

    public String helthProgramConf(){
        return getDriver().findElement(helthcareProgram).getText();
    }

    public String visitDateConf(){
        return getDriver().findElement(visitDate).getText();
    }

    public String commentConf(){
        return getDriver().findElement(comment).getText();
    }



}


