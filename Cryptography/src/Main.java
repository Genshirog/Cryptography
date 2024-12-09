import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        SceneManager sceneManager = new SceneManager(stage);
        sceneManager.show_login();
        Image icon = new Image(getClass().getResourceAsStream("/logo.png"));
        stage.getIcons().add(icon);
        stage.setTitle("Cryptography");
        stage.show();
    }
}
