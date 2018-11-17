package Dao;

import model.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class AdminDao extends Dao {
    public static boolean okAdmin(admin ad){
        Connection conn = null;
        String username = ad.getUserName();
        String psd = ad.getPassWord();
        conn = Dao.getConn();
        try {
            PreparedStatement pstmt = conn.prepareStatement("select Password from doctor where username = ? ");
            pstmt.setString(1,username);
            rs = pstmt.executeQuery();
            if (rs.next() && rs.getRow() > 0) {		//查询到用户信息
				String password = rs.getString(1).trim();	//获得密码
				if (password.equals(psd)) {
					return true;					//密码正确返回true
				} else {
					JOptionPane.showMessageDialog(null, "密码不正确");
					System.out.println("密码不正确");
					return false;					//密码错误返回false
				}
			} else {
				JOptionPane.showMessageDialog(null, "用户名不存在");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "数据库异常！\n"+e.getMessage());
			return false;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}
    }
}
