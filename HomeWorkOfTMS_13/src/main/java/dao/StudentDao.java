package dao;

import entity.Student;
import exception.DuplicateStudentException;
import exception.NotStudentException;

import java.util.List;

public interface StudentDao {
    void add(Student student) throws DuplicateStudentException;
    List<Student> getList();
    void remove(Student student);
    void update(Student student);
    Student getStudentByName(Student student) throws NotStudentException;
}
