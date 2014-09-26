package eopi.library;

public class BTNodeTemplate {
    public static class BTNode<Item> {
        BTNode<Item> left;
        BTNode<Item> right;
        Item value;

        public BTNode(BTNode<Item> left, BTNode<Item> right, Item value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public BTNode(Item value) {
            this.value = value;
        }

        public void setLeft(BTNode<Item> left) {
            this.left = left;
        }

        public void setRight(BTNode<Item> right) {
            this.right = right;
        }

        public BTNode<Item> getLeft() {
            return left;
        }

        public BTNode<Item> getRight() {
            return right;
        }

        public Item getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            BTNode that = (BTNode) o;

            if (value != null ? !value.equals(that.getValue()) : that
                    .getValue() != null) {
                return false;
            }
            if (left != null ? !left.equals(that.getLeft())
                    : that.getLeft() != null) {
                return false;
            }
            if (right != null ? !right.equals(that.getRight()) : that
                    .getRight() != null) {
                return false;
            }

            return true;
        }
    }
}
