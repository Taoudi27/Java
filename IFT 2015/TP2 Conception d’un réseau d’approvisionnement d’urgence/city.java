public class City {
    private String name; // Nom de la ville
    private int id; // Identifiant unique de la ville
    private int x, y; // Coordonnées géographiques (x, y)
    private int demand; // Demande en unités (par exemple, produits, services)
    private int priority; // Priorité de la ville (Low, Medium, High)
    private String priorityString; // Représentation textuelle de la priorité

    // Constructeur pour initialiser tous les attributs de la ville
    public City(String name, int id, int x, int y, int demand, int priority, String priorityString) {
        this.name = name;
        this.id = id;
        this.x = x;
        this.y = y;
        this.demand = demand;
        this.priority = priority;
        this.priorityString = priorityString;
    }

    // Getters pour accéder aux attributs de la ville
    public String getName() {
        return name;
    }
    
    public String getPriorityString() {
        return priorityString;
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

    public int getDemand() {
        return demand;
    }

    public int getPriority() {
        return priority;
    }

    // Setters pour modifier les attributs de la ville
    public void setname(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    // Méthode pour afficher les informations de la ville sous forme de chaîne de caractères
    @Override
    public String toString() {
        return name + " [ID=" + id + ", Coordinates=(" + x + ", " + y + "), Demand=" + demand + " units, Priority=" + priority + "]";
    }

    // Méthode pour calculer la distance entre cette ville et un autre point (x2, y2)
    public double calculateDistance(int x2, int y2) {
        return Math.sqrt(Math.pow(this.x - x2, 2) + Math.pow(this.y - y2, 2)); // Utilise la formule de distance euclidienne
    }
}
