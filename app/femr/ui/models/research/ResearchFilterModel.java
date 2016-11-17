package femr.ui.models.research;

import femr.common.models.ResearchFilterItem;

/**
 * Created by raghu on 11/15/16.
 */

public  class ResearchFilterModel {

    /**
     * Generate and provide an instance of ResearchFilterItem.
     * Moved from an implementation of IItemModelMapper on 6-10-2015 by Kevin
     *
     * @param filterViewModel a viewmodel, not null
     * @return ResearchFilterItem or null if processing fails
     */
    public static ResearchFilterItem createResearchFilterItem(FilterViewModel filterViewModel) {

        if (filterViewModel == null) {

            return null;
        }

        ResearchFilterItem filterItem = new ResearchFilterItem();

        filterItem.setPrimaryDataset(filterViewModel.getPrimaryDataset());
        filterItem.setSecondaryDataset(filterViewModel.getSecondaryDataset());
        filterItem.setGraphType(filterViewModel.getGraphType());
        filterItem.setStartDate(filterViewModel.getStartDate());
        filterItem.setEndDate(filterViewModel.getEndDate());

        Integer groupFactor = filterViewModel.getGroupFactor();
        filterItem.setGroupFactor(groupFactor);
        if (groupFactor != null && groupFactor > 0) {

            filterItem.setGroupPrimary(filterViewModel.isGroupPrimary());
        } else {

            filterItem.setGroupPrimary(false);
        }

        filterItem.setFilterRangeStart(filterViewModel.getFilterRangeStart());
        filterItem.setFilterRangeEnd(filterViewModel.getFilterRangeEnd());
        filterItem.setMedicationName(filterViewModel.getMedicationName());
        filterItem.setMissionTripId(filterViewModel.getMissionTripId()); //Andrew Trip Filter


        return filterItem;
    }
}
