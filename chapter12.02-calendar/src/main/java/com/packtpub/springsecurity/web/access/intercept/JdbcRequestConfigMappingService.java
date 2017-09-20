package com.packtpub.springsecurity.web.access.intercept;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.AntPathRequestMatcher;
import org.springframework.stereotype.Repository;

@Repository("requestConfigMappingService")
public class JdbcRequestConfigMappingService implements RequestConfigMappingService {

    private static final String SELECT_SQL = "select ant_pattern, expression from security_filtermetadata order by sort_order";
    private final JdbcOperations jdbcOperations;

    @Autowired
    public JdbcRequestConfigMappingService(JdbcOperations jdbcOperations) {
        if (jdbcOperations == null) {
            throw new IllegalArgumentException("jdbcOperations cannot be null");
        }
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public List<RequestConfigMapping> getRequestConfigMappings() {
        return jdbcOperations.query(SELECT_SQL, new RequestConfigMappingMapper());
    }

    private static final class RequestConfigMappingMapper implements RowMapper<RequestConfigMapping> {
        @Override
        public RequestConfigMapping mapRow(ResultSet rs, int rowNum) throws SQLException {
            String pattern = rs.getString("ant_pattern");
            String expressionString = rs.getString("expression");
            AntPathRequestMatcher matcher = new AntPathRequestMatcher(pattern);
            return new RequestConfigMapping(matcher, new SecurityConfig(expressionString));
        }
    }
}
