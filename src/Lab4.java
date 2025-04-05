import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lab4 {
    public Lab4(){
        System.out.println("Task 1:");
        List<Student> students = Arrays.asList(
            new Student("Иван", "Иванов", "10б"),
            new Student("Петр", "Петров", "9а"),
            new Student("Анна", "Сидорова", "9б"),
            new Student("Мария", "Павлова", "10а"),
            new Student("Сергей", "Владимиров", "9б"),
            new Student("Ирина", "Холодова", "10а"),
            new Student("Валерий", "Яковлев", "9а")
        );
        List<Student> sortedStudents = task1(students);
        sortedStudents.forEach(System.out::println);
        System.out.println("--------------------");
        System.out.println("Task 2:");
        List<Toy> toys = Arrays.asList(
            new Toy("мяч", "2 руб. 50 коп.", "для детей от 3 до 8 лет"),
            new Toy("кукла", "3 руб. 50 коп.", "для детей от 5 до 10 лет"),
            new Toy("конструктор", "4 руб. 50 коп.", "для детей от 7 до 12 лет"),
            new Toy("кубики", "5 руб. 50 коп.", "для детей от 2 до 5 лет")
        );
        toys = task2(toys);
        toys.forEach(System.out::println);
        System.out.println("--------------------");
        System.out.println("Task 3:");
        List<Element> elements = Arrays.asList(
            new Element("Медь", 8.96, "проводник"),
            new Element("Серебро", 10.49, "проводник"),
            new Element("Кремний", 2.33, "полупроводник"),
            new Element("Резина", 1.1, "изолятор"),
            new Element("Золото", 19.32, "проводник"),
            new Element("Алюминий", 2.7, "проводник")
        );

        List<Element> conductors = filterAndSortConductors(elements);
        conductors.forEach(System.out::println);

    }
    /*
     * 4. Сведения об ученике состоят из его имени и фамилии и названия класса (года обучения и буквы), в котором он учится. 
     * Дана таблица f, содержащая сведения об учениках школы.
     * ж) Собрать в таблице g сведения об учениках 9 -х и 10-х классов, поместив
     * в начале сведения об учениках класса 9а, затем 9б и т.д., затем 10а, 10б и т. д.
     */
    public static List<Student> task1(List<Student> students) {
        return students.stream()
            .filter(s -> s.className.startsWith("9") || s.className.startsWith("10"))
            .sorted(Comparator.comparing((Student s) -> Integer.parseInt(s.className.replaceAll("\\D", "")))
                .thenComparing(s -> s.className.replaceAll("\\d", ""))) 
            .collect(Collectors.toList());
    }

    /*
     * 14. Дана таблица f, содержащая сведения об игрушках: указывается название игрушки 
     * (например, кукла, кубики, мяч, конструктор и т.д.), ее стоимость в копейках и возрастные границы детей, 
     * для которых игрушка предназначена (например, для детей от двух до пяти лет). Получить следующие сведения:
     * ж) имеется ли мяч ценой 2 руб. 50 коп., предназначенный детям от 3 до 8 лет?; если нет, занести сведения об этой игрушке в файл f.
     */
    public static List<Toy> task2(List<Toy> toys) {
        for (Toy toy : toys) {
            if (toy.name.equals("мяч") && toy.price.equals("2 руб. 50 коп.") && toy.age.equals("для детей от 3 до 8 лет")) {
                return toys;
            }
        }
        toys.add(
            new Toy("мяч", "2 руб. 50 коп.", "для детей от 3 до 8 лет")
        );
        return toys;
    }


    /*
     * 11. Дана таблица f, содержащая сведения о веществах: указывается название вещества, 
     * его удельный вес и проводимость (проводник, полупроводник, изолятор).
     * б) выбрать данные о проводниках и упорядочить их по убыванию удельных весов.
     */
    public static List<Element> filterAndSortConductors(List<Element> elements) {
        return elements.stream()
            .filter(s -> s.type.equalsIgnoreCase("проводник")) 
            .sorted(Comparator.comparingDouble((Element s) -> s.weight).reversed())
            .collect(Collectors.toList());
    }

    class Student {
        String firstName;
        String lastName;
        String className; // Например, "9а", "10б" и т.д.
    
        public Student(String firstName, String lastName, String className) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.className = className;
        }
    
        @Override
        public String toString() {
            return firstName + " " + lastName + " (" + className + ")";
        }
    }

    static class Toy{
        String name;
        String price;
        String age;
        
        public Toy(String name, String price, String age){
            this.name = name;
            this.price = price;
            this.age = age;
        }
        @Override
        public String toString(){
            return name + " " + price + " " + age;
        }
    }
    class Element {
        String name;
        double weight;
        String type;
    
        public Element(String name, double weight, String type) {
            this.name = name;
            this.weight = weight;
            this.type = type;
        }
    
        @Override
        public String toString() {
            return name + " (Удельный вес: " + weight + ", Тип: " + type + ")";
        }
    }
}
