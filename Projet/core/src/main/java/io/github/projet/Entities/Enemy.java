package io.github.projet.Entities;

import com.badlogic.gdx.math.Rectangle;

public class Enemy extends Entitie{
    protected int health ;
    public Enemy(float position_x, float position_y,float speed) {
        super(position_x, position_y);
        this.speed = speed;
        this.hauteur = constantes.haut_enemy;
        this.largeur = constantes.larg_enemy;
        this.texture = constantes.img_enemy;
        this.health = constantes.health_enemy;
        this.hitbox = new Rectangle(position_x,position_y,largeur,hauteur);
    }

    @Override
    protected void move(float delta){
        this.setPosition_y(this.position_y - this.speed * delta);
    }

    public int getHealth (){
        return this.health;
    }
    public void setHealth(int health){
        this.health = health;
    }
}
