package cz.uhk.fim.rssreader.gui;

import cz.uhk.fim.rssreader.model.RSSItem;
import cz.uhk.fim.rssreader.model.RSSList;
import cz.uhk.fim.rssreader.model.RSSSource;
import cz.uhk.fim.rssreader.utils.FileUtils;
import cz.uhk.fim.rssreader.utils.RSSParser;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private static final String VALIDATION_TYPE = "VALIDATION_TYPE";
    private static final String IO_LOAD_TYPE = "IO_LOAD_TYPE";
    private static final String IO_SAVE_TYPE = "IO_SAVE_TYPE";

    private JLabel lblErrorMessage;
    private JTextField txtPathField;
    private RSSList rssList;

    public MainFrame() {
        init();
    }

    private void init() {
        setTitle("RSS Reader");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initContentUI();
    }

    private void initContentUI() {
        JPanel controlPanel = new JPanel(new BorderLayout());

        JButton btnLoad = new JButton("Load");
        txtPathField = new JTextField();
        JButton btnSave = new JButton("Save");
        lblErrorMessage = new JLabel();
        lblErrorMessage.setForeground(Color.RED);
        lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);

        controlPanel.add(btnLoad, BorderLayout.WEST);
        controlPanel.add(txtPathField, BorderLayout.CENTER);
        controlPanel.add(btnSave, BorderLayout.EAST);
        controlPanel.add(lblErrorMessage, BorderLayout.SOUTH);

        add(controlPanel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel(new WrapLayout());

        try {
            rssList = new RSSParser().getParsedRSS("http://gpf1.cz/feed/");

            for(RSSItem item : rssList.getAllItems()) {
                CardView cardView = new CardView(item);
                cardView.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(e.getClickCount() == 2){
                            DetailFrame  detailFrame = new DetailFrame(item);
                            detailFrame.setVisible(true);
                            detailFrame.addMouseListener(new MouseAdapter(){
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    if(SwingUtilities.isRightMouseButton(e)){
                                        detailFrame.setVisible(false);
                                    }
                                }
                            });
                        }
                    }
                });
               contentPanel.add(cardView);
            }
        } catch (IOException | SAXException | ParserConfigurationException e1) {
            e1.printStackTrace();
        }

        add(new JScrollPane(contentPanel), BorderLayout.CENTER);

//        btnLoad.addActionListener(e -> {
//            if(validateInput()) {
//                try {
//                    txtContent.setText(FileUtils.loadStringFromFile(txtPathField.getText()));
//                } catch (IOException e1) {
//                    showErrorMessage(IO_LOAD_TYPE);
//                    e1.printStackTrace();
//                }
//            }
//        });

//        btnSave.addActionListener(e -> {
//            if(validateInput()) {
////                try {
////                    FileUtils.saveStringToFile(txtPathField.getText(), txtContent.getText().getBytes(StandardCharsets.UTF_8));
////                } catch (IOException e1) {
////                    showErrorMessage(IO_SAVE_TYPE);
////                    e1.printStackTrace();
////                }
//

//            }
//        });
    }
    btnSave.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            List<RSSSource> sources = new ArrayList<>();
            sources.add(new RSSSource("gpf1.cz", "https.gpf1.cz"));
            sources.add(new RSSSource("dhfghsf", "httsjdjdkjdk"));
            sources.add(new RSSSource("321546312", "fghdfgjdj"));
            FileUtils.saveSources(sources);
        }
    })
    btnLoad.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e)
    })
    private void showErrorMessage(String type) {
        String message;
        switch(type){
            case VALIDATION_TYPE:
                message = "Zadávací pole nemůže být prázdné!";
                break;
            case IO_LOAD_TYPE:
                message = "Chyba při načítání souboru!";
                break;
            case IO_SAVE_TYPE:
                message = "Chyba při ukládání souboru!";
                break;
            default:
                message = "Bůh ví, co se stalo";
                break;
        }
        lblErrorMessage.setText(message);
        lblErrorMessage.setVisible(true);
    }

    private boolean validateInput(){
        lblErrorMessage.setVisible(false);
        if(txtPathField.getText().trim().isEmpty()) {
            showErrorMessage(VALIDATION_TYPE);
            return false;
        }
        return true;
    }
}
