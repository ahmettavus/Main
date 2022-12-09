
import java.util.*;

/**
 * This class tries to create the Periodic Table Game according to using by HashMap collection interface.
 *
 * @author ahmet
 * @version 0.0.0.1
 */
public class Main {
    static Map<String, String> periodicTable = new HashMap<String, String>();
    /**
     * Being used by randomElementSymbol and randomElementName, getting the randomElement and Symbol from the HashMap
     */
    static String randomElementSymbol;
    static String randomElementName;

    public static void main(String[] args) {

        periodicTable.put("H", "Hydrogen");
        periodicTable.put("Li", "Lithium");
        periodicTable.put("Na", "Sodium");
        periodicTable.put("K", "Potassium");
        periodicTable.put("Ca", "Calcium");
        periodicTable.put("Ti", "Titanium");
        periodicTable.put("He", "Helium");
        periodicTable.put("Ne", "Neon");
        periodicTable.put("Ar", "Argon");
        periodicTable.put("Al", "Aluminium");

        period();
        run();

    }

    /**
     *
     * Being used this method to getting two different randomElementSymbol and randomElementName random values from the periodicTable collection interface.
     *periodicTable hashMap is divided into as Set interface and afterwards being connected by List.
     */
    public static void period() {
        Set<String> elementSymbols = periodicTable.keySet();
        List<String> elementSymbolList = new ArrayList<String>(elementSymbols);
        Random rand = new Random();
        int randomIndex = rand.nextInt(elementSymbolList.size());
        randomElementSymbol = elementSymbolList.get(randomIndex);
        randomElementName = periodicTable.get(randomElementSymbol);
    }

    /**
     * This method is created to start and central for the program. After being created random name and id according to the periodicTable collections,
     * The program is started and given informations and rules shared by player.
     * The program creates random element and elementSymbol and giving the change to guess the correct answer by player.
     * After played game,
     */

    public static void run() {
        int score = 0;
        int correctAnswerCount = 0;
        int wrongAnswerCount = 0;
        String mainMenu = "-----  Welcome the Guessing Periodic Table Game! ----- \n" +
                "The Rules = If you can fill in the correct answer, you will get +10 points \n" +
                "If not, unfortunately, your total score will be deducted -5 points! \n" +
                "----------------------------------------------------------------------";

        System.out.println(mainMenu);

        while (true) {

            System.out.println("Random element symbol: " + randomElementSymbol + "\n" +
                    "Please writing down the correct element name");

            Scanner userInput = new Scanner(System.in);
            String elementName = userInput.nextLine();

            if (elementName.equalsIgnoreCase(randomElementName)) {
                score += 10;
                correctAnswerCount++;
                System.out.println("Congratulations, correct answer: " + randomElementSymbol + " -- " + randomElementName + "\n " +
                        "If you want to stop the game and get your final score, please press 0!");
                int stop = userInput.nextInt();
                if (stop == 0) {
                    break;
                }

            } else if (!elementName.equalsIgnoreCase(randomElementName)) {

                System.out.println("Wrong answer, please let's try one more time :)");
                wrongAnswerCount++;
                period();
                score -= 5;

            }

        }

        System.out.println("Total Correct Answer = " + correctAnswerCount + "\n" +
                "Total Wrong Answer =  " + wrongAnswerCount + "\n" +
                "Total score = " + score + "\n" +
                "Correct Answers for the Periodic Table Game : ");

        for (HashMap.Entry<String, String> printableValues : periodicTable.entrySet()) {
            System.out.println(printableValues.getKey() + " : " + printableValues.getValue());

        }
    }

}
