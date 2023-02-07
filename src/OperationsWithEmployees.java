public class OperationsWithEmployees {
    static void printEmployeesList(Employee[] employees) {
        if (Employee.numberOfEmployees == 0) {
            System.out.println("сотрудники отсутсвуют!");
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
}
