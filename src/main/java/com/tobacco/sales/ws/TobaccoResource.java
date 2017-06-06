package com.tobacco.sales.ws;

import com.tobacco.sales.dao.TobaccoDaoImpl;
import com.tobacco.sales.dto.TobaccoDTO;
import com.tobacco.sales.entity.Tobacco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

@Path("/tobacco")
@Consumes(value = "application/json")
@Produces(value = "application/json")
@Component
public class TobaccoResource {

    @Autowired
    private TobaccoDaoImpl tobaccoDao;

    @GET
    @Path("/")
    public List<TobaccoDTO> getList() {
        List<TobaccoDTO> list = new ArrayList<TobaccoDTO>();
        TobaccoDTO dto;
        for (Tobacco tobacco : tobaccoDao.getList()) {
            dto = new TobaccoDTO();
            dto.setId(tobacco.getId());
            dto.setName(tobacco.getName());
            dto.setMfrs(tobacco.getMfrs());
            dto.setSpec(tobacco.getSpec());
            dto.setPrice(tobacco.getPrice());
            dto.setDescription(tobacco.getDescription());
            dto.setUpdated(tobacco.getUpdated());
            list.add(dto);
        }
        return list;
    }

}
