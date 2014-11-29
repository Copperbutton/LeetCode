class MinStack {
    private static class Node {
        private int val;
        private Node next;
        public Node (int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    // Will use two stack to trace the minimal
    private Node head = null;
    private Node minHead = null;
    
    public void push(int x) {
        // Add value to normal stack
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        
        // Add value to min stack
        Node minNode = new Node(x);
        if (minHead == null) {
            minHead = minNode;
        } else if (minHead.val >= x) {
            minNode.next = minHead;
            minHead = minNode;
        }
    }

    public void pop() {
        if (head == null)
            return;
        if (head.val == minHead.val)
            minHead = minHead.next;
        head = head.next;
    }

    public int top() {
        if (head == null)
            return -1;
        return head.val;
    }

    public int getMin() {
        if (minHead == null)
            return -1;
        return minHead.val;
    }
}