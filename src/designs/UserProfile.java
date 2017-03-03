/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package designs;

import code.BeanCommGroup;
import code.BeanDetails;
import code.CommGroupOperations;
import code.EnterDetails;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;


public class UserProfile extends javax.swing.JFrame {

    /**
     * Creates new form UserProfile
     */
    
     private static final long serialVersionUID = 1L;
  
  private static final int BLINKING_RATE = 1000; // in ms

  private boolean blinkingOn = true;
    UserProfile up;
    int id;
    BeanDetails details;
    ArrayList<BeanCommGroup> cg;
    public UserProfile()
    {
        initComponents();
        

    }
  
   
    public UserProfile(BeanDetails data) 
    {
                initComponents();
        setResizable(false);
      
        details=new BeanDetails();
        details=data;
          if(details.getRole().equals("User"))
          {
              cpdetails.setEnabled(false);
              ctrans.setEnabled(false);
          }
           
        String s="Welcome "+data.getFirst()+ " "+data.getLast()+" ("+data.getRole()+")";
        
        setTitle(s);
        pfirst.setEditable(false);
        plast.setEditable(false);
       
               
        id=data.getUserId();
        System.out.println(id);
        cg= new CommGroupOperations().getCDate();
        if(cg!=null)
        {
        date();
        pending();
        }
    }
    public void pending ()
    {
        int d =new Date().getDate(); // system date 1-31
        int smonth=new Date().getMonth()+1; //system month 
        
        for(BeanCommGroup commgroup : cg)
            
        {
            int cmonth=Integer.parseInt(commgroup.getDate());
            
            System.out.println("current date = "+d);
            System.out.println("collectiondate ="+commgroup.getCDay()); // collection date(1-31)
            
             if(d>commgroup.getCDay())
             {
                 int gid=commgroup.getGrpId();
                 int count=new CommGroupOperations().termnos(gid);
                 
                 if(count>0)
                 {
                     for(int i=1;i<=count;i++)
                     {
                         int memno=new CommGroupOperations().countMem(count, gid);
                         if(memno>=0 && memno<10)
                         {

                          cpend.setForeground(Color.red);
                          
                         }
                     }
                 }
                 else System.out.println("ok");
             }
             else System.out.println("d ok");

        }
        
 
    
        
        
       
        
        
    }
    public void date()
    {

       if(cg!=null)
       {
          int m=new Date().getMonth()+1; //system month
          System.out.println("system month"+m);
          int sdate=new Date().getDate(); //system date
        for(BeanCommGroup commgroup:cg)
        {
            int gid=commgroup.getGrpId();
            int cm=Integer.parseInt(commgroup.getDate()); // collection month
                      System.out.println("system month"+cm);

            int cdate=commgroup.getCDay();
            if(m==cm)
          {
              if(sdate>cdate)
              {    
                  //JOptionPane.showMessageDialog(null,"date greater");
                cm=1;
                   if(new CommGroupOperations().updateCDate(cm, gid))
                
                   {
                    System.out.println("Date Updated");
                   
                   }
                   else System.out.println("date updation failed");
               }
             else    System.out.println("ok");

           }
            else if (m>cm)
            {
                cm=m-cm;
                if(new CommGroupOperations().updateCDate(cm, gid))
                
                   {
                    System.out.println("Date Updated");
                   
                   }
                   else System.out.println("date updation failed");
            }
            else System.out.println("ok");

        }
       }
       else JOptionPane.showMessageDialog(null,"Error");
    }
  
public class Blink extends JEditorPane {
    public Blink() 
    {
        
        try 
        {   
           
           addBlink(Color.red, 300);
        }
        catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }

    public void addBlink( Color blinkColor, int blinkRate) throws BadLocationException {
         new BlinkPainter(blinkColor, blinkRate);
    }

   
    class BlinkPainter extends DefaultHighlighter.DefaultHighlightPainter {
        Color blinkColor;
        Color activeColor;
        public BlinkPainter(Color c, int blinkRate) {
            super(null);
            blinkColor=c;

            Timer t=new Timer(blinkRate, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    changeColor();
                }
            });
            t.start();
        }

        protected void changeColor() {
            if (activeColor==blinkColor) {
                activeColor=getBackground();
            }
            else {
                activeColor=blinkColor;
            }
            repaint();
        }

        public Color getColor() {
            return activeColor;
        }

    }
} 

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jFrame3 = new javax.swing.JFrame();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jDialog3 = new javax.swing.JDialog();
        jFrame4 = new javax.swing.JFrame();
        jLabel3 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jLabel13 = new javax.swing.JLabel();
        myPanel1 = new designs.MyPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        myPanel3 = new designs.MyPanel();
        cinfo = new javax.swing.JLabel();
        cminfo = new javax.swing.JLabel();
        csinfo = new javax.swing.JLabel();
        cginfo = new javax.swing.JLabel();
        ctrans = new javax.swing.JLabel();
        cpdetails = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jDesktopPanel11 = new designs.JDesktopPanel1();
        btn = new javax.swing.JButton();
        cpend = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        myPanel2 = new designs.MyPanel();
        myPanel4 = new designs.MyPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pfirst = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        plast = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pcontactNo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        pEmailID = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pAddress = new javax.swing.JTextArea();
        UserID = new javax.swing.JLabel();
        prole = new javax.swing.JLabel();
        labelcp = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenu3.setText("jMenu3");

        jMenu4.setText("jMenu4");

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame3Layout = new javax.swing.GroupLayout(jFrame3.getContentPane());
        jFrame3.getContentPane().setLayout(jFrame3Layout);
        jFrame3Layout.setHorizontalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame3Layout.setVerticalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame4Layout = new javax.swing.GroupLayout(jFrame4.getContentPane());
        jFrame4.getContentPane().setLayout(jFrame4Layout);
        jFrame4Layout.setHorizontalGroup(
            jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame4Layout.setVerticalGroup(
            jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jLabel3.setText("jLabel3");

        jLabel13.setText("jLabel13");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
            }
        });

        myPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cinfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cinfo.setText("Committee Information");
        cinfo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cinfoFocusGained(evt);
            }
        });
        cinfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cinfoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cinfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cinfoMouseExited(evt);
            }
        });

        cminfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cminfo.setText("Group Members Information");
        cminfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cminfoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cminfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cminfoMouseExited(evt);
            }
        });

        csinfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        csinfo.setText("Committee Slab Information");
        csinfo.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                csinfoComponentAdded(evt);
            }
        });
        csinfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                csinfoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                csinfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                csinfoMouseExited(evt);
            }
        });

        cginfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cginfo.setText("Committee  Group Information");
        cginfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cginfoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cginfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cginfoMouseExited(evt);
            }
        });

        ctrans.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ctrans.setText("Transactions");
        ctrans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ctransMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ctransMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ctransMouseExited(evt);
            }
        });

        cpdetails.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cpdetails.setText("Committe Picking Details");
        cpdetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cpdetailsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cpdetailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cpdetailsMouseExited(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("High Tower Text", 1, 36)); // NOI18N
        jLabel10.setText("  Welcome To The Kitty System");
        jLabel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel3FocusGained(evt);
            }
        });

        jDesktopPane1.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jDesktopPanel11Layout = new javax.swing.GroupLayout(jDesktopPanel11);
        jDesktopPanel11.setLayout(jDesktopPanel11Layout);
        jDesktopPanel11Layout.setHorizontalGroup(
            jDesktopPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPanel11Layout.setVerticalGroup(
            jDesktopPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 534, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1.setLayer(jDesktopPanel11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/designs/Capture.PNG"))); // NOI18N
        btn.setToolTipText("Log Out");
        btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });

        cpend.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cpend.setText("Committe Pending Details");
        cpend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cpendMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cpendMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cpendMouseExited(evt);
            }
        });

        javax.swing.GroupLayout myPanel3Layout = new javax.swing.GroupLayout(myPanel3);
        myPanel3.setLayout(myPanel3Layout);
        myPanel3Layout.setHorizontalGroup(
            myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel3Layout.createSequentialGroup()
                .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cginfo)
                        .addComponent(csinfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(myPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cinfo))
                    .addComponent(cminfo)
                    .addGroup(myPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cpdetails))
                    .addGroup(myPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(ctrans, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(myPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cpend)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel3Layout.createSequentialGroup()
                .addContainerGap(213, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        myPanel3Layout.setVerticalGroup(
            myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(cinfo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(cginfo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(csinfo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(cminfo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(cpdetails, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ctrans, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cpend, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("HOME", jPanel1);

        jLabel4.setFont(new java.awt.Font("High Tower Text", 1, 36)); // NOI18N
        jLabel4.setText("        Details");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("               First Name                 : ");

        pfirst.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pfirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfirstActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Last Name   :");

        plast.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("    Role                       :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Contact No                  :");

        pcontactNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pcontactNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pcontactNoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("  Address                      :");

        pEmailID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pEmailID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pEmailIDActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("    Email Id                    :");

        pAddress.setColumns(20);
        pAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pAddress.setRows(5);
        jScrollPane1.setViewportView(pAddress);

        prole.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        labelcp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelcp.setText("  Change Password");
        labelcp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelcpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelcpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelcpMouseExited(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/designs/Capture.PNG"))); // NOI18N
        btn1.setToolTipText("Log Out");
        btn1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout myPanel4Layout = new javax.swing.GroupLayout(myPanel4);
        myPanel4.setLayout(myPanel4Layout);
        myPanel4Layout.setHorizontalGroup(
            myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel4Layout.createSequentialGroup()
                .addGroup(myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(myPanel4Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                        .addGap(419, 419, 419))
                    .addGroup(myPanel4Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(UserID, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)))
                .addComponent(labelcp, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(myPanel4Layout.createSequentialGroup()
                            .addComponent(pcontactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(431, 431, 431))
                        .addGroup(myPanel4Layout.createSequentialGroup()
                            .addComponent(pfirst, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(plast, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(54, 54, 54)))
                    .addGroup(myPanel4Layout.createSequentialGroup()
                        .addGroup(myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prole, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pEmailID, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(myPanel4Layout.createSequentialGroup()
                                .addGap(257, 257, 257)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(293, 293, 293))))
            .addGroup(myPanel4Layout.createSequentialGroup()
                .addGap(421, 421, 421)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        myPanel4Layout.setVerticalGroup(
            myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UserID)
                    .addGroup(myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addComponent(labelcp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 20, Short.MAX_VALUE)
                .addGroup(myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel4Layout.createSequentialGroup()
                        .addGroup(myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pfirst, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(plast, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(24, 24, 24)
                        .addComponent(jLabel7))
                    .addComponent(prole, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(pcontactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(myPanel4Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pEmailID, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(myPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addGap(48, 48, 48)
                .addComponent(jButton1)
                .addGap(168, 168, 168))
        );

        javax.swing.GroupLayout myPanel2Layout = new javax.swing.GroupLayout(myPanel2);
        myPanel2.setLayout(myPanel2Layout);
        myPanel2Layout.setHorizontalGroup(
            myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        myPanel2Layout.setVerticalGroup(
            myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("PROFILE", jPanel2);

        javax.swing.GroupLayout myPanel1Layout = new javax.swing.GroupLayout(myPanel1);
        myPanel1.setLayout(myPanel1Layout);
        myPanel1Layout.setHorizontalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        myPanel1Layout.setVerticalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cinfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cinfoMouseClicked
        // TODO add your handling code here:
        //CommiteeInfo info=new CommiteeInfo();
        //info.setVisible(true);
        Committee_Info d=new Committee_Info(details);
      //  jDesktopPane1.removeAll();
        profilePanel p=new profilePanel();
        jDesktopPane1.add(p);
        jDesktopPane1.add(d).setVisible(true);
        jDesktopPane1.repaint();
    }//GEN-LAST:event_cinfoMouseClicked

    private void cginfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cginfoMouseClicked
        // TODO add your handling code here:
      Committee_Group grp=new Committee_Group(details);
       jDesktopPane1 .add(grp).setVisible(true);
        
    }//GEN-LAST:event_cginfoMouseClicked

    private void csinfoComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_csinfoComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_csinfoComponentAdded

    private void csinfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_csinfoMouseClicked
        // TODO add your handling code here:
        Committee_SSlab slab=new Committee_SSlab(details);
         jDesktopPane1 .add(slab).setVisible(true);
        
    }//GEN-LAST:event_csinfoMouseClicked

    private void cminfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cminfoMouseClicked
        // TODO add your handling code here:
        Committee_GroupMember gm=new Committee_GroupMember(details);
        jDesktopPane1.add(gm).setVisible(true);
       
    }//GEN-LAST:event_cminfoMouseClicked

    private void cpdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cpdetailsMouseClicked
        // TODO add your handling code here:
       Comm_PickedDetails pick=new Comm_PickedDetails();
        jDesktopPane1.add(pick).setVisible(true);
    }//GEN-LAST:event_cpdetailsMouseClicked

    private void ctransMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ctransMouseClicked
        // TODO add your handling code here:
       Committee_Transactions trans=new Committee_Transactions();
        jDesktopPane1.add (trans).setVisible(true);
    }//GEN-LAST:event_ctransMouseClicked

    private void cinfoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cinfoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_cinfoFocusGained

    private void cinfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cinfoMouseEntered
        // TODO add your handling code here:
                cinfo.setForeground(Color.WHITE);

    }//GEN-LAST:event_cinfoMouseEntered

    private void cinfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cinfoMouseExited
        // TODO add your handling code here:
                        cinfo.setForeground(Color.BLACK);

    }//GEN-LAST:event_cinfoMouseExited

    private void cginfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cginfoMouseEntered
        // TODO add your handling code here:
                        cginfo.setForeground(Color.WHITE);

    }//GEN-LAST:event_cginfoMouseEntered

    private void csinfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_csinfoMouseEntered
        // TODO add your handling code here:
                        csinfo.setForeground(Color.WHITE);

    }//GEN-LAST:event_csinfoMouseEntered

    private void cminfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cminfoMouseEntered
        // TODO add your handling code here:
                        cminfo.setForeground(Color.WHITE);

    }//GEN-LAST:event_cminfoMouseEntered

    private void cpdetailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cpdetailsMouseEntered
        // TODO add your handling code here:
                        cpdetails.setForeground(Color.WHITE);

    }//GEN-LAST:event_cpdetailsMouseEntered

    private void ctransMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ctransMouseEntered
        // TODO add your handling code here:
                        ctrans.setForeground(Color.WHITE);

    }//GEN-LAST:event_ctransMouseEntered

    private void cginfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cginfoMouseExited
        // TODO add your handling code here:
                        cginfo.setForeground(Color.BLACK);

    }//GEN-LAST:event_cginfoMouseExited

    private void csinfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_csinfoMouseExited
        // TODO add your handling code here:
                                csinfo.setForeground(Color.BLACK);

    }//GEN-LAST:event_csinfoMouseExited

    private void cminfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cminfoMouseExited
        // TODO add your handling code here:
                                cminfo.setForeground(Color.BLACK);

    }//GEN-LAST:event_cminfoMouseExited

    private void cpdetailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cpdetailsMouseExited
        // TODO add your handling code here:
                                cpdetails.setForeground(Color.BLACK);

    }//GEN-LAST:event_cpdetailsMouseExited

    private void ctransMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ctransMouseExited
        // TODO add your handling code here:
                                ctrans.setForeground(Color.BLACK);

    }//GEN-LAST:event_ctransMouseExited

    private void pcontactNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcontactNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pcontactNoActionPerformed

    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked
        // TODO add your handling code here:
        pfirst.setText(details.getFirst());
        plast.setText(details.getLast());
        prole.setText(details.getRole());
        pcontactNo.setText(details.getContact());
        pAddress.setText(details.getAddress());
        pEmailID.setText(details.getEmail());
        
        
    }//GEN-LAST:event_jTabbedPane2MouseClicked

    private void labelcpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelcpMouseClicked
        // TODO add your handling code here:
        change_Password cp=new change_Password(id);
        cp.setVisible(true);
    }//GEN-LAST:event_labelcpMouseClicked

    private void labelcpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelcpMouseEntered
        // TODO add your handling code here:
        labelcp.setForeground(Color.WHITE);
    }//GEN-LAST:event_labelcpMouseEntered

    private void labelcpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelcpMouseExited
        // TODO add your handling code here:
                labelcp.setForeground(Color.BLACK);

    }//GEN-LAST:event_labelcpMouseExited

    private void pfirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfirstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pfirstActionPerformed

    private void pEmailIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pEmailIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pEmailIDActionPerformed

    private void jPanel3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel3FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3FocusGained

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        // TODO add your handling code here:
       int i=JOptionPane.showConfirmDialog(null,"Are you sure to Logout??","Log Out",JOptionPane.YES_NO_OPTION);
       if(i==JOptionPane.YES_OPTION)
       {
            this.dispose();
            KittyLogin k=new KittyLogin();
            k.setVisible(true);
       }        
    }//GEN-LAST:event_btnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(pcontactNo.getText().trim().length()>0 && pEmailID.getText().trim().length()>0 && pAddress.getText().trim().length()>0)
        
        {
            int i=JOptionPane.showConfirmDialog(null,"Save Changes ??","Update",JOptionPane.YES_NO_OPTION);
        
       if(i==JOptionPane.YES_OPTION)
       {
           String cno=pcontactNo.getText();
           String eid=pEmailID.getText();
           String a=pAddress.getText();
            EnterDetails data=new EnterDetails();
            data.ContactUpdate(id, cno);
            data.EmailUpdate(id, eid);
            data.AddressUpdate(id, a);
       }  
        }
        else JOptionPane.showMessageDialog(null,"Fields should not left blank");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cpendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cpendMouseClicked
        // TODO add your handling code here:
        PendingDetails pd=new PendingDetails();
        jDesktopPane1.add(pd).setVisible(true);
    }//GEN-LAST:event_cpendMouseClicked

    private void cpendMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cpendMouseEntered
        // TODO add your handling code here:
        if(!cpend.getForeground().equals(Color.RED))
        {
                  cpend.setForeground(Color.WHITE);
        }         
    }//GEN-LAST:event_cpendMouseEntered

    private void cpendMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cpendMouseExited
        // TODO add your handling code here:
                if(!cpend.getForeground().equals(Color.RED))
                {
                          cpend.setForeground(Color.BLACK);
                }
    }//GEN-LAST:event_cpendMouseExited

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
         int i=JOptionPane.showConfirmDialog(null,"Are you sure to Logout??","Log Out",JOptionPane.YES_NO_OPTION);
       if(i==JOptionPane.YES_OPTION)
       {
            this.dispose();
            KittyLogin k=new KittyLogin();
            k.setVisible(true);
       }
    }//GEN-LAST:event_btn1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 new UserProfile().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UserID;
    private javax.swing.JButton btn;
    private javax.swing.JButton btn1;
    private javax.swing.JLabel cginfo;
    private javax.swing.JLabel cinfo;
    private javax.swing.JLabel cminfo;
    private javax.swing.JLabel cpdetails;
    private javax.swing.JLabel cpend;
    private javax.swing.JLabel csinfo;
    private javax.swing.JLabel ctrans;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private designs.JDesktopPanel1 jDesktopPanel11;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JFrame jFrame4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel labelcp;
    private designs.MyPanel myPanel1;
    private designs.MyPanel myPanel2;
    private designs.MyPanel myPanel3;
    private designs.MyPanel myPanel4;
    private javax.swing.JTextArea pAddress;
    private javax.swing.JTextField pEmailID;
    private javax.swing.JTextField pcontactNo;
    private javax.swing.JTextField pfirst;
    private javax.swing.JTextField plast;
    private javax.swing.JLabel prole;
    // End of variables declaration//GEN-END:variables
}
