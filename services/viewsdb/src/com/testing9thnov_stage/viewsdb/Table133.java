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
 * Table133 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`TABLE133`")
public class Table133 implements Serializable {

    private Short idColumn;
    private String column2;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "\"TABLE133_ID_seq\"" , schema = "public", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "`IdColumn`", nullable = false, scale = 0, precision = 5)
    public Short getIdColumn() {
        return this.idColumn;
    }

    public void setIdColumn(Short idColumn) {
        this.idColumn = idColumn;
    }

    @Column(name = "`COLUMN2`", nullable = true, length = 255)
    public String getColumn2() {
        return this.column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table133)) return false;
        final Table133 table133 = (Table133) o;
        return Objects.equals(getIdColumn(), table133.getIdColumn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdColumn());
    }
}
