package com.outlook.sftjun.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

/**
 * Created by yinjun on 20/12/2017
 */
@Configuration
open class DataSourceConfig {

    @Bean
    open fun dataSource(): DataSource {
        val dataSource = DriverManagerDataSource()
        dataSource.apply {
            this.url = "jdbc:mysql://127.0.0.1:13306/practice?" +
                    "autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8&allowMultiQueries=true&useSSL=false"
            this.username = "root"
            this.setDriverClassName("com.mysql.jdbc.Driver")
            this.password = "root"
        }
        return dataSource
    }
}