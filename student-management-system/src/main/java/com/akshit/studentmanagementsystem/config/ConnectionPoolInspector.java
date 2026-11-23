package com.akshit.studentmanagementsystem.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;


// HikariDatSource : is one of the Connection Pool Implementations that provides database connections
// It implements DataSource (JDBC interface that provides database connections from its connection pool )

@Component
public class ConnectionPoolInspector {

    private final DataSource dataSource;

    public ConnectionPoolInspector(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void inspectConnectionPool() {

        HikariDataSource hikariDataSource = (HikariDataSource) dataSource;

        System.out.println("================HIKARI POOL INFORMATION================");

        System.out.println("Pool Name : " + hikariDataSource.getPoolName());

        System.out.println("Maximum Pool Size : " + hikariDataSource.getMaximumPoolSize());

        System.out.println("Minimum Idle : " + hikariDataSource.getMinimumIdle());

        System.out.println("Connection Timeout : " + hikariDataSource.getConnectionTimeout());

        System.out.println("Active Connections : " + hikariDataSource.getHikariPoolMXBean().getActiveConnections());

        System.out.println("Idle Connections : " + hikariDataSource.getHikariPoolMXBean().getIdleConnections());

        System.out.println("Total Connections : " + hikariDataSource.getHikariPoolMXBean().getTotalConnections());

        System.out.println("Threads awaiting connection : " + hikariDataSource.getHikariPoolMXBean().getThreadsAwaitingConnection());


    }






    }

