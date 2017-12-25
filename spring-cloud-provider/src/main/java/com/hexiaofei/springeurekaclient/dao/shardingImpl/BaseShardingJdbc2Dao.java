package com.hexiaofei.springeurekaclient.dao.shardingImpl;

import com.alibaba.druid.pool.DruidDataSource;
import io.shardingjdbc.core.api.ShardingDataSourceFactory;
import io.shardingjdbc.core.api.config.ShardingRuleConfiguration;
import io.shardingjdbc.core.api.config.TableRuleConfiguration;
import io.shardingjdbc.core.api.config.strategy.InlineShardingStrategyConfiguration;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/19.
 */
public class BaseShardingJdbc2Dao {

    private final static String DB_DRIVER = "com.mysql.jdbc.Driver";
    private final static String DB_NAME = "root";
    private final static String DB_PASSWORD = "";
    private final static String SHARDING_CONFIG_URL = "classpath:";

    static Map<String, DataSource> dataSourceMap;
    static ShardingRuleConfiguration shardingRuleConfig;

    static {
        initShardingConfig2();
    }

    /**
     * 4: 获取 jdbc链接
     * @return
     * @throws SQLException
     */
    static Connection getConnection() throws SQLException, IOException {
        DataSource dataSource = ShardingDataSourceFactory.createDataSource(new File("class"));
        return dataSource.getConnection();
    }

    static void initShardingConfig2(){
        TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration();
        orderTableRuleConfig.setLogicTable("t_order");
        orderTableRuleConfig.setActualDataNodes("ds_${0..1}.t_order_${[0, 1]}");

        orderTableRuleConfig.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("user_id", "ds_${user_id % 2}"));
        orderTableRuleConfig.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("order_id", "t_order_${order_id % 2}"));


        shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig);

    }

    /**
     * 1: 创建获取数据源
     * @param dataSourceName 数据库名称
     * @return
     */
    private static DataSource createDataSource(final String dataSourceName) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(DB_DRIVER);
        druidDataSource.setUrl(String.format("jdbc:mysql://lcyj88:3306/%s?useUnicode=true&characterEncoding=utf-8&useSSL=false",dataSourceName));
        druidDataSource.setUsername(DB_NAME);
        druidDataSource.setPassword(DB_PASSWORD);
        return druidDataSource;
    }

    private static Map<String, DataSource> createDataSource2(){
        Map<String, DataSource> dataSourceMap = new HashMap<>();

        DruidDataSource dataSource1 = new DruidDataSource();
        dataSource1.setDriverClassName(DB_DRIVER);
        dataSource1.setUrl("jdbc:mysql://lcyj88:3306/ds_0?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        dataSource1.setUsername(DB_NAME);
        dataSource1.setPassword(DB_PASSWORD);
        dataSourceMap.put("ds_0", dataSource1);

        DruidDataSource dataSource2 = new DruidDataSource();
        dataSource2.setDriverClassName(DB_DRIVER);
        dataSource2.setUrl("jdbc:mysql://lcyj88:3306/ds_1?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        dataSource2.setUsername(DB_NAME);
        dataSource2.setPassword(DB_PASSWORD);
        dataSourceMap.put("ds_1", dataSource2);
        return dataSourceMap;
    }
}
