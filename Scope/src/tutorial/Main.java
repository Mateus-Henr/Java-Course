package tutorial;

// Scope is the visibility of a class, variable or member.
public class Main
{
    public static void main(String[] args)
    {
        String varFour = "This is private to main()";

        ScopeCheck scopeInstance = new ScopeCheck();
        scopeInstance.useInner();

//        // It can't find the variable here, because it's private.
          // So it has no visibility outside of its class.
//        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
//        System.out.println("varThree is not accessible here " + innerClass.varThree);

        System.out.println("scopeInstance varOne is " + scopeInstance.getVarOne());
        System.out.println(varFour);

        scopeInstance.timesTwo();
        System.out.println("**********************************************");
        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
        innerClass.timesTwo();
    }

}

// In Java, an object's visibility (connected to scope) is governed by the access modifiers.
