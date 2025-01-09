package me.mohammad.bouncingballs;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;

public class ApplicationLauncher extends ApplicationAdapter {

    protected static Lwjgl3ApplicationConfiguration configuration;

    static {
        configuration = new Lwjgl3ApplicationConfiguration();
        configuration.setInitialBackgroundColor(Color.CLEAR);
        configuration.setTitle("");
        configuration.setTransparentFramebuffer(true);
        configuration.setResizable(false);
        configuration.setDecorated(false);
        configuration.setWindowPosition(0, 0);
        configuration.setWindowedMode(100, 100);
    }

    public static void main(String[] args) {
        if (StartupHelper.startNewJvmIfRequired())
            return;
        new Lwjgl3Application(new ApplicationLauncher(), configuration);
    }

    @Override
    public void create() {
        final Lwjgl3Application application = (Lwjgl3Application) Gdx.app;
        for (int i = 0; i < 10; i++) {
            final Ball ball = new Ball();
            ball.window = application.newWindow(ball, configuration);
        }
    }

}
