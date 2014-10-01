package stacksAndQueues.ctci.Q4;

import java.util.Stack;

/**
 * In the classic problem of the Towers of Hanoi, you have 3 towers and N disks
 * of different sizes which can slide onto any tower. The puzzle starts with
 * disks sorted in ascending order of size from top to bottom (i.e., each disk
 * sits on top of an even larger one). You have the following constraints: (T)
 * Only one disk can be moved at a time. (2) A disk is slid off the top of one
 * tower onto the next rod. (3) A disk can only be placed on top of a larger
 * disk. Write a program to move the disks from the first tower to the last
 * using Stacks.
 */
public class TowersOfHanoi {

    public static class Tower {
        private int index;
        private Stack<Integer> disks;

        public Tower(int i) {
            disks = new Stack<Integer>();
            index = i;
        }

        public int index() {
            return index;
        }

        public void addDisk(int disk) {
            if (!disks.isEmpty() && disks.peek() <= disk) {
                return;
            }
            disks.push(disk);
        }

        public void moveTopDiskTo(Tower tower) {
            int disk = disks.pop();
            tower.addDisk(disk);
        }

        public void moveDisks(int n, Tower buffer, Tower destination) {
            if (n > 0) {
                // move n - 1 disks from original to buffer
                moveDisks(n - 1, destination, buffer);
                // move disk n to destination
                moveTopDiskTo(destination);
                // move n - 1 disks from buffer to destination
                buffer.moveDisks(n - 1, this, destination);
            }
        }
    }

    public static void main(String[] args) {
        int numDisks = 10;
        Tower[] towers = new Tower[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }
        for (int i = numDisks; i > 0; i--) {
            towers[0].addDisk(i);
        }
        towers[0].moveDisks(numDisks, towers[1], towers[2]);

    }

}
