package project;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCalendrierCreation extends Page {

    public static Properties DATA;

    
    
     //Vérifie qu'on est sur la page creer calendrier
     @FindBy(xpath = "//td[@class= 'z-caption-l']")
     private WebElement titre_page_creer_calendrier;
 
     public boolean aCreerCalendrier() {
         if(titre_page_creer_calendrier.getAttribute("textContent").equals("Créer Calendrier")){
             return true;
         }else{
             return false;
         }         
     }


     //Vérifie qu'on est sur la page creer calendrier test 1
     @FindBy(xpath = "//td[@class= 'z-caption-l']")
     private WebElement titre_page_creer_calendrier_test1;
 
     public boolean aCreerCalendrierTest1() {
        DATA  = new Properties();
        try{                   
            DATA.load(new FileInputStream("src/main/resources/JDD/CAL.properties"));
            }catch(IOException e){
                e.printStackTrace();
            } 
        System.out.println("Créer Calendrier: "+DATA.getProperty("nomCalendrier1"));
         if(titre_page_creer_calendrier_test1.getAttribute("textContent").equals("Créer Calendrier: "+DATA.getProperty("nomCalendrier1"))){
             return true;
         }else{
             return false;
         }         
     }


     //Vérifie la présence de l'onglet "Données de calendrier"
    @FindBy(xpath = "//span[@class='z-tab-text' and contains(., 'Données de calendrier')]")
    private WebElement o_donnees_de_calendrier;
    
    public boolean aODonnesCalendrier(){
        if(o_donnees_de_calendrier.isDisplayed()){
            return true;
        }else{
            return false;
        }
    }


    


    //Vérifie que le champ "Nom" est bien vide
    @FindBy(xpath = "(//input)[1]")
	private WebElement c_nom;

    public boolean aCNomVide(){
        if(c_nom.getAttribute("textContent").equals("")){
            return true;
        }else{
            return false;
        }
    }


    //Vérifie que le champ "Nom" est bien rempli
    public boolean aCNomRempli(){
        DATA  = new Properties();
        try{                   
            DATA.load(new FileInputStream("src/main/resources/JDD/CAL.properties"));
            }catch(IOException e){
                e.printStackTrace();
            } 
        if(c_nom.getAttribute("textContent").equals(DATA.getProperty("nomCalendrier1"))){
            return true;
        }else{
            return false;
        }
    }
    

    //Vérifie que le message "Calendrier - Test 1 existe déjà" s'affiche
    @FindBy(xpath = "//div[@class='message_WARNING']")
	private WebElement m_existe_deja;

    public boolean aExisteDeja(){
        if(m_existe_deja.isDisplayed()){
            return true;
        }else{
            return false;
        }
    }


    //Vérifie que le message "Calendrier de base "Calendrier - Test Calendrier Dérivé" enregistré" s'affiche
    @FindBy(xpath = "//div[@class='message_INFO']/span[@class='z-label']")
	private WebElement m_cal_enregistre;

    public boolean aMCalEnregistre(){
        DATA  = new Properties();
        try{                   
            DATA.load(new FileInputStream("src/main/resources/JDD/CAL.properties"));
            }catch(IOException e){
                e.printStackTrace();
            } 
        if(m_cal_enregistre.getAttribute("textContent").equals("Calendrier de base \""+DATA.getProperty("nomCalendrierDerive")+"\" enregistré")){
            return true;
        }else{
            return false;
        }
    }

     
    //Remplit un calendrier à sa création
    @FindBy(xpath = "(//input)[1]")
    private WebElement c_nomCalendrier;
    
    public void remplirCalendrier(String nomCalendrier) {
        c_nomCalendrier.sendKeys(nomCalendrier);
    }

    

    //Click boutton enregistrer calendrier puis renvoit la PageListeCalendrier
    @FindBy(xpath = "//td[text() = 'Enregistrer']")
    private WebElement b_enregistrer;

    public PageListeCalendrier clickEnregistrerCalendrier(WebDriver driver) {
        b_enregistrer.click();
        return PageFactory.initElements(driver, PageListeCalendrier.class);
    }

    //Click boutton "enregistrer et continuer"
    @FindBy(xpath = "//td[text() = 'Enregistrer et continuer']")
    private WebElement b_enregistrerEtContinuer;

    public void clickEnregistrerContinuerCalendrier() {
        b_enregistrerEtContinuer.click();
    }

    //Click boutton "Annuler" et renvoie la PageListeCalendrier
    @FindBy(xpath = "(//td[text() = 'Annuler'])[1]")
    private WebElement b_annuler;

    public PageListeCalendrier annuler(WebDriver driver) {
        b_annuler.click();
        return PageFactory.initElements(driver, PageListeCalendrier.class);
    }

    

}
