package tutorial;

// Covariant Return Type
// Return type can be a subclass of the return type in the parent class.
public class Burger
{
    // Fields, methods ...
}

class HealthyBurger extends Burger
{
    // Fields, methods ...
}

class BurgerFactory
{
    public Burger createBurger()
    {
        return new Burger();
    }

}

class HealthyBurgerFactory extends BurgerFactory
{
    @Override
    public HealthyBurger createBurger()
    {
        return new HealthyBurger();
    }

}
