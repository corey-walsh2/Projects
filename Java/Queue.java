class Node {
	int val;
	Node next;

	Node(int val) {
		this.val = val;
	}
}

public class Que {

	Node head, tail;

	Que() {
		head = null;
		tail = null;
	}

	public static void main(String[] args) {
		Que queue = new Que();
      
      queue.enqueue(10);
		queue.enqueue(15);
		queue.enqueue(25);
		queue.dequeue();
		System.out.println("queue front is " + queue.front());
		System.out.println("queue rear is " + queue.rear());
		System.out.println("queue size is " + queue.size());
		queue.dequeue();
		queue.dequeue();
		System.out.println("queue size is " + queue.size());
	}

	/*
	 * Adds an element to the rear of the queue
	 */
	public void enqueue(int val) {
		if (tail == null) {
			head = tail = new Node(val);
		} else {
			Node newnode = new Node(val);
			tail.next = newnode;
			tail = newnode;
		}
	}

	/*
	 * Removes an element at the front of the queue and returns the element
	 */
	public Integer dequeue() {
		if (head != null) {
			head = head.next;
		}
		return null;
	}

	/*
	 * Checks if the queue is empty or has elements.
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/*
	 * Returns the number of elements of the queue
	 */
	public int size() {
		int count = 0;
		Node temp = head;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	/*
	 * Returns the front element of the queue
	 */
	public Integer front() {
		if (head != null)
			return head.val;
		else
			return null;
	}

	/*
	 * Returns the rear element of the queue.
	 */
	public Integer rear() {
		if (tail != null)
			return tail.val;
		else
			return null;
	}

}





/*import java.util.LinkedList;
import java.util.Queue;
class queue {

    private static class Node<Integer> {

        private final Integer nodes;
        private Node next;

        public Node(Integer nodes){
            this.nodes = nodes;
        }


        public void showQueue(){
            System.out.print(nodes + " ");
        }

    }
    
    //initializes front and tail nodes
    private Node front = null;
    private Node tail = null;
      
    //empty queue check
    public boolean isEmpty() {
        return (front == null);
    }
    
  
    public <Integer> void addLast(Integer nodes) {
        Node n = new Node(nodes);
        if (isEmpty()) {
            n.next = front;
            front = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
            tail.next = null;
        }

    }

    public void removeFirst() {
            Node temp = front;
            if (front.next == null)
                tail = null;
            front = front.next;

    }
        
    
    public void displayList() {
        Node curr = front;
        while (curr != null) {
            curr.showQueue();
            curr = curr.next;
        }
    }

}
//purpose of this class is to combine the first class with the main class
class addQueue {

    Queue<Integer> q = new LinkedList<>();

    public <Integer> void enqueue(Integer nodes) {
        q.addLast(nodes);
    }

    public void dequeue() {
        if(!q.isEmpty())
            q.removeFirst();
    }

    public void dumpQueue() {
        q.displayList();
        System.out.println();
    }

    public boolean isEmpty(){
        return q.isEmpty();
    }

}

class Main {

    public static void main(String[] args) {

        Queue <Integer> q = new LinkedList<>();

        q.enqueue(2);
        q.enqueue(1);
        q.dumpQueue();
        q.enqueue(3);
        q.enqueue(10);
        q.dequeue();
        q.enqueue(15);
        q.dumpQueue();
        q.dequeue();
        q.dequeue();
        q.dumpQueue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dumpQueue();

    }

}

*/