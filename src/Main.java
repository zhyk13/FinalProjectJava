
public class Main {
    public static void main(String[] args) {
// Объявляем переменные "Имена" и "Телефоны"
        String name1;
        String name2;
        String name3;
        String name4;
        String phone1;
        String phone2;
        String phone3;
        String phone4;
        String phone5;
        String phone6;
        String phone7;
        String phone8;
        String phone9;
        String phone10;
// Присваиваем объявленным переменным значения
        name1 = "Ivanov";
        name2 = "Сидоров";
        name3 = "Ковалев";
        name4 = "Petrov";
        phone1 = "123456";
        phone2 = "654321";
        phone3 = "333333";
        phone4 = "444444";
        phone5 = "555555";
        phone6 = "666666";
        phone7 = "777777";
        phone8 = "888888";
        phone9 = "999999";
        phone10 = "101010";
// Объявляем переменную myPhoneBook типа Phonebook (телефонная книга)
        Phonebook myPhoneBook = new Phonebook();
// Добавляем в телефонную книгу "Имена" и "Телефоны"
        myPhoneBook.addPhone(name1, phone1);
        myPhoneBook.addPhone(name1, phone2);
        myPhoneBook.addPhone(name4, phone3);
        myPhoneBook.addPhone(name2, phone4);
        myPhoneBook.addPhone(name2, phone5);
        myPhoneBook.addPhone(name2, phone6);
        myPhoneBook.addPhone(name3, phone7);
        myPhoneBook.addPhone(name3, phone8);
        myPhoneBook.addPhone(name3, phone9);
        myPhoneBook.addPhone(name3, phone10);
// Печатаем телефонную книгу (в порядке убывания количества телефонов у абонента)
        myPhoneBook.print();
// Удаляем телефон "999999" у абонента "Ковалев"
        myPhoneBook.delPhone("Ковалев", "999999");
// Печатаем получившуюся телефонную книгу (без телефона "999999" у убонента "Ковалев")
        myPhoneBook.print();
// Полностью удаляем из телефонной книги запись соответствующую абоненту "Peterov"
        myPhoneBook.delName("Petrov");
// Печатаем получившуюся телефонную книгу
        myPhoneBook.print();
    }
}