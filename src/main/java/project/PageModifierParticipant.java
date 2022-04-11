package project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageModifierParticipant {

    //Vérifie que l'on est sur la page "Modifier Participants"
    @FindBy(xpath = "(//tr[@valign='middle'])[2]/td[1]")
    private WebElement titre_page_modifier_participants;

    public boolean aModifierParticipant() {
        if(titre_page_modifier_participants.getAttribute("textContent").equals("Modifier le Participant: Jean DU") || titre_page_modifier_participants.getAttribute("textContent").equals("Modifier Participant: Jean DU")){
            return true;
        }else{
            return false;
        }
    }


    //Click sur l'onglet "Calendrier"
    @FindBy(xpath = "//span[text() = 'Calendrier']")
    private WebElement o_calendrier;
    
    public void clickCalendrier() {
        o_calendrier.click();
    }


    //Click sur le bouton suppprimer calendrier
    @FindBy(xpath = "//td[text() = 'Supprimer le calendrier']")
    private WebElement b_supprimer_calendrier;
    
    public void clickSupprimerCalendrier() {
        b_supprimer_calendrier.click();
    }


    //Click sur la liste de calendriers parents et sélectionne le premier
    @FindBy(xpath = "(//i[@class='z-combobox-btn'])[1]")
    private WebElement b_liste_calendrier_parent;

    // /html/body/div[2]/table/tbody/tr[1]
    // (//div[@class = 'z-combobox-pp z-combobox-shadow']//tr[@class = 'z-comboitem'])[1]
    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr[1]/td[2]")
    private WebElement s_premier_calendrier_parent;
    
    public void selectionnerPremierCalendrierParent() {
        b_liste_calendrier_parent.click();
        s_premier_calendrier_parent.click();
    }


    //Click sur le bouton "Sauver et Continuer"
    @FindBy(xpath = "//td[text()='Sauver et continuer']")
    private WebElement b_sauver_et_continuer;

    public void clickSauverEtContinuer() {
        b_sauver_et_continuer.click();
    }


    //Affichage du champ "Prénom"
    @FindBy(xpath = "(//div[@class='z-row-cnt z-overflow-hidden']/input[@class='z-textbox'])[1]")
	private WebElement c_prenom;

    //Vérifie que le champ "Prénom" est bien rempli
    public boolean aCPrenomRempli(){
        if(c_prenom.getAttribute("textContent").equals("Jean")){
            return true;
        }else{
            return false;
        }
    }
    
    //Vérifie que l'onglet Calendrier est sélectionné
    @FindBy(xpath = "(//div[@class = 'z-tabs-header'])[1]/ul/li[5]")
	private WebElement o_calendrier2;

    public boolean aOCalSelect(){
        if(o_calendrier2.getAttribute("class").equals("z-tab z-tab-seld")){
            return true;
        }else{
            return false;
        }
    }


    //Vérifie que l'option de calendrier Default est sélectionné
    @FindBy(xpath = "(//input[@class='z-combobox-inp'])[1]")
	private WebElement opt_calendrier_defaut;

    public boolean aOptCalDefaut(){
        if(o_calendrier2.getAttribute("value").equals("Default")){
            return true;
        }else{
            return false;
        }
    }


    //Vérifie que le message "Participant enregistré" s'affiche
    @FindBy(xpath = "//div[@class='message_INFO']/span[@class='z-label']")
	private WebElement m_participant_enregistre;

    public boolean aMParticipantEnregistre(){
        if(m_participant_enregistre.getAttribute("textContent").equals("Participant enregistré")){
            return true;
        }else{
            return false;
        }
    }


    //Vérifie que l'onglet Données personnelles est sélectionné
    @FindBy(xpath = "(//div[@class = 'z-tabs-header'])[1]/ul/li[1]")
	private WebElement o_données_personnelles;

    public boolean aODonnéesPersoSelect(){
        if(o_données_personnelles.getAttribute("class").equals("z-tab z-tab-seld")){
            return true;
        }else{
            return false;
        }
    }
    

    //Vérifie que le texte "Dérivé du calendrier Calendrier - Test 1" est affiché
    @FindBy(xpath = "(//tbody/tr/td/span[@class = 'z-label'])[8]")
	private WebElement type_calendrier;

    public boolean aTypeCalendrier(){
        if(type_calendrier.getAttribute("textContent").equals("Dérivé du calendrier Calendrier - Test 1")){
            return true;
        }else{
            return false;
        }
    }
    
}
