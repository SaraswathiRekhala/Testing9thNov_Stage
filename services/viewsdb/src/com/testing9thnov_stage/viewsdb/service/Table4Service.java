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

import com.testing9thnov_stage.viewsdb.Table4;

/**
 * Service object for domain model class {@link Table4}.
 */
public interface Table4Service {

    /**
     * Creates a new Table4. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Table4 if any.
     *
     * @param table4 Details of the Table4 to be created; value cannot be null.
     * @return The newly created Table4.
     */
	Table4 create(@Valid Table4 table4);


	/**
	 * Returns Table4 by given id if exists.
	 *
	 * @param table4Id The id of the Table4 to get; value cannot be null.
	 * @return Table4 associated with the given table4Id.
     * @throws EntityNotFoundException If no Table4 is found.
	 */
	Table4 getById(Integer table4Id) throws EntityNotFoundException;

    /**
	 * Find and return the Table4 by given id if exists, returns null otherwise.
	 *
	 * @param table4Id The id of the Table4 to get; value cannot be null.
	 * @return Table4 associated with the given table4Id.
	 */
	Table4 findById(Integer table4Id);


	/**
	 * Updates the details of an existing Table4. It replaces all fields of the existing Table4 with the given table4.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Table4 if any.
     *
	 * @param table4 The details of the Table4 to be updated; value cannot be null.
	 * @return The updated Table4.
	 * @throws EntityNotFoundException if no Table4 is found with given input.
	 */
	Table4 update(@Valid Table4 table4) throws EntityNotFoundException;

    /**
	 * Deletes an existing Table4 with the given id.
	 *
	 * @param table4Id The id of the Table4 to be deleted; value cannot be null.
	 * @return The deleted Table4.
	 * @throws EntityNotFoundException if no Table4 found with the given id.
	 */
	Table4 delete(Integer table4Id) throws EntityNotFoundException;

	/**
	 * Find all Table4s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Table4s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Table4> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Table4s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Table4s.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Table4> findAll(String query, Pageable pageable);

    /**
	 * Exports all Table4s matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Table4s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Table4.
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

