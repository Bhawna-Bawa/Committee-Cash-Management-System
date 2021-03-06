/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designs;

import code.BeanCommGroup;
import code.BeanCommPick;
import code.BeanDetails;
import code.CommGroupOperations;
import code.CommGrpMemOperations;
import code.CommPickOperations;
import code.CommitteeSlabOperations;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author karan
 */
public class Comm_PickedDetails extends javax.swing.JInternalFrame {

    /**
     * Creates new form Comm_PickedDetails
     */
      ArrayList<BeanCommGroup> cg;
      BeanCommPick data;
       ArrayList<BeanCommPick> l;
       String gid,uid;
       int row;
       
    public Comm_PickedDetails() 
    {
          
        initComponents();
      
       emptyTable();
    
        String cgs="Select *,date_format(startdate,'%D of %M, %Y'),date_format(enddate,'%D of %M, %Y'),date_format(collectiondate,'%D of %M, %Y') from committeegroup";
         cg= new CommGroupOperations().retrieveGroup(cgs);
                  Update.setEnabled(false);
         if(cg!=null)
         {      
        for(BeanCommGroup l:cg)
        {
            cbGId.addItem(""+l.getGrpId());
            
        }
         }
          
        
    } 
     public void emptyTable()
    {
    String[] columnNames = {"Group Id", "User Id","Name", "Term No","Picked Date Date","Amount","Status"};
 

              Object[][] data ;
              data = new Object[0][columnNames.length];
                DefaultTableModel dtm = new DefaultTableModel(data, columnNames)
                {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };

             jTable1.setModel(dtm);
    }
    
      public void display( String str)
    {
         String[] columnNames = {"Group Id", "User Id","Name", "Term No","Picked Date Date","Amount","Status"};
        Object[][] data = null;
       l=new CommPickOperations().retrievePick(str);
        if(l!=null)
        {
                  int i=0;
                  data = new Object[l.size()][columnNames.length];
                  for (BeanCommPick s : l) 
                  {
    data[i] = new Object[]{""+s.getGId(),""+s.getUId(),s.getName(),""+s.getTerm(),s.getDate(),""+s.getAmount(),s.getStatus()};
                    i++;
                    
                  }
                  
                  
                DefaultTableModel dtm = new DefaultTableModel(data, columnNames)
                {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };

                  jTable1.setModel(dtm);
                  
  
        }
        else
        {
            data = new Object[1][columnNames.length];
            data[0] = new Object[]{"No Record Found","No Record Found","No Record Found","No Record Found","No Record Found","No Record Found","No Record Found"};
                DefaultTableModel dtm = new DefaultTableModel(data, columnNames)
                {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };


             jTable1.setModel(dtm);
        }
        
    }
    
    
   
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myPanel1 = new designs.MyPanel();
        lGrpid = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbGId = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cbUId = new javax.swing.JComboBox();
        cbTermNo = new javax.swing.JComboBox();
        txtAmount = new javax.swing.JTextField();
        btnPick = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();

        lGrpid.setFont(new java.awt.Font("High Tower Text", 1, 36)); // NOI18N
        lGrpid.setText("   Picking Details");
        lGrpid.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("   User Id/Name     :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("      Group ID         :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("  Term No        :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Pick Date       :   ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("  Amount        :");

        cbGId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Select-" }));
        cbGId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGIdActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        cbUId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Select-" }));
        cbUId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUIdActionPerformed(evt);
            }
        });

        cbTermNo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Select-" }));
        cbTermNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTermNoActionPerformed(evt);
            }
        });

        txtAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmountActionPerformed(evt);
            }
        });

        btnPick.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPick.setText("Pick");
        btnPick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPickActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/designs/close.png"))); // NOI18N
        jButton5.setToolTipText("Close");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        Update.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Update.setText("Remove");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/designs/pick1.PNG"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 51), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout myPanel1Layout = new javax.swing.GroupLayout(myPanel1);
        myPanel1.setLayout(myPanel1Layout);
        myPanel1Layout.setHorizontalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                        .addGap(0, 107, Short.MAX_VALUE)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbTermNo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbUId, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbGId, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtAmount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)))
                                .addGap(259, 259, 259))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                                .addComponent(btnPick, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(286, 286, 286))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(35, 35, 35)
                                .addComponent(lGrpid, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Update)
                .addGap(284, 284, 284))
        );
        myPanel1Layout.setVerticalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lGrpid, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbGId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbUId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbTermNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(14, 14, 14)
                .addComponent(btnPick)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Update)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmountActionPerformed

    private void cbGIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGIdActionPerformed
        // TODO add your handling code here:
        //cbUId.removeAllItems();
        
        if(cbGId.getSelectedIndex()>0)
        {
        
        int gid=Integer.parseInt((String) cbGId.getSelectedItem());

           String s="Select a.groupid,a.User_Id,a.termno,date_format(a.pickeddate,'%D of %M, %Y')as ddate,a.amount,a.status,b.FirstName,b.LastName from  pickeddetails a,logindetails b where a.User_Id=b.User_Id and groupid="+gid;
           display(s);
        }
        else JOptionPane.showMessageDialog(null, "Select Group Id");
    
         if(cbGId.getSelectedIndex()>0) 
         {
        cbUId.removeAllItems();
       int id=Integer.parseInt((String) cbGId.getSelectedItem());
            //System.out.println(id);
            String s="select a.User_Id,b.FirstName,b.LastName,b.ContactNo,b.EmailId from groupmember a,logindetails b where a.User_Id=b.User_Id and groupid="+id;
           ArrayList<BeanDetails> l=new CommGrpMemOperations().allMembers(s);
            cbUId.addItem("-Select");
            if(l!=null)
            {
           for(BeanDetails m:l)
           {
              cbUId.addItem(""+m.getUserId()+"-"+m.getFirst()+" "+m.getLast());
           }
           
            }
        }
       
         
        
    }//GEN-LAST:event_cbGIdActionPerformed

    private void btnPickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPickActionPerformed
        // TODO add your handling code here:
       
        
        if(cbGId.getSelectedIndex()>0 && cbUId.getSelectedIndex()>0 &&  cbTermNo.getSelectedIndex()>0 && jDateChooser1.getDate()!=null &&txtAmount.getText().trim().length()>0)
    {       int gid=Integer.parseInt((String)cbGId.getSelectedItem());
            String []c=((String)cbUId.getSelectedItem()).split("-");
            data.setGId(Integer.parseInt(""+ cbGId.getSelectedItem())); 
            String status=new CommPickOperations().Status(Integer.parseInt(c[0]));
            if(!(status.equals("Picked")))
        {    
            data.setUId(Integer.parseInt(c[0]));            
            data.setTerm(Integer.parseInt(""+ cbTermNo.getSelectedItem()));  
            SimpleDateFormat format=new SimpleDateFormat("yyy/MM/dd");
           
            data.setPDate(format.format(jDateChooser1.getDate()));
            data.setAmount(Integer.parseInt(txtAmount.getText().trim()));
           
            if(new CommPickOperations().insertPickDetails(data))
            {
              JOptionPane.showMessageDialog(null, "Picking details Inserted");
           String s="Select a.groupid,a.User_Id,a.termno,date_format(a.pickeddate,'%D of %M, %Y')as ddate,a.amount,a.status,b.FirstName,b.LastName from  pickeddetails a,logindetails b where a.User_Id=b.User_Id and groupid="+gid;
           display(s);
              
  
            }
            else JOptionPane.showMessageDialog(null, "Operation Failed");

            
        }
            else JOptionPane.showMessageDialog(null,"Cannot Picked");
    }    
        else JOptionPane.showMessageDialog(null, "Fields should not left blank");
    }//GEN-LAST:event_btnPickActionPerformed

    private void cbTermNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTermNoActionPerformed
        // TODO add your handling code here:
        
        
        data=new BeanCommPick();
              int t= cbTermNo.getSelectedIndex();
              System.out.println(t);

             int gid=Integer.parseInt((String) cbGId.getSelectedItem());
            String g="Select committeeid from committeegroup where groupid="+gid;
            int cid=new CommGroupOperations().getComId(g);
            if(cid!=-1)
            {
            String s="Select amountgiven from committeeslab where  committeeid="+cid+" and termno="+t;
            int q=new CommitteeSlabOperations().amountGiven(s);
                if(q!=-1)
                {

                txtAmount.setText(""+q);
                txtAmount.setEnabled(false);
                }
                
                else 
                {
                    txtAmount.setText("");
                   JOptionPane.showMessageDialog(null,"No Value found");
                                

                }
            }
    }//GEN-LAST:event_cbTermNoActionPerformed

    private void cbUIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUIdActionPerformed
        // TODO add your handling code here:
         if(cbUId.getSelectedIndex()>0)
          for(int i=1;i<=20;i++)  
        {
            cbTermNo.addItem(i);
        }
         
       
       
       
    }//GEN-LAST:event_cbUIdActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:
        row=jTable1.getSelectedRow();
        
        gid=jTable1.getModel().getValueAt(row, 0).toString();

        uid=jTable1.getModel().getValueAt(row, 1).toString();
      
        int i=JOptionPane.showConfirmDialog(null,"Are you sure to remove??","Remove",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION)
        {

            if(new CommPickOperations().update(Integer.parseInt(gid),Integer.parseInt(uid)))
            {
                JOptionPane.showMessageDialog(null,"Removed");
                Update.setEnabled(false);
                int gid=Integer.parseInt((String) cbGId.getSelectedItem());

           String s="Select a.groupid,a.User_Id,a.termno,date_format(a.pickeddate,'%D of %M, %Y')as ddate,a.amount,a.status,b.FirstName,b.LastName from  pickeddetails a,logindetails b where a.User_Id=b.User_Id and groupid="+gid;
           display(s);

            }
            else JOptionPane.showMessageDialog(null,"Remove Operation Failed");

        }
       
    }//GEN-LAST:event_UpdateActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
     
        // TODO add your handling code here:

        {
        row=jTable1.getSelectedRow();
        
        gid=jTable1.getModel().getValueAt(row, 0).toString();

        uid=jTable1.getModel().getValueAt(row, 1).toString();
                 Update.setEnabled(true);
    }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Update;
    private javax.swing.JButton btnPick;
    private javax.swing.JComboBox cbGId;
    private javax.swing.JComboBox cbTermNo;
    private javax.swing.JComboBox cbUId;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lGrpid;
    private designs.MyPanel myPanel1;
    private javax.swing.JTextField txtAmount;
    // End of variables declaration//GEN-END:variables
}
