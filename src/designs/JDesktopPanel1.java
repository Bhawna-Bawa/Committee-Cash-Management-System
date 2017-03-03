
package designs;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JDesktopPanel1 extends JPanel
{
    Image myImage;
    public JDesktopPanel1()
    {
        try
        {
            myImage=new ImageIcon(getClass().getResource("nt527.jpg")).getImage();
            
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
