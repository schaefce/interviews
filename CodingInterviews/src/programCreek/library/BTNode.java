package programCreek.library;
public class BTNode<E> {
    public E value;
    public BTNode<E> right;
    public BTNode<E> left;

    public BTNode(E data) {
        this.value = data;
    }


}
