import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.util.StringConverter;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class App{
    private final StackPane root;
    private final String characters = "C G J J M   W M Q J D";
    private String[] levelChar;
    private int levelpoint = 1;
    private final ObservableList<String> savedRow2 = FXCollections.observableArrayList(new String[13]);
    private final ObservableList<String> savedRow4 = FXCollections.observableArrayList(new String[13]);
    private String[] levelAns;
    private final TableView<ObservableList<String>> tableView = new TableView<>();
    private final List<List<String>> userInputs = new ArrayList<>();
    public App(){
        root = new StackPane();
        root.getStyleClass().add("root_form");
        root.getChildren().add(app());  // Add VBox to the root
    }

    public Scene getScene() {
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        return scene;
    }

    public StackPane getRoot(){
        return root;
    }


    public VBox app(){
        Pane overlay = new Pane();
        overlay.getStyleClass().add("overlay");
        root.getChildren().add(overlay);

        VBox main_panel = new VBox();
        main_panel.setAlignment(Pos.TOP_CENTER);  // Centers the children in the VBox
        main_panel.setPrefHeight(600);
        main_panel.setMaxHeight(700);// Limit to the scene's height or adjust as necessary
        main_panel.setMaxWidth(1200);// You can also set maxWidth or adjust to your layout needs

        HBox logo_container = new HBox(50);
        logo_container.setAlignment(Pos.CENTER);
        Pane logo = new Pane();
        logo.getStyleClass().add("logo_app");
        HBox.setMargin(logo,new Insets(0,0,0,-100));

        VBox title2_container = new VBox();
        title2_container.setAlignment(Pos.TOP_CENTER);
        title2_container.setPrefHeight(300);
        title2_container.setMaxHeight(500);
        title2_container.setMaxWidth(1200);

        Label title = new Label("Cryptography");
        Label title2 = new Label("Game");
        title.getStyleClass().add("title_app");
        title2.getStyleClass().add("title_app");

        HBox button_container = new HBox(100);
        Button play = new Button("PLAY");
        play.setOnAction(event->{
            root.getStyleClass().remove("root_form");
            root.getStyleClass().add("root_app");
            root.getChildren().clear();
            root.getChildren().add(play());
        });
        Button tutorial = new Button("TUTORIAL");
        tutorial.setOnAction(event->{
            root.getStyleClass().remove("root_form");
            root.getStyleClass().add("root_app");
            root.getChildren().clear();
            root.getChildren().add(tutorial_scene());
        });
        Button about = new Button("ABOUT");
        about.setOnAction(event ->{
            root.getStyleClass().remove("root_form");
            root.getStyleClass().add("root_app");
            root.getChildren().clear();
            root.getChildren().add(about());

        });
        play.getStyleClass().add("buttons_app");
        tutorial.getStyleClass().add("buttons_app");
        about.getStyleClass().add("buttons_app");
        button_container.setAlignment(Pos.BOTTOM_CENTER);
        button_container.setMaxWidth(1200);
        button_container.setMaxHeight(300);
        button_container.getChildren().addAll(play,tutorial,about);

        logo_container.getChildren().addAll(logo,title);
        title2_container.getChildren().add(title2);
        main_panel.getChildren().addAll(logo_container,title2_container,button_container);
        return main_panel;
    }

    public VBox about(){
        VBox main_container = new VBox();
        main_container.getStyleClass().add("main_container");

        VBox back_container = new VBox();
        Button back = new Button("BACK");
        back_container.getStyleClass().add("back");
        back.getStyleClass().add("back_button");
        back.setOnAction(event ->{
            root.getStyleClass().remove("root_app");
            root.getStyleClass().add("root_form");
            root.getChildren().clear();
            root.getChildren().add(app());
        });
        VBox title_container = new VBox();
        title_container.getStyleClass().add("title_container");

        Label title = new Label("Cryptography Game");
        title.getStyleClass().add("title_app");

        VBox scroll_content = new VBox();
        scroll_content.setAlignment(Pos.TOP_CENTER);
        scroll_content.getStyleClass().add("scroll-pane");
        VBox about_us = new VBox();
        Label about = new Label("ABOUT US:");
        about.getStyleClass().add("labels_app");
        about_us.getStyleClass().add("title_page");

        TextArea about_us_content = new TextArea();
        about_us_content.setText("""
Welcome to Cryptography Game! This game was created by Tom German G. Arizobal and Jedrick Saniel as their final project for the subject Data Structures and Algorithm.

The purpose of this game is educational: it serves as an introduction to cryptography for beginners while also providing a fun and engaging way to relieve boredom. By solving our simple puzzles, players can enhance their deductive reasoning and critical thinking skills—important abilities for real-life applications.

Although designed as a simple game, it has a deeper objective. Once players master the game, they will learn to encrypt and decrypt messages using basic cryptography techniques, such as:

Keyword Cipher: A method where a keyword determines how letters are substituted in a message.
Substitution Cipher: A technique where each letter in the plaintext is replaced with a corresponding letter based on a fixed rule.
Players are also encouraged to explore advanced cryptography concepts like hashing (used for securing passwords) or AES (Advanced Encryption Standard), which is commonly used for secure data transmission. This journey will build their confidence and skills, allowing them to engage in cryptography communities or create their own encrypted challenges.

For the development of this game, we used:

Canva for design,
Java for the graphical user interface (GUI) and core functionality, and
XAMPP to store user progress and information.
Thank you for exploring Cryptography Game, and we hope it sparks your interest in the fascinating world of cryptography. Whether you're here to learn, have fun, or both, we believe you'll enjoy the experience!""");
        about_us_content.setWrapText(true);
        about_us_content.setEditable(false);
        about_us_content.getStyleClass().add("textarea");
        back_container.getChildren().add(back);
        scroll_content.getChildren().add(about_us_content);
        about_us.getChildren().addAll(about);
        title_container.getChildren().addAll(title);
        main_container.getChildren().addAll(back_container,title_container,about_us,scroll_content);
        return main_container;
    }

    public void setCharacter(int level){
        switch (level){
            case 1:
                levelChar =  new String[] {"A M M S","K M P L D L A"};
                break;
            case 2:
                levelChar =  new String[]{"R C L Q T N O","Q B O","S G C A"};
                break;
            case 3:
                levelChar =  new String[]{"Y N Q N","P Q M S W Q S M O"};
                break;
            case 4:
                levelChar =  new String[]{"Q U L Q S M S U S M J F","G M K H R P"};
            default:
                break;
        }
    }

    public void setAnswer(int level){
        switch (level){
            case 1:
                levelAns =  new String[] {"G O O D","M O R N I N G"};
                break;
            case 2:
                levelAns =  new String[]{"C A P T U R E", "T H E", "F L A G"};
                break;
            case 3:
                levelAns =  new String[]{"D A T A","S T R U C T U R E"};
                break;
            case 4:
                levelAns =  new String[]{"S U B S T I T U T I O N","C I P H E R"};
            default:
                break;
        }
    }

    public String[] getCharacters(){
        return levelChar;
    }

    public String[] getAns(){
        return  levelAns;
    }

    public VBox play(){
        setLevel(levelpoint);
        setCharacter(getLevel());
        VBox main_container = new VBox();
        main_container.getStyleClass().add("play_main");

        HBox panel_container = new HBox(50);
        panel_container.getStyleClass().add("play_panel");

        VBox key = new VBox();
        key.getStyleClass().add("play_box");

        VBox key_title = new VBox();
        Label keyTitle = new Label("KEYWORD TEXT");
        key_title.getStyleClass().add("play_key");

        VBox encrypt = new VBox();
        encrypt.getStyleClass().add("play_box");

        VBox encrypt_title = new VBox();
        Label encryptTitle = new Label("ENCRYPTED TEXT");
        encrypt_title.getStyleClass().add("play_key");

        VBox encrypt_content = new VBox();
        encrypt_content.getStyleClass().add("play_encrypt_content");

        VBox messageContainer = new VBox(5); // Vertical container for each line of characters
        messageContainer.getStyleClass().add("play_encrypt_message");
        messageContainer.setAlignment(Pos.CENTER);

        VBox answerContainer = new VBox(5); // Vertical container for the corresponding input fields
        answerContainer.getStyleClass().add("play_encrypt_answer");
        answerContainer.setAlignment(Pos.CENTER);

        VBox nextPage = new VBox();
        Button next = new Button("NEXT");
        nextPage.getStyleClass().add("next_tutorial");
        next.getStyleClass().add("next_btn");
        next.setOnAction(event -> {
            if (validateInputs(answerContainer)) {
                levelpoint++;
                savedRow2.clear();
                savedRow4.clear();
                userInputs.clear();
                root.getChildren().clear();
                root.getChildren().add(play());
                if(levelpoint > 4){
                    JOptionPane.showMessageDialog(null,"Congratulations you finished the game");
                    System.exit(0);
                }
            } else {
                JOptionPane.showMessageDialog(null,"Please fill all fields correctly.");
            }
        });

        for (int i = 0; i < getCharacters().length; i++) {
            String line = getCharacters()[i];
            HBox lineMessage = new HBox(5); // Horizontal container for characters
            HBox lineAnswer = new HBox(2); // Horizontal container for input fields
            lineMessage.setAlignment(Pos.CENTER);
            lineAnswer.setAlignment(Pos.CENTER);
            if (userInputs.size() <= i) {
                userInputs.add(new ArrayList<>());
            }
            List<String> currentLineInputs = userInputs.get(i);
            for (int j = 0; j < line.length(); j++) {
                final int index = j;
                char c = line.charAt(j);
                if (c == ' ') {
                    // Add empty space for spaces in the string
                    Label spaceLabel = new Label(" ");
                    spaceLabel.getStyleClass().add("play_contents_message_level");
                    lineMessage.getChildren().add(spaceLabel);
                    lineAnswer.getChildren().add(new Label(" "));
                } else {
                    // Add character label to the top row
                    Label charLabel = new Label(String.valueOf(c));
                    charLabel.getStyleClass().add("play_contents_message_level");
                    lineMessage.getChildren().add(charLabel);

                    // Add TextField to the bottom row
                    TextField inputField = new TextField();
                    inputField.getStyleClass().add("play_contents_answer_level");
                    inputField.textProperty().addListener((observable, oldValue, newValue) -> {
                        if (newValue.length() == 1) {
                            inputField.setText(newValue.toUpperCase());
                        }
                        if (newValue.length() > 1) {
                            inputField.setText(oldValue);
                        }
                    });
                    if (currentLineInputs.size() > j) {
                        inputField.setText(currentLineInputs.get(j));  // Set saved input
                    }

                    // Save the user input when it changes
                    inputField.textProperty().addListener((observable, oldValue, newValue) -> {
                        if (newValue.length() == 1 || newValue.isEmpty()) {
                            if (currentLineInputs.size() <= index) {
                                currentLineInputs.add(newValue);  // Add new value to list
                            } else {
                                currentLineInputs.set(index, newValue);  // Update existing value
                            }
                        }
                    });
                    lineAnswer.getChildren().add(inputField);
                }
            }
            messageContainer.getChildren().add(lineMessage);
            answerContainer.getChildren().add(lineAnswer);
        }



        VBox button_container = new VBox();
        button_container.getStyleClass().add("play_button");
        Button table = new Button("TABLE");
        table.getStyleClass().add("table_button");
        table.setOnAction(event ->{
            root.getChildren().clear();
            root.getChildren().add(play_table());
        });
        VBox back_container = new VBox();
        Button back = new Button("BACK");
        back_container.getStyleClass().add("back");
        back.getStyleClass().add("back_button");
        back.setOnAction(event ->{
            if(levelpoint > 1) {
                levelpoint--;
                userInputs.clear();
                root.getChildren().clear();
                root.getChildren().add(play());
            }else{
                userInputs.clear();
                root.getStyleClass().remove("root_app");
                root.getStyleClass().add("root_form");
                root.getChildren().clear();
                root.getChildren().add(app());
            }
        });

        back_container.getChildren().add(back);
        nextPage.getChildren().add(next);
        encrypt_content.getChildren().addAll(messageContainer,answerContainer);
        encrypt_title.getChildren().add(encryptTitle);
        encrypt.getChildren().addAll(encrypt_title,encrypt_content,nextPage);
        key_title.getChildren().add(keyTitle);
        key.getChildren().addAll(key_title,getKeyContent(getLevel()));
        button_container.getChildren().add(table);
        panel_container.getChildren().addAll(key,encrypt);
        main_container.getChildren().addAll(back_container,panel_container,button_container);
        return main_container;
    }

    private boolean validateInputs(VBox answerContainer) {
        boolean allCorrect = true;
        setAnswer(getLevel());
        // Compare each input field with the corresponding character in the answer
        for (int i = 0; i < getAns().length; i++) {
            String line = getAns()[i];
            HBox answerRow = (HBox) answerContainer.getChildren().get(i);

            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) != ' ') {
                    TextField inputField = (TextField) answerRow.getChildren().get(j);
                    char expectedChar = line.charAt(j);
                    String userInput = inputField.getText().trim();

                    // Check if input matches the expected character
                    if (userInput.isEmpty() || userInput.charAt(0) != expectedChar) {
                        allCorrect = false;
                    }
                }
            }
        }

        return allCorrect;
    }

    public void setLevel(int level){
        levelpoint = level;
    }

    public int getLevel(){
        return levelpoint;
    }
    public String key_content(int level){
        switch (level){
            case 1:
                return """
                At a quiet park on a sunny afternoon, I was strolling down the path when I spotted a vendor selling ice cream. I couldn't resist and decided to grab a cone with chocolate and vanilla swirls. Nearby, a woman was holding a colorful balloon, and her child was playing with a frisbee. As I enjoyed my treat, I thought about how much I loved the feeling of the cool breeze on a hot day. As I glanced around, I noticed something interesting: a frisbee on the ground with a design of a chocolate swirl.
                """;
            case 2:
                return """
                On a quiet evening at the beach, a woman sat on a rock, watching the waves roll in. The sky was a mix of pink and orange as the sun set. Seagulls flew overhead, calling to each other. As she looked around, she noticed a small, old box half-buried in the sand. Curious, she picked it up and opened it. Inside was a folded piece of paper with a single word written on it, glowing softly in the last light of the day.
                """;
            default:
                return null;
        }
    }

    public Node getKeyContent(int level) {
        if (level < 3) {
            return getTextArea_Content(level); // Return the TextArea for levels 1 and 2
        } else if(level == 3) {
            return getImageView(level); // Return the ImageView for levels 3 and 4
        } else{
            return getTableFour(level);
        }
    }

    public TextArea getTextArea_Content(int level) {
        TextArea keyContent = new TextArea();
        keyContent.setWrapText(true);
        keyContent.setEditable(false);
        keyContent.getStyleClass().add("play_key_content");

        // Set text based on the level
        if (level == 1) {
            keyContent.setText(key_content(1)); // Add your key_content(level) logic here
        } else if (level == 2) {
            keyContent.setText(key_content(2));
        }

        return keyContent;
    }

    public ImageView getImageView(int level) {
        ImageView imageView = new ImageView();
        imageView.getStyleClass().add("play_key_image");

        // Set the image based on the level
        if (level == 3) {
            imageView.setImage(new Image(getClass().getResource("new_york.jpg").toExternalForm()));
        }

        // Configure image size
        imageView.setFitWidth(450);
        imageView.setFitHeight(500);
        imageView.setPreserveRatio(false);

        return imageView;
    }

    public TableView getTableFour(int level) {
        TableView tableView = new TableView();
        tableView.setEditable(false);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setFixedCellSize(47);
        tableView.setPrefHeight(tableView.getFixedCellSize() * 4 + 28.5);
        tableView.setMaxHeight(tableView.getFixedCellSize() * 4 + 28.5);
        tableView.setTableMenuButtonVisible(false);
        tableView.getStyleClass().add("table_four");

        for (int i = 0; i < 10; i++) {
            TableColumn<ObservableList<String>, String> column = new TableColumn<>();
            final int colIndex = i;
            column.setSortable(false);
            column.setReorderable(false);
            column.setResizable(false);
            column.getStyleClass().add("columns");
            column.setCellValueFactory(data ->
                    new javafx.beans.property.SimpleStringProperty(data.getValue().get(colIndex))
            );

            column.setPrefWidth(45);  // Reduced cell width
            column.setMaxWidth(45);
            tableView.getColumns().add(column);
            ObservableList<ObservableList<String>> rows = FXCollections.observableArrayList();

            // First row (A-M)
            ObservableList<String> row1 = FXCollections.observableArrayList("A","D","E","B","U","G","D","B","A","E");
            rows.add(row1);

            // Second row (empty)
            ObservableList<String> row2 = FXCollections.observableArrayList("X", "L", "O", "O", "P", "V", "A", "D", "P", "G");
            rows.add(row2);

            // Third row (N-Z)
            ObservableList<String> row3 = FXCollections.observableArrayList("F","L","G","P","M","E","T","H","O","D");
            rows.add(row3);

            // Fourth row (empty)
            ObservableList<String> row4 = FXCollections.observableArrayList("M", "A", "P", "O", "Z", "O", "A", "B", "M", "K");
            rows.add(row4);

            ObservableList<String> row5 = FXCollections.observableArrayList("H", "T", "R", "I", "R", "H", "A", "T", "C", "B");
            rows.add(row5);

            ObservableList<String> row6 = FXCollections.observableArrayList("Y", "C", "L", "N", "C", "I", "M", "A", "O", "N");
            rows.add(row6);

            ObservableList<String> row7 = FXCollections.observableArrayList("H", "E", "D", "T", "F", "L", "T", "Y", "S", "F");
            rows.add(row7);

            ObservableList<String> row8 = FXCollections.observableArrayList("H", "J", "C", "E", "T", "S", "I", "H", "B", "F");
            rows.add(row8);

            ObservableList<String> row9 = FXCollections.observableArrayList("M", "B", "I", "R", "N", "E", "M", "A", "M", "K");
            rows.add(row9);

            ObservableList<String> row10 = FXCollections.observableArrayList("K", "o" ,"F", "U", "N", "C", "T", "I", "O", "N");
            rows.add(row10);
            tableView.setRowFactory(tv -> {
                TableRow<ObservableList<String>> row = new TableRow<>();
                row.setStyle("-fx-background-color: rgba(89, 89, 89, 1); -fx-border-color: white; -fx-border-width: 1px;");
                return row;
            });
            tableView.setItems(rows);

        }
        return tableView;
    }

    public VBox tutorial_scene(){
        VBox main_container = new VBox();
        main_container.getStyleClass().add("main_container");

        VBox back_container = new VBox();
        Button back = new Button("BACK");
        back_container.getStyleClass().add("back");
        back.getStyleClass().add("back_button");
        back.setOnAction(event ->{
            root.getStyleClass().remove("root_app");
            root.getStyleClass().add("root_form");
            root.getChildren().clear();
            root.getChildren().add(app());
        });
        VBox title_container = new VBox();
        title_container.getStyleClass().add("title_container");

        Label title = new Label("Cryptography Game");
        title.getStyleClass().add("title_app");

        VBox scroll_content = new VBox();
        scroll_content.setAlignment(Pos.TOP_CENTER);
        scroll_content.getStyleClass().add("scroll-pane");
        VBox tutorial = new VBox();
        Label tutorial_label = new Label("TUTORIAL:");
        tutorial_label.getStyleClass().add("labels_app");
        tutorial.getStyleClass().add("title_page");

        TextArea about_us_content = new TextArea();
        about_us_content.setText("""
A keyword puzzle is a type of substitution cipher in which a keyword is used to rearrange the alphabet for encoding. In a broader substitution cipher, any system of letter substitutions can be used, and the keyword puzzle is simply one specific example of this technique.

A substitution cipher involves replacing each letter in the plaintext with another letter. A keyword puzzle is a specific form of substitution cipher where the alphabet is rearranged based on a keyword to create the substitution pattern. It is a more structured version of the general substitution cipher.

In a substitution cipher, you must remove any repeating letters from the keyword. For example, if the keyword is "DEBATE," the repeating letter is "E." We remove the extra "E," keeping only the first one. The resulting key would be "DEBAT," which we can use to encrypt and decrypt messages""");
        about_us_content.setWrapText(true);
        about_us_content.setEditable(false);
        about_us_content.getStyleClass().add("textarea");

        VBox next_container = new VBox();
        Button next = new Button("NEXT");
        next_container.getStyleClass().add("next");
        next.getStyleClass().add("next_btn");
        next.setOnAction(event ->{
            root.getChildren().clear();
            root.getChildren().add(tutorial_scene_continue());
        });
        next_container.getChildren().add(next);
        back_container.getChildren().add(back);
        scroll_content.getChildren().add(about_us_content);
        tutorial.getChildren().addAll(tutorial_label);
        title_container.getChildren().addAll(title);
        main_container.getChildren().addAll(back_container,title_container,tutorial,scroll_content,next_container);
        return main_container;
    }

    public VBox tutorial_scene_continue(){
        VBox main_container = new VBox();
        main_container.getStyleClass().add("play_main");

        VBox back_container = new VBox();
        Button back = new Button("BACK");
        back_container.getStyleClass().add("back");
        back.getStyleClass().add("back_button");
        back.setOnAction(event ->{
            root.getChildren().clear();
            root.getChildren().add(tutorial_scene());
        });

        HBox panel_container = new HBox(50);
        panel_container.getStyleClass().add("play_panel");

        VBox key = new VBox();
        key.getStyleClass().add("play_box");

        VBox key_title = new VBox();
        Label keyTitle = new Label("KEYWORD TEXT");
        key_title.getStyleClass().add("play_key");

        TextArea key_content = new TextArea();
        key_content.setText("""
                At a bustling food truck, I was so hungry that I quickly ordered a burger and fries. Nearby, a kid eagerly asked for a hotdog, but the lady at the counter sighed and said, "Sorry, we're out of hotdogs."
                As I finished my meal, I remembered I needed to grab the keys from the car. However, the thought of the hotdog lingered in my mind. Suddenly, I recalled something peculiar about my keychain—it was shaped like a hotdog.
                """);
        key_content.setWrapText(true);
        key_content.setEditable(false);
        key_content.getStyleClass().add("play_key_content");

        VBox encrypt = new VBox();
        encrypt.getStyleClass().add("play_box");

        VBox encrypt_title = new VBox();
        Label encryptTitle = new Label("ENCRYPTED TEXT");
        encrypt_title.getStyleClass().add("play_key");

        VBox encrypt_content = new VBox();
        encrypt_content.getStyleClass().add("play_encrypt_content");

        HBox message = new HBox(5.5);
        message.getStyleClass().add("play_encrypt_message");
        HBox answer = new HBox(2);
        answer.getStyleClass().add("play_encrypt_answer");
        for (char c : characters.toCharArray()) {
            if (c == ' ') {
                // Add empty space for spaces in the string
                Label spaceLabel = new Label(" ");
                spaceLabel.getStyleClass().add("play_contents_message");
                message.getChildren().add(spaceLabel);
                answer.getChildren().add(new Label(" "));
            } else {
                // Add character label to the top row
                Label charLabel = new Label(String.valueOf(c));
                charLabel.getStyleClass().add("play_contents_message");
                message.getChildren().add(charLabel);

                // Add TextField to the bottom row
                TextField inputField = new TextField();
                inputField.getStyleClass().add("play_contents_answer");
                inputField.textProperty().addListener((observable,oldValue,newValue) ->{
                    if(newValue.length() == 1){
                        inputField.setText(newValue.toUpperCase());
                    }
                    if(newValue.length() > 1){
                        inputField.setText(oldValue);
                    }
                });
                answer.getChildren().add(inputField);
            }
        }

        VBox nextPage = new VBox();
        Button next = new Button("NEXT");
        nextPage.getStyleClass().add("next_tutorial");
        next.getStyleClass().add("next_btn");
        next.setOnAction(event->{
            JOptionPane.showMessageDialog(null,"Click on the table button to proceed to the next stage");
        });

        VBox button_container = new VBox();
        button_container.getStyleClass().add("play_button");
        Button table = new Button("TABLE");
        table.getStyleClass().add("table_button");
        table.setOnAction(event ->{
            root.getChildren().clear();
            root.getChildren().add(table_tutorial());
        });

        back_container.getChildren().add(back);
        nextPage.getChildren().add(next);
        encrypt_content.getChildren().addAll(message,answer);
        encrypt_title.getChildren().add(encryptTitle);
        encrypt.getChildren().addAll(encrypt_title,encrypt_content,nextPage);
        key_title.getChildren().add(keyTitle);
        key.getChildren().addAll(key_title,key_content);
        button_container.getChildren().add(table);
        panel_container.getChildren().addAll(key,encrypt);
        main_container.getChildren().addAll(back_container,panel_container,button_container);
        return main_container;
    }

    public VBox table_tutorial(){
        VBox main_container = new VBox();
        main_container.getStyleClass().add("main_container");
        VBox back_container = new VBox();
        Button back = new Button("BACK");
        back_container.getStyleClass().add("back");
        back.getStyleClass().add("back_button");
        back.setOnAction(event ->{
            root.getChildren().clear();
            root.getChildren().add(tutorial_scene_continue());
        });
        VBox title_container = new VBox();
        title_container.getStyleClass().add("title_container");

        Label title = new Label("Cryptography Game");
        title.getStyleClass().add("title_app");

        VBox tutorial = new VBox();
        Label tutorial_label = new Label("TUTORIAL:");
        tutorial_label.getStyleClass().add("labels_app");
        tutorial.getStyleClass().add("title_page");

        VBox table = new VBox();
        TableView<ObservableList<String>> tableView = new TableView<>();
        //change to true on play
        tableView.setEditable(false);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setFixedCellSize(45);
        tableView.setPrefHeight(tableView.getFixedCellSize() * 4 + 28.5);
        tableView.setMaxHeight(tableView.getFixedCellSize() * 4 + 28.5);
        tableView.setTableMenuButtonVisible(false);
        tableView.getStyleClass().add("table-view");
        table.getStyleClass().add("table");
        // Create columns dynamically
        for (int i = 0; i < 13; i++) {
            TableColumn<ObservableList<String>, String> column = new TableColumn<>();
            final int colIndex = i;
            column.setSortable(false);
            column.setReorderable(false);
            column.setResizable(false);
            column.getStyleClass().add("columns");
            column.setCellValueFactory(data ->
                    new javafx.beans.property.SimpleStringProperty(data.getValue().get(colIndex))
            );

            column.setPrefWidth(58);  // Reduced cell width
            column.setMaxWidth(58);
            column.setCellFactory(tc -> new TextFieldTableCell<ObservableList<String>, String>(new StringConverter<String>() {
                @Override
                public String toString(String object) {
                    return object.toUpperCase(); // Simply return the string as is
                }

                @Override
                public String fromString(String string) {
                    return string; // Return the string entered by the user
                }
            }) {
                @Override
                public void startEdit() {
                    if (getTableRow().getIndex() == 1 || getTableRow().getIndex() == 3) {
                        super.startEdit();

                    }
                }

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!empty && (getTableRow().getIndex() != 1 && getTableRow().getIndex() != 3)) {
                        setStyle("-fx-background-color: rgba(54, 54, 54, 0.3)");
                        setStyle("-fx-alignment: center");
                    } else {
                        setStyle("");
                        setStyle("-fx-alignment: center");
                    }

                }

                @Override
                public void commitEdit(String newValue) {
                    // Ensure the input is only one character
                    if (newValue.length() > 1) {
                        newValue = newValue.substring(0, 1);  // Truncate to the first character
                    }
                    super.commitEdit(newValue);  // Commit the edit with the truncated value
                }
            });

            column.setOnEditCommit(event -> {
                ObservableList<String> row = event.getRowValue(); // Get the row data
                row.set(event.getTablePosition().getColumn(), event.getNewValue()); // Update the cell data


            });

            tableView.getColumns().add(column);
        }

        // Add rows dynamically
        ObservableList<ObservableList<String>> rows = FXCollections.observableArrayList();

        // First row (A-M)
        ObservableList<String> row1 = FXCollections.observableArrayList();
        for (char c = 'A'; c <= 'M'; c++) {
            row1.add(String.valueOf(c));
        }
        rows.add(row1);

        // Second row (empty)
        ObservableList<String> row2 = FXCollections.observableArrayList();
        for (int i = 0; i < 13; i++) {
            row2.add("");
        }
        rows.add(row2);

        // Third row (N-Z)
        ObservableList<String> row3 = FXCollections.observableArrayList();
        for (char c = 'N'; c <= 'Z'; c++) {
            row3.add(String.valueOf(c));
        }
        rows.add(row3);

        // Fourth row (empty)
        ObservableList<String> row4 = FXCollections.observableArrayList();
        for (int i = 0; i < 13; i++) {
            row4.add("");
        }
        rows.add(row4);

        tableView.setItems(rows);

        tableView.setRowFactory(tv -> {
                    TableRow<ObservableList<String>> row = new TableRow<>();
                    row.setStyle("");  // Default style
                    row.indexProperty().addListener((observable, oldValue, newValue) -> {
                        if (newValue.intValue() == 0 || newValue.intValue() == 2) {
                            row.setStyle("-fx-background-color: rgba(94, 23, 235, 1);");  // Row 0 and row 2
                        } else {
                            row.setStyle("-fx-background-color: rgba(0,0,59)");  // Default color for row 1 and row 3
                        }
                    });
                    return row;
                });
        // Add the TableView to the VBox

        back_container.getChildren().add(back);
        table.getChildren().add(tableView);
        tutorial.getChildren().addAll(tutorial_label);
        title_container.getChildren().addAll(title);
        main_container.getChildren().addAll(back_container,title_container,tutorial,table,key(1),next(1));
        Platform.runLater(() ->{
            JOptionPane.showMessageDialog(null, """
                Welcome to the Cipher Table. Here you will learn how to encrpyt and decrypt messages using a keyword
                At the bottom of the screen is the key you found on the previous page which is hotdog""");
        });
        return main_container;
    }

    public VBox play_table() {
        VBox main_container = new VBox();
        main_container.getStyleClass().add("main_container");

        VBox back_container = new VBox();
        Button back = new Button("BACK");
        back_container.getStyleClass().add("back");
        back.getStyleClass().add("back_button");
        back.setOnAction(event -> {
            saveUserInputs(); // Save user inputs before switching views
            root.getChildren().clear();
            root.getChildren().add(play());
        });

        VBox title_container = new VBox();
        title_container.getStyleClass().add("title_container");

        Label title = new Label("Cryptography Game");
        title.getStyleClass().add("title_app");

        VBox table = new VBox();

        tableView.setEditable(true);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setFixedCellSize(45);
        tableView.setPrefHeight(tableView.getFixedCellSize() * 4 + 28.5);
        tableView.setMaxHeight(tableView.getFixedCellSize() * 4 + 28.5);
        tableView.setTableMenuButtonVisible(false);
        tableView.getStyleClass().add("table-view");
        table.getStyleClass().add("table");

        // Create columns dynamically
        for (int i = 0; i < 13; i++) {
            TableColumn<ObservableList<String>, String> column = new TableColumn<>();
            final int colIndex = i;
            column.setSortable(false);
            column.setReorderable(false);
            column.setResizable(false);
            column.getStyleClass().add("columns");

            column.setCellValueFactory(data ->
                    new SimpleStringProperty(data.getValue().get(colIndex))
            );

            column.setPrefWidth(58);
            column.setMaxWidth(58);
            column.setCellFactory(tc -> new TextFieldTableCell<>(new StringConverter<String>(){
                @Override
                public String toString(String object) {
                    return object != null ? object.toUpperCase() : "";
                }

                @Override
                public String fromString(String string) {
                    return string != null ? string : "";
                }
            }) {
                @Override
                public void startEdit() {
                    if (getTableRow().getIndex() == 1 || getTableRow().getIndex() == 3) {
                        super.startEdit();
                    }
                }

                @Override
                public void commitEdit(String newValue) {
                    if (newValue.length() > 1) {
                        newValue = newValue.substring(0, 1);
                    }
                    super.commitEdit(newValue);
                }
            });

            column.setOnEditCommit(event -> {
                ObservableList<String> row = event.getRowValue();
                row.set(event.getTablePosition().getColumn(), event.getNewValue());

                int rowIndex = event.getTablePosition().getRow();
                if (rowIndex == 1) {
                    savedRow2.setAll(row); // Update savedRow2
                } else if (rowIndex == 3) {
                    savedRow4.setAll(row); // Update savedRow4
                }
            });

            tableView.getColumns().add(column);
        }

        // Initialize rows
        ObservableList<ObservableList<String>> rows = FXCollections.observableArrayList();

        ObservableList<String> row1 = FXCollections.observableArrayList();
        for (char c = 'A'; c <= 'M'; c++) {
            row1.add(String.valueOf(c));
        }
        rows.add(row1);

        ObservableList<String> row2 = (savedRow2.isEmpty())
                ? FXCollections.observableArrayList(new String[13]) // Ensure 13 empty cells
                : FXCollections.observableArrayList(savedRow2); // Use saved state
        rows.add(row2);

        ObservableList<String> row3 = FXCollections.observableArrayList();
        for (char c = 'N'; c <= 'Z'; c++) {
            row3.add(String.valueOf(c));
        }
        rows.add(row3);

        ObservableList<String> row4 = (savedRow4.isEmpty())
                ? FXCollections.observableArrayList(new String[13]) // Ensure 13 empty cells
                : FXCollections.observableArrayList(savedRow4); // Use saved state
        rows.add(row4);
        tableView.setItems(rows);

        tableView.setRowFactory(tv -> {
            TableRow<ObservableList<String>> row = new TableRow<>();
            row.indexProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue.intValue() == 0 || newValue.intValue() == 2) {
                    row.setStyle("-fx-background-color: rgba(94, 23, 235, 1);");
                } else {
                    row.setStyle("-fx-background-color: rgba(0, 0, 59);");
                }
            });
            return row;
        });

        back_container.getChildren().add(back);
        table.getChildren().add(tableView);
        title_container.getChildren().add(title);
        main_container.getChildren().addAll(back_container, title_container, table);
        return main_container;
    }

    // Save user inputs for rows 2 and 4
    private void saveUserInputs() {
        ObservableList<ObservableList<String>> items = tableView.getItems();
        savedRow2.setAll(items.get(1));
        savedRow4.setAll(items.get(3));
    }

    public VBox key(int val){
        VBox key = new VBox();
        Label keyword = new Label(title(val));
        key.getStyleClass().add("key_table");
        key.getChildren().add(keyword);
        return key;
    }

    public String title(int val){
        if(val == 1){
            return "\"HOTDOG\"";
        }else{
            return "\"HOTDG\"";
        }
    }

    public VBox next(int val){
        if(val == 1) {
            VBox next_container = new VBox();
            Button next = new Button("NEXT");
            next_container.getStyleClass().add("next");

            next.getStyleClass().add("next_btn");
            next.setOnAction(event -> {
                root.getChildren().clear();
                root.getChildren().add(table_tutorial_answer());
            });
            next_container.getChildren().add(next);
            return next_container;
        } else{
            VBox next_container = new VBox();
            Button next = new Button("NEXT");
            next_container.getStyleClass().add("next");

            next.getStyleClass().add("next_btn");
            next.setOnAction(event -> {
                root.getChildren().clear();
                root.getChildren().add(answered());
            });
            next_container.getChildren().add(next);
            return next_container;
        }
    }

    public VBox table_tutorial_answer(){
        VBox main_container = new VBox();
        main_container.getStyleClass().add("main_container");

        VBox back_container = new VBox();
        Button back = new Button("BACK");
        back_container.getStyleClass().add("back");
        back.getStyleClass().add("back_button");
        back.setOnAction(event ->{
            root.getChildren().clear();
            root.getChildren().add(tutorial_scene_continue());
        });
        VBox title_container = new VBox();
        title_container.getStyleClass().add("title_container");

        Label title = new Label("Cryptography Game");
        title.getStyleClass().add("title_app");

        VBox tutorial = new VBox();
        Label tutorial_label = new Label("TUTORIAL:");
        tutorial_label.getStyleClass().add("labels_app");
        tutorial.getStyleClass().add("title_page");

        VBox table = new VBox();
        TableView<ObservableList<String>> tableView = new TableView<>();
        tableView.setEditable(true);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setFixedCellSize(45);
        tableView.setPrefHeight(tableView.getFixedCellSize() * 4 + 28.5);
        tableView.setMaxHeight(tableView.getFixedCellSize() * 4 + 28.5);
        tableView.setTableMenuButtonVisible(false);
        tableView.getStyleClass().add("table-view");
        table.getStyleClass().add("table");
        // Create columns dynamically
        for (int i = 0; i < 13; i++) {
            TableColumn<ObservableList<String>, String> column = new TableColumn<>();
            final int colIndex = i;
            column.setSortable(false);
            column.setReorderable(false);
            column.setResizable(false);
            column.getStyleClass().add("columns");
            column.setCellValueFactory(data ->
                    new javafx.beans.property.SimpleStringProperty(data.getValue().get(colIndex))
            );

            column.setPrefWidth(58);  // Reduced cell width
            column.setMaxWidth(58);
            column.setCellFactory(tc -> new TextFieldTableCell<ObservableList<String>, String>(new StringConverter<String>() {
                @Override
                public String toString(String object) {
                    return object.toUpperCase(); // Simply return the string as is
                }

                @Override
                public String fromString(String string) {
                    return string; // Return the string entered by the user
                }
            }) {
                @Override
                public void startEdit() {
                    if (getTableRow().getIndex() == 1 || getTableRow().getIndex() == 3) {
                        super.startEdit();

                    }
                }

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!empty && (getTableRow().getIndex() != 1 && getTableRow().getIndex() != 3)) {
                        setStyle("-fx-background-color: rgba(54, 54, 54, 0.3)");
                        setStyle("-fx-alignment: center");
                    } else {
                        setStyle("");
                        setStyle("-fx-alignment: center");
                    }

                }

                @Override
                public void commitEdit(String newValue) {
                    // Ensure the input is only one character
                    if (newValue.length() > 1) {
                        newValue = newValue.substring(0, 1);  // Truncate to the first character
                    }
                    super.commitEdit(newValue);  // Commit the edit with the truncated value
                }
            });

            column.setOnEditCommit(event -> {
                ObservableList<String> row = event.getRowValue(); // Get the row data
                row.set(event.getTablePosition().getColumn(), event.getNewValue()); // Update the cell data


            });

            tableView.getColumns().add(column);
        }

        // Add rows dynamically
        ObservableList<ObservableList<String>> rows = FXCollections.observableArrayList();

        // First row (A-M)
        ObservableList<String> row1 = FXCollections.observableArrayList();
        for (char c = 'A'; c <= 'M'; c++) {
            row1.add(String.valueOf(c));
        }
        rows.add(row1);

        // Second row (empty)
        ObservableList<String> row2 = FXCollections.observableArrayList("H", "O", "T", "D", "G", "A", "B", "C", "E", "F", "I", "J", "K");
        rows.add(row2);

        // Third row (N-Z)
        ObservableList<String> row3 = FXCollections.observableArrayList();
        for (char c = 'N'; c <= 'Z'; c++) {
            row3.add(String.valueOf(c));
        }
        rows.add(row3);

        // Fourth row (empty)
        ObservableList<String> row4 = FXCollections.observableArrayList("L", "M", "N", "P", "Q", "R", "S", "U", "V", "W", "X", "Y", "Z");
        rows.add(row4);

        tableView.setItems(rows);

        tableView.setRowFactory(tv -> {
            TableRow<ObservableList<String>> row = new TableRow<>();
            row.setStyle("");  // Default style
            row.indexProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue.intValue() == 0 || newValue.intValue() == 2) {
                    row.setStyle("-fx-background-color: rgba(94, 23, 235, 1);");  // Row 0 and row 2
                } else {
                    row.setStyle("-fx-background-color: rgba(0,0,59)");  // Default color for row 1 and row 3
                }
            });
            return row;
        });
        // Add the TableView to the VBox

        back_container.getChildren().add(back);
        table.getChildren().add(tableView);
        tutorial.getChildren().addAll(tutorial_label);
        title_container.getChildren().addAll(title);
        main_container.getChildren().addAll(back_container,title_container,tutorial,table,key(2),next(2));
        Platform.runLater(() -> {
            JOptionPane.showMessageDialog(null, """
                    As you have learn on the instruction we remove duplicate letters
                    tne we place it on the alphabets now HOTDOG became HOTDG now you have the encrypted message
                    dark blue table cell and the decrypted message on the purple table cell""");
        });
        return main_container;
    }

    public VBox answered(){
        VBox main_container = new VBox();
        main_container.getStyleClass().add("play_main");

        VBox back_container = new VBox();
        Button back = new Button("BACK");
        back_container.getStyleClass().add("back");
        back.getStyleClass().add("back_button");
        back.setOnAction(event ->{
            root.getChildren().clear();
            root.getChildren().add(tutorial_scene());
        });

        HBox panel_container = new HBox(50);
        panel_container.getStyleClass().add("play_panel");

        VBox key = new VBox();
        key.getStyleClass().add("play_box");

        VBox key_title = new VBox();
        Label keyTitle = new Label("KEYWORD TEXT");
        key_title.getStyleClass().add("play_key");

        TextArea key_content = new TextArea();
        key_content.setText("""
                At a bustling food truck, I was so hungry that I quickly ordered a burger and fries. Nearby, a kid eagerly asked for a hotdog, but the lady at the counter sighed and said, "Sorry, we're out of hotdogs."
                As I finished my meal, I remembered I needed to grab the keys from the car. However, the thought of the hotdog lingered in my mind. Suddenly, I recalled something peculiar about my keychain—it was shaped like a hotdog.
                """);
        key_content.setWrapText(true);
        key_content.setEditable(false);
        key_content.getStyleClass().add("play_key_content");

        VBox encrypt = new VBox();
        encrypt.getStyleClass().add("play_box");

        VBox encrypt_title = new VBox();
        Label encryptTitle = new Label("ENCRYPTED TEXT");
        encrypt_title.getStyleClass().add("play_key");

        VBox encrypt_content = new VBox();
        encrypt_content.getStyleClass().add("play_encrypt_content");

        HBox message = new HBox(5.5);
        message.getStyleClass().add("play_encrypt_message");
        HBox answer = new HBox(2);
        answer.getStyleClass().add("play_encrypt_answer");
        String hello = "H E L L O   W O R L D";
        for (int i = 0; i < characters.length(); i++) {
            char c = characters.charAt(i);

            // Check if the character is a space
            if (c == ' ') {
                // Add space label to the top row
                Label spaceLabel = new Label(" ");
                spaceLabel.getStyleClass().add("play_contents_message");
                message.getChildren().add(spaceLabel);

                // Add space label to the bottom row (not a TextField for space)
                answer.getChildren().add(new Label(" "));
            } else {
                // Add regular character label to the top row
                Label charLabel = new Label(String.valueOf(c));
                charLabel.getStyleClass().add("play_contents_message");
                message.getChildren().add(charLabel);

                // Get the corresponding character from the "hello" string for the answer row
                String answerChar = String.valueOf(hello.charAt(i));

                // Add TextField to the bottom row with the corresponding character
                TextField inputField = new TextField(answerChar);
                inputField.getStyleClass().add("play_contents_answer");
                inputField.setEditable(false); // Make TextField non-editable
                answer.getChildren().add(inputField);
            }
        }

        VBox nextPage = new VBox();
        Button next = new Button("NEXT");
        nextPage.getStyleClass().add("next_tutorial");
        next.getStyleClass().add("next_btn");
        next.setOnAction(event ->{
            root.getStyleClass().remove("root_app");
            root.getStyleClass().add("root_form");
            root.getChildren().clear();
            root.getChildren().add(app());
        });
        VBox button_container = new VBox();
        button_container.getStyleClass().add("play_button");
        Button table = new Button("TABLE");
        table.getStyleClass().add("table_button");
        table.setOnAction(event ->{
            root.getChildren().clear();
            root.getChildren().add(table_tutorial());
        });

        back_container.getChildren().add(back);
        nextPage.getChildren().add(next);
        encrypt_content.getChildren().addAll(message,answer);
        encrypt_title.getChildren().add(encryptTitle);
        encrypt.getChildren().addAll(encrypt_title,encrypt_content,nextPage);
        key_title.getChildren().add(keyTitle);
        key.getChildren().addAll(key_title,key_content);
        button_container.getChildren().add(table);
        panel_container.getChildren().addAll(key,encrypt);
        main_container.getChildren().addAll(back_container,panel_container,button_container);
        return main_container;
    }
}