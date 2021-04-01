package tn.cni.injez.configuration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import tn.cni.injez.model.Gouvernorat;

@Converter(autoApply=true)
public class GouvernoratConverter implements AttributeConverter<Gouvernorat, String> {

    @Override
    public String convertToDatabaseColumn(Gouvernorat gouvernorat) {
    	 if (gouvernorat == null)
             return null;
  
         switch (gouvernorat) {
         case أريانة :
        	 return "أريانة";
         case باجة :
        	 return "باجة";
         case بن_عروس :
        	 return "بن عروس";
         case بنزرت :
        	 return "بنزرت";
         case قابس :
        	 return "قابس";
         case قفصة :
        	 return "قفصة";
         case جندوبة :
        	 return "جندوبة";
         case القيروان :
        	 return "القيروان";
         case القصرين :
        	 return "القصرين";
         case قبلي :
        	 return "قبلي";
         case الكاف :
        	 return "الكاف";
         case المهدية :
        	 return "المهدية";
         case منوبة :
        	 return "منوبة";
         case مدنين :
        	 return "مدنين";
         case المنستير :
        	 return "المنستير";
         case نابل :
        	 return "نابل";
         case صفاقس :
        	 return "صفاقس";
         case سيدي_بوزيد :
        	 return "سيدي بوزيد";
         case سليانة :
        	 return "سليانة";
         case سوسة :
        	 return "سوسة";
         case تطاوين :
        	 return "تطاوين";
         case توزر :
        	 return "توزر";
         case تونس :
        	 return "تونس";
         case زغوان :
        	 return "زغوان";
  
         default:
        	 return "it works fine";
         }
    }

    @Override
    public Gouvernorat convertToEntityAttribute(String dbData) {
    	   if (dbData == null)
               return null;
    
           switch (dbData) {
           case "أريانة":
        	   return Gouvernorat.أريانة;
           case "باجة":
        	   return Gouvernorat.باجة;
           case "بن عروس":
        	   return Gouvernorat.بن_عروس;
           case "بنزرت":
        	   return Gouvernorat.بنزرت;
           case "قابس":
        	   return Gouvernorat.قابس;
           case "قفصة":
        	   return Gouvernorat.قفصة;
           case "جندوبة":
        	   return Gouvernorat.جندوبة;
           case "القيروان":
        	   return Gouvernorat.القيروان;
           case "القصرين":
        	   return Gouvernorat.القصرين;
           case "قبلي":
        	   return Gouvernorat.قبلي;
           case "الكاف":
        	   return Gouvernorat.الكاف;
           case "المهدية":
        	   return Gouvernorat.المهدية;
           case "منوبة":
        	   return Gouvernorat.منوبة;
           case "مدنين":
        	   return Gouvernorat.مدنين;
           case "المنستير":
        	   return Gouvernorat.المنستير;
           case "نابل":
        	   return Gouvernorat.نابل;
           case "صفاقس":
        	   return Gouvernorat.صفاقس;
           case "سيدي بوزيد":
        	   return Gouvernorat.سيدي_بوزيد;
           case "سليانة":
        	   return Gouvernorat.سليانة;
           case "سوسة":
        	   return Gouvernorat.سوسة;
           case "تطاوين":
        	   return Gouvernorat.تطاوين;
           case "توزر":
        	   return Gouvernorat.توزر;
           case "تونس":
        	   return Gouvernorat.تونس;
           case "زغوان":
        	   return Gouvernorat.زغوان;
    
          
    
           default:
        	   return Gouvernorat.تونس;
           }
       }
}