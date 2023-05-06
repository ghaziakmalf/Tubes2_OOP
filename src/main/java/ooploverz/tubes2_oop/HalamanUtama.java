package ooploverz.tubes2_oop;

// App
import javafx.application.Application;

// event

// scene
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

// stage
import javafx.scene.shape.Box;
import javafx.stage.Stage;
import javafx.stage.Screen;

// Geometry
import javafx.geometry.Rectangle2D;

public class HalamanUtama extends Application{
    /* Set screen size constant */
    Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
    private final double WINDOW_HEIGHT = primaryScreenBounds.getHeight() * 0.97;
    private final double WINDOW_WIDTH  = primaryScreenBounds.getWidth();

    private TabPane tabPane;

    private void addTab(String title, Node content) {
        System.out.println("Masuk");
        Tab tab = new Tab(title);
        tab.setContent(content);
        tabPane.getTabs().add(tab);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Panel
//        AnchorPane pane = new AnchorPane(); // layout
        tabPane = new TabPane(); // Panel untuk tampung semua tab


        // First Tab
        Tab tab1 = new Tab("Home");
        tab1.setClosable(false);


        /* Root Node */
        VBox root = new VBox();
        root.getStyleClass().add("content-wrapper");

        /* Menubar Panel */

        // create a menubar
        MenuBar menuBar = new MenuBar();
        menuBar.getStyleClass().add("menubar");

        // create menus

        // Membership
        Menu membershipMenu = new Menu("Membership");
        membershipMenu.getStyleClass().add("menu");

        MenuItem memberRegistration = new MenuItem("Member Registration");
        memberRegistration.setOnAction(event -> {
            VBox newRoot = new VBox();
            addTab("Member Registration", newRoot);
        });

        MenuItem membershipUpdate = new MenuItem("Update Membership");
        membershipUpdate.setOnAction(event -> {
            VBox newRoot = new VBox();
            addTab("Update Membership", newRoot);
        });
        MenuItem membershipDeactivate = new MenuItem("Deactivate Membership");
        membershipDeactivate.setOnAction(event -> {
            VBox newRoot = new VBox();
            addTab("Deactivate Membership", newRoot);
        });
        // add menu items to menu
        membershipMenu.getItems().addAll(memberRegistration, membershipUpdate, membershipDeactivate);

        // Cart
        Menu cartMenu = new Menu("Cart");
        MenuItem cart = new MenuItem("Cart");
        cartMenu.getItems().add(cart);
        cart.setOnAction(event -> {
            VBox newRoot = new VBox();
            addTab("Cart", newRoot);
        }
        );

        // Payment
        Menu paymentMenu = new Menu("Payment");
        MenuItem payment = new MenuItem("Payment");
        paymentMenu.getItems().add(payment);
        payment.setOnAction(event -> {
            VBox newRoot = new VBox();
            addTab("Payment", newRoot);
        }
        );
        // Inventory
        Menu inventoryMenu = new Menu("Inventory");
        MenuItem inventory = new MenuItem("Inventory");
        inventoryMenu.getItems().add(inventory);
        inventory.setOnAction(event -> {
            VBox newRoot = new VBox();
            addTab("Inventory", newRoot);
        });

        // History
        Menu historyMenu = new Menu("History");
        MenuItem history = new MenuItem("History");
        historyMenu.getItems().add(history);
        history.setOnAction(event -> {
            VBox newRoot = new VBox();
            addTab("History", newRoot);
        });

        // Settings
        Menu settingMenu =  new Menu("Settings");
        MenuItem settings = new MenuItem("Settings");
        settingMenu.getItems().add(settings);
        settings.setOnAction(event -> {
            VBox newRoot = new VBox();
            addTab("Settings", newRoot);
        });

        // add menus to menubar
        menuBar.getMenus().addAll( membershipMenu, cartMenu, paymentMenu, inventoryMenu, historyMenu, settingMenu);

        /* Logo */
        /* Digital Clock */

        /* Developers */

        /* Footer */





        // Add to root
        root.getChildren().addAll(menuBar);
        // add to tab1
        tab1.setContent(root);
        tab1.getStyleClass().add("tab");

        // Setup Akhir Scene
        tabPane.getTabs().add(tab1);
//        pane.getChildren().addAll(tabPane);
        Scene scene = new Scene(tabPane, WINDOW_WIDTH, WINDOW_HEIGHT);
        primaryStage.setTitle("Yonkou Mart");
        primaryStage.setScene(scene);
        scene.getStylesheets().add
                (HalamanUtama.class.getResource("mainWindow.css").toExternalForm());
        primaryStage.show();
    }

    public static void main (String[] args)
    {
        launch(args);
    }

}