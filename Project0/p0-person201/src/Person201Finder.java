import java.util.List;
import java.io.IOException;


public class Person201Finder {
    public static void main (String[] args) throws IOException {
        /*
        Should first print those who are not me, but also on the same floor (4) of Trinity
        Should also print those who are not me, but are also in Trinity
         */
        Person201 poop = new Person201 ("Lily", "Trinity", 4);
        Person201[] poopArray = Person201Utilities.readURL("https://courses.cs.duke.edu/compsci201/spring23/notes/people.txt");
        //System.out.println("\nSearching for people near " poop.getName() + "\n|");
        System.out.println("People on the same floor: ");
        List<Person201> sameFloor = Person201Utilities.sameFloor(poopArray, poop);
        Person201Utilities.printPeople(sameFloor);

        System.out.println("People in the same building: ");
        List<Person201> sameBuilding = Person201Utilities.sameBuilding(poopArray, poop);
        Person201Utilities.printPeople(sameBuilding);
        
    }
}