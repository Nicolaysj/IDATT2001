import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WAFClient {



    public static void main(String [] args) {

        try {

            ScandinavianWildAnimal ulla = WildAnimalFactory.newFemaleWolf(LocalDate.of(2015, 2, 26),
                    "Ulla",
                    LocalDate.of(2015, 4, 29),
                    "Innhegning 2, Skandinaviske rovdyr");

            System.out.println(ulla.printInfo());
            // (To test logger) System.out.println(2/0);
        } catch (Exception e){
            ZooLogger.getLogger().log(Level.ALL, e.getMessage());
            ZooLogger.closeHandler();
        }
    }
}
