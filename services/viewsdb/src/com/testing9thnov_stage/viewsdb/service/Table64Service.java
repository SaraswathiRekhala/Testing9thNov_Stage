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

import com.testing9thnov_stage.viewsdb.Table64;

/**
 * Service object for domain model class {@link Table64}.
 */
public interface Table64Service {

    /**
     * Creates a new Table64. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Table64 if any.
     *
     * @param table64 Details of the Table64 to be created; value cannot be null.
     * @return The newly created Table64.
     */
	Table64 create(@Valid Table64 table64);


	/**
	 * Returns Table64 by given id if exists.
	 *
	 * @param table64Id The id of the Table64 to get; value cannot be null.
	 * @return Table64 associated with the given table64Id.
     * @throws EntityNotFoundException If no Table64 is found.
	 */
	Table64 getById(Integer table64Id) throws EntityNotFoundException;

    /**
	 * Find and return the Table64 by given id if exists, returns null otherwise.
	 *
	 * @param table64Id The id of the Table64 to get; value cannot be null.
	 * @return Table64 associated with the given table64Id.
	 */
	Table64 findById(Integer table64Id);


	/**
	 * Updates the details of an existing Table64. It replaces all fields of the existing Table64 with the given table64.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Table64 if any.
     *
	 * @param table64 The details of the Table64 to be updated; value cannot be null.
	 * @return The updated Table64.
	 * @throws EntityNotFoundException if no Table64 is found with given input.
	 */
	Table64 update(@Valid Table64 table64) throws EntityNotFoundException;

    /**
	 * Deletes an existing Table64 with the given id.
	 *
	 * @param table64Id The id of the Table64 to be deleted; value cannot be null.
	 * @return The deleted Table64.
	 * @throws EntityNotFoundException if no Table64 found with the given id.
	 */
	Table64 delete(Integer table64Id) throws EntityNotFoundException;

	/**
	 * Find all Table64s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Table64s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Table64> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Table64s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Table64s.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Table64> findAll(String query, Pageable pageable);

    /**
	 * Exports all Table64s matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Table64s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Table64.
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
