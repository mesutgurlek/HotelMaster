package HotelStaffScreen;

import HotelEntities.Hotel;
import HotelManagement.HotelControllerFacade;
import HotelManagement.LoginController;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Heaven on 12/2/2015.
 */
public class Main extends Application {
    private static Stage primaryStage;
    private static Scene scene;
    private Hotel hotel;
    private HotelControllerFacade hotelController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.hotel = new Hotel();
        this.hotelController = new HotelControllerFacade(hotel);

        scene = new Scene(hotel.getLoginView(), 960, 540);

        primaryStage.setScene(scene);
        primaryStage.setTitle("HotelMaster");
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();

    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public static void changeSceneRoot(Parent parent) {
        scene.setRoot(parent);
        primaryStage.setScene(scene);
    }
}