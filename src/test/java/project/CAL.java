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
        PageAccueil pa = pl.seConnecter(driver, "admin", "admin");
        Debug.w4it(1000);
        assertTrue(pa.aCalendrier());
        Debug.w4it(1000);
        PageListeCalendrier plc = pa.selectionnerRessources_Calendrier(driver);
        Debug.w4it(1000);
        assertTrue("On est sur la PageListeCalendrier", plc.aListeCalendrier());
        //check tableau et données à faire
        //check bouton creer à faire
        Debug.w4it(1000);
        PageCalendrierCreation pcc = plc.clickCreer(driver);
        Debug.w4it(1000);
        assertTrue(pcc.aCreerCalendrier());
        //check formulaire à faire
        //check boutons enregistrer, enregistrer et continuer, annuler à faire
        pcc.remplirCalendrier("Calendrier - Test 1");
        plc = pcc.clickEnregistrerCalendrier(driver);
        Debug.w4it(1000);
        assertTrue(plc.aListeCalendrier());
        //check "Calendrier - Test 1" est présent
        Debug.w4it(1000);
        pcc = plc.creerDerive(driver);
        Debug.w4it(1000);
        assertTrue(pcc.aCreerCalendrier());
        //check champs remplis à faire
        pcc.remplirCalendrier("Calendrier - Test 1");
        pcc.clickEnregistrerContinuerCalendrier();
        //check message à faire
        pcc.remplirCalendrier("Calendrier - Test Calendrier Dérivé");
        pcc.clickEnregistrerContinuerCalendrier();
        //check message à faire
        //check titre page a faire
        plc = pcc.annuler(driver);
        //assertTrue(plc.aListeCalendrier());
        plc.clickMoins();
        //check arborescence à faire
        pcc = plc.clickCreerCopie(driver);
        //assertTrue(pcc.aCreerCalendrier());
        pcc.clickEnregistrerContinuerCalendrier();
        //check message à faire
        pcc.remplirCalendrier("Calendrier - Test 2");
        plc = pcc.clickEnregistrerCalendrier(driver);
        Debug.w4it(1000);
        assertTrue(plc.aListeCalendrier());
        //check message
        //check présence calendrier

    }

    @Test
    public void CAL_02(){
        PageLogin pl = PageFactory.initElements(driver, PageLogin.class);
        PageAccueil pa = pl.seConnecter(driver, "admin", "admin");       
        Debug.w4it(1000); 
        assertTrue(pa.aCalendrier());
        Debug.w4it(1000);
        PageParticipants pp = pa.selectionnerRessources_Participants(driver);
        Debug.w4it(1000);
        assertTrue("On est sur la page liste des participants", pp.aParticipants());
        //check tableau et données à faire
        //check boutons et couleurs des boutons à faire
        PageModifierParticipant pmp = pp.clickParticipant(driver);
        assertTrue("On est sur la page 'Modifier le participant'", pmp.aModifierParticipant());


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
