/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.stockmaster.stockmasterdb.view;

import br.com.stockmaster.stockmasterdb.classes.Customer;
import br.com.stockmaster.stockmasterdb.classes.Product;
import br.com.stockmaster.stockmasterdb.classes.Sale;
import br.com.stockmaster.stockmasterdb.classes.Supplier;
import br.com.stockmaster.stockmasterdb.dao.CustomerDAO;
import br.com.stockmaster.stockmasterdb.dao.ProductDAO;
import br.com.stockmaster.stockmasterdb.dao.salesDAO;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leona
 */
public class SalesRegister extends javax.swing.JFrame {
    List<Product> products = new ProductDAO().getAll();
    
    public SalesRegister() {
        initComponents();
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setExtendedState(MAXIMIZED_BOTH);
        comboBoxUpdate();
        listUpdate();
        fieldUpdate();
        
        quantityField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
        public void insertUpdate(javax.swing.event.DocumentEvent e) { fieldUpdate(); }
        public void removeUpdate(javax.swing.event.DocumentEvent e) { fieldUpdate(); }
        public void changedUpdate(javax.swing.event.DocumentEvent e) { fieldUpdate(); }
    });
    }
    
    private void comboBoxUpdate(){
        List<Customer> customers = new CustomerDAO().getAll();
        for (Product p : products){
        productBox.addItem(p);
        }
        for (Customer c : customers){
        customerBox.addItem(c);
        }
        }
    
    public void fieldUpdate(){
        Product selected = (Product) productBox.getSelectedItem();
        if (selected == null) return;
        
        int quantity;
        try{
        quantity = Integer.parseInt(quantityField.getText().trim());
        }catch(NumberFormatException e){
        quantity = 0;
        }
        
        BigDecimal quantityBd = BigDecimal.valueOf(quantity);
        
        BigDecimal totalValue = selected.getSellValue().multiply(quantityBd);
        BigDecimal totalCost = selected.getCostValue().multiply(quantityBd);
        BigDecimal profit = totalValue.subtract(totalCost);
        
        valueField.setText(totalValue.toString());
        profitField.setText(profit.toString());
    }
    
    public void listUpdate(){
    String[] columns = {"ID","Nome","Categoria","Fornecedor","Quantidade","Valor de custo","Valor de venda","Descrição"};
    DefaultTableModel model = new DefaultTableModel(columns, 0);
    
    for (Product p : products){
    Object[] row = {
        p.getId(),
        p.getName(),
        p.getCategory(),
        p.getSupplier(),
        p.getQuantity(),
        p.getCostValue(),
        p.getSellValue(),
        p.getNotes(),
    };
    model.addRow(row);
    }
    
    productTable.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelGradiente1 = new br.com.stockmaster.stockmasterdb.swing.PanelGradiente();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lProduct = new javax.swing.JButton();
        cProduct = new javax.swing.JButton();
        rSupplier = new javax.swing.JButton();
        cCustomer = new javax.swing.JButton();
        lCustomer = new javax.swing.JButton();
        lEmployeer = new javax.swing.JButton();
        cEmployeer = new javax.swing.JButton();
        rEntry = new javax.swing.JButton();
        rOut = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        lSupplier = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        returnButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();
        quantityField = new javax.swing.JTextField();
        productBox = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        dataField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        profitField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        valueField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        customerBox = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        panelGradiente1.setPrimaryColor(new java.awt.Color(0, 153, 255));
        panelGradiente1.setSecondaryColor(new java.awt.Color(0, 153, 204));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("StockMaster");
        panelGradiente1.add(jLabel4);
        jLabel4.setBounds(0, 70, 260, 47);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("- ESTOQUE");
        panelGradiente1.add(jLabel5);
        jLabel5.setBounds(10, 470, 180, 24);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("- PRODUTOS");
        panelGradiente1.add(jLabel6);
        jLabel6.setBounds(10, 160, 180, 24);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("- FORNECEDORES");
        panelGradiente1.add(jLabel7);
        jLabel7.setBounds(10, 230, 180, 24);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("- CLIENTES");
        panelGradiente1.add(jLabel8);
        jLabel8.setBounds(10, 310, 180, 24);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("- FUNCIONÁRIO");
        panelGradiente1.add(jLabel9);
        jLabel9.setBounds(10, 390, 180, 24);

        lProduct.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        lProduct.setText("Lista de Produtos");
        lProduct.setBorderPainted(false);
        lProduct.setContentAreaFilled(false);
        lProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lProduct.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lProductActionPerformed(evt);
            }
        });
        panelGradiente1.add(lProduct);
        lProduct.setBounds(10, 210, 200, 20);

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
        panelGradiente1.add(cProduct);
        cProduct.setBounds(10, 190, 200, 20);

        rSupplier.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        rSupplier.setText("Cadastro de Fornecedores");
        rSupplier.setBorderPainted(false);
        rSupplier.setContentAreaFilled(false);
        rSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rSupplier.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSupplierActionPerformed(evt);
            }
        });
        panelGradiente1.add(rSupplier);
        rSupplier.setBounds(10, 260, 210, 20);

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
        panelGradiente1.add(cCustomer);
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
        panelGradiente1.add(lCustomer);
        lCustomer.setBounds(0, 360, 200, 20);

        lEmployeer.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        lEmployeer.setText("Lista de Funcionários");
        lEmployeer.setBorderPainted(false);
        lEmployeer.setContentAreaFilled(false);
        lEmployeer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lEmployeer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lEmployeer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lEmployeerActionPerformed(evt);
            }
        });
        panelGradiente1.add(lEmployeer);
        lEmployeer.setBounds(0, 440, 200, 20);

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
        panelGradiente1.add(cEmployeer);
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
        panelGradiente1.add(rEntry);
        rEntry.setBounds(0, 500, 240, 20);

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
        panelGradiente1.add(rOut);
        rOut.setBounds(0, 520, 240, 20);

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 255));
        jLabel13.setText("- Registro de Vendas");
        panelGradiente1.add(jLabel13);
        jLabel13.setBounds(20, 540, 190, 18);

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
        panelGradiente1.add(lSupplier);
        lSupplier.setBounds(10, 280, 200, 20);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel4.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("PRODUTO :");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("QUANTIDADE:");

        returnButton.setBackground(new java.awt.Color(255, 102, 102));
        returnButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        returnButton.setText("VOLTAR");
        returnButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        registerButton.setBackground(new java.awt.Color(0, 153, 51));
        registerButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        registerButton.setText("SALVAR");
        registerButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        quantityField.setBackground(new java.awt.Color(204, 204, 204));
        quantityField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        quantityField.setForeground(new java.awt.Color(0, 0, 0));
        quantityField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));

        productBox.setBackground(new java.awt.Color(204, 204, 204));
        productBox.setForeground(new java.awt.Color(0, 0, 0));
        productBox.setLightWeightPopupEnabled(false);
        productBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productBoxActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("DATA: ");

        dataField.setBackground(new java.awt.Color(204, 204, 204));
        dataField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        dataField.setForeground(new java.awt.Color(0, 0, 0));
        dataField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));

        productTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(productTable);

        profitField.setEditable(false);
        profitField.setBackground(new java.awt.Color(172, 172, 172));
        profitField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        profitField.setForeground(new java.awt.Color(0, 0, 0));
        profitField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("LUCRO: ");

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("VALOR: ");

        valueField.setEditable(false);
        valueField.setBackground(new java.awt.Color(172, 172, 172));
        valueField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        valueField.setForeground(new java.awt.Color(0, 0, 0));
        valueField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        valueField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valueFieldActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("CLIENTE:");

        customerBox.setBackground(new java.awt.Color(204, 204, 204));
        customerBox.setForeground(new java.awt.Color(0, 0, 0));
        customerBox.setLightWeightPopupEnabled(false);
        customerBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customerBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addGap(2, 2, 2)
                        .addComponent(dataField))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(4, 4, 4)
                        .addComponent(valueField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addGap(4, 4, 4)
                        .addComponent(profitField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(125, 125, 125))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(productBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(customerBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(dataField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(profitField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(valueField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("REGISTRO DE VENDAS");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelGradiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
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

    private void rOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rOutActionPerformed
    StockOutRegister rOut = new StockOutRegister();
    rOut.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_rOutActionPerformed

    private void rEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rEntryActionPerformed
EntryRegister rEntry = new EntryRegister();
rEntry.setVisible(true);
this.dispose();
    }//GEN-LAST:event_rEntryActionPerformed

    private void cEmployeerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cEmployeerActionPerformed
    EmployerRegister rEmployer = new EmployerRegister();
rEmployer.setVisible(true);
this.dispose();
    }//GEN-LAST:event_cEmployeerActionPerformed

    private void lEmployeerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lEmployeerActionPerformed
        // TODO add your handling code here:
        EmployerList lEmployer = new EmployerList();
lEmployer.setVisible(true);
this.dispose();
    }//GEN-LAST:event_lEmployeerActionPerformed

    private void lCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lCustomerActionPerformed
        // TODO add your handling code here:
        CustomerList lCustomer = new CustomerList();
lCustomer.setVisible(true);
this.dispose();
    }//GEN-LAST:event_lCustomerActionPerformed

    private void cCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cCustomerActionPerformed
        // TODO add your handling code here:
        CustomerRegister rCustomer = new CustomerRegister();
rCustomer.setVisible(true);
this.dispose();
    }//GEN-LAST:event_cCustomerActionPerformed

    private void rSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSupplierActionPerformed
        // TODO add your handling code here:
        SupplierRegister rSupplier = new SupplierRegister();
rSupplier.setVisible(true);
this.dispose();
    }//GEN-LAST:event_rSupplierActionPerformed

    private void cProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cProductActionPerformed
        // TODO add your handling code here:
        ProductsRegister rProduct = new ProductsRegister();
rProduct.setVisible(true);
this.dispose();
    }//GEN-LAST:event_cProductActionPerformed

    private void lProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lProductActionPerformed
        // TODO add your handling code here:
        ProductsList lProduct = new ProductsList();
lProduct.setVisible(true);
this.dispose();
    }//GEN-LAST:event_lProductActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
    Product product = (Product) productBox.getSelectedItem();
    Customer customer = (Customer) customerBox.getSelectedItem();
    String quantityText = quantityField.getText();
    String dateString = dataField.getText();
    String totalValueText = valueField.getText();
    String profitText = profitField.getText();

    // Validação de produto e cliente selecionados
    if (product == null) {
        JOptionPane.showMessageDialog(rootPane, "Selecione um produto!");
        return;
    }

    if (customer == null) {
        JOptionPane.showMessageDialog(rootPane, "Selecione um cliente!");
        return;
    }

    // Validação de quantidade
    int quantity;
    try {
        quantity = Integer.parseInt(quantityText);
        if (quantity <= 0) {
            JOptionPane.showMessageDialog(rootPane, "Quantidade deve ser maior que 0.");
            return;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(rootPane, "Quantidade inválida! Digite um número inteiro.");
        return;
    }

    // Verifica estoque
    if (!product.decreaseQuantity(quantity)) {
        JOptionPane.showMessageDialog(rootPane, "Quantidade insuficiente! Disponível: " + product.getQuantity());
        return;
    }

    // Validação de valores numéricos
    BigDecimal totalValue, profit;
    try {
        totalValue = new BigDecimal(totalValueText);
        profit = new BigDecimal(profitText);

        if (totalValue.compareTo(BigDecimal.ZERO) <= 0 || profit.compareTo(BigDecimal.ZERO) < 0) {
            JOptionPane.showMessageDialog(rootPane, "Valores devem ser positivos!");
            return;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(rootPane, "Digite valores válidos para total e lucro.");
        return;
    }

    // Validação de data no formato YYYY/MM/DD
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate parsedDate;
            try {
                parsedDate = LocalDate.parse(dateString, formatter);
            } catch (DateTimeParseException e1) {
                JOptionPane.showMessageDialog(rootPane, "Data inválida! Use o formato YYYY/MM/DD. Ex: 2000/12/10");
                return;
            }


    // Registro da venda
    Sale sell = new Sale();
    sell.setCustomer(customer);
    sell.setDate(parsedDate);
    sell.setProduct(product);
    sell.setProfit(profit);
    sell.setQuantity(quantity);
    sell.setValue(totalValue);
    new salesDAO().save(sell);

    // Atualiza lista
    listUpdate();

    JOptionPane.showMessageDialog(rootPane, "Venda registrada com sucesso!");
        productBox.setSelectedIndex(0);
        customerBox.setSelectedIndex(0);
        quantityField.setText("");
        dataField.setText("");
    }//GEN-LAST:event_registerButtonActionPerformed

    private void productBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productBoxActionPerformed
        fieldUpdate();
    }//GEN-LAST:event_productBoxActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
MainPage mainPage = new MainPage();
mainPage.setVisible(true);
this.dispose();
    }//GEN-LAST:event_returnButtonActionPerformed

    private void valueFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valueFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valueFieldActionPerformed

    private void customerBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerBoxActionPerformed

    private void lSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lSupplierActionPerformed
SupplierList lSupplier = new SupplierList();
lSupplier.setVisible(true);
this.dispose();
    }//GEN-LAST:event_lSupplierActionPerformed

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
            java.util.logging.Logger.getLogger(SalesRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cCustomer;
    private javax.swing.JButton cEmployeer;
    private javax.swing.JButton cProduct;
    private javax.swing.JComboBox<Customer> customerBox;
    private javax.swing.JTextField dataField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton lCustomer;
    private javax.swing.JButton lEmployeer;
    private javax.swing.JButton lProduct;
    private javax.swing.JButton lSupplier;
    private br.com.stockmaster.stockmasterdb.swing.PanelGradiente panelGradiente1;
    private javax.swing.JComboBox<Product> productBox;
    private javax.swing.JTable productTable;
    private javax.swing.JTextField profitField;
    private javax.swing.JTextField quantityField;
    private javax.swing.JButton rEntry;
    private javax.swing.JButton rOut;
    private javax.swing.JButton rSupplier;
    private javax.swing.JButton registerButton;
    private javax.swing.JButton returnButton;
    private javax.swing.JTextField valueField;
    // End of variables declaration//GEN-END:variables
}
