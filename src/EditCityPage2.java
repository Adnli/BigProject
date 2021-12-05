import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditCityPage2 extends JPanel {
    private ClientFrame parent;
    private int id;
    private JLabel label;
    private JTextField textFieldName;
    private JTextField textFieldCountry;
    private JTextField textFieldShortName;
    private JButton confirm;
    private JButton back;
    public EditCityPage2(ClientFrame parent){
        this.parent=parent;
        setSize(500,500);
        setLayout(null);

        label = new JLabel("Name: ");
        label.setSize(100,30);
        label.setLocation(50,100);
        add(label);

        label = new JLabel("Country: ");
        label.setSize(100,30);
        label.setLocation(50,150);
        add(label);

        label = new JLabel("Short name:");
        label.setSize(150,30);
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
                String short_name = textFieldShortName.getText();
                City city = new City(id,name,country,short_name);
                PackageData pd = new PackageData();
                pd.setOperationType("edit_city");
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
                PackageData pd1 = new PackageData();
                pd1.setOperationType("list_cities");
                try{
                    parent.getOutputStream().writeObject(pd1);
                    if((pd1=(PackageData) parent.getInputStream().readObject())!=null){
                        parent.getEditCityPage().generateTable(pd1.getCities());
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                parent.getEditCityPage2().setVisible(false);
                parent.getEditCityPage().setVisible(true);
            }
        });
        add(confirm);

        back = new JButton("BACK");
        back.setSize(150,30);
        back.setLocation(100,350);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getEditCityPage2().setVisible(false);
                parent.getCityPage().setVisible(true);
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
