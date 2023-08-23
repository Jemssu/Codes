/**
 * This is the class that contains the Main method to run the Vending Machine ADT.
 * 
 * @author James Nathaniel F. Tan
 */
import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        String menu[] = {"View Available", "Dispense Drink", "Refill Drink", "Change Stock", "End"};
        String drinkChoice[] = {"Soda", "Juice", "Water"};
        String choice = ""; String hold = ""; int quantity = 0;

        VendingMachine vendingMachine = new VendingMachine("Pepsi", 2, "Apple", 1, "Distilled", 3);
        vendingMachine.showVMInfo();

        do {
            hold = vendingMachine.displayVendingMachine();
            choice = JOptionPane.showInputDialog(
                null, new JTextArea(hold), "Menu", 
                1, null, menu, menu).toString();
                
            switch(choice) {
                case "Dispense Drink":
                    String selectedDrinkDispense = (String) JOptionPane.showInputDialog(
                        null, "Type of Drink:", "Dispense Drink", 
                        JOptionPane.PLAIN_MESSAGE, null, drinkChoice, drinkChoice[0]);
        
                        if (selectedDrinkDispense != null) {
                            switch (selectedDrinkDispense) {
                                case "Soda":
                                    if (!vendingMachine.isSodaEmpty()) {
                                        vendingMachine.dispenseSoda();
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Sorry Customer, No More Soda!");
                                    } //end of if (Soda)
                                    break;
                                case "Juice":
                                    if (!vendingMachine.isJuiceEmpty()) {
                                        vendingMachine.dispenseJuice();
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Sorry Customer, No More Juice!");
                                    } //end of if (Juice)
                                    break;
                                case "Water":
                                    if (!vendingMachine.isWaterEmpty()) {
                                        vendingMachine.dispenseWater();
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Sorry Customer, No More Water!");
                                    } //end of if (Juice)
                                    break;
                            }//end of switch (selectedDrink)
                        }//end of if (selectedDrink)
                break;

                case "Refill Drink":
                    String selectedDrinkAdd = (String) JOptionPane.showInputDialog(
                        null, "Type of Drink:", "Refill Drink", 
                        JOptionPane.PLAIN_MESSAGE, null, drinkChoice, drinkChoice[0]);               

                    if (selectedDrinkAdd != null) {
                        while (true) {
                            String input = JOptionPane.showInputDialog(null, "Enter quantity (1 to 3):");  
                            if (input == null) {
                                break;
                            }//exit when pressing cancel
                            try {
                                quantity = Integer.parseInt(input);
                                if (quantity >= 1 && quantity <= 3) {
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(null, "Please enter a quantity between 1 and 3.");
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                            }//end of try-catch
                        }//end of while

                        switch (selectedDrinkAdd) {
                            case "Soda":
                                if (vendingMachine.getCountSoda() + quantity > 3) {
                                    JOptionPane.showMessageDialog(
                                        null, "The maximum limit for Soda is 3. Refill up to " + (3 - vendingMachine.getCountSoda()) + " only.");
                                } else {
                                    vendingMachine.refillSoda(quantity);
                                }//end of if (Soda) -> checks maximum limit
                            break;
                            case "Juice":
                                if (vendingMachine.getCountJuice() + quantity > 3) {
                                    JOptionPane.showMessageDialog(
                                        null, "The maximum limit for Juice is 3. Refill up to " + (3 - vendingMachine.getCountJuice()) + " only.");
                                } else {
                                    vendingMachine.refillJuice(quantity);;
                                }//end of if (Soda) -> checks maximum limit
                            break;
                            case "Water":
                                if (vendingMachine.getCountWater() + quantity > 3) {
                                    JOptionPane.showMessageDialog(
                                        null, "The maximum limit for Juice is 3. Refill up to " + (3 - vendingMachine.getCountWater()) + " only.");
                                } else {
                                    vendingMachine.refillWater(quantity);;
                            }//end of if (Soda) -> checks maximum limit
                            break;
                        }//end of switch (selectedDrinkAdd)
                    }//end of if (selectedDrinkAdd)
                break;

                case "Change Stock":
                    String selectedDrinkChange = (String) JOptionPane.showInputDialog(
                            null, "Type of Drink:", "Change Stock", 
                        JOptionPane.PLAIN_MESSAGE, null, drinkChoice, drinkChoice[0]);    
                        
                        if (selectedDrinkChange != null) {
                                switch (selectedDrinkChange) {
                                    case "Soda":
                                        if (vendingMachine.getCountSoda() == 0) {
                                            String newSodaType = JOptionPane.showInputDialog(
                                    null, "Type of Soda: ");
                                            if (newSodaType != null && !newSodaType.isEmpty()) {
                                                vendingMachine.setTypeSoda(newSodaType);
                                                JOptionPane.showMessageDialog(
                                                    null, "Label for the Stock of Soda changed to " + newSodaType + ".");           
                                                    while (true) {
                                                        String input = JOptionPane.showInputDialog(null, "Enter quantity (1 to 3):");
                                                        if (input == null) {
                                                            break;
                                                        }
                                                        try {
                                                            quantity = Integer.parseInt(input);
                                                            if (quantity >= 1 && quantity <= 3) {
                                                                vendingMachine.refillSoda(newSodaType, quantity);
                                                                JOptionPane.showMessageDialog(
                                                                    null, "Stock for " + newSodaType + " changed to " + quantity);
                                                                break;
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, "Please enter a quantity between 1 and 3.");
                                                            }
                                                        } catch (NumberFormatException e) {
                                                            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                                                        }//end of tr
                                                    }//end of while
                                            } else {
                                                JOptionPane.showMessageDialog(
                                                    null, "Invalid input. New Soda Label not changed.");
                                            }//end of if (newSodaType)
                                        } else {
                                            JOptionPane.showMessageDialog(
                                                null, "Can't Change Stock! There is some " + 
                                                vendingMachine.getTypeSoda() + " left.");
                                        }//end of if (Soda)
                                        break;
                                    case "Juice":
                                        if (vendingMachine.getCountJuice() == 0) {
                                            String newJuiceType = JOptionPane.showInputDialog(
                                    null, "Type of Juice: ");
                                            if (newJuiceType != null && !newJuiceType.isEmpty()) {
                                                vendingMachine.setTypeJuice(newJuiceType);
                                                JOptionPane.showMessageDialog(
                                                    null, "Label for the Stock of Juice changed to " + newJuiceType + ".");
                                                    while (true) {
                                                        String input = JOptionPane.showInputDialog(null, "Enter quantity (1 to 3):");
                                                        if (input == null) {
                                                            break;
                                                        }
                                                        try {
                                                            quantity = Integer.parseInt(input);
                                                            if (quantity >= 1 && quantity <= 3) {
                                                                vendingMachine.refillJuice(newJuiceType, quantity);
                                                                JOptionPane.showMessageDialog(
                                                                    null, "Stock for " + newJuiceType + " changed to " + quantity);
                                                                break;
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, "Please enter a quantity between 1 and 3.");
                                                            }
                                                        } catch (NumberFormatException e) {
                                                            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                                                        }//end of try-catch
                                                    }//end of while
                                            } else {
                                                JOptionPane.showMessageDialog(
                                                    null, "Invalid input. New Juice Label not changed.");
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(
                                                null, "Can't Change Stock! There is some " + 
                                                vendingMachine.getTypeJuice() + " left.");
                                        }
                                        break;
                                    case "Water":
                                        if (vendingMachine.getCountWater() == 0) {
                                            String newWaterType = JOptionPane.showInputDialog(
                                    null, "Type of Water: ");
                                            if (newWaterType != null && !newWaterType.isEmpty()) {
                                                vendingMachine.setTypeWater(newWaterType);
                                                JOptionPane.showMessageDialog(
                                                    null, "Label for the Water of Soda changed to " + newWaterType + ".");
                                                    while (true) {
                                                        String input = JOptionPane.showInputDialog(null, "Enter quantity (1 to 3):");
                                                        if (input == null) {
                                                            break;
                                                        }
                                                        try {
                                                            quantity = Integer.parseInt(input);
                                                            if (quantity >= 1 && quantity <= 3) {
                                                                vendingMachine.refillWater(newWaterType, quantity);
                                                                JOptionPane.showMessageDialog(
                                                                    null, "Stock for " + newWaterType + " changed to " + quantity);
                                                                break;
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, "Please enter a quantity between 1 and 3.");
                                                            }
                                                        } catch (NumberFormatException e) {
                                                            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                                                        }//end of try-catch
                                                    }//end of while
                                            } else {
                                                JOptionPane.showMessageDialog(
                                                    null, "Invalid input. New Water Label not changed.");
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(
                                                null, "Can't Change Stock! There is some " + 
                                                vendingMachine.getTypeWater() + " left.");
                                        }
                                        break;
                                }//end of switch (selectedDrink)
                            }//end of if (selectedDrink)
                break;
                case "View Available":
                    int[] inventory = vendingMachine.currentInventory();
                    String[] typesInventory = vendingMachine.currentTypes();
                    String stockInfo = "Current Available Flavors:\n\n";
                    for (int i = 0; i < inventory.length; i++) {
                        stockInfo += typesInventory[i] + " " + drinkChoice[i] + ": " + inventory[i] + "\n";
                    }//end of for (Showing the Available Products)
                    JOptionPane.showMessageDialog(null, stockInfo, "Current Stock", JOptionPane.INFORMATION_MESSAGE);                  
                break;
                case "End":
            }//end of switch (choice)
        } while(!choice.equals("End"));//end of while (main program)
    }//end of main
}//end of class