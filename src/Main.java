import java.util.Arrays;


public class Main {

    public static void main(final String[] args) {
        // write your code here
        MyCollection<Integer> colInt = new MyCollection<>();

        for (int i = 0; i < 5; i++) {
            System.out.println("добавляем " + i + " - " + colInt.add(i));
        }
        System.out.println("Коллекция до изменений - " + Arrays.toString(colInt.toArray()));

        System.out.println("Удаляем 3 - " + colInt.remove(3));
        System.out.println("Удаляем 10 - " + colInt.remove(10));

        MyCollection<Integer> colForDel = new MyCollection<>();
        colForDel.add(2);
        colForDel.add(4);
        colForDel.add(10);
        System.out.println("Содержит " + Arrays.toString(colForDel.toArray()) + " - " + colInt.containsAll(colForDel));

        colForDel.remove(10);
        System.out.println("Содержит " + Arrays.toString(colForDel.toArray()) + " - " + colInt.containsAll(colForDel));

        System.out.println("удаляем " + Arrays.toString(colForDel.toArray()) + " - " + colInt.removeAll(colForDel));

        System.out.println("Содержит 1 - " + colInt.contains(1));
        System.out.println("Содержит 2 - " + colInt.contains(2));
        System.out.println("Содержит 4 - " + colInt.contains(4));


        System.out.println("добавляем " + Arrays.toString(colForDel.toArray()));
        colInt.addAll(colForDel);

        System.out.println("Оставляем только " + Arrays.toString(colForDel.toArray()) + " - "
                + colInt.retainAll(colForDel));

        System.out.println("Результат - " + Arrays.toString(colInt.toArray()));

        System.out.println("Очищаем коллекцию");
        colInt.clear();
        System.out.println("Результат - " + Arrays.toString(colInt.toArray()));


    }
}
