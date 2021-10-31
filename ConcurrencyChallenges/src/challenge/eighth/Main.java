package challenge.eighth;

// Example of Deadlock
// Trying to acquire locks in a different order.
// To resolve we might consider if the two classes need to call each other in a circular way or see if
// over-synchronization is happening.

// What was happening
//  1. The Tutor thread calls tutor.studyTime().
//  2. The Tutor thread gets the lock for the Tutor object (because the studyTime() method is synchronized).
//  It prints "Tutor has arrived" and waits for the student, which we've simulated by calling sleep().
//  3. The Student thread runs and calls handleAssignment(). Since the method is synchronized,
//  it gets the lock for the Student object. It calls tutor.getProgressReport(),
//  but the Tutor thread is holding the lock for the tutor object, so the Student thread blocks.
//  4.The Tutor thread wakes up and runs, and calls student.startStudy().
//  But the method is synchronized, and the Student thread is holding the lock for the Student object,
//  so the Tutor thread blocks.
//  5.We have a deadlock. Neither thread will ever release the lock that the other thread is waiting for.

// What to think when encountering deadlocks
//  1. Is a set of locks being obtained in a different order by multiple threads (that's the case here)
//  If so, can we force all threads to obtain the locks in the same order?
//  2. Are we over-synchronizing the code?
//  3. Can we rewrite the code to break any circular call patterns?
//  4. Would using ReentrantLock objects help?

public class Main
{
    public static void main(String[] args)
    {
        Tutor tutor = new Tutor();
        Student student = new Student(tutor);
        tutor.setStudent(student);

        Thread tutorThread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                tutor.studyTime();
            }
        });

        Thread studentThread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                student.handInAssignment();
            }
        });

        tutorThread.start();
        studentThread.start();
    }

}

class Tutor
{
    private Student student;

    public synchronized void setStudent(Student student)
    {
        this.student = student;
    }

    public synchronized void studyTime()
    {
        System.out.println("Tutor has arrived");
        try
        {
            // wait for student to arrive and hand in assignment
            Thread.sleep(300);
        } catch (InterruptedException e)
        {

        }
        student.startStudy();
        System.out.println("Tutor is studying with student");
    }

    public synchronized void getProgressReport()
    {
        // get progress report
        System.out.println("Tutor gave progress report");
    }

}

class Student
{
    private Tutor tutor;

    Student(Tutor tutor)
    {
        this.tutor = tutor;
    }

    public synchronized void startStudy()
    {
        // study
        System.out.println("Student is studying");
    }

    public void handInAssignment()
    {
        tutor.getProgressReport();
        System.out.println("Student handed in assignment");
    }

}
