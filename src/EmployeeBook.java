public class EmployeeBook {
    Employee[] employees = new Employee[10];
    static int numberOfDepartments = 5;

    void addEmployee(String firstName, String middleName, String lastName, int departmentNumber, int salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(firstName, middleName, lastName, departmentNumber, salary);
                return;
            }
        }
    }

    boolean deleteEmployee(String firstName, String middleName, String lastName) {
        int index = findIndexEmployeeByFullName(firstName, middleName, lastName);
        if (index == -1) {
            return false;
        }
        employees[index] = null;
        Employee.decreaseNumberOfEmployees();
        return true;
    }

    boolean deleteEmployee(int id) {
        int index = findIndexEmployeeById(id);
        if (index == -1) {
            return false;
        }
        employees[index] = null;
        Employee.decreaseNumberOfEmployees();
        return true;
    }

    boolean changeEmployee(String firstName, String middleName, String lastName, int newDepartmentNumber, int newSalary) {
        int index = findIndexEmployeeByFullName(firstName, middleName, lastName);
        if (index == -1) {
            return false;
        }
        if (employees[index].getDepartmentNumber() != newDepartmentNumber) {
            employees[index].setDepartmentNumber(newDepartmentNumber);
        }
        if (employees[index].getSalary() != newSalary) {
            employees[index].setSalary(newSalary);
        }
        return true;
    }

    int findIndexEmployeeByFullName(String firstName, String middleName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getFirstName().equals(firstName.trim()) && employees[i].getMiddleName().equals(middleName.trim())
                    && employees[i].getLastName().equals(lastName.trim())) {
                return i;
            }
        }
        return -1;
    }

    int findIndexEmployeeById(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getID() == id) {
                return i;
            }
        }
        return -1;
    }

    void printEmployeesList() {
        if (Employee.numberOfEmployees == 0) {
            System.out.println("сотрудники отсутсвуют!");
            return;
        }
        System.out.println("Данные всех сотрудников(" + Employee.numberOfEmployees + "):");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    void printEmployeesFullNameList() {
        if (Employee.numberOfEmployees == 0) {
            System.out.println("сотрудники отсутсвуют!");
            return;
        }
        System.out.println("Список ФИО всех сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getLastName() + " " + employee.getFirstName().toUpperCase().charAt(0) + "." +
                        employee.getMiddleName().toUpperCase().charAt(0) + ".");
            }
        }
    }

    void printEmployeesFullNameListByDepartment(int departmentNumber) {
        if (Employee.numberOfEmployees == 0 || getNumberOfEmployeesByDepartment(departmentNumber) == 0) {
            System.out.println("в отделе №" + departmentNumber + " сотрудники отсутсвуют!");
            return;
        }
        System.out.println("ФИО сотрудников отдела № " + departmentNumber + ":");
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartmentNumber() == departmentNumber) {
                System.out.println(employee.getLastName() + " " + employee.getFirstName().toUpperCase().charAt(0) + "." +
                        employee.getMiddleName().toUpperCase().charAt(0) + ".");
            }
        }
    }

    void printEmployeesFullNameListByDepartments() {
        if (Employee.numberOfEmployees == 0) {
            System.out.println("сотрудники отсутсвуют!");
            return;
        }
        System.out.println("*Список ФИО всех сотрудников по отделам*\n");
        for (int departmentNumber = 1; departmentNumber <= numberOfDepartments; departmentNumber++) {
            printEmployeesFullNameListByDepartment(departmentNumber);
        }
    }

    int getMonthlySalaryFund() {
        if (Employee.numberOfEmployees == 0) {
            return 0;
        }
        int monthlySalaryFund = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                monthlySalaryFund += employee.getSalary();
            }
        }
        return monthlySalaryFund;
    }

    int getMonthlySalaryFund(int departmentNumber) {
        if (Employee.numberOfEmployees == 0) {
            return 0;
        }
        if (!Employee.isDepartmentCorrect(departmentNumber)) {
            throw new IllegalArgumentException("неверно указан отдел!");
        }
        int monthlySalaryFund = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartmentNumber() == departmentNumber) {
                monthlySalaryFund += employee.getSalary();
            }
        }
        return monthlySalaryFund;
    }

    Employee getMinSalaryEmployee() {
        if (Employee.numberOfEmployees == 0) {
            return null;
        }
        Employee desiredEmployee = null;
        int minSalary = Integer.MAX_VALUE;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                desiredEmployee = employee;
            }
        }
        return desiredEmployee;
    }

    Employee getMinSalaryEmployee(int departmentNumber) {
        if (Employee.numberOfEmployees == 0) {
            return null;
        }
        if (!Employee.isDepartmentCorrect(departmentNumber)) {
            throw new IllegalArgumentException("неверно указан отдел!");
        }
        Employee desiredEmployee = null;
        int minSalary = Integer.MAX_VALUE;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartmentNumber() == departmentNumber && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                desiredEmployee = employee;
            }
        }
        return desiredEmployee;
    }

    Employee getMaxSalaryEmployee() {
        if (Employee.numberOfEmployees == 0) {
            return null;
        }
        Employee desiredEmployee = null;
        int maxSalary = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                desiredEmployee = employee;
            }
        }
        return desiredEmployee;
    }

    Employee getMaxSalaryEmployee(int departmentNumber) {
        if (Employee.numberOfEmployees == 0) {
            return null;
        }
        if (!Employee.isDepartmentCorrect(departmentNumber)) {
            throw new IllegalArgumentException("неверно указан отдел!");
        }
        Employee desiredEmployee = null;
        int maxSalary = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartmentNumber() == departmentNumber && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                desiredEmployee = employee;
            }
        }
        return desiredEmployee;
    }

    int getAverageMonthlySalary() {
        if (Employee.numberOfEmployees == 0) {
            return 0;
        }
        return getMonthlySalaryFund() / Employee.numberOfEmployees;
    }

    void indexSalaryEmployees(float index) {
        if (Employee.numberOfEmployees == 0) {
            return;
        }
        if (index < -99 || index == 0) {
            throw new IllegalArgumentException("неверно указан размер индексации зароботной платы!");
        }
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary((int) (employee.getSalary() * (1 + index / 100)));
            }
        }
    }

    void indexSalaryEmployees(float index, int departmentNumber) {
        if (Employee.numberOfEmployees == 0) {
            return;
        }
        if (index < -99 || index == 0) {
            throw new IllegalArgumentException("неверно указан размер индексации зароботной платы!");
        }
        if (!Employee.isDepartmentCorrect(departmentNumber)) {
            throw new IllegalArgumentException("неверно указан отдел!");
        }
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartmentNumber() == departmentNumber) {
                employee.setSalary((int) (employee.getSalary() * (1 + index / 100)));
            }
        }
    }

    int getAverageMonthlySalary(int departmentNumber) {
        if (Employee.numberOfEmployees == 0) {
            return 0;
        }
        if (!Employee.isDepartmentCorrect(departmentNumber)) {
            throw new IllegalArgumentException("неверно указан отдел!");
        }
        if (getNumberOfEmployeesByDepartment(departmentNumber) > 0) {
            return getMonthlySalaryFund(departmentNumber) / getNumberOfEmployeesByDepartment(departmentNumber);
        }
        return 0;
    }

    int getNumberOfEmployeesByDepartment(int departmentNumber) {
        if (Employee.numberOfEmployees == 0) {
            return 0;
        }
        int numberOfEmployeesByDepartment = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartmentNumber() == departmentNumber) {
                numberOfEmployeesByDepartment++;
            }
        }
        return numberOfEmployeesByDepartment;
    }

    void printEmployeesList(int departmentNumber) {
        if (Employee.numberOfEmployees == 0 || getNumberOfEmployeesByDepartment(departmentNumber) == 0) {
            System.out.println("в отделе №" + departmentNumber + " сотрудники отсутсвуют!");
            return;
        }
        System.out.println("Данные всех сотрудников отдела №" + departmentNumber + ": ");
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartmentNumber() == departmentNumber) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }

    void printEmployeesWithSalaryLess(int salaryLevel) {
        if (Employee.numberOfEmployees == 0) {
            System.out.println("сотрудники отсутсвуют!");
            return;
        }
        System.out.println("Данные всех сотрудников c ЗП меньше " + salaryLevel + " руб.:");
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salaryLevel) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }

    void printEmployeesWithSalaryMore(int salaryLevel) {
        if (Employee.numberOfEmployees == 0) {
            System.out.println("сотрудники отсутсвуют!");
            return;
        }
        System.out.println("Данные всех сотрудников c ЗП больше или равно " + salaryLevel + " руб.:");
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= salaryLevel) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }
}

