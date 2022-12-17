/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smk1.web;

import edu.iit.sat.itmd4515.smk1.domain.Parent;
import edu.iit.sat.itmd4515.smk1.resources.service.ParentService;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Sumanth M K
 */
@FacesConverter(value="parentConverter", managed=true)
public class ParentConvertor implements Converter<Parent> {

    @EJB
    ParentService psvc;
    
    /**
     *
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public Parent getAsObject(FacesContext context, UIComponent component, String value) {
        
        if(value==null || value.isEmpty()) return null;
        
        return psvc.read(Long.valueOf(value));
    }

    /**
     *
     * @param context
     * @param component
     * @param value
     * @return
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Parent value) {
       
        if(value==null) return "";
        
        return String.valueOf(value.getId());
    }
    
}
