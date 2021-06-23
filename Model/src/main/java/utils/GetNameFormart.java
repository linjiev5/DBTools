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
}
