package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class FrameMain extends JFrame{
    private JTextArea textAreaOutput;
    private JButton buttonJavaSolve;
    private JButton buttonMySolve;
    private JTextField textFieldInput;
    private JPanel mainPanel;

    public FrameMain() {

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setVisible(true);
        this.add(mainPanel);
        setMinimumSize(new Dimension(600,600));


        buttonMySolve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = 0;
                try {
                    n = Integer.parseInt(textFieldInput.getText().trim());
                } catch (Exception E) {
                    JOptionPane.showMessageDialog(mainPanel, "Неккоректный ввод. Попробуйте еще раз.");
                    return;
                }

                MyQueue<MyQueue<Integer>> queues = MySolveTask.solveTask(n);
                StringBuilder queueAnswer = new StringBuilder();

                try {
                    while (!queues.isEmpty()) {
                        MyQueue<Integer> q = queues.poll();
                        while (!q.isEmpty()) {
                            queueAnswer.append(q.poll()).append(" ");
                        }
                        queueAnswer.append(" | ");
                    }
                } catch (MyQueue.MyQueueEmptyException ex) {
                    ex.printStackTrace();
                }
                textAreaOutput.setText(queueAnswer.toString());
            }
        });


        buttonJavaSolve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = 0;
                try {
                    n = Integer.parseInt(textFieldInput.getText().trim());
                } catch (Exception E) {
                    JOptionPane.showMessageDialog(mainPanel, "Неккоректный ввод. Попробуйте еще раз.");
                    return;
                }
                Queue<Queue<Integer>> queues = new LinkedList<>();
                queues = JavaSolveTask.javaSolveTask(n);

                StringBuilder queueAnswer = new StringBuilder();
                while (!queues.isEmpty()){
                    Queue<Integer> q = queues.poll();
                    while (!q.isEmpty()){
                        queueAnswer.append(q.poll()).append(" ");
                    }
                    queueAnswer.append(" | ");
                }
                textAreaOutput.setText(queueAnswer.toString());
                return;
            }
        });
    }
}
