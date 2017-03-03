/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designs;

import code.BeanCommInfo;
import code.BeanCommSlab;
import code.BeanDetails;
import code.CommInfoOperations;
import code.CommitteeSlabOperations;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author karan
 */
public class Committee_SSlab extends javax.swing.JInternalFrame {

    /**
     * Creates new form Committee_SSlab
     */
    ArrayList<BeanCommSlab> list,list1;
    int row;
    String termno,amount,id;
    BeanDetails data;
    public Committee_SSlab() 
    {
        initComponents();
    }
     public Committee_SSlab(BeanDetails d) 
    {
        initComponents();
        data=d;
        // jTable2.setColumnSelectionAllowed(true);

       // jTable1.setCellEditor(null);
        emptyTable();
          Delete1.setEnabled(false);
     
        btnDisplay.setEnabled(false);
        ncbTerm.setEnabled(false);
        ncbid.addItem("-Please Select-");
        ncbTerm.addItem("-Please Select-");
    
        String str="Select * from committeeinfo";

        ArrayList<BeanCommInfo> l=new CommInfoOperations().commInfoDisplay(str);
        if(l!=null)
        {
         for(BeanCommInfo li:l)
          {
            ncbid.addItem(li.getId()+"-"+li.getComName());
           
          }
        }
        for(int i=1;i<=20;i++)  
        {
            ncbTerm.addItem(""+i);
        }
            
        
        if(data.getRole().equals("User"))
        {

            ncbTerm.setEnabled(false);
            txtAmount.setEnabled(false);
            insert.setEnabled(false);
            Delete1.setEnabled(false);
        
    }


    }
      public void emptyTable()
    {
       String[] columnNames = {"Committee Id","Committee Name ","Term No"," Amount Given"};


              Object[][] data ;
              data = new Object[0][columnNames.length];
                DefaultTableModel dtm = new DefaultTableModel(data, columnNames)
                {
                        @Override
                       public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };

             jTable2.setModel(dtm);
    }
public void display(String str)
    {
         String[] columnNames = {"Committee Id","Committee Name ","Term No"," Amount Given"};
        Object[][] data = null;

        if(list!=null)
        {
                  int i=0;
                 
                  data = new Object[list.size()][columnNames.length];
                  for (BeanCommSlab s : list) 
                  {
                    data[i] = new Object[]{""+s.getId(),s.getComName(),""+s.getTermNo(),""+s.getAmountGiven()};
                    i++;
                    
                  }
                  
                  
                DefaultTableModel dtm = new DefaultTableModel(data, columnNames)
               {
                      @Override
                       public boolean isCellEditable(int row, int column) {
                       return false;
                   }
               };   

                  jTable2.setModel(dtm);
  
        }
        else
        {
            data = new Object[1][columnNames.length];
            data[0] = new Object[]{"No Record Found","No Record Found","No Record Found","No Record Found"};
                DefaultTableModel dtm = new DefaultTableModel(data, columnNames)
                {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };


             jTable2.setModel(dtm);
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

        myPanel2 = new designs.MyPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ncbid = new javax.swing.JComboBox();
        ncbTerm = new javax.swing.JComboBox();
        btnDisplay = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        insert = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Delete1 = new javax.swing.JButton();

        jLabel6.setFont(new java.awt.Font("High Tower Text", 1, 36)); // NOI18N
        jLabel6.setText("    Committee Slabs");
        jLabel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Committee Id/Name  :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("      Term No                :");

        ncbid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ncbidActionPerformed(evt);
            }
        });

        ncbTerm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ncbTermActionPerformed(evt);
            }
        });

        btnDisplay.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDisplay.setText("Display Slabs");
        btnDisplay.setToolTipText("Search");
        btnDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable2MouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Amount Given           :");

        txtAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmountActionPerformed(evt);
            }
        });
        txtAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAmountKeyTyped(evt);
            }
        });

        insert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        insert.setText("Insert");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/designs/close.png"))); // NOI18N
        jButton4.setToolTipText("Close");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        Delete1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Delete1.setText("Delete");
        Delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout myPanel2Layout = new javax.swing.GroupLayout(myPanel2);
        myPanel2.setLayout(myPanel2Layout);
        myPanel2Layout.setHorizontalGroup(
            myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel2Layout.createSequentialGroup()
                .addGroup(myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(myPanel2Layout.createSequentialGroup()
                        .addGroup(myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(myPanel2Layout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(jLabel9))
                            .addGroup(myPanel2Layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)
                        .addGroup(myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ncbid, 0, 158, Short.MAX_VALUE)
                            .addComponent(ncbTerm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAmount))
                        .addGap(54, 54, 54)
                        .addComponent(btnDisplay)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel2Layout.createSequentialGroup()
                .addContainerGap(188, Short.MAX_VALUE)
                .addGroup(myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel2Layout.createSequentialGroup()
                        .addComponent(insert, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(304, 304, 304))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Delete1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(295, 295, 295))
        );
        myPanel2Layout.setVerticalGroup(
            myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel2Layout.createSequentialGroup()
                .addGroup(myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(myPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ncbid, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDisplay))
                .addGap(19, 19, 19)
                .addGroup(myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ncbTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(insert)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Delete1)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ncbidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ncbidActionPerformed
        // TODO add your handling code here:
        if(ncbid.getSelectedIndex()>0)
        {   btnDisplay.setEnabled(true);

            ncbTerm.setEnabled(true);
        }
        else
        btnDisplay.setEnabled(false);

    }//GEN-LAST:event_ncbidActionPerformed

    private void ncbTermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ncbTermActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ncbTermActionPerformed

    private void btnDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayActionPerformed
        // TODO add your handling code here:
        String []c=((String)ncbid.getSelectedItem()).split("-");
        // System.out.print(s[0]);
        int t=0;
        if(ncbTerm.getSelectedIndex()>0)
        {
            t=Integer.parseInt((String)ncbTerm.getSelectedItem());
        }
        String s;
        int d=Integer.parseInt(c[0]);
        int count=ncbid.getSelectedIndex();
       // JOptionPane.showMessageDialog(null, count);

       

         if(ncbid.getSelectedIndex()>0 )
        {
            if(ncbid.getSelectedIndex()>0 && ncbTerm.getSelectedIndex()>0)
            {
            s="SELECT a.committeeid,a.committeename,b.termno,b.amountgiven from committeeinfo a,committeeslab b where a.committeeid=b.committeeid and b.committeeid="+d+" and termno="+t;
            list=new CommitteeSlabOperations().retrieveSlabInfo(s);
            display(s);
            }
            else
            {
           // System.out.println("Error");
            s="SELECT a.committeeid,a.committeename,b.termno,b.amountgiven from committeeinfo a,committeeslab b where a.committeeid=b.committeeid and b.committeeid="+d;

            list=new CommitteeSlabOperations().retrieveSlabInfo(s);
            display(s);
            }
        }

    }//GEN-LAST:event_btnDisplayActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
              if(data.getRole().equals("Admin"))

        {
        Delete1.setEnabled(true);

        row=jTable2.getSelectedRow();

        id=jTable2.getModel().getValueAt(row, 0).toString();     //value at cell
        termno=jTable2.getModel().getValueAt(row, 2).toString();     //value at cell
        amount=jTable2.getModel().getValueAt(row, 3).toString();
    }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_jTable2MouseEntered

    private void txtAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmountActionPerformed

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        // TODO add your handling code here:
        String []s=((String)ncbid.getSelectedItem()).split("-");
        int i=Integer.parseInt(s[0]);
        int l1=Integer.parseInt((String)ncbTerm.getSelectedItem());
        System.out.println(i+" "+l1);
        String s1="Select * from committeeslab";
         list1=new CommitteeSlabOperations().retrieveSlabInfoMain(s1);

            if (list1 != null)      
    {
            String ans="no";
            for(BeanCommSlab li:list1)
            {
                if(i==li.getId() && l1==li.getTermNo())
                {
                    ans="exist";
                    JOptionPane.showMessageDialog(null,"Slab Already Exist");

                    break;
                }
               
            }

            if(ans.equals("no"))
            {
                if(txtAmount.getText().trim().length()>0)
                {

                    BeanCommSlab data=new BeanCommSlab();
                    data.setId(i);
                    System.out.print(i);
                    data.setTermNo(l1);
                    System.out.print(l1);

                    data.setAmountGiven(Integer.parseInt(txtAmount.getText().trim()));
                    if(new CommitteeSlabOperations().insertSlab(data))
                    {
                        JOptionPane.showMessageDialog(null,"Slab Inserted");
                        String []c=((String)ncbid.getSelectedItem()).split("-");

                        int t=Integer.parseInt((String) ncbTerm.getSelectedItem());
                        String st;
                        if(ncbid.getSelectedIndex()>0 && ncbTerm.getSelectedIndex()>0)
                        {
                            st="SELECT a.committeeid,a.committeename,b.termno,b.amountgiven from committeeinfo a,committeeslab b where a.committeeid=b.committeeid and b.committeeid="+Integer.parseInt(c[0])+" and termno="+t;
                            list=new CommitteeSlabOperations().retrieveSlabInfo(st);
                            display(st);
                        }
                        else if(ncbid.getSelectedIndex()>0 )
                        {
                            st="SELECT a.committeeid,a.committeename,b.termno,b.amountgiven from committeeinfo a,committeeslab b where a.committeeid=b.committeeid and b.committeeid="+Integer.parseInt(c[0]);

                            list=new CommitteeSlabOperations().retrieveSlabInfo(st);
                            display(st);
                        }

                    }
                    else
                    JOptionPane.showMessageDialog(null,"Insertion failed");

                }          else  JOptionPane.showMessageDialog(null,"Fields Should not left blank");

            }
            //else JOptionPane.showMessageDialog(null,"error");
    }
            else
            {
                 if(txtAmount.getText().trim().length()>0)
                {

                    BeanCommSlab data=new BeanCommSlab();
                    data.setId(i);
                    System.out.print(i);
                    data.setTermNo(l1);
                    System.out.print(l1);

                    data.setAmountGiven(Integer.parseInt(txtAmount.getText().trim()));
                    if(new CommitteeSlabOperations().insertSlab(data))
                    {
                        JOptionPane.showMessageDialog(null,"Slab Inserted");
                        String []c=((String)ncbid.getSelectedItem()).split("-");

                        int t=Integer.parseInt((String) ncbTerm.getSelectedItem());
                        String st;
                        if(ncbid.getSelectedIndex()>0 && ncbTerm.getSelectedIndex()>0)
                        {
                            st="SELECT a.committeeid,a.committeename,b.termno,b.amountgiven from committeeinfo a,committeeslab b where a.committeeid=b.committeeid and b.committeeid="+Integer.parseInt(c[0])+" and termno="+t;
                            list=new CommitteeSlabOperations().retrieveSlabInfo(st);
                            display(st);
                        }
                        else if(ncbid.getSelectedIndex()>0 )
                        {
                            st="SELECT a.committeeid,a.committeename,b.termno,b.amountgiven from committeeinfo a,committeeslab b where a.committeeid=b.committeeid and b.committeeid="+Integer.parseInt(c[0]);

                            list=new CommitteeSlabOperations().retrieveSlabInfo(st);
                            display(st);
                        }

                    }
                    else
                    JOptionPane.showMessageDialog(null,"Insertion failed");

                }         
                 else  JOptionPane.showMessageDialog(null,"Fields Should not left blank");

                
            }
        
    }//GEN-LAST:event_insertActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void Delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete1ActionPerformed
        // TODO add your handling code here:

        row=jTable2.getSelectedRow();

        id=jTable2.getModel().getValueAt(row, 0).toString();     //value at cell
        int termno=Integer.parseInt(jTable2.getModel().getValueAt(row, 2).toString());
        int i=JOptionPane.showConfirmDialog(null,"Edit??","Edit",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION)
        {

            BeanCommSlab data=new BeanCommSlab();
            data.setId(Integer.parseInt(id));
            data.setTermNo(termno);
            if(new CommitteeSlabOperations().delete(data))
            {
                JOptionPane.showMessageDialog(null,"Removed");
                Delete1.setEnabled(false);
                String []c=((String)ncbid.getSelectedItem()).split("-");
                // System.out.print(s[0]);
                int t=(int) ncbTerm.getSelectedIndex();
                String s;
                if(ncbid.getSelectedIndex()>0 && ncbTerm.getSelectedIndex()>0)
                {
                    s="SELECT a.committeeid,a.committeename,b.termno,b.amountgiven from committeeinfo a,committeeslab b where a.committeeid=b.committeeid and b.committeeid="+Integer.parseInt(c[0])+" and termno="+t;
                    list=new CommitteeSlabOperations().retrieveSlabInfo(s);
                    display(s);
                }
                else if(ncbid.getSelectedIndex()>0 )
                {
                    s="SELECT a.committeeid,a.committeename,b.termno,b.amountgiven from committeeinfo a,committeeslab b where a.committeeid=b.committeeid and b.committeeid="+Integer.parseInt(c[0]);

                    list=new CommitteeSlabOperations().retrieveSlabInfo(s);
                    display(s);
                }

            }
            else JOptionPane.showMessageDialog(null,"Updation Failed");

        }

    }//GEN-LAST:event_Delete1ActionPerformed

    private void txtAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountKeyTyped
        // TODO add your handling code here:
        char vchar=evt.getKeyChar();
	if(!(Character.isDigit(vchar)))
	{
		evt.consume();
	}
    }//GEN-LAST:event_txtAmountKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete1;
    private javax.swing.JButton btnDisplay;
    private javax.swing.JButton insert;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private designs.MyPanel myPanel2;
    private javax.swing.JComboBox ncbTerm;
    private javax.swing.JComboBox ncbid;
    private javax.swing.JTextField txtAmount;
    // End of variables declaration//GEN-END:variables
}