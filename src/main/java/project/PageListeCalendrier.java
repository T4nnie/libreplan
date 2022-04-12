package project;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageListeCalendrier extends Page{

    public static Properties DATA;

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
    

    //Vérifie la présence de la colonne "Nom"
    @FindBy(xpath = "//div[@class='z-treecol-cnt' and contains(.,'Nom')]")
    private WebElement col_nom;

    public boolean aColNom(){
        if(col_nom.isDisplayed()){
            return true;
        }else{
            return false;
        }
    }


    //Vérifie la présence du bouton "Créer"
    @FindBy(xpath = "//div/span/table/tbody/tr/td[text()='Créer']")
	private WebElement b_creer;

    public boolean aBCreer(){
        if(b_creer.isDisplayed()){
            return true;
        }else{
            return false;
        }

    }


    //Vérifie la présence du calendrier dérivé
    @FindBy(xpath = "//span[text()='Calendrier - Test 1Calendrier - Test Calendrier Derive']")
	private WebElement calendrier_derive;

    public boolean aCalendrierDerive(){
        if(calendrier_derive.isDisplayed()){
            return true;
        }else{
            return false;
        }

    }

    //Vérifie que le calendrier dérivé est bien caché
    public boolean aPasCalendrierDerive(){
        if(calendrier_derive.isDisplayed()){
            return false;
        }else{
            return true;
        }

    }
    

    //Vérifie que le message "Calendrier de base "Calendrier - Test 2" enregistré" s'affiche
    @FindBy(xpath = "//div[@class='message_INFO']/span[@class='z-label']")
	private WebElement m_cal_enregistre;

    public boolean aMCalEnregistre2(){
        DATA  = new Properties();
        try{                   
            DATA.load(new FileInputStream("src/main/resources/JDD/CAL.properties"));
            }catch(IOException e){
                e.printStackTrace();
            } 
            System.out.println(DATA.getProperty("nomCalendrier1")+DATA.getProperty("nomCalendrier2")+" enregistré");
        if(m_cal_enregistre.getAttribute("textContent").equals("Calendrier de base \""+DATA.getProperty("nomCalendrier1")+DATA.getProperty("nomCalendrier2")+"\" enregistré")){
            //"Calendrier de base \"Calendrier - Test 1Calendrier - Test 2\" enregistré"
            //"Calendrier de base \""+DATA.getProperty("nomCalendrier1")+DATA.getProperty("nomCalendrier2")+"\" enregistré")
            return true;
        }else{
            return false;
        }
    }
    

    //Vérifie la présence du Calendrier qui vient d'être créé "Calendrier - Test 1"
    @FindBy(xpath = "(//div[@class='z-treecell-cnt z-overflow-hidden']/span[@class='z-label'])[1]")
	private WebElement e_calendrier_test_1;

    public boolean aElemCalTest1(){
        DATA  = new Properties();
        try{                   
            DATA.load(new FileInputStream("src/main/resources/JDD/CAL.properties"));
            }catch(IOException e){
                e.printStackTrace();
            } 
        if(e_calendrier_test_1.getAttribute("textContent").equals(DATA.getProperty("nomCalendrier1"))){
            return true;
        }else{
            return false;
        }
    }
    
    
}
