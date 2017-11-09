/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing9thnov_stage.salesdb.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class SvCustomersDataResponse implements Serializable {


    @ColumnAlias("ID")
    private BigInteger id;

    @ColumnAlias("NAME")
    private String name;

    @ColumnAlias("STATE_ID")
    private BigInteger stateId;

    public BigInteger getId() {
        return this.id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getStateId() {
        return this.stateId;
    }

    public void setStateId(BigInteger stateId) {
        this.stateId = stateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SvCustomersDataResponse)) return false;
        final SvCustomersDataResponse svCustomersDataResponse = (SvCustomersDataResponse) o;
        return Objects.equals(getId(), svCustomersDataResponse.getId()) &&
                Objects.equals(getName(), svCustomersDataResponse.getName()) &&
                Objects.equals(getStateId(), svCustomersDataResponse.getStateId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getName(),
                getStateId());
    }
}