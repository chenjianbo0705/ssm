package bobo.learning.ssm.dao;
/*
 * @author  bobo
 * @date  2020/10/29 15:55
 * @Email:1498244906@qq.com
 */

import bobo.learning.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {


    @Select("select * from member where id = #{id}")
    Member findById(String id) throws  Exception;
}
