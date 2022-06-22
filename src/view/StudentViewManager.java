package view;

import utils.AppUtils;

import java.util.Scanner;

public class StudentViewManager {

    public static void menuMain() {
        StudentView studentView = new StudentView();
        Scanner sc = new Scanner(System.in);
        System.out.print("╔══════════════════════════════════════════════════════════════════════════════════════════════════╗" +
                "\n║                                                                                                  ║" +
                "\n║                                    Student Managent                                              ║" +
                "\n║                                      [Main Menu]                                                 ║" +
                "\n║                                                                                                  ║" +
                "\n║                            ■  [1]  Show List Student                                             ║" +
                "\n║                            ■  [2]  Add Student                                                   ║" +
                "\n║                            ■  [3]  Update Student                                                ║" +
                "\n║                            ■  [4]  Remove Student                                                ║" +
                "\n║                            ■  [5]  Sort Student                                                  ║" +
                "\n║                            ■  [0]    Exit                                                        ║" +
                "\n║                                                                                                  ║" +
                "\n╚══════════════════════════════════════════════════════════════════════════════════════════════════╝" +
                "\n■ Type a number above by your choice: ");
        int choice = -1;
        while (choice != 0) {
            try {
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Show List");
                        studentView.showStudents(InputOption.SHOW);
                        menuMain();
                        break;
                    case 2:
                        System.out.println("Add Student");
                        studentView.add();
                        break;
                    case 3:
                        System.out.println("Update Student");
                        studentView.update();

                        break;
                    case 4:
                        System.out.println("Remove Student");
                        studentView.remove();
                        break;
                    case 5:
                        System.out.println("Sort Student");
                        runSort();
                    case 0:
                        AppUtils.exit();
                    default:
                        System.out.println("Wrong Input! Please enter a number !!! ");
                        menuMain();
                }
            } catch (Exception e) {
                System.err.println("Wrong input. Try again.");
            }
        }
    }

    public static void menuSort() {
        System.out.print("╔══════════════════════════════════════════════════════════════════════════════════════════════════╗" +
                "\n║                                                                                                  ║" +
                "\n║                                          [Menu Sort]                                             ║" +
                "\n║                                                                                                  ║" +
                "\n║                               ■  [1]      Sort Ascending By AverageScores                        ║" +
                "\n║                               ■  [2]      Sort Descending By AverageScores                       ║" +
                "\n║                               ■  [3]      Come Back                                              ║" +
                "\n║                               ■  [0]      Exit                                                   ║" +
                "\n║                                                                                                  ║" +
                "\n╚══════════════════════════════════════════════════════════════════════════════════════════════════╝" +
                "\n")
        ;
    }

    public static void runSort() {
        Scanner sc = new Scanner(System.in);
        StudentView studentView = new StudentView();
        do {
            menuSort();
            try {
                System.out.println("Enter your choice : ");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Sort Ascending By AverageScores");
                        studentView.sortByAverageScoresByASC();
                        break;
                    case 2:
                        System.out.println("Sort Descending By AverageScores");
                        studentView.sortByAverageScoresByDESC();
                        break;
                    case 3:
                        System.out.println("Come back");
                        menuMain();
                    case 0:
                        AppUtils.exit();
                        break;
                    default:
                        System.out.println("Wrong choice ! Try again !!!");
                        runSort();
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Wrong input ! Try again !!!");
                runSort();
            }
        } while (true);
    }

}
