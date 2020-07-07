package entity.comparators;

import entity.Student;

import java.util.Comparator;

public class ByNameSortAscendingComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }

    @Override
    public String toString() {
        return "По имени, от \"А\" до \"Я\"";
    }
}
