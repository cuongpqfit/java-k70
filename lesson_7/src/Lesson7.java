public class Lesson7 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.eat();
        cat.eat(" fish");
        cat.sleep();
        cat.run();

        System.out.println("----- Dog class ----");
        Dog dog = new Dog();
        dog.eat();

        System.out.println("----- Person class ----");
        Person man = new Man();
        Person girl = new Girl();

        man.eat();
        girl.eat();

        ImpTokenService tokenService = new ImpTokenService();
        tokenService.createToken();
        tokenService.destroyToken();
        tokenService.destroyToken2();
        tokenService.showToken();


    }
}
