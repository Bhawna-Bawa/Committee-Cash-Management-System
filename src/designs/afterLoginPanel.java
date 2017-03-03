
package designs;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class afterLoginPanel extends JPanel
{
    Image myImage;
    public afterLoginPanel()
    {
        try
        {
            myImage=new ImageIcon(getClass().getResource("afterLogin.jpg")).getImage();
            
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

    

