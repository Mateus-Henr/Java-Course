package tutorial.second;

public class Main
{
    public static void main(String[] args)
    {
        Dog dog = new Dog("Yorkie");
        dog.breathe();
        dog.eat();

        Parrot parrot = new Parrot("Australian rigneck");
        parrot.breathe();
        parrot.eat();
        parrot.fly();

        Penguin penguin = new Penguin("Emperor");
        penguin.fly();
    }

    // In order to decide what's option is going to be better (abstract class or interface) we need to consider the
    // relationship as "is a", versus "has a", or "can".
    // Example:
    // Dog is an animal, bird is an animal, so it makes sense to pass common state/behaviours for them, rather than
    // implementing an interface.
    // A parrot is a bird so it makes sense the Bird be its parent.
    // There's a problem with the example "BIRDS ARE NOT THE ONLY ANIMAL THAT CAN FLY". (So the fly() methods is not good.)
    // A bird can fly and a bat can fly, therefore to common behaviours such as this, the better option would be an
    // interface for "flying".

}
