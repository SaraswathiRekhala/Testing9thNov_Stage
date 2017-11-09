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
 * ClobTable generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`CLOB_TABLE`")
public class ClobTable implements Serializable {

    private Integer id;
    private String clobCol;
    private String stringCol;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "\"CLOB_TABLE_ID_seq\"" , schema = "public", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`CLOB_COL`", nullable = true, length = 2550)
    public String getClobCol() {
        return this.clobCol;
    }

    public void setClobCol(String clobCol) {
        this.clobCol = clobCol;
    }

    @Column(name = "`STRING_COL`", nullable = true, length = 255)
    public String getStringCol() {
        return this.stringCol;
    }

    public void setStringCol(String stringCol) {
        this.stringCol = stringCol;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClobTable)) return false;
        final ClobTable clobTable = (ClobTable) o;
        return Objects.equals(getId(), clobTable.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
