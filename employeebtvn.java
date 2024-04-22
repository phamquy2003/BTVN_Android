package employeebtvn;


import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private int age;
    private String department;
    private String code;
    private double salaryRate;

    public Employee(int id, String name, int age, String department, String code, double salaryRate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.code = code;
        this.salaryRate = salaryRate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public String getCode() {
        return code;
    }

    public double getSalaryRate() {
        return salaryRate;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Department: " + department + ", Code: " + code + ", Salary Rate: " + salaryRate;
    }
}

class EmployeeManager {
    private ArrayList<Employee> employees;

    public EmployeeManager() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(int id) {
        employees.removeIf(employee -> employee.getId() == id);
    }

    public void displayEmployees() {
        System.out.println("Danh sach nhan vien:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        initializeEmployees(employeeManager);

        while (true) {
            System.out.println("\n Tuy Chon:");
            System.out.println("1. Hien thi Nhan Vien");
            System.out.println("2. Them Nhan Vien ");
            System.out.println("3. Xoa Nhan Vien");
            System.out.println("4. Thoat");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                    employeeManager.displayEmployees();
                    break;
                case 2:
                    addNewEmployee(employeeManager);
                    break;
                case 3:
                    removeEmployee(employeeManager);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void initializeEmployees(EmployeeManager employeeManager) {
        employeeManager.addEmployee(new Employee(1, "Pham Quy", 30, "HR", "EMP001", 3000));
employeeManager.addEmployee(new Employee(2, "Luong Anh Tu", 25, "IT", "EMP002", 3500));
        employeeManager.addEmployee(new Employee(3, "Pham Trang", 35, "Finance", "EMP003", 4000));
        employeeManager.addEmployee(new Employee(4, "Pham Quynh", 28, "Marketing", "EMP004", 3200));
        employeeManager.addEmployee(new Employee(5, "Do Nhi", 40, "HR", "EMP005", 3800));
        employeeManager.addEmployee(new Employee(6, "Pham Ngoc", 32, "IT", "EMP006", 3600));
        employeeManager.addEmployee(new Employee(7, "Doan Manh", 27, "Finance", "EMP007", 4200));
        employeeManager.addEmployee(new Employee(8, "Ngoc Nhi", 38, "Marketing", "EMP008", 3300));
        employeeManager.addEmployee(new Employee(9, "Do Thinh", 29, "HR", "EMP009", 3900));
        employeeManager.addEmployee(new Employee(10, "Nguyen Thom", 33, "IT", "EMP010", 3700));
    }

    private static void addNewEmployee(EmployeeManager employeeManager) {
        System.out.println("Nhap ten nhan vien:");
        String name = scanner.nextLine();
        System.out.println("Nhap tuoi nhan vien:");
        int age = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Phong Ban:");
        String department = scanner.nextLine();
        System.out.println("Nhap ma nhan vien:");
        String code = scanner.nextLine();
        System.out.println("Nhap tien luong:");
        double salaryRate = scanner.nextDouble();
        scanner.nextLine(); 
        employeeManager.addEmployee(new Employee(1, name, age, department, code, salaryRate));
        System.out.println("Them nhan vien thanh cong");
    }

    private static void removeEmployee(EmployeeManager employeeManager) {
        System.out.println("Dien ID cua nhan vien can xoa");
        int idToRemove = scanner.nextInt();
        scanner.nextLine();
        employeeManager.removeEmployee(idToRemove);
        System.out.println("Xoa thanh cong!");
    }
}