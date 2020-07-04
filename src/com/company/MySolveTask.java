package com.company;

public class MySolveTask {

    public static MyQueue<MyQueue<Integer>> solveTask(int n) {
        MyQueue<MyQueue<Integer>> queues = new MyQueue<>();
        for (int i = 0; i < n; i++) {
            MyQueue<Integer> queue = new MyQueue<>();
            for (int j = 1; j <= i + 1; j++) {
                queue.add(j);
            }
            queues.add(queue);
        }

        return queues;
    }
}
