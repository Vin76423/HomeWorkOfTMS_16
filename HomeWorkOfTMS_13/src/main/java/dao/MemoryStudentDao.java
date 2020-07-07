package dao;

import entity.Student;
import exception.DuplicateStudentException;
import exception.NotStudentException;

import java.util.ArrayList;
import java.util.List;

public class MemoryStudentDao implements StudentDao {
    private List<Student> students = new ArrayList<>();
    private static MemoryStudentDao instance;

    private MemoryStudentDao() {
        students.add(new Student(5, "Сергей", 8.2, "sergey@gmail.com"));
        students.add(new Student(2,"Гена", 6.5, "genadiy@gmail.com"));
    }

    public static MemoryStudentDao getInstance() {
        if (instance == null) {
            instance = new MemoryStudentDao();
        }
        return instance;
    }

    @Override
    public void add(Student student) throws DuplicateStudentException {
        if (students.contains(student)) {
            throw new DuplicateStudentException(student.getId());
        }
        students.add(student);
    }

    @Override
    public List<Student> getList() {
        return new ArrayList<>(students);
    }

    @Override
    public void remove(Student student) {
        students.remove(student);
    }

    @Override
    public void update(Student student) {
        int index = students.indexOf(student);
        if (index != -1) {
            students.set(index, student);
        }
    }

    @Override
    public Student getStudentByName(Student student) throws NotStudentException {
        int index = students.indexOf(student);

        if (index != -1) {
            return students.get(index);
        }
        throw new NotStudentException(student.getName());
    }
}
