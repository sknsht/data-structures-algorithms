import java.util.*;

public class FractionalKnapsack {
    public static double getOptimalValue(int capacity, List<Item> items) {
        Collections.sort(items);

        double maxValue = 0;

        for (Item item : items) {
            if (capacity > 0) {
                int fraction = Math.min(item.getWeight(), capacity);
                maxValue += item.getValuePerWeight() * fraction;
                capacity -= fraction;
            }
        }
        return maxValue;
    }

    public static class Item implements Comparable<Item> {
        private final int value;
        private final int weight;
        private final double valuePerWeight;

        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.valuePerWeight = (double) value / (double) weight;
        }

        public int getWeight() {
            return weight;
        }

        public double getValuePerWeight() {
            return valuePerWeight;
        }

        @Override
        public int compareTo(Item o) {
            return Double.compare(o.getValuePerWeight(), valuePerWeight);
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            int weight = scanner.nextInt();
            items.add(new Item(value, weight));
        }
        System.out.println(getOptimalValue(capacity, items));
    }
}
