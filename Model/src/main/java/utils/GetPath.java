/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alinj
 */
public class GetPath {

    /**
     * 获取项目名称
     *
     * @return
     */
    public static String getProjectPath() {
        File directory = new File("");//参数为空
        try {
            return directory.getCanonicalPath();
        } catch (IOException ex) {
            Logger.getLogger(GetPath.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * 获取包名
     *
     * @return
     */
    public static String getPackagePath() {
        GetPath g = new GetPath();
        Package pack = g.getClass().getPackage();
        return pack.getName();
    }
}
