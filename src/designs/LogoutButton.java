

package designs;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class LogoutButton extends JButton




{
    Image myImage;
    public LogoutButton()
    {
        try
        {
            myImage=new ImageIcon(getClass().getResource("Capture.png")).getImage();
            
        }
        catch(Exception ex)
        {
           System.out.println(ex); 
        }
                
    }
    @Override
        protected void paintComponent(Graphics g)
    {
        if(myImage==null)
        {
            super.paintComponent(g);
        }
        else
        {
            g.drawImage(myImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

