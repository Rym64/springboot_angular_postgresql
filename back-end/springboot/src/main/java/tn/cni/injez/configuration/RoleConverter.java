package tn.cni.injez.configuration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import tn.cni.injez.model.Role;

@Converter(autoApply=true)
public class RoleConverter implements AttributeConverter<Role, String> {

    @Override
    public String convertToDatabaseColumn(Role role) {
    	 if (role == null)
             return null;
  
         switch (role) {
         case مستخدم:
             return "مستخدم";
  
         case مُشْرِف:
             return "مُشْرِف";
  
         case مُشْرِف_بالمركز_الوطني_للإعلامية:
             return "مُشْرِف بالمركز الوطني للإعلامية";
  
         
  
         default:
        	 return "it works fine";
         }
    }

    @Override
    public Role convertToEntityAttribute(String dbData) {
    	   if (dbData == null)
               return null;
    
           switch (dbData) {
           case "مستخدم":
               return Role.مستخدم;
    
           case "مُشْرِف":
               return Role.مُشْرِف;
    
           case "مُشْرِف بالمركز الوطني للإعلامية":
               return Role.مُشْرِف_بالمركز_الوطني_للإعلامية;
    
          
    
           default:
        	   return Role.مستخدم;
           }
       }
}