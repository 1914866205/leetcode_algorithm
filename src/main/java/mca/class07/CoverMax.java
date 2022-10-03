package mca.class07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName CoverMax
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/9/28 23:19
 * @Version 1.0
 **/
public class CoverMax {
    public static int maxCover1(int[][] lines) {
        //线段的左右边界
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lines.length; i++) {
            min = Math.min(min, lines[i][0]);
            max = Math.max(max, lines[i][1]);
        }
        int maxCount = 0;
        //只计算重合，不计算边界相邻。
        for (double i = min + 0.5; i < max; i += 1) {
            //记录每次重合的个数
            int cur = 0;
            for (int j = 0; j < lines.length; j++) {
                if (lines[j][0] < i && i < lines[j][1]) {
                    cur++;
                }
            }
            maxCount = Math.max(cur, maxCount);
        }
        return maxCount;
    }

    public static class Line {
        public int start;
        public int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class EndComparator implements Comparator<Line> {
        @Override
        public int compare(Line o1, Line o2) {
            return o1.end - o2.end;
        }
    }

    public static int maxCount2(int[][] m) {
        Line[] lines = new Line[m.length];
        for (int i = 0; i < m.length; i++) {
            lines[i] = new Line(m[i][0], m[i][1]);
        }
        // 按end升序
        Arrays.sort(lines, (a, b) -> a.end - b.end);
        int max = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < lines.length; i++) {
            while (!heap.isEmpty() && heap.peek() <= lines[i].start) {
                heap.poll();
            }
            heap.add(lines[i].end);
            max = Math.max(max, heap.size());
        }
        return max;
    }
}
