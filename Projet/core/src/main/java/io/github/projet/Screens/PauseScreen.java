package io.github.projet.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

import io.github.projet.Entities.Player;
import io.github.projet.MyGame;
import io.github.projet.utile.Constantes;
import io.github.projet.utile.Sauvegarde;

public class PauseScreen implements Screen{
    private final MyGame game;
    private Sauvegarde save;
    private Constantes constantes = new Constantes();
    private Texture fond;

    public PauseScreen(MyGame game, Sauvegarde save) {
        this.game = game;
        this.save = save;
        this.fond = constantes.PS_fond;
    }


    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        game.batch.begin();
        game.batch.draw(fond,0f,0f);
        game.font.draw(game.batch, "PAUSE MENU\nResume: SPACE\nMenu: ENTRER", 610, 350);
        game.batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            Player joueur = new Player(save.getS_position_x(), save.getS_position_y());
            game.setScreen(new GameScreen(game,joueur,save.getS_enemies(),save.getS_projectiles(),save.getS_score()));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            game.setScreen(new MenuScreen(game));
        }
    }


    @Override public void show() {}
    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() {}
}
