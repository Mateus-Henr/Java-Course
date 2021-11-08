package tutorial.third;

public class Main
{
    public static void main(String[] args)
    {

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);

        anotherClass.printValue();
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2)
    {
        return uc.upperAndConcat(s1, s2);
    }

}

interface UpperConcat
{
    String upperAndConcat(String s1, String s2);

}

class AnotherClass
{
    public String doSomething()
    {
        // Version without using lambda
//        System.out.println("The Another class's name is: " + getClass().getSimpleName());
//        return Main.doStringStuff(new UpperConcat()
//        {
//            @Override
//            public String upperAndConcat(String s1, String s2)
//            {
//                // Anonymous class doesn't have a name.
//                System.out.println("The anonymous class's is: " + getClass().getSimpleName());
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, "String1", "String2");

        // NESTED BLOCK
        // By putting the code inside a nested block all me mean is that we've enclosed it with another set of curly
        // braces. Code within a nested block can reference variables defined within the enclosing block.
        //  In other words, variables defined in this method "doSomething" can be used in the nested block.
        // To define local variables in the nested block just define it within the enclosing block.
//        final int i = 0; // Variable that cna be accessed in the nested block;
//        {
//            // Anonymous class
//            // If we want to reference a variable defined outside the anonymous class we have to declare it as final.
//            // It needs to be defined as final because the local variable doesn't belong to the anonymous class
//            // instance.
//            // What happens is that the variable is replaced by the value of "i" is when the instance is constructed.
//            // So if we modify the value of the variable anywhere else and as we assign an anonymous class to a
//            // variable and use it later, the value of the variable inside the anonymous class would be out of sync
//            // with the value of the "actual" variable.
//            UpperConcat uc = new UpperConcat()
//            {
//                @Override
//                public String upperAndConcat(String s1, String s2)
//                {
//                    // In order to print the variable here, it has to be defined as final, since this is an anonymous
//                    // class.
//                    System.out.println("i (within anonymous class) = " + i);
//                    return s1.toUpperCase() + s2.toUpperCase();
//                }
//            };
//            System.out.println("The Another class's name is: " + getClass().getSimpleName());
////            i++;
//            System.out.println("i = " + i);
//            return Main.doStringStuff(uc, "String1", "String2");
//        }

        int i = 0;
//        i++;
        // Version using lambda
        UpperConcat uc = (s1, s2) ->
        {
            // A lambda is not treated as an anonymous class, it's treated as a nested block of code and the scope
            // is a nested block, it can also access variables outside its scope. HOWEVER, even though when using
            // lambda it doesn't require the variable to be final, it still cannot be changed.
            System.out.println("The lambda expression's class is: " + getClass().getSimpleName());
            System.out.println("i in the lambda expression is " + i);
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result; // As we have more than one statement we need the "return" keyword.
        };
        // The parameter variables of the lambda also cannot be used outside the lambda's scope, similarly to the
        // nested block scope.
        // Representation of the lambda using a nested block
//        int j = 0;
//        {
//            String s1, s2; // Values given as parameters.
//            System.out.println("The lambda expression's class is: " + getClass().getSimpleName());
//            System.out.println("i in the lambda expression is " + j);
//            String result = s1.toUpperCase() + s2.toUpperCase();
//        }

        System.out.println("The Another class's name is: " + getClass().getSimpleName());
        return Main.doStringStuff(uc, "String1", "String2");
    }


    public void printValue()
    {
        int number = 25;

        // Using a lambda for the "Runnable".
        Runnable r = () ->
        {
            try
            {
                Thread.sleep(5000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            System.out.println("The value is " + number);
        };

        // What we are doing here is putting a thread to run that will only execute the "println()" after the method
        // has already finished executing, this way the variable "number" will no longer exist, so what's going to
        // be printed?
        // The answer is still 25, even though the variable no longer exists, it has already been set by the lambda,
        // when the lambda is creating its instance.

        // BECAUSE LAMBDAS MAY NOT BE IMMEDIATELY EVALUATED ANY VARIABLES USED WITHIN THE LAMBDA MUST BE FINAL.
        // but remember that we can still change variables defined within the lambda, because those variables are
        // defined within the lambda scope and can't be changed outside the lambda.

        new Thread(r).start();
    }

}