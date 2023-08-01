package hw3;

public class LinkList<T> {
   
    private Node<T> head;
    private Node<T> tail;

    public Node<T> find(T value) {
        Node<T> currentNode = head;
        while(currentNode != null) {
            if(value.equals(currentNode.getValue())) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

    public void addLast(T value) {
        Node<T> node = new Node<>(value);
        if(head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
        }
    }


    public void addFirst(T value) {
        Node<T> node = new Node<>(value);
        if(head == null) {
            head = node;
            tail = node;
        } else {
            head.setPrevious(node);
            node.setNext(head);
            head = node;
        }
    }


    public void addAfter(T value, Node<T> node) {
        Node<T> next = node.getNext();
        Node<T> newNode = new Node<>(value);
        node.setNext(newNode);
        newNode.setPrevious(node);
        if(next == null) {
            tail = newNode;
        } else {
            next.setPrevious(newNode);
            newNode.setNext(next);
        }
    }


    public void delete(Node<T> node) {
        if(node != null) {
            Node<T> previous = node.getPrevious();
            Node<T> next = node.getNext();
            if(previous == null && next == null) {
                head = null;
                tail = null;
            } else if(previous == null) {
                next.setPrevious(null);
                head = next;
            } else if(next == null) {
                previous.setNext(null);
                tail = previous;
            } else {
                previous.setNext(next);
                next.setPrevious(previous);
            }
        }
    }


    public void revert() {
        Node<T> currentNode = head;
        if(head != null && head.getNext() != null) {
            while(currentNode != null) {
                Node<T> next = currentNode.getNext();
                Node<T> previous = currentNode.getPrevious();
                currentNode.setNext(previous);
                currentNode.setPrevious(next);
                if(previous == null) {
                    tail = currentNode;
                }
                if(next == null) {
                    head = currentNode;
                }
                currentNode = next; 
            }
        } 
    }


    public void print() {
        if(head != null) {
            Node<T> currentNode = head;
            Node<T> next;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            while(currentNode != null) {
                    sb.append(currentNode.getValue()).append(", ");
                    //System.out.println(currentNode.value);
                    next = currentNode.getNext();
                    currentNode = next; 
            }
            sb.delete(sb.length() -2, sb.length());
            sb.append("]");
            System.out.println(sb);
        }
    }

}
