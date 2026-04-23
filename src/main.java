import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;  
import java.io.IOException;

public class Main {  
    // Main to read and create the CSV file parser.
  public static void main(String[] args) throws IOException, InterruptedException {
    Scanner scanner = new Scanner(new File("src/StudentEnrolmentData.txt"));
    List<StudentEnrol> processes = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            String processID = parts[0].trim();
            long burstTime = Long.parseLong(parts[1].trim());
            int priority = Integer.parseInt(parts[2].trim());
            processes.add(new StudentEnrol(processID, burstTime, priority));

        }
    scanner.close();
    for (StudentEnrol process : processes) {
        process.start();
    }

    // round robin the processes

    RoundRobin roundRobin = new RoundRobin();
    for (StudentEnrol process : processes) {
        roundRobin.enqueue(process);
    }

    roundRobin.startEnrolment();

    // Priority schedule the processes.
    PrioritySchedule scheduler = new PrioritySchedule();
    for (StudentEnrol process : processes) {
        scheduler.enqueue(process);
    }
    scheduler.startEnrolment();

    // MLFQ the processes.
}}; 
