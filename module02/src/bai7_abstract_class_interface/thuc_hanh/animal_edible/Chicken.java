package bai7_abstract_class_interface.thuc_hanh.animal_edible;

public class Chicken extends Animal implements Edible{
    @Override
    public String makeSound() {
        return "Chicken: Quaack quackk??";
    }

    @Override
    public String howToEat() {
        return "Can be boil";
    }
}
