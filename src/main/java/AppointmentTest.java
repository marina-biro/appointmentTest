import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
    public void logIn(){
        this.loginPage.clickMakeAppointmentBtn();
        this.loginPage.populateLoginForm();
        Assert.assertTrue(appointmentPage.isFormPresented());
    }

    @Test (priority = 2)
    public void makeAnAppointment(){
        // to try: 2 objects, comparing indexes
        String someText = "some text";
        String yesOrNo = "Yes";
        String date = "01/02/2023";

        this.appointmentPage.chooseProgram("none"); // to try: Enum
        this.appointmentPage.applyForReadmission(yesOrNo);
        this.appointmentPage.chooseFacility(1);
        this.appointmentPage.enterComment(someText);
        this.appointmentPage.enterDateOfVisit("01/02/2023");
        this.appointmentPage.clickConfirm();

        Assert.assertEquals(someText, summaryPage.commentConf());
        Assert.assertEquals(yesOrNo, summaryPage.readmissionConf());
        Assert.assertEquals(date, summaryPage.visitDateConf());
    }





}
