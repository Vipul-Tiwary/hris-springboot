package com.hisptz.hris.Bundles.DashboardChartBundle;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Guest on 8/16/18.
 */
@Component
public class DashboardChartMutation implements GraphQLMutationResolver{
    @Autowired
    private DashboardChartRepository dashboardChartRepository;

    public DashboardChartMutation(DashboardChartRepository dashboardChartRepository) {
        this.dashboardChartRepository = dashboardChartRepository;
    }

    public DashboardChart newDashboardChart(Integer fieldoneId, Integer fieldtwoId, Integer userId, String name, String description, String graphtype, Boolean lowerlevels, Boolean systemwide){
        return new DashboardChart(fieldoneId, fieldtwoId, userId, name, description, graphtype, lowerlevels,systemwide);
    }

    public Boolean deleteDashboardChart(Long id){
        dashboardChartRepository.delete(dashboardChartRepository.findOne(id));
        return true;
    }

    public DashboardChart updateDashboardChart(Long id,Integer fieldoneId, Integer fieldtwoId, Integer userId, String name, String description, String graphtype, Boolean lowerlevels, Boolean systemwide){
        DashboardChart dashboardChart = dashboardChartRepository.findOne(id);

        if (fieldoneId!= null)
            dashboardChart.setFieldoneId(fieldoneId);

        if (fieldtwoId != null)
            dashboardChart.setFieldtwoId(fieldtwoId);

        if (userId != null)
            dashboardChart.setUserId(userId);

        if (name != null)
            dashboardChart.setName(name);

        if (description != null)
            dashboardChart.setDescription(description);

        if (graphtype != null)
            dashboardChart.setGraphtype(graphtype);

        if (lowerlevels != null)
            dashboardChart.setLowerlevels(lowerlevels);

        if (systemwide != null)
            dashboardChart.setSystemwide(systemwide);

        dashboardChartRepository.save(dashboardChart);
        return dashboardChart;
    }
}




















