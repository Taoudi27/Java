
import java.util.*;

public class ResourceRedistribution {
    public void redistributeResources(List<Warehouse> warehouses) {
        PriorityQueue<Warehouse> excessHeap = new PriorityQueue<>(Comparator.comparingInt(Warehouse::getCapacity).reversed());
        PriorityQueue<Warehouse> deficitHeap = new PriorityQueue<>(Comparator.comparingInt(Warehouse::getCapacity));

        for (Warehouse warehouse : warehouses) {
            if (warehouse.getCapacity() > 50) {
                excessHeap.add(warehouse);
            } else if (warehouse.getCapacity() < 50) {
                deficitHeap.add(warehouse);
            }
        }

        while (!excessHeap.isEmpty() && !deficitHeap.isEmpty()) {
            Warehouse excess = excessHeap.poll();
            Warehouse deficit = deficitHeap.poll();

            int transferAmount = Math.min(excess.getCapacity() - 50, 50 - deficit.getCapacity());
            excess.reduceCapacity(transferAmount);
            deficit.increaseCapacity(transferAmount);

            System.out.println("Transferred " + transferAmount + " units from " + excess.getName() + " to " + deficit.getName());

            if (excess.getCapacity() > 50) {
                excessHeap.add(excess);
            }

            if (deficit.getCapacity() < 50) {
                deficitHeap.add(deficit);
            }
        }
        for (Warehouse wharehouse : warehouses) {
            System.out.println(wharehouse.getName() + wharehouse.getCapacity());
        }
    }
}
