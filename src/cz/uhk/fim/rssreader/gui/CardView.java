package cz.uhk.fim.rssreader.gui;

import cz.uhk.fim.rssreader.model.RSSItem;

import javax.swing.*;
import java.awt.*;



public class CardView extends JPanel {


    private static final int ITEM_WIDTH = 180;
    private static final int COMPONENT_WIDTH = 160;
    private static final int HEIGHT = 1;

    private final String startHtml = "<html><p style = 'width:"+ COMPONENT_WIDTH + "px'>";
    private final String endHtml = "</p></html>";
    private Color textColor;

    public CardView(RSSItem item){
        setLayout(new WrapLayout());
        setSize(ITEM_WIDTH, HEIGHT);
        setTitle(item.getTitle());
        Color bgColor = getRandomBgColor(item.getTitle());
        setBackground(bgColor);
        setDescription(item.getDescription());
        setInfo(String.format("%s-%s", item.getPubDate(), item.getAuthor()));
        }

    private void setTitle(String title){
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
    private void setInfo(String format) {
        JLabel lblFormat = new JLabel();
        lblFormat.setSize(COMPONENT_WIDTH, HEIGHT);
        lblFormat.setFont(new Font("Courier", Font.ITALIC,10));
        lblFormat.setText(String.format("%s%s%s", startHtml, format, endHtml));
        add(lblFormat);
    }
    private Color getRandomBgColor(String title) {
        int length = title.length();
        String[] parts = new String[3];
        int[] colors = new int[3];
        parts[0] = title.substring(0, length / 3);
        parts[1] = title.substring(length / 3, 2 * (length / 3));
        parts[2] = title.substring(2 * (length / 3), length);

        colors[0] = Math.abs(parts[0].hashCode() / 10000000);
        colors[1] = Math.abs(parts[1].hashCode() / 10000000);
        colors[2] = Math.abs(parts[2].hashCode() / 10000000);

        Color color = new Color(colors[0], colors[1], colors[2]);
        /*            Color color = new Color(title.hashCode());*/
        setInverseTextColor(color);
        return color;
    }
    
    private void setInverseTextColor(Color bgColor){
        textColor = new Color(255 - bgColor.getRed(), 255 - bgColor.getGreen(), 255 - bgColor.getBlue());
        
    }
    }


//item - jiná barva (RANDOM)
//třídy Color, String