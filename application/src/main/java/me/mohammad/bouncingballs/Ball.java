package me.mohammad.bouncingballs;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Window;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import org.lwjgl.opengl.GL20;

public class Ball extends ApplicationAdapter {

    public Lwjgl3Window window;

    private Texture frame;
    private Batch batch;

    private int incrementX;
    private int incrementY;

    private int speed;
    private int maxX;
    private int maxY;

    @Override
    public void create() {
        frame = new Texture(Gdx.files.internal("Frame.png"));
        batch = new SpriteBatch();

        speed = MathUtils.random(5, 15);

        final Graphics.DisplayMode displayMode = Gdx.graphics.getDisplayMode();
        maxX = displayMode.width;
        maxY = displayMode.height;

        window.setPosition(MathUtils.random(0, maxX), MathUtils.random(0, maxY));

        incrementX = (MathUtils.randomBoolean() ? (MathUtils.randomBoolean() ? (speed / 2) : speed) : MathUtils.randomBoolean() ? (speed / 2) : -speed);
        incrementY = (MathUtils.randomBoolean() ? (MathUtils.randomBoolean() ? (speed / 2) : speed) : MathUtils.randomBoolean() ? (speed / 2) : -speed);

        batch.setColor(MathUtils.random(0f, 1f), MathUtils.random(0f, 1f), MathUtils.random(0f, 1f), 1f);
    }

    @Override
    public void render() {
        if (window == null)
            return;

        final int x = window.getPositionX();
        final int y = window.getPositionY();

        incrementX = (x <= 0) ? speed : (x + frame.getWidth() >= maxX) ? -speed : incrementX;
        incrementY = (y <= 0) ? speed : (y + frame.getHeight() >= maxY) ? -speed : incrementY;
        window.setPosition(x + incrementX, y + incrementY);

        Gdx.gl.glClearColor(0f, 0f, 0f, 0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(frame, 0f, 0f, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
    }

    @Override
    public void resize(final int width, final int height) {
        batch.getProjectionMatrix().setToOrtho2D(0f, 0f, width, height);
    }

    @Override
    public void dispose() {
        frame.dispose();
        batch.dispose();
    }

}
