/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mountKabru.view;

import byui.cit260.mountKabru.control.GameControl;
import byui.cit260.mountKabru.control.HeroControl;
import byui.cit260.mountKabru.control.InventoryControl;
import byui.cit260.mountKabru.model.Hero;
import byui.cit260.mountKabru.model.Location;
import mountkabru.MountKabru;

import java.util.Scanner;


/**
 *
 * @author Phill
 */
public class GameMenuView extends View {
    
    public GameMenuView() {
           super( "\n"
               + "\n|----------------------------------------|"
               + "\n|                                   ___  |"
               + "\n|                _                 /   \\ |"
               + "\n|             __|_|______         /     \\|"
               + "\n|   __       |      _ _  |    ___|       |"
               + "\n|  /  `_     |  _  |_|_| |   |   |       |"
               + "\n| |  _  |    | | | |_|_| |   |___|    _  |"
               + "\n|_|_|_|_|____|_|_|_______|___|_|_|___|_|_|"
               + "\n|                                        |"
               + "\n|    This here be the Town of Kabru      |"
               + "\n|----------------------------------------|"
               + "\n"
               + "\n  A - go on an [A]dventure"
               + "\n  T - visit the [T]avern"
               + "\n  B - visit the [B]lacksmith"
               + "\n  SC- Visit the [S]pell[C]aster"
               + "\n  P - Visit the [P]rint Shop"
               + "\n  C - [C]haracter stats"
               + "\n  H - please [H]elp!"
               + "\n  S - [S]ave Game"
               + "\n  L - [L]oad Game"
               + "\n  M - [M]ain Menu"
               + "\n--------------------------------------");
    }
    
    
    private String promptMessage;

    @Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase(); //convert choice to upper case
        
        switch (value) {
            case "A": // go kill stuff on an adventure
                this.goAdventure();
                if (MountKabru.getCurrentGame().isEndOfGame()){
                    return true;
                }
                break;
            case "T": // visit the tavern in town
                this.goTavern();
                break;
            case "B": // visit the blacksmith in town
                this.goBlacksmith();
                break;               
            case "P": // visit the blacksmith in town
                this.goPrintShop();
                break;
            case "C": // visit the blacksmith in town
                this.goCharStats();
                break;
            case "H": //help menu
                this.displayHelpMenu();
                break;
            case "S": //help menu
                this.saveGame();
                break;
            case "L": //load game menu
                this.loadGame();
                break;
            case "SC":
                this.goSpellCaster();
                break;
            case "M": //quit game
                return true;
            
            default:
                this.console.println("\n*** Invalid selection *** Try again");
                
                         
        }
        return false;
    }

    public void goAdventure() {
         
       Location[][] locations = MountKabru.getCurrentGame().getWorld().getLocations();
        int rowCount = MountKabru.getCurrentGame().getWorld().getRowCount();
        int columnCount = MountKabru.getCurrentGame().getWorld().getColumnCount();
        
        for (int row = rowCount - 1; row >= 0; row--) {
            this.console.print(" " + (row + 1) + " ");
            for (int column = 0; column < columnCount; column++) {
                this.console.print("|");
                Location location = locations[row][column];
                boolean discovered = location.isDiscovered();
                if (discovered == true) {
                    this.console.print("---");
                    this.console.print("/\\");
                } else {
                    this.console.print("---");
                    this.console.print("??");
                }
                this.console.print("---");
            }
            this.console.print("| \n");
        }

        this.console.println("   |   1    |   2    |   3    |   4    |   5    |   6    |   7    |   8    |"); 
        
       WorldMapView worldMap = new WorldMapView();
       worldMap.display();
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
    
    private void goPrintShop() {
        
        PrintReportView printShop = new PrintReportView();
        printShop.display();
    }
    
    private void goCharStats() {

        HeroControl heroControl = new HeroControl();
        this.console.println(heroControl.displayCharStats());
        heroControl.promptEnterKey();

    }
    
    
    public void displayHelpMenu() {
        
         // create helpHelpMenuView object
        HelpMenuView helpMenuView = new HelpMenuView();
        
        //display the help menu view
        helpMenuView.display();
    }

    private void saveGame() {
        
       new SaveGameView().display();
        
    }
    
    private void goSpellCaster(){
        BuyFromSpellCaster buyFromSpellCaster = new BuyFromSpellCaster();

        buyFromSpellCaster.display();
    }
    
    private void loadGame() {
        new LoadGameView().display();
    }
    
    private void quitGame() {
        System.exit(0);
    }



    

    
}
