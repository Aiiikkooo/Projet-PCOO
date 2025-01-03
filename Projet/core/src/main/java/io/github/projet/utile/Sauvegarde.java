package io.github.projet.utile;

import com.badlogic.gdx.Screen;

import java.util.ArrayList;

import io.github.projet.Entities.Enemy;
import io.github.projet.Entities.Projectile;

public class Sauvegarde {
    protected ArrayList<Enemy> s_enemies;
    protected ArrayList<Projectile> s_projectiles;
    protected float s_position_x;
    protected float s_position_y;
    protected int s_score;

    public Sauvegarde(float s_position_x,float s_position_y,ArrayList<Enemy> s_enemies,ArrayList<Projectile> s_projectiles,int s_score){
        this.s_position_x = s_position_x;
        this.s_position_y = s_position_y;
        this.s_projectiles = s_projectiles;
        this.s_enemies = s_enemies;
        this.s_score = s_score;
    }


    public float getS_position_x(){
        return this.s_position_x;
    }

    public void setS_position_x(float s_position_x) {
        this.s_position_x = s_position_x;
    }

    public float getS_position_y() {
        return this.s_position_y;
    }

    public void setS_position_y(float s_position_y) {
        this.s_position_y = s_position_y;
    }

    public ArrayList<Enemy> getS_enemies(){
        return this.s_enemies;
    }

    public void setS_enemies(ArrayList<Enemy> s_enemies) {
        this.s_enemies = s_enemies;
    }

    public ArrayList<Projectile> getS_projectiles() {
        return s_projectiles;
    }

    public void setS_projectiles(ArrayList<Projectile> s_projectiles) {
        this.s_projectiles = s_projectiles;
    }

    public int getS_score() {
        return s_score;
    }
}
