import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditAircraftPage2 extends JPanel {
    private ClientFrame parent;
    private int id;
    private JLabel label;
    private JTextField textFieldName;
    private JTextField textFieldModel;
    private JTextField textFieldBusiness_class_capacity;
    private JTextField textFieldEconom_class_capacity;
    private JButton confirm;
    private JButton back;
    public EditAircraftPage2(ClientFrame parent){
        this.parent=parent;
        setSize(500,500);
        setLayout(null);

        label = new JLabel("Name: ");
        label.setSize(100,30);
        label.setLocation(50,100);
        add(label);

        label = new JLabel("Model: ");
        label.setSize(100,30);
        label.setLocation(50,150);
        add(label);

        label = new JLabel("Business class capacity:");
        label.setSize(150,30);
        label.setLocation(50,200);
        add(label);

        label = new JLabel("Economy class capacity: ");
        label.setSize(150,30);
        label.setLocation(50,250);
        add(label);

        textFieldName = new JTextField();
        textFieldName.setSize(200,30);
        textFieldName.setLocation(200,100);
        add(textFieldName);

        textFieldModel = new JTextField();
        textFieldModel.setSize(200,30);
        textFieldModel.setLocation(200,150);
        add(textFieldModel);

        textFieldBusiness_class_capacity = new JTextField();
        textFieldBusiness_class_capacity.setSize(200,30);
        textFieldBusiness_class_capacity.setLocation(200,200);
        add(textFieldBusiness_class_capacity);

        textFieldEconom_class_capacity = new JTextField();
        textFieldEconom_class_capacity.setSize(200,30);
        textFieldEconom_class_capacity.setLocation(200,250);
        add(textFieldEconom_class_capacity);

        confirm = new JButton("CONFIRM");
        confirm.setSize(150,30);
        confirm.setLocation(250,350);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textFieldName.getText();
                String model = textFieldModel.getText();
                int business_class_capacity = Integer.parseInt(textFieldBusiness_class_capacity.getText());
                int econom_class_capacity = Integer.parseInt(textFieldEconom_class_capacity.getText());
                Aircraft aircraft = new Aircraft(id,name,model,business_class_capacity,econom_class_capacity);
                PackageData pd = new PackageData();
                pd.setOperationType("edit_aircraft");
                pd.setAircraft(aircraft);
                try {
                    parent.getOutputStream().writeObject(pd);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                textFieldName.setText("");
                textFieldModel.setText("");
                textFieldBusiness_class_capacity.setText("");
                textFieldEconom_class_capacity.setText("");
                PackageData pd1 = new PackageData();
                pd1.setOperationType("list_aircrafts");
                try{
                    parent.getOutputStream().writeObject(pd1);
                    if((pd1=(PackageData) parent.getInputStream().readObject())!=null){
                        parent.getEditAircraftPage().generateTable(pd1.getAircrafts());
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                parent.getEditAircraftPage2().setVisible(false);
                parent.getEditAircraftPage().setVisible(true);
            }
        });
        add(confirm);

        back = new JButton("BACK");
        back.setSize(150,30);
        back.setLocation(100,350);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getEditAircraftPage2().setVisible(false);
                parent.getAircraftPage().setVisible(true);
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
