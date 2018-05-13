package com.grigor.avetisyan.server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Location implements Serializable {

    @Id
    private String id;

    String longitude;
    String latitude;

}
