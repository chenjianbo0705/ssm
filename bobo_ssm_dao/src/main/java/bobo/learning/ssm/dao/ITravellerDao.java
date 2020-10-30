package bobo.learning.ssm.dao;
/*
 * @author  bobo
 * @date  2020/10/29 15:58
 * @Email:1498244906@qq.com
 */

import bobo.learning.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {


    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    List<Traveller> findByOrdersID(String ordersID) throws  Exception;
}
