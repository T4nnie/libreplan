package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCalendrierCreation extends Page {

     //Vérifie qu'on est sur la page creer calendrier
     @FindBy(xpath = "//td[@class= 'z-caption-l']")
     private WebElement titre_page_creer_calendrier;
 
     public boolean aCreerCalendrier() {
         if(titre_page_creer_calendrier.getAttribute("textContent") .equals("Créer Calendrier")){
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
