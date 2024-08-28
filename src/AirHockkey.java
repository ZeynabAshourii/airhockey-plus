package src;

import java.util.LinkedList;

public class AirHockkey{
    static LinkedList<LinkedList<String>> players = new LinkedList<>();
    static LinkedList<LinkedList<Integer>> goals = new LinkedList<>();
    static LinkedList<String> mode = new LinkedList<>();
    static LinkedList<String> status = new LinkedList<>();
    static LinkedList<Integer> times = new LinkedList<>();
    static LinkedList<Integer> tedadGoal= new LinkedList<>();
    static LinkedList<Boolean> margin = new LinkedList<>();

    public static void main(String[] args) {
        tedadGoal.add(0);
        times.add(300);
        margin.add(false);
        new AirHockey();
    }


}
