import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCityPage extends JPanel {
    private ClientFrame parent;
    private JLabel label;
    private JTextField textFieldName;
    private JTextField textFieldCountry;
    private JTextField textFieldShortName;
    private JButton confirm;
    private JButton back;
    public AddCityPage(ClientFrame parent){
        this.parent=parent;
        setSize(500,500);
        setLayout(null);

        label = new JLabel("Name of city:");
        label.setSize(100,30);
        label.setLocation(50,100);
        add(label);

        label = new JLabel("Country of city:");
        label.setSize(100,30);
        label.setLocation(50,150);
        add(label);

        label = new JLabel("Short name of city: ");
        label.setSize(100,30);
        label.setLocation(50,200);
        add(label);

        textFieldName = new JTextField();
        textFieldName.setSize(200,30);
        textFieldName.setLocation(200,100);
        add(textFieldName);

        textFieldCountry = new JTextField();
        textFieldCountry.setSize(200,30);
        textFieldCountry.setLocation(200,150);
        add(textFieldCountry);

        textFieldShortName = new JTextField();
        textFieldShortName.setSize(200,30);
        textFieldShortName.setLocation(200,200);
        add(textFieldShortName);

        confirm = new JButton("CONFIRM");
        confirm.setSize(150,30);
        confirm.setLocation(250,350);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textFieldName.getText();
                String country = textFieldCountry.getText();
                String shortName = textFieldShortName.getText();
                City city = new City(0,name,country,shortName);
                PackageData pd = new PackageData();
                pd.setOperationType("add_city");
                pd.setCity(city);
                try {
                    parent.getOutputStream().writeObject(pd);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                textFieldName.setText("");
                textFieldCountry.setText("");
                textFieldShortName.setText("");
            }
        });
        add(confirm);

        back = new JButton("BACK");
        back.setSize(150,30);
        back.setLocation(100,350);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getAddCityPage().setVisible(false);
                parent.getCityPage().setVisible(true);
            }
        });
        add(back);
    }
}
