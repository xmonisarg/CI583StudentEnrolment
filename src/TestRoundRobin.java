import java.util.List;

public class TestRoundRobin {

    public static void main(String[] args) throws InterruptedException {

        System.out.println(" -- Round Robin Test --");

        RoundRobin rr = new RoundRobin();

        StudentEnrol p1 = new StudentEnrol("P1", 1000, 1);
        StudentEnrol p2 = new StudentEnrol("P2", 2000, 2);

        rr.enqueue(p1);
        rr.enqueue(p2);

        List<StudentEnrol> result = rr.startEnrolment();

        // Print the result size
        System.out.println("Result size: " + result.size());
        for (StudentEnrol s : result) {
        System.out.println(s.getProcessID() + " state: " + s.getState());
    }

    // Prints if the test has passed or failed.
        if (result.size() == 2) {
            System.out.println("Test completed - both passed");
        } else {
            System.out.println("Test failed");
        }
    }
}