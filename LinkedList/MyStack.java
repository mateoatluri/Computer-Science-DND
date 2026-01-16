import java.util.EmptyStackException;

public class MyStack<E> extends SinglyLinkedList<E> {
    
    private boolean isEmpty;

    public MyStack() {
        isEmpty = true;
        head = null;
    }

    public boolean push(E obj) {
        if (obj == null) {
            return false;
        }

        isEmpty = false;
        ListNode<E> newObj = new ListNode<E>(obj);

        newObj.setNext(super.getHead());
        head = newObj;

        return true;

    }

    public E pop() {
        if (isEmpty) {
            throw new EmptyStackException();
        }
        
        ListNode<E> toRemove = this.getHead();

        if (head.getNext() == null) {
            isEmpty = true;
        }


        head = head.getNext();
        return toRemove.getValue();
        
    }

    public E peek() {
        if (isEmpty) {
            throw new EmptyStackException();
        }
        
        return head.getValue();
    }

    public boolean empty() {
        if (isEmpty == true) {
            return true;
        } else {
            return false;
        }
    }

}
