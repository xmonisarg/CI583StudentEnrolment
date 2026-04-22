import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class PrioritySchedule {

    private PriorityQueue<StudentEnrol> queue;
    private long Quantum = 20;

    // Comparator lamba expression to create a priority queue.
    public PrioritySchedule() {
        
        Comparator<StudentEnrol> c = (s1, s2) -> {
            if (s1.getPriority() < s2.getPriority()) {
                return -1;
            } else if (s1.getPriority() > s2.getPriority()) {
                return 1;
            } else {
                return -1;
            }
        };
        this.queue = new PriorityQueue<>(c);
    }

public void enqueue(StudentEnrol process) {
        queue.add(process);
    }

public StudentEnrol dequeue() {
        if (!queue.isEmpty()) {
            return queue.poll();
        }
        return null;
    }

 // Copied and pasted the round robin to be able to make the priority queue work. 
    
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
            return completedProcesses;
        }
    }
