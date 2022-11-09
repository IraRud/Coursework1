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
        printSpecialSymbol();
        System.out.println("- ПОВЫШЕННАЯ СЛОЖНОСТЬ -");
        int percentageOfSalaryIncrease = 30;    // величина аргумента повышения зарплаты в %
        calculateSalaryByPercentage(percentageOfSalaryIncrease);    // индексация зарплаты
//        printEmployees();   // для проверки после индексации зп
        int employeesDepartment = 3;    // выбранный отдел
        checkOfEmployeesDepartment(employeesDepartment);   // проверка корректности ввода номера отдела
        Employee departmentEmployeeWithMinSalary = findDepartmentEmployeeWithMinSalary(employeesDepartment);
        System.out.println("Сотрудник c минимальной зарплатой в отделе " + employeesDepartment + " -> " + departmentEmployeeWithMinSalary + ".");
        Employee departmentEmployeeWithMaxSalary = findDepartmentEmployeeWithMaxSalary(employeesDepartment);
        System.out.println("Сотрудник c маскимальной зарплатой в отделе " + employeesDepartment + " -> " + departmentEmployeeWithMaxSalary + ".");
        int sumSalaryOfEmployeesDepartment = calculateSumSalaryOfEmployeesDepartment(employeesDepartment);
        System.out.println("Сумма затрат на зарплаты на зарплаты по отделу " + employeesDepartment + " в месяц: " + sumSalaryOfEmployeesDepartment + ".");
        double averageSalaryOfEmployeesDepartment = calculateAverageSalaryOfEmployeesDepartment(employeesDepartment);
        System.out.println("Среднее значение зарплат по отделу " + employeesDepartment + ": " + averageSalaryOfEmployeesDepartment + ".");
        int percentageOfSalaryIncreaseOfEmployeesDepartment = 50;    // величина аргумента повышения зарплаты в % для выбранного отдела
        calculateSalaryOfEmployeesDepartmentByPercentage(employeesDepartment, percentageOfSalaryIncreaseOfEmployeesDepartment);
        System.out.println("Список сотрудников отдела " + employeesDepartment + ": ");  // уже с учетом индексации зарплаты
        printEmployeesOfEmployeesDepartment(employeesDepartment);
        int numberForComparingSalaries = 20_000;    // число для сравнения с ним зарпалаты сотрудников (уже не отдела, а полный список)
        System.out.println("Список всех сотрудников, зарпалта которых меньше, чем " + numberForComparingSalaries + ": ");
        printEmployeesWithLessThan(numberForComparingSalaries);
        System.out.println("Список всех сотрудников, зарпалта которых больше, чем " + numberForComparingSalaries + ": ");
        printEmployeesWithMoreThan(numberForComparingSalaries);
    }

    public static void main(String[] args) {
        generateEmployees();    // создание списка сотрудников
        basicDifficulty();  // БАЗОВАЯ СЛОЖНОСТЬ
        increasedDifficulty();  // ПОВЫШЕННАЯ СЛОЖНОСТЬ
    }

    public static void printSpecialSymbol() {
        System.out.println("\n+ ===================== +\n");
    }

    public static void printEmployees() {    // печать сотрудников
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    public static int calculateSumSalary() {    // вычисление суммы затрат на зарплаты сотрудников в месяц
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
        int length = 0;
        int sum = calculateSumSalary();
        for (Employee employee : employees) {
            if (employee != null) {     // на случай если пустой сотрудник (хотя с конструктором класса Employee это невозможно). можно было через length
                length += 1;
            }
        }
        return (double) sum / length;
    }

    public static void printFullName() {    // печать Ф.И.О. всех сотрудников
        for (Employee employee : employees){
            System.out.println(employee.getFullName());
        }
    }

    public static void calculateSalaryByPercentage(int percentage) {    // изменение зарплат у всех сотрудников на величину аргумента в %
        for (Employee employee : employees) {
            int setSalary = employee.getSalary() + (employee.getSalary() * percentage / 100);    // т.к. зарплата типа int, то и после вычисления % в нее должно быть записано целое число
            employee.setSalary(setSalary);
        }
    }

    public static void checkOfEmployeesDepartment(int department) {   // проверка корректности ввода отдела
        if (department < 1 || department > 5) {     // при некорректном вводе отдела
            System.out.println("Неверный номер отдела " + department + ".");
        }
    }

    public static Employee findDepartmentEmployeeWithMinSalary(int department) {    // поиск сотрудника отдела (параметр) с минимальной зарплатой
        int min = Integer.MAX_VALUE;    // присваиваем максимальное значение типа int, любая зп сотрудника априори меньше
        Employee result = null;
//        checkEmployeesDepartment(department);
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                if (employee.getSalary() <= min) {  // сравниваем с минимальным значением
                    min = employee.getSalary();
                    result = employee;
                }
            }
        }
        return result;
    }

    public static Employee findDepartmentEmployeeWithMaxSalary(int department) {    // поиск сотрудника отдела (параметр) с максимальной зарплатой
        int max = Integer.MIN_VALUE;    // присваиваем минимальное значение типа int, любая зп сотрудника априори больше
        Employee result = null;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                if (employee.getSalary() >= max) {  // сравниваем с минимальным значением
                    max = employee.getSalary();
                    result = employee;
                }
            }
        }
        return result;
    }

    public static int calculateSumSalaryOfEmployeesDepartment(int department) {    // вычисление суммы затрат на зарплаты по отделу в месяц
        int sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public static double calculateAverageSalaryOfEmployeesDepartment(int department) {     // вычисление среднего значения зарплат по отделу
        int length = 0;
        int sum = calculateSumSalaryOfEmployeesDepartment(department);
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                length += 1;
            }
        }
        return (double) sum / length;
    }

    public static void calculateSalaryOfEmployeesDepartmentByPercentage(int department, int percentage) {    // изменение зарплат у отдела на величину аргумента в %
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                int setSalary = employee.getSalary() + (employee.getSalary() * percentage / 100);    // т.к. зарплата типа int, то и после вычисления % в нее должно быть записано целое число
                employee.setSalary(setSalary);
            }
        }
    }

    public static void printEmployeesOfEmployeesDepartment(int department) {    // печать сотрудников отдела (без отдела)
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                System.out.printf(" id: %d, Ф.И.О.: %s, зарплата: %d.\n", employee.getId(), employee.getFullName(), employee.getSalary());
            }
        }
    }

    public static void printEmployeesWithLessThan(int number) {    // печать сотрудников с зарплатой меньше числа -> id, ФИО, зарплата
        for (Employee employee : employees) {
            if (employee.getSalary() < number) {
                System.out.printf(" id: %d, Ф.И.О.: %s, зарплата: %d.\n", employee.getId(), employee.getFullName(), employee.getSalary());
            }
        }
    }

    public static void printEmployeesWithMoreThan(int number) {    // печать сотрудников с зарплатой большей числа -> id, ФИО, зарплата
        for (Employee employee : employees) {
            if (employee.getSalary() >= number) {
                System.out.printf(" id: %d, Ф.И.О.: %s, зарплата: %d.\n", employee.getId(), employee.getFullName(), employee.getSalary());
            }
        }
    }

}
