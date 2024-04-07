package com.zipcodewilmington.phonebook;

import java.util.*;
import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> map;

    public PhoneBook(Map<String, List<String>> map) {
        this.map =map;
    }

    public PhoneBook() {
//       this.phonebook = new LinkedHashMap<>();
         this(null);
    }

    public void add(String name, String phoneNumber) {
//        List<String> arr = new ArrayList<>();
//        arr.add(phoneNumber);
//        this.phonebook.put(name, arr);
        this.map.put(name, Collections.singletonList(phoneNumber));
    }

    public void addAll(String name, String... phoneNumbers) {
//        List newPhoneNumbers = Arrays.asList(phoneNumbers);
        this.map.put(name, List.of(phoneNumbers));
    }

    public void remove(String name) {
        map.remove(name);

    }

    public Boolean hasEntry(String name) {
        return map.containsKey(name);
    }
    public Boolean hasEntry(String name, String phoneNumber) {
        // retrive entry from phone book

        //declaring var list
        List <String> numbers = map.get(name);
        //see now if list contains the value

        return numbers.contains(phoneNumber);
    }

    public List<String> lookup(String name) {
        return map.get(name);
    }

    public String reverseLookup(String phoneNumber) {
        String key ="";
        for (Map.Entry<String, List<String>> phone : map.entrySet()) {
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
        for (Map.Entry<String, List<String>> PhoneBook : this.map.entrySet()) {
             result.add(PhoneBook.getKey());
        }

        return result;
    }

    public Map<String, List<String>> getMap() {
        return map;
    }
}
