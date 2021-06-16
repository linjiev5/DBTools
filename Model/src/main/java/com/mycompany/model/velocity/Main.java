/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.velocity;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Properties;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.context.Context;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

/**
 *
 * @author alinj
 */
public class Main {

    public static void main(String... args) {
        Properties p = new Properties();
        p.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        p.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        Velocity.init(p);

        Context context = new VelocityContext();
        context.put("key", "value0001");

        Template template = new Template();
        template = Velocity.getTemplate("\templetes.vm", "UTF-8");

        try (StringWriter body = new StringWriter();) {
            template.merge(context, body);
            body.flush();
            System.out.println(body.toString());;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
