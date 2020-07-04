package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class JavaSolveTask {

    public static Queue<Queue<Integer>> javaSolveTask(int n) {
        Queue<Queue<Integer>> queues = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 1; j <= i + 1; j++) {
                queue.add(j);
            }
            queues.add(queue);
        }
        return queues;
    }
}
