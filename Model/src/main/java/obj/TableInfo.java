/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author user
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableInfo {

    private String columnName;
    private String dataType;
    private String comment;

}
