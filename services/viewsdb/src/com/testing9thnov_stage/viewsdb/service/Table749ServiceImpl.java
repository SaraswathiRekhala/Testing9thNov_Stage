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

import com.testing9thnov_stage.viewsdb.Table749;


/**
 * ServiceImpl object for domain model class Table749.
 *
 * @see Table749
 */
@Service("viewsdb.Table749Service")
@Validated
public class Table749ServiceImpl implements Table749Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table749ServiceImpl.class);


    @Autowired
    @Qualifier("viewsdb.Table749Dao")
    private WMGenericDao<Table749, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table749, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "viewsdbTransactionManager")
    @Override
	public Table749 create(Table749 table749) {
        LOGGER.debug("Creating a new Table749 with information: {}", table749);
        Table749 table749Created = this.wmGenericDao.create(table749);
        return table749Created;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Table749 getById(Integer table749Id) throws EntityNotFoundException {
        LOGGER.debug("Finding Table749 by id: {}", table749Id);
        Table749 table749 = this.wmGenericDao.findById(table749Id);
        if (table749 == null){
            LOGGER.debug("No Table749 found with id: {}", table749Id);
            throw new EntityNotFoundException(String.valueOf(table749Id));
        }
        return table749;
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Table749 findById(Integer table749Id) {
        LOGGER.debug("Finding Table749 by id: {}", table749Id);
        return this.wmGenericDao.findById(table749Id);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "viewsdbTransactionManager")
	@Override
	public Table749 update(Table749 table749) throws EntityNotFoundException {
        LOGGER.debug("Updating Table749 with information: {}", table749);
        this.wmGenericDao.update(table749);

        Integer table749Id = table749.getId();

        return this.wmGenericDao.findById(table749Id);
    }

    @Transactional(value = "viewsdbTransactionManager")
	@Override
	public Table749 delete(Integer table749Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table749 with id: {}", table749Id);
        Table749 deleted = this.wmGenericDao.findById(table749Id);
        if (deleted == null) {
            LOGGER.debug("No Table749 found with id: {}", table749Id);
            throw new EntityNotFoundException(String.valueOf(table749Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Page<Table749> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table749s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Page<Table749> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table749s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service viewsdb for table Table749 to {} format", exportType);
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

