package HotelStaffScreen;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Created by Heaven on 12/4/2015.
 */
public class MenuView extends Pane {
    private ImageView checkInLogo;
    private ImageView customerListLogo;
    private ImageView roomListLogo;
    private ImageView reservationsLogo;
    private ImageView roomEditorLogo;

    public MenuView() {
        checkInLogo = new ImageView(getClass().getResource("icons/checkin_menu.png").toExternalForm());
        checkInLogo.setLayoutX(100);
        checkInLogo.setLayoutY(100);

        customerListLogo = new ImageView(getClass().getResource("icons/customerListIcon.png").toExternalForm());
        customerListLogo.setLayoutX(300);
        customerListLogo.setLayoutY(100);

        roomEditorLogo = new ImageView(getClass().getResource("icons/rooEditorIcon.png").toExternalForm());
        roomEditorLogo.setLayoutX(700);
        roomEditorLogo.setLayoutY(300);

        getChildren().addAll(checkInLogo, customerListLogo, roomEditorLogo);
    }

    public ImageView getCheckInLogo() {
        return checkInLogo;
    }

    public void setCheckInLogo(ImageView checkInLogo) {
        this.checkInLogo = checkInLogo;
    }

    public ImageView getCustomerListLogo() {
        return customerListLogo;
    }

    public void setCustomerListLogo(ImageView customerListLogo) {
        this.customerListLogo = customerListLogo;
    }

    public ImageView getRoomListLogo() {
        return roomListLogo;
    }

    public void setRoomListLogo(ImageView roomListLogo) {
        this.roomListLogo = roomListLogo;
    }

    public ImageView getReservationsLogo() {
        return reservationsLogo;
    }

    public void setReservationsLogo(ImageView reservationsLogo) {
        this.reservationsLogo = reservationsLogo;
    }

    public ImageView getRoomEditorLogo() {
        return roomEditorLogo;
    }

    public void setRoomEditorLogo(ImageView roomEditorLogo) {
        this.roomEditorLogo = roomEditorLogo;
    }
}
