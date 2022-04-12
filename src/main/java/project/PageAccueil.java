package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import project.Outils.Debug;

public class PageAccueil extends Page {


    //Vérifie qu'on est sur la page d'accueil
    @FindBy(xpath = "//title")
    private WebElement titre_page;
    
    
    /** 
     * Passer la souris sur l'onglet "Ressources" puis dans le sous-menu qui s'affiche, cliquer sur l'item "Calendriers".
     * @return boolean
     */
    public boolean aCalendrier() {
        System.out.println("text content " + titre_page.getAttribute("textContent"));
        

        if(titre_page.getAttribute("textContent").equals("LibrePlan: Calendrier")){
            return true;
        }else{
            return false;
        }
        
        
    }

    @FindBy(xpath = "//tr[@valign='bottom']/td[2]")
    private WebElement o_ressources;

    /*
    *Passer la souris sur l'onglet "Ressources" puis dans le sous-menu qui s'affiche, cliquer sur l'item "Calendriers".
    */
    @FindBy(xpath = "//a[@href='/libreplan/calendars/calendars.zul']")
    private WebElement l_calendrier;

    
    /** 
     * Passer la souris sur l'onglet "Ressources" puis dans le sous-menu qui s'affiche, cliquer sur l'item "Calendriers".
     * @param driver
     * @return PageListeCalendrier
     */
    public PageListeCalendrier selectionnerRessources_Calendrier(WebDriver driver) {
       moneOnRessourcesSelectA(driver, o_ressources, l_calendrier);
        return PageFactory.initElements(driver, PageListeCalendrier.class);
    }

    /*
    *.
    */
    @FindBy(xpath = "//a[@href='/libreplan/resources/machine/machines.zul']")
    private WebElement l_machines;
    
    /** 
     * Passer la souris sur l'onglet "Ressources" puis dans le sous-menu qui s'affiche, cliquer sur l'item "Machines"
     * @param driver
     * @return PageMachines
     */
    public PageMachines selectionnerRessources_Machines(WebDriver driver) {
        moneOnRessourcesSelectA(driver, o_ressources, l_machines);
        return PageFactory.initElements(driver, PageMachines.class);
    }


    /*
    *Passer la souris sur l'onglet "Ressources" puis dans le sous-menu qui s'affiche, cliquer sur l'item "Participants".
    */
    @FindBy(xpath = "//a[@href='/libreplan/resources/worker/worker.zul']")
    private WebElement l_participants;
    
    /** 
     * @param driver
     * @return PageParticipants
     */
    public PageParticipants selectionnerRessources_Participants(WebDriver driver) {
        moneOnRessourcesSelectA(driver, o_ressources, l_participants);
        return PageFactory.initElements(driver, PageParticipants.class);
    }

    
    /** 
     * @param driver
     * @param on
     * @param a
     */
    /*
    * Passer la souris sur un onglet *on* et selectionner un label *a*
    */
    private void moneOnRessourcesSelectA(WebDriver driver, WebElement on, WebElement a){
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        o_ressources = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@valign='bottom']/td[2]")));
        actions.moveToElement(on).moveToElement(a).click().build().perform();

    }

    @FindBy(xpath="//span[@title='Créer un nouveau projet']//img")
    WebElement b_creerProjet;

    
    /** 
     * @param driver
     * @return PageCreationProjet
     */
    public PageCreationProjet clickCreerProjet(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(b_creerProjet));
        actions.moveToElement(b_creerProjet).click().build().perform();
        Debug.w4it();
        Debug.getAllHandles(driver);
        return PageFactory.initElements(driver.switchTo().frame(0), PageCreationProjet.class);
    }

}
