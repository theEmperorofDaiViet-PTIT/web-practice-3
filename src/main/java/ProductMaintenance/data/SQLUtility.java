package ProductMaintenance.data;

import java.sql.*;
import java.util.ArrayList;

import ProductMaintenance.entity.*;
public class SQLUtility {

    public static String getHTMLTable(ArrayList<Product> products) throws SQLException{
        StringBuilder htmlTable = new StringBuilder();

        htmlTable.append("<table>");
 
        htmlTable.append("<tr>");

            htmlTable.append("<th>");
            htmlTable.append("Code");
            htmlTable.append("</th>");
            
            htmlTable.append("<th>");
            htmlTable.append("Description");
            htmlTable.append("</th>");
            
            htmlTable.append("<th>");
            htmlTable.append("Price");
            htmlTable.append("</th>");            

        htmlTable.append("<th></th><th></th>");
        htmlTable.append("</tr>");

        for(int i = 0; i < products.size(); i++){
            htmlTable.append("<tr>");
            String code = products.get(i).getProductCode();
            String description = products.get(i).getProductDescription();
            String price = Double.toString(products.get(i).getPrice());
            
            htmlTable.append("<td>");
            htmlTable.append(code);
            htmlTable.append("</td>");
            
            htmlTable.append("<td>");
            htmlTable.append(description);
            htmlTable.append("</td>");

            htmlTable.append("<td>");
            htmlTable.append("$" + price);
            htmlTable.append("</td>");
            
            htmlTable.append("<td><a href = \"/ProductMaintenance/updateProduct?productCode=" + code +"\">Edit</a></td>");
            htmlTable.append("<td><a href = \"/ProductMaintenance/deleteProduct?productCode=" + code +"\">Delete</a></td>");
        htmlTable.append("</tr>");
        }
        
        htmlTable.append("</table>");
        return htmlTable.toString();
    }
}