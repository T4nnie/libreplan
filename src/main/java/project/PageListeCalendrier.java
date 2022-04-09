package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageListeCalendrier extends Page{

    //Vérifie qu'on est sur la page des listes de calendriers
    @FindBy(xpath = "//title")
    private WebElement titre_page;

    public boolean aListeCalendrier(){
        if(titre_page.getAttribute("textContent").equals("LibrePlan:Calendrier")){
            return true;
        }else{
            return false;
        }
    }

    //Créer un calendrier et retourne la PageCalendrierCreation
    @FindBy(xpath = "(//td[@class='z-button-cm'])[6]")
    private WebElement b_creerCalendrier;

    public PageCalendrierCreation clickCreer(WebDriver driver) {
        b_creerCalendrier.click();
        return PageFactory.initElements(driver, PageCalendrierCreation.class);
    }

    /*
    * TODO
    */
    //Click sur l'icone "Créer une dérive" dans la colonne "Opération" et renvoie la PageCalendrierCreation
    @FindBy(xpath = "(//img[@src = '/libreplan/common/img/ico_derived1.png'])[1]")
    private WebElement b_creerDervie;
    public PageCalendrierCreation creerDerive(WebDriver driver) {
        b_creerDervie.click();
        return PageFactory.initElements(driver, PageCalendrierCreation.class);
    
    }

    //Click sur le petit bouton "moins" pour réduire
    @FindBy(xpath = "//span[@class = 'z-dottree-ico z-dottree-root-open']")
    private WebElement b_moins;
    
    public void clickMoins() {
        b_moins.click();
    }


    //Click "créer copie" et renvoie la PageCalendrierCreation
    @FindBy(xpath = "(//img[@src= '/libreplan/common/img/ico_copy1.png'])[1]")
    private WebElement b_creerCopie;

    public PageCalendrierCreation clickCreerCopie(WebDriver driver) {
        b_creerCopie.click();
        return PageFactory.initElements(driver, PageCalendrierCreation.class);
    }

}
