package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageParticipants extends Page{

    //Vérifie qu'on est sur la page PageParticipants
    @FindBy(xpath = "//title[text() = 'LibrePlan: Participants']")
    private WebElement titre_page_participants;

    public boolean aParticipants() {
        if(titre_page_participants.getAttribute("textContent").equals("LibrePlan: Participants")){
            return true;
        }else{
            return false;
        }
    }

    //Click sur le nom du premier participant de la liste et renvoie la PageModifierParticipants
    @FindBy(xpath = "(//span[parent::div[parent::td[parent::tr[parent::tbody]]]])[1]")
    private WebElement nom_participant;

    public PageModifierParticipant clickParticipant(WebDriver driver) {
        nom_participant.click();
        return PageFactory.initElements(driver, PageModifierParticipant.class);
    }

}
