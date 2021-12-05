import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoosePage extends JPanel {
    private ClientFrame parent;
    private JButton admin;
    private JButton cashier;
    private JButton exit;
    private JLabel label;

    public ChoosePage(ClientFrame parent){
        this.parent=parent;
        setSize(500,500);
        setLayout(null);

        label = new JLabel("Select user:");
        label.setSize(300,30);
        label.setLocation(100,200);
        add(label);

        admin = new JButton("ADMIN");
        admin.setSize(150,30);
        admin.setLocation(100,250);
        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getChoosePage().setVisible(false);
                parent.getAdminMainPage().setVisible(true);
            }
        });
        add(admin);

        cashier = new JButton("CASHIER");
        cashier.setSize(150,30);
        cashier.setLocation(250,250);
        cashier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getChoosePage().setVisible(false);
                parent.getMainPage().setVisible(true);
            }
        });
        add(cashier);

        exit = new JButton("EXIT");
        exit.setSize(300,30);
        exit.setLocation(100,300);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exit);
    }
}
