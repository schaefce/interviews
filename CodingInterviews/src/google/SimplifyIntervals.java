package google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimplifyIntervals {
    public static List<MyInterval> simplify(List<MyInterval> intervals) {
        List<MyInterval> returnList = new ArrayList<MyInterval>();
        Collections.sort(intervals);
        while (!intervals.isEmpty()) {
            addInterval(intervals, returnList, intervals.get(0));
        }
        return returnList;

    }

    private static void addInterval(List<MyInterval> intervals,
            List<MyInterval> returnList, MyInterval curr) {
        for (MyInterval inList : returnList) {
            if (inList.hasOverlap(curr)) {
                inList.replaceBounds(curr);
                intervals.remove(curr);
                shiftOverlaps(returnList, inList);
                return;
            }
        }
        returnList.add(curr);
        return;
    }

    private static void shiftOverlaps(List<MyInterval> intervals,
            MyInterval inList) {
        int i = intervals.indexOf(inList);
        MyInterval prev = i != 0 ? intervals.get(i - 1) : null;
        MyInterval next = i < intervals.size() - 1 ? intervals.get(i + 1)
                : null;
        if (prev != null && inList.hasOverlap(prev)) {
            inList.replaceBounds(prev);
            intervals.remove(prev);
            shiftOverlaps(intervals, inList);
        }

        if (next != null && inList.hasOverlap(next)) {
            inList.replaceBounds(next);
            intervals.remove(next);
            shiftOverlaps(intervals, inList);
        }
    }

    public static void printIntervals(List<MyInterval> intervals) {
        for (MyInterval interval : intervals) {
            System.out.println(interval);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<MyInterval> unsimplified = new ArrayList<MyInterval>();
        unsimplified.add(new MyInterval(-1, 4));
        unsimplified.add(new MyInterval(-2, 3));
        unsimplified.add(new MyInterval(5, 6));
        System.out.println(unsimplified);
        unsimplified = simplify(unsimplified);
        System.out.println(unsimplified);

        unsimplified.clear();
        unsimplified.add(new MyInterval(-1, 4));
        unsimplified.add(new MyInterval(-2, 3));
        unsimplified.add(new MyInterval(-5, 7));
        unsimplified.add(new MyInterval(5, 6));

        System.out.println(unsimplified);
        unsimplified = simplify(unsimplified);
        System.out.println(unsimplified);
    }
}
