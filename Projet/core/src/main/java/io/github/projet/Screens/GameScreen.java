package io.github.projet.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.MapObjects;

import java.util.ArrayList;
import java.util.Iterator;

import io.github.projet.Entities.Enemy;
import io.github.projet.Entities.Player;
import io.github.projet.Entities.Projectile;
import io.github.projet.MyGame;
import io.github.projet.utile.Constantes;
import io.github.projet.utile.Sauvegarde;

public class GameScreen implements Screen {
    private final MyGame game;
    private Player joueur;
    private ArrayList<Enemy> enemies;
    private ArrayList<Projectile> projectiles;
    private Texture fond;
    private int compt_boucle;
    private int compteur_mort_enemy;
    private int score;
    protected Constantes constantes = new Constantes();



    public GameScreen(MyGame game,Player joueur, ArrayList<Enemy> enemies, ArrayList<Projectile> projectiles,int score) {
        this.game = game;
        this.fond = constantes.GS_fond;
        this.joueur = joueur;
        this.enemies = enemies;
        this.projectiles = projectiles;
        this.score = score;
    }


    //gere l'affichage et evenements
    @Override
    public void render(float delta) {
        // Efface l'écran avec une couleur
        ScreenUtils.clear(0f, 0f, 0f, 0f);//noir

        // Met à jour les positions liées au temps
        update(delta);

        // Dessine les éléments
        game.batch.begin();
        game.batch.draw(fond, 0, 0);
        game.font.draw(game.batch, "Score:" + score, 10, constantes.hauteurFenetre - 10);
        // joueur
        game.batch.draw(joueur.getTexture(), joueur.getPosition_x(), joueur.getPosition_y());
        //enemy
        for (Enemy enemy : enemies) {
            game.batch.draw(enemy.getTexture(), enemy.getPosition_x(), enemy.getPosition_y());
        }
        //projectiles
        for (Projectile p : projectiles) {
            game.batch.draw(p.getTexture(), p.getPosition_x(), p.getPosition_y());
        }
        game.batch.end();


        // Gestion des évenements
        //Pause
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            Sauvegarde save = new Sauvegarde(joueur.getPosition_x(), joueur.getPosition_y(), enemies, projectiles,score);

            game.setScreen(new PauseScreen(game, save));
        }
        //Fin jeu
        if (joueur.getHealth() <= 0) {
            game.setScreen(new EndGameScreen(game,score));
        }

        //gestion des listes et colisions
        Iterator<Enemy> it_e = enemies.iterator();
        compt_boucle = 0;
        while (it_e.hasNext()) {
            Enemy enemy = it_e.next();
            if (enemy.isOutOfBounds()) {
                it_e.remove();
                compt_boucle += 1;
            }
            if (enemy.getHealth() <= 0) {
                it_e.remove();
                compt_boucle += 1;
                score +=1;
            }
            //colision Enemy_joueur
            if (joueur.getHitbox().overlaps(enemy.getHitbox())) {
                joueur.setHealth((joueur.getHealth()) - 1);
                it_e.remove();
                compt_boucle += 1;
            }
            //colision Enemy_projectile
            Iterator<Projectile> it_p = projectiles.iterator();
            while (it_p.hasNext()) {
                Projectile projectile = it_p.next();
                if (projectile.isOutOfBounds()){
                    it_p.remove();
                }
                if (projectile.getHitbox().overlaps(enemy.getHitbox())) {
                    enemy.setHealth((enemy.getHealth()) - 1);
                    it_p.remove();
                }
            }
        }
        //creation de nouveaux ennemies pour chaque ennemie enlevé
        for (int i=0; i<compt_boucle ;i++) {
            float randomX = (float) (Math.random() * (constantes.largeurFenetre - constantes.larg_enemy)); // Génère un entier entre 0 et 799;
            enemies.add(new Enemy(randomX,constantes.hauteurFenetre,constantes.base_speed_enemy + constantes.acceleration_enemy*compteur_mort_enemy));
            compteur_mort_enemy += 1;
        }
    }

    //gère les calcul en fonction du temps
    private void update(float delta) {

        // Gestion des entrées clavier
        //Deplacements joueur & colision bords_joueur
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            for (RectangleMapObject rectObject : constantes.bord_droite.getByType(RectangleMapObject.class)) {
                Rectangle rect = rectObject.getRectangle();
                if (!(joueur.getHitbox().overlaps(rect))) {
                    joueur.update_rigth(delta);
                }
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            for (RectangleMapObject rectObject : constantes.bord_gauche.getByType(RectangleMapObject.class)) {
                Rectangle rect = rectObject.getRectangle();
                if (!(joueur.getHitbox().overlaps(rect))) {
                    joueur.update_left(delta);
                }
            }
        }

        //if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
        //           joueur.update_rigth(delta);
        //}

        //if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
        //    joueur.update_left(delta);
        //}
        // Lancer projectile
        constantes.cd_proj.update(delta);
        if (Gdx.input.isKeyPressed(Input.Keys.TAB)){
            if (constantes.cd_proj.isReady()) {
                projectiles.add(new Projectile(joueur.getPosition_x() + (constantes.larg_player/2f-constantes.larg_proj/2f), joueur.getPosition_y()+ constantes.haut_player));
                constantes.cd_proj.reset();
            }
        }

        // Gestion des deplacements automatiques
        //Enemy
        Iterator<Enemy> it_e = enemies.iterator();
        while (it_e.hasNext()) {
            Enemy enemy = it_e.next();
            enemy.update(delta);
        }
        //Projectiles
        Iterator<Projectile> it_p = projectiles.iterator();
        while (it_p.hasNext()){
            Projectile p = it_p.next();
            p.update(delta);
        }
    }

    @Override public void show() {}
    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() {}
}
