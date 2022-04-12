package project;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
    public static Properties identifiant;
    public static Properties DATA;


    /* Debut de tout test de cette classe
    * Set le webdriver
    */
    @BeforeClass
    public static void set(){
        //System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();    
        identifiant = new Properties();
        DATA  = new Properties();
        try{
        identifiant.load(new FileInputStream("src/main/resources/JDD/identifiant.properties"));       
        DATA.load(new FileInputStream("src/main/resources/JDD/CAL.properties"));
        }catch(IOException e){
            e.printStackTrace();
        }   
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
        PageAccueil pa = pl.seConnecter(driver, identifiant.getProperty("nomUtilisateur"),identifiant.getProperty("motDePasse")); //step 1
        Debug.w4it(2000);
        assertTrue(pa.aCalendrier());        
        PageListeCalendrier plc = pa.selectionnerRessources_Calendrier(driver); //step 2
        Debug.w4it(2000);
        assertTrue("On est sur la PageListeCalendrier", plc.aListeCalendrier());
        assertTrue("Colonne nom isDisplayed", plc.aColNom());
        //éléments checkabes facultatifs
        assertTrue("Bouton Créer isDisplayed", plc.aBCreer());
        Debug.w4it(1000);
        PageCalendrierCreation pcc = plc.clickCreer(driver); //step 3
        Debug.w4it(1000);
        assertTrue(pcc.aCreerCalendrier());
        pcc.aODonnesCalendrier();
        //éléments checkabes facultatifs
        pcc.remplirCalendrier(DATA.getProperty("nomCalendrier1"));
        plc = pcc.clickEnregistrerCalendrier(driver); //step 4
        Debug.w4it(1000);
        assertTrue(plc.aListeCalendrier());
        //check "Calendrier - Test 1" est présent
        assertTrue(plc.aElemCalTest1());
        Debug.w4it(1000);
        pcc = plc.creerDerive(driver); //step 5
        Debug.w4it(1000);
        assertTrue(pcc.aCreerCalendrier());
        //check champs vide facultatif
        assertTrue("Le champ nom est vide", pcc.aCNomVide());
        pcc.remplirCalendrier(DATA.getProperty("nomCalendrier1")); //step 6
        pcc.clickEnregistrerContinuerCalendrier();
        assertTrue(pcc.aExisteDeja());
        pcc.remplirCalendrier(DATA.getProperty("nomCalendrierDerive"));
        pcc.clickEnregistrerContinuerCalendrier(); //step 7
        pcc.aMCalEnregistre();
        //check titre page facultaatif
        plc = pcc.annuler(driver); //step 8
        Debug.w4it(2000);
        assertTrue(plc.aListeCalendrier());
        plc.aCalendrierDerive();
        Debug.w4it(2000);
        plc.clickMoins(); //step 9
        plc.aPasCalendrierDerive();
        pcc = plc.clickCreerCopie(driver); //step 10
        Debug.w4it(2000);
        assertTrue(pcc.aCreerCalendrierTest1());
        pcc.aCNomRempli();
        pcc.clickEnregistrerContinuerCalendrier(); //step 11
        assertTrue(pcc.aExisteDeja());
        pcc.remplirCalendrier(DATA.getProperty("nomCalendrier2"));
        plc = pcc.clickEnregistrerCalendrier(driver); //step 12
        Debug.w4it(1000);
        assertTrue(plc.aListeCalendrier());
        assertTrue(plc.aMCalEnregistre2());
        //check présence calendrier facultatif

    }

    @Test
    public void CAL_04(){
        PageLogin pl = PageFactory.initElements(driver, PageLogin.class);
        PageAccueil pa = pl.seConnecter(driver, identifiant.getProperty("nomUtilisateur"),identifiant.getProperty("motDePasse")); //step 1
        Debug.w4it(2000); 
        assertTrue(pa.aCalendrier());
        Debug.w4it(1000);
        PageParticipants pp = pa.selectionnerRessources_Participants(driver); //step 2
        Debug.w4it(2000);
        assertTrue("On est sur la page liste des participants", pp.aParticipants());
        //check tableau et données facultatif
        assertTrue("La colonne 'Surnom' est présente", pp.aColSurnom());
        //check boutons et couleurs facultatif
        PageModifierParticipant pmp = pp.clickParticipant(driver); //step 3
        Debug.w4it(2000);
        //assertTrue("On est sur la page 'Modifier le participant'", pmp.aModifierParticipant()); // !! TEXTE HANTÉ !! check en fonction du nom du participant à faire
        pmp.aCPrenomRempli();
        //check nom participant facultatif
        pmp.clickCalendrier(); //step 4
        pmp.aOCalSelect();
        pmp.clickSupprimerCalendrier(); //step 5
        pmp.aOptCalDefaut();
        Debug.w4it(2000);
        pmp.selectionnerPremierCalendrierParent(); //step 6
        pmp.clickSauverEtContinuer();
        Debug.w4it(2000);
        pmp.aMParticipantEnregistre();
        pmp.aODonnéesPersoSelect();
        pmp.clickCalendrier(); //step 7
        pmp.aTypeCalendrier();
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
