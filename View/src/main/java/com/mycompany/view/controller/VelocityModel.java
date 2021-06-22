/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.view.controller;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Properties;
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
public class VelocityModel {

    public static void main(String[] args) {
        VelocityModel main = new VelocityModel();

    }

    /*
    public void useVelocityEngine() {
        try {
            VelocityEngine ve = new VelocityEngine();
            ve.init(getDefaultProp());
            VelocityContext context = new VelocityContext();

            context.put("list", "#");
            context.put("hello", "Hello World!");
            context.put("hello", "Hello World!");
            context.put("hello", "Hello World!");
            StringWriter w = new StringWriter();
            Template t = ve.getTemplate("templete.vm", "UTF-8");

            t.merge(context, w);
            System.out.println("template:" + w);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     */
    public void useVelocity(String path, String tableName) {
        try {
            Velocity.init(getDefaultProp());
            VelocityContext context = new VelocityContext();
            context.put("packagePath", "Hello World!");
            path = path.substring(path.lastIndexOf("java\\")).substring(5).replace("\\", ".");
            context.put("packagePath", path);
            ArrayList<TableInfo> tableInfo = DBUtils.getTableInfo(tableName);
            context.put("list", tableInfo);
            tableName = GetNameFormart.getPropertity(tableName);
            context.put("tableName", tableName);
            context.put("className", GetNameFormart.getClassName(tableName));
            StringWriter w = new StringWriter();
            Template t = Velocity.getTemplate("templete.vm", "UTF-8");
            t.merge(context, w);
            try {
                PrintWriter writer = new PrintWriter(path);
                t.merge(context, writer);
                writer.flush();
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
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
