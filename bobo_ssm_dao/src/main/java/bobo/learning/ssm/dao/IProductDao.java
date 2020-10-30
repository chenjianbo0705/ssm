package bobo.learning.ssm.dao;
/*
 * @author  bobo
 * @date  2020/10/29 10:20
 * @Email:1498244906@qq.com
 */

import bobo.learning.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface IProductDao {
    @Select("select * from product")
    List<Product> findAll() throws  Exception;

    //根据id查询产品
    @Select("select * from product where id=#{id}")
    public Product findById(String id) throws Exception;

    //添加产品
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);
}
