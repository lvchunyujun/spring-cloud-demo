package com.hexiaofei.springeurekaclient.dao.shardingImpl;

import com.alibaba.druid.pool.DataSourceDisableException;
import com.alibaba.druid.pool.DruidDataSource;
import com.dangdang.ddframe.rdb.sharding.api.ShardingDataSourceFactory;
import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.DatabaseShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;
import com.hexiaofei.springeurekaclient.dao.shardingImpl.common.ModuloDatabaseShardingAlgorithm;
import com.hexiaofei.springeurekaclient.dao.shardingImpl.common.ModuloTableShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/19.
 */
public class BaseDao {

    static ShardingRule shardingRule;

    static {
        initShardingConfig();
    }

    /**
     * 4: 获取 jdbc链接
     * @return
     * @throws SQLException
     */
    static Connection getConnection() throws SQLException {
        DataSource dataSource = ShardingDataSourceFactory.createDataSource(shardingRule);
        return dataSource.getConnection();
    }



    /**
     * 3: 初始化分片规则：表规则
     */
    static void initShardingConfig(){

        TableRule orderTableRule = TableRule.builder("t_order")
                .actualTables(Arrays.asList("t_order_0", "t_order_1"))
                .dataSourceRule(getDataSourceRule())
                .build();
        TableRule orderItemTableRule = TableRule.builder("t_order_item")
                .actualTables(Arrays.asList("t_order_item_0", "t_order_item_1"))
                .dataSourceRule(getDataSourceRule())
                .build();

        /**
         * DatabaseShardingStrategy 分库策略
         * 参数一：根据哪个字段分库
         * 参数二：分库路由函数
         * TableShardingStrategy 分表策略
         * 参数一：根据哪个字段分表
         * 参数二：分表路由函数
         *
         */
         shardingRule = ShardingRule.builder()
                .dataSourceRule(getDataSourceRule())
                .tableRules(Arrays.asList(orderTableRule,orderItemTableRule))
                .databaseShardingStrategy(new DatabaseShardingStrategy("user_id", new ModuloDatabaseShardingAlgorithm()))
                .tableShardingStrategy(new TableShardingStrategy("order_id", new ModuloTableShardingAlgorithm()))
        .build();
    }

    /**
     * 2:设置数据源规则
     * @return
     */
    public static DataSourceRule getDataSourceRule(){
        Map<String, DataSource> dataSourceMap = new HashMap<>(2);
        dataSourceMap.put("ds_0", createDataSource("ds_0"));
        dataSourceMap.put("ds_1", createDataSource("ds_1"));
        DataSourceRule dataSourceRule = new DataSourceRule(dataSourceMap);
        return dataSourceRule;
    }

    /**
     * 1: 创建获取数据源
     * @param dataSourceName 数据库名称
     * @return
     */
    private static DataSource createDataSource(final String dataSourceName) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl(String.format("jdbc:mysql://lcyj88:3306/%s?useUnicode=true&characterEncoding=utf-8&useSSL=false",dataSourceName));
        druidDataSource.setUsername("lcyj");
        druidDataSource.setPassword("000000");
        return druidDataSource;
    }
}
