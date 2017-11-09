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

import com.testing9thnov_stage.viewsdb.Table64;


/**
 * ServiceImpl object for domain model class Table64.
 *
 * @see Table64
 */
@Service("viewsdb.Table64Service")
@Validated
public class Table64ServiceImpl implements Table64Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table64ServiceImpl.class);


    @Autowired
    @Qualifier("viewsdb.Table64Dao")
    private WMGenericDao<Table64, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table64, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "viewsdbTransactionManager")
    @Override
	public Table64 create(Table64 table64) {
        LOGGER.debug("Creating a new Table64 with information: {}", table64);
        Table64 table64Created = this.wmGenericDao.create(table64);
        return table64Created;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Table64 getById(Integer table64Id) throws EntityNotFoundException {
        LOGGER.debug("Finding Table64 by id: {}", table64Id);
        Table64 table64 = this.wmGenericDao.findById(table64Id);
        if (table64 == null){
            LOGGER.debug("No Table64 found with id: {}", table64Id);
            throw new EntityNotFoundException(String.valueOf(table64Id));
        }
        return table64;
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Table64 findById(Integer table64Id) {
        LOGGER.debug("Finding Table64 by id: {}", table64Id);
        return this.wmGenericDao.findById(table64Id);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "viewsdbTransactionManager")
	@Override
	public Table64 update(Table64 table64) throws EntityNotFoundException {
        LOGGER.debug("Updating Table64 with information: {}", table64);
        this.wmGenericDao.update(table64);

        Integer table64Id = table64.getId();

        return this.wmGenericDao.findById(table64Id);
    }

    @Transactional(value = "viewsdbTransactionManager")
	@Override
	public Table64 delete(Integer table64Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table64 with id: {}", table64Id);
        Table64 deleted = this.wmGenericDao.findById(table64Id);
        if (deleted == null) {
            LOGGER.debug("No Table64 found with id: {}", table64Id);
            throw new EntityNotFoundException(String.valueOf(table64Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Page<Table64> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table64s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Page<Table64> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table64s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service viewsdb for table Table64 to {} format", exportType);
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

