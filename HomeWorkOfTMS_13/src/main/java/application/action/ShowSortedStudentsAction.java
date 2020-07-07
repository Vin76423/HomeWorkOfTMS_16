package application.action;

import application.config.ConfigSorts;
import application.utils.Input;
import entity.Student;
import java.util.Comparator;
import java.util.Map;

public class ShowSortedStudentsAction extends BaseAction implements Action{

    @Override
    public String getName() {
        return "Вывод всех студентов в отсортированом виде";
    }

    @Override
    public void action() {
        showList(studentController.getSortedList(getComparator()));
    }



    private void showSortsCase() {
        for (Map.Entry<Integer, Comparator<Student>> sort : ConfigSorts.sorts.entrySet())
            System.out.println(sort.getKey() + " - " + sort.getValue());
    }

    private Comparator<Student> getComparator() {
        showSortsCase();
        int index = Input.getInt("Выберите вариант сортировки");
        Comparator<Student> comparator = ConfigSorts.sorts.get(index);

        if (comparator != null) return comparator;

        System.out.println("Нет такого варианта. Повторите ввод.");
        return getComparator();
    }
}
