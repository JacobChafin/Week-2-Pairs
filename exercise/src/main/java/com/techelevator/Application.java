package com.techelevator;

import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

List<Department> departments = new ArrayList<Department>();
List<Employee> employees = new ArrayList<>();
Map<String, Project> projects = new HashMap<String, Project>();

    /**
     * The main entry point in the application
     * @param args
     */
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        // create some departments
        createDepartments();

        // print each department by name
        printDepartments();

        // create employees
        createEmployees();

        // give Angie a 10% raise, she is doing a great job!

        // print all employees
        printEmployees();

        // create the TEams project
        createTeamsProject();
        // create the Marketing Landing Page Project
        createLandingPageProject();

        // print each project name and the total number of employees on the project
        printProjectsReport();
    }

    /**
     * Create departments and add them to the collection of departments
     */
    private void createDepartments() {
        Department Marketing = new Department(1, "Marketing");
        Department Sales = new Department(2, "Sales");
        Department Engineering = new Department(3, "Engineering");
        departments.add(Marketing);
        departments.add(Sales);
        departments.add(Engineering);

    }

    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");
        for (Department department : departments) {
            System.out.println(department.getName());
        }
    }

    /**
     * Create employees and add them to the collection of employees
     */
    private void createEmployees() {
        Employee Dean_Johnson = new Employee();
        Dean_Johnson.setEmployeeId(1);
        Dean_Johnson.setFirstName("Dean");
        Dean_Johnson.setLastName("Johnson");
        Dean_Johnson.setEmail("djohnson@teams.com");
        Dean_Johnson.setSalary(60000);
        Dean_Johnson.setDepartment(departments.get(2));
        Dean_Johnson.setHiredDate("08/21/2020");
        Employee Angie_Smith = new Employee(2, "Angie", "Smith", "asmith@teams.com", departments.get(2), "08/21/2020");
        Angie_Smith.setSalary(60000);
        Angie_Smith.raiseSalary(10);
        Employee Margaret_Thompson = new Employee(3, "Margaret", "Thompson", "mthompson@teams.com", departments.get(0), "08/21/2020");
        Margaret_Thompson.setSalary(60000);
        employees.add(Dean_Johnson);
        employees.add(Angie_Smith);
        employees.add(Margaret_Thompson);
    }

    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {
        System.out.println("\n------------- EMPLOYEES ------------------------------");
        for (Employee employee :employees) {
            System.out.println(employee.getFullName(employee.getFirstName(), employee.getLastName()) + " (" + employee.getSalary() +") "+ employee.getDepartment().getName());
        }

    }

    /**
     * Create the 'TEams' project.
     */
    private void createTeamsProject() {
        Project TEams = new Project("TEams", "Project Management Software", "10/10/2020", "11/10/2020");
        for (Employee employee : employees) {
            if (employee.getDepartment().getName().equals("Engineering")) {
                TEams.setTeamMembers(employee);
            }
        }

        projects.put("TEams", TEams);



    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {
        Project Marketing_Landing_Page_Project = new Project("Marketing Landing Page", "Lead Capture Landing Page for Marketing", "10/10/2020", "10/17/2020");
        for (Employee employee : employees) {
            if (employee.getDepartment().getName().equals("Marketing")) {
                Marketing_Landing_Page_Project.setTeamMembers(employee);
            }
        }

        projects.put("Marketing Landing Page", Marketing_Landing_Page_Project);

    }

    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");
        for (Map.Entry<String, Project> project : projects.entrySet()) {
            System.out.println(project.getKey() +": " + (project.getValue().teamMembers.size()));
            // need list (teamMembers?) length of list with employees (by using project somewhere) to see how many
        }
    }
}
