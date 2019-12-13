package top.viewv.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class message {
    public int type; //1.客户 2.员工
    public String account_id;
    public String myid; //不可更改
    public String email;//也是头像
    public Date date;
    public int credit;

    public message(Connection conn,String account_id){
        try{
            this.account_id = account_id;
            String sql = "select count(*) from `full staff` where account_id = "
                    + account_id;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            int temp = rs.getInt(1);
            if(temp > 0){
                this.type = 2;
                sql = "select staff_id,icon,entry_date from `full staff` where account_id = "
                        +account_id;
                st = conn.prepareStatement(sql);
                rs = st.executeQuery(sql);
                rs.next();
                this.myid = rs.getString(1);
                this.email = rs.getString(2);
                this.date = rs.getDate(3);
                this.credit = -1;
            }
            else{
                this.type = 1;
                sql = "select client_id,icon,`time`,credit from `full client` where account_id = "
                        +account_id;
                st = conn.prepareStatement(sql);
                rs = st.executeQuery(sql);
                rs.next();
                this.myid = rs.getString(1);
                this.email = rs.getString(2);
                this.date = rs.getDate(3);
                this.credit = rs.getInt(4);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static int UpdateAccountID(Connection conn,message me,String nid){
        try{
            if (me.type == 1){
                String sql = "select count(*) from `full client` where account_id = \""
                        + nid +"\"";
                PreparedStatement st = conn.prepareStatement(sql);
                ResultSet rs = st.executeQuery(sql);
                rs.next();
                int temp = rs.getInt(1);
                if(temp > 0){
                    return 1;
                }else{
                    sql = "update client set account_id = \"" + nid + "\"" +
                    " where client_id = " + me.myid;
                    st.execute(sql);
                    sql = "update account set account_id = \"" + nid + "\"" +
                    " where account_id = " + me.account_id;
                    st.execute(sql);
                    me.account_id = nid;
                    return 2;
                }
            }else{
                String sql = "select count(*) from `full staff` where account_id = \""
                        + nid +"\"";
                PreparedStatement st = conn.prepareStatement(sql);
                ResultSet rs = st.executeQuery(sql);
                rs.next();
                int temp = rs.getInt(1);
                if(temp > 0){
                    return 1;
                }else{
                    sql = "update staff set account_id = \"" + nid + "\"" +
                            " where client_id = " + me.myid;
                    st.execute(sql);
                    sql = "update account set account_id = \"" + nid + "\"" +
                            " where account_id = " + me.account_id;
                    st.execute(sql);
                    me.account_id = nid;
                    return 2;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    //1.账号存在 2.成功

    public static int UpdatePassword(Connection conn,message me,String np,String rnp){
        try{
            if(np != rnp){
                return 1;
            }
            else{
                String sql = "update account set `password` = \"" + np + "\""
                        +" where account_id = \"" + me.account_id + "\"";
                PreparedStatement st = conn.prepareStatement(sql);
                st.execute(sql);
                return 2;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    //1.两次密码不匹配 2.成功

    public static void UpdateEmail(Connection conn,message me,String nemail){
        try{
            String sql = "update account set icon = \"" + nemail + "\""
                    +" where account_id = \"" + me.account_id + "\"";
            PreparedStatement st = conn.prepareStatement(sql);
            st.execute(sql);
            me.email = nemail;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
