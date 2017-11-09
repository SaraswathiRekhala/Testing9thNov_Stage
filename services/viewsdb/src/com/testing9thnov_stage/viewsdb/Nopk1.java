/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing9thnov_stage.viewsdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Nopk1 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`NOPK1`")
@IdClass(Nopk1Id.class)
public class Nopk1 implements Serializable {

    private Integer column1;
    private Integer column2;

    @Id
    @Column(name = "`COLUMN1`", nullable = false, scale = 0, precision = 10)
    public Integer getColumn1() {
        return this.column1;
    }

    public void setColumn1(Integer column1) {
        this.column1 = column1;
    }

    @Id
    @Column(name = "`COLUMN2`", nullable = true, scale = 0, precision = 10)
    public Integer getColumn2() {
        return this.column2;
    }

    public void setColumn2(Integer column2) {
        this.column2 = column2;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nopk1)) return false;
        final Nopk1 nopk1 = (Nopk1) o;
        return Objects.equals(getColumn1(), nopk1.getColumn1()) &&
                Objects.equals(getColumn2(), nopk1.getColumn2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColumn1(),
                getColumn2());
    }
}

