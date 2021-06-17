/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author user
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Connect {

    private String url;
    private String user;
    private String pas;

    /**
     * データベースに連結する
     *
     * @return
     */
    public java.sql.Connection getConnection() {
        java.sql.Connection con;
        try {
            con = DriverManager.getConnection(getUrl(), getUser(), getPas());
            return con;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * queryでデータを増やし、削除、更新する
     *
     * @param query
     * @return i
     */
    public int excuteSQLQuery(String query) {
        int i = 0;
        java.sql.Connection con = getConnection();
        Statement st;
        try {
            st = con.createStatement();
            // 入れたsqlを実行する
            System.out.println(query);
            i = st.executeUpdate(query);
            con.close();
            st.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * データベースに同じデータがあるか
     *
     * @param query
     * @return 同じデータがない場合は”0”　ある場合は”1”
     */
    public int getSameData(String query) {
        int i = 0;
        java.sql.Connection con = getConnection();
        Statement stmt;
        try {
            stmt = con.createStatement();
            // sqlqueryで検索する
            ResultSet rs = stmt.executeQuery(query);
            // データが存在する場合

            if (rs != null && rs.next()) {
                i = 1;
            } else {
                // データがなければiは0のまま戻る
            }
            con.close();
            stmt.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(i);
        return i;
    }
}
