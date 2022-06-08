import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppointmentPage extends _BasePage {
    public AppointmentPage (WebDriver driver, WebDriverWait driverWait) {
        super(driver,driverWait);
    }

    private By facility = By.id("combo_facility");
    private By hospitalReadmission = By.xpath("//*[@id=\"appointment\"]/div/div/form/div[2]/div/label");
    private By helthcareProgram_Medicare = By.xpath("/html/body/section/div/div/form/div[3]/div/label[1]/input");
    private By helthcareProgram_Medicaid = By.xpath("/html/body/section/div/div/form/div[3]/div/label[2]/input");
    private By helthcareProgram_None = By.xpath(("/html/body/section/div/div/form/div[3]/div/label[3]/input"));
    private By applayForHospReadmission = By.xpath("/html/body/section/div/div/form/div[2]/div/label/input");
    private By helthFacilityDropDown = By.id("combo_facility");
    private By visitDate = By.id("txt_visit_date");
    private By comment = By.id("txt_comment");

    public By getFacility() {
        return facility;
    }

    public By getHospitalReadmission() {
        return hospitalReadmission;
    }

    public By getHelthcareProgram_Medicare() {
        return helthcareProgram_Medicare;
    }

    public By getHelthcareProgram_Medicaid() {
        return helthcareProgram_Medicaid;
    }

    public By getHelthcareProgram_None() {
        return helthcareProgram_None;
    }



    public void enterDateOfVisit(String ddMmYyyy){
        explicitDriverWait(10, visitDate);
        WebElement date = getDriver().findElement(visitDate);
        date.sendKeys(ddMmYyyy);
    }


    public void chooseFacility(int optionNumber1to3){
        explicitDriverWait(10, helthFacilityDropDown);
        WebElement option = getDriver().findElement(helthFacilityDropDown);
        Select sl = new Select(option);
        sl.selectByIndex(optionNumber1to3);
    }


    public void applyForReadmission(String yesOrNo){
        explicitDriverWait(10,applayForHospReadmission);
        WebElement checkbox = getDriver().findElement(applayForHospReadmission);
        if(yesOrNo.equalsIgnoreCase("yes")){
            checkbox.click();
        }else {}

    }

    public void chooseProgram(String option){

        explicitDriverWait(10, helthcareProgram_Medicaid);
        explicitDriverWait(10, helthcareProgram_Medicare);
        explicitDriverWait(10, helthcareProgram_None);

        WebElement option1 = getDriver().findElement(helthcareProgram_Medicaid);
        WebElement option2 = getDriver().findElement(helthcareProgram_Medicare);
        WebElement option3 = getDriver().findElement(helthcareProgram_None);

        if(option.equalsIgnoreCase("medicare")){
            option1.click();
        }else if(option.equalsIgnoreCase("medicaid")){
            option2.click();
        }else if(option.equalsIgnoreCase("none")){
            option3.click();
        }
    }

    public void explicitDriverWait (int seconds, By element){
        new WebDriverWait(getDriver(),Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOfElementLocated(element));

    }



}
