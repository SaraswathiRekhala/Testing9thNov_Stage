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

import com.testing9thnov_stage.viewsdb.TestNopk2;
import com.testing9thnov_stage.viewsdb.service.TestNopk2Service;


/**
 * Controller object for domain model class TestNopk2.
 * @see TestNopk2
 */
@RestController("viewsdb.TestNopk2Controller")
@Api(value = "TestNopk2Controller", description = "Exposes APIs to work with TestNopk2 resource.")
@RequestMapping("/viewsdb/TestNopk2")
public class TestNopk2Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestNopk2Controller.class);

    @Autowired
	@Qualifier("viewsdb.TestNopk2Service")
	private TestNopk2Service testNopk2Service;

	@ApiOperation(value = "Creates a new TestNopk2 instance.")
@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public TestNopk2 createTestNopk2(@RequestBody TestNopk2 testNopk2) {
		LOGGER.debug("Create TestNopk2 with information: {}" , testNopk2);

		testNopk2 = testNopk2Service.create(testNopk2);
		LOGGER.debug("Created TestNopk2 with information: {}" , testNopk2);

	    return testNopk2;
	}

    @ApiOperation(value = "Returns the TestNopk2 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TestNopk2 getTestNopk2(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting TestNopk2 with id: {}" , id);

        TestNopk2 foundTestNopk2 = testNopk2Service.getById(id);
        LOGGER.debug("TestNopk2 details with id: {}" , foundTestNopk2);

        return foundTestNopk2;
    }

    @ApiOperation(value = "Updates the TestNopk2 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TestNopk2 editTestNopk2(@PathVariable("id") Integer id, @RequestBody TestNopk2 testNopk2) throws EntityNotFoundException {
        LOGGER.debug("Editing TestNopk2 with id: {}" , testNopk2.getId());

        testNopk2.setId(id);
        testNopk2 = testNopk2Service.update(testNopk2);
        LOGGER.debug("TestNopk2 details with id: {}" , testNopk2);

        return testNopk2;
    }

    @ApiOperation(value = "Deletes the TestNopk2 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteTestNopk2(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting TestNopk2 with id: {}" , id);

        TestNopk2 deletedTestNopk2 = testNopk2Service.delete(id);

        return deletedTestNopk2 != null;
    }

    /**
     * @deprecated Use {@link #findTestNopk2s(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of TestNopk2 instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TestNopk2> searchTestNopk2sByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering TestNopk2s list");
        return testNopk2Service.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of TestNopk2 instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TestNopk2> findTestNopk2s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TestNopk2s list");
        return testNopk2Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of TestNopk2 instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TestNopk2> filterTestNopk2s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TestNopk2s list");
        return testNopk2Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportTestNopk2s(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return testNopk2Service.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of TestNopk2 instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countTestNopk2s( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting TestNopk2s");
		return testNopk2Service.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getTestNopk2AggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return testNopk2Service.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TestNopk2Service instance
	 */
	protected void setTestNopk2Service(TestNopk2Service service) {
		this.testNopk2Service = service;
	}

}

