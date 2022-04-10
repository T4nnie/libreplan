package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import project.Outils.Debug;

public class PageAccueil extends Page {


    //Vérifie qu'on est sur la page d'accueil
    @FindBy(xpath = "//title")
    private WebElement titre_page;
    
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

    public PageListeCalendrier selectionnerRessources_Calendrier(WebDriver driver) {
       moneOnAndSelectA(driver, o_ressources, l_calendrier);
        return PageFactory.initElements(driver, PageListeCalendrier.class);
    }

    /*
    *Passer la souris sur l'onglet "Ressources" puis dans le sous-menu qui s'affiche, cliquer sur l'item "Machines".
    */
    @FindBy(xpath = "//a[@href='/libreplan/resources/machine/machines.zul']")
    private WebElement l_machines;
    public PageMachines selectionnerRessources_Machines(WebDriver driver) {
        moneOnAndSelectA(driver, o_ressources, l_machines);
        return PageFactory.initElements(driver, PageMachines.class);
    }


    /*
    *Passer la souris sur l'onglet "Ressources" puis dans le sous-menu qui s'affiche, cliquer sur l'item "Participants".
    */
    @FindBy(xpath = "//a[@href='/libreplan/resources/worker/worker.zul']")
    private WebElement l_participants;
    public PageParticipants selectionnerRessources_Participants(WebDriver driver) {
        moneOnAndSelectA(driver, o_ressources, l_participants);
        return PageFactory.initElements(driver, PageParticipants.class);
    }

    /*
    * Passer la souris sur un onglet *on* et selectionner un label *a*
    */
    private void moneOnAndSelectA(WebDriver driver, WebElement on, WebElement a){
        Actions actions = new Actions(driver);
        actions.moveToElement(on).moveToElement(a).click().build().perform();

    }

}
