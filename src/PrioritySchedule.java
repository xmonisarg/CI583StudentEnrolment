import java.util.PriorityQueue;
import java.util.Comparator;

public class PrioritySchedule {

    // Comparator lamba expression to create a priority queue.
    Comparator<StudentEnrol> c = (s1, s2) -> {
        if (s1.getPriority() < s2.getPriority()) {
            return -1;
        } else if (s1.getPriority() > s2.getPriority()) {
            return 1;
        } else {
            return 0;
        }
    };
}
