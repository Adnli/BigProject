import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AircraftPage extends JPanel {
    private ClientFrame parent;
    private JButton add;
    private JButton list;
    private JButton edit;
    private JButton delete;
    private JButton back;
    public AircraftPage(ClientFrame parent){
        this.parent=parent;
        setSize(500,500);
        setLayout(null);

        add = new JButton("ADD AIRCRAFT");
        add.setSize(300,30);
        add.setLocation(100,100);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getAircraftPage().setVisible(false);
                parent.getAddAircraftPage().setVisible(true);
            }
        });
        add(add);

        list = new JButton("LIST AIRCRAFTS");
        list.setSize(300,30);
        list.setLocation(100,150);
        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageData pd = new PackageData();
                pd.setOperationType("list_aircrafts");
                try{
                    parent.getOutputStream().writeObject(pd);
                    if((pd=(PackageData) parent.getInputStream().readObject())!=null){
                        parent.getListAircraftsPage().generateTable(pd.getAircrafts());
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                parent.getAircraftPage().setVisible(false);
                parent.getListAircraftsPage().setVisible(true);
            }
        });
        add(list);

        edit = new JButton("EDIT AIRCRAFT");
        edit.setSize(300,30);
        edit.setLocation(100, 200);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageData pd = new PackageData();
                pd.setOperationType("list_aircrafts");
                try{
                    parent.getOutputStream().writeObject(pd);
                    if((pd=(PackageData) parent.getInputStream().readObject())!=null){
                        parent.getEditAircraftPage().generateTable(pd.getAircrafts());
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                parent.getAircraftPage().setVisible(false);
                parent.getEditAircraftPage().setVisible(true);
            }
        });
        add(edit);

        delete = new JButton("DELETE AIRCRAFT");
        delete.setSize(300,30);
        delete.setLocation(100,250);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageData pd1 = new PackageData();
                pd1.setOperationType("list_aircrafts");
                try{
                    parent.getOutputStream().writeObject(pd1);
                    if((pd1=(PackageData) parent.getInputStream().readObject())!=null){
                        parent.getDeleteAircraftsPage().generateTable(pd1.getAircrafts());
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                parent.getAircraftPage().setVisible(false);
                parent.getDeleteAircraftsPage().setVisible(true);
            }
        });
        add(delete);

        back = new JButton("BACK");
        back.setSize(300,30);
        back.setLocation(100,350);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getAircraftPage().setVisible(false);
                parent.getAdminMainPage().setVisible(true);
            }
        });
        add(back);
    }
}
