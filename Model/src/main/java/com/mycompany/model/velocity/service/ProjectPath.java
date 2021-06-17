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
import utils.GetPath;

/**
 *
 * @author alinj
 */
public class ProjectPath {

    /**
     * ファイルを読み取る
     *
     * @return
     */
    public static String getPath() {
        try {
            // ファイル読み取る
            String courseFile = GetPath.getProjectPath();
            FileInputStream fr = new FileInputStream(courseFile + "\\src\\main\\resources\\path.csv");
            BufferedReader br = new BufferedReader(new InputStreamReader(fr));
            String str;
            br.readLine();
            if ((str = br.readLine()) != null) {
                return str;
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
     * 情報を更新する
     *
     * @param str
     * @return
     */
    public static int setPath(String str) {
        int result = -1;
        if (str.equals("")) {
            result = 0;
        } else {
            try {
                String courseFile = GetPath.getProjectPath();
                FileOutputStream fos = new FileOutputStream(courseFile + "\\src\\main\\resources\\path.csv");
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);
                String templete = "ProjectPath\n";
                bw.write(templete);
                bw.write(str);
                result = 1;
                bw.flush();
                bw.close();
                fos.close();
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
