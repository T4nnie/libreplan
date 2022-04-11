package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageMachineCreation {
    
    /*
    *TODO
    *Accéder à la page de gestion des machines :
    *Passer la souris sur l'onglet "Ressources" puis dans le sous-menu qui s'affiche, cliquer sur l'item "Machines".
    */

    //[Pas de test 4] Créer une machine - Vérifier la conformité de l'onglet "Données de la machine"
    
    //Affichage des onglets de la création de la machine
	@FindBy(xpath = "//li[@class='z-tab z-tab-seld']//span[text()='Donnée de la machine']")
	public WebElement ongletDonneeMachine;
	@FindBy(xpath = "//input[@class='z-textbox z-textbox-disd z-textbox-text-disd']")
	public WebElement c_code;
	@FindBy(xpath = "//input[@class='focus-element z-textbox z-textbox-text-invalid']")
	public WebElement c_nom;
	@FindBy(xpath = "//input[@class='z-textbox z-textbox-text-invalid']")
	public WebElement c_description;
	
    @FindBy(css =  "div.z-row-cnt.z-overflow-hidden > select")
	public WebElement s_type;
	@FindBy(css =  "div.z-row-cnt.z-overflow-hidden > select > option[selected]")
	public WebElement s_typeSelected;
	@FindBy(xpath = "//div[@class='z-tabpanels']//tr[@class='z-row']//input[@type='checkbox']")
	public WebElement b_checkbox;
	
    //Boutons
	@FindBy(xpath = "//span[@class='save-button global-action z-button']//td[@class='z-button-cm' and text()='Enregistrer']")
	public WebElement b_enregistrer;
	@FindBy(xpath = "//span[@class='save-button global-action z-button']//td[@class='z-button-cm' and text()='Sauver et continuer']")
	public WebElement b_sauverEtContinuer;
	@FindBy(xpath = "(//td[@class='z-button-cm' and text()='Annuler'])[2]")
	public WebElement b_annuler;
	
    //FIN [/Pas de test 4]

    //Elements/Liste Page confirmation création Machine
    //Supprimer Modifier Machine
	@FindBy(xpath = "(//img[@src='/libreplan/common/img/ico_borrar1.png'])[1]")
	public WebElement b_supprimerMachine;
    @FindBy(xpath = "(//img[@src='/libreplan/common/img/ico_editar1.png'])[1]")
	public WebElement b_modifierMachine;
	//Suppression - confirmation suppression
    @FindBy(xpath = "//td[@class='z-button-cm' and text()='OK']")
	public WebElement b_okSupprimer;
    //Suppression - annuler suppression
    @FindBy(xpath = "(//td[@class='z-button-cm' and text()='Annuler'])[3]")
	public WebElement b_koSupprimer;

    /* ---------------------*/
    /*       METHODES
    /* ---------------------*/
    @FindBy(xpath = "//title")
    private WebElement titre_page;
    public boolean aMachines(){
        if(titre_page.getAttribute("textContent").equals("LibrePlan: Machines")){
            return true;
        }else{
            return false;
        }    
    }

    /*
    *Créer une machine - Conformité de l'onglet "Données de la machine" :
    *Vérifier la conformité de l'onglet "Données de la machine".
    */


    /*
    *Créer une machine - Bouton [Sauver et continuer] :
    *- Code : décocher la case "Générer le code" et saisir la valeur suivante dans le champ de saisie : "MACHINETEST1"
    *- Nom : MACHINETEST1
    *- Description : MACHINETEST1
    *- Type : laisser la valeur par défaut de la liste déroulante "Ressource normale"
    *- Cliquer sur le bouton [Sauver et continuer].
    */


    //décocher la case "générer le code"
    
    public void decocherCheckbox(){
        b_checkbox.click();
    }

    //Remplir les champs
    public void remplirMachine(String codeMachine, String nomMachine, String descMachine){
        c_nom.clear();
        c_nom.sendKeys("MACHINETEST1");
        c_code.clear();
        c_code.sendKeys("MACHINETEST1");
        c_description.clear();
        c_description.sendKeys("MACHINETEST1");
    }

    //Cliquer sur le bouton [Sauver et continuer]
    public void sauverEtContinuer() {
        b_sauverEtContinuer.click();
    }

    //Retour page de gestion des machines :
    //Cliquer sur le bouton [Annuler].

    public void annuler(){
        b_annuler.click();
    }

}