import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddFlyghtPage extends JPanel {
    private ClientFrame parent;
    private JLabel label;
    private JTextField textFieldDepartureTime;
    private JTextField textFieldEconomPlacePrice;
    private JTextField textFieldBusinessPlacePrice;
    private JComboBox departureCitiesBox;
    private JComboBox aircraftsBox;
    private JComboBox arrivalCitiesBox;
    private String[] aircrafts;
    private String[] departureCities;
    private String[] arrivalCities;
    private JButton confirm;
    private JButton back;

    public AddFlyghtPage(ClientFrame parent){
        this.parent=parent;
        setSize(500,500);
        setLayout(null);

        label = new JLabel("Aircraft id:");
        label.setSize(100,30);
        label.setLocation(50,50);
        add(label);

        label = new JLabel("Departure city id:");
        label.setSize(100,30);
        label.setLocation(50,100);
        add(label);

        label = new JLabel("Arrival city id:");
        label.setSize(100,30);
        label.setLocation(50,150);
        add(label);

        label = new JLabel("Departure Time:");
        label.setSize(100,30);
        label.setLocation(50,200);
        add(label);

        label = new JLabel("Economy place price:");
        label.setSize(100,30);
        label.setLocation(50,250);
        add(label);

        label = new JLabel("Business place price:");
        label.setSize(100,30);
        label.setLocation(50,300);
        add(label);

        textFieldDepartureTime = new JTextField();
        textFieldDepartureTime.setSize(200,30);
        textFieldDepartureTime.setLocation(200,200);
        add(textFieldDepartureTime);

        textFieldEconomPlacePrice = new JTextField();
        textFieldEconomPlacePrice.setSize(200,30);
        textFieldEconomPlacePrice.setLocation(200,250);
        add(textFieldEconomPlacePrice);

        textFieldBusinessPlacePrice = new JTextField();
        textFieldBusinessPlacePrice.setSize(200,30);
        textFieldBusinessPlacePrice.setLocation(200,300);
        add(textFieldBusinessPlacePrice);

        confirm = new JButton("CONFIRM");
        confirm.setSize(150,30);
        confirm.setLocation(250,350);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aircraft_id_string = (String) aircraftsBox.getSelectedItem();
                int aircraft_id = Integer.parseInt(String.valueOf(aircraft_id_string.charAt(0)));
                String departure_city_id_string = (String) departureCitiesBox.getSelectedItem();
                int departure_city_id = Integer.parseInt(String.valueOf(departure_city_id_string.charAt(0)));
                String arrival_city_id_string = (String) arrivalCitiesBox.getSelectedItem();
                int arrival_city_id = Integer.parseInt(String.valueOf(arrival_city_id_string.charAt(0)));
                String departure_time = textFieldDepartureTime.getText();
                int econom_place_price = Integer.parseInt(textFieldEconomPlacePrice.getText());
                int business_place_price = Integer.parseInt(textFieldBusinessPlacePrice.getText());
                Flyght flyght = new Flyght(0,aircraft_id,departure_city_id,arrival_city_id,departure_time,econom_place_price,business_place_price);
                PackageData pd = new PackageData();
                pd.setOperationType("add_flight");
                pd.setFlyght(flyght);
                try {
                    parent.getOutputStream().writeObject(pd);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                aircraftsBox.setSelectedIndex(0);
                departureCitiesBox.setSelectedIndex(0);
                arrivalCitiesBox.setSelectedIndex(0);
                textFieldDepartureTime.setText("");
                textFieldEconomPlacePrice.setText("");
                textFieldBusinessPlacePrice.setText("");
            }
        });
        add(confirm);

        back = new JButton("BACK");
        back.setSize(150,30);
        back.setLocation(100,350);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getAddFlyghtPage().setVisible(false);
                parent.getFlyghtPage().setVisible(true);
            }
        });
        add(back);
    }
    public void setAircrafts(ArrayList<Aircraft> arrayAircraft){
        ArrayList<Aircraft> arrayAircrafts = arrayAircraft;
        int j;
        for (j = 0; j<arrayAircrafts.size();j++){
        }
        aircrafts=new String[j];
        for (int i = 0; i<arrayAircrafts.size();i++){
            aircrafts[i] =String.valueOf(arrayAircrafts.get(i).getId())+ " " + arrayAircraft.get(i).getName();
        }
        aircraftsBox = new JComboBox(aircrafts);
        aircraftsBox.setSize(200,30);
        aircraftsBox.setLocation(200,50);
        add(aircraftsBox);
    }
    public void setDepartureCities(ArrayList<City> arrayCity){
        ArrayList<City> arrayCities = arrayCity;
        int j;
        for (j = 0; j<arrayCities.size();j++){
        }
        departureCities=new String[j];
        for (int i = 0; i<arrayCities.size();i++){
            departureCities[i]=String.valueOf(arrayCities.get(i).getId())+" "+arrayCities.get(i).getShort_name();
        }
        departureCitiesBox = new JComboBox(departureCities);
        departureCitiesBox.setSize(200,30);
        departureCitiesBox.setLocation(200,100);
        add(departureCitiesBox);
    }
    public void setArrivalCitiesBox(ArrayList<City> arrayCity){
        ArrayList<City> arrayCities = arrayCity;
        int j;
        for (j = 0; j<arrayCities.size(); j++){
        }
        arrivalCities = new String[j];
        for (int i = 0; i<arrayCities.size(); i++){
            arrivalCities[i]=String.valueOf(arrayCities.get(i).getId())+" "+arrayCities.get(i).getShort_name();
        }
        arrivalCitiesBox = new JComboBox(arrivalCities);
        arrivalCitiesBox.setSize(200,30);
        arrivalCitiesBox.setLocation(200,150);
        add(arrivalCitiesBox);
    }
}
