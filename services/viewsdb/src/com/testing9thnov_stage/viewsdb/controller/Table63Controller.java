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

import com.testing9thnov_stage.viewsdb.Table63;
import com.testing9thnov_stage.viewsdb.Table63Id;
import com.testing9thnov_stage.viewsdb.service.Table63Service;


/**
 * Controller object for domain model class Table63.
 * @see Table63
 */
@RestController("viewsdb.Table63Controller")
@Api(value = "Table63Controller", description = "Exposes APIs to work with Table63 resource.")
@RequestMapping("/viewsdb/Table63")
public class Table63Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table63Controller.class);

    @Autowired
	@Qualifier("viewsdb.Table63Service")
	private Table63Service table63Service;

	@ApiOperation(value = "Creates a new Table63 instance.")
@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public Table63 createTable63(@RequestBody Table63 table63) {
		LOGGER.debug("Create Table63 with information: {}" , table63);

		table63 = table63Service.create(table63);
		LOGGER.debug("Created Table63 with information: {}" , table63);

	    return table63;
	}

@ApiOperation(value = "Returns the Table63 instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Table63 getTable63(@RequestParam("column2") String column2,@RequestParam("column3") String column3) throws EntityNotFoundException {

        Table63Id table63Id = new Table63Id();
        table63Id.setColumn2(column2);
        table63Id.setColumn3(column3);

        LOGGER.debug("Getting Table63 with id: {}" , table63Id);
        Table63 table63 = table63Service.getById(table63Id);
        LOGGER.debug("Table63 details with id: {}" , table63);

        return table63;
    }



    @ApiOperation(value = "Updates the Table63 instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Table63 editTable63(@RequestParam("column2") String column2,@RequestParam("column3") String column3, @RequestBody Table63 table63) throws EntityNotFoundException {

        table63.setColumn2(column2);
        table63.setColumn3(column3);

        LOGGER.debug("Table63 details with id is updated with: {}" , table63);

        return table63Service.update(table63);
    }


    @ApiOperation(value = "Deletes the Table63 instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteTable63(@RequestParam("column2") String column2,@RequestParam("column3") String column3) throws EntityNotFoundException {

        Table63Id table63Id = new Table63Id();
        table63Id.setColumn2(column2);
        table63Id.setColumn3(column3);

        LOGGER.debug("Deleting Table63 with id: {}" , table63Id);
        Table63 table63 = table63Service.delete(table63Id);

        return table63 != null;
    }


    /**
     * @deprecated Use {@link #findTable63s(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Table63 instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table63> searchTable63sByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Table63s list");
        return table63Service.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Table63 instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table63> findTable63s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table63s list");
        return table63Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Table63 instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table63> filterTable63s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table63s list");
        return table63Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportTable63s(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return table63Service.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Table63 instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countTable63s( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Table63s");
		return table63Service.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getTable63AggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return table63Service.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service Table63Service instance
	 */
	protected void setTable63Service(Table63Service service) {
		this.table63Service = service;
	}

}

