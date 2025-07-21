package com.zipcodewilmington.phonebook;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        phonebook = new HashMap<>() ;
    }

    public void add(String name, String phoneNumber) {
         List<String> temp;
        if(phonebook.containsKey(name)){
            temp = phonebook.get(name);
        }else{
            temp = new ArrayList<>();
        }
        temp.add(phoneNumber);
        phonebook.put(name, temp);
    }

    public void addAll(String name, String... phoneNumbers) {
        for(String num : phoneNumbers){
           add(name, num);
        }

        
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name, String phonenum) {

        if(phonenum==null){
            return phonebook.containsKey(name);
        }

        return phonebook.get(name).contains(phonenum);
    }
    public Boolean hasEntry(String name){
        return hasEntry(name, null);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {

        for(String name : phonebook.keySet()){
            for(String num:phonebook.get(name)){
                if(num.equals(phoneNumber))
                    return name;
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        // return new ArrayList<>(phonebook.keySet());
        List<String> temp = new ArrayList<>();
        for(String n : phonebook.keySet())
            temp.add(n);
        return temp;    
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
