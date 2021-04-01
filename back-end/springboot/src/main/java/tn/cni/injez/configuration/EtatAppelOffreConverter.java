package tn.cni.injez.configuration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import tn.cni.injez.model.EtatAppelOffre;

@Converter(autoApply=true)
public class EtatAppelOffreConverter implements AttributeConverter<EtatAppelOffre, String> {

    @Override
    public String convertToDatabaseColumn(EtatAppelOffre etatAppelOffre) {
    	 if (etatAppelOffre == null)
             return null;
  
         switch (etatAppelOffre) {
         case جارية:
             return "جارية";
  
         case ملغاة:
             return "ملغاة";
  
         case موافَق_عليها:
             return "موافَق عليها";
  
         
  
         default:
        	 return "it works fine";
         }
    }

    @Override
    public EtatAppelOffre convertToEntityAttribute(String dbData) {
    	   if (dbData == null)
               return null;
    
           switch (dbData) {
           case "جارية":
               return EtatAppelOffre.جارية;
    
           case "ملغاة":
               return EtatAppelOffre.ملغاة;
    
           case "موافَق عليها":
               return EtatAppelOffre.موافَق_عليها;
    
          
    
           default:
        	   return EtatAppelOffre.جارية;
           }
       }
}