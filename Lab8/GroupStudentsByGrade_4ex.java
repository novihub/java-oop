package Lab8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupStudentsByGrade_4ex {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 10),
                new Student("Bob", 9),
                new Student("Charlie", 10),
                new Student("Dave", 9),
                new Student("Eve", 8));

        Map<Integer, List<Student>> groupedByGrade = students.stream()
                .collect(Collectors.groupingBy(student -> student.grade));

        groupedByGrade.forEach((grade, studentList) -> {
            System.out.println("Grade " + grade + ": " + studentList);
        });
    }
}

class Student {
    String name;
    int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return name;
    }
}
