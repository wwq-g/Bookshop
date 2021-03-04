package service;

import dao.Basedao;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {
    /**
     * 加入数据库
     * @param u
     * @return
     */
    public static int insert(User u){
        String sql = "insert into wwq_user values(?,?,?,?,?,DATE_FORMAT(?,'%Y-%m-%d'),?,?,?,?)";

        Object[] params = {
                u.getUsername(),
                u.getNickname(),
                u.getPassword(),
                u.getSex(),
                u.getMobile(),
                u.getBirthday(),
                u.getAddress(),
                u.getCode(),
                u.getEmail(),
                u.getStatus()

        };

        return Basedao.exectuIUD(sql,params);
    }

    public static int[] totalPage(int count,String keyword){
        int arr[] ={0,1};

        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            if ( keyword != null){
                String sql = "select count(*) from wwq_user where nickname like ?";
                ps=conn.prepareStatement(sql);
                ps.setString(1,"%"+keyword+"%");

            }else {
                String sql = "select count(*) from wwq_user";
                ps=conn.prepareStatement(sql);
            }

            rs = ps.executeQuery();

            while (rs.next()){
                arr[0] = rs.getInt(1); //总记录数

                if (arr[0]%count ==0){
                    arr[1] = arr[0]/count;  //页数
                }else {
                    arr[1] = arr[0]/count+1;
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }


        return arr;
    }


    public static ArrayList<User> selectAll(int cpage,int count,String keyword) {
        ArrayList<User> list = new ArrayList<User>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn= Basedao.getconn();

        PreparedStatement ps = null;

        try {
            if(keyword != null){
                String sql = "select * from wwq_user where nickname like ? order by birthday desc limit ?,?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,"%"+keyword+"%");
                ps.setInt(2,(cpage-1)*count);
                ps.setInt(3,count);
            }else {
                String sql = "select * from wwq_user order by birthday desc limit ?,?";
                ps = conn.prepareStatement(sql);

                ps.setInt(1, (cpage-1)*count);
                ps.setInt(2, count);
            }



            rs = ps.executeQuery();
            while (rs.next()){
                User u = new User(
                        rs.getString("username"),
                        rs.getString("nickname"),
                        rs.getString("password"),
                        rs.getString("sex"),
                        rs.getString("mobile"),
                        rs.getString("birthday"),
                        rs.getString("address"),
                        rs.getString("code"),
                        rs.getString("email"),
                        rs.getInt("status")

                );


                list.add(u);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
        return list;
    }



    public static User selectById(String username) {
        User u = null;
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn= Basedao.getconn();

        PreparedStatement ps = null;

        try {

           String sql = "select m.*,DATE_FORMAT(m.birthday,'%Y-%m-%d')birthday from wwq_user m where username =? ";

           ps = conn.prepareStatement(sql);
           ps.setString(1,username);

            rs = ps.executeQuery();
            while (rs.next()){
                u = new User(
                        rs.getString("username"),
                        rs.getString("nickname"),
                        rs.getString("password"),
                        rs.getString("sex"),
                        rs.getString("mobile"),
                        rs.getString("birthday"),
                        rs.getString("address"),
                        rs.getString("code"),
                        rs.getString("email"),
                        rs.getInt("status")

                );


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
//        System.out.println("u:"+u);
        return u;
    }

    public static int update(User u) {
        String sql = "update  wwq_user set nickname=?,password=?,sex=?,mobile=?,birthday=DATE_FORMAT(?,'%Y-%m-%d'),address=?,code=?,email=?,status=? where username=?";

        Object[] params = {
                u.getNickname(),
                u.getPassword(),
                u.getSex(),
                u.getMobile(),
                u.getBirthday(),
                u.getAddress(),
                u.getCode(),
                u.getEmail(),
                u.getStatus(),
                u.getUsername()
        };

        return Basedao.exectuIUD(sql,params);
    }

    //删除
    public static int del(String username) {

        String sql = "delete from wwq_user where username=? and status!=2";

        Object[] params = {username};

        return Basedao.exectuIUD(sql, params);

    }


    public static int selectByName(String username) {
        int count = 0;
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "select count(*) from wwq_user where username=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            rs = ps.executeQuery();
            while (rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }

        return count;
    }

    //判断用户密码是否正确
    public static int selectByNM(String username, String password) {
        int count = 0;
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "select count(*) from wwq_user where username=? and password=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            while (rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }

        return count;
    }

    //登录获取用户信息
    public static User selectAdmin(String username, String password) {
        User u = null;
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn= Basedao.getconn();

        PreparedStatement ps = null;

        try {

            String sql = "select m.*,DATE_FORMAT(m.birthday,'%Y-%m-%d')birthday from wwq_user m where username =? and password=? ";

            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);

            rs = ps.executeQuery();
            while (rs.next()){
                u = new User(
                        rs.getString("username"),
                        rs.getString("nickname"),
                        rs.getString("password"),
                        rs.getString("sex"),
                        rs.getString("mobile"),
                        rs.getString("birthday"),
                        rs.getString("address"),
                        rs.getString("code"),
                        rs.getString("email"),
                        rs.getInt("status")

                );


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Basedao.closeall(rs,ps,conn);
        }
//        System.out.println("u:"+u);
        return u;
    }


    public static int ChangePass(String username, String newpass) {
        String sql = "update wwq_user set password=? where username=?;";

        Object[] params = {newpass, username};

        return Basedao.exectuIUD(sql, params);

    }
}
