package svervice;

import model.Student;
import utils.CSVUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class StudentService implements IStudentService {
    public final static String PATH = "D:\\Exam\\Module2_Exam\\data\\students.csv";
    Scanner sc = new Scanner(System.in);

    private static StudentService instance;

    private StudentService() {

    }

    public static StudentService getInstance() {
        if (instance == null)
            instance = new StudentService();
        return instance;
    }
    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        List<String> records = CSVUtils.readData(PATH);
        for (String record : records) {
            students.add(Student.parse(record));
        }
        return students;
    }

    @Override
    public void add(Student newStudent) {
        List<Student> students = findAll();
        ;
        students.add(newStudent);
        CSVUtils.writeData(PATH, students);
    }

    @Override
    public void update(Student newStudent) {
        List<Student> students = findAll();
        for (Student student : students) {
            if (student.getStudentId() == newStudent.getStudentId()) {
                String Name = newStudent.getStudentName();
                if (Name != null && !Name.isEmpty()) {
                    student.setStudentName(Name);
                }
                int age = newStudent.getStudentAge();
                if (age != 0) {
                    student.setStudentAge(age);

                }
                String gender = newStudent.getGender();
                if (gender != null) {
                    student.setGender(gender);
                }
                String address = newStudent.getAddress();
                if (address != null) {
                    student.setAddress(address);
                }
                double averageScores = newStudent.getAverageScores();
                if (averageScores != 0) {
                    student.setAverageScores(averageScores);
                }
                break;
            }
        }
    }

    @Override
    public Student findById(int id) {
        List<Student> students = findAll();
        for (Student student : students) {
            if (student.getStudentId()==id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public boolean exist(int id) {
        return findById(id) != null;
    }

    @Override
    public boolean existByName(String name) {
        List<Student> students = findAll();
        for (Student student : students) {
            if (student.getStudentName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existsById(int id) {
        List<Student> students = findAll();
        for (Student student : students) {
            if (student.getStudentId()==id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteById(int id) {
        List<Student> students = findAll();
       students.removeIf(new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getStudentId()==id;
            }
        });
        CSVUtils.writeData(PATH, students);
    }

    @Override
    public List<Student> SortByAverageScoresASC() {
        List<Student> students = new ArrayList<>(findAll());
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                double result = o1.getAverageScores() - o2.getAverageScores();
                if (result == 0)
                    return 0;
                return result > 0 ? 1 : -1;
            }
        });

        return students;
    }

    @Override
    public List<Student> SortByAverageScoresDXSC() {
        List<Student> students = new ArrayList<>(findAll());
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                double result = o2.getAverageScores() - o1.getAverageScores();
                if (result == 0)
                    return 0;
                return result > 0 ? 1 : -1;
            }
        });

        return students;
    }
}
