import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppointmentTest {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private AppointmentPage appointmentPage;
    private LoginPage loginPage;
    private SummaryPage summaryPage;

    public AppointmentTest(){

    }

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Raven\\Desktop\\QA\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        this.appointmentPage = new AppointmentPage(this.driver, this.driverWait);
        this.loginPage = new LoginPage(this.driver, this.driverWait);
        this.summaryPage = new SummaryPage(this.driver, this.driverWait);
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
    }

    @Test (priority = 1)
    public void clickMakeAppointmentBtn(){
        this.loginPage.clickMakeAppointmentBtn();
        this.loginPage.populateLoginForm();
    }

    @Test (priority = 2)
    public void chooseProgram(){
        this.appointmentPage.chooseProgram("none");
    }

    @Test(priority = 3)
    public void hospitalReadmission_YesorNo(){
        this.appointmentPage.applyForReadmission("yes");
    }

    @Test(priority = 4)
    public void chooseFacility(){
        this.appointmentPage.chooseFacility(1);
    }
}
