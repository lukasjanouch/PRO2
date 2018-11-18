package cz.uhk.fim.rssreader.gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class AddSrcFrame extends JFrame{
    public AddSrcFrame(){
        init();


    }
    private void init() {
        setTitle("Přidat nový src");
        setSize(230, 150);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);

        initContentUI();
    }
    private void initContentUI() {
        JLabel lblNazev = new JLabel("Název:");
        JLabel lblLink = new JLabel("Link:");
        JTextField txtNazev = new JTextField(10);
        JTextField txtLink = new JTextField(10);
        JButton btnOk = new JButton("OK");
        JButton btnCancel = new JButton("Cancel");

        JPanel pnlNazev = new JPanel();
        JPanel pnlLink = new JPanel();
        JPanel pnlBtns = new JPanel();

        pnlNazev.setLayout(new FlowLayout());
        pnlNazev.add(lblNazev);
        pnlNazev.add(txtNazev);

        pnlLink.setLayout(new FlowLayout());
        pnlLink.add(lblLink);
        pnlLink.add(txtLink);

        pnlBtns.setLayout(new FlowLayout());
        pnlBtns.add(btnOk);
        pnlBtns.add(btnCancel);

        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
        add(pnlNazev);
        add(pnlLink);
        add(pnlBtns);



        btnCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                dispose();

            }
        });
    }
}

