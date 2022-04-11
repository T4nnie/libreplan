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
	private WebElement b_filtres;
    //Affichage du bouton [Créer]
    @FindBy(xpath = "//div/span/table/tbody/tr/td[text()='Créer']")
	private WebElement b_creer;


    // Méthodes pour renseigner et vérifier des champs
    
    //Vérifie que la colonne surnom est présente
    public boolean aColSurnom() {
        if(col_surnom.isDisplayed()){
            return true;
        }else{
            return false;
        }
    }


}
