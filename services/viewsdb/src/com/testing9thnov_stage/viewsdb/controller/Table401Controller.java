/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing9thnov_stage.viewsdb.controller;

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

import com.testing9thnov_stage.viewsdb.Table401;
import com.testing9thnov_stage.viewsdb.service.Table401Service;


/**
 * Controller object for domain model class Table401.
 * @see Table401
 */
@RestController("viewsdb.Table401Controller")
@Api(value = "Table401Controller", description = "Exposes APIs to work with Table401 resource.")
@RequestMapping("/viewsdb/Table401")
public class Table401Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table401Controller.class);

    @Autowired
	@Qualifier("viewsdb.Table401Service")
	private Table401Service table401Service;

	@ApiOperation(value = "Creates a new Table401 instance.")
@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public Table401 createTable401(@RequestBody Table401 table401) {
		LOGGER.debug("Create Table401 with information: {}" , table401);

		table401 = table401Service.create(table401);
		LOGGER.debug("Created Table401 with information: {}" , table401);

	    return table401;
	}

    @ApiOperation(value = "Returns the Table401 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Table401 getTable401(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Table401 with id: {}" , id);

        Table401 foundTable401 = table401Service.getById(id);
        LOGGER.debug("Table401 details with id: {}" , foundTable401);

        return foundTable401;
    }

    @ApiOperation(value = "Updates the Table401 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Table401 editTable401(@PathVariable("id") Integer id, @RequestBody Table401 table401) throws EntityNotFoundException {
        LOGGER.debug("Editing Table401 with id: {}" , table401.getId());

        table401.setId(id);
        table401 = table401Service.update(table401);
        LOGGER.debug("Table401 details with id: {}" , table401);

        return table401;
    }

    @ApiOperation(value = "Deletes the Table401 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteTable401(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table401 with id: {}" , id);

        Table401 deletedTable401 = table401Service.delete(id);

        return deletedTable401 != null;
    }

    /**
     * @deprecated Use {@link #findTable401s(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Table401 instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table401> searchTable401sByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Table401s list");
        return table401Service.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Table401 instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table401> findTable401s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table401s list");
        return table401Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Table401 instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table401> filterTable401s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table401s list");
        return table401Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportTable401s(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return table401Service.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Table401 instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countTable401s( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Table401s");
		return table401Service.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getTable401AggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return table401Service.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service Table401Service instance
	 */
	protected void setTable401Service(Table401Service service) {
		this.table401Service = service;
	}

}
