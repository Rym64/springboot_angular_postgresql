package tn.cni.injez.configuration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import tn.cni.injez.model.Pays;

@Converter(autoApply=true)
public class PaysConverter implements AttributeConverter<Pays, String> {

    @Override
    public String convertToDatabaseColumn(Pays pays) {
    	 if (pays == null)
             return null;
  
         switch (pays) {
         case أفغانستان :
        	 return "أفغانستان";
         case ألبانيا :
        	 return "ألبانيا";
         case الجزائر :
        	 return "الجزائر";
         case أندورا :
        	 return "أندورا";
         case أنغولا :
        	 return "أنغولا";
         case الأرجنتين :
        	 return "الأرجنتين";
         case أرمينيا :
        	 return "أرمينيا";
          case أستراليا :
        	 return "أستراليا";
          case النمسا :
        	 return "النمسا";
          case أذربيجان :
        	 return "أذربيجان";
          case البحرين :
        	 return "البحرين";
          case بنغلاديش :
        	 return "بنغلاديش";
          case بيلاروسيا :
        	 return "بيلاروسيا";
          case بلجيكا :
        	 return "بلجيكا";
          case بوليفيا :
        	 return "بوليفيا";
          case بوتسوانا :
        	 return "بوتسوانا";
          case البرازيل :
        	 return "البرازيل";
          case بروناي :
        	 return "بروناي";
          case بلغاريا :
        	 return "بلغاريا";
          case بوروندي :
        	 return "بوروندي";
          case كمبوديا :
        	 return "كمبوديا";
          case الكاميرون :
        	 return "الكاميرون";
          case كندا :
        	 return "كندا";
          case تشاد :
        	 return "تشاد";
          case تشيلي :
        	 return "تشيلي";
          case الصين :
        	 return "الصين";
          case كولومبيا :
        	 return "كولومبيا";
          case الكونغو :
        	 return "الكونغو";
          case كوستاريكا :
        	 return "كوستاريكا";
          case كرواتيا :
        	 return "كرواتيا";
          case كوبا :
        	 return "كوبا";
          case قبرص :
        	 return "قبرص";
          case التشيك :
        	 return "التشيك";
          case الدنمارك :
        	 return "الدنمارك";
          case جيبوتي :
        	 return "جيبوتي";
          case إكوادور :
        	 return "إكوادور";
          case مصر :
        	 return "مصر";
          case السلفادور :
        	 return "السلفادور";
          case إريتريا :
        	 return "إريتريا";
          case إستونيا :
        	 return "إستونيا";
          case إثيوبيا :
        	 return "إثيوبيا";
          case فنلندا :
        	 return "فنلندا";
          case فرنسا :
        	 return "فرنسا";
          case غامبيا :
        	 return "غامبيا";
          case جورجيا :
        	 return "جورجيا";
          case ألمانيا :
        	 return "ألمانيا";
          case غانا :
        	 return "غانا";
          case اليونان :
        	 return "اليونان";
          case غينيا :
        	 return "غينيا";
          case هايتي :
        	 return "هايتي";
          case هندوراس :
        	 return "هندوراس";
          case المجر :
        	 return "المجر";
          case أيسلندا :
        	 return "أيسلندا";
          case الهند :
        	 return "الهند";
          case إندونيسيا :
        	 return "إندونيسيا";
          case إيران :
        	 return "إيران";
          case العراق :
        	 return "العراق"; 
          case إيطاليا :
        	 return "إيطاليا";
          case جامايكا :
        	 return "جامايكا";
          case اليابان :
        	 return "اليابان";
          case الأردن :
        	 return "الأردن";
          case كازاخستان :
        	 return "كازاخستان";
          case كينيا :
        	 return "كينيا";
          case كوريا_الجنوبية :
        	 return "كوريا الجنوبية";
          case كوسوفو :
        	 return "كوسوفو";
          case الكويت :
        	 return "الكويت";
          case لاتفيا :
        	 return "لاتفيا";
          case لبنان :
        	 return "لبنان";
          case ليبيا :
        	 return "ليبيا";
          case ليتوانيا :
        	 return "ليتوانيا";
          case لوكسمبورغ :
        	 return "لوكسمبورغ";
          case مقدونيا :
        	 return "مقدونيا";
          case مدغشقر :
        	 return "مدغشقر";
          case ماليزيا :
        	 return "ماليزيا";
          case مالي :
        	 return "مالي";
          case مالطا :
        	 return "مالطا";
          case موريتانيا :
        	 return "موريتانيا";
          case المكسيك :
        	 return "المكسيك";
          case موناكو :
        	 return "موناكو";
          case منغوليا :
        	 return "منغوليا";
          case المغرب :
        	 return "المغرب";
          case موزمبيق :
        	 return "موزمبيق";
          case ميانمار :
        	 return "ميانمار";
          case ناميبيا :
        	 return "ناميبيا";
          case نيبال :
        	 return "نيبال";
          case هولندا :
        	 return "هولندا";
          case نيوزيلندا :
        	 return "نيوزيلندا";
          case نيجيريا :
        	 return "نيجيريا";
          case النرويج :
        	 return "النرويج";
          case عمان :
        	 return "عمان";
          case باكستان :
        	 return "باكستان";
          case بنما :
        	 return "بنما";
          case باراغواي :
        	 return "باراغواي";
          case بيرو :
        	 return "بيرو";
          case الفلبين :
        	 return "الفلبين";
          case بولندا :
        	 return "بولندا";
          case البرتغال :
        	 return "البرتغال";
          case قطر :
        	 return "قطر";
          case رومانيا :
        	 return "رومانيا";
          case روسيا :
        	 return "روسيا";
          case فلسطين :
        	 return "فلسطين";
          case رواندا :
        	 return "رواندا";
          case السعودية :
        	 return "السعودية";
          case السنغال :
        	 return "السنغال";
          case صربيا :
        	 return "صربيا";
          case سيشيل :
        	 return "سيشيل";
          case سيراليون :
        	 return "سيراليون";
          case سنغافورة :
        	 return "سنغافورة";
          case سلوفاكيا :
        	 return "سلوفاكيا";
          case سلوفينيا :
        	 return "سلوفينيا";
          case الصومال :
        	 return "الصومال";
          case جنوب_إفريقيا :
        	 return "جنوب إفريقيا";
          case إسبانيا :
        	 return "إسبانيا";
          case سريلانكا :
        	 return "سريلانكا";
          case السودان :
        	 return "السودان";
          case سوازيلاند :
        	 return "سوازيلاند";
          case السويد :
        	 return "السويد";
          case سويسرا :
        	 return "سويسرا";
          case سوريا :
        	 return "سوريا";
          case تايوان :
        	 return "تايوان";
          case طاجيكستان :
        	 return "طاجيكستان";
          case تنزانيا :
        	 return "تنزانيا";
          case تايلاند :
        	 return "تايلاند";
          case توغو :
        	 return "توغو";
          case تونس :
        	 return "تونس";
          case تركيا :
        	 return "تركيا";
          case تركمانستان :
        	 return "تركمانستان";
          case أوغندا :
        	 return "أوغندا";
          case أوكرانيا :
        	 return "أوكرانيا";
          case الإمارات :
        	 return "الإمارات";
          case بريطانيا :
        	 return "بريطانيا";
          case الولايات_المتحدة_الأمريكية :
        	 return "الولايات المتحدة الأمريكية";
          case أوروغواي :
        	 return "أوروغواي";
          case أوزبكستان :
        	 return "أوزبكستان";
          case فنزويلا :
        	 return "فنزويلا";
          case فيتنام :
        	 return "فيتنام";
          case اليمن :
        	 return "اليمن";
  
         default:
        	 return "it works fine";
         }
    }

    @Override
    public Pays convertToEntityAttribute(String dbData) {
    	   if (dbData == null)
               return null;
    
           switch (dbData) {
           case "أفغانستان":
        	   return Pays.أفغانستان;
           case "ألبانيا":
        	   return Pays.ألبانيا;
           case "الجزائر":
        	   return Pays.الجزائر;
           case "أندورا":
        	   return Pays.أندورا;
           case "أنغولا":
        	   return Pays.أنغولا;
           case "الأرجنتين":
        	   return Pays.الأرجنتين;
           case "أرمينيا":
        	   return Pays.أرمينيا;
           case "أستراليا":
        	   return Pays.أستراليا;
           case "النمسا":
        	   return Pays.النمسا;
           case "أذربيجان":
        	   return Pays.أذربيجان;
           case "البحرين":
        	   return Pays.البحرين;
           case "بنغلاديش":
        	   return Pays.بنغلاديش;
           case "بيلاروسيا":
        	   return Pays.بيلاروسيا;
           case "بلجيكا":
        	   return Pays.بلجيكا;
           case "بوليفيا":
        	   return Pays.بوليفيا;
           case "بوتسوانا":
        	   return Pays.بوتسوانا;
           case "البرازيل":
        	   return Pays.البرازيل;
           case "بروناي":
        	   return Pays.بروناي;
           case "بلغاريا":
        	   return Pays.بلغاريا;
           case "بوروندي":
        	   return Pays.بوروندي;
           case "كمبوديا":
        	   return Pays.كمبوديا;
           case "الكاميرون":
        	   return Pays.الكاميرون;
           case "كندا":
        	   return Pays.كندا;
           case "تشاد":
        	   return Pays.تشاد;
           case "تشيلي":
        	   return Pays.تشيلي;
           case "الصين":
        	   return Pays.الصين;
           case "كولومبيا":
        	   return Pays.كولومبيا;
           case "الكونغو":
        	   return Pays.الكونغو;
           case "كوستاريكا":
        	   return Pays.كوستاريكا;
           case "كرواتيا":
        	   return Pays.كرواتيا;
           case "كوبا":
        	   return Pays.كوبا;
           case "قبرص":
        	   return Pays.قبرص;
           case "التشيك":
        	   return Pays.التشيك;
           case "الدنمارك":
        	   return Pays.الدنمارك;
           case "جيبوتي":
        	   return Pays.جيبوتي;
           case "إكوادور":
        	   return Pays.إكوادور;
           case "مصر":
        	   return Pays.مصر;
           case "السلفادور":
        	   return Pays.السلفادور;
           case "إريتريا":
        	   return Pays.إريتريا;
           case "إستونيا":
        	   return Pays.إستونيا;
           case "إثيوبيا":
        	   return Pays.إثيوبيا;
           case "فنلندا":
        	   return Pays.فنلندا;
           case "فرنسا":
        	   return Pays.فرنسا;
           case "غامبيا":
        	   return Pays.غامبيا;
           case "جورجيا":
        	   return Pays.جورجيا;
           case "ألمانيا":
        	   return Pays.ألمانيا;
           case "غانا":
        	   return Pays.غانا;
           case "اليونان":
        	   return Pays.اليونان;
           case "غينيا":
        	   return Pays.غينيا;
           case "هايتي":
        	   return Pays.هايتي;
           case "هندوراس":
        	   return Pays.هندوراس;
           case "المجر":
        	   return Pays.المجر;
           case "أيسلندا":
        	   return Pays.أيسلندا;
           case "الهند":
        	   return Pays.الهند;
           case "إندونيسيا":
        	   return Pays.إندونيسيا;
           case "إيران":
        	   return Pays.إيران;
           case "العراق":
        	   return Pays.العراق; 
           case "إيطاليا":
        	   return Pays.إيطاليا;
           case "جامايكا":
        	   return Pays.جامايكا;
           case "اليابان":
        	   return Pays.اليابان;
           case "الأردن":
        	   return Pays.الأردن;
           case "كازاخستان":
        	   return Pays.كازاخستان;
           case "كينيا":
        	   return Pays.كينيا;
           case "كوريا الجنوبية":
        	   return Pays.كوريا_الجنوبية;
           case "كوسوفو":
        	   return Pays.كوسوفو;
           case "الكويت":
        	   return Pays.الكويت;
           case "لاتفيا":
        	   return Pays.لاتفيا;
           case "لبنان":
        	   return Pays.لبنان;
           case "ليبيا":
        	   return Pays.ليبيا;
           case "ليتوانيا":
        	   return Pays.ليتوانيا;
           case "لوكسمبورغ":
        	   return Pays.لوكسمبورغ;
           case "مقدونيا":
        	   return Pays.مقدونيا;
           case "مدغشقر":
        	   return Pays.مدغشقر;
           case "ماليزيا":
        	   return Pays.ماليزيا;
           case "مالي":
        	   return Pays.مالي;
           case "مالطا":
        	   return Pays.مالطا;
           case "موريتانيا":
        	   return Pays.موريتانيا;
           case "المكسيك":
        	   return Pays.المكسيك;
           case "موناكو":
        	   return Pays.موناكو;
           case "منغوليا":
        	   return Pays.منغوليا;
           case "المغرب":
        	   return Pays.المغرب;
           case "موزمبيق":
        	   return Pays.موزمبيق;
           case "ميانمار":
        	   return Pays.ميانمار;
           case "ناميبيا":
        	   return Pays.ناميبيا;
           case "نيبال":
        	   return Pays.نيبال;
           case "هولندا":
        	   return Pays.هولندا;
           case "نيوزيلندا":
        	   return Pays.نيوزيلندا;
           case "نيجيريا":
        	   return Pays.نيجيريا;
           case "النرويج":
        	   return Pays.النرويج;
           case "عمان":
        	   return Pays.عمان;
           case "باكستان":
        	   return Pays.باكستان;
           case "بنما":
        	   return Pays.بنما;
           case "باراغواي":
        	   return Pays.باراغواي;
           case "بيرو":
        	   return Pays.بيرو;
           case "الفلبين":
        	   return Pays.الفلبين;
           case "بولندا":
        	   return Pays.بولندا;
           case "البرتغال":
        	   return Pays.البرتغال;
           case "قطر":
        	   return Pays.قطر;
           case "رومانيا":
        	   return Pays.رومانيا;
           case "روسيا":
        	   return Pays.روسيا;
           case "فلسطين":
        	   return Pays.فلسطين;
           case "رواندا":
        	   return Pays.رواندا;
           case "السعودية":
        	   return Pays.السعودية;
           case "السنغال":
        	   return Pays.السنغال;
           case "صربيا":
        	   return Pays.صربيا;
           case "سيشيل":
        	   return Pays.سيشيل;
           case "سيراليون":
        	   return Pays.سيراليون;
           case "سنغافورة":
        	   return Pays.سنغافورة;
           case "سلوفاكيا":
        	   return Pays.سلوفاكيا;
           case "سلوفينيا":
        	   return Pays.سلوفينيا;
           case "الصومال":
        	   return Pays.الصومال;
           case "جنوب إفريقيا":
        	   return Pays.جنوب_إفريقيا;
           case "إسبانيا":
        	   return Pays.إسبانيا;
           case "سريلانكا":
        	   return Pays.سريلانكا;
           case "السودان":
        	   return Pays.السودان;
           case "سوازيلاند":
        	   return Pays.سوازيلاند;
           case "السويد":
        	   return Pays.السويد;
           case "سويسرا":
        	   return Pays.سويسرا;
           case "سوريا":
        	   return Pays.سوريا;
           case "تايوان":
        	   return Pays.تايوان;
           case "طاجيكستان":
        	   return Pays.طاجيكستان;
           case "تنزانيا":
        	   return Pays.تنزانيا;
           case "تايلاند":
        	   return Pays.تايلاند;
           case "توغو":
        	   return Pays.توغو;
           case "تونس":
        	   return Pays.تونس;
           case "تركيا":
        	   return Pays.تركيا;
           case "تركمانستان":
        	   return Pays.تركمانستان;
           case "أوغندا":
        	   return Pays.أوغندا;
           case "أوكرانيا":
        	   return Pays.أوكرانيا;
           case "الإمارات":
        	   return Pays.الإمارات;
           case "بريطانيا":
        	   return Pays.بريطانيا;
           case "الولايات المتحدة الأمريكية":
        	   return Pays.الولايات_المتحدة_الأمريكية;
           case "أوروغواي":
        	   return Pays.أوروغواي;
           case "أوزبكستان":
        	   return Pays.أوزبكستان;
           case "فنزويلا":
        	   return Pays.فنزويلا;
           case "فيتنام":
        	   return Pays.فيتنام;
           case "اليمن":
        	   return Pays.اليمن;
          
    
           default:
        	   return Pays.تونس;
           }
       }
}