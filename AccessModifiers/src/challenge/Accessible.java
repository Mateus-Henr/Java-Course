package challenge;

// Challenge:
// In the following interface declaration, what is the visibility of:
//
// 1. The "Accessible" interface?
// It's package-private, it can only be accessed within the same package.
//
// 2. The int variable "SOME_CONSTANT"?
// It's public, because all interfaces variables are public static final.
//
// 3. The "methodA"?
// It's a public method, it's visible everywhere, even outside its package.
//
// 4. The "methodB" and "methodC"?
// They're public methods, because all interfaces methods are automatically public.
//

// MEANING THAT in interfaces we don't any access modifier, everything will be public.
// And the point for declaring a interface is to provide method that have to be implemented.
// Therefore they cannot be private, etc.
// We can just make the interface package-private by not putting "public" when defining it.

interface Accessible
{
    int SOME_CONSTANT = 100;

    public void methodA();

    void methodB();

    boolean methodC();

}
