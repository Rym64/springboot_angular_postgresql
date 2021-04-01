package tn.cni.injez.configuration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import tn.cni.injez.model.Devise;

@Converter(autoApply=true)
public class DeviseConverter implements AttributeConverter<Devise, String> {

    @Override
    public String convertToDatabaseColumn(Devise devise) {
    	 if (devise == null)
             return null;
  
         switch (devise) {
         case بوليفاريو_بوليفي:
        	 return "بوليفاريو بوليفي";
         case أرياري_مدغشقري:
        	 return "أرياري مدغشقري";
         case الجنيه_الإسترليني:
        	 return "الجنيه الإسترليني";
         case اليورو:
        	 return "اليورو";
         case أوقية_موريتانية:
        	 return "أوقية موريتانية";
         case بات_تايلاندي:
        	 return "بات تايلاندي";
         case بوليفار_فنزويلي:
        	 return "بوليفار فنزويلي";
         case بير_إثيوبي:
        	 return "بير إثيوبي";
         case توغروغ_منغولي:
        	 return "توغروغ منغولي";
         case تينغ_كازاخستاني:
        	 return "تينغ كازاخستاني";
         case جنيه_سوداني:
        	 return "جنيه سوداني";
         case جنيه_مصري:
        	 return "جنيه مصري";
         case درام_أرميني:
        	 return "درام أرميني";
         case درهم_إماراتي:
        	 return "درهم إماراتي";
         case درهم_مغربي:
        	 return "درهم مغربي";
         case دولار_أسترالي:
        	 return "دولار أسترالي";
         case دولار_أمريكي:
        	 return "دولار أمريكي";
         case دولار_تايواني:
        	 return "دولار تايواني";
         case دولار_جامايكي:
        	 return "دولار جامايكي";
         case دولار_سنغافوري:
        	 return "دولار سنغافوري";
         case دولار_كندي:
        	 return "دولار كندي";
         case دولار_نيوزيلندي:
        	 return "دولار نيوزيلندي";
         case دونغ_فيتنامي:
        	 return "دونغ فيتنامي";
         case دينار_أردني:
        	 return "دينار أردني";
         case دينار_بحريني:
        	 return "دينار بحريني";
         case دينار_تونسي:
        	 return "دينار تونسي";
         case دينار_جزائري:
        	 return "دينار جزائري";
         case دينار_صربي:
        	 return "دينار صربي";
         case دينار_عراقي:
        	 return "دينار عراقي";
         case دينار_كويتي:
        	 return "دينار كويتي";
         case دينار_ليبي:
        	 return "دينار ليبي";
         case دينار_مقدوني:
        	 return "دينار مقدوني";
         case راند_جنوب_أفريقي:
        	 return "راند جنوب أفريقي";
         case روبل_بلاروسي:
        	 return "روبل بلاروسي";
         case روبل_روسي:
        	 return "روبل روسي";
         case روبية_إندونيسية:
        	 return "روبية إندونيسية";
         case روبية_باكستانية:
        	 return "روبية باكستانية";
         case روبية_سريلانكي:
        	 return "روبية سريلانكي";
         case روبية_سيشلية:
        	 return "روبية سيشلية";
         case روبية_هندية:
        	 return "روبية هندية";
         case ريال_إيراني:
        	 return "ريال إيراني";
         case ريال_برازيلي:
        	 return "ريال برازيلي";
         case ريال_سعودي:
        	 return "ريال سعودي";
         case ريال_عماني:
        	 return "ريال عماني";
         case ريال_قطري:
        	 return "ريال قطري";
         case ريال_يمني:
        	 return "ريال يمني";
         case رينغيت_ماليزي:
        	 return "رينغيت ماليزي";
         case سول_بيروفي:
        	 return "سول بيروفي";
         case سوم_أوزبكستاني:
        	 return "سوم أوزبكستاني";
         case شلن_صومالي:
        	 return "شلن صومالي";
         case شيلينغ_أوغندي:
        	 return "شيلينغ أوغندي";
         case شيلينغ_تانزاني:
        	 return "شيلينغ تانزاني";
         case غواراني_باراغواني:
        	 return "غواراني باراغواني";
         case فرنك_بوروندي:
        	 return "فرنك بوروندي";
         case فرنك_جيبوتي:
        	 return "فرنك جيبوتي";
         case فرنك_رواندي:
        	 return "فرنك رواندي";
         case فرنك_سويسري:
        	 return "فرنك سويسري";
         case فرنك_غرب_أفريقي:
        	 return "فرنك غرب أفريقي";
         case فرنك_غيني:
        	 return "فرنك غيني";
         case فرنك_كونغولي:
        	 return "فرنك كونغولي";
         case فرنك_وسط_أفريقي:
        	 return "فرنك وسط أفريقي";
         case فورنت_مجري:
        	 return "فورنت مجري";
         case كوانزا_أنغولي:
        	 return "كوانزا أنغولي";
         case كيات_ميانماري:
        	 return "كيات ميانماري";
         case لاري_جورجي:
        	 return "لاري جورجي";
         case ليرة_تركية:
        	 return "ليرة تركية";
         case ليرة_سورية:
        	 return "ليرة سورية";
         case ليرة_لبنانية:
        	 return "ليرة لبنانية";
         case ليف_بلغاري:
        	 return "ليف بلغاري";
         case ليو_روماني:
        	 return "ليو روماني";
         case ليون_سيراليوني:
        	 return "ليون سيراليوني";
         case مانات_أذربيجاني:
        	 return "مانات أذربيجاني";
         case هريفينا_أوكرانية:
        	 return "هريفينا أوكرانية";
         case وون_كوري_جنوبي:
        	 return "وون كوري جنوبي";
         case ين_ياباني:
        	 return "ين ياباني";
         case يوان_صيني:
        	 return "يوان صيني";

  
         
  
         default:
        	 return "it works fine";
         }
    }

    @Override
    public Devise convertToEntityAttribute(String dbData) {
    	   if (dbData == null)
               return null;
    
           switch (dbData) {
           case "بوليفاريو بوليفي":
              return Devise.بوليفاريو_بوليفي;
           case "أرياري مدغشقري":
        	   return Devise.أرياري_مدغشقري;
           case "الجنيه الإسترليني":
        	   return Devise.الجنيه_الإسترليني;
           case "اليورو":
        	   return Devise.اليورو;
           case "أوقية موريتانية":
        	   return Devise.أوقية_موريتانية;
           case "بات تايلاندي":
        	   return Devise.بات_تايلاندي;
           case "بوليفار فنزويلي":
        	   return Devise.بوليفار_فنزويلي;
           case "بير إثيوبي":
        	   return Devise.بير_إثيوبي;
           case "توغروغ منغولي":
        	   return Devise.توغروغ_منغولي;
           case "تينغ كازاخستاني":
        	   return Devise.تينغ_كازاخستاني;
           case "جنيه سوداني":
        	   return Devise.جنيه_سوداني;
           case "جنيه مصري":
        	   return Devise.جنيه_مصري;
           case "درام أرميني":
        	   return Devise.درام_أرميني;
           case "درهم إماراتي":
        	   return Devise.درهم_إماراتي;
           case "درهم مغربي":
        	   return Devise.درهم_مغربي;
           case "دولار أسترالي":
        	   return Devise.دولار_أسترالي;
           case "دولار أمريكي":
        	   return Devise.دولار_أمريكي;
           case "دولار تايواني":
        	   return Devise.دولار_تايواني;
           case "دولار جامايكي":
        	   return Devise.دولار_جامايكي;
           case "دولار سنغافوري":
        	   return Devise.دولار_سنغافوري;
           case "دولار كندي":
        	   return Devise.دولار_كندي;
           case "دولار نيوزيلندي":
        	   return Devise.دولار_نيوزيلندي;
           case "دونغ فيتنامي":
        	   return Devise.دونغ_فيتنامي;
           case "دينار أردني":
        	   return Devise.دينار_أردني;
           case "دينار بحريني":
        	   return Devise.دينار_بحريني;
           case "دينار تونسي":
        	   return Devise.دينار_تونسي;
           case "دينار جزائري":
        	   return Devise.دينار_جزائري;
           case "دينار صربي":
        	   return Devise.دينار_صربي;
           case "دينار عراقي":
        	   return Devise.دينار_عراقي;
           case "دينار كويتي":
        	   return Devise.دينار_كويتي;
           case "دينار ليبي":
        	   return Devise.دينار_ليبي;
           case "دينار مقدوني":
        	   return Devise.دينار_مقدوني;
           case "راند جنوب أفريقي":
        	   return Devise.راند_جنوب_أفريقي;
           case "روبل بلاروسي":
        	   return Devise.روبل_بلاروسي;
           case "روبل روسي":
        	   return Devise.روبل_روسي;
           case "روبية إندونيسية":
        	   return Devise.روبية_إندونيسية;
           case "روبية باكستانية":
        	   return Devise.روبية_باكستانية;
           case "روبية سريلانكي":
        	   return Devise.روبية_سريلانكي;
           case "روبية سيشلية":
        	   return Devise.روبية_سيشلية;
           case "روبية هندية":
        	   return Devise.روبية_هندية;
           case "ريال إيراني":
        	   return Devise.ريال_إيراني;
           case "ريال برازيلي":
        	   return Devise.ريال_برازيلي;
           case "ريال سعودي":
        	   return Devise.ريال_سعودي;
           case "ريال عماني":
        	   return Devise.ريال_عماني;
           case "ريال قطري":
        	   return Devise.ريال_قطري;
           case "ريال يمني":
        	   return Devise.ريال_يمني;
           case "رينغيت ماليزي":
        	   return Devise.رينغيت_ماليزي;
           case "سول بيروفي":
        	   return Devise.سول_بيروفي;
           case "سوم أوزبكستاني":
        	   return Devise.سوم_أوزبكستاني;
           case "شلن صومالي":
        	   return Devise.شلن_صومالي;
           case "شيلينغ أوغندي":
        	   return Devise.شيلينغ_أوغندي;
           case "شيلينغ تانزاني":
        	   return Devise.شيلينغ_تانزاني;
           case "غواراني باراغواني":
        	   return Devise.غواراني_باراغواني;
           case "فرنك بوروندي":
        	   return Devise.فرنك_بوروندي;
           case "فرنك جيبوتي":
        	   return Devise.فرنك_جيبوتي;
           case "فرنك رواندي":
        	   return Devise.فرنك_رواندي;
           case "فرنك سويسري":
        	   return Devise.فرنك_سويسري;
           case "فرنك غرب أفريقي":
        	   return Devise.فرنك_غرب_أفريقي;
           case "فرنك غيني":
        	   return Devise.فرنك_غيني;
           case "فرنك كونغولي":
        	   return Devise.فرنك_كونغولي;
           case "فرنك وسط أفريقي":
        	   return Devise.فرنك_وسط_أفريقي;
           case "فورنت مجري":
        	   return Devise.فورنت_مجري;
           case "كوانزا أنغولي":
        	   return Devise.كوانزا_أنغولي;
           case "كيات ميانماري":
        	   return Devise.كيات_ميانماري;
           case "لاري جورجي":
        	   return Devise.لاري_جورجي;
           case "ليرة تركية":
        	   return Devise.ليرة_تركية;
           case "ليرة سورية":
        	   return Devise.ليرة_سورية;
           case "ليرة لبنانية":
        	   return Devise.ليرة_لبنانية;
           case "ليف بلغاري":
        	   return Devise.ليف_بلغاري;
           case "ليو روماني":
        	   return Devise.ليو_روماني;
           case "ليون سيراليوني":
        	   return Devise.ليون_سيراليوني;
           case "مانات أذربيجاني":
        	   return Devise.مانات_أذربيجاني;
           case "هريفينا أوكرانية":
        	   return Devise.هريفينا_أوكرانية;
           case "وون كوري جنوبي":
        	   return Devise.وون_كوري_جنوبي;
           case "ين ياباني":
        	   return Devise.ين_ياباني;
           case "يوان صيني":
        	   return Devise.يوان_صيني;
    
           default:
               return Devise.دينار_تونسي;
           }
           
       }
}