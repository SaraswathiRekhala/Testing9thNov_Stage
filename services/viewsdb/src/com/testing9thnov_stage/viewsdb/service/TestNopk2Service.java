/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing9thnov_stage.viewsdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testing9thnov_stage.viewsdb.TestNopk2;

/**
 * Service object for domain model class {@link TestNopk2}.
 */
public interface TestNopk2Service {

    /**
     * Creates a new TestNopk2. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on TestNopk2 if any.
     *
     * @param testNopk2 Details of the TestNopk2 to be created; value cannot be null.
     * @return The newly created TestNopk2.
     */
	TestNopk2 create(@Valid TestNopk2 testNopk2);


	/**
	 * Returns TestNopk2 by given id if exists.
	 *
	 * @param testnopk2Id The id of the TestNopk2 to get; value cannot be null.
	 * @return TestNopk2 associated with the given testnopk2Id.
     * @throws EntityNotFoundException If no TestNopk2 is found.
	 */
	TestNopk2 getById(Integer testnopk2Id) throws EntityNotFoundException;

    /**
	 * Find and return the TestNopk2 by given id if exists, returns null otherwise.
	 *
	 * @param testnopk2Id The id of the TestNopk2 to get; value cannot be null.
	 * @return TestNopk2 associated with the given testnopk2Id.
	 */
	TestNopk2 findById(Integer testnopk2Id);


	/**
	 * Updates the details of an existing TestNopk2. It replaces all fields of the existing TestNopk2 with the given testNopk2.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on TestNopk2 if any.
     *
	 * @param testNopk2 The details of the TestNopk2 to be updated; value cannot be null.
	 * @return The updated TestNopk2.
	 * @throws EntityNotFoundException if no TestNopk2 is found with given input.
	 */
	TestNopk2 update(@Valid TestNopk2 testNopk2) throws EntityNotFoundException;

    /**
	 * Deletes an existing TestNopk2 with the given id.
	 *
	 * @param testnopk2Id The id of the TestNopk2 to be deleted; value cannot be null.
	 * @return The deleted TestNopk2.
	 * @throws EntityNotFoundException if no TestNopk2 found with the given id.
	 */
	TestNopk2 delete(Integer testnopk2Id) throws EntityNotFoundException;

	/**
	 * Find all TestNopk2s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TestNopk2s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<TestNopk2> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all TestNopk2s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TestNopk2s.
     *
     * @see Pageable
     * @see Page
	 */
    Page<TestNopk2> findAll(String query, Pageable pageable);

    /**
	 * Exports all TestNopk2s matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
	 */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the TestNopk2s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the TestNopk2.
	 */
	long count(String query);

	/**
	 * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
	 * @return Paginated data with included fields.

     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
	Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);


}

