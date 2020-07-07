package entity.comparators;

import entity.Student;

import java.util.Comparator;

public class ByEmailSortDescendingComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o2.getEmail().compareTo(o1.getEmail());
    }

    @Override
    public String toString() {
        return "По емейлу, от \"Z\" до \"A\"";
    }
}
