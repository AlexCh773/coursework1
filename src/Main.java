public class Main {
    static EmployeeBook employeeBook = new EmployeeBook();

    public static void main(String[] args) {
        employeeBook.addEmployee("Иван", "Иванович", "Иванов", 3, 56_000);
        employeeBook.addEmployee("Петр", "Николаевич", "Сидоров", 1, 46_000);
        employeeBook.addEmployee("Степан", "Сергеевич", "Петров", 5, 126_000);
        employeeBook.addEmployee("Игорь", "Васильевичь", "Лопухов", 3, 100_000);
        employeeBook.addEmployee("Иван", "Васильевичь", "Лопата", 3, 55_000);
        employeeBook.addEmployee("Василий", "Степанович", "Пастухов", 4, 47_000);

        firstLevelDifficultyTest();
        secondLevelDifficultyTest();
        thirdLevelDifficultyTest();
    }

    public static void firstLevelDifficultyTest() {
        System.out.println("\n***ТЕСТ КУРСОВОЙ РАБОТЫ №1 (БАЗОВАЯ СЛОЖНОСТЬ)***\n");
        employeeBook.printEmployeesList();
        employeeBook.employees[1].setSalary(57_000);
        employeeBook.employees[1].setDepartmentNumber(4);
        System.out.println("\n" + employeeBook.employees[1]);
        System.out.println("\nмесячный фонд заработной платы: " + employeeBook.getMonthlySalaryFund() + " руб.");
        System.out.println("размер средней ЗП: " + employeeBook.getAverageMonthlySalary() + " руб.");
        System.out.println("\nсотрудник с минимальной ЗП: " + employeeBook.getMinSalaryEmployee());
        System.out.println("сотрудник с максимальной ЗП: " + employeeBook.getMaxSalaryEmployee());
        System.out.println();
        employeeBook.printEmployeesFullNameList();
    }

    public static void secondLevelDifficultyTest() {
        System.out.println("\n\n***ТЕСТ КУРСОВОЙ РАБОТЫ №1 (ПОВЫШЕННАЯ СЛОЖНОСТЬ)***\n");
        employeeBook.printEmployeesList();
        int indexingSize = 15;
        employeeBook.indexSalaryEmployees(indexingSize);
        System.out.println("\nпроведена индексация заработных плат всех сотрудников на " + indexingSize + "%\n");
        employeeBook.printEmployeesList();
        int departmentTest = 3;
        System.out.println("\nмесячный фонд заработной платы по отделу № " + departmentTest + ": " + employeeBook.getMonthlySalaryFund(departmentTest) + " руб.");
        System.out.println("размер средней ЗП по отделу № " + departmentTest + ": " + employeeBook.getAverageMonthlySalary(departmentTest) + " руб.");
        Employee minSalaryEmployee = employeeBook.getMinSalaryEmployee(departmentTest);
        if (minSalaryEmployee == null) {
            System.out.println("\nв отделе №" + departmentTest + " сотрудники отсутствуют! ");
        } else {
            System.out.println("\nсотрудник с минимальной ЗП в отделе №" + departmentTest + ": " + minSalaryEmployee);
        }
        Employee maxSalaryEmployee = employeeBook.getMaxSalaryEmployee(departmentTest);
        if (maxSalaryEmployee == null) {
            System.out.println("в отделе №" + departmentTest + " сотрудники отсутствуют! ");
        } else {
            System.out.println("сотрудник с максимальной ЗП в отделе №" + departmentTest + ": " + maxSalaryEmployee);
        }
        indexingSize = 8;
        employeeBook.indexSalaryEmployees(indexingSize, departmentTest);
        System.out.println("\nпроведена индексация заработных плат сотрудников отдела №" + departmentTest + " на " + indexingSize + "%\n");
        employeeBook.printEmployeesList(departmentTest);
        int salaryLevel = 80_000;
        System.out.println();
        employeeBook.printEmployeesWithSalaryLess(salaryLevel);
        System.out.println();
        employeeBook.printEmployeesWithSalaryMore(salaryLevel);
    }

    public static void thirdLevelDifficultyTest() {
        System.out.println("\n\n***ТЕСТ КУРСОВОЙ РАБОТЫ №1 (МАКСИМАЛЬНАЯ СЛОЖНОСТЬ)***\n");
        employeeBook.printEmployeesList();
        String firstName = "Петр", middleName = "Николаевич  ", lastName = " Сидоров";
        if (employeeBook.deleteEmployee(firstName, middleName, lastName)) {
            System.out.println("\n" + lastName.trim() + " " + firstName.trim() + " " + middleName.trim() + " удален из списка сотрудников\n");
            employeeBook.printEmployeesList();
        } else {
            System.out.println("\n" + lastName.trim() + " " + firstName.trim() + " " + middleName.trim() + " не найден в списке сотрудников\n");
        }
        int employeeId = 6;
        if (employeeBook.deleteEmployee(employeeId)) {
            System.out.println("\nсотрудник с id " + employeeId + " удален из списка сотрудников\n");
            employeeBook.printEmployeesList();
        } else {
            System.out.println("\n" + lastName.trim() + " " + firstName.trim() + " " + middleName.trim() + " не найден в списке сотрудников\n");
        }
        firstName = " Игорь";
        middleName = "Васильевичь";
        lastName = " Лопухов";
        if (employeeBook.changeEmployee(firstName, middleName, lastName, 1, 128_000)) {
            System.out.println("\nзаработная плата и номер отдела сотрудника " + lastName.trim() + " " + firstName.trim() + " " + middleName.trim() + ", изменены\n");
            employeeBook.printEmployeesList();
        } else {
            System.out.println("\n" + lastName.trim() + " " + firstName.trim() + " " + middleName.trim() + " не найден в списке сотрудников\n");
        }
        System.out.println();
        employeeBook.printEmployeesFullNameListByDepartments();
    }
}