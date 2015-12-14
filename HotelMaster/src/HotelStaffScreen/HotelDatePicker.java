package HotelStaffScreen;

import javafx.scene.control.DatePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * Created by Heaven on 12/14/2015.
 */
public class HotelDatePicker extends DatePicker {
    private LocalDateTime localDateTime;

    public HotelDatePicker(){
        this.setValue(LocalDate.from(localDateTime.now()));
    }

    public HotelDatePicker(int dayLater){
        this.setValue(LocalDate.from(localDateTime.now().plusDays(dayLater)));
    }

}
