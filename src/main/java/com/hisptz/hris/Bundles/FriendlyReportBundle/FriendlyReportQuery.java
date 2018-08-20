package com.hisptz.hris.Bundles.FriendlyReportBundle;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.hisptz.hris.Bundles.InputTypeBundle.InputType;
import com.hisptz.hris.core.Model.ModelQuery;
import com.hisptz.hris.core.Model.ModelSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Guest on 8/16/18.
 */
@Component
public class FriendlyReportQuery extends ModelQuery<FriendlyReport>{
    @Autowired
    private FriendlyReportRepository friendlyReportRepository;

    private ModelSpecification<FriendlyReport> spec;

    public FriendlyReportQuery(FriendlyReportRepository friendlyReportRepository) {
        this.friendlyReportRepository = friendlyReportRepository;
    }

    public List<FriendlyReport> friendlyReports(){
        return friendlyReportRepository.findAll();
    }

    public FriendlyReport getFriendlyReportById(Long id){
        return friendlyReportRepository.findOne(id);
    }

    public List<FriendlyReport> queryFriendlyReport(String where){
        return query(where, spec, friendlyReportRepository);
    }

}
