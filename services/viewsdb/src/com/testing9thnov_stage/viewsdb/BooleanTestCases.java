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
 * BooleanTestCases generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`Boolean_TestCases`")
public class BooleanTestCases implements Serializable {

    private Integer booleanId;
    private String _1boolean;
    private String _0boolean;
    private String yboolean;
    private String nboolean;
    private Boolean tboolean;
    private Boolean fboolean;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "\"Boolean_TestCases_BooleanId_seq\"" , schema = "public", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "`BooleanId`", nullable = false, scale = 0, precision = 10)
    public Integer getBooleanId() {
        return this.booleanId;
    }

    public void setBooleanId(Integer booleanId) {
        this.booleanId = booleanId;
    }

    @Column(name = "`1_Boolean`", nullable = true, length = 1)
    public String get_1boolean() {
        return this._1boolean;
    }

    public void set_1boolean(String _1boolean) {
        this._1boolean = _1boolean;
    }

    @Column(name = "`0_Boolean`", nullable = true, length = 1)
    public String get_0boolean() {
        return this._0boolean;
    }

    public void set_0boolean(String _0boolean) {
        this._0boolean = _0boolean;
    }

    @Column(name = "`Y_Boolean`", nullable = true, length = 1)
    public String getYboolean() {
        return this.yboolean;
    }

    public void setYboolean(String yboolean) {
        this.yboolean = yboolean;
    }

    @Column(name = "`N_Boolean`", nullable = true, length = 1)
    public String getNboolean() {
        return this.nboolean;
    }

    public void setNboolean(String nboolean) {
        this.nboolean = nboolean;
    }

    @Column(name = "`T_Boolean`", nullable = true)
    public Boolean getTboolean() {
        return this.tboolean;
    }

    public void setTboolean(Boolean tboolean) {
        this.tboolean = tboolean;
    }

    @Column(name = "`F_Boolean`", nullable = true)
    public Boolean getFboolean() {
        return this.fboolean;
    }

    public void setFboolean(Boolean fboolean) {
        this.fboolean = fboolean;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BooleanTestCases)) return false;
        final BooleanTestCases booleanTestCases = (BooleanTestCases) o;
        return Objects.equals(getBooleanId(), booleanTestCases.getBooleanId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBooleanId());
    }
}

