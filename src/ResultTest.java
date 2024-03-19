import java.util.*;

class PhoneBookResultTest{
    private  HashMap<String, Set<Integer>> phoneBookMapTest = new HashMap<>();

    public void addPhone(String name, int phoneNum) {
// Введите свое решение ниже
        if(phoneBookMapTest.containsKey(name)){
            Set<Integer> al = phoneBookMapTest.get(name);
            al.add(phoneNum);
            phoneBookMapTest.put(name,al);
        }else {
            Set<Integer> phone = new HashSet<>();
            phone.add(phoneNum);
            phoneBookMapTest.put(name,phone);
        }
    }

    public Set<Integer> find(String name) {
// Введите свое решение ниже
        if(phoneBookMapTest.containsKey(name)){
            return phoneBookMapTest.get(name);
        }else {
            return  new HashSet<>();
        }
    }

    public HashMap<String, Set<Integer>> getPhoneBookTest() {
        HashMap<String, Set<Integer>> t = new LinkedHashMap<>();
        Set<String> n = phoneBookMapTest.keySet();
        int sizeValue =1;
        for (String e: n) {
            int size = phoneBookMapTest.get(e).size();
            if (sizeValue < size){
                sizeValue = size;
            }
        }
        while (t.size()<phoneBookMapTest.size()){
            for (String e: n) {
                int size = phoneBookMapTest.get(e).size();
                if (sizeValue == size){
                    t.put(e,phoneBookMapTest.get(e));
                    System.out.println(e + " : " + phoneBookMapTest.get(e));
                }
            }
            sizeValue--;
        }
// Введите свое решение ниже
        return t;
    }
}
public class ResultTest {
    public static void main(String[] args) {
        String name1;
        String name2;
        String name3;
        String name4;
        int phone1;
        int phone2;
        int phone3;
        int phone4;

        if (args.length == 0) {
            name1 = "Ivanov";
            name2 = "Petrov";
            name3 = "Geek";
            name4 = "Brains";
            phone1 = 123457;
            phone2 = 754321;
            phone3 = 847657;
            phone4 = 999657;
        } else {
            name1 = args[0];
            name2 = args[1];
            name3 = args[2];
            name4 = args[3];
            phone1 = Integer.parseInt(args[4]);
            phone2 = Integer.parseInt(args[5]);
            phone3 = Integer.parseInt(args[6]);
            phone4 = Integer.parseInt(args[7]);
        }

        PhoneBookResultTest myPhoneBook = new PhoneBookResultTest();
        myPhoneBook.addPhone(name1, phone1);
        myPhoneBook.addPhone(name1, phone2);
        myPhoneBook.addPhone(name1, phone3);
        myPhoneBook.addPhone(name2, phone1);
        myPhoneBook.addPhone(name2, phone2);
        myPhoneBook.addPhone(name3, phone1);
        myPhoneBook.addPhone(name3, phone2);
        myPhoneBook.addPhone(name3, phone3);
        myPhoneBook.addPhone(name3, phone4);
        myPhoneBook.addPhone(name4, phone1);

        System.out.println(myPhoneBook.find(name2));
        System.out.println(myPhoneBook.getPhoneBookTest());
        System.out.println(myPhoneBook.find("Me"));
    }
}