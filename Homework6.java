import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Homework6 {

    public static void main(String[] args) {
        String name1;
        String name2;
        int phone1;
        int phone2;

        if (args.length == 0) {
            // name1 = "Ivanov";
            // name2 = "Petrov";
            // phone1 = 123456;
            // phone2 = 654321;
            name1 = "David";
            name2 = "David";
            phone1 = 111111;
            phone2 = 222222;
        } else {
            name1 = args[0];
            name2 = args[1];
            phone1 = Integer.parseInt(args[2]);
            phone2 = Integer.parseInt(args[3]);
        }

        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add(name1, phone1);
        myPhoneBook.add(name1, phone2);
        myPhoneBook.add(name2, phone2);
        myPhoneBook.add("name3", 456354);
        myPhoneBook.add("name2", 987456);
        myPhoneBook.add("name2", 954517);
        myPhoneBook.add("David", 172016);

        System.out.println(myPhoneBook.find(name1));
        System.out.println(PhoneBook.getPhoneBook());
        System.out.println(myPhoneBook.find("Me"));
    }    
}
    class PhoneBook {
        private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

        public void add(String name, Integer phoneNum) {

            if(phoneBook.containsKey(name)){
                for(var entry: phoneBook.entrySet()){
                    if(entry.getKey()==name){
                        ((ArrayList<Integer>) entry.getValue()).add(phoneNum);
                    }
                }

            }
            else{
                ArrayList<Integer> newPhones = new ArrayList<Integer>();
                newPhones.add(phoneNum);
                phoneBook.put(name, newPhones);

            }
        }

        public ArrayList<Integer> find(String name) {

            return phoneBook.getOrDefault(name, new ArrayList<Integer>());


        }

        public static HashMap<String, ArrayList<Integer>> getPhoneBook() {

            HashMap<String, ArrayList<Integer>> result = new LinkedHashMap<String, ArrayList<Integer>>();
            while(result.size()<phoneBook.size()){
                int maxCount =0;
                String name="";
                for(var entry: phoneBook.entrySet()){
                                        
                    if(entry.getValue().size()>maxCount && !result.containsKey(entry.getKey()) ){
                        maxCount=entry.getValue().size();
                        name = entry.getKey();
                    }

                }

                result.put(name, phoneBook.get(name));
            }

            return result;
           
        }
    }