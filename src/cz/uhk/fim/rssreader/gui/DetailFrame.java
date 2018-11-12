package cz.uhk.fim.rssreader.gui;

import cz.uhk.fim.rssreader.model.RSSItem;

import javax.swing.*;
import java.awt.*;

public class DetailFrame extends JFrame {
    private static final int ITEM_WIDTH = 180;
    private static final int COMPONENT_WIDTH = 160;
    private static final int HEIGHT = 1;

    final String startHtml = "<html><p style = 'width:"+ COMPONENT_WIDTH + "px'>";
    final String endHtml = "</p></html>";

    public DetailFrame(RSSItem item){
        setLayout(new WrapLayout());
        setSize(ITEM_WIDTH, HEIGHT);
        setItemTitle(item.getTitle());
        setDescription(item.getDescription());
        setLink(item.getLink());
        setInfo(String.format("%s-%s", item.getPubDate(), item.getAuthor()));

        init();
    }
    private void init() {
        setTitle("Detail");
        setSize(ITEM_WIDTH+50, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);



    }
    private void setItemTitle(String title){
        JLabel lblTitle = new JLabel();
        lblTitle.setSize(COMPONENT_WIDTH, HEIGHT);
        lblTitle.setFont(new Font("Courier", Font.BOLD,12));
        lblTitle.setText(String.format("%s%s%s", startHtml, title, endHtml));
        add(lblTitle);
    }
    private void setDescription(String description){
        JLabel lblDescription = new JLabel();
        lblDescription.setSize(COMPONENT_WIDTH, HEIGHT);
        lblDescription.setFont(new Font("Courier", Font.PLAIN,11));
        lblDescription.setText(String.format("%s%s%s", startHtml, description, endHtml));
        add(lblDescription);
    }
    private void setLink(String link){
        JLabel lblLink = new JLabel();
        lblLink.setSize(COMPONENT_WIDTH, HEIGHT);
        lblLink.setFont(new Font("Serif",Font.PLAIN,10));
        lblLink.setText(String.format("%s%s%s", startHtml, link, endHtml));
        add(lblLink);
    }
    private void setInfo(String format) {
        JLabel lblFormat = new JLabel();
        lblFormat.setSize(COMPONENT_WIDTH, HEIGHT);
        lblFormat.setFont(new Font("Courier", Font.ITALIC,10));
        lblFormat.setText(String.format("%s%s%s", startHtml, format, endHtml));
        add(lblFormat);
    }


    }








