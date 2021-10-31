package tutorial;

import java.util.HashMap;
import java.util.Map;

public class MapProgram
{
    public static void main(String[] args)
    {
        Map<String, String> languages = new HashMap<>();
        if (languages.containsKey("Java"))
        {
            System.out.println("Java is already in the map.");
        }
        else
        {
            languages.put("Java", "A compiled high-level, object-oriented, platform independent language.");
            System.out.println("Java added successfully!");
        }

        languages.put("Python", "An interpreted, object-oriented, high-level programming language with dynamic semantics.");
        languages.put("Algol", "An algorithmic language.");
        languages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code.");

        // We can see if the key/value are being added by the first time by getting the return of the "put" method.
        System.out.println("Return of the put operation if key/value are new: " + languages.put("Lisp", "Therein lies madness."));

        // It returns the previous value if present, otherwise returns null. Ex:
        System.out.println("Return of the put operation if key/value are already existent: " + languages.put("Lisp", "Therein lies madness."));

        // By using the ways above you can see if the value is new or not, but you can't prohibit the method to add the
        // value if already existent for example. To bypass this you can use:
        if (languages.containsKey("Java"))
        {
            System.out.println("Java is already in the map.");
        }
        else
        {
            languages.put("Java", "A compiled high-level, object-oriented, platform independent language.");
        }

        System.out.println(languages.get("Java"));
        // If you try to add a value to an existing key, the value of the key will be overwritten. Example:
        languages.put("Java", "This course is about Java.");
        System.out.println(languages.get("Java"));

        System.out.println("=========================================================================================");
        for (String key : languages.keySet())
        {
            System.out.println(key + " : " + languages.get(key));
        }
        System.out.println("=========================================================================================");

        // Removing from the map
        languages.remove("Python");

        // Removing just if the key/value match the condition, as you can see below the remove method returns true or
        // false whether or not it's been capable of deleting the element.
        if (languages.remove("Algol", "A family of algorithmic languages."))
        {
            System.out.println("Algo removed.");
        }
        else
        {
            System.out.println("Algo not removed, key/value pair not found.");
        }

        // Replacing the entry for an specified key.
        // Returns the previous value stored in that key.
        System.out.println(languages.replace("Lisp", "A functional programming language with imperative features."));

        // When you try to replace a non-existing key the value will not be added and the return will be null.
        System.out.println(languages.replace("Scala", "This will not be added."));

        // Using replace that returns a boolean if the key/value informed were found, would update the key with the new
        // value. Used to make sure that the correct value will be updated. Ex:
        if (languages.replace("Lisp", "This will not work", "A functional programming language with imperative features."))
        {
            System.out.println("Lisp replaced.");
        }
        else
        {
            System.out.println("Lisp was not replaced.");
        }

        // putIfAbsent - Will only add to the map if the key's not present used to prevent concurrency issues where
        // one thread doesn't add to the map only for that entry to be overwritten by another thread
    }

}
