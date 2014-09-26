package eopi.library;

public class LLNodeTemplate {
    public static class LLNode<Item> {
        public LLNode<Item> next;
        public Item item;

        public LLNode(LLNode<Item> next, Item item) {
            this.next = next;
            this.item = item;
        }

        public LLNode(Item item) {
            this(null, item);
        }
    }
}
