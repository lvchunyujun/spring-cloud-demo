package com.hexiaofei.springeurekaclient.dao.shardingImpl;

import com.hexiaofei.springeurekaclient.dao.IUserDao;
import com.hexiaofei.springeurekaclient.domain.User;
import groovy.lang.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/12/19.
 */
@Repository
@Scope("singleton")
public class UserDaoShardingImpl extends BaseDao implements IUserDao{

    private static Logger logger = LoggerFactory.getLogger(BaseDao.class);

    @Override
    public User selectUserById(int id) {
        String sql = "SELECT i.*,o.order_name FROM t_order o JOIN t_order_item i ON o.order_id=i.order_id    order by o.order_id  desc";
        try {
            Connection conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
//            preparedStatement.setInt(1, 1000);
//            preparedStatement.setInt(2, 10003);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while(rs.next()) {
                    System.out.println("sharding-jdbc  查询成功：[order_name="+rs.getString("order_name")+", item_id="+rs.getInt(1)+", order_id="+rs.getInt(2)+", user_id="+rs.getInt(3)+"]");
                }
            }catch (Exception e){
                logger.error("JDBC 异常！",e);
            }
        }catch (Exception e){
            logger.error("JDBC 异常！",e);
        }
        return null;
    }

    @Override
    public void inertObject() {
        Connection conn = null;
        try {
            String sql = " INSERT INTO t_order(order_id,user_id,order_name) VALUES(?,?,?) ";
            conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,10005);
            preparedStatement.setInt(2,13);
            preparedStatement.setString(3,"ds_1_2002");
            int resultId = preparedStatement.executeUpdate();
            System.out.println("sharding-jdbc  插入结果="+resultId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void inertObject(int user_id, int order_id) {
        Connection conn = null;
        try {
            String sql = " INSERT INTO t_order(order_id,user_id,order_name) VALUES(?,?,?) ";
            conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,order_id);
            preparedStatement.setInt(2,user_id);
            preparedStatement.setString(3,"ds_1_2002");
            int resultId = preparedStatement.executeUpdate();
            System.out.println("sharding-jdbc  插入结果="+resultId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
