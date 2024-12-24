import java.util.*;

public class DynamicResourceSharing {
    // Map pour représenter les parents de chaque ville dans leur cluster
    private Map<String, String> parent = new HashMap<>();

    // Méthode pour initialiser les clusters, chaque ville est son propre cluster au début
    public void initializeClusters(List<City> cities) {
        for (City city : cities) {
            parent.put(city.getName(), city.getName()); // La ville est son propre parent
        }
    }

    // Méthode pour trouver le représentant (racine) du cluster d'une ville
    public String find(String city) {
        if (!parent.get(city).equals(city)) {
            // Compression de chemin pour optimiser les futures recherches
            parent.put(city, find(parent.get(city))); 
        }
        return parent.get(city); // Retourne la racine du cluster
    }

    // Méthode pour fusionner (union) deux clusters
    public void union(String city1, String city2) {
        String root1 = find(city1); // Trouve le cluster de la première ville
        String root2 = find(city2); // Trouve le cluster de la deuxième ville

        // Si les villes sont dans des clusters différents, les fusionner
        if (!root1.equals(root2)) {
            parent.put(root2, root1); // Attache la racine du second cluster à la première
            System.out.println("Merged clusters of " + city1 + " and " + city2);
        }
    }

    // Méthode pour afficher les clusters auxquels appartiennent les villes
    public void displayClusters(List<City> cities) {
        for (City city : cities) {
            // Affiche le cluster auquel appartient chaque ville
            System.out.println(city.getName() + " belongs to cluster: " + find(city.getName()));
        }
    }
}
