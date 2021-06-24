/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.view.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import obj.TableInfo;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import utils.DBUtils;
import utils.GetNameFormart;

/**
 *
 * @author user
 */
public class ObjectModel {

    public void useVelocity(String path, String type, String tableName) {
        try {
            Velocity.init(getDefaultProp());
            VelocityContext context = new VelocityContext();
            String newPath = path.substring(path.lastIndexOf("java\\")).substring(5).replace("\\", ".");
            context.put("packagePath", newPath + ".object");
            ArrayList<TableInfo> tableInfo = DBUtils.getTableInfo(tableName);
            context.put("list", tableInfo);
            String className = GetNameFormart.getClassName(tableName + "Object");
            context.put("className", className);
            StringWriter w = new StringWriter();
            Template t = Velocity.getTemplate("object.vm", "UTF-8");
            t.merge(context, w);
            File md = new File(path + "\\" + type);
            File f = new File(path + "\\" + type + "\\" + className + ".java");
            try {
                if (!md.exists()) {
                    md.mkdirs();
                    FileWriter fw = new FileWriter(f, false);
                    fw.write(w.toString());
                    fw.close();
                } else {
                    FileWriter fw = new FileWriter(f, false);
                    fw.write(w.toString());
                    fw.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(VelocityEntityModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("template:" + w);
        } catch (MethodInvocationException | ParseErrorException | ResourceNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Properties getDefaultProp() {
        Properties prop = new Properties();
        prop.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        prop.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        System.out.println(ClasspathResourceLoader.class.getName());
        return prop;
    }
}
