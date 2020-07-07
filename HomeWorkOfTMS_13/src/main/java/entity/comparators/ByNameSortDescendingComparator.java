package entity.comparators;

import entity.Student;

import java.util.Comparator;

public class ByNameSortDescendingComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o2.getName().compareTo(o1.getName());
    }

    @Override
    public String toString() {
        return "По имени, от \"Я\" до \"А\"";
    }
}
