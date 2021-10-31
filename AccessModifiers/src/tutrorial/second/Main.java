package tutrorial.second;

// Access control is granted by the top level or at the member level.
// Top level - Interfaces public or package private. (You can't define a top level as private)
public class Main
{
    public static void main(String[] args)
    {
        Account timsAccount = new Account("Tim");
        timsAccount.deposit(1000);
        timsAccount.withdraw(500);
        timsAccount.withdraw(-200);
        timsAccount.deposit(-20);
        timsAccount.calculateBalance();

//        timsAccount.balance = 5000;

        System.out.println("Balance on account is " + timsAccount.getBalance());

//        timsAccount.transactions.add(4500); // Now it's private
        timsAccount.calculateBalance();
    }

}

// Top Level
// At the Top Level, only classes, interfaces and enums can exist, everything else must be included within
// one of these.

// public
// - The object is visible to all classes everywhere, whether they are in the same package or have imported the
//   imported package containing the public class.
// Ex:s "public class X" and "public interface do".

// Package-private
// - The object is only available within its own package (and is visible to every class within the same package).
// - Package-private is specified by not specifying, it's the default if you do not specify public.
// - There no "package-private" keyword.
// Exs: "class X" and "interface x".



// Member Level

// public
// - A public member (or field) and public method can be accessed from any other class anywhere, even in a
//   different package.
// Ex: "public int x".

// Package-private
// - A object with no access modifier is visible to every class within the same package (but not to classes
//   in external packages).
// Ex: "int x".

// private
// - The object is only visible within the class it is declared. It is not visible anywhere else (including in
//   subclasses of its class).
// Ex: "private int x".

// protected
// - The object is visible anywhere in its own package (like package-private) but also in subclasses even if they
//   are in another package.
// Ex: "protected int x".
