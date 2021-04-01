package tn.cni.injez.configuration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import tn.cni.injez.model.TypeLotAppelOffre;

@Converter(autoApply=true)
public class TypeLotConverter implements AttributeConverter<TypeLotAppelOffre, String> {

    @Override
    public String convertToDatabaseColumn(TypeLotAppelOffre typeLot) {
    	 if (typeLot == null)
             return null;
  
         switch (typeLot) {
         case تمويل_مشروع:
             return "تمويل مشروع";
  
         case تنفيذ_مشروع:
             return "تنفيذ مشروع";
  
         case دراسة_مشروع:
             return "دراسة مشروع";
  
         
  
         default:
        	 return "it works fine";
         }
    }

    @Override
    public TypeLotAppelOffre convertToEntityAttribute(String dbData) {
    	   if (dbData == null)
               return null;
    
           switch (dbData) {
           case "تمويل مشروع":
               return TypeLotAppelOffre.تمويل_مشروع;
    
           case "تنفيذ مشروع":
               return TypeLotAppelOffre.تنفيذ_مشروع;
    
           case "دراسة مشروع":
               return TypeLotAppelOffre.دراسة_مشروع;
    
          
    
           default:
        	   return TypeLotAppelOffre.دراسة_مشروع;
           }
       }
}