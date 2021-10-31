package challenge.ninth;

// Another example of Deadlock

// What's happening
//  1. The tutor thread calls the tutor.studyTime() method. It acquires the Tutor lock, and then the Student lock.
//  2. The tutor thread reaches the this.wait() line of code. When it executes wait(), it releases the tutor lock.
//  Recall that the wait() and notifyAll() methods must be called from within synchronized blocks.
//  To call wait() on an object, a thread must be holding the object's lock. When it calls wait(), it releases the lock.
//  3. The student thread runs the handleAssignment() method. It gets the tutor lock and calls getProgressReport().
//  It then tries to get the student lock, but the tutor thread is still holding it.
//  Because of that, the student thread can't notify the tutor thread, so a deadlock happens.
public class Main
{
    public static void main(String[] args)
    {
        final NewTutor tutor = new NewTutor();
        final NewStudent student = new NewStudent(tutor);
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

class NewTutor
{
    private NewStudent student;

    public void setStudent(NewStudent student)
    {
        this.student = student;
    }

    public void studyTime()
    {
        synchronized (this)
        {
            System.out.println("Tutor has arrived");
            synchronized (student)
            {
//                try
//                {
//                    // wait for student to arrive
//                    wait(); // Releases the lock (before leaving the synchronized block) until it's notified.
//                    // This premature release can lead to problems. Here it liberates the "tutor" lock.
//                } catch (InterruptedException e)
//                {
//
//                }

                student.startStudy();
                System.out.println("Tutor is studying with student");
            }

        }
    }

    public void getProgressReport()
    {
        // get progress report
        System.out.println("Tutor gave progress report");
    }

}

class NewStudent
{
    private NewTutor tutor;

    NewStudent(NewTutor tutor)
    {
        this.tutor = tutor;
    }

    public void startStudy()
    {
        // study
        System.out.println("Student is studying");
    }

    public void handInAssignment()
    {
        synchronized (tutor)
        {
            tutor.getProgressReport();
            synchronized (this)
            {
                System.out.println("Student handed in assignment");
//                tutor.notifyAll();
            }
        }
    }

}
