package google;

public class MyInterval implements Comparable<MyInterval> {
    public Integer start;
    public Integer end;

    public MyInterval(Integer s, Integer e) {
        this.start = s;
        this.end = e;
    }

    public boolean hasOverlap(MyInterval other) {
        return start.compareTo(other.end) <= 0
                && other.start.compareTo(end) <= 0;

    }

    public void replaceBounds(MyInterval other) {
        start = other.start.compareTo(start) < 0 ? other.start : start;
        end = other.end.compareTo(end) > 0 ? other.end : end;

    }

    @Override
    public int compareTo(MyInterval other) {
        return start.compareTo(other.start);
    }

    public String toString() {
        return String.format("[%d,%d]", start, end);
    }

}