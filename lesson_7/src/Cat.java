public class Cat extends Animal {
    //Cat eat
    @Override
    public void eat() {
        System.out.println("");
        super.eat();
        System.out.println("Cat eat");
    }

    public void eat(String msg) {
        System.out.println("Cat eat " + msg);
    }
}
