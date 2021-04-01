package tn.cni.injez.configuration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import tn.cni.injez.model.Financeur;

@Converter(autoApply=true)
public class FinanceurConverter implements AttributeConverter<Financeur, String> {

    @Override
    public String convertToDatabaseColumn(Financeur financeur) {
    	 if (financeur == null)
             return null;
  
         switch (financeur) {
         case رجال_أعمال_أجانب:
             return "رجال أعمال أجانب";
  
         case بنوك_أجنبية:
             return "بنوك أجنبية";
  
         case جمعيات_أجنبية:
             return "جمعيات أجنبية";
  
         
  
         default:
        	 return "it works fine";
         }
    }

    @Override
    public Financeur convertToEntityAttribute(String dbData) {
    	   if (dbData == null)
               return null;
    
           switch (dbData) {
           case "رجال أعمال أجانب":
               return Financeur.رجال_أعمال_أجانب;
    
           case "بنوك أجنبية":
               return Financeur.بنوك_أجنبية;
    
           case "جمعيات أجنبية":
               return Financeur.جمعيات_أجنبية;
    
          
    
           default:
        	   return Financeur.بنوك_أجنبية;
           }
       }
}