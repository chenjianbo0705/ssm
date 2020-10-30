package bobo.learning.ssm.dao;
/*
 * @author  bobo
 * @date  2020/10/29 14:18
 * @Email:1498244906@qq.com
 */

import bobo.learning.ssm.domain.Member;
import bobo.learning.ssm.domain.Orders;
import bobo.learning.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOdersDao {

    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "bobo.learning.ssm.dao.IProductDao.findById")),
    })
    List<Orders> findAll() throws  Exception;



    //多表操作
    @Select("select * from orders where id=#{ordersId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "bobo.learning.ssm.dao.IProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "bobo.learning.ssm.dao.IMemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType =java.util.List.class,many = @Many(select ="bobo.learning.ssm.dao.ITravellerDao.findByOrdersID"))
    })
    Orders findById(String ordersId)throws  Exception;
}
