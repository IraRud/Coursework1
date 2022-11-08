package skypro.java.course1.coursework;

import java.util.Objects;

public class Employee {
    private final String fullName;    // ФИО
    private int department;     // отдел
    private int salary;         // зарпалата
    private static int counter = 0; // счетчик для идентификатора
    private final int id;             // id

    public Employee(String fullName, int department, int salary) {  // конструктор
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.id = counter++;  // нумерация id для сотрудника начинается с 0, затем счетчик прибавляет 1
    }

    // создададим геттеры

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    // создадим сеттеры

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    // переопределение

    @Override
    public String toString() {
        return "Ф.И.О.: " + fullName + ", отдел: " + department + ", зарплата: " + salary + ", id: " + id;
    }

    @Override
    public boolean equals(Object other) {   // сравнение по id, т.к. он уникальный для каждого (ФИО, отдел, зарплата у полных тезок в отделе может совпадать)
        if (other == this) {
            return true;
        }
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        Employee someEmployee = (Employee) other;
        return id == someEmployee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
