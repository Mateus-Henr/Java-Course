package tutorial.first;


// When debugging a socket is opened because the debugger attaches to the app and communicates to the app using that
// socket. So if we want to analise what's happening inside the app we need to stop the app at some point to analise
// its state (use a breakpoint for it).
// Also, for debugging it's really important to have access to the source code (if we want to see what's happening
// inside a class or method)
// To use the debugger with a class, the compiled class files must contain debug information (normally third parties
// class don't contain debug information).
// When using debugger, our app will run slower than it usually does since it has extra processing.
// For threading issues it can be challenging.
public class Main
{
    public static void main(String[] args)
    {
        StringUtilities utils = new StringUtilities();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 10)
        {
            utils.addChar(sb, 'a');
        }

        System.out.println(sb);
    }

}

// Debug Sections
// Frames = Shows the execution stack trace, so each time a method is called a frame is added to the stacktrace. The
// first method call is at the bottom and the top method will be what's currently being executed.
// The dropdown in this section shows the threads that are being executed.
// Variables
// It varies depending on the frame that you've got selected, here it's shown the variables that are related to the
// frame, variables that have been declared before that point.
// To see variables for a specific class you can expand the "this" variable dropdown that will show the field instances
// for that specific class.
// When dealing with objects you can expand them to see more info about them (their current fields and properties).
// Normally when a variable is used in the current suspended method it's shown twice, in the "this" part and in the
// variables main panel (for convenience).

// Debug Controls
// They are used to control the flow of execution of the program.
// Show Executing Point = Returns the editor where the code was suspended.
// Step Over = It will advance the execution point by one statement, and it won't show us any methods called by that
// statement.
// Step Into = It'll step into any methods called by the next statement. When trying to step into JDK methods the
// debugger won't suspend because they assume that developers aren't interested in seeing what's happening there,
// sometimes it also happens with third party libraries.
// Force Step Into = Used if you want to step into any methods, even JDK and third parties methods.
// Step Out = When you want the debugger to run the rest of the method, to return to the caller and then suspend.
// Drop Frame = Allows us to rewind the app by one frame (it might return to the previous method or the previous
// statement). We can't rewind network and database traffic and changes to static instance variables. Only local
// variables will be reverted, some developers use it to test different code paths without having to restart the app.
// But it's very rarely used.
// Run To Cursor = The app will suspend on where the cursor is located.
// Resume = In case of you not wanting to kill the app by pressing the "stop" button you can use this to resume the
// app. Can be useful if your app has some sort of cleanup method, database connection, network interaction that is
// necessary to end properly, it runs to its completion.
// View Breakpoints = To view all your breakpoints.

// Watchers (variables with a glasses icon)
// They are a feature of IntelliJ debugger, they appear on the Variables Pane and are updated as the app runs.
// It's a convenient way to see variables, when working with many variables we can set them as watches.
// When it's in blue it means that it has been updated.
// You can open the watches panel by clicking on "Show Watches" and it'll show watches added by you.
// A Field Watchpoint is a type of breakpoint, which is different from watches, it's used when we want to monitor
// what's altering the variable, so whenever the value of the variable is updated or accessed the app is suspended.
// You can set a Field Watchpoint by clicking "Alt" + left-click on the side of the code.
// Also, by using the right-click on the field watchpoint you can configure it, like setting conditions, defining when
// it should stop, etc.
// You can use "Remove Once Hit" to only stop the program execution once.