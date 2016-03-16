/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mountKabru.view;

import byui.cit260.mountKabru.model.Game;
import byui.cit260.mountKabru.model.Location;
import byui.cit260.mountKabru.model.World;
import mountkabru.MountKabru;


/**
 *
 * @author Phill
 */
public class GameMenuView extends View {
    
    public GameMenuView() {
           super( "\n"
                + "\n--------------------------------------"
                + "\n|  This here be the Town of Kabru    |"
                + "\n--------------------------------------"
                + "\nA - go on an [A]dventure"
                + "\nT - visit the [T]avern"
                + "\nB - visit the [B]lacksmith"
                + "\nH - please [H]elp!"
                + "\nQ - [Q]uit"
                + "\n--------------------------------------");
    }
    
    
    
    private String promptMessage;

    @Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase(); //convert choice to upper case
        
        switch (value) {
            case "A": // go kill stuff on an adventure
                this.goAdventure();
                break;
            case "T": // visit the tavern in town
                this.goTavern();
                break;
            case "B": // visit the blacksmith in town
                this.goBlacksmith();
                break;
            case "H": //help menu
                this.displayHelpMenu();
                break;
            
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                
                         
        }
        return false;
    }

    public void goAdventure() {
         
        //Show the player the map
         Location[][] locations = MountKabru.getCurrentGame().getWorld().getLocations();
         int rowCount = MountKabru.getCurrentGame().getWorld().getRowCount();
         int columnCount = MountKabru.getCurrentGame().getWorld().getColumnCount();
         
         
         System.out.println("This is the map of the world");
         
         
        for (int row = rowCount-1; row >= 0; row--) {
            
            System.out.print(" " + (row+1) + " ");
            for (int column = 0; column < columnCount; column++) {
                System.out.print("|");
                Location location = locations[row][column];
                boolean discovered = location.isDiscovered(); 
                if (discovered == true) {
                 System.out.print("o");
                }
                else {
                System.out.print("---");   
                 System.out.print("??");
                }
                System.out.print("---");
            }
        System.out.print("| \n");
        }
                
       System.out.println("   |   1    |   2    |   3    |   4    |   5    |   6    |   7    |   8    |"); 
         
       // AdventureView adventureView = new AdventureView();
        //adventureView.display();
    }

    public void goTavern() {
        
        //create the tavern view object
        TavernView tavernView = new TavernView();
        //display the tavern view
        tavernView.display();
    }

    public void goBlacksmith() {
        
        //create the tavern view object
        BlacksmithView blacksmithView = new BlacksmithView();
        //display the tavern view
        blacksmithView.display();
    }

    public void displayHelpMenu() {
        
         // create helpHelpMenuView object
        HelpMenuView helpMenuView = new HelpMenuView();
        
        //display the help menu view
        helpMenuView.display();
    }
}
