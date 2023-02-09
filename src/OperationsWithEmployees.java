public class OperationsWithEmployees {
    static void printEmployeesList(Employee[] employees) {
        if (Employee.numberOfEmployees == 0) {
            System.out.println("сотрудники отсутсвуют!");
            return;
        }
        System.out.println("Данные всех сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    static void printEmployeesFullNameList(Employee[] employees) {
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

    static int getMonthlySalaryFund(Employee[] employees) {
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

    static Employee getMinSalaryEmployee(Employee[] employees) {
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

    static Employee getMaxSalaryEmployee(Employee[] employees) {
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

    static int getAverageMonthlySalary(Employee[] employees) {
        if (Employee.numberOfEmployees == 0) {
            return 0;
        }
        return getMonthlySalaryFund(employees) / Employee.numberOfEmployees;
    }

    static void indexSalaryEmployees(Employee[] employees, float index) {
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

    static Employee getMinSalaryEmployee(Employee[] employees, int departmentNumber) {
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

    static Employee getMaxSalaryEmployee(Employee[] employees, int departmentNumber) {
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

    static int getMonthlySalaryFund(Employee[] employees, int departmentNumber) {
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

    static int getAverageMonthlySalary(Employee[] employees, int departmentNumber) {
        if (Employee.numberOfEmployees == 0) {
            return 0;
        }
        if (!Employee.isDepartmentCorrect(departmentNumber)) {
            throw new IllegalArgumentException("неверно указан отдел!");
        }
        if (getNumberOfEmployeesByDepartment(employees, departmentNumber) > 0) {
            return getMonthlySalaryFund(employees, departmentNumber) / getNumberOfEmployeesByDepartment(employees, departmentNumber);
        }
        return 0;
    }

    static int getNumberOfEmployeesByDepartment(Employee[] employees, int departmentNumber) {
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

    static void indexSalaryEmployees(Employee[] employees, float index, int departmentNumber) {
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

    static void printEmployeesList(Employee[] employees, int departmentNumber) {
        if (Employee.numberOfEmployees == 0 || getNumberOfEmployeesByDepartment(employees, departmentNumber) == 0) {
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

    static void printEmployeesWithSalaryLess(Employee[] employees, int salaryLevel) {
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

    static void printEmployeesWithSalaryMore(Employee[] employees, int salaryLevel) {
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
