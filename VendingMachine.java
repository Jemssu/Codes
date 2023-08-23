/**
 * This Vending Machine ADT represents the process and operations done by a vending machine.
 * It allows the users to dispense a drink, refill the machine with drinks, as well as able 
 * to change the product placed in the machine itself, such as the type of cola, water etc.
 * 
 * @author James Nathaniel F. Tan
 * @course Data Structures and Algorithms 
 * @topic Data Abstraction Types
 */
public class VendingMachine {  
    private String typeSoda, typeJuice, typeWater;
    private int countSoda, countJuice, countWater;
    /**
     * This is the default constructor that represents the default value of 3 for every drink
     * as well as setting it all to 'generic' types for example. This also represents as the 
     * default creator of the Vending Machine. When no parameters are entered when calling it.
     * 
     * @typeSoda   initializes the type of soda to "Soda X"
     * @countSoda   initialized the count of soda to "3"
     * @typeJuice  initializes the type of juice to "Juice X" 
     * @countJuice  initialized the count of juice to "3"     
     * @typeWater  initializes the type of water to "Water X"
     * @countWater  initialized the count of water to "3"
     */
    public VendingMachine() {
        typeSoda = "Soda X";
        countSoda = 3;
        typeJuice = "Juice X";
        countJuice = 3;
        typeWater = "Water X";
        countWater = 3;
    }

     /**
     * This is a constructor that represents the default value of 3 for every drink, but specifies 
     * the types depending on what was included when calling the method. 
     *  
     * @param typeSoda   initializes the type of sodaindicated in "String 1"
     * @countSoda   initialized the count of soda to "3"
     * @param typeJuice  initializes the type of juice indicated in "String 2" 
     * @countJuice  initialized the count of juice to "3"     
     * @param typeWater  initializes the type of water indicated in "String 3"
     * @countWater  initialized the count of water to "3"
     */
    public VendingMachine(String typeSoda, String typeJuice, String typeWater) {
        this.typeSoda = typeSoda;
        countSoda = 3;
        this.typeJuice = typeJuice;
        countJuice = 3;
        this.typeWater = typeWater;
        countWater = 3;
    }

    /**
     * This is a constructor makes you input the amount for every drink, and  
     * specifies the types depending on what was included when calling the method. 
     * 
     * @param typeSoda   initializes the type of soda indicated in "String 1"
     * @param countSoda   initializes the count of soda indicated in "Int 1"
     * @param typeJuice  initializes the type of juice indicated in "String 2" 
     * @param countJuice  initializes the count of juice indicated in "Int 2"     
     * @param typeWater  initializes the type of water indicated in "String 3"
     * @param countWater  initializes the count of water indicated in "Int 3"
     */
    public VendingMachine(String typeSoda, int countSoda, String typeJuice, int countJuice, String typeWater,  int countWater) {
        this.typeSoda = typeSoda;
        this.countSoda = countSoda;
        this.typeJuice = typeJuice;
        this.countJuice = countJuice;
        this.typeWater = typeWater;
        this.countWater = countWater;
    }

    //Standard/Default Setters
    public void setTypeSoda(String typeSoda) {this.typeSoda = typeSoda;}
    public void setTypeJuice(String typeJuice) {this.typeJuice = typeJuice;}
    public void setTypeWater(String typeWater) {this.typeWater = typeWater;}
    public void setCountSoda(int countSoda) {this.countSoda = countSoda;}
    public void setCountJuice(int countJuice) {this.countJuice = countJuice;}
    public void setCountWater(int countWater) {this.countWater = countWater;}

    //Standard/Default Getters
    public String getTypeSoda() {return typeSoda;}
    public String getTypeJuice() {return typeJuice;}
    public String getTypeWater() {return typeWater;}
    public int getCountSoda() {return countSoda;}
    public int getCountJuice() {return countJuice;}
    public int getCountWater() {return countWater;}

    //Dispense Operations
    public void dispenseSoda() {
        if (countSoda >= 1) {
            countSoda--;
        }
    }//end of method
    public void dispenseJuice() {
        if (countJuice >= 1) {
            countJuice--;
        }
    }//end of method
    public void dispenseWater() {
        if (countWater >= 1) {
            countWater--;
        } 
    }//end of method
    
    //Refill Operations
    public void refillSoda(int quantity) {
        countSoda += quantity;
    }//end of method
    public void refillJuice(int quantity) {
        countJuice += quantity;
    }//end of method
    public void refillWater(int quantity) {
        countWater += quantity;
    }//end of method

    public void refillSoda(String label, int quantity) {
        setTypeSoda(label);
        setCountSoda(quantity);
    }//end of method
    public void refillJuice(String label, int quantity) {
        setTypeJuice(label);
        setCountJuice(quantity);
    }//end of method
    public void refillWater(String label, int quantity) {
        setTypeWater(label);
        setCountWater(quantity);
    }//end of method

    //Observing Operations
    public int[] currentInventory () {
        int[] inventory = {countSoda, countJuice, countWater};
        return inventory;
    }
    public String[] currentTypes () {
        String[] typesInventory = {typeSoda, typeJuice, typeWater};
        return typesInventory;
    }
    
    //Boolean Operations
    public boolean isSodaEmpty() {return (countSoda == 0);}
    public boolean isJuiceEmpty() {return (countJuice == 0);}
    public boolean isWaterEmpty() {return (countWater == 0);}

    public boolean isSodaFull() {return (countSoda >= 3);}
    public boolean isJuiceFull() {return (countJuice >= 3);}
    public boolean isWaterFull() {return (countWater >= 3);}

    /** ADT Modifications #1 ~
     * This method directly prints the string of displayVMInfo(). It also shows additional
     * information such as the boolean statements, isFull and isEmpty. This is best when
     * it is shown in the console to track and see if your data in the JOptionPane syncs 
     * with the one in your console.
     * 
     */
    public void showVMInfo() {
        System.out.println("Soda type\t: " + typeSoda);
        System.out.println("Soda Stock\t: " + countSoda + " pcs");
        System.out.println("Juice type\t: " + typeJuice);
        System.out.println("Juice Stock\t: " + countJuice + " pcs");
        System.out.println("Water type\t: " + typeWater);
        System.out.println("Water Stock\t: " + countWater + " pcs");
        System.out.println("isSodaFull\t: " + isSodaFull());
        System.out.println("isSodaEmpty\t: " + isSodaEmpty());
        System.out.println("isJuiceFull\t: " + isJuiceFull());
        System.out.println("isJuiceEmpty\t: " + isJuiceEmpty());
        System.out.println("isWaterFull\t: " + isWaterFull());
        System.out.println("isWaterEmpty\t: " + isWaterEmpty());
    }//end of method

    /** ADT Modifications #2 ~
     * This method contains the String 'hold'. It is the non-void version of showVMINfo(). 
     * This is best used when with the GUI in the JOptionPane. Which would be discarded
     * later when making this program as I will try to implement a more dynamic layout.
     * 
     */
    public String displayVMInfo() {
        String hold = "Soda Type\t: " + typeSoda 
                    + "\nSoda Left\t: " + countSoda 
                    + "\nJuice Type\t: " + typeJuice 
                    + "\nJuice Left\t: " + countJuice
                    + "\nWater Type\t: " + typeWater 
                    + "\nWater Left\t: " + countWater
                    ;
        return hold;
    }//end of method

    /** ADT Modifications #3 ~
     * This method contains generates the "ITEMS" inside the 
     * vending machine depending on the count of item inside.
     * 
     * @param count this is used with displayVendingMachine().
     * 
     */
    private String generateRow(int count) {
        StringBuilder row = new StringBuilder();
        if (count == 0) {
            row.append("                        ");
        }
        if (count == 1) {
            for (int i = 0; i < count; i++) {
                row.append("  (0) ");
            }
            row.append("                ");
        }
        if (count == 2) {
            for (int i = 0; i < count; i++) {
                row.append("  (0) ");
            }
            row.append("        ");
        }
        if (count == 3) {
            for (int i = 0; i < count; i++) {
                row.append("  (0) ");
            } 
        }
        return row.toString();
    }//end of method

    /** ADT Modifications #4 ~
     * This method contains the String 'vendingMachineLayout'. 
     * This is best used when with the GUI in the JOptionPane. 
     * This represents model that you could see inside the Pane.
     * 
     */
    public String displayVendingMachine() {
        String sodaRow = generateRow(countSoda);
        String juiceRow = generateRow(countJuice);
        String waterRow = generateRow(countWater);
        
        String vendingMachineLayout =
            "          _ _ _ _ _ _ _ _ _\n" +     
            "          |" + sodaRow + " |" +    "<-- Soda\n" +
            "          | = = = = = = =  |\n" +    
            "          |" + juiceRow + " |" +   "<-- Juice\n" +
            "          | = = = = = = =  |\n" +    
            "          |" + waterRow + " |" +   "<-- Water\n" +
            "          | = = = = = = =  |\n" +    
            "          | = = = = = = =  |\n";     
        
        return vendingMachineLayout;
    }//end of method
}//end of class