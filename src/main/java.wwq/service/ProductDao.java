package service;

import dao.Basedao;
import entity.Category;
import entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao {
    public static int insert(Product p) {
        String sql = "insert into wwq_product values(null,?,?,?,?,?,?,?)";

        Object[] params =  {
                p.getProduct_name(),
                p.getProduct_description(),
                p.getProduct_price(),
                p.getProduct_stock(),
                p.getProduct_fid(),
                p.getProduct_cid(),
                p.getProduct_filename()
        };
        return Basedao.exectuIUD(sql,params);

    }

    public static ArrayList<Product> selectAll() {
        ArrayList<Product> list = new ArrayList<Product>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn= Basedao.getconn();

        PreparedStatement ps = null;

        try {

            String sql = "select * from wwq_product";
            ps = conn.prepareStatement(sql);


            rs = ps.executeQuery();
            while (rs.next()){
                Product product = new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_description"),
                        rs.getInt("product_price"),
                        rs.getInt("product_stock"),
                        rs.getInt("product_fid"),
                        rs.getInt("product_cid"),
                        rs.getString("product_filename")

                );


                list.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
        return list;


    }

    //删除
    public static int del(int product_id) {
        String sql = "delete from wwq_product where product_id=?";

        Object[] params = {product_id};

        return Basedao.exectuIUD(sql, params);
    }

    //查找一条
    public static Product selectById(int product_id) {
        Product product = null;
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn= Basedao.getconn();

        PreparedStatement ps = null;

        try {

            String sql = "select * from wwq_product  where product_id =? ";

            ps = conn.prepareStatement(sql);
            ps.setInt(1,product_id);

            rs = ps.executeQuery();
            while (rs.next()){
                product = new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_description"),
                        rs.getInt("product_price"),
                        rs.getInt("product_stock"),
                        rs.getInt("product_fid"),
                        rs.getInt("product_cid"),
                        rs.getString("product_filename")
                );


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
//        System.out.println("u:"+u);
        return product;
    }

    public static ArrayList<Product> selectAllByFid(int id) {
        ArrayList<Product> list = new ArrayList<Product>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn= Basedao.getconn();

        PreparedStatement ps = null;

        try {

            String sql = "select * from wwq_product  where product_fid =? ";

            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);

            rs = ps.executeQuery();
            while (rs.next()){
              Product  product = new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_description"),
                        rs.getInt("product_price"),
                        rs.getInt("product_stock"),
                        rs.getInt("product_fid"),
                        rs.getInt("product_cid"),
                        rs.getString("product_filename")
                );
                list.add(product);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
//        System.out.println("u:"+u);
        return list;
    }

    public static ArrayList<Product> selectAllByCid(int id) {
        ArrayList<Product> list = new ArrayList<Product>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn= Basedao.getconn();

        PreparedStatement ps = null;

        try {

            String sql = "select * from wwq_product  where product_cid =? ";

            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);

            rs = ps.executeQuery();
            while (rs.next()){
                Product  product = new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_description"),
                        rs.getInt("product_price"),
                        rs.getInt("product_stock"),
                        rs.getInt("product_fid"),
                        rs.getInt("product_cid"),
                        rs.getString("product_filename")
                );
                list.add(product);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
//        System.out.println("u:"+u);
        return list;
    }

    public static ArrayList<Product> selectAllById(ArrayList<Integer> ids) {
        ArrayList<Product> list = new ArrayList<Product>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn= Basedao.getconn();

        PreparedStatement ps = null;

        try {
            for (int i=0;i<ids.size();i++){
                String sql = "select * from wwq_product  where product_id =? ";

                ps = conn.prepareStatement(sql);
                ps.setInt(1,ids.get(i));

                rs = ps.executeQuery();
                while (rs.next()){
                    Product  product = new Product(
                            rs.getInt("product_id"),
                            rs.getString("product_name"),
                            rs.getString("product_description"),
                            rs.getInt("product_price"),
                            rs.getInt("product_stock"),
                            rs.getInt("product_fid"),
                            rs.getInt("product_cid"),
                            rs.getString("product_filename")
                    );
                    list.add(product);

                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
//        System.out.println("u:"+u);
        return list;
    }
}
