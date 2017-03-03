
package designs;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class NewClass1 extends JPanel
{
    Image myImage;
    public NewClass1()
    {
        try
        {
            myImage=new ImageIcon(getClass().getResource("images (3).jpg")).getImage();
            
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

