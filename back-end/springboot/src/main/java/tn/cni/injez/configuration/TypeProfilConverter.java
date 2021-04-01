package tn.cni.injez.configuration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import tn.cni.injez.model.TypeProfil;

@Converter(autoApply=true)
public class TypeProfilConverter implements AttributeConverter<TypeProfil, String> {

    @Override
    public String convertToDatabaseColumn(TypeProfil typeProfil) {
    	 if (typeProfil == null)
             return null;
  
         switch (typeProfil) {
         case جميع_الصلاحيات:
             return "جميع الصلاحيات";
  
         case تمويل:
             return "تمويل";
  
         case تقسيم:
             return "تقسيم";
             
         case طلبات_العروض_و_صفقات_و_فواتير:
             return "طلبات العروض و صفقات و فواتير";
  
  
         case أهداف_و_مؤشرات:
             return "أهداف ومؤشرات";
             
         case إحصائيات:
             return "إحصائيات";
  
         
  
         default:
        	 return "it works fine";
         }
    }

    @Override
    public TypeProfil convertToEntityAttribute(String dbData) {
    	   if (dbData == null)
               return null;
    
           switch (dbData) {
           case "جميع الصلاحيات":
               return TypeProfil.جميع_الصلاحيات;
    
           case "تمويل":
               return TypeProfil.تمويل;
    
           case "تقسيم":
               return TypeProfil.تقسيم;
               
           case "طلبات العروض و صفقات و فواتير":
               return TypeProfil.طلبات_العروض_و_صفقات_و_فواتير;
    
    
           case "أهداف ومؤشرات":
               return TypeProfil.أهداف_و_مؤشرات;
           case "إحصائيات":
               return TypeProfil.إحصائيات;
    
          
    
           default:
        	   return TypeProfil.إحصائيات;
           }
       }
}