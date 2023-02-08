public class Main {
    static Employee[] employees = new Employee[10];
    public static void main(String[] args) {
        firstLevelDifficultyTest();
    }

    public static void firstLevelDifficultyTest() {
        employees[0] = new Employee("Иван", "Иванович", "Иванов", 3, 56000);
        employees[1] = new Employee("Петр", "Николаевич", "Сидоров", 1, 46000);
        employees[2] = new Employee("Степан", "Сергеевич", "Петров", 5, 126_000);
        System.out.println();
        OperationsWithEmployees.printEmployeesList(employees);
        employees[1].setSalary(57000);
        employees[1].setDepartmentNumber(4);
        System.out.println("\n" + employees[1]);
        System.out.println("\nмесячный фонд заработной платы: " + OperationsWithEmployees.getMonthlySalaryFund(employees) + " руб.");
        System.out.println("\nсотрудник с минимальной ЗП: " + OperationsWithEmployees.getMinSalaryEmployee(employees));
        System.out.println("\nсотрудник с максимальной ЗП: " + OperationsWithEmployees.getMaxSalaryEmployee(employees));
        System.out.println("\nразмер средней ЗП: " + OperationsWithEmployees.getAverageMonthlySalary(employees) + " руб.");
        System.out.println();
        OperationsWithEmployees.printEmployeesFullNameList(employees);
    }
}