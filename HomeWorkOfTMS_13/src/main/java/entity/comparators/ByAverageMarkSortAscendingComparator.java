package entity.comparators;

import entity.Student;

import java.util.Comparator;

public class ByAverageMarkSortAscendingComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return (int) ((o1.getAverageMark() - o2.getAverageMark()) * 100);
    }

    @Override
    public String toString() {
        return "По среднему балу за симестр, по возрастанию";
    }
}
