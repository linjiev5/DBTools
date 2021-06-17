/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import obj.TableInfo;

/**
 *
 * @author user
 */
public class DBUtils {

    /**
     * 根据表名找標題名、數據類型、數據註解
     *
     * @param c
     * @param tableName
     * @return
     */
    public static ArrayList<TableInfo> getTableInfo(Connect c, String tableName) {
        ArrayList<TableInfo> tableInfos = new ArrayList<>();
        Connection connection = c.getConnection();
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            // sql
            String query = "SELECT\n"
                    + "    a.attname as name\n"
                    + "    , format_type(a.atttypid, a.atttypmod) as type\n"
                    + "    , col_description(a.attrelid, a.attnum) as comment \n"
                    + "FROM\n"
                    + "    pg_class as c\n"
                    + "    , pg_attribute as a \n"
                    + "where\n"
                    + "    c.relname = '" + tableName + "' \n"
                    + "    and a.attrelid = c.oid \n"
                    + "    and a.attnum > 0";
            rs = st.executeQuery(query);

            while (rs.next()) {
                TableInfo ti = new TableInfo();
                ti.setColumnName(rs.getString("name"));
                ti.setDataType(rs.getString("type"));
                ti.setComment("comment");
                tableInfos.add(ti);
            }
            return tableInfos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
