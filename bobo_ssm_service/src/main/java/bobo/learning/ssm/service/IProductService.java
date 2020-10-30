package bobo.learning.ssm.service;
/*
 * @author  bobo
 * @date  2020/10/29 10:22
 * @Email:1498244906@qq.com
 */

import bobo.learning.ssm.domain.Product;

import java.util.List;

public interface IProductService {

    public List<Product> findAll() throws  Exception;

    void save(Product product)throws Exception;
}
