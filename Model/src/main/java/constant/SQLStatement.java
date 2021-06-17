/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constant;

import lombok.Data;

/**
 * SQL語句
 *
 * @author user
 */
@Data
public class SQLStatement {

    public static final String GET_TABLE_NAME = "SELECT TABLENAME\n"
            + "FROM PG_TABLES\n"
            + "WHERE SCHEMANAME='public'";

}
