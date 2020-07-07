package controllers;

import dao.StudentDao;
import dao.SerializableStudentDao;
import entity.Student;
import exception.DuplicateStudentException;
import exception.NotStudentException;
import services.CreateReportService;
import services.MailService;
import services.XMLExportStudentsOperationService;
import services.XMLImportStudentsOperationService;

import java.util.*;

public class StudentController {
    private StudentDao studentDao = new SerializableStudentDao();  //MemoryProductDao.getInstance()

    public void add(Student student) throws DuplicateStudentException {
        // повезло на зачете + 1 бал.
        if (student.getName().startsWith("С"))
            student.setAverageMark(student.getAverageMark() + 1);

        studentDao.add(student);
    }



    public List<Student> getList() {
        return studentDao.getList();
    }

    public List<Student> getSortedList(Comparator<Student> comparator) {
        List<Student> students = getList();
        students.sort(comparator);
        return students;
    }

    public List<Student> getSubList(double lowerLimit, double upperLimit) {
        NavigableSet<Student> students = new TreeSet<>(getList());
        return new ArrayList<>(students.subSet(new Student(lowerLimit),true,
                new Student(upperLimit), true));
    }



    public void remove(int id) { studentDao.remove(new Student(id)); }

    public void update(Student student) { studentDao.update(student); }

    public Student getStudentByName(String name) throws NotStudentException {
        return studentDao.getStudentByName(new Student(name));
    }

    public void sendMailsAboutStudentsSuccess() {
        Thread thread = new Thread(new MailService(getList()));
        thread.start();
    }

    public void exportStudentsByXML(String path) {
        Thread thread = new Thread(new XMLExportStudentsOperationService(getList(), path));
        thread.start();
    }

    public void createReport() {
        new Thread(new CreateReportService(getList())).start();
    }
}
