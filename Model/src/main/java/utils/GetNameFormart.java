/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author user
 */
public class GetNameFormart {

    /**
     * 駝峰轉換字母
     *
     * @param colum
     * @return
     */
    public static String getPropertity(String colum) {
        String pro;
        int index = colum.indexOf("_");
        //判断アンダーバーがあるかどうか
        if (index < 0) {
            //アンダーバーがない
            pro = colum.substring(0, 1).toLowerCase() + colum.substring(1);//首字母小写
        } else {
            //アンダーバーがある
            StringBuilder sb = new StringBuilder();
            String[] colums = colum.split("_");
            for (int i = 0; i < colums.length; i++) {
                if (i == 0) {
                    //拼接第一个,并将首字母小写
                    sb.append(colums[i].substring(0, 1).toLowerCase()).append(colums[i].substring(1));
                } else {
                    //除了第一个都将首字母大写
                    sb.append(colums[i].substring(0, 1).toUpperCase()).append(colums[i].substring(1));
                }
            }
            pro = sb.toString();
        }

        return pro;
    }

    /**
     * 頭文字を大文字にする
     *
     * @param column
     * @return
     */
    public static String getFirstUpperCase(String column) {
        // 頭文字を大文字にする
        String newColumnName = column.substring(0, 1).toUpperCase() + column.substring(1);
        return newColumnName;
    }

    /**
     * 生成类名
     *
     * @param tableName 表名
     * @return
     */
    public static String getClassName(String tableName) {
        String newClassName;
        int i = tableName.indexOf("_");
        if (i < 0) {
            //アンダーバーがない場合
            newClassName = tableName.substring(0, 1).toUpperCase() + tableName.substring(1);
        } else {
            //アンダーバーがある場合
            String[] strs = tableName.split("_");
            StringBuilder sb = new StringBuilder();
            for (String str : strs) {
                sb.append(str.substring(0, 1).toUpperCase()).append(str.substring(1));
            }
            newClassName = sb.toString();
        }
        return newClassName;
    }

    public static String getDataType(String input) {
        if (input.contains("varying") || input.contains("text")) {
            return "String";
        } else if (input.contains("character") || input.contains("char")) {
            return "char";
        } else if (input.contains("boolean ") || input.contains("bit")) {
            return "boolean";
        } else if (input.contains("integer") || input.contains("int")) {
            return "int";
        } else if (input.contains("bigint") || input.contains("biginteger") || input.contains("long")) {
            return "long";
        } else if (input.contains("date") || input.contains("DATA")) {
            return "Date";
        } else if (input.contains("timestamp")) {
            return "Timestamp";
        } else {
            return "UnsupportedType";
        }
    }

}
