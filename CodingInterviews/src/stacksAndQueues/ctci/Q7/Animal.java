package stacksAndQueues.ctci.Q7;

public abstract class Animal {
    private int arrivalTime;
    protected final String name;

    public Animal(String name) {
        this.name = name;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int i) {
        arrivalTime = i;
    }

    public boolean isOlderThan(Animal a) {
        return getArrivalTime() < a.getArrivalTime();
    }
}