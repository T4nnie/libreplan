package project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageMachines extends Page {

    //Xpath select menu Ressource-Machine
    @FindBy(xpath = "//a[@href='/libreplan/resources/machine/machines.zul']")
    private WebElement s_Machine;


    //Affichage éléments du tableau
    @FindBy(xpath = "(//div[@class='z-column-cnt' and contains(., 'Nom')])[1]")
    private WebElement col_Machine;
    @FindBy(xpath = "(//div[@class='z-column-cnt' and contains(., 'Description')])[1]")
    private WebElement col_Description;
    @FindBy(xpath = "(//div[@class='z-column-cnt' and contains(., 'Code')])[1]")
    private WebElement col_Code;
    @FindBy(xpath = "(//div[@class='z-column-cnt' and contains(., 'En file')])[1]")
    private WebElement col_EnFile;
    @FindBy(xpath = "(//div[@class='z-column-cnt' and contains(., 'Opérations')])[1]")
    private WebElement col_Operations;


    //Xpath du champ de recherche "Filtré par" (champ de saisie + icône représentant une loupe)
    @FindBy(xpath = "//input[@class='z-bandbox-inp']")
    private WebElement c_SaisieFiltre;

    @FindBy(xpath = "//i[@class='z-bandbox-btn']")
    private WebElement b_SaisieFiltre;
    
    //Xpath du champ "Détails personnels"
    @FindBy(xpath = "(//input[@class='z-textbox'])[1]")
    //span[@class="z-label" and contains(., 'Détails personnels')] 
    private WebElement c_DetailsPerso;

    //Xpath du bouton bleu clair [Plus d'options]
    @FindBy(xpath = "//td[@class='z-caption-l' and contains(.,'options')]")
    private WebElement b_PlusOptions;

    //Xpath du bouton [Filtre]
    @FindBy(xpath = "//td[@class='z-button-cm' and contains(.,'Filtre')]")
    private WebElement b_Filtre;

    //Xpath du bouton [Créer]
    @FindBy(xpath = "(//td[@class='z-button-cm' and text()='Créer'])[1]")
    private WebElement b_Creer;



    /* ---------------------*/
    /*       METHODES
    /* ---------------------*/

    //STEP 1 - Connexion à l'application - Profil Admin OK

    //STEP 2 - Accéder à la page de gestion des machines

    @FindBy(xpath = "//title")
    private WebElement titre_page;
    public boolean aMachines(){
        if(titre_page.getAttribute("textContent").equals("LibrePlan: Machines")){
            return true;
        }else{
            return false;
        }    
    }

    //STEP 3 - Créer une machine - Accès au formulaire de création


    //STEP 4 - Créer une machine - Conformité de l'onglet "Données de la machine"
    
    
    //STEP 5- Créer une machine - Bouton [Sauver et continuer]
    
    
    //STEP 6 - Retour page de gestion des machines
}


