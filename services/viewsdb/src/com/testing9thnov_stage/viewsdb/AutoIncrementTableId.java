/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing9thnov_stage.viewsdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

public class AutoIncrementTableId implements Serializable {

    private Integer id;
    private String name;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AutoIncrementTable)) return false;
        final AutoIncrementTable autoIncrementTable = (AutoIncrementTable) o;
        return Objects.equals(getId(), autoIncrementTable.getId()) &&
                Objects.equals(getName(), autoIncrementTable.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getName());
    }
}
