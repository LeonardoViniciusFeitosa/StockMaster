/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.stockmaster.stockmasterdb.view;

import br.com.stockmaster.stockmasterdb.classes.Product;
import br.com.stockmaster.stockmasterdb.classes.StockEntry;
import br.com.stockmaster.stockmasterdb.classes.StockOut;
import br.com.stockmaster.stockmasterdb.classes.Sale;
import br.com.stockmaster.stockmasterdb.classes.User;
import br.com.stockmaster.stockmasterdb.dao.UserDAO;
import br.com.stockmaster.stockmasterdb.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leona
 */
public class MainPage extends javax.swing.JFrame {

    /**
     * Creates new form mainPage
     */
    public MainPage() {
        initComponents();
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setExtendedState(MAXIMIZED_BOTH);
        
        listsUpdate(JPAUtil.getEntityManager());
        textUpdate(JPAUtil.getEntityManager());
        
  User active = UserDAO.getActiveUser();
if (active != null) {
    jLabel1.setText("Bem vindo, " + active.getUsername());
}
    }
    
    public void textUpdate(EntityManager em){
        BigDecimal totalCost = BigDecimal.ZERO;
        BigDecimal totalSell = BigDecimal.ZERO;
        BigDecimal totalProfit = BigDecimal.ZERO;
        
        try{
            List<Product> products = em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
            
            for (Product p : products){
            BigDecimal quantity = BigDecimal.valueOf(p.getQuantity());
            totalCost = totalCost.add(p.getCostValue().multiply(quantity));
            totalSell = totalSell.add(p.getSellValue().multiply(quantity));
            }
             totalProfit = totalSell.subtract(totalCost);
             
             // Atualiza os campos na interface
        costValue.setText("R$" + totalCost.toPlainString());
        sellValue.setText("R$" + totalSell.toPlainString());
        profitValue.setText("R$" + totalProfit.toPlainString());
        }
        catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao calcular valores: " + e.getMessage());
        }
    }
    
     public void listsUpdate(EntityManager em) {
         // -------- StockEntry --------
    String[] entryColumns = {"ID","Produto","Fornecedor","Quantidade","Data","Observações"};
    DefaultTableModel entryModel = new DefaultTableModel(entryColumns, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    List<StockEntry> entries = em.createQuery("SELECT e FROM StockEntry e", StockEntry.class)
                                 .getResultList();
    for (StockEntry e : entries) {
        Object[] row = {
            e.getId(),
            e.getProduct().getName(),
            e.getSupplier().getName(),
            e.getQuantity(),
            e.getDate(),
            e.getNotes()
        };
        entryModel.addRow(row);
    }
    entryTable.setModel(entryModel);

        // -------- StockOut --------
    String[] outColumns = {"ID","Produto","Quantidade","Data","Observações"};
    DefaultTableModel outModel = new DefaultTableModel(outColumns, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    List<StockOut> outs = em.createQuery("SELECT o FROM StockOut o", StockOut.class)
                             .getResultList();
    for (StockOut o : outs) {
        Object[] row = {
            o.getId(),
            o.getProduct().getName(),
            o.getQuantity(),
            o.getDate(),
            o.getNotes()
        };
        outModel.addRow(row);
    }
    outTable.setModel(outModel);

    // -------- Sale --------
    String[] sellColumns = {"ID", "Produto", "Cliente", "Quantidade", "Data", "Valor", "Lucro"};
    DefaultTableModel sellModel = new DefaultTableModel(sellColumns, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    List<Sale> sales = em.createQuery("SELECT s FROM Sale s", Sale.class)
                         .getResultList();
    for (Sale s : sales) {
        Object[] row = {
            s.getId(),
            s.getProduct().getName(),
            s.getCustomer().getName(),
            s.getQuantity(),
            s.getDate(),
            s.getValue(),
            s.getProfit()
        };
        sellModel.addRow(row);
    }
    sellTable.setModel(sellModel);
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelGradiente1 = panelGradiente1 = new br.com.stockmaster.stockmasterdb.swing.PanelGradiente();
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
        jPanel2 = new javax.swing.JPanel();
        costValue = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        profitValue = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        entryTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        outTable = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        sellTable = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        sellValue = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

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
        panelGradiente1.add(cSupplier);
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
        panelGradiente1.add(rSales);
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
        panelGradiente1.add(rOut);
        rOut.setBounds(0, 520, 240, 20);

        costValue.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        costValue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        costValue.setText("R$XX,XX");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("TOTAL EM ESTOQUE (CUSTO TOTAL)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(costValue, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(costValue, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        profitValue.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        profitValue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        profitValue.setText("R$XX,XX");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel11.setText("TOTAL EM ESTOQUE (LUCRO)");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(profitValue, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profitValue, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("BEM VINDO, USUÁRIO");

        entryTable.setModel(new javax.swing.table.DefaultTableModel(
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
        entryTable.setEnabled(false);
        jScrollPane1.setViewportView(entryTable);

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("REGISTRO DE ENTRADAS DE ESTOQUE");

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
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        outTable.setModel(new javax.swing.table.DefaultTableModel(
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
        outTable.setEnabled(false);
        jScrollPane2.setViewportView(outTable);

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("REGISTRO DE SAÍDAS DE ESTOQUE");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        sellTable.setModel(new javax.swing.table.DefaultTableModel(
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
        sellTable.setEnabled(false);
        jScrollPane3.setViewportView(sellTable);

        jPanel7.setBackground(new java.awt.Color(153, 153, 153));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("REGISTRO DE VENDAS");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        sellValue.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        sellValue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        sellValue.setText("R$XX,XX");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel13.setText("TOTAL EM ESTOQUE (VENDA)");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(83, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sellValue, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sellValue, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelGradiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(100, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void rSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSalesActionPerformed
    SalesRegister rSale = new SalesRegister();
    rSale.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_rSalesActionPerformed

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
ProductsRegister rProduct = new ProductsRegister();
rProduct.setVisible(true);
this.dispose();
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
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cCustomer;
    private javax.swing.JButton cEmployeer;
    private javax.swing.JButton cProduct;
    private javax.swing.JButton cSupplier;
    private javax.swing.JLabel costValue;
    private javax.swing.JTable entryTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton lCustomer;
    private javax.swing.JButton lEmployeer;
    private javax.swing.JButton lProduct;
    private javax.swing.JButton lSupplier;
    private javax.swing.JTable outTable;
    private br.com.stockmaster.stockmasterdb.swing.PanelGradiente panelGradiente1;
    private javax.swing.JLabel profitValue;
    private javax.swing.JButton rEntry;
    private javax.swing.JButton rOut;
    private javax.swing.JButton rSales;
    private javax.swing.JTable sellTable;
    private javax.swing.JLabel sellValue;
    // End of variables declaration//GEN-END:variables
}
