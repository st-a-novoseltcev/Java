package view.vehicle;

//  TODO  - edit vehicle menu
public class EditMenu extends VehicleMenu {
        public void show() {
        showTitle();
        display_ln(" ".repeat(3) + String.format(langData.getProperty("BACK_CMD"), 0));
        display_ln(String.format(langData.getProperty("EDIT_VEHICLE_CMD"), ">= 1"));
        showSeparator();
        row(langData.getProperty("ENTER_CMD"));
    }
}
