import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;  

public class main {  

    public main(String[] args) throws Exception {  

        // Opens the CSV file and reads the data from the file
        Scanner scanner = new Scanner(new File("studentenrol.csv"));  
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
    }
}