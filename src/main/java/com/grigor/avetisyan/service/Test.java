package com.grigor.avetisyan.service;


import com.grigor.avetisyan.server.dao.BaseDao;
import com.grigor.avetisyan.server.entity.DeviceID;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/test")
@RequestScoped
public class Test {

    @Inject
    private BaseDao baseDao;

    private DeviceID deviceID = new DeviceID();

    @POST
    @Path("get")
    public Response get(String a) {
        deviceID.setId(a.split("=")[1]);
        return baseDao.save(deviceID);
    }

    @POST
    @Path("check")
    public Response checkId(String id) {
        deviceID.setId(id.split("=")[1]);
        return baseDao.checkId(id);
    }

    @POST
    @Path("location")
    public void saveLocations(String location){


        System.out.println(location);
    }

}
