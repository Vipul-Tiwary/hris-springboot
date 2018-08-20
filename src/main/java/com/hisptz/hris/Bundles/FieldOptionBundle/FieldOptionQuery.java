package com.hisptz.hris.Bundles.FieldOptionBundle;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.hisptz.hris.Bundles.FieldBundle.Field;
import com.hisptz.hris.core.Model.ModelQuery;
import com.hisptz.hris.core.Model.ModelSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Guest on 8/13/18.
 */
@Component
public class FieldOptionQuery extends ModelQuery<FieldOption>{
    @Autowired
    protected FieldOptionRepository fieldOptionRepository;

    private ModelSpecification<FieldOption> spec;

    public FieldOptionQuery(FieldOptionRepository fieldOptionRepository) {
        this.fieldOptionRepository = fieldOptionRepository;
    }

    public List<FieldOption> fieldOptions(){
        return fieldOptionRepository.findAll();
    }

    public FieldOption getFieldOptionById(Long id){
        return fieldOptionRepository.findOne(id);
    }

    public List<FieldOption> queryFieldOptions(String where){
        return query(where, spec, fieldOptionRepository);
    }
}
