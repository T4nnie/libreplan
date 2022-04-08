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
    public PageMachines clickEnregistrerMachine(WebDriver driver){
        return null;
}

    public void remplirMachine(){

    
    }




    /*
    * PAS DE TEST 3
    * Créer une machine - Accès au formulaire de création :
    * Cliquer sur le bouton [Créer].
    */

    //Xpath du bouton Créer une machine
    @FindBy(xpath = "")
    private WebElement clickCreerMachine;

    //Xpath de l'onglet "Données de la machine"
    

    /*
    *Créer une machine - Conformité de l'onglet "Données de la machine" :
    *Vérifier la conformité de l'onglet "Données de la machine".
    */



    /*
    *TODO
    *Créer une machine - Bouton [Sauver et continuer] :
    *1 - Renseigner l'ensemble des champs du bloc "Données de base" avec les valeurs suivantes :
    *- Code : décocher la case "Générer le code" et saisir la valeur suivante dans le champ de saisie : "MACHINETEST1"
    *- Nom : MACHINETEST1
    *- Description : MACHINETEST1
    *- Type : laisser la valeur par défaut de la liste déroulante "Ressource normale"
    *2 - Cliquer sur le bouton [Sauver et continuer].
    */



    /*
    *TODO
    *Retour page de gestion des machines :
    *Cliquer sur le bouton [Annuler].
    */

    public PageMachines annuler(){
        return null;
    }



}
