package io.github.projet.Entities;

import com.badlogic.gdx.math.Rectangle;

public class Player extends Entitie{
    protected int health;

    public Player (float position_x,float position_y){
        super(position_x, position_y);
        this.speed = constantes.speed_player;
        this.largeur = constantes.larg_player;
        this.hauteur = constantes.haut_player;
        this.texture = constantes.img_player;
        this.health = constantes.health_player;
        this.hitbox = new Rectangle(position_x,position_y,largeur,hauteur);
    }

    protected void move(String direction, float delta){
        if ( direction == "left"){
            this.setPosition_x(this.position_x - this.speed * delta);
        }
        if ( direction == "rigth"){
            this.setPosition_x(this.position_x + this.speed * delta);
        }

    }

    public void update_left(float delta){
        this.move("left",delta);
        super.update_hitbox();
    }
    public void update_rigth(float delta){
        this.move("rigth",delta);
        super.update_hitbox();
    }
    public int getHealth (){
        return this.health;
    }
    public void setHealth(int health){
        this.health= health;
    }
}
