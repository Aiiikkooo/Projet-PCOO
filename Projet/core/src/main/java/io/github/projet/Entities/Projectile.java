package io.github.projet.Entities;

public class Projectile extends Entitie{

    public Projectile(float position_x, float position_y) {
        super(position_x, position_y);
        this.speed = constantes.speed_proj;
        this.texture = constantes.img_proj;
        this.largeur = constantes.larg_proj;
        this.hauteur = constantes.haut_proj;
    }


    @Override
    protected void move(float delta) {
        this.setPosition_y(this.getPosition_y() + this.getSpeed() * delta);
    }

    public void update (float delta){
        super.update(delta);
    }
}
