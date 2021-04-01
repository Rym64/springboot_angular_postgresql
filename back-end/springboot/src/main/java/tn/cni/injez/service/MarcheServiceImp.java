package tn.cni.injez.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cni.injez.exception.ResourceNotFoundException;
import tn.cni.injez.model.Marche;
import tn.cni.injez.model.Pays;
import tn.cni.injez.model.LotAppelOffre;
import tn.cni.injez.repository.MarcheRepository;
import java.sql.Date;
import java.util.Calendar;

@Service
public class MarcheServiceImp implements MarcheService{
	@Autowired
	private MarcheRepository marcheRepository;
	@Autowired
	private LotAppelOffreService lotAppelOffreService;
	
	
	@Override
	public List<Marche> afficherMarches() {
		return this.findMarchesByAppelOffre();
		
	}

	@Override
	public List<Marche> findMarchesByAppelOffre() {
		List<LotAppelOffre> liste = lotAppelOffreService.lotAppelOffreCourant();
		Iterator iter = liste.iterator();
		LotAppelOffre lotAppelOffre = (LotAppelOffre) iter.next();
		List<Marche> listMarches = marcheRepository.findAll();
		List<Marche> listMarches1 = new ArrayList<>();
		listMarches.forEach(marche -> {
			if ((marche.getLot_appel_offre())==lotAppelOffre) {
				listMarches1.add(marche);
			}	
		} );
		return listMarches1;
		}
	
	@Override
	public Marche findMarcheById(String code) {
		 Marche marche=marcheRepository.findById(code).get();
		 return marche;
		}
	
	@Override
	public Marche ajouterMarche(Marche marche) {
		Calendar c2 = Calendar.getInstance();
		Calendar c3 = Calendar.getInstance();
		Calendar c4 = Calendar.getInstance();
		if (marche != null) {
			
			if(marche.getDate_signature()!=null) {
			c2.setTime(marche.getDate_signature());
			c2.add(Calendar.DATE, 1);
			java.sql.Date dateSignature1= new java.sql.Date(c2.getTimeInMillis());
			marche.setDate_signature(dateSignature1);}
			
			if(marche.getDate_fin_travaux_estimee()!=null) {
			c3.setTime(marche.getDate_fin_travaux_estimee());
			c3.add(Calendar.DATE, 1);
			java.sql.Date dateFinTravauxEstimee1= new java.sql.Date(c3.getTimeInMillis());
			marche.setDate_fin_travaux_estimee(dateFinTravauxEstimee1);}
			
			if(marche.getDate_fin_travaux_reelle()!=null) {
			c4.setTime(marche.getDate_fin_travaux_reelle());
			c4.add(Calendar.DATE, 1);
			java.sql.Date dateFinTravauxReelle1= new java.sql.Date(c4.getTimeInMillis());
			marche.setDate_fin_travaux_reelle(dateFinTravauxReelle1);}
			
			this.setPays_geocoordinates(marche);
			return marcheRepository.save(marche);
		} else {
			throw new ResourceNotFoundException("Record cannot be created");
		}

	}
	
	@Override
	public Marche modifierMarche(Marche marche) {
		Calendar c2 = Calendar.getInstance();
		Calendar c3 = Calendar.getInstance();
		Calendar c4 = Calendar.getInstance();
		if (marche != null) {
			
			
			if(marche.getDate_signature()!=null) {
				c2.setTime(marche.getDate_signature());
				c2.add(Calendar.DATE, 1);
				java.sql.Date dateSignature1= new java.sql.Date(c2.getTimeInMillis());
				marche.setDate_signature(dateSignature1);}
				
				if(marche.getDate_fin_travaux_estimee()!=null) {
				c3.setTime(marche.getDate_fin_travaux_estimee());
				c3.add(Calendar.DATE, 1);
				java.sql.Date dateFinTravauxEstimee1= new java.sql.Date(c3.getTimeInMillis());
				marche.setDate_fin_travaux_estimee(dateFinTravauxEstimee1);}
				
				if(marche.getDate_fin_travaux_reelle()!=null) {
				c4.setTime(marche.getDate_fin_travaux_reelle());
				c4.add(Calendar.DATE, 1);
				java.sql.Date dateFinTravauxReelle1= new java.sql.Date(c4.getTimeInMillis());
				marche.setDate_fin_travaux_reelle(dateFinTravauxReelle1);}
				
				this.setPays_geocoordinates(marche);

			return marcheRepository.save(marche);
		} else {
			throw new ResourceNotFoundException("Record cannot be created");
		}

	}

	@Override
	public void supprimerMarche(String code) {
		if (code != null) {
			marcheRepository.deleteById(code);
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + code);
		}

	}

	@Override
	public List<Marche> marcheCourant() {
		List<Marche> listMarches = marcheRepository.findAll();
		List<Marche> listMarches1 = new ArrayList<>();
		listMarches.forEach(marche -> {
			if ((marche.getCurrent()) == 1)
				listMarches1.add(marche);
		}) ;
		return listMarches1;
	}
	
	@Override
	public List<Marche> searchMarche(String recherche)
	{List<Marche> listMarches = this.findMarchesByAppelOffre();
	List<Marche> listMarches1 = new ArrayList<>();
	Set<Marche> setMarches = new LinkedHashSet<>();
	listMarches.forEach(marche -> {
		if ((marche.getFournisseur())!=null) {if ((marche.getFournisseur()).equals(recherche)) {setMarches.add(marche);} }
		if ((marche.getMontant_actualise())!=null) {if ((marche.getMontant_actualise()).toString().equals(recherche)) {setMarches.add(marche);} }
		if ((marche.getCode())!=null) {if ((marche.getCode()).equals(recherche)) {setMarches.add(marche);} }
		if ((marche.getLibelle())!=null) {if ((marche.getLibelle()).equals(recherche)) {setMarches.add(marche);} }
		if ((marche.getDevise())!=null) {if ((marche.getDevise()).toString().equals(recherche)) {setMarches.add(marche);} }
		if ((marche.getPays_marche())!=null) {if ((marche.getPays_marche()).toString().equals(recherche)) {setMarches.add(marche);} }
		if ((marche.getMontant_dt())!=null) {if ((marche.getMontant_dt()).toString().equals(recherche)) {setMarches.add(marche);} }
		if ((marche.getDate_signature())!=null) {if ((marche.getDate_signature()).toString().equals(recherche)) {setMarches.add(marche);} }
		if ((marche.getPeriode_travail())!=null) {if ((marche.getPeriode_travail()).toString().equals(recherche)) {setMarches.add(marche);} }
		if ((marche.getDate_fin_travaux_estimee())!=null) {if ((marche.getDate_fin_travaux_estimee()).toString().equals(recherche)) {setMarches.add(marche);} }
		if ((marche.getDate_fin_travaux_reelle())!=null) {if ((marche.getDate_fin_travaux_reelle()).toString().equals(recherche)) {setMarches.add(marche);} }
		if ((marche.getNiveau())!=null) {if ((marche.getNiveau()).toString().equals(recherche)) {setMarches.add(marche);} }

	}); 
	
	setMarches.forEach(marche2 -> {
		listMarches1.add(marche2);	
	});
	return listMarches1;}
	
	
	public void setPays_geocoordinates(Marche marche)
	{
	if (marche.getPays_marche()==Pays.أفغانستان ) marche.setPays_geocoordinates("33.9340384, 67.7034313");
	if (marche.getPays_marche()==Pays. ألبانيا) marche.setPays_geocoordinates("41.1529058, 20.1605717");
	if (marche.getPays_marche()==Pays. الجزائر) marche.setPays_geocoordinates("28.0289837, 1.6666663");
	if (marche.getPays_marche()==Pays. أندورا) marche.setPays_geocoordinates("42.5422699, 1.5976721");
	if (marche.getPays_marche()==Pays. أنغولا ) marche.setPays_geocoordinates("-11.2135241, 17.8770032");
	if (marche.getPays_marche()==Pays.الأرجنتين) marche.setPays_geocoordinates("-38.4192641, -63.5989206");
	if (marche.getPays_marche()==Pays. أرمينيا) marche.setPays_geocoordinates("40.0706185, 45.0407411");
	if (marche.getPays_marche()==Pays. أستراليا) marche.setPays_geocoordinates("-26.4390917, 133.281323");
	if (marche.getPays_marche()==Pays. النمسا) marche.setPays_geocoordinates("47.6964719, 13.3457347");
	if (marche.getPays_marche()==Pays. أذربيجان) marche.setPays_geocoordinates("40.1521651, 47.615563");
	if (marche.getPays_marche()==Pays. البحرين) marche.setPays_geocoordinates("25.9434256, 50.6014985");
	if (marche.getPays_marche()==Pays. بنغلاديش ) marche.setPays_geocoordinates("23.6943117, 90.344352");
	if (marche.getPays_marche()==Pays.بيلاروسيا) marche.setPays_geocoordinates("53.7169415, 27.9775789");
	if (marche.getPays_marche()==Pays. بلجيكا) marche.setPays_geocoordinates("50.5010789, 4.4764595");
	if (marche.getPays_marche()==Pays. بوليفيا) marche.setPays_geocoordinates("-16.2837065, -63.5493965");
	if (marche.getPays_marche()==Pays. بوتسوانا) marche.setPays_geocoordinates("-22.342841, 24.6871044");
	if (marche.getPays_marche()==Pays. البرازيل) marche.setPays_geocoordinates("-14.2400732, -53.1805017");
	if (marche.getPays_marche()==Pays. بروناي) marche.setPays_geocoordinates("4.5242486, 114.7196266");
	if (marche.getPays_marche()==Pays. بلغاريا) marche.setPays_geocoordinates("42.7249925, 25.4833039");
	if (marche.getPays_marche()==Pays. بوروندي ) marche.setPays_geocoordinates("-3.3896077, 29.9255829");
	if (marche.getPays_marche()==Pays.كمبوديا ) marche.setPays_geocoordinates("11.9879665, 104.9806145");
	if (marche.getPays_marche()==Pays.الكاميرون) marche.setPays_geocoordinates("7.3696495, 12.3445856");
	if (marche.getPays_marche()==Pays. كندا) marche.setPays_geocoordinates("56.0, -96.0");
	if (marche.getPays_marche()==Pays. تشاد) marche.setPays_geocoordinates("15.446105, 18.7350005");
	if (marche.getPays_marche()==Pays. تشيلي) marche.setPays_geocoordinates("-36.739055, -71.0574941");
	if (marche.getPays_marche()==Pays. الصين) marche.setPays_geocoordinates("35.8592948, 104.1361118");
	if (marche.getPays_marche()==Pays. كولومبيا) marche.setPays_geocoordinates("4.1156735, -72.9301367");
	if (marche.getPays_marche()==Pays. الكونغو) marche.setPays_geocoordinates("-0.6605788, 14.8965794");
	if (marche.getPays_marche()==Pays. كوستاريكا) marche.setPays_geocoordinates("9.6301892, -84.2541844");
	if (marche.getPays_marche()==Pays. كرواتيا ) marche.setPays_geocoordinates("44.4737849, 16.4688717");
	if (marche.getPays_marche()==Pays.كوبا ) marche.setPays_geocoordinates("21.5513258, -79.6017351");
	if (marche.getPays_marche()==Pays.قبرص) marche.setPays_geocoordinates("35.1697515, 33.4366038");
	if (marche.getPays_marche()==Pays. التشيك) marche.setPays_geocoordinates("49.8037633, 15.4749126");
	if (marche.getPays_marche()==Pays. الدنمارك) marche.setPays_geocoordinates("55.9396761, 9.5155848");
	if (marche.getPays_marche()==Pays. جيبوتي) marche.setPays_geocoordinates("11.8226699, 42.5883476");
	if (marche.getPays_marche()==Pays. إكوادور) marche.setPays_geocoordinates("-1.7929665, -78.1368875");
	if (marche.getPays_marche()==Pays. مصر) marche.setPays_geocoordinates("26.8357675, 30.7956597");
	if (marche.getPays_marche()==Pays. السلفادور ) marche.setPays_geocoordinates("13.8029939, -88.9053364");
	if (marche.getPays_marche()==Pays.إريتريا ) marche.setPays_geocoordinates("15.1879664, 39.7881626");
	if (marche.getPays_marche()==Pays.إستونيا) marche.setPays_geocoordinates("58.5974875, 24.9872555");
	if (marche.getPays_marche()==Pays. إثيوبيا) marche.setPays_geocoordinates("9.149175, 40.498867");
	if (marche.getPays_marche()==Pays. فنلندا) marche.setPays_geocoordinates("64.9146659, 26.0672554");
	if (marche.getPays_marche()==Pays. فرنسا) marche.setPays_geocoordinates("46.71109, 1.7191036");
	if (marche.getPays_marche()==Pays. غامبيا) marche.setPays_geocoordinates("13.4457859, -15.3061209");
	if (marche.getPays_marche()==Pays. جورجيا) marche.setPays_geocoordinates("42.3207845, 43.3713615");
	if (marche.getPays_marche()==Pays. ألمانيا) marche.setPays_geocoordinates("51.1642292, 10.4541194");
	if (marche.getPays_marche()==Pays. غانا) marche.setPays_geocoordinates("7.9527706, -1.0307118");
	if (marche.getPays_marche()==Pays. اليونان) marche.setPays_geocoordinates("38.2749497, 23.8102717");
	if (marche.getPays_marche()==Pays. غينيا ) marche.setPays_geocoordinates("9.9327629, -11.3580296");
	if (marche.getPays_marche()==Pays.هايتي ) marche.setPays_geocoordinates("19.0558462, -73.0513321");
	if (marche.getPays_marche()==Pays.هندوراس ) marche.setPays_geocoordinates("14.7503821, -86.241341");
	if (marche.getPays_marche()==Pays.المجر) marche.setPays_geocoordinates("47.1611615, 19.5057541");
	if (marche.getPays_marche()==Pays. أيسلندا) marche.setPays_geocoordinates("64.9312762, -19.0211697");
	if (marche.getPays_marche()==Pays. الهند ) marche.setPays_geocoordinates("21.1289956, 82.7792201");
	if (marche.getPays_marche()==Pays.إندونيسيا ) marche.setPays_geocoordinates("-2.548926, 118.0148634");
	if (marche.getPays_marche()==Pays.إيران ) marche.setPays_geocoordinates("32.4207423, 53.6830157");
	if (marche.getPays_marche()==Pays.العراق ) marche.setPays_geocoordinates("33.2209265, 43.6847595");
	if (marche.getPays_marche()==Pays. إيطاليا ) marche.setPays_geocoordinates("41.29246, 12.5736108");
	if (marche.getPays_marche()==Pays.جامايكا) marche.setPays_geocoordinates("18.1155174, -77.2760026");
	if (marche.getPays_marche()==Pays. اليابان ) marche.setPays_geocoordinates("37.4900318, 136.4664008");
	if (marche.getPays_marche()==Pays.الأردن ) marche.setPays_geocoordinates("31.279862, 37.1297454");
	if (marche.getPays_marche()==Pays.كازاخستان ) marche.setPays_geocoordinates("48.005284, 66.9045434");
	if (marche.getPays_marche()==Pays.كينيا ) marche.setPays_geocoordinates("0.1768696, 37.9083264");
	if (marche.getPays_marche()==Pays.كوريا_الجنوبية) marche.setPays_geocoordinates("35.8615124, 127.096405");
	if (marche.getPays_marche()==Pays. كوسوفو ) marche.setPays_geocoordinates("42.5833, 21.0001");
	if (marche.getPays_marche()==Pays.الكويت) marche.setPays_geocoordinates("29.3140762, 47.491749");
	if (marche.getPays_marche()==Pays. لاتفيا) marche.setPays_geocoordinates("56.8801729, 24.6057484");
	if (marche.getPays_marche()==Pays. لبنان ) marche.setPays_geocoordinates("33.8735578, 35.863749");
	if (marche.getPays_marche()==Pays.ليبيا ) marche.setPays_geocoordinates("26.3347113, 17.2692101");
	if (marche.getPays_marche()==Pays.ليتوانيا) marche.setPays_geocoordinates("55.1735998, 23.8948016");
	if (marche.getPays_marche()==Pays. لوكسمبورغ ) marche.setPays_geocoordinates("49.8152995, 6.13332");
	if (marche.getPays_marche()==Pays.مقدونيا ) marche.setPays_geocoordinates("41.6137143, 21.743258");
	if (marche.getPays_marche()==Pays.مدغشقر ) marche.setPays_geocoordinates("-18.7792678, 46.8344597");
	if (marche.getPays_marche()==Pays.ماليزيا ) marche.setPays_geocoordinates("4.140634, 109.6181485");
	if (marche.getPays_marche()==Pays.مالي) marche.setPays_geocoordinates("17.5739347, -3.9861092");
	if (marche.getPays_marche()==Pays. مالطا ) marche.setPays_geocoordinates("35.9440174, 14.3795242");
	if (marche.getPays_marche()==Pays.موريتانيا ) marche.setPays_geocoordinates("21.0078589, -10.951734");
	if (marche.getPays_marche()==Pays.المكسيك ) marche.setPays_geocoordinates("23.6260333, -102.5375005");
	if (marche.getPays_marche()==Pays.موناكو) marche.setPays_geocoordinates("43.7383229, 7.4244581");
	if (marche.getPays_marche()==Pays. منغوليا) marche.setPays_geocoordinates("46.8651082, 103.8347844");
	if (marche.getPays_marche()==Pays. المغرب) marche.setPays_geocoordinates("31.794525, -7.0849336");
	if (marche.getPays_marche()==Pays. موزمبيق) marche.setPays_geocoordinates("-18.6696553, 35.5273354");
	if (marche.getPays_marche()==Pays. ميانمار ) marche.setPays_geocoordinates("19.0734647, 96.6710399");
	if (marche.getPays_marche()==Pays.ناميبيا ) marche.setPays_geocoordinates("-22.967062, 18.4929993");
	if (marche.getPays_marche()==Pays.نيبال ) marche.setPays_geocoordinates("28.3973623, 84.12576");
	if (marche.getPays_marche()==Pays.هولندا ) marche.setPays_geocoordinates("52.2129919, 5.2793703");
	if (marche.getPays_marche()==Pays.نيوزيلندا ) marche.setPays_geocoordinates("-43.3744881, 172.4662705");
	if (marche.getPays_marche()==Pays.نيجيريا ) marche.setPays_geocoordinates("9.077751, 8.6774567");
	if (marche.getPays_marche()==Pays.النرويج ) marche.setPays_geocoordinates("64.5783089, 17.888237");
	if (marche.getPays_marche()==Pays.عمان ) marche.setPays_geocoordinates("21.5278654, 55.9196996");
	if (marche.getPays_marche()==Pays.باكستان ) marche.setPays_geocoordinates("30.3894007, 69.3532207");
	if (marche.getPays_marche()==Pays.بنما ) marche.setPays_geocoordinates("8.4255193, -80.1053645");
	if (marche.getPays_marche()==Pays.باراغواي ) marche.setPays_geocoordinates("-23.4380203, -58.4483065");
	if (marche.getPays_marche()==Pays.بيرو) marche.setPays_geocoordinates("-9.1951786, -74.9904165");
	if (marche.getPays_marche()==Pays. الفلبين ) marche.setPays_geocoordinates("11.6978352, 122.6217542");
	if (marche.getPays_marche()==Pays.بولندا ) marche.setPays_geocoordinates("51.9189046, 19.1343786");
	if (marche.getPays_marche()==Pays.البرتغال ) marche.setPays_geocoordinates("39.557191, -7.8536599");
	if (marche.getPays_marche()==Pays.قطر ) marche.setPays_geocoordinates("25.3271054, 51.1966577");
	if (marche.getPays_marche()==Pays.رومانيا ) marche.setPays_geocoordinates("45.9442858, 25.0094303");
	if (marche.getPays_marche()==Pays.روسيا ) marche.setPays_geocoordinates("55.0, 103.0");
	if (marche.getPays_marche()==Pays.فلسطين) marche.setPays_geocoordinates("31.947351, 35.227163");
	if (marche.getPays_marche()==Pays. رواندا ) marche.setPays_geocoordinates("-1.9437057, 29.8805778");
	if (marche.getPays_marche()==Pays.السعودية ) marche.setPays_geocoordinates("24.266906, 45.107849");
	if (marche.getPays_marche()==Pays.السنغال ) marche.setPays_geocoordinates("14.5001717, -14.4392276");
	if (marche.getPays_marche()==Pays.صربيا ) marche.setPays_geocoordinates("44.2107675, 20.9224158");
	if (marche.getPays_marche()==Pays.سيشيل ) marche.setPays_geocoordinates("-4.6838871, 55.4494781");
	if (marche.getPays_marche()==Pays.سيراليون ) marche.setPays_geocoordinates("8.4494988, -11.7868289");
	if (marche.getPays_marche()==Pays.سنغافورة ) marche.setPays_geocoordinates("1.3146631, 103.8454093");
	if (marche.getPays_marche()==Pays.سلوفاكيا ) marche.setPays_geocoordinates("48.6737532, 19.696058");
	if (marche.getPays_marche()==Pays.سلوفينيا ) marche.setPays_geocoordinates("46.1491664, 14.9860106");
	if (marche.getPays_marche()==Pays.الصومال ) marche.setPays_geocoordinates("5.1632866, 46.2037008");
	if (marche.getPays_marche()==Pays.جنوب_إفريقيا ) marche.setPays_geocoordinates("-28.4792625, 24.6727135");
	if (marche.getPays_marche()==Pays.إسبانيا) marche.setPays_geocoordinates("40.2085, -3.713");
	if (marche.getPays_marche()==Pays. سريلانكا ) marche.setPays_geocoordinates("7.8774222, 80.7003428");
	if (marche.getPays_marche()==Pays.السودان ) marche.setPays_geocoordinates("15.7860696, 30.1995791");
	if (marche.getPays_marche()==Pays.سوازيلاند ) marche.setPays_geocoordinates("-26.5179414, 31.4629694");
	if (marche.getPays_marche()==Pays.السويد ) marche.setPays_geocoordinates("62.1983366, 17.5671981");
	if (marche.getPays_marche()==Pays.سويسرا) marche.setPays_geocoordinates("46.8131873, 8.22421");
	if (marche.getPays_marche()==Pays. سوريا) marche.setPays_geocoordinates("34.8149145, 39.0464523");
	if (marche.getPays_marche()==Pays. تايوان ) marche.setPays_geocoordinates("23.553118, 121.0211024");
	if (marche.getPays_marche()==Pays.طاجيكستان ) marche.setPays_geocoordinates("38.8581784, 71.2479841");
	if (marche.getPays_marche()==Pays.تنزانيا ) marche.setPays_geocoordinates("-6.3728253, 34.8924826");
	if (marche.getPays_marche()==Pays.تايلاند ) marche.setPays_geocoordinates("13.03887, 101.490104");
	if (marche.getPays_marche()==Pays.توغو) marche.setPays_geocoordinates("8.6259267, 0.8325041");
	if (marche.getPays_marche()==Pays. تونس) marche.setPays_geocoordinates("33.7931605, 9.5607653");
	if (marche.getPays_marche()==Pays. تركيا) marche.setPays_geocoordinates("38.9573415, 35.240741");
	if (marche.getPays_marche()==Pays. تركمانستان ) marche.setPays_geocoordinates("38.963802, 59.5775989");
	if (marche.getPays_marche()==Pays.أوغندا ) marche.setPays_geocoordinates("1.3707295, 32.3032414");
	if (marche.getPays_marche()==Pays.أوكرانيا) marche.setPays_geocoordinates("48.383022, 31.1828699");
	if (marche.getPays_marche()==Pays. الإمارات) marche.setPays_geocoordinates("24.3505839, 53.9396418");
	if (marche.getPays_marche()==Pays. بريطانيا) marche.setPays_geocoordinates("55.3617609, -3.4433238");
	if (marche.getPays_marche()==Pays. الولايات_المتحدة_الأمريكية ) marche.setPays_geocoordinates("37.6, -95.665");
	if (marche.getPays_marche()==Pays.أوروغواي ) marche.setPays_geocoordinates("-32.5583168, -55.811697");
	if (marche.getPays_marche()==Pays.أوزبكستان) marche.setPays_geocoordinates("41.381166, 64.5735819");
	if (marche.getPays_marche()==Pays. فنزويلا ) marche.setPays_geocoordinates("5.1632955, -69.4146705");
	if (marche.getPays_marche()==Pays.فيتنام ) marche.setPays_geocoordinates("15.9030623, 105.8066925");
	if (marche.getPays_marche()==Pays.اليمن) marche.setPays_geocoordinates("15.5539046, 48.1748476");

	}


}
