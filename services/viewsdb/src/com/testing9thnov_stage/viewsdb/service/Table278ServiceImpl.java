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

import com.testing9thnov_stage.viewsdb.Table278;


/**
 * ServiceImpl object for domain model class Table278.
 *
 * @see Table278
 */
@Service("viewsdb.Table278Service")
@Validated
public class Table278ServiceImpl implements Table278Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table278ServiceImpl.class);


    @Autowired
    @Qualifier("viewsdb.Table278Dao")
    private WMGenericDao<Table278, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table278, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "viewsdbTransactionManager")
    @Override
	public Table278 create(Table278 table278) {
        LOGGER.debug("Creating a new Table278 with information: {}", table278);
        Table278 table278Created = this.wmGenericDao.create(table278);
        return table278Created;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Table278 getById(Integer table278Id) throws EntityNotFoundException {
        LOGGER.debug("Finding Table278 by id: {}", table278Id);
        Table278 table278 = this.wmGenericDao.findById(table278Id);
        if (table278 == null){
            LOGGER.debug("No Table278 found with id: {}", table278Id);
            throw new EntityNotFoundException(String.valueOf(table278Id));
        }
        return table278;
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Table278 findById(Integer table278Id) {
        LOGGER.debug("Finding Table278 by id: {}", table278Id);
        return this.wmGenericDao.findById(table278Id);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "viewsdbTransactionManager")
	@Override
	public Table278 update(Table278 table278) throws EntityNotFoundException {
        LOGGER.debug("Updating Table278 with information: {}", table278);
        this.wmGenericDao.update(table278);

        Integer table278Id = table278.getId();

        return this.wmGenericDao.findById(table278Id);
    }

    @Transactional(value = "viewsdbTransactionManager")
	@Override
	public Table278 delete(Integer table278Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table278 with id: {}", table278Id);
        Table278 deleted = this.wmGenericDao.findById(table278Id);
        if (deleted == null) {
            LOGGER.debug("No Table278 found with id: {}", table278Id);
            throw new EntityNotFoundException(String.valueOf(table278Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Page<Table278> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table278s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Page<Table278> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table278s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service viewsdb for table Table278 to {} format", exportType);
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

