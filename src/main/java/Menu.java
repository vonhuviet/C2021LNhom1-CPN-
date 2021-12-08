/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import Module.*;
import Utility.*;
import Utility.Utility;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bun
 */
public final class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Test
     */
    static List<Role> roleList;
    static List<Shopinfo> shopList;
    static List<Users> userList;
    static List<Service> serviceList;
    static List<Warehouse> whouseList;
    static List<Orders> ordersList;
    DefaultTableModel tableModel;
    int currentIndex = -1;

    public static Users loggedID = null;

    public Menu() {
        initComponents();

        loggedID = DataMgr.getInstance().loginWithId;
        
        //check username
        System.out.println(loggedID);
        

        if (loggedID.getIdRole() == 2) {
            menuListJtb.setEnabledAt(2, false);
            menuListJtb.setEnabledAt(3, false);
            menuListJtb.setEnabledAt(4, false);
        } else {
            menuListJtb.setEnabledAt(2, true);
            menuListJtb.setEnabledAt(3, true);
            menuListJtb.setEnabledAt(4, true);
        }

        userNameLoginTxt.setText(loggedID.getUsername());

        ClockExample();
        editUsersBt.setEnabled(false);
        delUsersBtn.setEnabled(false);
        ordersInfoTab();
        ShopInfoTab();
        UsersInfoTab();
        ServiceInfoTab();
        WhouseInfoTab();

    }

    private void ordersInfoTab() {
        // bang thong tin cua ShopList
        tableModel = (DefaultTableModel) ordersjTab.getModel();
        ordersList = OrderDAO.getOrdersList(null);
        showOrders();
        //OrdersList
        ordersjTab.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentIndex = ordersjTab.getSelectedRow();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    private void ShopInfoTab() {
        // bang thong tin cua ShopList
        tableModel = (DefaultTableModel) shopInfoTab.getModel();
        shopList = ShopInfoDAO.getShopList(null);
        showShop();

        //ShopList
        shopInfoTab.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentIndex = shopInfoTab.getSelectedRow();

                nameSTxt.setText(shopList.get(currentIndex).getShopname());
                phoneSTxt.setText(shopList.get(currentIndex).getShopPhone());
                addressSTxt.setText(shopList.get(currentIndex).getAddress());
                emailSTxt.setText(shopList.get(currentIndex).getEmail());

                createShopBtn.setEnabled(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    private void UsersInfoTab() {
        //bang thong tin cua UserList
        tableModel = (DefaultTableModel) usersTable.getModel();
        userList = UserDAO.getUserList();
        roleList = RoleDAO.getRoleList();

        for (Role role : roleList) {
            cbxAccount.addItem(role);
        }
        showUsers();

        //UserList
        usersTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentIndex = usersTable.getSelectedRow();
                if(userList.get(currentIndex).getIdUser() == 1){
                    usernameTXT.setEnabled(false);
                    addresUserTXT.setEnabled(false);
                    fullNameUserTXT.setEnabled(false);
                    mobileUserTXT.setEnabled(false);
                    emailUserTXT.setEnabled(false);
                    cbxAccount.setEnabled(false);
                    jCbActive.setEnabled(false);
                    createUsersBt.setEnabled(false);
                    editUsersBt.setEnabled(false);
                    delUsersBtn.setEnabled(false);
                    rsUsersBtn.setEnabled(false);
                    
                }else{
                    usernameTXT.setEnabled(true);
                    addresUserTXT.setEnabled(true);
                    fullNameUserTXT.setEnabled(true);
                    mobileUserTXT.setEnabled(true);
                    emailUserTXT.setEnabled(true);
                    cbxAccount.setEnabled(true);
                    jCbActive.setEnabled(true);
                    createUsersBt.setEnabled(false);
                    editUsersBt.setEnabled(true);
                    delUsersBtn.setEnabled(true);
                    rsUsersBtn.setEnabled(true);
                }
                

                usernameTXT.setText(userList.get(currentIndex).getUsername());
//              PwdTXT.setText(userList.get(currentIndex).getPassword());
                addresUserTXT.setText(userList.get(currentIndex).getAddress());
                fullNameUserTXT.setText(userList.get(currentIndex).getFullname());
                mobileUserTXT.setText(userList.get(currentIndex).getMobile());
                emailUserTXT.setText(userList.get(currentIndex).getEmail());

                for (Role role : roleList) {
                    if (role.getIdRole() == userList.get(currentIndex).getIdRole()) {
                        cbxAccount.setSelectedItem(role);
                    }

                }
                boolean activeState = Users.activeStateToBool(userList.get(currentIndex).getActive());
                jCbActive.setSelectedItem(!activeState);

                PwdTXT.setEnabled(false);
                ConfirmPwdTXT.setEnabled(false);

//                createUsersBt.setEnabled(false);
//                editUsersBt.setEnabled(true);
//                delUsersBtn.setEnabled(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });

    }

    private void ServiceInfoTab() {
        //bang thong tin cua ServiceList
        tableModel = (DefaultTableModel) serviceTab.getModel();
        serviceList = ServiceDAO.getSerList();
        showService();
        //Service List
        serviceTab.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentIndex = serviceTab.getSelectedRow();

                nameSvTxt.setText(serviceList.get(currentIndex).getNameService());
                priceSvTxt.setText(serviceList.get(currentIndex).getPriceService() + (""));
                noteSvTxtArea.setText(serviceList.get(currentIndex).getNote());

                createSvBtn.setEnabled(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });
    }

    private void WhouseInfoTab() {
        //bang thong tin cua WareHouseList
        tableModel = (DefaultTableModel) wareHouseTab.getModel();
        whouseList = WareHouseDAO.getWHouseList();
        showWhouse();
        //Ware House List
        wareHouseTab.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentIndex = wareHouseTab.getSelectedRow();

                nameWhTxt.setText(whouseList.get(currentIndex).getNameWhouse());
                addressWhTxt.setText(whouseList.get(currentIndex).getAddress());
                noteWhTxtArea.setText(whouseList.get(currentIndex).getNote());

                createWhBtn.setEnabled(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });

    }

    //Shop
    private void showShop() {
        tableModel = (DefaultTableModel) shopInfoTab.getModel();
        shopList = ShopInfoDAO.getShopList(null);
       
        tableModel.setRowCount(0);
        shopList.forEach(si -> {
            tableModel.addRow(new Object[]{
                tableModel.getRowCount() + 1,
                si.getShopname(),
                si.getShopPhone(),
                si.getAddress(),
                si.getEmail()
            });
        });
        ResetShop();
    }

    public void ResetShop() {
        nameSTxt.setText("");
        phoneSTxt.setText("");
        addressSTxt.setText("");
        emailSTxt.setText("");
        createShopBtn.setEnabled(true);
        
    }

    //User
    private void showUsers() {
        tableModel = (DefaultTableModel) usersTable.getModel();
        userList = UserDAO.getUserList();
        tableModel.setRowCount(0);

        for (Users u : userList) {

            boolean isAdmin;
            if (u.getIdRole() == 1) {
                isAdmin = true;
            } else {
                isAdmin = false;
            }

            boolean isActive;
            if (u.getActive() == 1) {
                isActive = true;
            } else {
                isActive = false;
            }

            tableModel.addRow(new Object[]{
                tableModel.getRowCount() + 1,
                u.getUsername(),
                u.getAddress(),
                u.getMobile(),
                u.getFullname(),
                u.getEmail(),
                isAdmin,
                isActive
            });
        }
        ResetUsers();
    }

    public void ResetUsers() {
        usernameTXT.setText("");
        PwdTXT.setText("");
        ConfirmPwdTXT.setText("");
        addresUserTXT.setText("");
        emailUserTXT.setText("");
        fullNameUserTXT.setText("");
        mobileUserTXT.setText("");

        PwdTXT.setEnabled(true);
        ConfirmPwdTXT.setEnabled(true);
        editUsersBt.setEnabled(false);
        delUsersBtn.setEnabled(false);
    }

    //Service
    private void showService() {
        tableModel = (DefaultTableModel) serviceTab.getModel();
        serviceList = ServiceDAO.getSerList();
        tableModel.setRowCount(0);
        serviceList.forEach(sv -> {
            tableModel.addRow(new Object[]{
                tableModel.getRowCount() + 1,
                sv.getNameService(),
                sv.getPriceService(),
                sv.getNote()
            });
        });

    }

    public void ResetService() {
        nameSvTxt.setText("");
        priceSvTxt.setText("");
        noteSvTxtArea.setText("");
        createSvBtn.setEnabled(true);
        showService();
    }

    //Whouse
    private void showWhouse() {
        tableModel = (DefaultTableModel) wareHouseTab.getModel();
        whouseList = WareHouseDAO.getWHouseList();
        tableModel.setRowCount(0);
        whouseList.forEach(wh -> {

            tableModel.addRow(new Object[]{
                tableModel.getRowCount() + 1,
                wh.getNameWhouse(),
                wh.getAddress(),
                wh.getNote()
            });
        });

    }

    public void ResetWhouse() {
        nameWhTxt.setText("");
        addressWhTxt.setText("");
        noteWhTxtArea.setText("");
        createWhBtn.setEnabled(true);
        showWhouse();
    }

    //Orders
    private void showOrders() {
        tableModel = (DefaultTableModel) ordersjTab.getModel();
        ordersList = OrderDAO.getOrdersList(null);
     
        tableModel.setRowCount(0);
        ordersList.forEach(od -> {

            tableModel.addRow(new Object[]{
                tableModel.getRowCount() + 1,
                od.getRollNo(),
                od.getNameProduct(),
                od.getStatus(),
                od.getUsers(),
                od.getService(),
                od.getNameCustomer(),
                od.getAddressCustomer(),
                od.getMobileCustomer(),
                od.getWarehouse(),
                od.getShopinfo(),
                od.getWeight(),
                od.getTotalPrice(),
                od.getNote()

            });

        });

    }

    public void ClockExample() {
        // thiết lập lại đồng hồ sau mỗi 1 giây

        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);

        String time = " " + day + " / " + month + " / " + year;
        timeJlabel.setText(time);

    }

    public void notification(String contentNoti, String titleNoti, int icon) {
        JOptionPane.showMessageDialog(new JFrame(), contentNoti,
                titleNoti, icon);
    }

    // kiem tra email can fix - test
    private String fixEmail(String email) {
        boolean check = true;
        if (!(Pattern.matches("^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$", email))) {
            JOptionPane.showMessageDialog(null, "Please enter a valid email", "Error", JOptionPane.ERROR_MESSAGE);
            check = false;
        } else {
            JOptionPane.showMessageDialog(null, "The email is valid", "Good!", JOptionPane.INFORMATION_MESSAGE);

        }
        return email;
    }
    
     public void NumbCheck(java.awt.event.KeyEvent evt) {
        char numb = evt.getKeyChar();
        if (!(Character.isDigit(numb)) || (numb == KeyEvent.VK_BACK_SPACE) || (numb == KeyEvent.VK_DELETE)) {
            evt.consume();
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

        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        menuListJtb = new javax.swing.JTabbedPane();
        odersJtb = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        ordersjTab = new javax.swing.JTable();
        jPanel19 = new javax.swing.JPanel();
        creOdersBtn = new javax.swing.JButton();
        delOrdersBtn = new javax.swing.JButton();
        searchOrdersBtn = new javax.swing.JButton();
        warehouseJtb = new javax.swing.JTabbedPane();
        WHouseList = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        wareHouseTab = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        nameWhTxt = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        addressWhTxt = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        noteWhTxtArea = new javax.swing.JTextArea();
        createWhBtn = new javax.swing.JButton();
        delWhBtn = new javax.swing.JButton();
        resetWhBtn = new javax.swing.JButton();
        WHouseHistory = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        WHHistoryjTab = new javax.swing.JTable();
        serviceJtb = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        serviceTab = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        nameSvTxt = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        priceSvTxt = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        noteSvTxtArea = new javax.swing.JTextArea();
        createSvBtn = new javax.swing.JButton();
        delSvBtn = new javax.swing.JButton();
        resetSvBtn = new javax.swing.JButton();
        shopJtb = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        nameSTxt = new javax.swing.JTextField();
        phoneSTxt = new javax.swing.JTextField();
        addressSTxt = new javax.swing.JTextField();
        emailSTxt = new javax.swing.JTextField();
        createShopBtn = new javax.swing.JButton();
        delShopBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        rsShopBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        searchShopBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        shopInfoTab = new javax.swing.JTable();
        usersJtb = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        usernameTXT = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        PwdTXT = new javax.swing.JPasswordField();
        jLabel14 = new javax.swing.JLabel();
        ConfirmPwdTXT = new javax.swing.JPasswordField();
        jLabel15 = new javax.swing.JLabel();
        emailUserTXT = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        addresUserTXT = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        fullNameUserTXT = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        mobileUserTXT = new javax.swing.JTextField();
        cbxAccount = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jCbActive = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        editUsersBt = new javax.swing.JButton();
        createUsersBt = new javax.swing.JButton();
        delUsersBtn = new javax.swing.JButton();
        rsUsersBtn = new javax.swing.JButton();
        Team = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        StatisticalJtb = new javax.swing.JTabbedPane();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        logoutJp = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        userNameLoginTxt = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        timeJlabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 153));

        jPanel1.setForeground(new java.awt.Color(102, 255, 51));

        menuListJtb.setBackground(new java.awt.Color(102, 255, 102));
        menuListJtb.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        odersJtb.setBackground(new java.awt.Color(102, 255, 102));
        odersJtb.setMinimumSize(new java.awt.Dimension(80, 30));
        odersJtb.setPreferredSize(new java.awt.Dimension(1181, 609));

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));

        ordersjTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Roll No", "Name Product", "Status", "Users", "Service", "Name Customer", "Address Customer", "Mobile Customer", "Warehouse", "Shop", "Weight(Kg)", "Total Price", "Note"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(ordersjTab);
        if (ordersjTab.getColumnModel().getColumnCount() > 0) {
            ordersjTab.getColumnModel().getColumn(0).setResizable(false);
            ordersjTab.getColumnModel().getColumn(0).setPreferredWidth(20);
            ordersjTab.getColumnModel().getColumn(1).setResizable(false);
            ordersjTab.getColumnModel().getColumn(2).setResizable(false);
            ordersjTab.getColumnModel().getColumn(3).setResizable(false);
            ordersjTab.getColumnModel().getColumn(4).setResizable(false);
            ordersjTab.getColumnModel().getColumn(5).setResizable(false);
            ordersjTab.getColumnModel().getColumn(6).setResizable(false);
            ordersjTab.getColumnModel().getColumn(7).setResizable(false);
            ordersjTab.getColumnModel().getColumn(8).setResizable(false);
            ordersjTab.getColumnModel().getColumn(9).setResizable(false);
            ordersjTab.getColumnModel().getColumn(10).setResizable(false);
            ordersjTab.getColumnModel().getColumn(10).setPreferredWidth(150);
            ordersjTab.getColumnModel().getColumn(11).setResizable(false);
            ordersjTab.getColumnModel().getColumn(12).setResizable(false);
            ordersjTab.getColumnModel().getColumn(13).setResizable(false);
        }

        jPanel19.setBackground(new java.awt.Color(204, 204, 255));

        creOdersBtn.setBackground(new java.awt.Color(102, 255, 102));
        creOdersBtn.setText("Create");
        creOdersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creOdersBtnActionPerformed(evt);
            }
        });

        delOrdersBtn.setBackground(new java.awt.Color(255, 153, 153));
        delOrdersBtn.setText("Delete");
        delOrdersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delOrdersBtnActionPerformed(evt);
            }
        });

        searchOrdersBtn.setBackground(new java.awt.Color(0, 255, 255));
        searchOrdersBtn.setText("Search");
        searchOrdersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchOrdersBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(creOdersBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
            .addComponent(delOrdersBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(searchOrdersBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(creOdersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(delOrdersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchOrdersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(210, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(0, 1180, Short.MAX_VALUE)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 84, Short.MAX_VALUE)))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        odersJtb.addTab("Oders List", jPanel7);

        menuListJtb.addTab("Oders", new javax.swing.ImageIcon(getClass().getResource("/icon/hoadon.png")), odersJtb); // NOI18N
        odersJtb.getAccessibleContext().setAccessibleName("Oders");

        WHouseList.setBackground(new java.awt.Color(204, 204, 255));
        WHouseList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        wareHouseTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Name", "Address", "Note"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(wareHouseTab);
        if (wareHouseTab.getColumnModel().getColumnCount() > 0) {
            wareHouseTab.getColumnModel().getColumn(0).setResizable(false);
            wareHouseTab.getColumnModel().getColumn(1).setResizable(false);
            wareHouseTab.getColumnModel().getColumn(2).setResizable(false);
            wareHouseTab.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel15.setBackground(new java.awt.Color(204, 204, 255));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Warehouse");

        jLabel25.setText("Name :");

        jLabel26.setText("Address:");

        jLabel27.setText("Note :");

        noteWhTxtArea.setColumns(20);
        noteWhTxtArea.setRows(5);
        jScrollPane6.setViewportView(noteWhTxtArea);

        createWhBtn.setBackground(new java.awt.Color(102, 255, 102));
        createWhBtn.setText("Create");
        createWhBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createWhBtnActionPerformed(evt);
            }
        });

        delWhBtn.setBackground(new java.awt.Color(255, 51, 51));
        delWhBtn.setText("Delete");
        delWhBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delWhBtnActionPerformed(evt);
            }
        });

        resetWhBtn.setBackground(new java.awt.Color(255, 204, 204));
        resetWhBtn.setText("Reset");
        resetWhBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetWhBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nameWhTxt))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(addressWhTxt))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(createWhBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(resetWhBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(delWhBtn))
                                    .addComponent(jScrollPane6))))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(nameWhTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(addressWhTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(27, 27, 27)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createWhBtn)
                    .addComponent(delWhBtn)
                    .addComponent(resetWhBtn))
                .addContainerGap(275, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout WHouseListLayout = new javax.swing.GroupLayout(WHouseList);
        WHouseList.setLayout(WHouseListLayout);
        WHouseListLayout.setHorizontalGroup(
            WHouseListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WHouseListLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 881, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        WHouseListLayout.setVerticalGroup(
            WHouseListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane5)
        );

        warehouseJtb.addTab("WareHouse List", WHouseList);

        WHouseHistory.setBackground(new java.awt.Color(204, 204, 255));

        WHHistoryjTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Oders Name", "WareHouse", "Address", "Create At", "WareHouse2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(WHHistoryjTab);
        if (WHHistoryjTab.getColumnModel().getColumnCount() > 0) {
            WHHistoryjTab.getColumnModel().getColumn(0).setResizable(false);
            WHHistoryjTab.getColumnModel().getColumn(1).setResizable(false);
            WHHistoryjTab.getColumnModel().getColumn(2).setResizable(false);
            WHHistoryjTab.getColumnModel().getColumn(3).setResizable(false);
            WHHistoryjTab.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout WHouseHistoryLayout = new javax.swing.GroupLayout(WHouseHistory);
        WHouseHistory.setLayout(WHouseHistoryLayout);
        WHouseHistoryLayout.setHorizontalGroup(
            WHouseHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WHouseHistoryLayout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        WHouseHistoryLayout.setVerticalGroup(
            WHouseHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        warehouseJtb.addTab("WareHouse History", WHouseHistory);

        menuListJtb.addTab("WareHouse", new javax.swing.ImageIcon(getClass().getResource("/icon/nhanvien.png")), warehouseJtb); // NOI18N

        jPanel12.setBackground(new java.awt.Color(204, 204, 255));
        jPanel12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        serviceTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Name", "Price", "Note"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(serviceTab);
        if (serviceTab.getColumnModel().getColumnCount() > 0) {
            serviceTab.getColumnModel().getColumn(0).setResizable(false);
            serviceTab.getColumnModel().getColumn(1).setResizable(false);
            serviceTab.getColumnModel().getColumn(2).setResizable(false);
            serviceTab.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel13.setBackground(new java.awt.Color(204, 204, 255));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Service");

        jLabel21.setText("Name :");

        jLabel22.setText("Price :");

        priceSvTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                priceSvTxtKeyTyped(evt);
            }
        });

        jLabel23.setText("Note :");

        noteSvTxtArea.setColumns(20);
        noteSvTxtArea.setRows(5);
        jScrollPane4.setViewportView(noteSvTxtArea);

        createSvBtn.setBackground(new java.awt.Color(102, 255, 102));
        createSvBtn.setText("Create");
        createSvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createSvBtnActionPerformed(evt);
            }
        });

        delSvBtn.setBackground(new java.awt.Color(255, 51, 51));
        delSvBtn.setText("Delete");
        delSvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delSvBtnActionPerformed(evt);
            }
        });

        resetSvBtn.setBackground(new java.awt.Color(255, 204, 204));
        resetSvBtn.setText("Reset");
        resetSvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetSvBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nameSvTxt))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(priceSvTxt))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane4))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(resetSvBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(createSvBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(delSvBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(nameSvTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(priceSvTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(28, 28, 28)
                .addComponent(createSvBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(resetSvBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(delSvBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
        );

        serviceJtb.addTab("Service List", jPanel12);

        menuListJtb.addTab("Service", new javax.swing.ImageIcon(getClass().getResource("/icon/doitac.png")), serviceJtb); // NOI18N

        shopJtb.setMinimumSize(new java.awt.Dimension(104, 44));
        shopJtb.setPreferredSize(new java.awt.Dimension(1181, 609));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        jLabel5.setText("Email:");

        nameSTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameSTxtActionPerformed(evt);
            }
        });

        phoneSTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phoneSTxtKeyTyped(evt);
            }
        });

        createShopBtn.setBackground(new java.awt.Color(102, 255, 102));
        createShopBtn.setText("Create");
        createShopBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createShopBtnActionPerformed(evt);
            }
        });

        delShopBtn.setBackground(new java.awt.Color(255, 51, 51));
        delShopBtn.setText("Delete");
        delShopBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delShopBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SHOP INFO");

        rsShopBtn.setBackground(new java.awt.Color(255, 204, 204));
        rsShopBtn.setText("Reset");
        rsShopBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rsShopBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Shop Name :");

        searchShopBtn.setBackground(new java.awt.Color(0, 255, 255));
        searchShopBtn.setText("Search");
        searchShopBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchShopBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Shop Phone:");

        jLabel4.setText("Address: ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rsShopBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(createShopBtn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(searchShopBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(delShopBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(nameSTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneSTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressSTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailSTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameSTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(phoneSTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressSTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailSTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createShopBtn)
                    .addComponent(delShopBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rsShopBtn)
                    .addComponent(searchShopBtn))
                .addContainerGap(320, Short.MAX_VALUE))
        );

        shopInfoTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Shop Name", "Shop Phone", "Address", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(shopInfoTab);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );

        shopJtb.addTab("ShopList", jPanel2);

        menuListJtb.addTab("ShopInfo", new javax.swing.ImageIcon(getClass().getResource("/icon/sanpham.png")), shopJtb); // NOI18N
        shopJtb.getAccessibleContext().setAccessibleName("ShopList");

        usersJtb.setName(""); // NOI18N

        jPanel9.setBackground(new java.awt.Color(204, 204, 255));

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Username", "Address", "Mobile", "Full Name", "Email", "Account", "Activated"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(usersTable);

        jPanel10.setBackground(new java.awt.Color(204, 204, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Create Account");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Username: ");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Password: ");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("ConfirmPwd:");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Email:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Address: ");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Full Name:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("MobilePhone: ");

        mobileUserTXT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mobileUserTXTKeyTyped(evt);
            }
        });

        cbxAccount.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxAccountItemStateChanged(evt);
            }
        });
        cbxAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAccountActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Account:");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setText("Active: ");

        jCbActive.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activated", "Deactivated" }));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usernameTXT, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                            .addComponent(PwdTXT))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailUserTXT)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(cbxAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jCbActive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(fullNameUserTXT)
                            .addComponent(mobileUserTXT))
                        .addGap(83, 83, 83))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ConfirmPwdTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addresUserTXT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(355, 355, 355)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 440, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(11, 11, 11)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel17)
                    .addComponent(fullNameUserTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(PwdTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(mobileUserTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConfirmPwdTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(emailUserTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addresUserTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel19)
                    .addComponent(cbxAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(jCbActive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(204, 204, 255));

        editUsersBt.setBackground(new java.awt.Color(255, 255, 0));
        editUsersBt.setText("Edit");
        editUsersBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUsersBtActionPerformed(evt);
            }
        });

        createUsersBt.setBackground(new java.awt.Color(102, 255, 102));
        createUsersBt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        createUsersBt.setText("Create");
        createUsersBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUsersBtActionPerformed(evt);
            }
        });

        delUsersBtn.setBackground(new java.awt.Color(255, 51, 51));
        delUsersBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        delUsersBtn.setText("Delete");
        delUsersBtn.setToolTipText("");
        delUsersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delUsersBtnActionPerformed(evt);
            }
        });

        rsUsersBtn.setBackground(new java.awt.Color(255, 204, 204));
        rsUsersBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rsUsersBtn.setText("Reset");
        rsUsersBtn.setToolTipText("");
        rsUsersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rsUsersBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rsUsersBtn)
                    .addComponent(delUsersBtn)
                    .addComponent(editUsersBt, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createUsersBt))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(createUsersBt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editUsersBt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(delUsersBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rsUsersBtn)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1265, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        usersJtb.addTab("Users List", jPanel9);

        menuListJtb.addTab("User", new javax.swing.ImageIcon(getClass().getResource("/icon/khachHang.png")), usersJtb); // NOI18N

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 683, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 576, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 587, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout TeamLayout = new javax.swing.GroupLayout(Team);
        Team.setLayout(TeamLayout);
        TeamLayout.setHorizontalGroup(
            TeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        TeamLayout.setVerticalGroup(
            TeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menuListJtb.addTab("Team", new javax.swing.ImageIcon(getClass().getResource("/icon/me.png")), Team); // NOI18N

        StatisticalJtb.setBackground(new java.awt.Color(204, 204, 255));

        jPanel17.setBackground(new java.awt.Color(204, 204, 255));

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
        jScrollPane9.setViewportView(jTable1);

        jPanel20.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        StatisticalJtb.addTab("Statistical", jPanel17);

        menuListJtb.addTab("Statistical", new javax.swing.ImageIcon(getClass().getResource("/icon/doanhthu.png")), StatisticalJtb); // NOI18N

        logoutJp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutJpMouseClicked(evt);
            }
        });
        logoutJp.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                logoutJpComponentShown(evt);
            }
        });

        javax.swing.GroupLayout logoutJpLayout = new javax.swing.GroupLayout(logoutJp);
        logoutJp.setLayout(logoutJpLayout);
        logoutJpLayout.setHorizontalGroup(
            logoutJpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1270, Short.MAX_VALUE)
        );
        logoutJpLayout.setVerticalGroup(
            logoutJpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 576, Short.MAX_VALUE)
        );

        menuListJtb.addTab("Log Out ", new javax.swing.ImageIcon(getClass().getResource("/icon/output.png")), logoutJp); // NOI18N

        jPanel5.setBackground(new java.awt.Color(162, 222, 235));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("CATEGORY MANAGER");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(221, 221, 221))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(0, 255, 255));
        jPanel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("User:");

        userNameLoginTxt.setText(" ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Today: ");

        timeJlabel.setText(" ");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timeJlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(userNameLoginTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(userNameLoginTxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(timeJlabel))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(menuListJtb)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(menuListJtb, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        menuListJtb.getAccessibleContext().setAccessibleName("MenuList");

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

    private void searchShopBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchShopBtnActionPerformed
        // TODO add your handling code here:
        String s = JOptionPane.showInputDialog("Enter the store name to search?");

        if (s.isEmpty()) {
            shopList = ShopInfoDAO.getShopList(null);
        } else {
            shopList = ShopInfoDAO.getShopList("%" + s + "%");
        }

        showShop();
    }//GEN-LAST:event_searchShopBtnActionPerformed

    private void rsShopBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rsShopBtnActionPerformed
        // TODO add your handling code here:
        ResetShop();
    }//GEN-LAST:event_rsShopBtnActionPerformed

    private void delShopBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delShopBtnActionPerformed
        // TODO add your handling code here:
        if (currentIndex == -1) {
            JOptionPane.showMessageDialog(rootPane, "You haven't chosen yet? ");
            return;
        }
        int option = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete this store? ");

        if (option == 0) {
            ShopInfoDAO.deleteShop(shopList.get(currentIndex).getIdShop());
            shopList.remove(currentIndex);
            currentIndex = -1;

            showShop();
        }
    }//GEN-LAST:event_delShopBtnActionPerformed

    private void createShopBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createShopBtnActionPerformed
        // TODO add your handling code here:
        boolean check = true;
        String ShopName = nameSTxt.getText();
        String ShopPhone = phoneSTxt.getText();
        String Address = addressSTxt.getText();
        String Email = emailSTxt.getText();
        if (!(Pattern.matches("^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$", Email))) {
            JOptionPane.showMessageDialog(null, "Please enter a valid email", "Error", JOptionPane.ERROR_MESSAGE);
            check = false;
        } else {
            JOptionPane.showMessageDialog(null, "The email is valid", "Good!", JOptionPane.INFORMATION_MESSAGE);

        }

        if (check == true) {

            Shopinfo si = new Shopinfo(ShopName, ShopPhone, Address, Email);

            ShopInfoDAO.insertShop(si);

            shopList = ShopInfoDAO.getShopList(null);
            showShop();
        }
    }//GEN-LAST:event_createShopBtnActionPerformed

    private void nameSTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameSTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameSTxtActionPerformed

    private void logoutJpComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_logoutJpComponentShown
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to out? ");
        Users u = new Users();
        userList.add(u);
        if (option == 0) {

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Login().setVisible(true);
                }
            });
            setVisible(false);
            dispose();
        }


    }//GEN-LAST:event_logoutJpComponentShown

    private void logoutJpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutJpMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutJpMouseClicked

    private void createUsersBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUsersBtActionPerformed
        // TODO add your handling code here:
        boolean check = true;
        String username = usernameTXT.getText();
        String password = PwdTXT.getText();
        String confirmpwd = ConfirmPwdTXT.getText();
        String address = addresUserTXT.getText();
        String fullname = fullNameUserTXT.getText();
        String mobile = mobileUserTXT.getText();
        String Email = emailUserTXT.getText();

        String Account = cbxAccount.getSelectedItem().toString();
        String Active = jCbActive.getSelectedItem().toString();
        if (!(Pattern.matches("^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$", Email))) {
            JOptionPane.showMessageDialog(null, "Please enter a valid email", "Error", JOptionPane.ERROR_MESSAGE);
            check = false;
        } else {
            JOptionPane.showMessageDialog(null, "The email is valid", "Good!", JOptionPane.INFORMATION_MESSAGE);

        }
        if (!password.equals(confirmpwd)) {
            JOptionPane.showMessageDialog(rootPane, "Plz check password and confirm password");
            return;
        }
        password = Utility.getSecurityMD5(password);
        if (check == true) {
            Users u;
            if (Account.equals("Admin")) {
                u = new Users(username, password, 1, 1, mobile, address, fullname, Email);
                UserDAO.insert(u);
                ResetUsers();

            } else if (Account.equals("Staff") && Active.equals("Activated")) {
                u = new Users(username, password, 2, 1, mobile, address, fullname, Email);
                UserDAO.insert(u);
                ResetUsers();
            } else {
                u = new Users(username, password, 2, 0, mobile, address, fullname, Email);
                UserDAO.insert(u);
                ResetUsers();
            }
        }
        tableModel = (DefaultTableModel) usersTable.getModel();
        userList = UserDAO.getUserList();
        showUsers();
    }//GEN-LAST:event_createUsersBtActionPerformed

    private void rsUsersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rsUsersBtnActionPerformed
        // TODO add your handling code here:
        ResetUsers();
        createUsersBt.setEnabled(true);
    }//GEN-LAST:event_rsUsersBtnActionPerformed

    private void editUsersBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUsersBtActionPerformed
        // TODO add your handling code here:
        String username = usernameTXT.getText();
        //   String password = PwdTXT.getText();
        String confirmpwd = ConfirmPwdTXT.getText();
        String address = addresUserTXT.getText();
        String fullname = fullNameUserTXT.getText();
        String mobile = mobileUserTXT.getText();
        String email = emailUserTXT.getText();
        String Account = cbxAccount.getSelectedItem().toString();
        String Active = jCbActive.getSelectedItem().toString();
        /*    if (!password.equals(confirmpwd)) {
            JOptionPane.showMessageDialog(rootPane, "Plz check password and confirm password");
            return;
        }
        password = Utility.getSecurityMD5(password);
         */
        Users u;

        if (currentIndex >= 0) {
            u = userList.get(currentIndex);
            currentIndex = -1;

            u.setUsername(username);
            //  u.setPassword(password);
            u.setAddress(address);
            u.setFullname(fullname);
            u.setMobile(mobile);
            u.setEmail(email);
            if (Account.equals("Admin")) {
                u.setActive(1);
            } else if (Account.equals("Staff") && Active.equals("Activated")) {
                u.setActive(1);
            } else {
                u.setActive(0);
            }
            UserDAO.update(u);
        }

        createUsersBt.setEnabled(false);

        showUsers();

    }//GEN-LAST:event_editUsersBtActionPerformed

    private void cbxAccountItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxAccountItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxAccountItemStateChanged

    private void cbxAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxAccountActionPerformed

    private void delUsersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delUsersBtnActionPerformed
        // TODO add your handling code here:
        if (currentIndex == -1) {
            JOptionPane.showMessageDialog(rootPane, "You haven't chosen yet? ");
            return;
        }
        int option = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete it? ");

        if (option == 0) {
            UserDAO.deleteID(userList.get(currentIndex).getIdUser());
            userList.remove(currentIndex);
            currentIndex = -1;
            
           
            showUsers();
        }
    }//GEN-LAST:event_delUsersBtnActionPerformed

    private void createSvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createSvBtnActionPerformed
        // TODO add your handling code here:ư
        String nameSv = nameSvTxt.getText();
        int priceSv = Integer.parseInt(priceSvTxt.getText());
        String noteSv = noteSvTxtArea.getText();

        Service sv = new Service(nameSv, priceSv, noteSv);

        ServiceDAO.insertSer(sv);
        ResetService();
    }//GEN-LAST:event_createSvBtnActionPerformed

    private void resetSvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetSvBtnActionPerformed
        // TODO add your handling code here:
        ResetService();
    }//GEN-LAST:event_resetSvBtnActionPerformed

    private void delSvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delSvBtnActionPerformed
        // TODO add your handling code here:
        if (currentIndex == -1) {
            JOptionPane.showMessageDialog(rootPane, "You haven't chosen yet? ");
            return;
        }
        int option = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete it? ");

        if (option == 0) {
            ServiceDAO.deleteSerID(serviceList.get(currentIndex).getIdService());
            userList.remove(currentIndex);
            currentIndex = -1;

            showService();
        }
    }//GEN-LAST:event_delSvBtnActionPerformed

    private void createWhBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createWhBtnActionPerformed
        // TODO add your handling code here:
        String nameWh = nameWhTxt.getText();
        String AddressWh = addressWhTxt.getText();
        String noteWh = noteWhTxtArea.getText();

        Warehouse wh = new Warehouse(nameWh, AddressWh, noteWh);

        WareHouseDAO.insertWhouse(wh);
        showWhouse();
        ResetWhouse();
    }//GEN-LAST:event_createWhBtnActionPerformed

    private void delWhBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delWhBtnActionPerformed
        // TODO add your handling code here:
        if (currentIndex == -1) {
            JOptionPane.showMessageDialog(rootPane, "You haven't chosen yet? ");
            return;
        }
        int option = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete it? ");

        if (option == 0) {
            WareHouseDAO.deleteWhouse(whouseList.get(currentIndex).getIdWhouse());
            whouseList.remove(currentIndex);
            currentIndex = -1;

            showWhouse();
        }
    }//GEN-LAST:event_delWhBtnActionPerformed

    private void resetWhBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetWhBtnActionPerformed
        // TODO add your handling code here:
        ResetWhouse();
    }//GEN-LAST:event_resetWhBtnActionPerformed

    private void priceSvTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceSvTxtKeyTyped
        // TODO add your handling code here:
        NumbCheck(evt);
    }//GEN-LAST:event_priceSvTxtKeyTyped

    private void mobileUserTXTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobileUserTXTKeyTyped
        // TODO add your handling code here:
        NumbCheck(evt);
    }//GEN-LAST:event_mobileUserTXTKeyTyped

    private void phoneSTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneSTxtKeyTyped
        // TODO add your handling code here:
        NumbCheck(evt);
    }//GEN-LAST:event_phoneSTxtKeyTyped

    private void searchOrdersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchOrdersBtnActionPerformed
        // TODO add your handling code here:
        String s = JOptionPane.showInputDialog("Enter the rollno name to search?");

        if (s.isEmpty()) {
            ordersList = OrderDAO.getOrdersList(null);
        } else {
            ordersList = OrderDAO.getOrdersList("%" + s + "%");
        }

        showOrders();
    }//GEN-LAST:event_searchOrdersBtnActionPerformed

    private void delOrdersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delOrdersBtnActionPerformed
        // TODO add your handling code here:
        if (currentIndex == -1) {
            JOptionPane.showMessageDialog(rootPane, "You haven't chosen yet? ");
            return;
        }
        int option = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete it? ");

        if (option == 0) {
            OrderDAO.deleteOrders(ordersList.get(currentIndex).getIdOrders());
            whouseList.remove(currentIndex);
            currentIndex = -1;

            showOrders();
        }
    }//GEN-LAST:event_delOrdersBtnActionPerformed

    private void creOdersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creOdersBtnActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order().setVisible(true);
            }
        });
        setVisible(false);
    }//GEN-LAST:event_creOdersBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField ConfirmPwdTXT;
    private javax.swing.JPasswordField PwdTXT;
    private javax.swing.JTabbedPane StatisticalJtb;
    private javax.swing.JPanel Team;
    private javax.swing.JTable WHHistoryjTab;
    private javax.swing.JPanel WHouseHistory;
    private javax.swing.JPanel WHouseList;
    private javax.swing.JTextField addresUserTXT;
    private javax.swing.JTextField addressSTxt;
    private javax.swing.JTextField addressWhTxt;
    private javax.swing.JComboBox<Role> cbxAccount;
    private javax.swing.JButton creOdersBtn;
    private javax.swing.JButton createShopBtn;
    private javax.swing.JButton createSvBtn;
    private javax.swing.JButton createUsersBt;
    private javax.swing.JButton createWhBtn;
    private javax.swing.JButton delOrdersBtn;
    private javax.swing.JButton delShopBtn;
    private javax.swing.JButton delSvBtn;
    private javax.swing.JButton delUsersBtn;
    private javax.swing.JButton delWhBtn;
    private javax.swing.JButton editUsersBt;
    private javax.swing.JTextField emailSTxt;
    private javax.swing.JTextField emailUserTXT;
    private javax.swing.JTextField fullNameUserTXT;
    private javax.swing.JComboBox<String> jCbActive;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel logoutJp;
    private javax.swing.JTabbedPane menuListJtb;
    private javax.swing.JTextField mobileUserTXT;
    private javax.swing.JTextField nameSTxt;
    private javax.swing.JTextField nameSvTxt;
    private javax.swing.JTextField nameWhTxt;
    private javax.swing.JTextArea noteSvTxtArea;
    private javax.swing.JTextArea noteWhTxtArea;
    private javax.swing.JTabbedPane odersJtb;
    private javax.swing.JTable ordersjTab;
    private javax.swing.JTextField phoneSTxt;
    private javax.swing.JTextField priceSvTxt;
    private javax.swing.JButton resetSvBtn;
    private javax.swing.JButton resetWhBtn;
    private javax.swing.JButton rsShopBtn;
    private javax.swing.JButton rsUsersBtn;
    private javax.swing.JButton searchOrdersBtn;
    private javax.swing.JButton searchShopBtn;
    private javax.swing.JTabbedPane serviceJtb;
    private javax.swing.JTable serviceTab;
    private javax.swing.JTable shopInfoTab;
    private javax.swing.JTabbedPane shopJtb;
    private javax.swing.JLabel timeJlabel;
    private javax.swing.JLabel userNameLoginTxt;
    private javax.swing.JTextField usernameTXT;
    private javax.swing.JTabbedPane usersJtb;
    private javax.swing.JTable usersTable;
    private javax.swing.JTable wareHouseTab;
    private javax.swing.JTabbedPane warehouseJtb;
    // End of variables declaration//GEN-END:variables
}
