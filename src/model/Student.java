package model;

public class Student {
    private int StudentId;
    private String studentName;
    private int studentAge;
    private String gender;
    private String address;
    private double averageScores;

    public Student() {

    }

    public Student(int studentId, String studentName, int studentAge, String gender, String address, double averageScores) {
        StudentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.gender = gender;
        this.address = address;
        this.averageScores = averageScores;
    }

    public static Student parse(String row) {
        String[] fields = row.split(",");
        int StudentId = Integer.parseInt(fields[0]);
        String studentName = fields[1];
        int studentAge = Integer.parseInt(fields[2]);
        String gender = fields[3];
        String address = fields[4];
        double averageScores = Double.parseDouble(fields[5]);
        return new Student(StudentId, studentName, studentAge, gender, address, averageScores);
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAverageScores() {
        return averageScores;
    }

    public void setAverageScores(double averageScores) {
        this.averageScores = averageScores;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,",
                StudentId,
                studentName,
                studentAge,
                gender,
                address,
                averageScores);

    }
}
