package project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageModifierParticipant {

    //Vérifie que l'on est sur la page "Modifier Participants"
    @FindBy(xpath = "(//tr[@valign='middle'])[2]/td[1]")
    private WebElement titre_page_modofier_participants;

    public boolean aModifierParticipant() {
        if(titre_page_modofier_participants.getAttribute("textContent").equals("Modifier Participant: Jean DU")){
            return true;
        }else{
            return false;
        }
    }

}
