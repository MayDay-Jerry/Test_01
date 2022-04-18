package com.may.mapper;

import com.may.pojo.Competence;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface CompetenceMapper {
    List<Competence> queryAll();
    Competence query(int id);
}
