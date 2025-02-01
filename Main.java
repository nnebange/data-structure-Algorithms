import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    // Constructor
    LinkedList() {
        this.head = null;
    }

    // Method to add a node at the end of the list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Added: " + data);
    }

    // Method to delete a node at the beginning
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty, nothing to delete.");
            return;
        }
        System.out.println("Deleted: " + head.data);
        head = head.next;
    }

    // Method to delete a node at the end
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty, nothing to delete.");
            return;
        }
        if (head.next == null) {
            System.out.println("Deleted: " + head.data);
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        System.out.println("Deleted: " + current.next.data);
        current.next = null;
    }

    // Method to delete a node at a specific position
    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty, nothing to delete.");
            return;
        }
        if (position == 0) {
            System.out.println("Deleted: " + head.data);
            head = head.next;
            return;
        }
        Node current = head;
        for (int i = 0; current != null && i < position - 1; i++) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            System.out.println("Position not found.");
            return;
        }
        System.out.println("Deleted: " + current.next.data);
        current.next = current.next.next;
    }

    // Method to print the linked list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int choice;

        do {
            System.out.println("\n--- Linked List Operations ---");
            System.out.println("1. Add a node");
            System.out.println("2. Delete at the beginning");
            System.out.println("3. Delete at the end");
            System.out.println("4. Delete at a specific position");
            System.out.println("5. Print the list");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the data to add: ");
                    int data = scanner.nextInt();
                    list.add(data);
                    break;
                case 2:
                    list.deleteAtBeginning();
                    break;
                case 3:
                    list.deleteAtEnd();
                    break;
                case 4:
                    System.out.print("Enter the position to delete: ");
                    int position = scanner.nextInt();
                    list.deleteAtPosition(position);
                    break;
                case 5:
                    System.out.println("Current List:");
                    list.printList();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}