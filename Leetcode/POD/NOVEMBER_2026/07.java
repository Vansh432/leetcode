import java.util.*;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length, m = tasks.length;

        // free heap: {weight, index}
        PriorityQueue<int[]> free = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0])
                                   : Integer.compare(a[1], b[1])
        );

        // busy heap: {freeTime, weight, index}  (long, because time can get large)
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0])
                    : a[1] != b[1] ? Long.compare(a[1], b[1])
                                   : Long.compare(a[2], b[2])
        );

        for (int i = 0; i < n; i++) {
            free.offer(new int[]{servers[i], i});
        }

        int[] ans = new int[m];
        long time = 0;

        for (int j = 0; j < m; j++) {
            // 1. task can't start before it arrives
            time = Math.max(time, j);

            // 2. nobody free -> jump to the earliest finish time
            if (free.isEmpty() && busy.peek()[0] > time) {
                time = busy.peek()[0];
            }

            // 3. release all servers that are done by now (<= time)
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] s = busy.poll();
                free.offer(new int[]{(int) s[1], (int) s[2]});
            }

            // 4. pick best free server
            int[] best = free.poll();
            ans[j] = best[1];

            // 5. it will be free at (actual start time + duration)
            busy.offer(new long[]{time + tasks[j], best[0], best[1]});
        }
        return ans;
    }
}