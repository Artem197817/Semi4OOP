import java.util.ArrayList;
import java.util.List;

public class Main {

        /**
         * Реализовать класс Box c возможностями:
         * 1. Класс должен быть параметризуемым любым фруктом. То есть Box<String> - запрещено.
         * 2. Должен быть метод add, принимающий конкретный фрукт (тот тип фрукта, который содержится в коробке)
         * 2. У класса реализован метод getWeight - возвращает сумму всех фруктов.
         * 3. Метод moveTo пересыпает содержимое текущей коробки в другую.
         */

        public static void main(String[] args) {
            //Box<String> stringBox = new Box(); // недопустимо
            Box<Orange> orangeBox = new Box<>();
            Box<Apple> appleBox = new Box<>();
            Box<GoldenApple> goldenAppleBox = new Box<>();

            orangeBox.add(new Orange(1));
           // orangeBox.add(new Apple(1));  // недопустимо
           // orangeBox.add(new GoldenApple(1));  // недопустимо
            System.out.println(orangeBox.getWeight()); // 1

            appleBox.add(new Apple(1));
            appleBox.add(new GoldenApple(1));
            System.out.println(appleBox.getWeight()); // 2

            //goldenAppleBox.add(new Apple(1)); // недопустимо
            goldenAppleBox.add(new GoldenApple(1));

            Box<Orange> anotherOrangeBox = new Box();
            orangeBox.moveTo(anotherOrangeBox);
            //orangeBox.moveTo(appleBox); // недопустимо
            System.out.println(anotherOrangeBox.getWeight()); // 1
            System.out.println(orangeBox.getWeight()); // 0

            //appleBox.moveTo(goldenAppleBox); // недопустимо
            goldenAppleBox.moveTo(appleBox);
            System.out.println(goldenAppleBox.getWeight()); // 0

            System.out.println(appleBox.getWeight()); // 3
        }

        // TODO: Добавить дженерик
        static class Box <T extends Fruit>{
            public List<T> box = new ArrayList<>();
            public int weightBox;
            public void add(T fruit){
                box.add(fruit);
                weightBox += fruit.getWeight();
            }
            public int getWeight() {
                return weightBox;
            }
            public  void moveTo(Box<? super T> another) {
                for (T fruit : box) {
                   another.add(fruit);
                }
               box.clear();
               weightBox = 0;
            }

        }

        static class Fruit {
            private final int weight;

            public Fruit(int weight) {
                this.weight = weight;
            }

            public int getWeight() {
                return weight;
            }
        }

        static class Orange extends Fruit {
            public Orange(int weight) {
                super(weight);
            }
        }

        static class Apple extends Fruit {
            public Apple(int weight) {
                super(weight);
            }
        }

        static class GoldenApple extends Apple {
            public GoldenApple(int weight) {
                super(weight);
            }
        }}



