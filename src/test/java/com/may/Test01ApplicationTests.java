package com.may;

import com.may.mapper.CompetenceMapper;
import com.may.mapper.EmployeeMapper;
import com.may.mapper.UserMapper;
import com.may.pojo.Competence;
import com.may.pojo.Employee;
import com.may.pojo.User;
import org.apache.commons.io.FilenameUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Test01ApplicationTests {
    @Test
    void contextLoads() {
    }

}
