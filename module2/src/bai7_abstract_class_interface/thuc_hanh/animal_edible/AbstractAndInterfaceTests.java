package bai7_abstract_class_interface.thuc_hanh.animal_edible;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal ani : animals) {
            System.out.println(ani.makeSound());
            if (ani instanceof Chicken) {
                Edible edible = (Chicken) ani;
                System.out.println(edible.howToEat());
            }
        }

        Fruit[] fruit = new Fruit[2];
        fruit[0] = new Apple();
        fruit[1] = new Orange();
        for (Fruit fru : fruit) {
            System.out.println(fru.howToEat());
        }
    }
}
