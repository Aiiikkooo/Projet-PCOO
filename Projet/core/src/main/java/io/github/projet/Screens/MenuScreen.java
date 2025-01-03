package io.github.projet.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

import io.github.projet.Entities.Enemy;
import io.github.projet.Entities.Player;
import io.github.projet.MyGame;
import io.github.projet.utile.Constantes;

public class MenuScreen implements Screen {

    private final MyGame game;
    private Texture fond;
    private Constantes constantes = new Constantes();

    public MenuScreen(MyGame game) {
        this.game = game;
        this.fond = constantes.MS_fond;
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        game.batch.begin();
        game.batch.draw(fond,0f,0f);
        game.font.draw(game.batch, "Welcome to Void Assault!\n   Press ENTER to start", 545, 350);
        game.font.draw(game.batch, "You can PAUSE with SPACE", 530, 315);
        game.batch.end();

        if (Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.ENTER)) {
            ArrayList<Enemy> enemies = new ArrayList<>();
            for (int i=0; i< constantes.nb_enemies_simultane;i++) {
                float randomX = (float) (Math.random() * (constantes.largeurFenetre - constantes.larg_enemy)); // Génère un entier entre 0 et 799;
                enemies.add(new Enemy(randomX,constantes.hauteurFenetre,constantes.base_speed_enemy));
            }
            game.setScreen(new GameScreen(game,new Player( 570f,30f),enemies,new ArrayList<>(),0));
        }
    }


    @Override public void show() {}
    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() {}
}
