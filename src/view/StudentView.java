package view;

import model.Student;
import svervice.IStudentService;
import svervice.StudentService;
import utils.AppUtils;
import utils.CSVUtils;

import java.util.List;
import java.util.Scanner;

import static svervice.StudentService.PATH;

public class StudentView {
    private final IStudentService studentService;
    private final Scanner sc = new Scanner(System.in);

    public StudentView() {
        studentService = StudentService.getInstance();
    }
    public void showStudents(InputOption inputOption) {
        List<Student> students = studentService.findAll();

        System.out.println("════════════════════════════════════════════════════════ Wine List ════════════════════════════════════════════════════════");
        System.out.printf("showStudents%-15s %-30s %-25s %-10s %-20s %-20s \n",
                "Id",
                "Student Name ",
                "Age",
                "Gender",
                "Address",
                "AverageScores");
        for (Student student : students) {
            System.out.printf("%-15s %-30s %-15s %-10s %-20s %-20s \n",
                    student.getStudentId(),
                    student.getStudentName(),
                    student.getStudentAge(),
                    student.getGender(),
                    student.getAddress(),
                    student.getAverageScores()
            );
        }
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        if (inputOption == InputOption.SHOW) {
            AppUtils.isRetry(InputOption.SHOW);
        }
    }
    public void showStudentsClone() {
        List<Student> students = studentService.findAll();

        System.out.println("════════════════════════════════════════════════════════ Wine List ════════════════════════════════════════════════════════");
        System.out.printf("showStudents%-15s %-30s %-25s %-10s %-20s %-20s \n",
                "Id",
                "Student Name ",
                "Age",
                "Gender",
                "Address",
                "AverageScores");
        for (Student student : students) {
            System.out.printf("%-15s %-30s %-25s %-10s %-20s %-20s\n",
                    student.getStudentId(),
                    student.getStudentName(),
                    student.getStudentAge(),
                    student.getGender(),
                    student.getAddress(),
                    student.getAverageScores()
            );
        }
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");

    }

    public void add() {
        do {
            int id = inputId(InputOption.ADD);
            String Name = inputName(InputOption.ADD);
            int age = inputAge(InputOption.ADD);
            String gender = inputGender(InputOption.ADD);
            String address = inputAddress(InputOption.ADD);
            double averageScores = inputAverageScores(InputOption.ADD);
            Student student = new Student(id, Name, age, gender, address,averageScores);
            studentService.add(student);
            System.out.println(" successfully added\n");
        } while (AppUtils.isRetry(InputOption.ADD));

    }
    public void update() {
        List<Student> students = studentService.findAll();
        showStudentsClone();
        System.out.print("Enter Id Edit : ");
        int id = Integer.parseInt(sc.nextLine());
        for (Student student : students) {
            try {

                if (student.getStudentId() == id) {
                    System.out.print("Edit Id : ");
                    int id1 = Integer.parseInt(sc.nextLine());
                    do {
                        if (id <= 0) {
                            System.out.println("don't let bellow");
                            System.out.print("Enter again");
                            id = Integer.parseInt(sc.nextLine());
                        }
                    } while (id <= 0);
                    student.setStudentId(id1);

                    System.out.print("Edit Name : ");
                    String Name = sc.nextLine();
                    do {
                        if (Name.trim().isEmpty()) {
                            System.out.println("don't let bellow");
                            System.out.print("Enter again  ");
                            Name = sc.nextLine();
                        }
                    } while (Name.trim().isEmpty());
                    student.setStudentName(Name);

                    System.out.print("Edit age : ");
                    int age = Integer.parseInt(sc.nextLine());
                    do {
                        if (age <= 0) {
                            System.out.println("don't let bellow");
                            System.out.print("Enter again ");
                            age = Integer.parseInt(sc.nextLine());
                        }
                    } while (age <= 0);
                    student.setStudentAge(age);

                    System.out.print("Edit gender : ");
                    String gender = sc.nextLine();
                    do {
                        if (gender.trim().isEmpty()) {
                            System.out.println("don't let bellow");
                            System.out.print("Enter again : ");
                            gender = sc.nextLine();
                        }
                    } while (gender.trim().isEmpty());
                    student.setGender(gender);

                    System.out.print("edit address : ");
                    String address = sc.nextLine();
                    do {
                        if (address.trim().isEmpty()) {
                            System.out.println("don't let bellow");
                            System.out.print("Enter again : ");
                            address = sc.nextLine();
                        }
                    } while (address.trim().isEmpty());
                    student.setAddress(address);

                    System.out.print("edit averageScores : ");
                    double averageScores = Double.parseDouble(sc.nextLine());
                    do {
                        if (averageScores <= 0) {
                            System.out.println("don't let bellow");
                            System.out.print("Enter again ");
                            averageScores = Double.parseDouble(sc.nextLine());
                        }
                    } while (averageScores <= 0);
                    student.setAverageScores(averageScores);

                    CSVUtils.writeData(PATH, students);
                    break;
                }
            } catch (Exception e) {
                System.out.println("Wrong input, please re-enter from the beginning");
                update();
            }
        }
        System.out.println("Successful change !!!!!! ");
    }
    public void remove() {
        showStudents(InputOption.DELETE);
        int id;
        while (!studentService.exist(id = inputId(InputOption.DELETE))) {
            System.out.println("No products to be deleted were found");
            System.out.println(" Press 'y' to add more \t|\t 'q' to come back \t|\t 't' to exit the program");
            System.out.print(" ⭆ ");
            String option = sc.nextLine();
            switch (option) {
                case "y":
                    break;
                case "q":
                    return;
                case "t":
                    AppUtils.exit();
                    break;
                default:
                    System.out.println("Choose the wrong function! Please choose again");
                    break;
            }
        }

        System.out.println("   ❄ ❄ ❄ ❄ REMOVE COMFIRM ❄ ❄ ❄");
        System.out.println("  ❄      1. Press 1 to delete     ❄");
        System.out.println(" ❄       2. Press 2 to go back     ❄");
        System.out.println("❄ ❄ ❄ ❄ ❄ ❄ ❄ ❄ ❄ ❄ ❄ ❄ ❄ ❄ ❄ ❄");
        int option = AppUtils.retryChoose(1, 2);
        if (option == 1) {
            studentService.deleteById(id);
            System.out.println("Remove Successfully");
            AppUtils.isRetry(InputOption.DELETE);
        }
    }
    private int inputId(InputOption option){
        switch (option) {
            case ADD:
                System.out.println("Enter ID: ");
                break;
            case UPDATE:
                System.out.println("Enter ID you want to edit: ");
                break;
        }
        System.out.print("⭆ ");
        return Integer.parseInt(sc.nextLine());
    }
    private String inputName(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Enter name: ");
                break;
            case UPDATE:
                System.out.println("Enter the name you want to edit: ");
                break;
        }
        System.out.print("⭆ ");
        return sc.nextLine();
    }
    private String inputGender(InputOption option){
        switch (option) {
            case ADD:
                System.out.println("Enter Gender: ");
                break;
            case UPDATE:
                System.out.println("Enter Gender you want to edit: ");
                break;
        }
        System.out.print("⭆ ");
        return sc.nextLine();
    }

    private int inputAge(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Enter Age: ");
                break;
            case UPDATE:
                System.out.println("Enter Age you want to edit: ");
                break;
        }
        System.out.print("⭆ ");
        return Integer.parseInt(sc.nextLine());
    }

    private String inputAddress(InputOption option){
        switch (option) {
            case ADD:
                System.out.println("Enter Address: ");
                break;
            case UPDATE:
                System.out.println("Enter Address you want to edit: ");
                break;
        }
        System.out.print("⭆ ");
        return sc.nextLine();
    }
    private double inputAverageScores(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Enter averageScores:");
                break;
            case UPDATE:
                System.out.println("Enter averageScores you want to edit: ");
                break;
        }
        System.out.print("⭆ ");
        return Double.parseDouble(sc.nextLine());
    }
    public void showProductsSort(InputOption inputOption, List<Student> students) {
        System.out.println("════════════════════════════════════════════════════════ Wine List ════════════════════════════════════════════════════════");
        System.out.printf("%-15s %-30s %-25s %-10s %-20s %-20s \n",
                "Id",
                "Student Name ",
                "Age",
                "Gender",
                "Address",
                "AverageScores");
        for (Student student : students) {
            System.out.printf("%-15s %-30s %-15s %-10s %-20s %-20s \n",
                    student.getStudentId(),
                    student.getStudentName(),
                    student.getStudentAge(),
                    student.getGender(),
                    student.getAddress(),
                    student.getAverageScores()
            );
        }
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");

        if (inputOption == InputOption.SHOW)
            AppUtils.isRetry(InputOption.SHOW);
    }
    public void sortByAverageScoresByASC() {
        showProductsSort(InputOption.SHOW, studentService.SortByAverageScoresASC());
    }

    public void sortByAverageScoresByDESC() {
        showProductsSort(InputOption.SHOW, studentService.SortByAverageScoresDXSC());
    }
}
