package services;

import dao.SerializableStudentDao;
import dao.StudentDao;
import entity.Student;
import exception.DuplicateStudentException;

public class XMLImportStudentsOperationService extends XMLOperationService {
    private StudentDao studentDao = new SerializableStudentDao();

    public XMLImportStudentsOperationService(String path) {
        super(path);
    }

    @Override
    public void run() {
        for (Student student : importStudentsByXML()) {
            try {
                studentDao.add(student);
                Thread.sleep(2000);
            } catch (DuplicateStudentException | InterruptedException e) {
                continue;
            }
        }
    }
}
