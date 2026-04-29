import java.util.ArrayList;
import java.util.List;

public class MLFQ {

        private ArrayList<StudentEnrol> young = new ArrayList<>();
        private ArrayList<StudentEnrol> old = new ArrayList<>();
        private long Quantum = 20;
        private boolean fromYoung;

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
                    fromYoung = true;
                } else {
                    process = old.remove(0);
                    fromYoung = false;
                }
    // Using a switch statement to check whether to start, terminate or use a default for the processes and in the appropriate queue method.
                Thread.State state = process.getState();
                switch (state) {
                    case NEW:
                        process.start();
                        Thread.sleep(Quantum);
                        if (fromYoung) {
                            old.add(process);
                        } else {
                            young.add(process);
                        }
                        break;
                    case TERMINATED:
                        completedProcesses.add(process);
                        System.out.println("Process " + process.getProcessID() + " completed."
                        + " completed total time:" + process.getBurstTime() + "ms" + process.getTimeTaken() + "ms");
                        break;
                    default:
                        process.interrupt();
                        Thread.sleep(Quantum);
                        if (fromYoung) {
                            old.add(process);
                        } else {
                            young.add(process);
                        break;
                    }
                }
        }
            return completedProcesses;
            }
}
