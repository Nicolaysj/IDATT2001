import java.time.LocalDate;

public class WildAnimalFactory {

    public static ScandinavianWildAnimal newMaleBear(LocalDate arrivalDate, String name, LocalDate dateOfBirth, String address){
       return new MaleIndividual("Bjørn", "Ursus arctos", "Ursidae",
               arrivalDate, name, dateOfBirth, true, address);
    }
    public static ScandinavianWildAnimal newFemaleWolf(LocalDate arrivalDate, String name, LocalDate dateOfBirth, String address){
        return new FemaleIndividual("Ulv", "Canis lupus", "Canidae",
                arrivalDate, name, dateOfBirth, true, address, 0);
    }
    public static ScandinavianWildAnimal newMaleWolf(LocalDate arrivalDate, String name, LocalDate dateOfBirth, String address){
        return new MaleIndividual("Ulv", "Canis lupus", "Canidae",
                arrivalDate, name, dateOfBirth, true, address);
    }

}

class WildAnimalFactorySingleton{

    private static Individual instance;

    private WildAnimalFactorySingleton(){}

    public static ScandinavianWildAnimal newMaleBear(LocalDate arrivalDate, String name, LocalDate dateOfBirth, String address){
        if(instance == null){
            return new MaleIndividual("Bjørn", "Ursus arctos", "Ursidae",
                    arrivalDate, name, dateOfBirth, true, address);
        } return instance;

    }
    public static ScandinavianWildAnimal newFemaleWolf(LocalDate arrivalDate, String name, LocalDate dateOfBirth, String address){
        if(instance==null) {
            return new FemaleIndividual("Ulv", "Canis lupus", "Canidae",
                    arrivalDate, name, dateOfBirth, true, address, 0);
        } return instance;
    }
    public static ScandinavianWildAnimal newMaleWolf(LocalDate arrivalDate, String name, LocalDate dateOfBirth, String address){
        if(instance==null) {
            return new MaleIndividual("Ulv", "Canis lupus", "Canidae",
                    arrivalDate, name, dateOfBirth, true, address);
        }return instance;
    }

}
