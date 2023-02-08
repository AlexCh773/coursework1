public class Employee {
    static int numberOfEmployees;
    final int ID;
    String firstName, middleName, lastName;
    int departmentNumber;
    int salary;

    public Employee(String firstName, String middleName, String lastName, int departmentNumber, int salary) {
        if (firstName.trim().equals("") || lastName.trim().equals("") || middleName.trim().equals("")) {
            throw new IllegalArgumentException("неверно указаны фамилия имя отчество сотрудника!");
        }
        if (departmentNumber < 1 || departmentNumber > 5) {
            throw new IllegalArgumentException("неверно указан отдел!");
        }
        if (salary < 1) {
            throw new IllegalArgumentException("неверно указан размер заработной платы!");
        }
        numberOfEmployees++;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.departmentNumber = departmentNumber;
        this.salary = salary;
        this.ID = numberOfEmployees;
    }

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setDepartmentNumber(int departmentNumber) {
        if (departmentNumber < 1 || departmentNumber > 5) {
            throw new IllegalArgumentException("неверно указан отдел!");
        }
        this.departmentNumber = departmentNumber;
    }

    public void setSalary(int salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("неверно указан размер заработной платы!");
        }
        this.salary = salary;
    }

    @Override
    public String toString() {
        return lastName + " " +
                firstName + " " +
                middleName + " " +
                ", табельный номер: " + ID +
                ", отдел №" + departmentNumber +
                ", оклад: " + salary + " руб.";
    }
}
