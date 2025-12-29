import java.util.*;
public class HashmapAssignment {
    public static void main(String[] args ){
        HashMap<Person, Address> taxDefaultersGlenties = new HashMap<>();
        taxDefaultersGlenties.put(new Person("Mike Jones",27),
    new Address(4,"Ard Conell", "Glenties"));
          taxDefaultersGlenties.put(new Person("Alan Patridge",49),
    new Address(19,"Ard McGill", "Glenties"));
       taxDefaultersGlenties.put(new Person("Mary Jones",30),
    new Address(4,"Naomh Conaill Closs", "Glenties"));
       taxDefaultersGlenties.put(new Person("Mark Mosley",30),
    new Address(15,"Ard Conell", "Glenties"));
    


          HashMap<Person, Address> taxDefaultersArdara = new HashMap<>();
          taxDefaultersArdara.put(new Person("Stephen Collum",44),
    new Address(22,"Aran Court", "Ardara"));
   taxDefaultersArdara.put(new Person("Tom Sharpe",56),
    new Address(49,"Ard Na Greine", "Ardara"));
    taxDefaultersArdara.put(new Person("John Irving",28),
    new Address(11,"Aran Court", "Ardara"));
        taxDefaultersArdara.put(new Person("Nick Davies",31),
    new Address(2,"Laconnell", "Ardara"));          
          
    HashMap<String, HashMap<Person, Address>> database = new HashMap<>();
    database.put("Glenties", taxDefaultersGlenties);
    database.put("Ardara", taxDefaultersArdara);
    }
      HashMap<Person, Address> temp = new HashMap<>();
   
}