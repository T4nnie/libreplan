package project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageMachines extends Page {

    //Xpath select menu Ressource-Machine
    @FindBy(xpath = "//a[@href='/libreplan/resources/machine/machines.zul']")
    private WebElement s_Machine;

    //Xpath de la colonne Nom
    @FindBy(xpath = "//*[@id='pOCQs5-cave'][text()='Nom']")
    private WebElement col_Machine;

    //Xpath de la colonne Description
    @FindBy(xpath = "//*[@id='pOCQt5-cave'][text()='Description']")
    private WebElement col_Desc;

    //Xpath de la colonne Code
    @FindBy(xpath = "//*[@id='pOCQu5-cave'][text()='Code']")
    private WebElement col_Code;

    //Xpath de la colonne En file
    @FindBy(xpath = "//*[@id='pOCQv5-cave'][text()='En file']")
    private WebElement col_EnFile;

    //Xpath de la colonne Opérations
    @FindBy(xpath = "//*[@id='pOCQw5-cave'][text()='Opérations']")
    private WebElement col_Operations;

    //Xpath du champ de recherche "Filtré par" (champ de saisie + icône représentant une loupe)
    @FindBy(xpath = "//*[@id='pOCQq4-real'][@class='z-bandbox-inp']")
    private WebElement c_SaisieFiltre;

    @FindBy(xpath = "//*[@id='pOCQq4-btn'][@class='z-bandbox-btn']")
    private WebElement b_SaisieFiltre;
    
    //Xpath du champ "Détails personnels"
    @FindBy(xpath = "//input[@id='pOCQd5']")
    private WebElement c_DetailsPerso;

    //Xpath du bouton bleu clair [Plus d'options]
    @FindBy(xpath = "//*[@id='pOCQf5-cnt'][contains(., 'options')]")
    private WebElement b_PlusOptions;

    //Xpath du bouton [Filtre]
    //*[@id="pOCQn5-box"]/tbody/tr[2]/td[@class="z-button-cm"]
    @FindBy(xpath = "//*[@id='pOCQn5-box']/tbody/tr[2]/td[contains(., 'Filtre')]")
    private WebElement b_Filtre;

    //Xpath du bouton [Créer]
    @FindBy(xpath = "//*[@id='lSGQx5-box']/tbody/tr[2]/td[contains(., 'Créer')]")
    private WebElement b_Creer;




    //Methodes

}
