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

/**
 * TestNopk generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`TEST_NOPK`")
public class TestNopk implements Serializable {

    private Integer id;
    private Integer col2;
    private Integer col3;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "\"TEST_NOPK_ID_seq\"" , schema = "public", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`COL2`", nullable = true, scale = 0, precision = 10)
    public Integer getCol2() {
        return this.col2;
    }

    public void setCol2(Integer col2) {
        this.col2 = col2;
    }

    @Column(name = "`COL3`", nullable = true, scale = 0, precision = 10)
    public Integer getCol3() {
        return this.col3;
    }

    public void setCol3(Integer col3) {
        this.col3 = col3;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestNopk)) return false;
        final TestNopk testNopk = (TestNopk) o;
        return Objects.equals(getId(), testNopk.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

