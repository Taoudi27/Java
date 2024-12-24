import java.util.*;

// Classe pour la gestion du réseau d'approvisionnement d'urgence
public class EmergencySupplyNetwork {

    // Matrice des coûts pour représenter le graphe
    private Map<String, Map<String, Double>> costMatrix = new HashMap<>();

    // Construction du graphe entre les villes et les entrepôts
    public void buildGraph(List<City> cities, List<Warehouse> warehouses) {
        for (City city : cities) {
            costMatrix.put(city.getName(), new HashMap<>()); // Initialise les coûts pour chaque ville
            for (Warehouse warehouse : warehouses) {
                double distance = calculateDistance(city.getX(), city.getY(), warehouse.getX(), warehouse.getY());
                double cost = calculateCost(distance);
                costMatrix.get(city.getName()).put(warehouse.getName(), cost); // Stocke le coût pour cet entrepôt
            }
        }
    }

    // Calcul de la distance euclidienne entre deux points (ville et entrepôt)
    private double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Calcul du coût de transport basé sur la distance
    private double calculateCost(double distance) {
        if (distance <= 10) return distance * 1; // Drone : coût faible
        else if (distance <= 20) return distance * 2; // Camion : coût moyen
        else return distance * 3; // Train : coût élevé
    }

    // Affichage de la matrice des coûts entre chaque ville et entrepôt
    public void displayCostMatrix() {
        System.out.println("Graph Representation (Cost Matrix):");
        System.out.println("---------------------------------------------------");
        for (String city : costMatrix.keySet()) {
            System.out.println(city + " -> " + costMatrix.get(city));
        }
        System.out.println("---------------------------------------------------");
    }

    // Allocation des ressources aux villes en fonction de leurs priorités
    public void allocateResources(List<City> cities, List<Warehouse> warehouses) {
        // File de priorité pour gérer les villes par ordre décroissant de priorité
        PriorityQueue<City> cityQueue = new PriorityQueue<>(Comparator.comparing(City::getPriority).reversed());
        cityQueue.addAll(cities);

        // Allocation des ressources pour chaque ville dans la file
        for (City city : cityQueue) {
            int remainingDemand = city.getDemand(); // Demande restante pour la ville
            while (remainingDemand > 0) {
                Warehouse bestWarehouse = null;
                double minCost = Double.MAX_VALUE;

                // Recherche du meilleur entrepôt (avec le coût minimal et de la capacité)
                for (Warehouse warehouse : warehouses) {
                    double cost = costMatrix.get(city.getName()).get(warehouse.getName());
                    if (cost < minCost && warehouse.getCapacity() > 0) {
                        minCost = cost;
                        bestWarehouse = warehouse;
                    }
                }

                // Transfert des ressources si un entrepôt approprié est trouvé
                if (bestWarehouse != null) {
                    int transferAmount = Math.min(bestWarehouse.getCapacity(), remainingDemand);
                    bestWarehouse.reduceCapacity(transferAmount); // Réduction de la capacité de l'entrepôt
                    remainingDemand -= transferAmount; // Mise à jour de la demande restante
                    System.out.println("Allocated " + transferAmount + " units from " + bestWarehouse.getName() + " to " + city.getName());
                } else {
                    // Message d'erreur si aucune ressource suffisante n'est disponible
                    System.out.println("Unable to fully allocate resources for " + city.getName());
                    break;
                }
            }
        }
    }
}
