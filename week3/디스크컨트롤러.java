import java.util.*;

class Solution {
    public int solution(int[][] jobArr) {
        int n = jobArr.length;
        
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new Job(i, jobArr[i][0], jobArr[i][1]));
        }
        jobs.sort(Comparator.comparingInt(job -> job.start));
        
        Comparator<Job> diskComparator = Comparator
            .comparingInt((Job j) -> j.need)
            .thenComparingInt(j -> j.start)
            .thenComparingInt(j -> j.idx);
        Queue<Job> disk = new PriorityQueue<>(diskComparator);
        
        int time = 0;
        int i = 0;
        int sum = 0;
        while (i < n || !disk.isEmpty()) {
            while (i < n && jobs.get(i).start <= time)
                disk.add(jobs.get(i++));
            
            if (!disk.isEmpty()) {
                Job target = disk.poll();
                time += target.need;
                sum += time - target.start;
                continue;
            }
            time = jobs.get(i).start;
        }
        
        return sum / n;
    }
    
    class Job {
        int idx;
        int start;
        int need;
        
        public Job(int idx, int start, int need) {
            this.idx = idx;
            this.start = start;
            this.need = need;
        }
    }
}
