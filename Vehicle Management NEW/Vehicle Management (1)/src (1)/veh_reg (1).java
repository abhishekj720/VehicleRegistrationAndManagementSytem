
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ankit Akash
 */
public class veh_reg extends javax.swing.JFrame {
    String vid,oid,old;
    int flag;
    public veh_reg(String v) {
        vid=v;
        //oid=o;
        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        txtVid.setText(vid);
           // txtOid.setText(oid);
        
    }
    public veh_reg(String v,int f,String o,String name) {
        oid=v;
        flag=f;
        old=name;
         initComponents();
         setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
         
         txtOid.setText(oid);
         txtOid.setEnabled(false);
         txtVid.setText(name);
         txtVid.setEnabled(false);
        
        
       
        
    }
    public veh_reg() {
        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    }
    private void change()
    {   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtRegid = new javax.swing.JTextField();
        txtVid = new javax.swing.JTextField();
        txtRegDate = new javax.swing.JTextField();
        txtOid = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Enter Registration ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(470, 280, 332, 44);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setText("Enter Vehicle Number");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(470, 370, 344, 44);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setText("Enter Registration Date");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(470, 450, 369, 44);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setText("Enter Owner ID");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(470, 540, 247, 44);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel5.setText("Registration Details");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(750, 140, 409, 58);

        txtRegid.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        getContentPane().add(txtRegid);
        txtRegid.setBounds(1130, 270, 427, 50);

        txtVid.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        getContentPane().add(txtVid);
        txtVid.setBounds(1130, 360, 427, 50);

        txtRegDate.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        getContentPane().add(txtRegDate);
        txtRegDate.setBounds(1130, 440, 427, 50);

        txtOid.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtOid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOidActionPerformed(evt);
            }
        });
        getContentPane().add(txtOid);
        txtOid.setBounds(1130, 530, 427, 50);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jButton1.setText("SUBMIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(840, 640, 231, 97);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Filling-out-form-1.jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(260, 80, 1770, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Connection con=null;
         PreparedStatement stm=null;
        if(flag==0) {
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project?zeroDateTimeBehavior=convertToNull","root","14011996");
            stm=con.prepareStatement("insert into registration values(?,?,?,?)");
            stm.setString(1,txtRegid.getText());
            stm.setString(2,txtVid.getText());
            stm.setString(3,txtRegDate.getText());
            stm.setString(4,txtOid.getText());
            
            int i=stm.executeUpdate();
            System.out.print(i);
            if(i>0)
            {
                JOptionPane.showMessageDialog(null,"Registration Successfull");
            }
            else
                JOptionPane.showMessageDialog(null,"Invalid Input");
            
           

            
        } catch (SQLException ex) {
            Logger.getLogger(new_owner_info.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    if(flag==1){
    PreparedStatement stm1=null;
    String rdate=txtRegDate.getText();
    String rid=txtRegid.getText();
    System.out.println(rid);
        try {
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project?zeroDateTimeBehavior=convertToNull","root","14011996");
           stm1=conn.prepareStatement("update registration set cus_id=?,reg_date=?,reg_id=?,veh_no=? where veh_no=?");
           System.out.println(old+"HYU");
           //ystem.out.println(oid);
           stm1.setString(1,oid);
           stm1.setString(2,rdate);
           stm1.setString(3,txtRegid.getText());
           stm1.setString(4,old);
           stm1.setString(5,old);
         
           //stm1.setString
           System.out.println(old);
           System.out.println(oid);
           // stm.setString(1,oid);
           int i=stm1.executeUpdate();
            System.out.print(i);
            if(i>0)
            {
                JOptionPane.showMessageDialog(null,"UPDATION Successfull");
            }
            else
                JOptionPane.showMessageDialog(null,"Invalid Input");
            
           
        
        } catch (SQLException ex) {
            Logger.getLogger(veh_reg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    }
    private void txtOidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOidActionPerformed

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
            java.util.logging.Logger.getLogger(veh_reg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(veh_reg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(veh_reg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(veh_reg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new veh_reg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtOid;
    private javax.swing.JTextField txtRegDate;
    private javax.swing.JTextField txtRegid;
    private javax.swing.JTextField txtVid;
    // End of variables declaration//GEN-END:variables
}
