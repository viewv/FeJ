package top.viewv.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SqlTable extends TableView {
    public SqlTable(){

    }

    public SqlTable(String TableName){
        try{
            Connect connect = new Connect();
            Connection conn = connect.getConnection();
            String GetColumnNameSql = "select COLUMN_NAME from information_schema.COLUMNS where table_name = '" + TableName + "'";
            String[] ColumnName = new String[15];
            PreparedStatement ColumnStatment = conn.prepareStatement(GetColumnNameSql);
            ResultSet rs = ColumnStatment.executeQuery();
            int cnt = 0;
            while(rs.next()){
                ColumnName[cnt] = rs.getString("COLUMN_NAME");
                System.out.println(ColumnName[cnt]);
                cnt++;
            }

            TableColumn[] TableColumns = new TableColumn[cnt];
            String TableValue[] = new String[cnt];
            String GetTableValueSql = "select * from " + TableName;
            for (int i = 0; i < ColumnName.length; ++i){
                TableColumns[i] = new TableColumn(ColumnName[i]);
                this.getColumns().add(TableColumns[i]);
            }


        }

        catch(SQLException se){
            se.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

}
