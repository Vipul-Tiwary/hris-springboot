package com.hisptz.hris.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.hisptz.hris.Bundles.FieldBundle.Field;
import com.hisptz.hris.Bundles.FieldBundle.FieldRepository;
import com.hisptz.hris.Bundles.UserBundle.User;
import com.hisptz.hris.Bundles.UserBundle.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Guest on 8/7/18.
 */
@Component
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FieldRepository fieldRepository;

    public Mutation(UserRepository userRepository, FieldRepository fieldRepository) {
        this.userRepository = userRepository;
        this.fieldRepository = fieldRepository;
    }

    /**
     *TODO: Optimize using Aspect Oriented Programming
     */

    /**
     *  User Mutations
     */
    public User newUser(Integer organisationunitId, String username, String usernameCanonical, String email, String emailCanonical, Boolean enabled, String salt, String password, Boolean locked, Boolean expired, Date expiresAt, String confirmationToken, Date passwordRequestedAt, String roles, Boolean credentialsExpired, Date credentialsExpireAt, String uid, String phonenumber, String jobtitle, String firstname, String middlename, String surname, Date deletedat, String description) {
       User user = new User(organisationunitId, username, usernameCanonical, email, emailCanonical, enabled, salt, password, locked, expired, expiresAt, confirmationToken, passwordRequestedAt, roles, credentialsExpired, credentialsExpireAt,  uid, phonenumber,  jobtitle, firstname, middlename, surname, deletedat, description);

        userRepository.save(user);
        return user;
    }

    public Boolean deleteUser(Long id){
        userRepository.delete(userRepository.findOne(id));
        return true;
    }

    public User updateUser(Long id, Integer organisationunitId, String username, String usernameCanonical, String email, String emailCanonical, Boolean enabled, String salt, String password, Boolean locked, Boolean expired, Date expiresAt, String confirmationToken, Date passwordRequestedAt, String roles, Boolean credentialsExpired, Date credentialsExpireAt, String uid, String phonenumber, String jobtitle, String firstname, String middlename, String surname, Date deletedat, String description){
        User user = userRepository.findOne(id);

        /**
         * TODO: Optimize using the State Pattern
         */
        if(organisationunitId != null)
            user.setOrganisationunitId(organisationunitId);

        
        if(username != null)
            user.setUsername(username);

        
        if (usernameCanonical != null)
            user.setUsernameCanonical(usernameCanonical);

        
        if (email != null)
            user.setEmail(email);

        
        if(emailCanonical != null)
            user.setEmailCanonical(emailCanonical);

        
        if(enabled != null)
            user.setEnabled(enabled);

        
        if(salt != null)
            user.setSalt(salt);

        
        if(password != null)
            user.setPassword(password);

        
        if(locked != null)
            user.setLocked(locked);

        if(expired != null)
            user.setExpired(expired);

        if(expiresAt != null)
            user.setExpiresAt(expiresAt);

        if(confirmationToken != null)
            user.setConfirmationToken(confirmationToken);

        if(passwordRequestedAt != null)
            user.setPasswordRequestedAt(passwordRequestedAt);

        if(roles != null)
            user.setRoles(roles);

        if(credentialsExpired != null)
            user.setCredentialsExpired(credentialsExpired);

        if (credentialsExpireAt != null)
            user.setCredentialsExpireAt(credentialsExpireAt);

        if(uid != null)
            user.setUid(uid);

        if(phonenumber != null)
             user.setPhonenumber(phonenumber);

        if(jobtitle != null)
            user.setJobtitle(jobtitle);

        if(firstname != null)
            user.setFirstname(firstname);

        if(middlename != null)
         user.setMiddlename(middlename);

        if(surname != null)
            user.setSurname(surname);

        if(deletedat != null)
            user.setDeletedat(deletedat);

        if(description != null)
            user.setDescription(description);

        userRepository.save(user);
        return user;
    }


    /**
     *  Field Mutations
     */
    public Field newField(Integer datatypeId, Integer inputtypeId, String uid, String name, String caption, Boolean compulsory, Boolean isunique, Boolean iscalculated, String description, String calculatedexpression, Boolean hashistory, Boolean hastarget, Boolean fieldrelation, Boolean skipinreport) {
        Field field = new Field(datatypeId, inputtypeId, uid, name, caption, compulsory, isunique, iscalculated, description,  calculatedexpression, hashistory, hastarget, fieldrelation, skipinreport);

        fieldRepository.save(field);
        return field;
    }

    public Boolean deleteField(Long id){
        fieldRepository.delete(fieldRepository.findOne(id));
        return true;
    }

    public Field updateField(Long id, Integer datatypeId, Integer inputtypeId, String uid, String name, String caption, Boolean compulsory, Boolean isunique, Boolean iscalculated, String description, String calculatedexpression, Boolean hashistory, Boolean hastarget, Boolean fieldrelation, Boolean skipinreport) {
        Field field = fieldRepository.findOne(id);

        if(datatypeId != null)
            field.setDatatypeId(datatypeId);

        if (inputtypeId != null)
            field.setInputtypeId(inputtypeId);

        if (uid != null)
            field.setUid(uid);

        if (name != null)
            field.setName(name);

        if (caption != null)
            field.setCaption(name);

        if (compulsory != null)
            field.setCompulsory(compulsory);

        if (isunique != null)
            field.setIsunique(isunique);

        if (iscalculated != null)
            field.setIscalculated(iscalculated);

        if (description != null)
            field.setDescription(description);

        if (calculatedexpression != null)
            field.setCalculatedexpression(calculatedexpression);

        if (hashistory != null)
            field.setHashistory(hashistory);

        if (hastarget != null)
            field.setHastarget(hastarget);

        if (fieldrelation != null)
            field.setFieldrelation(fieldrelation);

        if (skipinreport != null)
            field.setSkipinreport(skipinreport);

        fieldRepository.save(field);
        return field;
    }

}
