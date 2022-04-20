import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PopupWindow {
    private static PopupWindow instance;
    private JFrame baseFrame;
    private JPanel baseLayoutPanel;
    // Make the PopupWindow class singleton
    public static PopupWindow getInstance(){
        if(instance == null){
            instance = new PopupWindow();
        }
        return instance;
    }
    private PopupWindow(){
        this.baseFrame = new JFrame("Add Recipe");
        this.baseFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        this.baseLayoutPanel = new JPanel();
        BoxLayout baseLayout = new BoxLayout(this.baseLayoutPanel, BoxLayout.X_AXIS);
        this.baseLayoutPanel.setLayout(baseLayout);
        this.baseLayoutPanel.setBackground(Color.decode("#DDE0FB"));

        this.baseLayoutPanel.add(LeftFormPanel.getInstance());
        this.baseLayoutPanel.add(RightFormPanel.getInstance());

        this.baseFrame.getContentPane().add(this.baseLayoutPanel);
        this.baseFrame.setPreferredSize(new Dimension(600, 500));
        this.baseFrame.pack();
        this.baseFrame.setResizable(false);
//        this.baseFrame.setVisible(false);
        this.baseFrame.setVisible(true);
    }
    public void show(boolean shouldShow){
        this.baseFrame.setVisible(shouldShow);
    }
}
