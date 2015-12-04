package worcapsysem;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class worcapClient extends javax.swing.JFrame {
    DBConnect db = new DBConnect();
    private Connection con;
    private ResultSet rs;
    private Statement s = null;
    DefaultTableModel model;
    
    public worcapClient() throws SQLException {
        initComponents();
        con = db.getConnection();
        s = con.createStatement();
        model = (DefaultTableModel) projectLists.getModel();
        String query = "SELECT Projects.ProjectName, UserProjects.userID FROM UserProjects INNER JOIN Projects ON Projects.ProjectID = UserProjects.ProjectID";
        rs = s.executeQuery(query);
        while(rs.next())
        {
            String val = rs.getString("ProjectName");
            model.insertRow(0, new String[]{val});
        }
        hideAllUn();
    }
    
    public String getProjName(){
        return projName.getText();
    }
    
    public void hideAllUn(){
        projName.setVisible(false);
        this.userID.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        projectLists = new javax.swing.JTable();
        projName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        userID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));
        setResizable(false);

        jLabel1.setText("Choose Project:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Instruction:");

        jLabel3.setText("Select project to which you want to log time. You can switch projects at anytime");

        projectLists.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        projectLists.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Project Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        projectLists.setGridColor(new java.awt.Color(204, 204, 255));
        projectLists.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        projectLists.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                projectListsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(projectLists);
        if (projectLists.getColumnModel().getColumnCount() > 0) {
            projectLists.getColumnModel().getColumn(0).setResizable(false);
        }

        projName.setText("Name");

        jLabel4.setText("you want.");

        userID.setText("UserID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(projName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(userID))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(projName)))
                    .addComponent(userID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void projectListsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projectListsMouseClicked
        if(evt.getClickCount() == 2 && !evt.isConsumed())
        {
            evt.consume();
            int sel = projectLists.getSelectedRow();
            String proj = (String) projectLists.getValueAt(sel, 0);
            try {
                TaskInfo t = new TaskInfo();
                t.set(proj);
                t.userID.setText(this.userID.getText().toString());
                t.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(worcapClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.setVisible(false);
        }
    }//GEN-LAST:event_projectListsMouseClicked
    
    private void addValuesToTable() throws SQLException{
        
    }
    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new worcapClient().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(worcapClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
   public javax.swing.JLabel getLabel1(){
       return jLabel1;
   }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel projName;
    private javax.swing.JTable projectLists;
    public javax.swing.JLabel userID;
    // End of variables declaration//GEN-END:variables
}