/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing9thnov_stage.viewsdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testing9thnov_stage.viewsdb.Table129;
import com.testing9thnov_stage.viewsdb.Table129Id;


/**
 * ServiceImpl object for domain model class Table129.
 *
 * @see Table129
 */
@Service("viewsdb.Table129Service")
@Validated
public class Table129ServiceImpl implements Table129Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table129ServiceImpl.class);


    @Autowired
    @Qualifier("viewsdb.Table129Dao")
    private WMGenericDao<Table129, Table129Id> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table129, Table129Id> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "viewsdbTransactionManager")
    @Override
	public Table129 create(Table129 table129) {
        LOGGER.debug("Creating a new Table129 with information: {}", table129);
        Table129 table129Created = this.wmGenericDao.create(table129);
        return table129Created;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Table129 getById(Table129Id table129Id) throws EntityNotFoundException {
        LOGGER.debug("Finding Table129 by id: {}", table129Id);
        Table129 table129 = this.wmGenericDao.findById(table129Id);
        if (table129 == null){
            LOGGER.debug("No Table129 found with id: {}", table129Id);
            throw new EntityNotFoundException(String.valueOf(table129Id));
        }
        return table129;
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Table129 findById(Table129Id table129Id) {
        LOGGER.debug("Finding Table129 by id: {}", table129Id);
        return this.wmGenericDao.findById(table129Id);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "viewsdbTransactionManager")
	@Override
	public Table129 update(Table129 table129) throws EntityNotFoundException {
        LOGGER.debug("Updating Table129 with information: {}", table129);
        this.wmGenericDao.update(table129);

        Table129Id table129Id = new Table129Id();
        table129Id.setColumn2(table129.getColumn2());
        table129Id.setColumn3(table129.getColumn3());

        return this.wmGenericDao.findById(table129Id);
    }

    @Transactional(value = "viewsdbTransactionManager")
	@Override
	public Table129 delete(Table129Id table129Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table129 with id: {}", table129Id);
        Table129 deleted = this.wmGenericDao.findById(table129Id);
        if (deleted == null) {
            LOGGER.debug("No Table129 found with id: {}", table129Id);
            throw new EntityNotFoundException(String.valueOf(table129Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Page<Table129> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table129s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Page<Table129> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table129s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service viewsdb for table Table129 to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}

