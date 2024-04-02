import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SplashScreen extends JPanel {
    private JButton buildButton;
    public SplashScreen(){
        this.setBounds(0,0,800,800);
        this.setBackground(new Color(194, 235, 91));
        this.setLayout(null);
        this.setVisible(true);

        //welcome text
        JLabel welcomeLabel = new JLabel("The Realms of Shubie Park");
        welcomeLabel.setBounds(160,25,500,150);
        welcomeLabel.setFont(new Font ("Engravers Old English",Font.BOLD,45));
        this.add(welcomeLabel);

        //welcome image
        JLabel imageLabel = new JLabel("image goes here");
        imageLabel.setBounds(30,130,740,480);
        ImageIcon welcomeImage = new ImageIcon(getClass().getResource("LandingScreen.jpeg"));
        imageLabel.setIcon(welcomeImage);
        this.add(imageLabel);

        //build a character button
        buildButton = new JButton("Build A Character");
        buildButton.setBounds(300,650,200,50);
        this.add(buildButton);
    }

    public JButton getBuildButton() {
        return buildButton;
    }
}
