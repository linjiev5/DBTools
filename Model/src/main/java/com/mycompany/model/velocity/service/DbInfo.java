/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.velocity.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import obj.DBInfoObj;
import utils.GetPath;

/**
 *
 * @author user
 */
public class DbInfo {

    /**
     * DBの保存情報ファイルを読み取る
     *
     * @return
     */
    public static DBInfoObj getDBInfo() {
        DBInfoObj info = new DBInfoObj();
        try {
            // ファイル読み取る
            String courseFile = GetPath.getProjectPath();
            FileInputStream fr = new FileInputStream(courseFile + "\\src\\main\\resources\\dbInfo.csv");
            BufferedReader br = new BufferedReader(new InputStreamReader(fr));
            String str;
            br.readLine();
            if ((str = br.readLine()) != null) {
                String[] strs = str.split(",");
                info.setDBType(strs[0]);
                info.setPort(strs[1]);
                info.setDbName(strs[2]);
                info.setUser(strs[3]);
                info.setPassword(strs[4]);
                return info;
            }
            br.close();
            fr.close();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * DB保存情報を更新する
     *
     * @param info
     * @return
     */
    public static int setDBInfo(DBInfoObj info) {
        int result = -1;
        if (info == null) {
            result = 0;
        } else {
            try {
                String courseFile = GetPath.getProjectPath();
                FileOutputStream fos = new FileOutputStream(courseFile + "\\src\\main\\resources\\dbInfo.csv");
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);
                String templete = "DBType,PortNumber,DBName,User,Password\n";
                String str = info.getDBType() + "," + info.getPort() + "," + info.getDbName() + "," + info.getUser() + "," + info.getPassword();
                bw.write(templete);
                bw.write(str);
                bw.flush();
                bw.close();
                fos.close();
                osw.close();
                result = 1;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
