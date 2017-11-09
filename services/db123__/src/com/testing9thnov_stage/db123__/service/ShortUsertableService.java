/*Generated by WaveMaker Studio*/
package com.testing9thnov_stage.db123__.service;

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

import com.testing9thnov_stage.db123__.ShortUsertable;

/**
 * Service object for domain model class {@link ShortUsertable}.
 */
public interface ShortUsertableService {

    /**
     * Creates a new ShortUsertable. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on ShortUsertable if any.
     *
     * @param shortUsertable Details of the ShortUsertable to be created; value cannot be null.
     * @return The newly created ShortUsertable.
     */
	ShortUsertable create(@Valid ShortUsertable shortUsertable);


	/**
	 * Returns ShortUsertable by given id if exists.
	 *
	 * @param shortusertableId The id of the ShortUsertable to get; value cannot be null.
	 * @return ShortUsertable associated with the given shortusertableId.
     * @throws EntityNotFoundException If no ShortUsertable is found.
	 */
	ShortUsertable getById(Short shortusertableId) throws EntityNotFoundException;

    /**
	 * Find and return the ShortUsertable by given id if exists, returns null otherwise.
	 *
	 * @param shortusertableId The id of the ShortUsertable to get; value cannot be null.
	 * @return ShortUsertable associated with the given shortusertableId.
	 */
	ShortUsertable findById(Short shortusertableId);


	/**
	 * Updates the details of an existing ShortUsertable. It replaces all fields of the existing ShortUsertable with the given shortUsertable.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on ShortUsertable if any.
     *
	 * @param shortUsertable The details of the ShortUsertable to be updated; value cannot be null.
	 * @return The updated ShortUsertable.
	 * @throws EntityNotFoundException if no ShortUsertable is found with given input.
	 */
	ShortUsertable update(@Valid ShortUsertable shortUsertable) throws EntityNotFoundException;

    /**
	 * Deletes an existing ShortUsertable with the given id.
	 *
	 * @param shortusertableId The id of the ShortUsertable to be deleted; value cannot be null.
	 * @return The deleted ShortUsertable.
	 * @throws EntityNotFoundException if no ShortUsertable found with the given id.
	 */
	ShortUsertable delete(Short shortusertableId) throws EntityNotFoundException;

	/**
	 * Find all ShortUsertables matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching ShortUsertables.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<ShortUsertable> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all ShortUsertables matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching ShortUsertables.
     *
     * @see Pageable
     * @see Page
	 */
    Page<ShortUsertable> findAll(String query, Pageable pageable);

    /**
	 * Exports all ShortUsertables matching the given input query to the given exportType format.
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
	 * Retrieve the count of the ShortUsertables in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the ShortUsertable.
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

