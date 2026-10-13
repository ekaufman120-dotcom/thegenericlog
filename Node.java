public class Node<T>{
    private T data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public T getInfo() {
        return data;
    }

    public void setInfo(T data) {
        this.data = data;
    }

    public Node<T> getLink() {
        return next;
    }

    public void setLink(Node<T> next) {
        this.next = next;
    }
}
