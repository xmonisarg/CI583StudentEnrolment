import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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
}

public static void main(String[] arg) throws IOException {
// This is the file path to the CSV
    String filePath = "src/StudentEnrolmentData.txt";
// Try making the scanner for the CSV
    try ( Scanner scanner = new Scanner (new File(filePath))) {
// If the scanner has a next line it executes
if( scanner.hasNextLine()){
// does a while loop for every line inside of it
while (scanner.hasNextLine()){
String line = scanner.nextLine();
            String[] parts = line.split(",");
            String processID = parts[0].trim();
            long burstTime = Long.parseLong(parts[1].trim());
            int priority = Integer.parseInt(parts[2].trim());
// instantiates a new StudentEnrol Object with the new data
             StudentEnrol studentEnrol = new StudentEnrol(processID, burstTime, priority);
// begins the enrolment
            studentEnrol.start();
        }
    }
}}}
