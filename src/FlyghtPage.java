import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlyghtPage extends JPanel {
    private ClientFrame parent;
    private JButton add;
    private JButton list;
    private JButton edit;
    private JButton delete;
    private JButton back;
    public FlyghtPage(ClientFrame parent){
        this.parent=parent;
        setSize(500,500);
        setLayout(null);

        add = new JButton("ADD FLIGHT");
        add.setSize(300,30);
        add.setLocation(100,100);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageData pd = new PackageData();
                pd.setOperationType("list_aircrafts");
                try {
                    parent.getOutputStream().writeObject(pd);
                    if((pd=(PackageData) parent.getInputStream().readObject())!=null){
                        parent.getAddFlyghtPage().setAircrafts(pd.getAircrafts());
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                pd.setOperationType("list_cities");
                try {
                    parent.getOutputStream().writeObject(pd);
                    if((pd=(PackageData) parent.getInputStream().readObject())!=null){
                        parent.getAddFlyghtPage().setDepartureCities(pd.getCities());
                    }
                }
                catch (Exception e1){
                    e1.printStackTrace();
                }
                pd.setOperationType("list_cities");
                try {
                    parent.getOutputStream().writeObject(pd);
                    if((pd=(PackageData) parent.getInputStream().readObject())!=null){
                        parent.getAddFlyghtPage().setArrivalCitiesBox(pd.getCities());
                    }
                }
                catch (Exception e2){
                    e2.printStackTrace();
                }
                parent.getFlyghtPage().setVisible(false);
                parent.getAddFlyghtPage().setVisible(true);
            }
        });
        add(add);

        list = new JButton("LIST FLIGHTS");
        list.setSize(300,30);
        list.setLocation(100,150);
        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageData pd = new PackageData();
                pd.setOperationType("list_flights");
                try{
                    parent.getOutputStream().writeObject(pd);
                    if((pd=(PackageData) parent.getInputStream().readObject())!=null){
                        parent.getListFlyghtPage().generateTable(pd.getFlyghts());
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                parent.getFlyghtPage().setVisible(false);
                parent.getListFlyghtPage().setVisible(true);
            }
        });
        add(list);

        edit = new JButton("EDIT FLIGHT");
        edit.setSize(300,30);
        edit.setLocation(100, 200);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                parent.getFlyghtPage().setVisible(false);
                parent.getEditFlyghtPage().setVisible(true);
            }
        });
        add(edit);

        delete = new JButton("DELETE FLIGHT");
        delete.setSize(300,30);
        delete.setLocation(100,250);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageData pd1 = new PackageData();
                pd1.setOperationType("list_flights");
                try{
                    parent.getOutputStream().writeObject(pd1);
                    if((pd1=(PackageData) parent.getInputStream().readObject())!=null){
                        parent.getDeleteFlyghtPage().generateTable(pd1.getFlyghts());
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                parent.getFlyghtPage().setVisible(false);
                parent.getDeleteFlyghtPage().setVisible(true);
            }
        });
        add(delete);

        back = new JButton("BACK");
        back.setSize(300,30);
        back.setLocation(100,350);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getFlyghtPage().setVisible(false);
                parent.getAdminMainPage().setVisible(true);
            }
        });
        add(back);
    }
}
