

/**
 * Implement an application that supports undo/redo functionality. Use a linked list to maintain a sequence of states.
 * Each state change is stored as a node in the list, allowing for easy navigation.
 * 1<>2<>3<>4<>5
 */
public class UndoRedoManager<T> {
    private class Node {
        private T state;
        private Node prev;
        private Node next;

        private Node(T state) {
            this.state = state;
        }
    }

    private Node currentState;

    // Undo operation
    public T undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
            return currentState.state;
        }
        return null; // No previous state to undo to
    }

    // Perform an operation and add a new state
    public void addState(T newState) {
        Node newNode = new Node(newState);
        if (currentState != null) {
            newNode.prev = currentState;
            currentState.next = newNode;
        }
        currentState = newNode;
    }

    // Redo operation
    public T redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
            return currentState.state;
        }
        return null; // No next state to redo to
    }

    // Get the current state
    public T getCurrentState() {
        return currentState != null ? currentState.state : null;
    }

    public static void main(String[] args) {
        UndoRedoManager<String> manager = new UndoRedoManager<>();

        // Adding states
        manager.addState("State 1");
        manager.addState("State 2");
        manager.addState("State 3");

        // Current state
        System.out.println("Current State: " + manager.getCurrentState()); // Output: State 3

        // Undo
        System.out.println("Undo: " + manager.undo()); // Output: State 2
        System.out.println("Current State: " + manager.getCurrentState()); // Output: State 2

        // Redo
        System.out.println("Redo: " + manager.redo()); // Output: State 3
        System.out.println("Current State: " + manager.getCurrentState()); // Output: State 3

        // Undo again
        System.out.println("Undo: " + manager.undo()); // Output: State 2
        System.out.println("Current State: " + manager.getCurrentState()); // Output: State 2

        // Adding a new state after undo
        manager.addState("State 4");
        System.out.println("Current State: " + manager.getCurrentState()); // Output: State 4

        // Undo to go back to State 2
        System.out.println("Undo: " + manager.undo()); // Output: State 2
        System.out.println("Current State: " + manager.getCurrentState()); // Output: State 2
    }
}