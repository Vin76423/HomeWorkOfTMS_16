package entity.comparators;

import entity.Student;

import java.util.Comparator;

public class ByAverageMarkSortDescendingComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return (int) ((o2.getAverageMark() - o1.getAverageMark()) * 100);
    }

    @Override
    public String toString() {
        return "По среднему балу, по убыванию";
    }
}


