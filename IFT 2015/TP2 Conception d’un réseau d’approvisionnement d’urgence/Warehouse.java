public class Warehouse {
    private String name; // Nom de l'entrepôt
    private int id; // Identifiant unique de l'entrepôt
    private int x, y; // Coordonnées géographiques (x, y)
    private int capacity; // Capacité en unités de l'entrepôt

    // Constructeur pour initialiser tous les attributs de l'entrepôt
    public Warehouse(String name, int id, int x, int y, int capacity) {
        this.name = name;
        this.id = id;
        this.x = x;
        this.y = y;
        this.capacity = capacity;
    }

    // Getters pour accéder aux attributs de l'entrepôt
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCapacity() {
        return capacity;
    }

    // Setters pour modifier les attributs de l'entrepôt
    public void setId(int id) {
        this.id = id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Méthode pour réduire la capacité de l'entrepôt (par exemple après une expédition)
    public void reduceCapacity(int amount) {
        this.capacity -= amount;
    }

    // Méthode pour augmenter la capacité de l'entrepôt (par exemple après une réception)
    public void increaseCapacity(int amount) {
        this.capacity += amount;
    }

    // Méthode pour afficher les informations de l'entrepôt sous forme de chaîne
    @Override
    public String toString() {
        return name + " [ID=" + id + ", Coordinates=(" + x + ", " + y + "), Capacity=" + capacity + " units]";
    }

    // Méthode pour calculer la distance entre cet entrepôt et un autre point (x2, y2)
    public double calculateDistance(int x2, int y2) {
        return Math.sqrt(Math.pow(this.x - x2, 2) + Math.pow(this.y - y2, 2)); // Utilise la formule de distance euclidienne
    }
}
