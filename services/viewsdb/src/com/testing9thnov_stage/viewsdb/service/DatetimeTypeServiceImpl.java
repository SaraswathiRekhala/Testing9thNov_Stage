/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing9thnov_stage.viewsdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.HashMap;
import java.util.Map;

import org.joda.time.LocalDateTime;
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

import com.testing9thnov_stage.viewsdb.DatetimeType;


/**
 * ServiceImpl object for domain model class DatetimeType.
 *
 * @see DatetimeType
 */
@Service("viewsdb.DatetimeTypeService")
@Validated
public class DatetimeTypeServiceImpl implements DatetimeTypeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatetimeTypeServiceImpl.class);


    @Autowired
    @Qualifier("viewsdb.DatetimeTypeDao")
    private WMGenericDao<DatetimeType, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<DatetimeType, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "viewsdbTransactionManager")
    @Override
	public DatetimeType create(DatetimeType datetimeTypeInstance) {
        LOGGER.debug("Creating a new DatetimeType with information: {}", datetimeTypeInstance);
        DatetimeType datetimeTypeInstanceCreated = this.wmGenericDao.create(datetimeTypeInstance);
        return datetimeTypeInstanceCreated;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public DatetimeType getById(Integer datetimetypeId) throws EntityNotFoundException {
        LOGGER.debug("Finding DatetimeType by id: {}", datetimetypeId);
        DatetimeType datetimeTypeInstance = this.wmGenericDao.findById(datetimetypeId);
        if (datetimeTypeInstance == null){
            LOGGER.debug("No DatetimeType found with id: {}", datetimetypeId);
            throw new EntityNotFoundException(String.valueOf(datetimetypeId));
        }
        return datetimeTypeInstance;
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public DatetimeType findById(Integer datetimetypeId) {
        LOGGER.debug("Finding DatetimeType by id: {}", datetimetypeId);
        return this.wmGenericDao.findById(datetimetypeId);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public DatetimeType getByIdAndDatetimeType(int id, LocalDateTime datetimeType) {
        Map<String, Object> idAndDatetimeTypeMap = new HashMap<>();
        idAndDatetimeTypeMap.put("id", id);
        idAndDatetimeTypeMap.put("datetimeType", datetimeType);

        LOGGER.debug("Finding DatetimeType by unique keys: {}", idAndDatetimeTypeMap);
        DatetimeType datetimeTypeInstance = this.wmGenericDao.findByUniqueKey(idAndDatetimeTypeMap);

        if (datetimeTypeInstance == null){
            LOGGER.debug("No DatetimeType found with given unique key values: {}", idAndDatetimeTypeMap);
            throw new EntityNotFoundException(String.valueOf(idAndDatetimeTypeMap));
        }

        return datetimeTypeInstance;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "viewsdbTransactionManager")
	@Override
	public DatetimeType update(DatetimeType datetimeTypeInstance) throws EntityNotFoundException {
        LOGGER.debug("Updating DatetimeType with information: {}", datetimeTypeInstance);
        this.wmGenericDao.update(datetimeTypeInstance);

        Integer datetimetypeId = datetimeTypeInstance.getId();

        return this.wmGenericDao.findById(datetimetypeId);
    }

    @Transactional(value = "viewsdbTransactionManager")
	@Override
	public DatetimeType delete(Integer datetimetypeId) throws EntityNotFoundException {
        LOGGER.debug("Deleting DatetimeType with id: {}", datetimetypeId);
        DatetimeType deleted = this.wmGenericDao.findById(datetimetypeId);
        if (deleted == null) {
            LOGGER.debug("No DatetimeType found with id: {}", datetimetypeId);
            throw new EntityNotFoundException(String.valueOf(datetimetypeId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "viewsdbTransactionManager")
	@Override
	public Page<DatetimeType> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all DatetimeTypes");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Page<DatetimeType> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all DatetimeTypes");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "viewsdbTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service viewsdb for table DatetimeType to {} format", exportType);
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

