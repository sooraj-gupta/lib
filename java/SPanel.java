import javax.swing.*;
import java.awt.*;
public class SPanel extends JPanel
{
    int screenWidth = 0;
    int screenHeight = 0;

    public SPanel( int width, int height )
    {
        super();
        screenWidth = width;
        screenHeight = height;
        super.setBackground( Color.WHITE );
    }

    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
    }

}
