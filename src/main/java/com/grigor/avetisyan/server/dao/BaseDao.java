package com.grigor.avetisyan.server.dao;

import com.grigor.avetisyan.server.entity.DeviceID;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Transactional
public class BaseDao {

    @PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager entityManager;

    public Response save(Object data) {
        try {
            entityManager.persist(data);
            entityManager.flush();
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            return Response.status(Response.Status.ACCEPTED).build();
        }
    }

    public Response checkId(Object data) {
        if (entityManager.find(DeviceID.class,((String)data).split("=")[1])==null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.status(Response.Status.FOUND).build();
    }

    public void update(Object data){
        try {
            entityManager.merge(data);
            entityManager.flush();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}

