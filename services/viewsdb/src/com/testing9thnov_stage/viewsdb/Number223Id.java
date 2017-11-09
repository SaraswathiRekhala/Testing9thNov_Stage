/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing9thnov_stage.viewsdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Number223Id implements Serializable {

    private Integer id;
    private Short integerCol;
    private Short shortCol;
    private Integer longCol;
    private Integer bigintegerCol;
    private BigDecimal byteCol;
    private Short floatCol;
    private BigDecimal doubleCol;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getIntegerCol() {
        return this.integerCol;
    }

    public void setIntegerCol(Short integerCol) {
        this.integerCol = integerCol;
    }

    public Short getShortCol() {
        return this.shortCol;
    }

    public void setShortCol(Short shortCol) {
        this.shortCol = shortCol;
    }

    public Integer getLongCol() {
        return this.longCol;
    }

    public void setLongCol(Integer longCol) {
        this.longCol = longCol;
    }

    public Integer getBigintegerCol() {
        return this.bigintegerCol;
    }

    public void setBigintegerCol(Integer bigintegerCol) {
        this.bigintegerCol = bigintegerCol;
    }

    public BigDecimal getByteCol() {
        return this.byteCol;
    }

    public void setByteCol(BigDecimal byteCol) {
        this.byteCol = byteCol;
    }

    public Short getFloatCol() {
        return this.floatCol;
    }

    public void setFloatCol(Short floatCol) {
        this.floatCol = floatCol;
    }

    public BigDecimal getDoubleCol() {
        return this.doubleCol;
    }

    public void setDoubleCol(BigDecimal doubleCol) {
        this.doubleCol = doubleCol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number223)) return false;
        final Number223 number223 = (Number223) o;
        return Objects.equals(getId(), number223.getId()) &&
                Objects.equals(getIntegerCol(), number223.getIntegerCol()) &&
                Objects.equals(getShortCol(), number223.getShortCol()) &&
                Objects.equals(getLongCol(), number223.getLongCol()) &&
                Objects.equals(getBigintegerCol(), number223.getBigintegerCol()) &&
                Objects.equals(getByteCol(), number223.getByteCol()) &&
                Objects.equals(getFloatCol(), number223.getFloatCol()) &&
                Objects.equals(getDoubleCol(), number223.getDoubleCol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getIntegerCol(),
                getShortCol(),
                getLongCol(),
                getBigintegerCol(),
                getByteCol(),
                getFloatCol(),
                getDoubleCol());
    }
}
