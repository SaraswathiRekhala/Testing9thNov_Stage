/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.testing9thnov_stage.salesdb.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.commons.wrapper.IntegerWrapper;
import com.wavemaker.runtime.data.dao.query.WMQueryExecutor;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import com.testing9thnov_stage.salesdb.Reps;
import com.testing9thnov_stage.salesdb.service.SalesdbQueryExecutorService;
import com.testing9thnov_stage.salesdb.models.query.*;

@RestController(value = "Salesdb.QueryExecutionController")
@RequestMapping("/salesdb/queryExecutor")
@Api(value = "QueryExecutionController", description = "controller class for query execution")
public class QueryExecutionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryExecutionController.class);

    @Autowired
    private SalesdbQueryExecutorService queryService;

    @RequestMapping(value = "/queries/SV_RepsOrderBy", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "RepsOrderBy")
    public Page<SvRepsOrderByResponse> executeSV_RepsOrderBy(Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Executing named query: SV_RepsOrderBy");
        Page<SvRepsOrderByResponse> _result = queryService.executeSV_RepsOrderBy(pageable);
        LOGGER.debug("got the result for named query: SV_RepsOrderBy, result:{}", _result);
        return _result;
    }

    @ApiOperation(value = "Returns downloadable file for query SV_RepsOrderBy")
    @RequestMapping(value = "/queries/SV_RepsOrderBy/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSV_RepsOrderBy(@PathVariable("exportType") ExportType exportType, Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Exporting named query: SV_RepsOrderBy");

        return queryService.exportSV_RepsOrderBy(exportType, pageable);
    }

    @RequestMapping(value = "/queries/SV_StatesData", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "statesData")
    public Page<SvStatesDataResponse> executeSV_StatesData(Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Executing named query: SV_StatesData");
        Page<SvStatesDataResponse> _result = queryService.executeSV_StatesData(pageable);
        LOGGER.debug("got the result for named query: SV_StatesData, result:{}", _result);
        return _result;
    }

    @ApiOperation(value = "Returns downloadable file for query SV_StatesData")
    @RequestMapping(value = "/queries/SV_StatesData/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSV_StatesData(@PathVariable("exportType") ExportType exportType, Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Exporting named query: SV_StatesData");

        return queryService.exportSV_StatesData(exportType, pageable);
    }

    @RequestMapping(value = "/queries/HQL_INOperator", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "In Operator")
    public Page<Reps> executeHQL_INOperator(@RequestParam(value = "channelType") List<Integer> channelType, Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Executing named query: HQL_INOperator");
        Page<Reps> _result = queryService.executeHQL_INOperator(channelType, pageable);
        LOGGER.debug("got the result for named query: HQL_INOperator, result:{}", _result);
        return _result;
    }

    @ApiOperation(value = "Returns downloadable file for query HQL_INOperator")
    @RequestMapping(value = "/queries/HQL_INOperator/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportHQL_INOperator(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "channelType") List<Integer> channelType, Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Exporting named query: HQL_INOperator");

        return queryService.exportHQL_INOperator(exportType, channelType, pageable);
    }

    @RequestMapping(value = "/queries/SV_CreateTable", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Create All Types Table")
    public IntegerWrapper executeSV_CreateTable(@Valid @RequestBody SvCreateTableRequest svCreateTableRequest, HttpServletRequest _request) {
        LOGGER.debug("Executing named query: SV_CreateTable");
        Integer _result = queryService.executeSV_CreateTable(svCreateTableRequest);
        LOGGER.debug("got the result for named query: SV_CreateTable, result:{}", _result);
        return new IntegerWrapper(_result);
    }

    @RequestMapping(value = "/queries/SV_SalesData", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "SalesData")
    public Page<SvSalesDataResponse> executeSV_SalesData(Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Executing named query: SV_SalesData");
        Page<SvSalesDataResponse> _result = queryService.executeSV_SalesData(pageable);
        LOGGER.debug("got the result for named query: SV_SalesData, result:{}", _result);
        return _result;
    }

    @ApiOperation(value = "Returns downloadable file for query SV_SalesData")
    @RequestMapping(value = "/queries/SV_SalesData/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSV_SalesData(@PathVariable("exportType") ExportType exportType, Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Exporting named query: SV_SalesData");

        return queryService.exportSV_SalesData(exportType, pageable);
    }

    @RequestMapping(value = "/queries/SV_ProductsData", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Products Data")
    public Page<SvProductsDataResponse> executeSV_ProductsData(Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Executing named query: SV_ProductsData");
        Page<SvProductsDataResponse> _result = queryService.executeSV_ProductsData(pageable);
        LOGGER.debug("got the result for named query: SV_ProductsData, result:{}", _result);
        return _result;
    }

    @ApiOperation(value = "Returns downloadable file for query SV_ProductsData")
    @RequestMapping(value = "/queries/SV_ProductsData/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSV_ProductsData(@PathVariable("exportType") ExportType exportType, Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Exporting named query: SV_ProductsData");

        return queryService.exportSV_ProductsData(exportType, pageable);
    }

    @RequestMapping(value = "/queries/SV_ChannelsData", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "SV_ChannelsData")
    public Page<SvChannelsDataResponse> executeSV_ChannelsData(Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Executing named query: SV_ChannelsData");
        Page<SvChannelsDataResponse> _result = queryService.executeSV_ChannelsData(pageable);
        LOGGER.debug("got the result for named query: SV_ChannelsData, result:{}", _result);
        return _result;
    }

    @ApiOperation(value = "Returns downloadable file for query SV_ChannelsData")
    @RequestMapping(value = "/queries/SV_ChannelsData/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSV_ChannelsData(@PathVariable("exportType") ExportType exportType, Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Exporting named query: SV_ChannelsData");

        return queryService.exportSV_ChannelsData(exportType, pageable);
    }

    @RequestMapping(value = "/queries/SV_FollowUpsData", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "FollowUps Data")
    public Page<SvFollowUpsDataResponse> executeSV_FollowUpsData(Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Executing named query: SV_FollowUpsData");
        Page<SvFollowUpsDataResponse> _result = queryService.executeSV_FollowUpsData(pageable);
        LOGGER.debug("got the result for named query: SV_FollowUpsData, result:{}", _result);
        return _result;
    }

    @ApiOperation(value = "Returns downloadable file for query SV_FollowUpsData")
    @RequestMapping(value = "/queries/SV_FollowUpsData/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSV_FollowUpsData(@PathVariable("exportType") ExportType exportType, Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Exporting named query: SV_FollowUpsData");

        return queryService.exportSV_FollowUpsData(exportType, pageable);
    }

    @RequestMapping(value = "/queries/SV_LeadsData", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Leads Data")
    public Page<SvLeadsDataResponse> executeSV_LeadsData(Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Executing named query: SV_LeadsData");
        Page<SvLeadsDataResponse> _result = queryService.executeSV_LeadsData(pageable);
        LOGGER.debug("got the result for named query: SV_LeadsData, result:{}", _result);
        return _result;
    }

    @ApiOperation(value = "Returns downloadable file for query SV_LeadsData")
    @RequestMapping(value = "/queries/SV_LeadsData/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSV_LeadsData(@PathVariable("exportType") ExportType exportType, Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Exporting named query: SV_LeadsData");

        return queryService.exportSV_LeadsData(exportType, pageable);
    }

    @RequestMapping(value = "/queries/SV_CustomersData", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "SV_CustomersData")
    public Page<SvCustomersDataResponse> executeSV_CustomersData(Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Executing named query: SV_CustomersData");
        Page<SvCustomersDataResponse> _result = queryService.executeSV_CustomersData(pageable);
        LOGGER.debug("got the result for named query: SV_CustomersData, result:{}", _result);
        return _result;
    }

    @ApiOperation(value = "Returns downloadable file for query SV_CustomersData")
    @RequestMapping(value = "/queries/SV_CustomersData/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSV_CustomersData(@PathVariable("exportType") ExportType exportType, Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Exporting named query: SV_CustomersData");

        return queryService.exportSV_CustomersData(exportType, pageable);
    }

    @RequestMapping(value = "/queries/SV_TasksData", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Tasks Data")
    public Page<SvTasksDataResponse> executeSV_TasksData(Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Executing named query: SV_TasksData");
        Page<SvTasksDataResponse> _result = queryService.executeSV_TasksData(pageable);
        LOGGER.debug("got the result for named query: SV_TasksData, result:{}", _result);
        return _result;
    }

    @ApiOperation(value = "Returns downloadable file for query SV_TasksData")
    @RequestMapping(value = "/queries/SV_TasksData/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSV_TasksData(@PathVariable("exportType") ExportType exportType, Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Exporting named query: SV_TasksData");

        return queryService.exportSV_TasksData(exportType, pageable);
    }

    @RequestMapping(value = "/queries/HQL_CUSTOMREPS1", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "CUSTOM REPS")
    public Page<HqlCustomreps1Response> executeHQL_CUSTOMREPS1(Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Executing named query: HQL_CUSTOMREPS1");
        Page<HqlCustomreps1Response> _result = queryService.executeHQL_CUSTOMREPS1(pageable);
        LOGGER.debug("got the result for named query: HQL_CUSTOMREPS1, result:{}", _result);
        return _result;
    }

    @ApiOperation(value = "Returns downloadable file for query HQL_CUSTOMREPS1")
    @RequestMapping(value = "/queries/HQL_CUSTOMREPS1/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportHQL_CUSTOMREPS1(@PathVariable("exportType") ExportType exportType, Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Exporting named query: HQL_CUSTOMREPS1");

        return queryService.exportHQL_CUSTOMREPS1(exportType, pageable);
    }

    @RequestMapping(value = "/queries/SV_CUSTOMREPS", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "CUSTOM REPS")
    public Page<SvCustomrepsResponse> executeSV_CUSTOMREPS(Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Executing named query: SV_CUSTOMREPS");
        Page<SvCustomrepsResponse> _result = queryService.executeSV_CUSTOMREPS(pageable);
        LOGGER.debug("got the result for named query: SV_CUSTOMREPS, result:{}", _result);
        return _result;
    }

    @ApiOperation(value = "Returns downloadable file for query SV_CUSTOMREPS")
    @RequestMapping(value = "/queries/SV_CUSTOMREPS/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSV_CUSTOMREPS(@PathVariable("exportType") ExportType exportType, Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Exporting named query: SV_CUSTOMREPS");

        return queryService.exportSV_CUSTOMREPS(exportType, pageable);
    }

    @RequestMapping(value = "/queries/Sv_QuotesData", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "QuotesData")
    public Page<SvQuotesDataResponse> executeSv_QuotesData(Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Executing named query: Sv_QuotesData");
        Page<SvQuotesDataResponse> _result = queryService.executeSv_QuotesData(pageable);
        LOGGER.debug("got the result for named query: Sv_QuotesData, result:{}", _result);
        return _result;
    }

    @ApiOperation(value = "Returns downloadable file for query Sv_QuotesData")
    @RequestMapping(value = "/queries/Sv_QuotesData/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSv_QuotesData(@PathVariable("exportType") ExportType exportType, Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Exporting named query: Sv_QuotesData");

        return queryService.exportSv_QuotesData(exportType, pageable);
    }

}


