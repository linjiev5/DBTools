/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.mycompany.model.velocity.service.DbInfo;
import constant.SQLStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import obj.DBInfoObj;

import obj.TableInfo;

/**
 *
 * @author user
 */
public class DBUtils {

    /**
     * 根据表名找標題名、數據類型、數據註解
     *
     * @param tableName
     * @return
     */
    public static ArrayList<TableInfo> getTableInfo(String tableName) {
        ArrayList<TableInfo> tableInfos = new ArrayList<>();
        Connection connection = getConnectDBInfo().getConnection();
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
                ti.setColumnName(GetNameFormart.getPropertity(rs.getString("name")));
                ti.setDataType(GetNameFormart.getDataType(rs.getString("type")));
                ti.setComment(rs.getString("comment"));
                tableInfos.add(ti);
            }
            return tableInfos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 獲取表名
     *
     * @return
     */
    public static ArrayList<String> getTableName() {
        ArrayList<String> tableNames = new ArrayList<>();
        Connection connection = getConnectDBInfo().getConnection();
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            // sql
            String query = SQLStatement.GET_TABLE_NAME;
            rs = st.executeQuery(query);

            while (rs.next()) {
                String tableName = new String();
                tableName = rs.getString("tablename");
                tableNames.add(tableName);
            }
            return tableNames;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 鏈接數據庫
     *
     * @return
     */
    public static Connect getConnectDBInfo() {
        Connect c = new Connect();
        DBInfoObj dbInfo = DbInfo.getDBInfo();
        c.setUrl("jdbc:" + dbInfo.getDBType() + "://localHost:" + dbInfo.getPort() + "/" + dbInfo.getDbName());
        c.setUser(dbInfo.getUser());
        c.setPas(dbInfo.getPassword());
        return c;
    }

    /**
     * 判斷數據庫是否連接
     *
     * @return
     */
    public static boolean isConnectDB() {
        Connect c = new Connect();
        DBInfoObj dbInfo = DbInfo.getDBInfo();
        c.setUrl("jdbc:" + dbInfo.getDBType() + "://localHost:" + dbInfo.getPort() + "/" + dbInfo.getDbName());
        c.setUser(dbInfo.getUser());
        c.setPas(dbInfo.getPassword());
        Connection connection = c.getConnection();
        if (connection != null) {
            return true;
        } else {
            return false;
        }
    }
}
