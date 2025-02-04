
public class StackDouble { 
    private int[] elements;  // tab pr stocker elements de 2 piles
    private int top_1; 
    private int top_2; 

    public StackDouble() { // constructeur initialise piles et tabs commun
        this.elements = new int[100];
        this.top_1 = -1;
        this.top_2 = elements.length;
    }

    public boolean full() { // methode pour si tableau est plein
        // Les piles sont pleines si les deux sommets se croise ou rencontre
        return top_1 + 1 == top_2;
    }

    public boolean push(boolean one, int value) { // ajouter element dans une des 2 piles
        if (full()) {
            return false; // false car pile sont pleine et impossible d'ajout 
        }

        if (one) {
            // Ajouter a la première pile
            elements[++top_1] = value;
        } else {
            // Ajouter a la deuxième pile
            elements[--top_2] = value;
        }
        return true;
    }

    public int top(boolean one) throws Exception { // methode pr recuperer element sommet de pile sans la delete
        if (one) {
            if (top_1 == -1) {
                throw new Exception("Première pile est vide.");
            }
            return elements[top_1];
        } else {
            if (top_2 == elements.length) {
                throw new Exception("Deuxième pile est vide.");
            }
            return elements[top_2];
        }
    }

    public int pop(boolean one) throws Exception { // methode pour retirer et retoruner element au sommet 
        if (one) {
            if (top_1 == -1) {
                throw new Exception("première pile est vide.");
            }
            return elements[top_1--];
        } else {
            if (top_2 == elements.length) {
                throw new Exception("deuxième pile est vide.");
            }
            return elements[top_2++];
        }
    }

    public int size(boolean one) { // methode pour obtenir taille des 2 piles
        if (one) {
            return top_1 + 1;
        } else {
            return elements.length - top_2;
        }
    }
    
    
    
}
