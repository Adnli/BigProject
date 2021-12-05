import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditFlyghtPage2 extends JPanel {
    private ClientFrame parent;
    private JLabel label;
    private JTextField textFieldAircraftId;
    private JTextField textFieldDepartureCityId;
    private JTextField textFieldArrivalCityId;
    private JTextField textFieldDepartureTime;
    private JTextField textFieldEconomPlacePrice;
    private JTextField textFieldBusinessPlacePrice;
    private JButton confirm;
    private JButton back;
    private int id;

    public EditFlyghtPage2(ClientFrame parent){
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

        textFieldAircraftId = new JTextField();
        textFieldAircraftId.setSize(200,30);
        textFieldAircraftId.setLocation(200,50);
        add(textFieldAircraftId);

        textFieldDepartureCityId = new JTextField();
        textFieldDepartureCityId.setSize(200,30);
        textFieldDepartureCityId.setLocation(200,100);
        add(textFieldDepartureCityId);

        textFieldArrivalCityId = new JTextField();
        textFieldArrivalCityId.setSize(200,30);
        textFieldArrivalCityId.setLocation(200,150);
        add(textFieldArrivalCityId);

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

        confirm = new JButton("EDIT");
        confirm.setSize(150,30);
        confirm.setLocation(250,350);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int aircraft_id = Integer.parseInt(textFieldAircraftId.getText());
                int departure_city_id = Integer.parseInt(textFieldDepartureCityId.getText());
                int arrival_city_id = Integer.parseInt(textFieldArrivalCityId.getText());
                String departure_time = textFieldDepartureTime.getText();
                int econom_place_price = Integer.parseInt(textFieldEconomPlacePrice.getText());
                int business_place_price = Integer.parseInt(textFieldBusinessPlacePrice.getText());
                Flyght flyght = new Flyght(id,aircraft_id,departure_city_id,arrival_city_id,departure_time,econom_place_price,business_place_price);
                PackageData pd = new PackageData();
                pd.setOperationType("edit_flight");
                pd.setFlyght(flyght);
                try {
                    parent.getOutputStream().writeObject(pd);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                PackageData pd1 = new PackageData();
                pd1.setOperationType("list_flights");
                try{
                    parent.getOutputStream().writeObject(pd1);
                    if((pd1=(PackageData) parent.getInputStream().readObject())!=null){
                        parent.getEditFlyghtPage().generateTable(pd1.getFlyghts());
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                parent.getEditFlyghtPage2().setVisible(false);
                parent.getEditFlyghtPage().setVisible(true);
            }
        });
        add(confirm);

        back = new JButton("BACK");
        back.setSize(150,30);
        back.setLocation(100,350);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getEditFlyghtPage2().setVisible(false);
                parent.getFlyghtPage().setVisible(true);
            }
        });
        add(back);
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
}
