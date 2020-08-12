/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Color;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yash
 */
public class BillGenFormModel extends javax.swing.JFrame {

    /**
     * Creates new form BillGenFormModel
     */
    
    private String userID = "0";
    public BillGenFormModel() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        billingTable.getTableHeader().setDefaultRenderer(new TableHeaderFont());
        billingTable.setShowGrid(true);
        billingTable.setGridColor(Color.BLACK);  
    }

    
    public BillGenFormModel(ArrayList<List> fieldList, String s) {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        userID = s;
        try {
            String GSTNo = "";
            String Com_Name = "";
            String Co_addr = "";
            String mailID = "";
            String contact = "";
            
            String url = "jdbc:mysql://localhost:3306/medical_system?autoReconnect=true&useSSL=false";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "");
            Statement st = conn.createStatement();
            String query = "SELECT nvl(max(`Bill Number`), 0) as Bill_count FROM `sold_medicine_details`";
            ResultSet rs =st.executeQuery(query);
            String bill_no = "";
            if(rs.next()){
                bill_no = rs.getString("Bill_count");
            }
            rs = st.executeQuery("Select Email,`Mobile Number`, GST, `Company Address`, `Company Name` from user_table where `User ID` = "+userID);    // change afterwards.... Default value ID:1
            if(rs.next()){
                contact = rs.getString("Mobile Number");
                mailID = rs.getString("Email");
                GSTNo = rs.getString("GST");
                Co_addr = rs.getString("Company Address");
                Com_Name = rs.getString("Company Name");
            }
            float mrp = 0;
            float g_total = 0;
            Object ob[][] = new Object[10][6];
            for (List table_Row: fieldList){
                int i = fieldList.indexOf(table_Row);
                Object ob1[] = {Integer.toString(i+1), fieldList.get(i).get(0).toString(), fieldList.get(i).get(2).toString(), fieldList.get(i).get(5).toString(), fieldList.get(i).get(6).toString(), fieldList.get(i).get(12).toString()};
                ob[i] = ob1;
                g_total+=Float.valueOf(fieldList.get(i).get(12).toString());
                mrp+=Float.valueOf(fieldList.get(i).get(6).toString());
                String query1 = "insert into sold_medicine_details values(0, "+String.valueOf(Integer.valueOf(bill_no)+1)+", "+fieldList.get(i).get(0).toString()+", "+fieldList.get(i).get(1).toString()+", '"+fieldList.get(i).get(5).toString()+"', '"+fieldList.get(i).get(11).toString()+"', '"+fieldList.get(i).get(12).toString()+"', '"+fieldList.get(i).get(10).toString()+"', '"+fieldList.get(i).get(13).toString()+"')";
                st.executeUpdate(query1);
            }
            
            mailText.setText(mailID);
            mobText.setText(contact);
            gstText.setText(GSTNo);
            cAddrText.setText(Co_addr);
            CoNameText.setText(Com_Name);
            GSTAppliedText.setText("+"+fieldList.get(0).get(11).toString().split("%")[0]+"% GST: RS."+String.valueOf(Math.round(g_total-mrp)));
            grandTotalText.setText("RS."+String.valueOf(Math.round(g_total)));
            billDate.setText(fieldList.get(0).get(10).toString()+"   "+fieldList.get(0).get(13).toString());
                //close database server
            conn.close();
            billNo.setText(String.valueOf(Integer.valueOf(bill_no)+1));
            billCustName.setText(fieldList.get(0).get(8).toString());
            billCustContact.setText(fieldList.get(0).get(9).toString());
            
            billingTable.setModel(new DefaultTableModel(ob, new String [] {
                "Item No.", "Medicine ID", "Medicine Name", "Quantity", "MRP (per each)", "Total"
            }));
            billingTable.getTableHeader().setDefaultRenderer(new TableHeaderFont());
            billingTable.setShowGrid(true);
            billingTable.setGridColor(Color.BLACK);    
        } catch (Exception e) {
                new DBDownDialogBox().setVisible(true);
                System.out.println("Bill Generation Model\n"+e);
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        billPanel = new javax.swing.JPanel();
        CoNameText = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cAddrText = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        billNo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        billCustName = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        billCustContact = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        billingTable = new javax.swing.JTable();
        printBtn = new javax.swing.JButton();
        closeBtn = new javax.swing.JButton();
        GSTAppliedText = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        grandTotalText = new javax.swing.JLabel();
        payStatus = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        gstText = new javax.swing.JLabel();
        billDate = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        mailText = new javax.swing.JLabel();
        mobText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(248, 30, 154));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MediGo");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel1, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.5;
        jPanel1.add(jPanel2, gridBagConstraints);

        billPanel.setBackground(new java.awt.Color(255, 255, 255));
        billPanel.setPreferredSize(new java.awt.Dimension(1200, 700));

        CoNameText.setFont(new java.awt.Font("Rubik", 1, 26)); // NOI18N
        CoNameText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CoNameText.setText("USer Company Name");

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(400, 50));

        cAddrText.setEditable(false);
        cAddrText.setColumns(20);
        cAddrText.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        cAddrText.setLineWrap(true);
        cAddrText.setRows(5);
        cAddrText.setText("dfgdsfhgsyjdgfjgsjfgjgfsdghfgjsdggfjgsdjfgjsdgjfgjdgjfgsjdgfjgsjdgfjgsdjfgjdsgjfgjsdgjfgjdsgfjgsdjgfjgsjdf");
        cAddrText.setWrapStyleWord(true);
        cAddrText.setAutoscrolls(false);
        cAddrText.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        cAddrText.setDoubleBuffered(true);
        jScrollPane1.setViewportView(cAddrText);

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15)); // NOI18N
        jLabel3.setText("Bill No. ");

        billNo.setFont(new java.awt.Font("Palatino Linotype", 1, 16)); // NOI18N
        billNo.setText("0");

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15)); // NOI18N
        jLabel6.setText("Customer Name:");

        billCustName.setFont(new java.awt.Font("Palatino Linotype", 1, 16)); // NOI18N
        billCustName.setText("kdafhkhk khkahfkhakfd sf sg ");

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15)); // NOI18N
        jLabel8.setText("Contact Number:");

        billCustContact.setFont(new java.awt.Font("Palatino Linotype", 1, 16)); // NOI18N
        billCustContact.setText("7982379479");

        jScrollPane3.setPreferredSize(new java.awt.Dimension(452, 150));

        billingTable.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        billingTable.setForeground(new java.awt.Color(248, 30, 154));
        billingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Item No.", "Medicine ID", "Medicine Name", "Quantity", "MRP (Each)", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        billingTable.setPreferredSize(new java.awt.Dimension(450, 88));
        billingTable.setRowHeight(22);
        jScrollPane3.setViewportView(billingTable);

        printBtn.setBackground(new java.awt.Color(248, 30, 154));
        printBtn.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        printBtn.setForeground(new java.awt.Color(255, 255, 255));
        printBtn.setText("PRINT");
        printBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(248, 30, 154)));
        printBtn.setContentAreaFilled(false);
        printBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        printBtn.setIconTextGap(10);
        printBtn.setOpaque(true);
        printBtn.setPreferredSize(new java.awt.Dimension(80, 35));
        printBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                printBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                printBtnMouseExited(evt);
            }
        });

        closeBtn.setBackground(new java.awt.Color(248, 30, 154));
        closeBtn.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        closeBtn.setForeground(new java.awt.Color(255, 255, 255));
        closeBtn.setText("CLOSE");
        closeBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(248, 30, 154)));
        closeBtn.setContentAreaFilled(false);
        closeBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        closeBtn.setIconTextGap(10);
        closeBtn.setOpaque(true);
        closeBtn.setPreferredSize(new java.awt.Dimension(80, 35));
        closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeBtnMouseExited(evt);
            }
        });

        GSTAppliedText.setFont(new java.awt.Font("Rubik", 1, 14)); // NOI18N
        GSTAppliedText.setForeground(new java.awt.Color(0, 204, 0));
        GSTAppliedText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GSTAppliedText.setText("+ 5% GST: Rs.479532");

        jLabel5.setFont(new java.awt.Font("Rubik", 1, 18)); // NOI18N
        jLabel5.setText("Grand Total: ");

        grandTotalText.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        grandTotalText.setForeground(new java.awt.Color(0, 204, 51));
        grandTotalText.setText("Rs. 8764989");

        payStatus.setBackground(new java.awt.Color(255, 255, 255));
        payStatus.setFont(new java.awt.Font("Rubik", 1, 14)); // NOI18N
        payStatus.setForeground(new java.awt.Color(255, 0, 0));
        payStatus.setText("  Unpaid");
        payStatus.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        payStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                payStatusMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15)); // NOI18N
        jLabel4.setText("GST Number: ");

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15)); // NOI18N
        jLabel7.setText("Date & Time: ");

        gstText.setFont(new java.awt.Font("Palatino Linotype", 1, 16)); // NOI18N
        gstText.setText("78Y78DSYF87HYIF");

        billDate.setFont(new java.awt.Font("Palatino Linotype", 1, 16)); // NOI18N
        billDate.setText("sgdgfjdkhfk");

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Email : ");
        jLabel2.setPreferredSize(new java.awt.Dimension(45, 14));

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Contact : ");
        jLabel9.setPreferredSize(new java.awt.Dimension(58, 14));

        mailText.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        mailText.setText("hfdsgtfgjyadgf");
        mailText.setPreferredSize(new java.awt.Dimension(78, 14));

        mobText.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        mobText.setText("yashshettigar047@gmail.com");
        mobText.setPreferredSize(new java.awt.Dimension(97, 14));

        javax.swing.GroupLayout billPanelLayout = new javax.swing.GroupLayout(billPanel);
        billPanel.setLayout(billPanelLayout);
        billPanelLayout.setHorizontalGroup(
            billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(billPanelLayout.createSequentialGroup()
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(billPanelLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(billPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(billNo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(billPanelLayout.createSequentialGroup()
                                        .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(billPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(billCustName))
                                            .addGroup(billPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(billCustContact)))
                                        .addGap(121, 121, 121)
                                        .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(billPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(billDate, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(billPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(gstText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                            .addGroup(billPanelLayout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(GSTAppliedText, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(billPanelLayout.createSequentialGroup()
                                        .addComponent(printBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(113, 113, 113)
                                        .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(billPanelLayout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(grandTotalText, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(118, 118, 118)
                                        .addComponent(payStatus)))))
                        .addGap(0, 31, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CoNameText)
                            .addGroup(billPanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(billPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(mailText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(billPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(mobText, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(22, 22, 22)))
                .addContainerGap())
        );
        billPanelLayout.setVerticalGroup(
            billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(billPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(CoNameText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(billPanelLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(billNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3)))
                            .addGroup(billPanelLayout.createSequentialGroup()
                                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(mobText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(billCustName)
                            .addComponent(jLabel4)
                            .addComponent(gstText, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(billDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                            .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(billCustContact)
                                .addComponent(jLabel7)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(payStatus)
                        .addGap(26, 26, 26))
                    .addGroup(billPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GSTAppliedText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(grandTotalText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)))
                .addGroup(billPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 7.0;
        jPanel1.add(billPanel, gridBagConstraints);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(12, 13, 892, 623);

        setSize(new java.awt.Dimension(916, 725));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_closeBtnMouseClicked

    private void payStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_payStatusMouseClicked
        // TODO add your handling code here:
        if(payStatus.isSelected()){
            payStatus.setText("  Paid");
            payStatus.setForeground(Color.decode("#00CC33"));
        } else {
            payStatus.setText("  Unpaid");
            payStatus.setForeground(Color.decode("#FF0000"));
        }
    }//GEN-LAST:event_payStatusMouseClicked

    private void printBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printBtnMouseClicked
        // TODO add your handling code here:
        PrinterJob pjob = PrinterJob.getPrinterJob();
        pjob.setJobName(CoNameText.getText()+"_BillNumber_"+billNo.getText()+"_Dated_"+billDate.getText());
        PageFormat preformat = pjob.defaultPage();
        preformat.setOrientation(PageFormat.LANDSCAPE);
        PageFormat postformat = pjob.pageDialog(preformat);
        //If user does not hit cancel then print.
        if (preformat != postformat) {
            //Set print component
            pjob.setPrintable(new Printer(jPanel1), postformat);
            if (pjob.printDialog()) {
                try {
                    pjob.print();
                } catch (PrinterException ex) {
                    Logger.getLogger(BillGenFormModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_printBtnMouseClicked

    private void printBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printBtnMouseEntered
        // TODO add your handling code here:
        printBtn.setForeground(Color.decode("#F81E9A"));
        printBtn.setBackground(Color.WHITE);
    }//GEN-LAST:event_printBtnMouseEntered

    private void printBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printBtnMouseExited
        // TODO add your handling code here:
        printBtn.setForeground(Color.WHITE);
        printBtn.setBackground(Color.decode("#F81E9A"));
    }//GEN-LAST:event_printBtnMouseExited

    private void closeBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseEntered
        // TODO add your handling code here:
        closeBtn.setForeground(Color.decode("#F81E9A"));
        closeBtn.setBackground(Color.WHITE);
    }//GEN-LAST:event_closeBtnMouseEntered

    private void closeBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseExited
        // TODO add your handling code here:
        closeBtn.setForeground(Color.WHITE);
        closeBtn.setBackground(Color.decode("#F81E9A"));
    }//GEN-LAST:event_closeBtnMouseExited

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
            java.util.logging.Logger.getLogger(BillGenFormModel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillGenFormModel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillGenFormModel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillGenFormModel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillGenFormModel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CoNameText;
    private javax.swing.JLabel GSTAppliedText;
    private javax.swing.JLabel billCustContact;
    private javax.swing.JLabel billCustName;
    private javax.swing.JLabel billDate;
    private javax.swing.JLabel billNo;
    private javax.swing.JPanel billPanel;
    private javax.swing.JTable billingTable;
    private javax.swing.JTextArea cAddrText;
    private javax.swing.JButton closeBtn;
    private javax.swing.JLabel grandTotalText;
    private javax.swing.JLabel gstText;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel mailText;
    private javax.swing.JLabel mobText;
    private javax.swing.JCheckBox payStatus;
    private javax.swing.JButton printBtn;
    // End of variables declaration//GEN-END:variables
}
