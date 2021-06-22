/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author user
 */
public class IODeal {

    /**
     * path和内容
     *
     * @param filePath
     * @param input
     * @return
     */
    public static boolean createCsv(String filePath, String input) {

        try {
            try ( // 上書き
                    FileWriter fw = new FileWriter(filePath, false)) {
                fw.write(input);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
