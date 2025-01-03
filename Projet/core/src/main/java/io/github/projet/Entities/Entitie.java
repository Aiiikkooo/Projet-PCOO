package io.github.projet.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import io.github.projet.utile.Constantes;


public abstract class Entitie {
    protected Texture texture;
    protected float hauteur;
    protected float largeur;
    protected float position_x;
    protected float position_y;
    protected float speed;
    protected Rectangle hitbox;
    protected Constantes constantes = new Constantes();

    public Entitie (float position_x, float position_y){
        this.position_x = position_x;
        this.position_y = position_y;
        this.hitbox = new Rectangle(position_x,position_y,largeur*constantes.ajust_hitbox,hauteur*constantes.ajust_hitbox);
    }

    protected void move(float delta){
    }

    protected void update_hitbox(){
        this.setHitbox(new Rectangle(this.getPosition_x(),this.getPosition_y(),this.getLargeur()*constantes.ajust_hitbox,this.getHauteur()*constantes.ajust_hitbox));
    }

    public void update (float delta){
        this.move(delta);
        this.update_hitbox();
    }

    public boolean isOutOfBounds(){
        return (this.position_x + this.getLargeur())<0|| (this.position_y + this.getHauteur())<0 || this.position_x >constantes.largeurFenetre || this.position_y > constantes.hauteurFenetre;
    }



    //getteur_stetteur
    public Texture getTexture(){
        return this.texture;
    }
    public void setTexture(String path_tex_new){
        this.texture= new Texture(path_tex_new);
    }

    public float getSpeed(){
        return this.speed;
    }
    public void setSpeed(float new_speed){
        this.speed= new_speed;
    }

    public float getPosition_x(){
        return this.position_x;
    }
    public void setPosition_x(float new_x){
        this.position_x= new_x;
    }

    public float getPosition_y(){
        return this.position_y;
    }
    public void setPosition_y(float new_y){
        this.position_y= new_y;
    }

    public Rectangle getHitbox (){
        return this.hitbox;
    }
    public void setHitbox(Rectangle new_hitbox){
        this.hitbox= new_hitbox;
    }

    public float getHauteur (){
        return this.hauteur;
    }
    public void setHauteur(float hauteur){
        this.hauteur= hauteur;
    }

    public float getLargeur (){
        return this.largeur;
    }
    public void setLargeur(float largeur){
        this.hauteur= largeur;
    }
}
