import java.util.ArrayList;
import java.util.List;

public class RoundRobin {
    private ArrayList<StudentEnrol> queue;
    private int Quantum = 20;

    public RoundRobin(ArrayList<StudentEnrol> processes) {
        this.queue = new ArrayList<>(processes);
    }

    
}
