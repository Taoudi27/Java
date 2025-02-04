
import java.util.Stack;

public class CarConfrontation {
    public int[] carconfrontation(int[] a) {
        Stack<Integer> stack = new Stack<>();

        for (int car : a) {
            boolean survived = true;

            // Gestion des collisions
            while (!stack.isEmpty() && stack.peek() > 0 && car < 0) {
                int lastCar = stack.peek();
                
                // Comparaison des poids absolus
                if (Math.abs(lastCar) < Math.abs(car)) {
                    stack.pop(); // La voiture en haut de la pile est détruite
                    continue;    // comparaison
                } else if (Math.abs(lastCar) == Math.abs(car)) {
                    stack.pop(); // Les deux voitures s'annulent
                    survived = false;
                    break;
                } else {
                    survived = false;
                    break;
                }
            }

            // Si la voiture a survécu, on l'empile
            if (survived) {
                stack.push(car);
            }
        }

        // Convertir la pile en tab
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {  // qlq tests
        CarConfrontation cc = new CarConfrontation();

        int[] example1 = {5, 10, -5, -15};
        int[] result1 = cc.carconfrontation(example1);
        System.out.println("Result for [5, 10, -5, -15]: " + java.util.Arrays.toString(result1));

        int[] example2 = {5, 10, -5};
        int[] result2 = cc.carconfrontation(example2);
        System.out.println("Result for [5, 10, -5]: " + java.util.Arrays.toString(result2));

        int[] example3 = {8, -8};
        int[] result3 = cc.carconfrontation(example3);
        System.out.println("Result for [8, -8]: " + java.util.Arrays.toString(result3));
    }
}
