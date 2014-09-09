package ctci.stacksAndQueues.Q7;

import java.util.LinkedList;

/*
 * 3.7 An animal shelter holds only dogs and cats, and operates on a strictly
 * "first in, first out" basis. People must adopt either the "oldest" (based on
 * arrival time) of all animals at the shelter, or they can select whether they
 * would prefer a dog or a cat (and will receive the oldest animal of that
 * type). They cannot select which specific animal they would like. Create the
 * data structures to maintain this system and implement operations such as
 * enqueue, dequeueAny, dequeueDog and dequeueCat. You may use the built-in
 * LinkedList data structure.
 */

public class AnimalShelterQueue {

    private LinkedList<Dog> dogs = new LinkedList<Dog>();
    private LinkedList<Cat> cats = new LinkedList<Cat>();
    private int time = 0;

    public void enqueue(Animal a) {
        a.setArrivalTime(time);
        time++;
        if (a instanceof Dog) {
            dogs.add((Dog) a);
        } else if (a instanceof Cat) {
            cats.add((Cat) a);
        }
    }

    public Animal dequeueAny() {
        if (dogs.size() == 0) {
            return dequeueCat();
        } else if (cats.size() == 0) {
            return dequeueDog();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if (dog.isOlderThan(cat)) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    public Dog dequeueDog() {
        return dogs.poll();
    }

    public Cat dequeueCat() {
        return cats.poll();
    }
}