package project;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import project.Outils.Debug;

/**
 * Unit test for simple App.
 */
public class CAL {

    public static WebDriver driver;

    /* Debut de tout test de cette classe
    * Set le webdriver
    */
    @BeforeClass
    public static void set(){
        //System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();       
    }
    
    /* Debut de chaque test de cette class
    * Ouvrir le lien cible du test
    */
    @Before
    public void setBeforeEach(){
        driver.get("http://localhost:8080/libreplan");
        driver.manage().window().maximize();
    }
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void CAL_01(){
        PageLogin pl = PageFactory.initElements(driver, PageLogin.class);
        PageAccueil pa = pl.seConnecter(driver, "log", "mdp");
        assert (pa.aCalendrier());
        PageListeCalendrier plc = pa.selectionnerRessources_Calendrier(driver);
        PageCalendrierCreation pcc = plc.clickCreer(driver);


        

    }


    /*Fin de chaque test de cette class
    * Attends 5 secondes
    */

    @After
    public void end(){
        Debug.w4it(5000);
    }

    /* Fin de tout test de cette classe
    * Ferme le webdriver
    */   
    @AfterClass
    public static void down(){
        driver.quit();
    }
}
