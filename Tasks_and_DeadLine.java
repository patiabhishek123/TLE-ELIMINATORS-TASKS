import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Tasks_and_DeadLine {

    static class Task {
        long dn;
        long dl;

        Task(long dn, long dl) {
            this.dn = dn;
            this.dl = dl;
        }
    }

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Task[] tasks = new Task[n];

        for (int i = 0; i < n; i++) {
           String[] parts = br.readLine().split(" ");
            long dn = Long.parseLong(parts[0]);
            long dl = Long.parseLong(parts[1]);
            tasks[i] = new Task(dn ,dl);
        }

        Arrays.sort(tasks, Comparator.comparingLong(t -> t.dn));
        long time = 0;
        long reward = 0;

        for (Task t : tasks) {
            time += t.dn;
            reward += (t.dl - time);
        }

        System.out.println(reward);
    }
}