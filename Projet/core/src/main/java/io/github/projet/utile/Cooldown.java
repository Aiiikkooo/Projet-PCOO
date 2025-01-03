package io.github.projet.utile;

public class Cooldown {
    private float cooldownTime; // Temps du cooldown en secondes
    private float timer; // Timer interne

    public Cooldown(float cooldownTime) {
        this.cooldownTime = cooldownTime;
        this.timer = 0; // Initialisé à 0, prêt à agir immédiatement
    }

    // Appeler cette méthode dans la boucle de jeu pour réduire le timer
    public void update(float delta) {
        if (timer > 0) {
            timer -= delta;
        }
    }

    // Vérifie si le cooldown est terminé
    public boolean isReady() {
        return timer <= 0;
    }

    // Relancer le cooldown
    public void reset() {
        timer = cooldownTime;
    }
}


