import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

// Custom button class. Sets default styling
public class Button extends JButton {
    public Button(String text){
        super(text);
        this.setBackground(Color.WHITE);
        this.setOpaque(true);
        this.setBorderPainted(false);
        this.setFont(new Font("Dialog", Font.PLAIN, 18));
        this.setBorder(new EmptyBorder(10, 14, 10, 14));
    }
}
