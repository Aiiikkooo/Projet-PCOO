package io.github.projet.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

import io.github.projet.MyGame;
import io.github.projet.utile.Constantes;

public class EndGameScreen implements Screen {

    private final MyGame game;
    private Texture fond;
    protected int score;
    private Constantes constantes = new Constantes();



    public EndGameScreen(MyGame game,int score) {
        this.game = game;
        this.fond = constantes.EGS_fond;
        this.score = score;
    }

    public void render(float delta) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        game.batch.begin();
        game.batch.draw(fond,0f,0f);
        game.font.draw(game.batch, "Game Over\nYour Score: "+score+"\nMenu: ENTRER", 570, 400);
        game.batch.end();
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            game.setScreen(new MenuScreen(game));
        }
    }


    @Override
    public void show() {}
    @Override
    public void resize(int width, int height) {}
    @Override
    public void pause() {}
    @Override
    public void resume() {}
    @Override
    public void hide() {}
    @Override
    public void dispose() {}
}
