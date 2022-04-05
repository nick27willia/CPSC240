import javax.swing.*;
import java.awt.*;

public class PopupWindow {
    private JFrame baseFrame;
    private JPanel baseLayoutPanel;

    public PopupWindow(){
        this.baseFrame = new JFrame("Recipe");
        this.baseFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        this.baseLayoutPanel = new JPanel();
        BoxLayout baseLayout = new BoxLayout(this.baseLayoutPanel, BoxLayout.X_AXIS);
        this.baseLayoutPanel.setLayout(baseLayout);
        this.baseLayoutPanel.setBackground(Color.decode("#DDE0FB"));

        this.baseFrame.getContentPane().add(this.baseLayoutPanel);
        this.baseFrame.setPreferredSize(new Dimension(800, 500));
        this.baseFrame.pack();
        this.baseFrame.setVisible(false);
    }
    public void show(boolean shouldShow){
        this.baseFrame.setVisible(shouldShow);
    }
}
