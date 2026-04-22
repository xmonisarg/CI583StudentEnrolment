import java.util.ArrayList;
import java.util.List;

public class RoundRobin {
    private ArrayList<StudentEnrol> queue;
    private long Quantum = 20;

    public RoundRobin() {
        this.queue = new ArrayList<>();
    }
    // Enqueue a process to the back of the queue 
    public void enqueue(StudentEnrol process) {
        queue.add(process);
    }
    // Dequeue a process from the front of the queue, with the return of the remove
    public StudentEnrol dequeue() {
        if (!queue.isEmpty()) {
            return queue.remove(0);
        }
        return null;
    }

    public List<StudentEnrol> startEnrolment() throws InterruptedException {
        List<StudentEnrol> completedProcesses = new ArrayList<>();
        while (!queue.isEmpty()) {
            StudentEnrol process = dequeue();
            Thread.State state = process.getState();
            // If the process is new, it will begin and then be added to the queue once the quantum time ended.
            if (state == Thread.State.NEW) {
                process.start();
                Thread.sleep(Quantum);
                queue.add(process);
            } else if (state == Thread.State.TERMINATED) {
                // If the process was terminated, add it to completed processes
                completedProcesses.add(process);

                System.out.println("Process " + process.getProcessID() 
                + " completed. Time taken: " + 
                (process.getBurstTime() - process.getTimeTaken()) + " ms");
            }
        }
        // End the while loop when the queue is empty and return the list of completed processes
        return completedProcesses;
    }
}
