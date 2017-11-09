/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing9thnov_stage.viewsdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

/**
 * Table44 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`TABLE44`")
public class Table44 implements Serializable {

    private Integer id;
    @Type(type = "DateTime")
    private LocalDateTime column2;
    private String column3;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "\"TABLE44_ID_seq\"" , schema = "public", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`COLUMN2`", nullable = true)
    public LocalDateTime getColumn2() {
        return this.column2;
    }

    public void setColumn2(LocalDateTime column2) {
        this.column2 = column2;
    }

    @Column(name = "`COLUMN3`", nullable = true, length = 255)
    public String getColumn3() {
        return this.column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table44)) return false;
        final Table44 table44 = (Table44) o;
        return Objects.equals(getId(), table44.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

