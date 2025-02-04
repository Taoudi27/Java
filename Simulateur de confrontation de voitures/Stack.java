
public class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    
    // Constructeur de la pile avec une taille max donnée.
     public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1; // La pile est vide initialement 
    }

   
    public int size() { // retourne la taille actuel de la pile ( nbre d'elements)
        return top + 1;
    }


  
    public void push(int value) { // ajoute element sur la pile, si la pile est pleine,on lance StackOverflowError
        if (top >= maxSize - 1) {
            throw new StackOverflowError("Pile pleine,on ne peux rien ajouter");
        }
        stackArray[++top] = value;
    }

  
    
    public int pop() { // retire dernier element de la pile, si elle est vide on lance IllegalStateException
        if (isEmpty()) {
            throw new IllegalStateException("La pile est vide, on ne peux rien retirer.");
        }
        return stackArray[top--];
    }

   
    public int top() { // retourne dernie relement de la pile sans le retirer, si vide on lance IllegalStateException
        if (isEmpty()) {
            throw new IllegalStateException("La pile est vide, aucun élément à afficher.");
        }
        return stackArray[top];
    }

 
    public boolean isEmpty() { // verifie si pile est vide, renvoie true si vide et false sinon
        return top == -1;
    }

  
    // voici des methode pour tester la classe Stack.java
    public static void main(String[] args) {
        Stack stack = new Stack(4);

        try {
            stack.push(23);
            stack.push(2);
            System.out.println("Top element of the stack: " + stack.top());

            stack.pop();
            stack.pop();

            System.out.println("Is stack empty? " + stack.isEmpty());
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }
}
