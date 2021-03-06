/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designs;

import code.BeanCommGroup;
import code.BeanCommInfo;
import code.BeanDetails;
import code.CommGroupOperations;
import code.CommInfoOperations;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author karan
 */
public class Committee_Group extends javax.swing.JInternalFrame {

    /**
     * Creates new form Committee_Group
     */
    int row;
    String role,id,sd,ed,cd,totalmember;
      ArrayList<BeanCommInfo> list;

    public Committee_Group(BeanDetails data) {
       initComponents();
       emptyTable();
        cbId.removeAllItems();
       
        role=data.getRole();
         Remove.setEnabled(false);
         Update.setEnabled(false);
       operation();


    }
    public void operation()
    {
        
        if(role.equals("Admin"))
        {

            String str="Select * from committeeinfo";
           list=new CommInfoOperations().commInfoDisplay(str);
           cbId.addItem("    -Please Select-   ");
           if(list!=null)
           {    
           for(BeanCommInfo l:list)
           {
               cbId.addItem(l.getId()+"-"+l.getComName()+","+l.getType());
           }
           }
           else System.out.println("Error");
           

           
        }
             else
        {
            cbId.setEnabled(false);
           
            textMember.setEnabled(false);
            btnAdd.setEnabled(false);
            Update.setEnabled(false);
            Remove.setEnabled(false);
        }
        
    }
    public void emptyTable()
    {
     String[] columnNames = {"Group Id", "Committee Id","Start Date", "End Date","Collection Date","Total Members"};
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
       String[] columnNames = {"Group Id", "Committee Id","Start Date", "End Date","Collection Date","Total Members"};
       Object[][] data = null;
       ArrayList<BeanCommGroup> l=new CommGroupOperations().retrieveGroup(str);
        if(l!=null)
        {
                  int i=0;
                  data = new Object[l.size()][columnNames.length];
                  for (BeanCommGroup s : l) 
                  {
                    data[i] = new Object[]{s.getGrpId(),s.getComId(),s.getSDate(),s.getEDate(),s.getcDate(),s.getTotalMem()};
                    i++;
                    
                  }
                  
                  
                DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
              /*  {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                }; */

                  jTable1.setModel(dtm);
  
        }
        else
        {
            data = new Object[1][columnNames.length];
            data[0] = new Object[]{"No Record Found","No Record Found","No Record Found","No Record Found","No Record Found","No Record Found"};
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
        textMember = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbId = new javax.swing.JComboBox();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        grpId = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Remove = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();

        lGrpid.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lGrpid.setText("Group ID          :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("  Start Date         :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Committee ID/Name :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("End Date          :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Collection Date    :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Total Memeber    :");

        textMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMemberActionPerformed(evt);
            }
        });
        textMember.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textMemberKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("High Tower Text", 1, 36)); // NOI18N
        jLabel1.setText("   Committee Group Information");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cbId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIdActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAdd.setText("Add Group");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
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

        grpId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grpIdActionPerformed(evt);
            }
        });
        grpId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                grpIdKeyTyped(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/designs/close.png"))); // NOI18N
        jButton3.setToolTipText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Update.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        Remove.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Remove.setText("Remove");
        Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/designs/ca.PNG"))); // NOI18N
        jLabel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(51, 51, 51)));

        javax.swing.GroupLayout myPanel1Layout = new javax.swing.GroupLayout(myPanel1);
        myPanel1.setLayout(myPanel1Layout);
        myPanel1Layout.setHorizontalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(Update)
                .addGap(18, 18, 18)
                .addComponent(Remove)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(myPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbId, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(myPanel1Layout.createSequentialGroup()
                                        .addComponent(grpId, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(45, 45, 45)
                                        .addComponent(jButton2))))
                            .addGroup(myPanel1Layout.createSequentialGroup()
                                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(myPanel1Layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lGrpid, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(myPanel1Layout.createSequentialGroup()
                                                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(5, 5, 5))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(myPanel1Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(myPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(myPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(textMember, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(83, 83, 83)
                                        .addComponent(btnAdd)))))
                        .addGap(0, 169, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        myPanel1Layout.setVerticalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(myPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lGrpid)
                    .addComponent(jButton2)
                    .addComponent(grpId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(21, 21, 21)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Remove)
                    .addComponent(Update))
                .addContainerGap(13, Short.MAX_VALUE))
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

    private void textMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMemberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMemberActionPerformed

    private void cbIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIdActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cbIdActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if(cbId.getSelectedIndex()>0  && jDateChooser1.getDate()!=null && jDateChooser2.getDate()!=null && jDateChooser3.getDate()!=null && textMember.getText().trim().length()>0)
        {
           BeanCommGroup data=new BeanCommGroup();
           String []s=((String)cbId.getSelectedItem()).split("-");
           System.out.print(s[0]);
           data.setComId((Integer.parseInt(s[0])));
                       SimpleDateFormat format=new SimpleDateFormat("yyy/MM/dd");

           data.setSDate(format.format(jDateChooser1.getDate()));
           data.setEDate(format.format(jDateChooser2.getDate()));
           data.setCDate(format.format(jDateChooser3.getDate()));
            //System.out.println(""+cd3.getSelectedItem()+"-"+cd2.getSelectedItem()+"-"+cd1.getSelectedItem()+"");
           int tm=Integer.parseInt(textMember.getText().trim());
           if(tm<=20)
           {
           data.setTotalMem(tm);
           
        if(new CommGroupOperations().insertGroup(data))
        {
            JOptionPane.showMessageDialog(null,"Group Inserted");

             String str="Select *,date_format(startdate,'%D of %M, %Y'),date_format(enddate,'%D of %M, %Y'),date_format(collectiondate,'%D of %M, %Y') from committeegroup" ;

                display(str);
        }
        else             JOptionPane.showMessageDialog(null,"Insertion Failed");

        }
           else 
           {JOptionPane.showMessageDialog(null,"Memeber caannot exceed then 20");
           textMember.setText("");
           }
        }
        else JOptionPane.showMessageDialog(null,"Fields should not left blank");
    }//GEN-LAST:event_btnAddActionPerformed

    private void grpIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grpIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grpIdActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(grpId.getText().trim().length()>0)
        {    
            int c=Integer.parseInt(grpId.getText().trim());
            String str="Select *,date_format(startdate,'%D of %M, %Y'),date_format(enddate,'%D of %M, %Y'),date_format(collectiondate,'%D of %M, %Y') from committeegroup where groupid="+c;

                display(str);
       
        }
        else JOptionPane.showMessageDialog(null, "Enter Valid Group Id");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here       
        row=jTable1.getSelectedRow();  
            
      
         
         id=jTable1.getModel().getValueAt(row, 0).toString();
         sd=jTable1.getModel().getValueAt(row, 2).toString();
         ed=jTable1.getModel().getValueAt(row, 3).toString();     //value at cell
        cd=jTable1.getModel().getValueAt(row, 4).toString();
        totalmember=jTable1.getModel().getValueAt(row, 5).toString();
        
          if(row<0)
          {
              JOptionPane.showMessageDialog(null,"Select Contents from table");
          }
          else
  {
        int i=JOptionPane.showConfirmDialog(null,"Edit??","Edit",JOptionPane.YES_NO_OPTION);
       if(i==JOptionPane.YES_OPTION)
       {
        
     
        if(id!=null&& sd!=null && ed!=null && cd!=null && totalmember!=null)
        {
      
        BeanCommGroup data=new BeanCommGroup();
        data.setGrpId(Integer.parseInt(id));
        data.setSDate(sd);
        data.setEDate(ed);
        data.setCDate(cd);
        data.setTotalMem(Integer.parseInt(totalmember));
        if(new CommGroupOperations().update(data))
        {
                JOptionPane.showMessageDialog(null,"Updated");
                Update.setEnabled(false);
                int c=Integer.parseInt(grpId.getText().trim());
                String str="Select *,date_format(startdate,'%D of %M, %Y'),date_format(enddate,'%D of %M, %Y'),date_format(collectiondate,'%D of %M, %Y') from committeegroup where groupid="+c;

                display(str);

        }
                else JOptionPane.showMessageDialog(null,"Updation Failed");

        }
        else JOptionPane.showMessageDialog(null,"Row Values should not left blank");
       }
  }     
    }//GEN-LAST:event_UpdateActionPerformed

    private void RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveActionPerformed
        // TODO add your handling code here:
        row=jTable1.getSelectedRow();  
            
      
         
         id=jTable1.getModel().getValueAt(row, 0).toString();
        if(row<0)
        {
            JOptionPane.showMessageDialog(null,"Select row from table");
        }
        else
        {
            int i=JOptionPane.showConfirmDialog(null,"Remove??","Remove",JOptionPane.YES_NO_OPTION);
            if(i==JOptionPane.YES_OPTION)
            {
            String str="Delete from committeegroup where groupid="+Integer.parseInt(id);
            if(new CommGroupOperations().deleteGrp(str))
            {
                 JOptionPane.showMessageDialog(null,"Removed");
                 Remove.setEnabled(false);
                 String st="Select *,date_format(startdate,'%D of %M, %Y'),date_format(enddate,'%D of %M, %Y'),date_format(collectiondate,'%D of %M, %Y') from committeegroup ";

                display(st);

                 
            }
            else   JOptionPane.showMessageDialog(null,"Operation Failed");

            }
        }
    }//GEN-LAST:event_RemoveActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
          if(role.equals("Admin"))

        {
                    Remove.setEnabled(true);
                    Update.setEnabled(true);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void grpIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_grpIdKeyTyped
        // TODO add your handling code here:
        char vchar=evt.getKeyChar();
	if(!(Character.isDigit(vchar)))
	{
		evt.consume();
	}
    }//GEN-LAST:event_grpIdKeyTyped

    private void textMemberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textMemberKeyTyped
        // TODO add your handling code here:
        char vchar=evt.getKeyChar();
	if(!(Character.isDigit(vchar)))
	{
		evt.consume();
	}
    }//GEN-LAST:event_textMemberKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Remove;
    private javax.swing.JButton Update;
    private javax.swing.JButton btnAdd;
    private javax.swing.JComboBox cbId;
    private javax.swing.JTextField grpId;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lGrpid;
    private designs.MyPanel myPanel1;
    private javax.swing.JTextField textMember;
    // End of variables declaration//GEN-END:variables
}
