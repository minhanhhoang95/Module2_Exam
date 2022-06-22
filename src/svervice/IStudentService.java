package svervice;

import model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    void add(Student newProduct);

    void update(Student newProduct);

    Student findById(int id);

    boolean exist(int id);

    boolean existByName(String name);

    boolean existsById(int id);

    void deleteById(int id);

    List<Student> SortByAverageScoresASC();

    List<Student> SortByAverageScoresDXSC();
}
