package lxx.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lxx
 * @since 2024-05-02
 */
@Getter
@Setter
@Accessors(chain = true)
public class PostgresqlTest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;


}
