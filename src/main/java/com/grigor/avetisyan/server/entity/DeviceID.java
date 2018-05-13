package com.grigor.avetisyan.server.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Data
public class DeviceID implements Serializable{
    @Id
    private String id;

//    @OneToMany(mappedBy = "id")
//    ArrayList<Location> locations = new ArrayList<>();
}
