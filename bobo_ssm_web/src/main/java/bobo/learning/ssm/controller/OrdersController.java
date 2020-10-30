package bobo.learning.ssm.controller;

import bobo.learning.ssm.domain.Orders;
import bobo.learning.ssm.service.IOrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/*
 * @author  bobo
 * @date  2020/10/29 14:16
 * @Email:1498244906@qq.com
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService iOrdersService;

   /* @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = iOrdersService.findAll();
        mv.addObject("ordersList",ordersList);
        mv.setViewName("orders-list");
        return  mv;
    }*/
   //查询
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = iOrdersService.findAll(page,size);
        //PageInfo就是一个分页Bean
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public  ModelAndView findById(@RequestParam(name = "id",required = true)  String ordersId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders  orders=iOrdersService.findById(ordersId);
        mv.setViewName("orders-show");
        mv.addObject("orders",orders);
        return  mv;

    }
}
