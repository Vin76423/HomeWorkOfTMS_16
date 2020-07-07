package entity.comparators;

import entity.Student;

import java.util.Comparator;

public class ByEmailSortAscendingComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getEmail().compareTo(o2.getEmail());
    }

    @Override
    public String toString() {
        return "По емейлу, от \"А\" до \"Z\"";
    }
}
