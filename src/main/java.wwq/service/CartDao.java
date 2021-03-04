package service;

import dao.Basedao;
import entity.Cart;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CartDao {
    public static int insert(Cart cart) {
        String sql = "insert into wwq_cart values(null,?,?,?,?,?,?,?,1)";

        Object[] params = {
                cart.getCart_p_filename(),
                cart.getCart_p_name(),
                cart.getCart_p_price(),
                cart.getCart_p_quantity(),
                cart.getCart_p_stock(),
                cart.getCart_p_id(),
                cart.getCart_u_id(),


        };

        return Basedao.exectuIUD(sql,params);
    }

    public static ArrayList<Cart> getCart(String uid) {
        ArrayList<Cart> list = new ArrayList<Cart>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn= Basedao.getconn();

        PreparedStatement ps = null;

        try {

                String sql = "select * from wwq_cart where cart_u_id=? and cart_valid=1 order by cart_id desc";
                ps = conn.prepareStatement(sql);
                ps.setString(1,uid);

            rs = ps.executeQuery();
            while (rs.next()){
                Cart cart = new Cart(
                        rs.getInt("cart_id"),
                        rs.getString("cart_p_filename"),
                        rs.getString("cart_p_name"),
                        rs.getInt("cart_p_price"),
                        rs.getInt("cart_p_quantity"),
                        rs.getInt("cart_p_stock"),
                        rs.getInt("cart_p_id"),
                        rs.getString("cart_u_id"),
                        rs.getInt("cart_valid")
                );


                list.add(cart);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
        return list;
    }

    public static Cart getCartShop(String uid, String pid) {
        Cart es =null;
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();

        PreparedStatement ps = null;



        try {
            String sql = "select * from wwq_cart where cart_u_id=? and cart_p_id=? and cart_valid=1 order by cart_id desc";
            ps = conn.prepareStatement(sql);
            ps.setString(1, uid);
            ps.setInt(2, Integer.parseInt(pid));
            rs = ps.executeQuery();

            while(rs.next()) {
                es = new Cart(
                        rs.getInt("cart_id"),
                        rs.getString("cart_p_filename"),
                        rs.getString("cart_p_name"),
                        rs.getInt("cart_p_price"),
                        rs.getInt("cart_p_quantity"),
                        rs.getInt("cart_p_stock"),
                        rs.getInt("cart_p_id"),
                        rs.getString("cart_u_id"),
                        rs.getInt("cart_valid")
                );






            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }



        return es;
    }

    public static int updatenum(int cart_id, int newcount) {
        String sql = "update wwq_cart set cart_p_quantity=? where cart_id=? ";

        Object[] params = {newcount, cart_id};

        return Basedao.exectuIUD(sql, params);
    }

    public static int getDeleteDD(int parseInt) {
        String sql="delete from wwq_cart where cart_id=?";

        Object[] params={parseInt};

        return Basedao.exectuIUD(sql, params);
    }

    public static Cart getCartShop(String id) {
        Cart es =null;
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();

        PreparedStatement ps = null;



        try {
            String sql = "select * from wwq_cart where cart_id=? and cart_valid=1 order by cart_id desc";
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            rs = ps.executeQuery();

            while(rs.next()) {
                es = new Cart(
                        rs.getInt("cart_id"),
                        rs.getString("cart_p_filename"),
                        rs.getString("cart_p_name"),
                        rs.getInt("cart_p_price"),
                        rs.getInt("cart_p_quantity"),
                        rs.getInt("cart_p_stock"),
                        rs.getInt("cart_p_id"),
                        rs.getString("cart_u_id"),
                        rs.getInt("cart_valid")
                );






            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }



        return es;
    }
}
