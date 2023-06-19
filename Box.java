import java.util.ArrayList;

public class Box <T extends Fruit>{

    private ArrayList<T> fruits = new ArrayList<>();

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        if (fruits.isEmpty()) {
            return 0.0f;
        }
        float weight = 0.0f;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }
    public boolean compare(Box<?> other) {
        return Math.abs(this.getWeight() - other.getWeight()) < 0.0001;
    }

    public void transferFruitsTo(Box<T> other) {
        if (this == other) {
            return;
        }

        if (this.fruits.isEmpty()) {
            return;
        }

        if (other.fruits.isEmpty()) {
            other.fruits.addAll(this.fruits);
            this.fruits.clear();
            return;
        }

        if (this.fruits.get(0).getClass() != other.fruits.get(0).getClass()) {
            return;
        }

        other.fruits.addAll(this.fruits);
        this.fruits.clear();
    }

}
