package project;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

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
public class PRO_TA {

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
        try{
        identifiant.load(new FileInputStream("src/main/resources/identifiant.properties"));       
        DATA.load(new FileInputStream("src/main/resources/PRO_TA.properties"));
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
    public void PROTA_01(){
        PageLogin pl = PageFactory.initElements(driver, PageLogin.class);   
        PageAccueil pa = pl.seConnecter(driver, identifiant.getProperty("nomUtilisateur"),identifiant.getProperty("motDePasse"));
        PageCreationProjet fc = pa.clickCreerProjet(driver);
        //assert(pa.isMe());
        fc.remplirFormulaire(DATA.getProperty("nvProjet_nom"), DATA.getProperty("nvProjet_code"), "Date", "dateEcheance");
    

    }

    @Test
    public void PROTA_04(){
        PageLogin pl = PageFactory.initElements(driver, PageLogin.class);   


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
