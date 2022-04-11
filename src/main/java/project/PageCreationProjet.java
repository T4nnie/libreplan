package project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageCreationProjet extends Page{

    @FindBy(xpath = "//tbody[@class='z-rows']/tr[1]/td[1]//span")
    WebElement l_nom;
    @FindBy(xpath = "//tbody[@class='z-rows']/tr[1]/td[2]//input")
    WebElement c_nom;
    
    @FindBy(xpath = "//tbody[@class='z-rows']/tr[2]/td[1]//span")
    WebElement l_modele;
    @FindBy(xpath = "//tbody[@class='z-rows']/tr[2]/td[2]//input")
    WebElement c_modele;

    @FindBy(xpath = "//tbody[@class='z-rows']/tr[3]/td[1]//span")
    WebElement l_code;
    @FindBy(xpath = "//tbody[@class='z-rows']/tr[3]/td[2]//input[@type='text']")
    WebElement c_code;
    @FindBy(xpath = "//tbody[@class='z-rows']/tr[3]/td[2]//input[@type='checkbox']")
    WebElement chk_code;
    
    @FindBy(xpath = "//tbody[@class='z-rows']/tr[4]/td[1]//span")
    WebElement l_dateDebut;
    @FindBy(xpath = "//tbody[@class='z-rows']/tr[4]/td[2]//input[@class='z-datebox-inp']")
    WebElement c_dateDebut;
    
    @FindBy(xpath = "//tbody[@class='z-rows']/tr[5]/td[1]//span")
    WebElement l_dateEcheance;
    @FindBy(xpath = "//tbody[@class='z-rows']/tr[5]/td[2]//input[@class='z-datebox-inp']")
    WebElement c_dateEcheance;
    
    @FindBy(xpath = "//tbody[@class='z-rows']/tr[6]/td[1]//span")
    WebElement l_client;
    @FindBy(xpath = "//tbody[@class='z-rows']/tr[6]/td[2]//input")
    WebElement c_client;
    
    @FindBy(xpath = "//tbody[@class='z-rows']/tr[7]/td[1]//span")
    WebElement l_calendrier;
    @FindBy(xpath = "//tbody[@class='z-rows']/tr[7]/td[2]//input")
    WebElement c_calendrier;

    @FindBy(xpath = "//td[.='Accepter'][@class]")
    WebElement b_accepter;
    
    @FindBy(xpath = "//td[.='Annuler'][@class]")
    WebElement b_annuler;

    
    public void remplirFormulaire(String nom, String code, String dateDebut, String dateEcheance){
        c_nom.sendKeys(nom);
        c_code.sendKeys(code);
        c_dateDebut.sendKeys(dateDebut);
        c_dateEcheance.sendKeys(dateEcheance);
    }



}
