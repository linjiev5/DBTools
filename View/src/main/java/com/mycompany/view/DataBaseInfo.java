package com.mycompany.view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.model.velocity.service.DbInfo;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import obj.DBInfoObj;

/**
 *
 * @author user
 */
public class DataBaseInfo extends javax.swing.JFrame {

    /**
     * Creates new form NewDateBase
     */
    public DataBaseInfo() {
        initComponents();
        this.setLocationRelativeTo(null); // 画面を中心にする
        reFormatCombox();
        showData();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hostLabel = new javax.swing.JLabel();
        dBNameLabel = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        localhost = new javax.swing.JTextField();
        dataBaseName = new javax.swing.JTextField();
        user = new javax.swing.JTextField();
        save = new javax.swing.JToggleButton();
        close = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        dBType = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        hostLabel.setText("ポート番号");

        dBNameLabel.setText("ＤＢ名");

        userLabel.setText("User");

        passwordLabel.setText("Password");

        localhost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                localhostKeyTyped(evt);
            }
        });

        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });

        save.setText("保存");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        close.setText("閉じる");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        clear.setText("クリア");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        dBType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        dBType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dBTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(dBNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(dataBaseName)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dBType, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(hostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(localhost, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(save)
                .addGap(28, 28, 28)
                .addComponent(clear)
                .addGap(26, 26, 26)
                .addComponent(close)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(localhost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dBType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dBNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(dataBaseName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );

        dBType.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        MainView m = new MainView();
        if (checkInput()) {
            DBInfoObj info = new DBInfoObj();
            info.setDBType(dBType.getSelectedItem().toString());
            info.setDbName(dataBaseName.getText());
            info.setPassword(password.getText());
            info.setPort(localhost.getText());
            info.setUser(user.getText());
            int result = DbInfo.setDBInfo(info);
            switch (result) {
                case 0:
                    m.showMessage.setText("amazing");
                    break;
                case 1:
                    m.showMessage.setText(dataBaseName.getText() + "を保存しました");
                    break;
                default:
                    m.showMessage.setText("error");
                    break;
            }
            m.dbName.setText(dataBaseName.getText());
            this.dispose();
            m.setVisible(true);
        }
    }//GEN-LAST:event_saveActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        this.dispose();
        MainView m = new MainView();
        m.setVisible(true);
    }//GEN-LAST:event_closeActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        localhost.setText(null);
        dataBaseName.setText(null);
        user.setText(null);
        password.setText(null);
    }//GEN-LAST:event_clearActionPerformed

    private void localhostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_localhostKeyTyped
        // TODO add your handling code here:
        char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_localhostKeyTyped

    /**
     * 初期化するときにファイルデータを取得する
     */
    private void showData() {
        DBInfoObj dbInfo = DbInfo.getDBInfo();
        ComboBoxModel<String> model = dBType.getModel();
        model.setSelectedItem(dbInfo.getDBType());
        localhost.setText(dbInfo.getPort());
        user.setText(dbInfo.getUser());
        password.setText(dbInfo.getPassword());
        dataBaseName.setText(dbInfo.getDbName());
    }
    private void dBTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dBTypeActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_dBTypeActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    /**
     * 選択肢をリセットする
     */
    public void reFormatCombox() {
        dBType.removeAllItems();
        dBType.addItem("postgresql");
        dBType.addItem("mysql");
    }

    /**
     * 成功true,失敗false
     *
     * @return
     */
    private boolean isConnect() {
        DBInfoObj info = new DBInfoObj();
        info.setDBType(dBType.getSelectedItem().toString());
        info.setDbName(dataBaseName.getText());
        info.setPassword(password.getText());
        info.setPort(localhost.getText());
        info.setUser(user.getText());
        int result = DbInfo.setDBInfo(info);
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 空欄チェック
     *
     * @return
     */
    private boolean checkInput() {
        if (dataBaseName.getText().equals("") | localhost.getText().equals("") | user.getText().equals("") | password.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "空欄保存できません");
            return false;
        } else {
            return true;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear;
    private javax.swing.JButton close;
    private javax.swing.JLabel dBNameLabel;
    public javax.swing.JComboBox<String> dBType;
    public javax.swing.JTextField dataBaseName;
    private javax.swing.JLabel hostLabel;
    public javax.swing.JTextField localhost;
    public javax.swing.JPasswordField password;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JToggleButton save;
    public javax.swing.JTextField user;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
