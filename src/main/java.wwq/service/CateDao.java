package service;

import dao.Basedao;
import entity.Category;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CateDao {
    public static ArrayList<Category> selectAll() {
        ArrayList<Category> list = new ArrayList<Category>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn= Basedao.getconn();

        PreparedStatement ps = null;

        try {

                String sql = "select * from wwq_category";
                ps = conn.prepareStatement(sql);


            rs = ps.executeQuery();
            while (rs.next()){
                Category category = new Category(
                        rs.getInt("cate_id"),
                        rs.getString("cate_name"),
                        rs.getInt("cate_parent_id")
                );


                list.add(category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
        return list;
    }



    public static int insert(Category category){
        String sql = "insert into wwq_category values(null,?,?)";

        Object[] params = {
                category.getCate_name(),
                category.getCate_parent_id()
        };

        return Basedao.exectuIUD(sql,params);
    }

    public static Category selectById(int id) {
        Category category = null;
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn= Basedao.getconn();

        PreparedStatement ps = null;

        try {

            String sql = "select * from wwq_category  where cate_id =? ";

            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);

            rs = ps.executeQuery();
            while (rs.next()){
                category = new Category(
                        rs.getInt("cate_id"),
                        rs.getString("cate_name"),
                        rs.getInt("cate_parent_id")
                );


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
//        System.out.println("u:"+u);
        return category;
    }

    public static int update(Category category) {
        String sql = "update wwq_category set cate_name=?,cate_parent_id=? where cate_id=?";

        Object[] params = {
                category.getCate_name(),
                category.getCate_parent_id(),
                category.getCate_id()
        };

        return Basedao.exectuIUD(sql,params);
    }

    public static int del(int cate_id) {
        String sql = "delete from wwq_category where cate_id=?";

        Object[] params = {cate_id};

        return Basedao.exectuIUD(sql, params);
    }

    public static ArrayList<Category> selectCat(String flag) {
        ArrayList<Category> list = new ArrayList<Category>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn= Basedao.getconn();

        PreparedStatement ps = null;

        try {
            String sql = null;

            if (flag!=null && flag.equals("father")){
                sql = "select  * from wwq_category where cate_parent_id=0";
            }else {
                sql = "select  * from wwq_category where cate_parent_id!=0";
            }
            ps = conn.prepareStatement(sql);


            rs = ps.executeQuery();
            while (rs.next()){
                Category category = new Category(
                        rs.getInt("cate_id"),
                        rs.getString("cate_name"),
                        rs.getInt("cate_parent_id")
                );


                list.add(category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
        return list;
    }
}
