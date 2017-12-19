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

/**
 * Created by Administrator on 2017/12/19.
 */
@Repository
@Scope("singleton")
public class UserDaoShardingImpl extends BaseDao implements IUserDao{

    private static Logger logger = LoggerFactory.getLogger(BaseDao.class);

    @Override
    public User selectUserById(int id) {
        String sql = "SELECT i.*,o.order_name FROM t_order o JOIN t_order_item i ON o.order_id=i.order_id  where o.order_id > ? and o.order_id < ? order by o.order_id desc limit 0,2 ";
        try {
            Connection conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, 1000);
            preparedStatement.setInt(2, 10003);
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

    }
}
