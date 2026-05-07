import java.util.List;

public class TestMLFQ {
    public static void main(String[] args) throws InterruptedException {

        System.out.println(" -- MLFQ Test --");

        MLFQ mlfq = new MLFQ();

        // Values for processes for the test
        StudentEnrol p1 = new StudentEnrol("P1", 1000, 1);
        StudentEnrol p2 = new StudentEnrol("P2", 2500, 2);
        StudentEnrol p3 = new StudentEnrol("P3", 900, 1);
        StudentEnrol p4 = new StudentEnrol("P4", 3000, 2);

        mlfq.enqueue(p1);
        mlfq.enqueue(p2);
        mlfq.enqueue(p3);
        mlfq.enqueue(p4);

        List<StudentEnrol> result = mlfq.startEnrolment();

        if (result.size() == 4) {
            System.out.println("Test passed:" + result.size());
        } else {
            System.out.println("Test failed:" + result.size());
        }
    }
}
