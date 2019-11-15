package top.viewv.api;

public class UserAuth {
    public static String[] getUserAuth(String userId){
        /*
        1: 管理者
        0: 非管理者
        NU: 普通用户
        SU: 超级用户
        SA: 销售
        FM: 财务
        WS: 成品库
        MS: 原料库
        PL: 生产车间
        PM: 生产计划科目
            MG: 管理者
            WK: 员工
            LB: 接待员，搬运工，计划管理员
         */
        char [] user = userId.toCharArray();
        String[] type = new String[3];
        type[0] = "NU";
        type[1] = "NU";
        type[2] = "0";
        if (user[0] == '0' && user[1] == '0'){
            type[0] = "SU";
            type[1] = "SU";
            type[2] = "1";
            return type;
        } else if (user[0] == '1'){
            type[0] = "SA";
            if (user[1] == '1'){
                type[1] = "MG";
            }else if (user[1] == '2'){
                type[1] = "WK";
            }else if (user[1] == '3'){
                type[1] = "LB";
            }
            if (user[2] == '1'){
                type[2] = "1";
            }else {
                type[2] = "0";
            }
            return type;
        }else if (user[0] == '2'){
            type[0] = "FM";
            if (user[1] == '1'){
                type[1] = "MG";
            }else if (user[1] == '2') {
                type[1] = "WK";
            }
            if (user[2] == '1'){
                type[2] = "1";
            }else {
                type[2] = "0";
            }
            return type;
        }else if (user[0] == '3'){
            type[0] = "WS";
            if (user[1] == '1'){
                type[1] = "WK";
            }else if (user[1] == '2'){
                type[1] = "LB";
            }else if (user[1] == '3'){
                type[1] = "MG";
            }
            if (user[2] == '1'){
                type[2] = "1";
            }else {
                type[2] = "0";
            }
            return type;
        }else if (user[0] == '4'){
            type[0] = "MS";
            if (user[1] == '1'){
                type[1] = "WK";
            }else if (user[1] == '2'){
                type[1] = "LB";
            }else if (user[1] == '3'){
                type[1] = "MG";
            }
            if (user[2] == '1'){
                type[2] = "1";
            }else {
                type[2] = "0";
            }
            return type;
        }else if (user[0] == '5'){
            type[0] = "PL";
            if (user[1] == '1'){
                type[1] = "MG";
            }else if (user[1] == '2'){
                type[1] = "WK";
            }
            if (user[2] == '1'){
                type[2] = "1";
            }else {
                type[2] = "0";
            }
            return type;
        }else if (user[0] == '6'){
            type[0] = "PM";
            if (user[1] == '1'){
                type[1] = "MG";
            }else if (user[1] == '2'){
                type[1] = "WK";
            }else if (user[1] == '3'){
                type[1] = "LB";
            }
            if (user[2] == '1'){
                type[2] = "1";
            }else {
                type[2] = "0";
            }
            return type;
        }
        return type;
    }
}
