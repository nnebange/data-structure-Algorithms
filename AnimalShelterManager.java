import java.util.LinkedList;
import java.util.Queue;
import java.util.Date;

class Animal {
    private String name;
    private String type; 
    private Date timestamp;

    public Animal(String name, String type) {
        if (!type.equals("dog") && !type.equals("cat")) {
            throw new IllegalArgumentException("Animal type must be 'dog' or 'cat'.");
        }
        this.name = name;
        this.type = type;
        this.timestamp = new Date();
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}

class AnimalShelter {
    private Queue<Animal> dogs;
    private Queue<Animal> cats;

    public AnimalShelter() {
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
    }

    public void enqueue(Animal animal) {
        if (animal.getType().equals("dog")) {
            dogs.add(animal);
        } else if (animal.getType().equals("cat")) {
            cats.add(animal);
        } else {
            throw new IllegalArgumentException("Animal type must be 'dog' or 'cat'.");
        }
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty() && cats.isEmpty()) {
            throw new IllegalStateException("No animals available.");
        } else if (dogs.isEmpty()) {
            return cats.poll();
        } else if (cats.isEmpty()) {
            return dogs.poll();
        } else {
            // Compare timestamps of the oldest dog and cat
            if (dogs.peek().getTimestamp().before(cats.peek().getTimestamp())) {
                return dogs.poll();
            } else {
                return cats.poll();
            }
        }
    }

    public Animal dequeueDog() {
        if (dogs.isEmpty()) {
            throw new IllegalStateException("No dogs available.");
        }
        return dogs.poll();
    }

    public Animal dequeueCat() {
        if (cats.isEmpty()) {
            throw new IllegalStateException("No cats available.");
        }
        return cats.poll();
    }
}

public class Main {
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();

        // Enqueue animals
        shelter.enqueue(new Animal("Buddy", "dog"));
        shelter.enqueue(new Animal("Whiskers", "cat"));
        shelter.enqueue(new Animal("Max", "dog"));
        shelter.enqueue(new Animal("Mittens", "cat"));

        // Dequeue operations
        System.out.println("Adopted: " + shelter.dequeueAny().getName()); 
        System.out.println("Adopted: " + shelter.dequeueDog().getName());
        System.out.println("Adopted: " + shelter.dequeueCat().getName());

        // Attempt to dequeue when no animals are available
        try {
            System.out.println("Adopted: " + shelter.dequeueAny().getName());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
    }
}}