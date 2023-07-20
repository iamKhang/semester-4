/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import bus.NhanVien_bus;
import bus.TaiKhoan_bus;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import entity.connguoi.NhanVien;

/**
 *
 * @author thanh
 */
public class Frame_DangNhap extends javax.swing.JFrame {

    private final MainView main;

    private final TaiKhoan_bus taiKhoan_bus = new TaiKhoan_bus();
    private final NhanVien_bus nhanVien_bus = new NhanVien_bus();

    public Frame_DangNhap(MainView main) {
        this.main = main;
        initComponents();
    }

    public void close() {
        this.setVisible(false);
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_img = new javax.swing.JPanel();
        lbl_img = new javax.swing.JLabel();
        pnl_form = new javax.swing.JPanel();
        lbl_dangNhap = new javax.swing.JLabel();
        pnl_formInput = new javax.swing.JPanel();
        pnl_username = new javax.swing.JPanel();
        lbl_ma = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        txt_username = new javax.swing.JTextField();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 20));
        pnl_password = new javax.swing.JPanel();
        lbl_pass = new javax.swing.JLabel();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        txt_password = new javax.swing.JPasswordField();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 30), new java.awt.Dimension(0, 30), new java.awt.Dimension(32767, 50));
        pnl_control = new javax.swing.JPanel();
        btn_login = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        pnl_img.setBackground(new java.awt.Color(255, 255, 255));
        pnl_img.setPreferredSize(new java.awt.Dimension(250, 0));
        pnl_img.setLayout(new java.awt.BorderLayout());

        lbl_img.setBackground(new java.awt.Color(153, 204, 255));
        lbl_img.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbl_img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Login.png"))); // NOI18N
        lbl_img.setText("ComputerPartsShop");
        lbl_img.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_img.setMaximumSize(new java.awt.Dimension(250, 184));
        lbl_img.setMinimumSize(new java.awt.Dimension(250, 184));
        lbl_img.setPreferredSize(new java.awt.Dimension(250, 184));
        lbl_img.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pnl_img.add(lbl_img, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnl_img, java.awt.BorderLayout.WEST);

        pnl_form.setBackground(new java.awt.Color(255, 255, 255));
        pnl_form.setPreferredSize(new java.awt.Dimension(300, 300));
        pnl_form.setLayout(new java.awt.BorderLayout());

        lbl_dangNhap.setFont(new java.awt.Font("Damascus", 1, 25)); // NOI18N
        lbl_dangNhap.setForeground(new java.awt.Color(65, 165, 238));
        lbl_dangNhap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_dangNhap.setText("ĐĂNG NHẬP");
        lbl_dangNhap.setToolTipText("");
        lbl_dangNhap.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_dangNhap.setPreferredSize(new java.awt.Dimension(146, 60));
        pnl_form.add(lbl_dangNhap, java.awt.BorderLayout.PAGE_START);

        pnl_formInput.setBackground(new java.awt.Color(255, 255, 255));
        pnl_formInput.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnl_formInput.setLayout(new javax.swing.BoxLayout(pnl_formInput, javax.swing.BoxLayout.Y_AXIS));

        pnl_username.setBackground(new java.awt.Color(255, 255, 255));
        pnl_username.setPreferredSize(new java.awt.Dimension(0, 50));
        pnl_username.setLayout(new javax.swing.BoxLayout(pnl_username, javax.swing.BoxLayout.X_AXIS));

        lbl_ma.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_ma.setText("Mã nhân viên:");
        lbl_ma.setPreferredSize(new java.awt.Dimension(100, 30));
        pnl_username.add(lbl_ma);
        pnl_username.add(filler1);

        txt_username.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_username.setText("NV0003");
        txt_username.setToolTipText("");
        txt_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usernameKeyPressed(evt);
            }
        });
        pnl_username.add(txt_username);

        pnl_formInput.add(pnl_username);
        pnl_formInput.add(filler5);

        pnl_password.setBackground(new java.awt.Color(255, 255, 255));
        pnl_password.setPreferredSize(new java.awt.Dimension(0, 50));
        pnl_password.setLayout(new javax.swing.BoxLayout(pnl_password, javax.swing.BoxLayout.X_AXIS));

        lbl_pass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_pass.setText("Mật khẩu:");
        lbl_pass.setPreferredSize(new java.awt.Dimension(100, 30));
        pnl_password.add(lbl_pass);
        pnl_password.add(filler6);

        txt_password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_password.setText("1111");
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordKeyPressed(evt);
            }
        });
        pnl_password.add(txt_password);

        pnl_formInput.add(pnl_password);
        pnl_formInput.add(filler2);

        pnl_control.setBackground(new java.awt.Color(255, 255, 255));
        pnl_control.setMinimumSize(new java.awt.Dimension(112, 100));
        pnl_control.setPreferredSize(new java.awt.Dimension(0, 100));
        pnl_control.setLayout(new java.awt.GridLayout(2, 0, 0, 4));

        btn_login.setBackground(new java.awt.Color(65, 165, 238));
        btn_login.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setText("Đăng nhập");
        btn_login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_login.setPreferredSize(new java.awt.Dimension(107, 30));
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        pnl_control.add(btn_login);

        btn_cancel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_cancel.setText("Hủy bỏ");
        btn_cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
        pnl_control.add(btn_cancel);

        pnl_formInput.add(pnl_control);

        pnl_form.add(pnl_formInput, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnl_form, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        close();
    }//GEN-LAST:event_btn_cancelActionPerformed
    
    public void handleLogin() {
        String username = txt_username.getText().trim();
        String password = new String(txt_password.getPassword());
        
        boolean isValid = taiKhoan_bus.kiemTraTaiKhoan(username, password);
        

//        Dang nhap
        if (isValid) {
            try {
                NhanVien nhanVien = nhanVien_bus.getNhanVienTheoMa(username).get(0);
                // Neu trang thai = da nghi => khong cho dang nhap
                if(!nhanVien.isTrangThai()) {
                    JOptionPane.showMessageDialog(this, "Tài khoản của bạn đã bị vô hiệu hoá !");
                    return;
                }
                    
                main.login(nhanVien);
                close();
            } catch (HeadlessException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Tài khoản, mật khẩu không chính xác", "Đăng nhập sai", JOptionPane.DEFAULT_OPTION);
            txt_username.selectAll();
            txt_username.requestFocus();
        }
    }
    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        handleLogin();
    }//GEN-LAST:event_btn_loginActionPerformed

    private void txt_usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usernameKeyPressed
        if (evt.getKeyCode() == 10) {
            handleLogin();
        }
    }//GEN-LAST:event_txt_usernameKeyPressed

    private void txt_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyPressed
        if (evt.getKeyCode() == 10) {
            handleLogin();
        }
    }//GEN-LAST:event_txt_passwordKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_login;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.JLabel lbl_dangNhap;
    private javax.swing.JLabel lbl_img;
    private javax.swing.JLabel lbl_ma;
    private javax.swing.JLabel lbl_pass;
    private javax.swing.JPanel pnl_control;
    private javax.swing.JPanel pnl_form;
    private javax.swing.JPanel pnl_formInput;
    private javax.swing.JPanel pnl_img;
    private javax.swing.JPanel pnl_password;
    private javax.swing.JPanel pnl_username;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
