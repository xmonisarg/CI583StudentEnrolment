import java.util.ArrayList;
import java.util.List;

public class MLFQ {

        private ArrayList<StudentEnrol> young = new ArrayList<>();
        private ArrayList<StudentEnrol> old = new ArrayList<>();
        private long Quantum = 20;

        public void enqueue(StudentEnrol process) {
            young.add(process);

        }
 // Using a while loop with the queue process if it old or young - then it would either be interrupted or continue with the process. 
        public List<StudentEnrol> startEnrolment() throws InterruptedException {
            List <StudentEnrol> completedProcesses = new ArrayList<>();
            while (!young.isEmpty() || !old.isEmpty()) {
                StudentEnrol process;
                if (!young.isEmpty()) {
                    process = young.remove(0);
                } else {
                    process = old.remove(0);
                }
                Thread.State state = process.getState();
                if (state == Thread.State.NEW) {
                    process.start();
                    Thread.sleep(Quantum);
                    old.add(process);
                } else if (state == Thread.State.TERMINATED) {
                    completedProcesses.add(process);
                    System.out.println("Process " + process.getProcessID() 
                    + " completed. Time taken: " + 
                    process.getBurstTime() + "ms " + process.getTimeTaken() + "ms");
                } else {
                    // Interrupt if the process was continued if it was not old or new.
                    process.interrupt();
                    Thread.sleep(Quantum);
                    if (young.contains(process)) {
                        old.add(process);
                    } else {
                        young.add(process);
                    }
                }
                
        }
            return completedProcesses;


        }
}
