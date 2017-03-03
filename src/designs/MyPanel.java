
package designs;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel
{
    Image myImage;
    public MyPanel()
    {
        try
        {
            myImage=new ImageIcon(getClass().getResource("mtaVFni.jpg")).getImage();
            
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
