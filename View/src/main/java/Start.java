
import com.mycompany.view.MainView;
import java.util.ArrayList;
import utils.DBUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alinj
 */
public class Start {

    public static void main(String... args) {
        ArrayList<String> tableNames = DBUtils.getTableName(DBUtils.getConnectDB());
        for (String str : tableNames) {

            System.out.println(str);
        }
        MainView main = new MainView();
        main.setVisible(true);
    }
}
