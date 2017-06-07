package com.tobacco.sales.ws;

import com.tobacco.sales.dao.TobaccoDaoImpl;
import com.tobacco.sales.dto.TobaccoDTO;
import com.tobacco.sales.entity.Tobacco;
import com.tobacco.sales.entity.TobaccoQuantity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
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
    public List<TobaccoDTO> getList() {
        List<TobaccoDTO> list = new ArrayList<TobaccoDTO>();
        TobaccoDTO dto;
        TobaccoQuantity quantity;
        for (Tobacco tobacco : tobaccoDao.getList()) {
            dto = new TobaccoDTO();
            dto.setId(tobacco.getId());
            dto.setName(tobacco.getName());
            dto.setMfrs(tobacco.getMfrs());
            dto.setSpec(tobacco.getSpec());
            dto.setPrice(tobacco.getPrice());
            dto.setDescription(tobacco.getDescription());
            dto.setUpdated(tobacco.getUpdated());

            quantity = tobaccoDao.findByTobaccoId(tobacco.getId());
            dto.setQuantity(quantity.getQuantity());
            dto.setStatus(quantity.getStatus());

            list.add(dto);
        }
        return list;
    }

    @POST
    @Transactional
    public Response create(TobaccoDTO tobaccoDTO) {

        Assert.notNull(tobaccoDTO, "Data must be defined.");

        Tobacco tobacco = new Tobacco();
        tobacco.setId(tobaccoDTO.getId());
        tobacco.setName(tobaccoDTO.getName());
        tobacco.setMfrs(tobaccoDTO.getMfrs());
        tobacco.setSpec(tobaccoDTO.getSpec());
        tobacco.setPrice(tobaccoDTO.getPrice());
        tobacco.setDescription(tobaccoDTO.getDescription());

        TobaccoQuantity quantity = new TobaccoQuantity();
        quantity.setTobaccoId(tobacco.getId());
        quantity.setQuantity(tobaccoDTO.getQuantity());
        quantity.setStatus(tobaccoDTO.getStatus());

        tobaccoDao.create(tobacco);
        tobaccoDao.create(quantity);

        return Response.ok().build();

    }

    @PUT
    @Transactional
    public TobaccoDTO update(TobaccoDTO tobaccoDTO) {

        Assert.notNull(tobaccoDTO, "Data must be defined.");

        Tobacco tobacco = new Tobacco();
        tobacco.setId(tobaccoDTO.getId());
        tobacco.setName(tobaccoDTO.getName());
        tobacco.setMfrs(tobaccoDTO.getMfrs());
        tobacco.setSpec(tobaccoDTO.getSpec());
        tobacco.setPrice(tobaccoDTO.getPrice());
        tobacco.setDescription(tobaccoDTO.getDescription());

        TobaccoQuantity quantity = new TobaccoQuantity();
        quantity.setTobaccoId(tobacco.getId());
        quantity.setQuantity(tobaccoDTO.getQuantity());
        quantity.setStatus(tobaccoDTO.getStatus());

        Tobacco updated = tobaccoDao.update(tobacco);
        TobaccoQuantity quantityUpdated = tobaccoDao.update(quantity);

        TobaccoDTO dto = new TobaccoDTO();
        dto.setId(updated.getId());
        dto.setName(updated.getName());
        dto.setMfrs(updated.getMfrs());
        dto.setSpec(updated.getSpec());
        dto.setPrice(updated.getPrice());
        dto.setDescription(updated.getDescription());
        dto.setUpdated(updated.getUpdated());
        dto.setQuantity(quantityUpdated.getQuantity());
        dto.setStatus(quantityUpdated.getStatus());

        return dto;

    }

    @DELETE
    public Response delete(TobaccoDTO tobaccoDTO) {
        Assert.notNull(tobaccoDTO, "Data must be defined.");

        tobaccoDao.delete(tobaccoDTO.getId());
        tobaccoDao.deleteByTobaccoId(tobaccoDTO.getId());

        return Response.ok().build();
    }

}
