package com.hexiaofei.springeurekaclient.dao.shardingImpl;

import com.alibaba.druid.pool.DruidDataSource;
import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.hexiaofei.springeurekaclient.dao.shardingImpl.common.ModuloDatabaseShardingAlgorithm;
import com.hexiaofei.springeurekaclient.dao.shardingImpl.common.ModuloTableShardingAlgorithm;
import io.shardingjdbc.core.api.ShardingDataSourceFactory;
import io.shardingjdbc.core.api.config.ShardingRuleConfiguration;
import io.shardingjdbc.core.api.config.TableRuleConfiguration;
import io.shardingjdbc.core.api.config.strategy.InlineShardingStrategyConfiguration;
import io.shardingjdbc.core.rule.ShardingRule;
import io.shardingjdbc.core.rule.TableRule;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/19.
 */
public class BaseDao {

    private final static String DB_DRIVER = "com.mysql.jdbc.Driver";
    private final static String DB_NAME = "lcyj";
    private final static String DB_PASSWORD = "000000";

    static ShardingRule shardingRule;
    static Map<String, DataSource> dataSourceMap;


    static {
        initShardingConfig();
        initShardingConfig2();
    }

    /**
     * 4: 获取 jdbc链接
     * @return
     * @throws SQLException
     */
    static Connection getConnection() throws SQLException, IOException {

        DataSource dataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap, new File(""));


//        DataSource dataSource = ShardingDataSourceFactory.createDataSource(shardingRule);
        return dataSource.getConnection();
    }



    /**
     * 3: 初始化分片规则：表规则
     */
    static void initShardingConfig(){

//        TableRule orderTableRule = TableRule.builder("t_order")
//                .actualTables(Arrays.asList("t_order_0", "t_order_1"))
//                .dataSourceRule(getDataSourceRule())
//                .build();
//        TableRule orderItemTableRule = TableRule.builder("t_order_item")
//                .actualTables(Arrays.asList("t_order_item_0", "t_order_item_1"))
//                .dataSourceRule(getDataSourceRule())
//                .build();

        /**
         * DatabaseShardingStrategy 分库策略
         * 参数一：根据哪个字段分库
         * 参数二：分库路由函数
         * TableShardingStrategy 分表策略
         * 参数一：根据哪个字段分表
         * 参数二：分表路由函数
         *
         */
//         shardingRule = ShardingRule.builder()
//                .dataSourceRule(getDataSourceRule())
//                .tableRules(Arrays.asList(orderTableRule,orderItemTableRule))
//                .databaseShardingStrategy(new DatabaseShardingStrategy("user_id", new ModuloDatabaseShardingAlgorithm()))
//                .tableShardingStrategy(new TableShardingStrategy("order_id", new ModuloTableShardingAlgorithm()))
//        .build();
    }

    static void initShardingConfig2(){
        TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration();
        orderTableRuleConfig.setLogicTable("t_order");
        orderTableRuleConfig.setActualDataNodes("ds_${0..1}.t_order_${[0, 1]}");

        orderTableRuleConfig.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("user_id", "ds_${user_id % 2}"));
        orderTableRuleConfig.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("order_id", "t_order_${order_id % 2}"));

        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig);
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
        dataSource2.setUrl("jdbc:mysql://localhost:3306/ds_1?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        dataSource2.setUsername(DB_NAME);
        dataSource2.setPassword(DB_PASSWORD);
        dataSourceMap.put("ds_1", dataSource2);
        return dataSourceMap;
    }
}
