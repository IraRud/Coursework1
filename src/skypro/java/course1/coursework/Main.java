package skypro.java.course1.coursework;

public class Main {

    private static Employee[] employees = new Employee[10];  // поле типа Employee[]

    public static void generateEmployees() { // создание сотрудников
        employees[0] = new Employee("Максим Финагеев", 1, 20_437);
        employees[1] = new Employee("Андрей Шестопалов", 2, 19_000);
        employees[2] = new Employee("Александр Горохов", 3, 10_568);
        employees[3] = new Employee("Алиса Хорватова", 1, 12_000);
        employees[4] = new Employee("Игорь Долгих", 2, 40_341);
        employees[5] = new Employee("Максим Затеев", 4, 21_237);
        employees[6] = new Employee("Александра Колосова", 5, 27_445);
        employees[7] = new Employee("Полина Гагарина", 3, 23_400);
        employees[8] = new Employee("Сергей Лазарев", 5, 30_000);
        employees[9] = new Employee("Иван Курочкин", 4, 20_000);
    }

    public static void basicDifficulty() {  // БАЗОВАЯ СЛОЖНОСТЬ
        printSpecialSymbol();
        System.out.println("- БАЗОВАЯ СЛОЖНОСТЬ -");
        System.out.println("Список сотрудников: ");
        printEmployees();
        int sumSalary = calculateSumSalary();
        System.out.println("Сумма затрат на зарплаты в месяц составила: " + sumSalary + ".");
        Employee employeeWithMinSalary = findEmployeeWithMinSalary();
        System.out.println("Сотрудник c минимальной зарплатой -> " + employeeWithMinSalary + ".");
        Employee employeeWithMaxSalary = findEmployeeWithMaxSalary();
        System.out.println("Сотрудник c максимальной зарплатой -> " + employeeWithMaxSalary + ".");
        double averageSalary = calculateAverageSalary();
        System.out.println("Среднее значение зарплат: " + averageSalary + ".");
        System.out.println("Ф.И.О. всех сотрудников: ");
        printFullName();
    }

    public static void increasedDifficulty() {  // ПОВЫШЕННАЯ СЛОЖНОСТЬ
        /* Создать дополнительные статические методы для решения следующих задач.
1. Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %).
2. Получить в качестве параметра номер отдела (1–5) и найти (всего 6 методов):
    1. Сотрудника с минимальной зарплатой.
    2. Сотрудника с максимальной зарплатой.
    3. Сумму затрат на зарплату по отделу.
    4. Среднюю зарплату по отделу (учесть, что количество людей в отделе отличается от employees.length).
    5. Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
    6. Напечатать всех сотрудников отдела (все данные, кроме отдела).
3. Получить в качестве параметра число и найти:
    1. Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
    2. Всех сотрудников с зарплатой больше (или равно) числа (вывести id, Ф. И. О. и зарплатой в консоль).*/
        printSpecialSymbol();
        System.out.println("- ПОВЫШЕННАЯ СЛОЖНОСТЬ -");

    }

    public static void main(String[] args) {
        generateEmployees();    // создание списка сотрудников
        basicDifficulty();  // БАЗОВАЯ СЛОЖНОСТЬ
        increasedDifficulty();  // ПОВЫШЕННАЯ СЛОЖНОСТЬ
    }

    public static void printSpecialSymbol() {
        System.out.println("+ ===================== +");
    }

    public static void printEmployees() {    // печать сотрудников
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    public static int calculateSumSalary() {    // вычисление суммы затрат за на зарплаты сотрудников в месяц
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    public static Employee findEmployeeWithMinSalary() {    // поиск сотрудника с минимальной зарплатой
        int min = Integer.MAX_VALUE;    // присваиваем максимальное значение типа int, любая зп сотрудника априори меньше
        Employee result = null;
        for (Employee employee : employees) {
            if (employee.getSalary() <= min) {  // сравниваем с минимальным значением
                min = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public static Employee findEmployeeWithMaxSalary() {    // поиск сотрудника с максимальной зарплатой
        int max = Integer.MIN_VALUE;    // присваиваем минимальное значение типа int, любая зп сотрудника априори больше
        Employee result = null;
        for (Employee employee : employees) {
            if (employee.getSalary() >= max) {  // сравниваем с минимальным значением
                max = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public static double calculateAverageSalary() {     // вычисление среднего значения по зарплатам
        int i = 0;
        int sum = calculateSumSalary();
        for (Employee employee : employees) {
            if (employee != null) {     // на случай если пустой сотрудник (хотя с конструктором класса Employee это невозможно). можно было через length
                i += 1;
            }
        }
        return (double) sum / i;
    }

    public static void printFullName() {    // печать Ф.И.О. всех сотрудников
        for (Employee employee : employees){
            System.out.println(employee.getFullName());
        }
    }

}
