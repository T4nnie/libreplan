package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageParticipantsCreation extends Page{
    
    //Affichage de la page "Créer Participant"
    @FindBy(xpath = "//td[@class='z-caption-l' and contains(.,'Créer')]")
	private WebElement titre_creer_participant;

    //Affichage de l'onglet Données personnelles
    @FindBy(xpath = "//span[@class='z-tab-text' and contains(.,'Données personnelles')]")
	private WebElement titre_onglet_donnees_persos;

    //Affichage du bloc d'utilisateur lié contenant les boutons radio suivants :
    @FindBy(xpath = "//span[@id and contains(.,'Utilisateur lié')]")
	private WebElement titre_bloc_utilisateur_lie;
    //Non lié : coché par défaut
    @FindBy(xpath = "//label[@class and contains(.,'Non lié')]/preceding-sibling::input")
	private WebElement b_radio_non_lie;
    //Utilisateur existant
    @FindBy(xpath = "//label[@class and contains(.,'Utilisateur existant')]/preceding-sibling::input")
	private WebElement b_radio_utilisateur_existant;
    //Créer un nouvel utilisateur
    @FindBy(xpath = "//label[@class and contains(.,'un nouvel utilisateur')]/preceding-sibling::input")
	private WebElement b_radio_nouvel_utilisateur;

    //Affichage du bouton Enregistrer
    @FindBy(xpath = "//td[text()='Enregistrer']")
	private WebElement b_enregistrer;

    //Affichage du bouton Sauver et continuer
    @FindBy(xpath = "//td[text()='Sauver et continuer']")
	private WebElement b_sauver_continuer;

    //Affichage du bouton Annuler
    @FindBy(xpath = "//span[3][@class='cancel-button global-action z-button']/table/tbody/tr[2]/td[text()='Annuler']")
	private WebElement b_annuler;

    
    


    /*
    *   METHODES
    */
	// Clics sur boutons
	public void clicBoutonRadioCreerNouvelUtilisateur() {
		b_radio_nouvel_utilisateur.click();
	}
	public void clicEnregistrer() {
		b_enregistrer.click();
	}

    // Méthodes pour renseigner et vérifier des champs
	

}
