package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {

    //Screen
    private final Camera camera;
    private final Viewport viewport;

    //Graphics
    private final SpriteBatch batch;
    private final Texture background;
    private BitmapFont font;

    //Timing
    private int backgrTimer;

    //World parameters
    private final int WORLD_WIDTH = 1100;
    private final int WORLD_HEIGHT = 650;

    //Movement & Points instances
    HighScore highScore;
    Player player;

    GameScreen(){
        camera = new OrthographicCamera();
        viewport = new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        background = new Texture("background.jpeg");
        backgrTimer = 0;
        batch = new SpriteBatch();

        highScore = new HighScore();
        font = new BitmapFont();
        player = new Player();
    }

    // Put all logic here
    void Update(float deltaTime)
    {
        player.Update(deltaTime);
    }

    // Put all drawings here
    @Override
    public void render(float deltaTime) {
        batch.begin();
        Update(deltaTime);

        //scrolling background
        backgrTimer++;
        if(backgrTimer % WORLD_HEIGHT == 0){
            backgrTimer = 0;
        }
        batch.draw(background, 0, -backgrTimer, WORLD_WIDTH, WORLD_HEIGHT);
        batch.draw(background, 0, -backgrTimer + WORLD_HEIGHT, WORLD_WIDTH, WORLD_HEIGHT);

        player.Render(deltaTime, batch);

        font.setColor(Color.PINK);
        font.draw(batch, "Points: " + highScore.getScore(), 1017, 642);

        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        batch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    @Override
    public void show() {

    }

}
