package com.zipcodewilmington.phonebook;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */

 //---Summary---

 // We're buidling a digital phone book using a map => a book to hold each name like a label and each label points to a list of phone numbers
 // Adding commands such as add people, find numbers and remove people 


 //---PhoneBook Blueprint---

 // The PhoneBook class is designed to manage a collection of phone numbers associated with names.
 // A Map has two elements: A key and a value 
 // Key -> A unique identifier for each entry (in this case, the person's name)
 // Value -> What you get when you look up a key (in this case, list of phone numbers associated with that name)
 // Map<String, List<String>>=> specifies what goes in the box. String for the name and List<String> for the list of phone numbers

public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {

        this.phonebook = new HashMap<>(map);
    }

    //------Initialize PhoneBook ------

    //Purpose: instruction for creating a new empty phonebook
    // This is our CONSTRUCTOR

    public PhoneBook() {

        phonebook = new HashMap<>();
    }


    //------Add Phone Numbers ------

    // Purpose: Adds a phone number for a given name
    // add(String name, String phoneNumber) => Takes a name and a phone number and adds that number to the persons entry
    // If the name already exists, it adds the phone number to the existing list of numbers
    // If the name does not exist, it creates a new entry with the name and adds the phone number to a new list
    
    public void add(String name, String phoneNumber) {

        //get the list of phone numbers for the given name
        List <String> numbers = phonebook.getOrDefault(name, new ArrayList<>());
        
        //add the phone number to the list
        numbers.add(phoneNumber);
        //put the name and phone numbers in the phonebook
        phonebook.put(name, numbers);

    }

    //------Add Multiple Phone Numbers ------

    // Purpose: Adds multiple phone numbers for a given name
    // Just like add but it loops through all the numbers you gave it and adds each one to the list


    public void addAll(String name, String... phoneNumbers) {

        //Adds multiple phone numbers for a given name
        List<String> numbers = phonebook.getOrDefault(name, new ArrayList<>());

        // Iterate through the phone numbers and add them to the list
        for (String number : phoneNumbers) {
            //add each phone number to the list
            numbers.add(number);
        }
        //put the name and phone numbers in the phonebook
        phonebook.put(name, numbers);
    }

    //------Remove Phone Numbers ------

    // Purpose: You give it a name, and it completely erases that person and all their numbers from the phone book
    // Map has built in "delete this key" functionality

    public void remove(String name) {

        phonebook.remove(name);
    }

    //------Check for Phone Numbers ------

    // Purpose: Checks if a name exists in the phone book (true or false)
    // checks to see if key (the name in this case) exists

    public Boolean hasEntry(String name, String phoneNumber) {

    if (phonebook.containsKey(name)) {

        List<String> numbers = phonebook.get(name);

        return numbers != null && numbers.contains(phoneNumber);
    }
    return false;
}

    //------Check for Phone Numbers TESTS ------

    // Purpose: Checks if a name exists in the phone book (true or false)
    // Checks to see if the key (the name in this case) exists
    // If it does, it returns true, otherwise it returns false
    // We need both hasEntry(String name, String phoneNumber) and hasEntry(String name) 
    //because we want to check if a person exists with a specific number or just the name
    
    public Boolean hasEntry(String name) {

    return phonebook.containsKey(name);
}

    //------Lookup Phone Numbers ------

    // Purpose: Looks up a name and returns a list of phone numbers associated with that name
    // If the name does not exist, it returns an empty list
    // Think of it like a label on a box, you look at the label and see what is inside the box
    // If there is no label, you get an empty box

    public List<String> lookup(String name) {

        return phonebook.getOrDefault(name, new ArrayList<>());
    }

    //------Reverse Lookup Phone Numbers ------

    // Purpose: Looks up a phone number and returns the name associated with that number
    // Does the opposite of lookup
    // How it works: goes through every single person in the phone book, looks at their list of numbers and tries to find a match
    // If the number is not found, it returns null

    public String reverseLookup(String phoneNumber)  {

        for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) { //for each entry in the phonebook

            // Check if the list of phone numbers for this entry contains the given phone number

           if (entry.getValue().contains(phoneNumber)) { //if the list of phone numbers contains the phone number we're looking for

                return entry.getKey(); // Return the name associated with the phone number
            }
        }
        return null; // Return null if the phone number is not found
    }

    //------Get All Contact Names ------

    // Purpose: Returns a list of all names in the phone book
    // Think of it like a list of labels you can see/ the code gives you all of its keys

    public List<String> getAllContactNames() {

        return new ArrayList<>(phonebook.keySet());
    }

    //------Get All Phone Numbers ------

    // Purpose: Returns a list of all phone numbers in the phone book
    // Uses the actual internal map that the phone book is using
    
    public Map<String, List<String>> getMap() {

        return phonebook;
    }
}
