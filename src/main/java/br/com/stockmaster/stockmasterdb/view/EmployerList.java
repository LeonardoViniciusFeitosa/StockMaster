/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.stockmaster.stockmasterdb.view;

import br.com.stockmaster.stockmasterdb.classes.TempDatabase;
import br.com.stockmaster.stockmasterdb.classes.Customer;
import br.com.stockmaster.stockmasterdb.classes.Employer;
import br.com.stockmaster.stockmasterdb.dao.EmployerDAO;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leona
 */
public class EmployerList extends javax.swing.JFrame {

    public EmployerList() {
        initComponents();
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setExtendedState(MAXIMIZED_BOTH);
        listUpdate();
    }
    
    public void listUpdate(){
    String[] columns = {"ID","Nome","CPF","Endereço","Telefone","Email","Cargo"};
        // Modelo de tabela que não permite edição manual
    DefaultTableModel model = new DefaultTableModel(columns, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // nenhuma célula pode ser editada
        }
    };
    List<Employer> employers = new EmployerDAO().getAll();
    
    for (Employer e : employers){
    Object[] row = {
    e.getId(),
        e.getName(),
        e.getPersonalId(),
        e.getAddress(),
        e.getNumber(),
        e.getEmail(),
        e.getRole()
    };
    model.addRow(row);
    }
    
    employerTable.setModel(model);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        returnButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        employerTable = new javax.swing.JTable();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelGradiente4 = new br.com.stockmaster.stockmasterdb.swing.PanelGradiente();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lProduct3 = new javax.swing.JButton();
        cProduct = new javax.swing.JButton();
        lSupplier = new javax.swing.JButton();
        cSupplier = new javax.swing.JButton();
        cCustomer = new javax.swing.JButton();
        lCustomer = new javax.swing.JButton();
        cEmployeer = new javax.swing.JButton();
        rEntry = new javax.swing.JButton();
        rSales = new javax.swing.JButton();
        rOut = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N

        returnButton.setBackground(new java.awt.Color(153, 153, 153));
        returnButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        returnButton.setText("VOLTAR");
        returnButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setForeground(new java.awt.Color(0, 0, 0));

        employerTable.setBackground(new java.awt.Color(153, 153, 153));
        employerTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(employerTable);

        editButton.setBackground(new java.awt.Color(0, 204, 51));
        editButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        editButton.setText("EDITAR");
        editButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(255, 102, 102));
        deleteButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        deleteButton.setText("EXCLUIR");
        deleteButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("LISTA DE FUNCIONÁRIOS");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelGradiente4.setPrimaryColor(new java.awt.Color(0, 153, 255));
        panelGradiente4.setSecondaryColor(new java.awt.Color(0, 153, 204));

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("StockMaster");
        panelGradiente4.add(jLabel22);
        jLabel22.setBounds(0, 70, 260, 47);

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel23.setText("- ESTOQUE");
        panelGradiente4.add(jLabel23);
        jLabel23.setBounds(10, 470, 180, 24);

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel24.setText("- PRODUTOS");
        panelGradiente4.add(jLabel24);
        jLabel24.setBounds(10, 160, 180, 24);

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel25.setText("- FORNECEDORES");
        panelGradiente4.add(jLabel25);
        jLabel25.setBounds(10, 230, 180, 24);

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel26.setText("- CLIENTES");
        panelGradiente4.add(jLabel26);
        jLabel26.setBounds(10, 310, 180, 24);

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel27.setText("- FUNCIONÁRIO");
        panelGradiente4.add(jLabel27);
        jLabel27.setBounds(10, 390, 180, 24);

        lProduct3.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        lProduct3.setText("Lista de Produtos");
        lProduct3.setBorderPainted(false);
        lProduct3.setContentAreaFilled(false);
        lProduct3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lProduct3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lProduct3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lProduct3ActionPerformed(evt);
            }
        });
        panelGradiente4.add(lProduct3);
        lProduct3.setBounds(10, 210, 200, 20);

        cProduct.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        cProduct.setText("Cadastro de Produtos");
        cProduct.setBorderPainted(false);
        cProduct.setContentAreaFilled(false);
        cProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cProduct.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cProductActionPerformed(evt);
            }
        });
        panelGradiente4.add(cProduct);
        cProduct.setBounds(10, 190, 200, 20);

        lSupplier.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        lSupplier.setText("Lista de Fornecedores");
        lSupplier.setBorderPainted(false);
        lSupplier.setContentAreaFilled(false);
        lSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lSupplier.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lSupplierActionPerformed(evt);
            }
        });
        panelGradiente4.add(lSupplier);
        lSupplier.setBounds(10, 280, 200, 20);

        cSupplier.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        cSupplier.setText("Cadastro de Fornecedores");
        cSupplier.setBorderPainted(false);
        cSupplier.setContentAreaFilled(false);
        cSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cSupplier.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cSupplierActionPerformed(evt);
            }
        });
        panelGradiente4.add(cSupplier);
        cSupplier.setBounds(10, 260, 240, 20);

        cCustomer.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        cCustomer.setText("Cadastro de Clientes");
        cCustomer.setBorderPainted(false);
        cCustomer.setContentAreaFilled(false);
        cCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cCustomer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cCustomerActionPerformed(evt);
            }
        });
        panelGradiente4.add(cCustomer);
        cCustomer.setBounds(0, 340, 240, 20);

        lCustomer.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        lCustomer.setText("Lista de Clientes");
        lCustomer.setBorderPainted(false);
        lCustomer.setContentAreaFilled(false);
        lCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lCustomer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lCustomerActionPerformed(evt);
            }
        });
        panelGradiente4.add(lCustomer);
        lCustomer.setBounds(0, 360, 200, 20);

        cEmployeer.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        cEmployeer.setText("Cadastro de Funcionário");
        cEmployeer.setBorderPainted(false);
        cEmployeer.setContentAreaFilled(false);
        cEmployeer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cEmployeer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cEmployeer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cEmployeerActionPerformed(evt);
            }
        });
        panelGradiente4.add(cEmployeer);
        cEmployeer.setBounds(0, 420, 240, 20);

        rEntry.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        rEntry.setText("Registro de Entrada de Estoque");
        rEntry.setBorderPainted(false);
        rEntry.setContentAreaFilled(false);
        rEntry.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rEntry.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rEntryActionPerformed(evt);
            }
        });
        panelGradiente4.add(rEntry);
        rEntry.setBounds(0, 500, 240, 20);

        rSales.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        rSales.setText("Registro de Venda");
        rSales.setBorderPainted(false);
        rSales.setContentAreaFilled(false);
        rSales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rSales.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSalesActionPerformed(evt);
            }
        });
        panelGradiente4.add(rSales);
        rSales.setBounds(0, 540, 240, 20);

        rOut.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        rOut.setText("Registro de Saída de Estoque");
        rOut.setBorderPainted(false);
        rOut.setContentAreaFilled(false);
        rOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rOut.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rOutActionPerformed(evt);
            }
        });
        panelGradiente4.add(rOut);
        rOut.setBounds(0, 520, 240, 20);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("- Lista de Funcionários");
        panelGradiente4.add(jLabel1);
        jLabel1.setBounds(20, 440, 220, 15);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelGradiente4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addComponent(panelGradiente4, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lProduct3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lProduct3ActionPerformed
        ProductsList lProduct = new ProductsList();
        lProduct.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lProduct3ActionPerformed

    private void cProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cProductActionPerformed
        ProductsRegister rProduct = new ProductsRegister();
        rProduct.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cProductActionPerformed

    private void lSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lSupplierActionPerformed
        SupplierList lSupplier = new SupplierList();
        lSupplier.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lSupplierActionPerformed

    private void cSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cSupplierActionPerformed
        SupplierRegister rSupplier = new SupplierRegister();
        rSupplier.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cSupplierActionPerformed

    private void cCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cCustomerActionPerformed
        CustomerRegister rCustomer = new CustomerRegister();
        rCustomer.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cCustomerActionPerformed

    private void lCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lCustomerActionPerformed
        CustomerList lCustomer = new CustomerList();
        lCustomer.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lCustomerActionPerformed

    private void cEmployeerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cEmployeerActionPerformed
        EmployerRegister rEmployer = new EmployerRegister();
        rEmployer.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cEmployeerActionPerformed

    private void rEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rEntryActionPerformed
EntryRegister rEntry = new EntryRegister();
rEntry.setVisible(true);
this.dispose();
    }//GEN-LAST:event_rEntryActionPerformed

    private void rSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSalesActionPerformed
    SalesRegister rSale = new SalesRegister();
    rSale.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_rSalesActionPerformed

    private void rOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rOutActionPerformed
    StockOutRegister rOut = new StockOutRegister();
    rOut.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_rOutActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
MainPage mainPage = new MainPage();
mainPage.setVisible(true);
this.dispose();
    }//GEN-LAST:event_returnButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        int selectedRow = employerTable.getSelectedRow();
        
        if (selectedRow == -1){
        JOptionPane.showMessageDialog(rootPane, "Selecione um funcionário para editar!");
        return;
        }
        EmployerEdit edit = new EmployerEdit((int) employerTable.getValueAt(selectedRow, 0));
        edit.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
int selectedRow = employerTable.getSelectedRow();
if (selectedRow == -1){
    JOptionPane.showMessageDialog(this, "Selecione um funcionário!");
    return;
}
String n = (String) employerTable.getValueAt(selectedRow, 1);
int id = (int) employerTable.getValueAt(selectedRow, 0);
int r = JOptionPane.showConfirmDialog(this, "Tem certeza de que deseja deleter " + n + "?", "Confirmação", JOptionPane.YES_OPTION, JOptionPane.NO_OPTION);
if (r == JOptionPane.YES_OPTION){
new EmployerDAO().delete(id);
}
listUpdate();
    }//GEN-LAST:event_deleteButtonActionPerformed

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
            java.util.logging.Logger.getLogger(EmployerList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployerList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployerList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployerList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployerList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cCustomer;
    private javax.swing.JButton cEmployeer;
    private javax.swing.JButton cProduct;
    private javax.swing.JButton cSupplier;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JTable employerTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lCustomer;
    private javax.swing.JButton lProduct3;
    private javax.swing.JButton lSupplier;
    private br.com.stockmaster.stockmasterdb.swing.PanelGradiente panelGradiente4;
    private javax.swing.JButton rEntry;
    private javax.swing.JButton rOut;
    private javax.swing.JButton rSales;
    private javax.swing.JButton returnButton;
    // End of variables declaration//GEN-END:variables
}
