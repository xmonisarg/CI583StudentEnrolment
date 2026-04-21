public class StudentEnrol extends Thread {
    private String processID;
    private long burstTime;
    private int priority;
    private long remainingTime;
    private long startTime;
    private long endTime;
    


public StudentEnrol (String processID, long burstTime, int priority) {
    this.processID = processID;
    this.burstTime = burstTime;
    this.priority = priority;
    this.remainingTime = burstTime;
    }

@Override
public void run() {
    startTime = System.currentTimeMillis();

    while (remainingTime > 0) {
        try {
            Thread.sleep(20);
            remainingTime -= 20;
        } catch (InterruptedException e) {
            return;
        }
        endTime = System.currentTimeMillis();
    }
}};