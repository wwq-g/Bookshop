package test;/**
 * @author shkstart
 * @create 2021-01-08 23:58
 */

import dao.Basedao;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @program: wwqShop
 *
 * @description:测试
 *
 * @author: wwq
 *
 * @create: 2021-01-08 23:58
 **/
public class Sqltest {
    public static void main(String[] args) {
        Connection conn = null;

            conn = Basedao.getconn();
            System.out.println(conn);


    }

}
