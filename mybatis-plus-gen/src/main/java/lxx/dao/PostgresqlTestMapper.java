package lxx.dao;

import lxx.entity.PostgresqlTest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lxx
 * @since 2024-05-02
 */
@Mapper
public interface PostgresqlTestMapper {

    int insert(PostgresqlTest entity);

    int deleteById(Integer id);

    int updateById(PostgresqlTest entity);

    PostgresqlTest selectById(Integer id);

    List<PostgresqlTest> selectByEntity(PostgresqlTest entity);

}
