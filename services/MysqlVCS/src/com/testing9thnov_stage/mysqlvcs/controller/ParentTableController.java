/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing9thnov_stage.mysqlvcs.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.testing9thnov_stage.mysqlvcs.ChildTable;
import com.testing9thnov_stage.mysqlvcs.ParentTable;
import com.testing9thnov_stage.mysqlvcs.service.ParentTableService;


/**
 * Controller object for domain model class ParentTable.
 * @see ParentTable
 */
@RestController("MysqlVCS.ParentTableController")
@Api(value = "ParentTableController", description = "Exposes APIs to work with ParentTable resource.")
@RequestMapping("/MysqlVCS/ParentTable")
public class ParentTableController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParentTableController.class);

    @Autowired
	@Qualifier("MysqlVCS.ParentTableService")
	private ParentTableService parentTableService;

	@ApiOperation(value = "Creates a new ParentTable instance.")
@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public ParentTable createParentTable(@RequestBody ParentTable parentTable) {
		LOGGER.debug("Create ParentTable with information: {}" , parentTable);

		parentTable = parentTableService.create(parentTable);
		LOGGER.debug("Created ParentTable with information: {}" , parentTable);

	    return parentTable;
	}

    @ApiOperation(value = "Returns the ParentTable instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ParentTable getParentTable(@PathVariable("id") String id) throws EntityNotFoundException {
        LOGGER.debug("Getting ParentTable with id: {}" , id);

        ParentTable foundParentTable = parentTableService.getById(id);
        LOGGER.debug("ParentTable details with id: {}" , foundParentTable);

        return foundParentTable;
    }

    @ApiOperation(value = "Updates the ParentTable instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ParentTable editParentTable(@PathVariable("id") String id, @RequestBody ParentTable parentTable) throws EntityNotFoundException {
        LOGGER.debug("Editing ParentTable with id: {}" , parentTable.getId());

        parentTable.setId(id);
        parentTable = parentTableService.update(parentTable);
        LOGGER.debug("ParentTable details with id: {}" , parentTable);

        return parentTable;
    }

    @ApiOperation(value = "Deletes the ParentTable instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteParentTable(@PathVariable("id") String id) throws EntityNotFoundException {
        LOGGER.debug("Deleting ParentTable with id: {}" , id);

        ParentTable deletedParentTable = parentTableService.delete(id);

        return deletedParentTable != null;
    }

    /**
     * @deprecated Use {@link #findParentTables(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of ParentTable instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ParentTable> searchParentTablesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering ParentTables list");
        return parentTableService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of ParentTable instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ParentTable> findParentTables(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ParentTables list");
        return parentTableService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of ParentTable instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ParentTable> filterParentTables(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ParentTables list");
        return parentTableService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportParentTables(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return parentTableService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of ParentTable instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countParentTables( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting ParentTables");
		return parentTableService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getParentTableAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return parentTableService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/childTables", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the childTables instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ChildTable> findAssociatedChildTables(@PathVariable("id") String id, Pageable pageable) {

        LOGGER.debug("Fetching all associated childTables");
        return parentTableService.findAssociatedChildTables(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ParentTableService instance
	 */
	protected void setParentTableService(ParentTableService service) {
		this.parentTableService = service;
	}

}

