package test;
import java.util.List;

// Student Enrol Java copied over to make my test working.
public StudentEnrol (String processID, long burstTime, int priority) {
    this.processID = processID;
    this.burstTime = burstTime;
    this.priority = priority;
    this.remainingTime = burstTime;
    }

// Getters for process attributes to be able to functional in RoundRobin

public String getProcessID() {
    return processID;
}

public long getBurstTime() {
    return burstTime;
}

public long getTimeTaken() {
    return burstTime - remainingTime;
}

public long getStartTime() {
    return startTime;
}

public long getEndTime() {
    return endTime;
}

public class TestRoundRobin {
    // Creating fake processes to test RoundRobin
    public static void main(String[] args) throws InterruptedException {
        RoundRobin rr = new RoundRobin();

        StudentEnrol p1 = new StudentEnrol("P1", 100, 1);
        StudentEnrol p2 = new StudentEnrol("P2", 200, 2);

        rr.enqueue(p1);
        rr.enqueue(p2);

        List<StudentEnrol> result = rr.startEnrolment();
        if (result.size() == 2) {
            System.out.println("Test completed - both passed");
        } else {
            System.out.println("Test failed - both failed");
        }
        }
    }
}
