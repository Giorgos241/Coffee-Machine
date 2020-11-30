package machine;
import java.util.*;


public class CoffeeMachine {

    /*Initial Values*/
    /*
     * Water -> 400
     * Milk -> 540
     * Coffee Beans -> 120
     * Cups -> 9
     * Money ($) -> 550
     * */
    /*Initial Values*/

    //The values the coffee machine stores
    public enum  coffeeMachineInts{
        WATER("ml of water"),
        MILK("ml of milk"),
        COFFEE_BEANS("grams of coffee"),
        CUPS("disposable cups of coffee"),
        MONEY;

        private final String measureUnit;
        coffeeMachineInts(String measureUnit) {
            this.measureUnit = measureUnit;

        }
        coffeeMachineInts() {
            this.measureUnit = null;

        }

        public String getMeasureUnit() {
            return measureUnit;
        }
    }
    public static Scanner menuChoice = new Scanner(System.in);
    //For the machine producing coffee
    public static EnumMap<coffeeMachineInts, Integer> ingrediesntsMap = new EnumMap<coffeeMachineInts, Integer>(coffeeMachineInts.class);
    //For each coffee you order
    public static EnumMap<coffeeMachineInts, Integer> coffeeIngrediesntsMap = new EnumMap<coffeeMachineInts, Integer>(coffeeMachineInts.class);
    //For making the coffee after passing the subtraction test!
    public static EnumMap<coffeeMachineInts, Integer> ingredientsMapNewValues = new EnumMap<coffeeMachineInts, Integer>(coffeeMachineInts.class);

    public static List<coffeeMachineInts> coffeeMachineIntsListToBeFilled  = new ArrayList<>(List.of(coffeeMachineInts.values()));


    public static String ingredientMissing, choice = null;
    public static boolean checker =false;
    public static int addedResult,subtractedResult = 0;
    public static Integer coffeeMachineValue,coffeeRequiredValue = 0;


    public static void main(String[] args) {
//        System.out.println("Hello World!");

        /*Initialize Values*/
        //    int water,milk,coffeeBeans,disposableCups,money;
        /*Initialize Values*/
        ingrediesntsMap.put(coffeeMachineInts.WATER,400);
        ingrediesntsMap.put(coffeeMachineInts.MILK,540);
        ingrediesntsMap.put(coffeeMachineInts.COFFEE_BEANS,120);
        ingrediesntsMap.put(coffeeMachineInts.CUPS,9);
        ingrediesntsMap.put(coffeeMachineInts.MONEY,550);

        //Select something from the menu
        selectOption();

    }

    static void selectOption(){

        System.out.println("Write action (buy, fill, take, remaining, exit):");
        System.out.print(">");
        choice = menuChoice.next();
        getInput(choice.toLowerCase());
    }

    static  void getInput(String menuInput){
        switch(menuInput){
            case "buy":
                buy();
                break;
            case "fill":
               fill();
               break;
            case "take":
                take();
                break;
            case "remaining":
                remaining();
                break;
            case "exit":
                exit();
            default:
                selectOption();
                break;
        }
    }

    static void remaining(){
        //System.out.println("Remaining!");
        System.out.println("The coffee machine has:");
        System.out.println(ingrediesntsMap.get(coffeeMachineInts.WATER)+" of water");
        System.out.println(ingrediesntsMap.get(coffeeMachineInts.MILK)+" of milk");
        System.out.println(ingrediesntsMap.get(coffeeMachineInts.COFFEE_BEANS)+" of coffee beans");
        System.out.println(ingrediesntsMap.get(coffeeMachineInts.CUPS)+" of disposable cups");
        System.out.println("$"+ingrediesntsMap.get(coffeeMachineInts.MONEY)+" of money");

        //back to the menu you go!
        selectOption();
    }

    static void buy() {
        //System.out.println("Buy!");
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        System.out.print(">");
        choice = menuChoice.next();


            switch (choice) {
                case "1":
                //Fill the coffeeRequiredInts with espresso values
                coffeeIngrediesntsMap.put(coffeeMachineInts.WATER, 250);
                coffeeIngrediesntsMap.put(coffeeMachineInts.MILK, 0);
                coffeeIngrediesntsMap.put(coffeeMachineInts.COFFEE_BEANS, 16);
                coffeeIngrediesntsMap.put(coffeeMachineInts.CUPS, 1);
                coffeeIngrediesntsMap.put(coffeeMachineInts.MONEY, 4);
                prepCoffee();
                break;
            case "2":
                //Fill the coffeeRequiredInts with latte values
                coffeeIngrediesntsMap.put(coffeeMachineInts.WATER, 350);
                coffeeIngrediesntsMap.put(coffeeMachineInts.MILK, 75);
                coffeeIngrediesntsMap.put(coffeeMachineInts.COFFEE_BEANS, 20);
                coffeeIngrediesntsMap.put(coffeeMachineInts.CUPS, 1);
                coffeeIngrediesntsMap.put(coffeeMachineInts.MONEY, 7);
                prepCoffee();
                break;
            case "3":
                //Fill the coffeeRequiredInts with cappuccino values
                coffeeIngrediesntsMap.put(coffeeMachineInts.WATER, 200);
                coffeeIngrediesntsMap.put(coffeeMachineInts.MILK, 100);
                coffeeIngrediesntsMap.put(coffeeMachineInts.COFFEE_BEANS, 12);
                coffeeIngrediesntsMap.put(coffeeMachineInts.CUPS, 1);
                coffeeIngrediesntsMap.put(coffeeMachineInts.MONEY, 6);
                prepCoffee();
                break;
            case "back":
                selectOption();
            default:
                buy();
            }
        }

    static void prepCoffee(){

        /*Check if there is enough to make the coffee*/

        //System.out.println("Checking coffee machine for making "+cName);

        for (coffeeMachineInts m : coffeeMachineInts.values()){

             coffeeMachineValue = ingrediesntsMap.get(m);
             coffeeRequiredValue = coffeeIngrediesntsMap.get(m);

            subtractedResult = coffeeMachineValue-coffeeRequiredValue;
            //Sum money the coffee machine has + value of the coffee you are buying
            addedResult = coffeeIngrediesntsMap.get(coffeeMachineInts.MONEY) + ingrediesntsMap.get(coffeeMachineInts.MONEY);


            if(subtractedResult >= 0) {
                System.out.println("There is enough " +m.toString().toLowerCase());
                ingredientsMapNewValues.put(m,subtractedResult);

            }else{
                System.out.println("There is NOT enough "+m.toString().toLowerCase());
                ingredientMissing = m.toString().toLowerCase();
                checker = true;
            }


        }

        //If its true, then make the subtractions!
        if(checker){
            System.out.println("Sorry, not enough " + ingredientMissing + "!");
            ingredientsMapNewValues.clear();

            checker = false;

            /*Dont make coffee and go back to the menu*/
            selectOption();

        }else{
            System.out.println("I have enough resources, making you a coffee!");

            checker = false;
            /*Have the resources, make the coffee*/
            makeCoffee();
        }

    }

    public static void makeCoffee(){
        //Welcome! All checks indicate that you are able to visit this sacred method.

        for (coffeeMachineInts m : coffeeMachineInts.values()){
            Integer coffeeRequiredValue = ingredientsMapNewValues.get(m);

            ingrediesntsMap.replace(m,coffeeRequiredValue);
            System.out.println(ingredientsMapNewValues);
        }

        //Add the money as well
        ingrediesntsMap.replace(coffeeMachineInts.MONEY, addedResult);

        //Get back to the menu
        selectOption();

    }



    static void fill(){
        //Fill the machine with ingredients
        System.out.println("Fill!");
        coffeeMachineIntsListToBeFilled.remove(coffeeMachineInts.MONEY);



        for(coffeeMachineInts m: coffeeMachineIntsListToBeFilled){
            System.out.println("Write how many "+m.getMeasureUnit().toLowerCase()+ " do you want to add:");
            System.out.print(">");
            int addedAmount = Integer.parseInt(menuChoice.next());
            Integer coffeeMachineValue = ingrediesntsMap.get(m);

            int subtractedResult = coffeeMachineValue+addedAmount;

            ingrediesntsMap.replace(m,subtractedResult);

        }

        selectOption();

    }

    static void take(){
        //Take the money from the machine
        int moneyToGive = ingrediesntsMap.get(coffeeMachineInts.MONEY);

        System.out.println("Take!");

        System.out.println("I gave you $" +moneyToGive);
         ingrediesntsMap.replace(coffeeMachineInts.MONEY, 0);

         selectOption();
    }

    static void exit(){
        System.exit(0);
    }


}
