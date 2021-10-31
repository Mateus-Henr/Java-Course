package tutorial;

public class ScopeCheck
{
    // Access modifiers
    public int publicVar = 0;
    private int varOne = 1; // This var has the entire class scope.

    public ScopeCheck()
    {
        System.out.println("Scope created, publicVar = " + publicVar + ": varOne = " + varOne);
    }

    public int getVarOne()
    {
        return varOne;
    }

    public void timesTwo()
    {
        int varTwo = 2; // This var has this method scope.

        for (int i = 0; i < 10; i++)
        {
            // Referring to the variable within the local scope.
            // When variables have the same name the rules of scope ensure that the variable with the narrow
            /// scope is going to be used.
            // When Java sees a variable, it starts by checking the current block of code to see if the variable is
            // declared there. Otherwise it'll see if the variable is declared outside of the current block scope.
            // By using the "this" keyword you can access the more outside of the scope variable.
            System.out.println(i + " times two is " + i * varTwo);
        }
//        System.out.println("Value of i is now " + i); // i is limited to the for loop scope.

    }

    public void useInner()
    {
        InnerClass innerClass = new InnerClass();
        System.out.println("varThree from outer class: " + innerClass.varThree);
    }

    // An inner class has access to all of the fields of its main class.
    // The same goes for the main class, it can access the private variables of the inner class.
    public class InnerClass
    {
        private int varThree = 3;

        public InnerClass()
        {
            System.out.println("InnerClass created, varOne is " + varOne + " and varThree is " + varThree);
        }

        public void timesTwo()
        {
            System.out.println("varOne is still available here " + varOne);
            for (int i = 0; i < 10; i++)
            {
//                ScopeCheck.this.timesTwo();
                // If we use "this" here it'll look for the variable in the InnerClass.
                // Like: ScopeCheck.this.varOne (Get the main class var)
                System.out.println(i + " times two is " + i * varThree);
            }
        }

    }

}
