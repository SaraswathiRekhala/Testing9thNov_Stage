/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing9thnov_stage.viewsdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

public class SampleVirtualtableId implements Serializable {

    private String name;
    private Integer column;
    private String column4;
    private Integer id;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getColumn() {
        return this.column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public String getColumn4() {
        return this.column4;
    }

    public void setColumn4(String column4) {
        this.column4 = column4;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SampleVirtualtable)) return false;
        final SampleVirtualtable sampleVirtualtable = (SampleVirtualtable) o;
        return Objects.equals(getName(), sampleVirtualtable.getName()) &&
                Objects.equals(getColumn(), sampleVirtualtable.getColumn()) &&
                Objects.equals(getColumn4(), sampleVirtualtable.getColumn4()) &&
                Objects.equals(getId(), sampleVirtualtable.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(),
                getColumn(),
                getColumn4(),
                getId());
    }
}
