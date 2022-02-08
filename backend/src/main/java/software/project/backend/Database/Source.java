package software.project.backend.Database;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

public class Source {

    private static DataSource source = null;

    private Source(){}

    @Bean @Primary
    public static DataSource getDataSource(){
        if (source == null){
            source = DataSourceBuilder
                    .create()
                    .username("sql11471271")
                    .password("cTemhzD67v")
                    .url("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11471271")
                    .driverClassName("com.mysql.cj.jdbc.Driver")
                    .build();
        }
        return source;
    }
}
