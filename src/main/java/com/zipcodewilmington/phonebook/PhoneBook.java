package com.zipcodewilmington.phonebook;

import java.util.*;
import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook =new LinkedHashMap<>();
    }

    public PhoneBook() {
//       this.phonebook = new LinkedHashMap<>();
         this(null);
    }

    public void add(String name, String phoneNumber) {
//        List<String> arr = new ArrayList<>();
//        arr.add(phoneNumber);
//        this.phonebook.put(name, arr);
        this.phonebook.put(name, Collections.singletonList(phoneNumber));
    }

    public void addAll(String name, String... phoneNumbers) {
//        List newPhoneNumbers = Arrays.asList(phoneNumbers);
        this.phonebook.put(name, List.of(phoneNumbers));
    }

    public void remove(String name) {
        phonebook.remove(name);

    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }
    public Boolean hasEntry(String name, String phoneNumber) {
        // retrive entry from phone book

        //declaring var list
        List <String> numbers = phonebook.get(name);
        //see now if list contains the value

        return numbers.contains(phoneNumber);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber) {
        String key ="";
        for (Map.Entry<String, List<String>> phone : phonebook.entrySet()) {
            String variable = phone.getValue().toString();
            variable =variable.substring(1,variable.length()-1);
            if (Objects.equals(variable,phoneNumber)) {
                key = phone.getKey();
            }
        }
        return key;
    }

    public List<String> getAllContactNames() {
        List <String> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> PhoneBook : this.phonebook.entrySet()) {
             result.add(PhoneBook.getKey());
        }

        return result;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
