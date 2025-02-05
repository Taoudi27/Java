import java.util.Random;

class Song {

    int id; // infos pour une chanson
    String title;
    String artist;
    int duration;

    public Song(int id, String title, String artist, int duration) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String toString() {
        return id + ". " + title + " - " + artist + " (" + duration + " sec)";
    }
}

class CircularPlaylist {

    private Song[] playlist;
    private int front;
    private int rear;
    private int maxSize;
    private boolean shuffleMode;
    private boolean repeatMode;
    private int count;  // Keeps track of the number of songs

    public CircularPlaylist(int capacity) {
        this.maxSize = capacity;
        this.playlist = new Song[maxSize];
        this.front = 0;
        this.rear = 0;
        this.shuffleMode = false;
        this.repeatMode = false;
        this.count = 0;
    }

    
    
    
    public void addSong(Song song) { // ajoute chanson a playlist
    	// complexité O(1) temps constant
        if (count == maxSize) {
            System.out.println("playlist pleine"); // si la playlist pleine, on ne peux pas ajouter de chansons
            return;
        }
        playlist[rear] = song;
        rear = (rear + 1) % maxSize; // met a jours rear de maniere circulaire
        count++;
    }
    
    

    public Song playSong() { // permet de jouer la chanson actuelle
    	//comoplexité si shuffle desactivé: O(1) si activé: O(getRandomIndex)
        if (count == 0) {
            System.out.println("aucune chanson a jouer.");
            return null;
        }
        int index = shuffleMode ? getRandomIndex() : front; // index en fonction du mode aleatoire
        Song song = playlist[index];
        if (!repeatMode) {
            front = (front + 1) % maxSize; // passe a la chanson suivante
            count--;
        }
        return song;
    }
    
    

    private int getRandomIndex() { // obtenir index aleatoire en mode shuffle
    	//complexité: O(1), gestion index aleatoire est en temps constant
        Random rand = new Random();
        return (front + rand.nextInt(count)) % maxSize;
    }

    public void nextSong() { // permet de passer a la chanson suivante
    	//complexité: O(1)
        if (count == 0) {
            System.out.println("il nya pas de prochaine chanson.");  // si playlist vide, 
            return;
        }
        front = (front + 1) % maxSize; // avance front de maniere circulaire
    }
    
    

    public void previousSong() { // aller a la chanson precedante
    	//Complexité O(1) carfaut juste decrementer index front
        if (count == 0) {
            System.out.println("Aucune chanson précédente.");
            return;
        }
        front = (front - 1 + maxSize) % maxSize; // Recule front de manière circulaire
    }
    
    

    public void removeSong(int id) { // suprimer chanson de playlist en fonction de son ID
    	//compelxité O(n) car on parcourt n elements pr trouver chanson
        if (count == 0) {
            System.out.println("La playlist est vide.");
            return;
        }
        int index = front;
        for (int i = 0; i < count; i++) {
            if (playlist[index].id == id) {
                // Décale toutes les chansons après celle supprimée
                for (int j = 0; j < count - 1; j++) {
                    playlist[(index + j) % maxSize] = playlist[(index + j + 1) % maxSize];
                }
                playlist[(front + count - 1) % maxSize] = null; // Vide le dernier emplacement
                rear = (rear - 1 + maxSize) % maxSize; // Met à jour rear de manière circulaire
                count--;
                System.out.println("Chanson avec ID " + id + " supprimée.");
                return;
            }
            index = (index + 1) % maxSize;
        }
        System.out.println("Chanson avec ID " + id + " introuvable.");
    }

    
    
    
    public void toggleShuffle() { // activer ou desactiver le mode aleatoire
    	//complexité O(1) basculement booleen
        shuffleMode = !shuffleMode;
        System.out.println("Mode aléatoire : " + (shuffleMode ? "ACTIVÉ" : "DÉSACTIVÉ"));
    }
    
    
    

    public void toggleRepeat() { // activer desactiver le mode repetition
    	//complexité O(1) basculement booleen
        repeatMode = !repeatMode;
        System.out.println("Mode répétition : " + (repeatMode ? "ACTIVÉ" : "DÉSACTIVÉ"));
    }
    
    

    public void displayPlaylist() { // afficher les chansons de la playlist
    	//complexité O(n) car on parcourt les n chansons de la playlist
        if (count == 0) {
            System.out.println("La playlist est vide.");
            return;
        }
        System.out.println("Playlist :");
        int index = front;
        for (int i = 0; i < count; i++) {
            System.out.println(playlist[index]);
            index = (index + 1) % maxSize; // Avance à la chanson suivante de manière circulaire
        }
    
    }


}
