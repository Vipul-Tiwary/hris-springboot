package com.hisptz.hris.Bundles.RelationalFilter;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Guest on 8/14/18.
 */
@Component
public class RelationalFilterQuery implements GraphQLQueryResolver {
    @Autowired
    protected RelationalFilterRepository relationalFilterRepository;

    public RelationalFilterQuery(RelationalFilterRepository RelationalFilterRepository) {
        this.relationalFilterRepository = RelationalFilterRepository;
    }

    public List<RelationalFilter> relationalFilters(){
       return relationalFilterRepository.findAll();
    }

    public RelationalFilter getRelationalFilterById(Long id){
      return relationalFilterRepository.findOne(id);
    }
}