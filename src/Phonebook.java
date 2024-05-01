import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Phonebook {
// Объявляем переменную namePhones в которой будет храниться телефонная книга.
//  Ключем является "Имя", а значением список "телефонов". И "Имя" и "Телефон"
//  типа String (чтобы не было ограничений на формат записи номера телефона).
    public Map<String, ArrayList<String>> namePhones = new HashMap<>();
// Объявляем переменную quatityPhones которую будем заполнять параллельно переменной
// namePhones, но в ней будем хранить "Имя" (которое будет являться ключем) и количество
// телефонов у этого абонента (значение).
    public Map<String, Integer> quantityPhones = new HashMap<>();
// Обявляем переменную tmpQuanityPhones. Это временная переменная которая будет нужна для
// организации вывода на печать телефонной книги в порядке убывания числа телефонов у абонента.
// В ней будет дублироваться значение переменной quantityPhones.
    public Map<String, Integer> tmpQuanityPhones = new HashMap<>();

// Метод получает на вход "Имя" и "Телефон", проверяет есть ли такое "Имя" в телефонной книге
// и, если такого имени нет, то создает новую запись с этим "Именем" и "Телефоном", а если такое
// "Имя" есть, то просто добавляет к списку его телефонов еще один "Телефон". Одновременно заполняется
// переменная quantityPhones в которой хранятся "Имена" и количество телефонов у этого "Имени".
    public void addPhone (String name, String phone) {
        int tmp;
        if (!namePhones.containsKey(name)) {                // Если "Имени" еще нет, то создается новая запись
            namePhones.put(name, new ArrayList<>());        // в телефонной книге и в переменной содержащей
            quantityPhones.put(name, 0);                    //  имена и количество телефонов у этого имени
        }
        namePhones.get(name).add(phone);                    // К "Имени" добавляется номер телефона
        tmp = quantityPhones.get(name) + 1;                 // Количество телефонов соответствущих "Имени"
        quantityPhones.put(name,tmp);                       // увеличивается на 1.
    }

// Функция принимает "Имя" и "Телефон" и удаляет этот телефон из телефонной книги и
// уменьшает на 1 количество телефонов соответствующих этому имени в переменной quantityPhones
    public void delPhone (String name, String phone) {
        int tmp;
        namePhones.get(name).remove(phone);                 // Удаление номера телефона phone у абонента name
        tmp = quantityPhones.get(name) - 1;                 // Уменьшение на 1 количества телефонов у абонента
        quantityPhones.put(name, tmp);                      // name в переменной quantityPhones

    }

// Функция принимает "Имя" и удаляет изх телефонной книги запись соответствующую
// этому абоненту.
    public void delName (String name) {
        namePhones.remove(name);            // Удаление записи соответствующей имени name из телефонной книги
        quantityPhones.remove(name);        // Удаление записи соответствующей имени name из переменной quantityPhones
    }

// Вывод на печать телефонной книги в порядке убывния номеров у абонента
    public void print() {
// Объявляем временную переменную в которой будем хранить количество телефонов абонентов
// Это будет список Integer
        ArrayList<Integer> tmpArrayQuantityPhones = new ArrayList<>();
// Из переменной quantityPhones, содержащей пары "Имя" - "Количество телефонов соответствующее этому Имени",
// переписываем в список tmpArrayQuantityPhones только количество телефонов.
        for (Map.Entry<String, Integer> set : quantityPhones.entrySet()) {
            tmpArrayQuantityPhones.add(set.getValue());
        }
// Сортируем список tmpArrayQuantityPhones по убыванию
        Collections.sort(tmpArrayQuantityPhones, Collections.reverseOrder());
// Дублируем переменную quantityPhones, в переменную tmpQuanityPhones
        Map<String, Integer> tmpQuanityPhones = new HashMap<>(quantityPhones);
// В цикле перебираем упорядоченный по убыванию список количества телефонов у абонентов
// tmpArrayQuantityPhones
        for (Integer i : tmpArrayQuantityPhones ) {
// Перебираем временную переменную tmpQuanityPhones содержащую пары
// "Имя" - "Количество телефонов"
            for (Map.Entry<String, Integer> set : tmpQuanityPhones.entrySet()) {
// Проверяем, равно ли число телефонов у текущей записи числу i и если равно, то
                if (set.getValue() == i) {
                    String key = set.getKey();                              // Сохраняем "Имя" в переменную key
                    ArrayList<String> value = namePhones.get(set.getKey()); // Сохраняем список телефонов в переменную
                                                                            // value
                    System.out.print("Фамилия: " + key + " Телефон: " + value + "  ");  // Печатаем в одну строчку
// В задаче сказано, вывести на печать в одну строчку. Гораздо нагляднее результат печати по убыванию числа телефонов
// у абонента выглядит если выводить в столбик. Для этого строку 77 нужно закоментировать, а строку 80 раскоментировать.
//                    System.out.println("Фамилия: " + key + " Телефон: " + value);
                    tmpQuanityPhones.put(set.getKey(), 0);  // В переменную tmpQuanityPhones, по тому ключу, данные по
                                                            // которому уже распечатали, записываем 0, чтобв при
                                                            // следующем проходе эту запись уже не печатать
                }
            }
        }
    }
}
