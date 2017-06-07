package com.tobacco.sales.ws;

import com.tobacco.sales.dao.OrderDaoImpl;
import com.tobacco.sales.dto.OrderDTO;
import com.tobacco.sales.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/order")
@Consumes(value = "application/json")
@Produces(value = "application/json")
@Component
public class OrderResource {

    @Autowired
    private OrderDaoImpl orderDao;

    @GET
    public List<OrderDTO> list(@QueryParam("status") Integer status) {
        List<OrderDTO> dtos = new ArrayList<OrderDTO>();
        OrderDTO dto;
        if (status == null) {
            for (Order order : orderDao.list()) {
                dto = new OrderDTO();
                dto.setId(order.getId());
                dto.setUsername(order.getUsername());
                dto.setTobaccoId(order.getTobaccoId());
                dto.setQuantity(order.getQuantity());
                dto.setMoney(order.getMoney());
                dto.setStatus(order.getStatus());
                dto.setUpdated(order.getUpdated());
                dtos.add(dto);
            }
        } else {
            for (Order order : orderDao.findByStatus(status)) {
                dto = new OrderDTO();
                dto.setId(order.getId());
                dto.setUsername(order.getUsername());
                dto.setTobaccoId(order.getTobaccoId());
                dto.setQuantity(order.getQuantity());
                dto.setMoney(order.getMoney());
                dto.setStatus(order.getStatus());
                dto.setUpdated(order.getUpdated());
                dtos.add(dto);
            }
        }

        return dtos;

    }

    @POST
    @Transactional
    public Response create(OrderDTO dto) {
        Assert.notNull(dto, "Data must be defined");

        Order order = new Order();
        order.setId(dto.getId());
        order.setUsername(dto.getUsername());
        order.setTobaccoId(dto.getTobaccoId());
        order.setQuantity(dto.getQuantity());
        order.setMoney(dto.getMoney());
        order.setStatus(dto.getStatus());
        order.setUpdated(dto.getUpdated());

        orderDao.create(order);

        return Response.ok().build();
    }

    @PUT
    @Transactional
    public Response updateStatus(OrderDTO dto) {
        Assert.notNull(dto, "Data must be defined");
        orderDao.updateStatus(dto.getId(), dto.getStatus());

        return Response.ok().build();
    }

}
