public class Main {
    static Employee[] employees = new Employee[10];
    public static void main(String[] args) {
        employees[0] = new Employee("Иван", "Иванович", "Иванов", 3, 56_000);
        employees[1] = new Employee("Петр", "Николаевич", "Сидоров", 1, 46_000);
        employees[2] = new Employee("Степан", "Сергеевич", "Петров", 5, 126_000);
        employees[3] = new Employee("Игорь", "Васильевичь", "Лопухов", 3, 100_000);
        employees[4] = new Employee("Иван", "Васильевичь", "Лопата", 3, 55_000);

        firstLevelDifficultyTest();
        secondLevelDifficultyTest();
    }

    public static void firstLevelDifficultyTest() {
        System.out.println("\n***ТЕСТ КУРСОВОЙ РАБОТЫ №1 (БАЗОВАЯ СЛОЖНОСТЬ)***\n");
        OperationsWithEmployees.printEmployeesList(employees);
        employees[1].setSalary(57_000);
        employees[1].setDepartmentNumber(4);
        System.out.println("\n" + employees[1]);
        System.out.println("\nмесячный фонд заработной платы: " + OperationsWithEmployees.getMonthlySalaryFund(employees) + " руб.");
        System.out.println("размер средней ЗП: " + OperationsWithEmployees.getAverageMonthlySalary(employees) + " руб.");
        System.out.println("\nсотрудник с минимальной ЗП: " + OperationsWithEmployees.getMinSalaryEmployee(employees));
        System.out.println("сотрудник с максимальной ЗП: " + OperationsWithEmployees.getMaxSalaryEmployee(employees));
        System.out.println();
        OperationsWithEmployees.printEmployeesFullNameList(employees);
    }

    public static void secondLevelDifficultyTest() {
        System.out.println("\n***ТЕСТ КУРСОВОЙ РАБОТЫ №1 (ПОВЫШЕННАЯ СЛОЖНОСТЬ)***\n");
        OperationsWithEmployees.printEmployeesList(employees);
        int indexingSize = 15;
        OperationsWithEmployees.indexSalaryEmployees(employees, indexingSize);
        System.out.println("\nпроведена индексация заработных плат всех сотрудников на " + indexingSize + " %\n");
        OperationsWithEmployees.printEmployeesList(employees);
        int departmentTest = 3;
        System.out.println("\nмесячный фонд заработной платы по отделу № " + departmentTest + ": " + OperationsWithEmployees.getMonthlySalaryFund(employees, departmentTest) + " руб.");
        System.out.println("размер средней ЗП по отделу № " + departmentTest + ": " + OperationsWithEmployees.getAverageMonthlySalary(employees, departmentTest) + " руб.");
        Employee minSalaryEmployee = OperationsWithEmployees.getMinSalaryEmployee(employees, departmentTest);
        if (minSalaryEmployee == null) {
            System.out.println("\nв отделе №" + departmentTest + " сотрудники отсутствуют! ");
        } else {
            System.out.println("\nсотрудник с минимальной ЗП в отделе №" + departmentTest + ": " + minSalaryEmployee);
        }
        Employee maxSalaryEmployee = OperationsWithEmployees.getMaxSalaryEmployee(employees, departmentTest);
        if (maxSalaryEmployee == null) {
            System.out.println("в отделе №" + departmentTest + " сотрудники отсутствуют! ");
        } else {
            System.out.println("сотрудник с максимальной ЗП в отделе №" + departmentTest + ": " + maxSalaryEmployee);
        }
        indexingSize = 8;
        OperationsWithEmployees.indexSalaryEmployees(employees, indexingSize, departmentTest);
        System.out.println("\nпроведена индексация заработных плат сотрудников отдела №" + departmentTest + " на " + indexingSize + " %\n");
        OperationsWithEmployees.printEmployeesList(employees, departmentTest);
        int salaryLevel = 80000;
        System.out.println();
        OperationsWithEmployees.printEmployeesWithSalaryLess(employees, salaryLevel);
        System.out.println();
        OperationsWithEmployees.printEmployeesWithSalaryMore(employees, salaryLevel);
    }
}