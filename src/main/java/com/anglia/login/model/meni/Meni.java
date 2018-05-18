package com.anglia.login.model.meni;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "meni")
public class Meni implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int meni_id;
    private String ime;

}
