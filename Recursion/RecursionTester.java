public class RecursionTester {
    public static void main(String[] args) {
        ListNode head = new ListNode("a");
        ListNode mid = new ListNode("b");
        ListNode tail = new ListNode("c");
        head.setNext(mid);
        mid.setNext(tail);
        tail.setNext(null);

        Recursion.printListInReverse(head);

    }
}
