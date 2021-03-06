/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing9thnov_stage.mysqlvcs.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
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

import com.testing9thnov_stage.mysqlvcs.ChildTable;
import com.testing9thnov_stage.mysqlvcs.ParentTable;


/**
 * ServiceImpl object for domain model class ParentTable.
 *
 * @see ParentTable
 */
@Service("MysqlVCS.ParentTableService")
@Validated
public class ParentTableServiceImpl implements ParentTableService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParentTableServiceImpl.class);

    @Lazy
    @Autowired
	@Qualifier("MysqlVCS.ChildTableService")
	private ChildTableService childTableService;

    @Autowired
    @Qualifier("MysqlVCS.ParentTableDao")
    private WMGenericDao<ParentTable, String> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<ParentTable, String> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "MysqlVCSTransactionManager")
    @Override
	public ParentTable create(ParentTable parentTable) {
        LOGGER.debug("Creating a new ParentTable with information: {}", parentTable);
        ParentTable parentTableCreated = this.wmGenericDao.create(parentTable);
        if(parentTableCreated.getChildTables() != null) {
            for(ChildTable childTable : parentTableCreated.getChildTables()) {
                childTable.setParentTable(parentTableCreated);
                LOGGER.debug("Creating a new child ChildTable with information: {}", childTable);
                childTableService.create(childTable);
            }
        }
        return parentTableCreated;
    }

	@Transactional(readOnly = true, value = "MysqlVCSTransactionManager")
	@Override
	public ParentTable getById(String parenttableId) throws EntityNotFoundException {
        LOGGER.debug("Finding ParentTable by id: {}", parenttableId);
        ParentTable parentTable = this.wmGenericDao.findById(parenttableId);
        if (parentTable == null){
            LOGGER.debug("No ParentTable found with id: {}", parenttableId);
            throw new EntityNotFoundException(String.valueOf(parenttableId));
        }
        return parentTable;
    }

    @Transactional(readOnly = true, value = "MysqlVCSTransactionManager")
	@Override
	public ParentTable findById(String parenttableId) {
        LOGGER.debug("Finding ParentTable by id: {}", parenttableId);
        return this.wmGenericDao.findById(parenttableId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "MysqlVCSTransactionManager")
	@Override
	public ParentTable update(ParentTable parentTable) throws EntityNotFoundException {
        LOGGER.debug("Updating ParentTable with information: {}", parentTable);
        this.wmGenericDao.update(parentTable);

        String parenttableId = parentTable.getId();

        return this.wmGenericDao.findById(parenttableId);
    }

    @Transactional(value = "MysqlVCSTransactionManager")
	@Override
	public ParentTable delete(String parenttableId) throws EntityNotFoundException {
        LOGGER.debug("Deleting ParentTable with id: {}", parenttableId);
        ParentTable deleted = this.wmGenericDao.findById(parenttableId);
        if (deleted == null) {
            LOGGER.debug("No ParentTable found with id: {}", parenttableId);
            throw new EntityNotFoundException(String.valueOf(parenttableId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "MysqlVCSTransactionManager")
	@Override
	public Page<ParentTable> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all ParentTables");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "MysqlVCSTransactionManager")
    @Override
    public Page<ParentTable> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all ParentTables");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "MysqlVCSTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service MysqlVCS for table ParentTable to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "MysqlVCSTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "MysqlVCSTransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }

    @Transactional(readOnly = true, value = "MysqlVCSTransactionManager")
    @Override
    public Page<ChildTable> findAssociatedChildTables(String id, Pageable pageable) {
        LOGGER.debug("Fetching all associated childTables");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("parentTable.id = '" + id + "'");

        return childTableService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ChildTableService instance
	 */
	protected void setChildTableService(ChildTableService service) {
        this.childTableService = service;
    }

}

