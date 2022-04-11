package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageParticipants extends Page{

    //Vérifie qu'on est sur la page PageParticipants
    @FindBy(xpath = "//title[text() = 'LibrePlan: Participants']")
    private WebElement titre_page_participants;

    public boolean aParticipants() {
        if(titre_page_participants.getAttribute("textContent").equals("LibrePlan: Participants")){
            return true;
        }else{
            return false;
        }
    }

    //Click sur le nom du premier participant de la liste et renvoie la PageModifierParticipants
    @FindBy(xpath = "(//span[parent::div[parent::td[parent::tr[parent::tbody]]]])[1]")
    private WebElement nom_participant;

    public PageModifierParticipant clickParticipant(WebDriver driver) {
        nom_participant.click();
        return PageFactory.initElements(driver, PageModifierParticipant.class);
    }

    public class PageParticipantsGRE {
    //Affichage de la page "Liste des participants"
    @FindBy(xpath = "//*[text()='Liste des participants']")
	private WebElement titre_participants;

    //Affichage éléments du tableau
	@FindBy(xpath = "//div[@class='z-column-cnt' and contains(.,'Surnom')]")
	private WebElement col_surnom;
	@FindBy(xpath = "//div[@class='z-column-cnt' and contains(.,'Prénom')]")
	private WebElement col_prenom;
	@FindBy(xpath = "//div[@class='z-column-cnt' and contains(.,'ID')]")
	private WebElement col_id;
	@FindBy(xpath = "//div[@class='z-column-cnt' and contains(.,'Code')]")
	private WebElement col_code;
	@FindBy(xpath = "//div[@class='z-column-cnt' and contains(.,'En file')]")
	private WebElement col_enFile;
	@FindBy(xpath = "//div[@class='z-column-cnt' and contains(.,'Opérations')]")

	private WebElement col_operations;  

    //Affichage du champ de saisie "Filtré par"
    @FindBy(xpath = "//table[@class='filtering-area z-hbox']/tbody/tr/td/table/tbody/tr/td[3]/span/i/input")
    ////*[@id="r3uPn4"][text()="Filtré par"]
	private WebElement c_rechercher;

    //Affichage de l'icône loupe
    @FindBy(xpath = "//table[@class='filtering-area z-hbox']/tbody/tr/td/table/tbody/tr/td[3]/span/i/i")
	private WebElement icone_rechercher;

    //Affichage du champ Détails personnels
    @FindBy(xpath = "//input[@class='z-textbox' and contains(@style,'200')]")
	private WebElement champ_details_perso;

    //Affichage du bouton [Plus options]
    @FindBy(xpath = "//td[@class='z-caption-l' and contains(.,'options')]")
	private WebElement b_plus_doptions;
    //Affichage du bouton [Filtre]
    @FindBy(xpath = "//td[@class='z-button-cm' and contains(.,'Filtre')]")
	private WebElement b_filtre;
    //Affichage du bouton [Créer]
    @FindBy(xpath = "//div/span/table/tbody/tr/td[text()='Créer']")
	private WebElement b_creer;



    //[Page Suivante "Créer participant"]Affichage de la page "Créer Participant"
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
	public void clicCreer() {
		b_creer.click();
	}
	public void clicBoutonRadioCreerNouvelUtilisateur() {
		b_radio_nouvel_utilisateur.click();
	}
	public void clicEnregistrer() {
		b_enregistrer.click();
	}
	public void clicPlusDoptions() {
		b_plus_doptions.click();
	}

	// Méthodes pour renseigner et vérifier des champs

    }
}
