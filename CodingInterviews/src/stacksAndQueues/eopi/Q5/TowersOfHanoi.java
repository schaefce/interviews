package stacksAndQueues.eopi.Q5;

import java.util.Stack;

/*
 * 8.5 (TOWERS OF HANOI) You are given n rings. The ith ring has diameter i. The
 * rings are initially sorted in order on a peg P1, with the largest ring on the
 * bottom. You are to transfer these rings to another peg P2, which is initially
 * empty. You have a third peg P3 which is also initially empty. The only
 * operation you can do is taking a single ring from the top of one peg and
 * placing it on the top of another peg; you must never place a bigger ring
 * above a smaller ring. Write a function that prints a sequence of operations
 * that transfers all rings from P1 to P2.
 */

public class TowersOfHanoi {
    public static class Tower {
        Stack<Integer> disks;
        int index;

        Tower(int index) {
            disks = new Stack<Integer>();
            this.index = index + 1;
        }

        void addDisk(int disk) throws Exception {
            if (!disks.isEmpty() && disk > disks.peek()) {
                throw new Exception("Disk out of order exception");
            }
            disks.push(disk);
        }

        void moveTopDiskTo(Tower tower) throws Exception {
            int disk = disks.pop();
            tower.addDisk(disk);
            System.out.println(String.format(
                    "Move disk %d from tower %d to tower %d", disk, index,
                    tower.index));
        }

        void moveDisks(int n, Tower buffer, Tower destination) throws Exception {
            if (n > 0) {
                moveDisks(n - 1, destination, buffer);
                moveTopDiskTo(destination);
                buffer.moveDisks(n - 1, this, destination);
            }
        }

        void printTower() {
            System.out.println(String.format("Tower %d contents: ", index));
            Stack<Integer> tmp = new Stack<Integer>();
            while (!disks.isEmpty()) {
                int d = disks.pop();
                System.out.println(d);
                tmp.push(d);
            }
            while (!tmp.isEmpty()) {
                disks.push(tmp.pop());
            }
        }
    }

    public static void printTowers(Tower[] towers) {
        for (Tower tower : towers) {
            tower.printTower();
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        int N = 3;
        Tower[] towers = new Tower[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }
        for (int i = N; i > 0; i--) {
            towers[0].addDisk(i);
        }
        printTowers(towers);
        towers[0].moveDisks(N, towers[2], towers[1]);
        printTowers(towers);
    }
}
