/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.stockmaster.stockmasterdb.view;

import br.com.stockmaster.stockmasterdb.classes.Product;
import br.com.stockmaster.stockmasterdb.classes.Supplier;
import br.com.stockmaster.stockmasterdb.dao.ProductDAO;
import br.com.stockmaster.stockmasterdb.dao.SupplierDAO;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author leona
 */
public class ProductsEdit extends javax.swing.JFrame {

   private int productId;
   ProductDAO pdao = new ProductDAO();
   SupplierDAO sdao = new SupplierDAO();
   private List<Product> products = pdao.getAll();
    private List<Supplier> suppliers = sdao.getAll();
   
    public ProductsEdit(int id){
        
        initComponents();
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setExtendedState(MAXIMIZED_BOTH);
        comboBoxUpdate();
        FieldsUpdate(id);
        this.productId = id;
        
    }
    
    private void comboBoxUpdate(){
    for (Supplier s : suppliers){
    supplierBox.addItem(s);
    }
    }
    private void FieldsUpdate(int id){
        Product p = pdao.findById(id);
        nameField.setText(p.getName());
        categoryBox.setSelectedItem(p.getCategory());
        supplierBox.setSelectedItem(p.getSupplier());
        QuantityField.setText(String.valueOf(p.getQuantity()));
        costField.setText(String.valueOf(p.getCostValue()));
        sellField.setText(String.valueOf(p.getSellValue()));
        NotesArea.setText(p.getNotes());
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradiente1 = new br.com.stockmaster.stockmasterdb.swing.PanelGradiente();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lProduct = new javax.swing.JButton();
        cProduct = new javax.swing.JButton();
        lSupplier = new javax.swing.JButton();
        cSupplier = new javax.swing.JButton();
        cCustomer = new javax.swing.JButton();
        lCustomer = new javax.swing.JButton();
        lEmployeer = new javax.swing.JButton();
        cEmployeer = new javax.swing.JButton();
        rEntry = new javax.swing.JButton();
        rSales = new javax.swing.JButton();
        rOut = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        QuantityField = new javax.swing.JTextField();
        sellField = new javax.swing.JTextField();
        costField = new javax.swing.JTextField();
        supplierBox = new javax.swing.JComboBox<>();
        categoryBox = new javax.swing.JComboBox<>();
        returnButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        NotesArea = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelGradiente5 = new br.com.stockmaster.stockmasterdb.swing.PanelGradiente();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        lProduct4 = new javax.swing.JButton();
        lSupplier2 = new javax.swing.JButton();
        cSupplier2 = new javax.swing.JButton();
        cCustomer2 = new javax.swing.JButton();
        lCustomer2 = new javax.swing.JButton();
        lEmployeer2 = new javax.swing.JButton();
        cEmployeer2 = new javax.swing.JButton();
        rEntry2 = new javax.swing.JButton();
        rSales2 = new javax.swing.JButton();
        rOut2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        panelGradiente1.setLayout(null);

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
        cProduct.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cProductActionPerformed(evt);
            }
        });
        panelGradiente1.add(cProduct);
        cProduct.setBounds(10, 190, 200, 20);

        lSupplier.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        lSupplier.setText("Lista de Fornecedores");
        lSupplier.setBorderPainted(false);
        lSupplier.setContentAreaFilled(false);
        lSupplier.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lSupplierActionPerformed(evt);
            }
        });
        panelGradiente1.add(lSupplier);
        lSupplier.setBounds(10, 280, 200, 20);

        cSupplier.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        cSupplier.setText("Cadastro de Fornecedores");
        cSupplier.setBorderPainted(false);
        cSupplier.setContentAreaFilled(false);
        cSupplier.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cSupplierActionPerformed(evt);
            }
        });
        panelGradiente1.add(cSupplier);
        cSupplier.setBounds(10, 260, 240, 20);

        cCustomer.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        cCustomer.setText("Cadastro de Clientes");
        cCustomer.setBorderPainted(false);
        cCustomer.setContentAreaFilled(false);
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
        rEntry.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rEntryActionPerformed(evt);
            }
        });
        panelGradiente1.add(rEntry);
        rEntry.setBounds(0, 500, 240, 20);

        rSales.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        rSales.setText("Registro de Venda");
        rSales.setBorderPainted(false);
        rSales.setContentAreaFilled(false);
        rSales.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSalesActionPerformed(evt);
            }
        });
        panelGradiente1.add(rSales);
        rSales.setBounds(0, 540, 240, 20);

        rOut.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        rOut.setText("Registro de Saída de Estoque");
        rOut.setBorderPainted(false);
        rOut.setContentAreaFilled(false);
        rOut.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rOutActionPerformed(evt);
            }
        });
        panelGradiente1.add(rOut);
        rOut.setBounds(0, 520, 240, 20);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("NOME:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("CATEGORIA:");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("FORNECEDOR:");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("QUANTIDADE:");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("VALOR DE CUSTO:");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("VALOR DE VENDA:");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("DESCRIÇÃO:");

        nameField.setBackground(new java.awt.Color(204, 204, 204));
        nameField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        nameField.setForeground(new java.awt.Color(0, 0, 0));
        nameField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));

        QuantityField.setBackground(new java.awt.Color(204, 204, 204));
        QuantityField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        QuantityField.setForeground(new java.awt.Color(0, 0, 0));
        QuantityField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));

        sellField.setBackground(new java.awt.Color(204, 204, 204));
        sellField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        sellField.setForeground(new java.awt.Color(0, 0, 0));
        sellField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        sellField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellFieldActionPerformed(evt);
            }
        });

        costField.setBackground(new java.awt.Color(204, 204, 204));
        costField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        costField.setForeground(new java.awt.Color(0, 0, 0));
        costField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        costField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costFieldActionPerformed(evt);
            }
        });

        supplierBox.setBackground(new java.awt.Color(204, 204, 204));
        supplierBox.setForeground(new java.awt.Color(0, 0, 0));
        supplierBox.setLightWeightPopupEnabled(false);
        supplierBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierBoxActionPerformed(evt);
            }
        });

        categoryBox.setBackground(new java.awt.Color(204, 204, 204));
        categoryBox.setForeground(new java.awt.Color(0, 0, 0));
        categoryBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Eletrônicos", "Móveis", "Roupas e acessórios", "Alimentos e bebidas", "Higiene e beleza", "Material de escritório", "Ferramentas e construção", "Brinquedos", "Saúde e medicamentos", "Esporte e lazer", "Outros..." }));
        categoryBox.setLightWeightPopupEnabled(false);

        returnButton.setBackground(new java.awt.Color(255, 102, 102));
        returnButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        returnButton.setText("VOLTAR");
        returnButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        saveButton.setBackground(new java.awt.Color(0, 153, 51));
        saveButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        saveButton.setText("SALVAR");
        saveButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        NotesArea.setBackground(new java.awt.Color(204, 204, 204));
        NotesArea.setColumns(20);
        NotesArea.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        NotesArea.setForeground(new java.awt.Color(0, 0, 0));
        NotesArea.setRows(5);
        jScrollPane1.setViewportView(NotesArea);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(4, 4, 4)
                        .addComponent(categoryBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel14)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(costField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addGap(3, 3, 3)
                        .addComponent(sellField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameField))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(QuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supplierBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(categoryBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(supplierBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(QuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(sellField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(costField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("EDITAR CADASTRO DE PRODUTOS");

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

        panelGradiente5.setPrimaryColor(new java.awt.Color(0, 153, 255));
        panelGradiente5.setSecondaryColor(new java.awt.Color(0, 153, 204));

        jLabel33.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("StockMaster");
        panelGradiente5.add(jLabel33);
        jLabel33.setBounds(0, 70, 260, 47);

        jLabel34.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel34.setText("- ESTOQUE");
        panelGradiente5.add(jLabel34);
        jLabel34.setBounds(10, 470, 180, 24);

        jLabel35.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel35.setText("- PRODUTOS");
        panelGradiente5.add(jLabel35);
        jLabel35.setBounds(10, 160, 180, 24);

        jLabel36.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel36.setText("- FORNECEDORES");
        panelGradiente5.add(jLabel36);
        jLabel36.setBounds(10, 230, 180, 24);

        jLabel37.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel37.setText("- CLIENTES");
        panelGradiente5.add(jLabel37);
        jLabel37.setBounds(10, 310, 180, 24);

        jLabel38.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel38.setText("- FUNCIONÁRIO");
        panelGradiente5.add(jLabel38);
        jLabel38.setBounds(10, 390, 180, 24);

        lProduct4.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        lProduct4.setText("Lista de Produtos");
        lProduct4.setBorderPainted(false);
        lProduct4.setContentAreaFilled(false);
        lProduct4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lProduct4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lProduct4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lProduct4ActionPerformed(evt);
            }
        });
        panelGradiente5.add(lProduct4);
        lProduct4.setBounds(10, 210, 200, 20);

        lSupplier2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        lSupplier2.setText("Lista de Fornecedores");
        lSupplier2.setBorderPainted(false);
        lSupplier2.setContentAreaFilled(false);
        lSupplier2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lSupplier2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lSupplier2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lSupplier2ActionPerformed(evt);
            }
        });
        panelGradiente5.add(lSupplier2);
        lSupplier2.setBounds(10, 280, 200, 20);

        cSupplier2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        cSupplier2.setText("Cadastro de Fornecedores");
        cSupplier2.setBorderPainted(false);
        cSupplier2.setContentAreaFilled(false);
        cSupplier2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cSupplier2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cSupplier2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cSupplier2ActionPerformed(evt);
            }
        });
        panelGradiente5.add(cSupplier2);
        cSupplier2.setBounds(10, 260, 240, 20);

        cCustomer2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        cCustomer2.setText("Cadastro de Clientes");
        cCustomer2.setBorderPainted(false);
        cCustomer2.setContentAreaFilled(false);
        cCustomer2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cCustomer2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cCustomer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cCustomer2ActionPerformed(evt);
            }
        });
        panelGradiente5.add(cCustomer2);
        cCustomer2.setBounds(0, 340, 240, 20);

        lCustomer2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        lCustomer2.setText("Lista de Clientes");
        lCustomer2.setBorderPainted(false);
        lCustomer2.setContentAreaFilled(false);
        lCustomer2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lCustomer2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lCustomer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lCustomer2ActionPerformed(evt);
            }
        });
        panelGradiente5.add(lCustomer2);
        lCustomer2.setBounds(0, 360, 200, 20);

        lEmployeer2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        lEmployeer2.setText("Lista de Funcionários");
        lEmployeer2.setBorderPainted(false);
        lEmployeer2.setContentAreaFilled(false);
        lEmployeer2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lEmployeer2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lEmployeer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lEmployeer2ActionPerformed(evt);
            }
        });
        panelGradiente5.add(lEmployeer2);
        lEmployeer2.setBounds(0, 440, 200, 20);

        cEmployeer2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        cEmployeer2.setText("Cadastro de Funcionário");
        cEmployeer2.setBorderPainted(false);
        cEmployeer2.setContentAreaFilled(false);
        cEmployeer2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cEmployeer2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cEmployeer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cEmployeer2ActionPerformed(evt);
            }
        });
        panelGradiente5.add(cEmployeer2);
        cEmployeer2.setBounds(0, 420, 240, 20);

        rEntry2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        rEntry2.setText("Registro de Entrada de Estoque");
        rEntry2.setBorderPainted(false);
        rEntry2.setContentAreaFilled(false);
        rEntry2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rEntry2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rEntry2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rEntry2ActionPerformed(evt);
            }
        });
        panelGradiente5.add(rEntry2);
        rEntry2.setBounds(0, 500, 240, 20);

        rSales2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        rSales2.setText("Registro de Venda");
        rSales2.setBorderPainted(false);
        rSales2.setContentAreaFilled(false);
        rSales2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rSales2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSales2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSales2ActionPerformed(evt);
            }
        });
        panelGradiente5.add(rSales2);
        rSales2.setBounds(0, 540, 240, 20);

        rOut2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        rOut2.setText("Registro de Saída de Estoque");
        rOut2.setBorderPainted(false);
        rOut2.setContentAreaFilled(false);
        rOut2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rOut2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rOut2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rOut2ActionPerformed(evt);
            }
        });
        panelGradiente5.add(rOut2);
        rOut2.setBounds(0, 520, 240, 20);

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 255));
        jLabel15.setText("- Cadastro de Produtos");
        panelGradiente5.add(jLabel15);
        jLabel15.setBounds(30, 190, 280, 18);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelGradiente5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addComponent(panelGradiente5, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
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

    private void sellFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sellFieldActionPerformed

    private void costFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_costFieldActionPerformed

    private void lProduct4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lProduct4ActionPerformed
        ProductsList lProduct = new ProductsList();
        lProduct.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lProduct4ActionPerformed

    private void lSupplier2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lSupplier2ActionPerformed
        SupplierList lSupplier = new SupplierList();
        lSupplier.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lSupplier2ActionPerformed

    private void cSupplier2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cSupplier2ActionPerformed
        SupplierRegister rSupplier = new SupplierRegister();
        rSupplier.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cSupplier2ActionPerformed

    private void cCustomer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cCustomer2ActionPerformed
        CustomerRegister cCustomer = new CustomerRegister();
        cCustomer.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cCustomer2ActionPerformed

    private void lCustomer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lCustomer2ActionPerformed
        CustomerList lCustomer = new CustomerList();
        lCustomer.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lCustomer2ActionPerformed

    private void lEmployeer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lEmployeer2ActionPerformed
        EmployerList lEmployer = new EmployerList();
        lEmployer.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lEmployeer2ActionPerformed

    private void cEmployeer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cEmployeer2ActionPerformed
        EmployerRegister rEmployer = new EmployerRegister();
        rEmployer.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cEmployeer2ActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
    try {
        // Obtém os valores dos campos
        String name = nameField.getText().trim();
        String categoryName = (String) categoryBox.getSelectedItem();
        Supplier supplier = (Supplier) supplierBox.getSelectedItem();
        String quantityRaw = QuantityField.getText().trim();
        String costRaw = costField.getText().trim();
        String sellRaw = sellField.getText().trim();
        String obs = NotesArea.getText().trim();

        // Validação de preenchimento
        if (name.isEmpty() || categoryName == null || categoryName.trim().isEmpty()
                || supplier == null || quantityRaw.isEmpty() 
                || costRaw.isEmpty() || sellRaw.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos corretamente!");
            return;
        }

        // Conversão de valores numéricos
        int quantity;
        BigDecimal costValue;
        BigDecimal sellValue;

        try {
            quantity = Integer.parseInt(quantityRaw);
            if (quantity < 0) {
                JOptionPane.showMessageDialog(this, "A QUANTIDADE não pode ser negativa!");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "QUANTIDADE inválida! Informe um número inteiro.");
            return;
        }

        try {
            costValue = new BigDecimal(costRaw);
            if (costValue.compareTo(BigDecimal.ZERO) <= 0) {
                JOptionPane.showMessageDialog(this, "VALOR DE CUSTO deve ser maior que zero!");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "VALOR DE CUSTO inválido! Informe um número válido.");
            return;
        }

        try {
            sellValue = new BigDecimal(sellRaw);
            if (sellValue.compareTo(BigDecimal.ZERO) <= 0) {
                JOptionPane.showMessageDialog(this, "VALOR DE VENDA deve ser maior que zero!");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "VALOR DE VENDA inválido! Informe um número válido.");
            return;
        }

        // Atualiza produto usando DAO
        Product product = pdao.findById(productId);
        if (product != null) {
            product.setName(name);
            product.setCategory(categoryName);
            product.setSupplier(supplier);
            product.setQuantity(quantity);
            product.setCostValue(costValue);
            product.setSellValue(sellValue);
            product.setNotes(obs);
            pdao.update(product);

            JOptionPane.showMessageDialog(this, "Produto atualizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Produto não encontrado!");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao salvar produto: " + e.getMessage());
    }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void supplierBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplierBoxActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
ProductsList list = new ProductsList();
list.setVisible(true);
this.dispose();
    }//GEN-LAST:event_returnButtonActionPerformed

    private void rSales2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSales2ActionPerformed
    SalesRegister rSale = new SalesRegister();
    rSale.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_rSales2ActionPerformed

    private void rOut2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rOut2ActionPerformed
    StockOutRegister rOut = new StockOutRegister();
    rOut.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_rOut2ActionPerformed

    private void rEntry2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rEntry2ActionPerformed
EntryRegister rEntry = new EntryRegister();
rEntry.setVisible(true);
this.dispose();
    }//GEN-LAST:event_rEntry2ActionPerformed

    private void rOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rOutActionPerformed

    private void rSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSalesActionPerformed

    private void rEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rEntryActionPerformed

    }//GEN-LAST:event_rEntryActionPerformed

    private void cEmployeerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cEmployeerActionPerformed
        EmployerRegister rEmployer = new EmployerRegister();
        rEmployer.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cEmployeerActionPerformed

    private void lEmployeerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lEmployeerActionPerformed
        EmployerList lEmployer = new EmployerList();
        lEmployer.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lEmployeerActionPerformed

    private void lCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lCustomerActionPerformed
        CustomerList lCustomer = new CustomerList();
        lCustomer.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lCustomerActionPerformed

    private void cCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cCustomerActionPerformed
        CustomerRegister rCustomer = new CustomerRegister();
        rCustomer.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cCustomerActionPerformed

    private void cSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cSupplierActionPerformed
        SupplierRegister rSupplier = new SupplierRegister();
        rSupplier.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cSupplierActionPerformed

    private void lSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lSupplierActionPerformed
        SupplierList lSupplier = new SupplierList();
        lSupplier.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lSupplierActionPerformed

    private void cProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cProductActionPerformed

    }//GEN-LAST:event_cProductActionPerformed

    private void lProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lProductActionPerformed
        ProductsList lProduct = new ProductsList();
        lProduct.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lProductActionPerformed

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
            java.util.logging.Logger.getLogger(ProductsEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductsEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductsEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductsEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea NotesArea;
    private javax.swing.JTextField QuantityField;
    private javax.swing.JButton cCustomer;
    private javax.swing.JButton cCustomer2;
    private javax.swing.JButton cEmployeer;
    private javax.swing.JButton cEmployeer2;
    private javax.swing.JButton cProduct;
    private javax.swing.JButton cSupplier;
    private javax.swing.JButton cSupplier2;
    private javax.swing.JComboBox<String> categoryBox;
    private javax.swing.JTextField costField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lCustomer;
    private javax.swing.JButton lCustomer2;
    private javax.swing.JButton lEmployeer;
    private javax.swing.JButton lEmployeer2;
    private javax.swing.JButton lProduct;
    private javax.swing.JButton lProduct4;
    private javax.swing.JButton lSupplier;
    private javax.swing.JButton lSupplier2;
    private javax.swing.JTextField nameField;
    private br.com.stockmaster.stockmasterdb.swing.PanelGradiente panelGradiente1;
    private br.com.stockmaster.stockmasterdb.swing.PanelGradiente panelGradiente5;
    private javax.swing.JButton rEntry;
    private javax.swing.JButton rEntry2;
    private javax.swing.JButton rOut;
    private javax.swing.JButton rOut2;
    private javax.swing.JButton rSales;
    private javax.swing.JButton rSales2;
    private javax.swing.JButton returnButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField sellField;
    private javax.swing.JComboBox<Supplier> supplierBox;
    // End of variables declaration//GEN-END:variables
}