package dao;

import entity.Student;
import exception.DuplicateStudentException;
import exception.NotStudentException;

import java.io.*;
import java.util.*;

public class SerializableStudentDao implements StudentDao {
    public static final String PATH = "storage.bin";

    @Override
    public synchronized void add(Student student) throws DuplicateStudentException {
        List<Student> students = getList();
        if (students.contains(student))
            throw new  DuplicateStudentException(student.getId());

        students.add(student);
        save(students);
    }

    @Override
    public synchronized List<Student> getList() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new  FileInputStream(PATH))) {
            return  (List<Student>) objectInputStream.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void remove(Student student) {
        List<Student> students = getList();
        students.remove(student);
        save(students);
    }

    @Override
    public void update(Student student) {
        List<Student> students = getList();
        int index = students.indexOf(student);

        if (index != -1)
            students.set(index, student);
        save(students);
    }

    @Override
    public Student getStudentByName(Student student) throws NotStudentException {
        List<Student> students = getList();
        int index = students.indexOf(student);

        if (index != -1)
            return students.get(index);

        throw new NotStudentException(student.getName());
    }






    private void save(List<Student> students) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(PATH))) {
            objectOutputStream.writeObject(students);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
