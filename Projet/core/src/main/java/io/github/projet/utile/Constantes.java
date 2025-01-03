package io.github.projet.utile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

import java.awt.Rectangle;

public class Constantes {

    //Dimension ecran
    public static int largeurFenetre = Gdx.graphics.getWidth();
    public static int hauteurFenetre = Gdx.graphics.getHeight();

    //texture screens
    public static Texture GS_fond = new Texture("Fond_GS.png");
    public static Texture MS_fond = new Texture("Fond_MS.png");
    public static Texture PS_fond = new Texture("Fond_PS.png");
    public static Texture EGS_fond = new Texture("Fond_EGS.png");



    //utilitaire
    public static float ajust_hitbox = 0.9f;
    public static int nb_enemies_simultane = 4;
    public static TiledMap map = new TmxMapLoader().load("Map_bords.tmx");
    public static MapObjects bord_droite;
    public static MapObjects bord_gauche;
    static {
        bord_droite = map.getLayers().get("Bord_droite").getObjects();
        bord_gauche = map.getLayers().get("Bord_gauche").getObjects();
    }

    //joueur
    public static Texture img_player = new Texture("Joueur.png");
    public static float speed_player = 400f;
    public static float larg_player;
    public static float haut_player;
    public static int health_player = 1;

    static {
        Texture img_player = new Texture("Joueur.png");
        larg_player = img_player.getWidth();
        haut_player = img_player.getHeight();
        img_player.dispose();
    }

    //enemy
    public static Texture img_enemy = new Texture("Enemy.png");
    public static float base_speed_enemy = 60f;
    public static float acceleration_enemy = 2f;

    public static  float larg_enemy;
    public static  float haut_enemy;
    public static int health_enemy = 1;

    static {
        Texture img_enemy = new Texture("Enemy.png");
        larg_enemy = img_enemy.getWidth();
        haut_enemy = img_enemy.getHeight();
        img_enemy.dispose();
    }

    //projectiles
    public static Texture img_proj = new Texture("Projectile.png");
    public static float speed_proj = 280f;

    public static float larg_proj;
    public static float haut_proj;
    static {
        Texture img_proj = new Texture("Projectile.png");
        larg_proj = img_proj.getWidth();
        haut_proj = img_proj.getHeight();
        img_proj.dispose();
    }

    //Cooldown
    public static Cooldown cd_proj = new Cooldown(0.33f);
}
