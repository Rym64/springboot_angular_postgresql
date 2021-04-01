package tn.cni.injez.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cni.injez.exception.ResourceNotFoundException;
import tn.cni.injez.model.FinancementEtranger;
import tn.cni.injez.model.Pays;
import tn.cni.injez.model.Projet;
import tn.cni.injez.repository.FinancementEtrangerRepository;


@Service
public class FinancementEtrangerServiceImp implements FinancementEtrangerService{
	@Autowired
	private FinancementEtrangerRepository financementEtrangerRepository;
	@Autowired
	private ProjetService projetService;
	
	
	@Override
	public List<FinancementEtranger> afficherFinancementsEtrangers() {
		return this.findFinancementsEtrangersByProject();
	}

	@Override
	public List<FinancementEtranger> findFinancementsEtrangersByProject() {
		List<Projet> liste = projetService.projetCourant();
		Iterator iter = liste.iterator();
		Projet projet = (Projet) iter.next();
		List<FinancementEtranger> listFinancements = financementEtrangerRepository.findAll();
		List<FinancementEtranger> listFinancements1 = new ArrayList<>();
		listFinancements.forEach(financement -> {
			if ((financement.getProjet())==projet) {
				listFinancements1.add(financement);
			}	
		}); 
		return listFinancements1;
		}
	@Override
	public FinancementEtranger findFinancementEtrangerById(String code) {
		 FinancementEtranger financement=financementEtrangerRepository.findById(code).get();
		 return financement;
		}
	@Override
	public FinancementEtranger ajouterFinancementEtranger(FinancementEtranger financement) {
	
		Calendar c2 = Calendar.getInstance();
		Calendar c3 = Calendar.getInstance();
		Calendar c4 = Calendar.getInstance();
		Calendar c5 = Calendar.getInstance();
		if (financement != null) {
			
			if(financement.getDate_signature()!=null) {
			c2.setTime(financement.getDate_signature());
			c2.add(Calendar.DATE, 1);
			java.sql.Date dateSignature1= new java.sql.Date(c2.getTimeInMillis());
			financement.setDate_signature(dateSignature1);}
			
			if(financement.getDate_debut()!=null) {
			c3.setTime(financement.getDate_debut());
			c3.add(Calendar.DATE, 1);
			java.sql.Date dateDebut1= new java.sql.Date(c3.getTimeInMillis());
			financement.setDate_debut(dateDebut1);}
			
			if(financement.getDate_cloture()!=null) {
			c4.setTime(financement.getDate_cloture());
			c4.add(Calendar.DATE, 1);
			java.sql.Date dateCloture1= new java.sql.Date(c4.getTimeInMillis());
			financement.setDate_cloture(dateCloture1);}
			
			if(financement.getDate_delai()!=null) {
			c5.setTime(financement.getDate_delai());
			c5.add(Calendar.DATE, 1);
			java.sql.Date dateDelai1= new java.sql.Date(c5.getTimeInMillis());
			financement.setDate_delai(dateDelai1);}
			
			this.setPays_geocoordinates(financement);
			return financementEtrangerRepository.save(financement);
		} else {
			throw new ResourceNotFoundException("Record cannot be created");
		}

	}
	
	@Override
	public FinancementEtranger modifierFinancementEtranger(FinancementEtranger financement) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		Calendar c3 = Calendar.getInstance();
		Calendar c4 = Calendar.getInstance();
		Calendar c5 = Calendar.getInstance();
		if (financement != null) {
			if(financement.getDate_actualisation()!=null) {
			c1.setTime(financement.getDate_actualisation());
			c1.add(Calendar.DATE, 1);
			java.sql.Date dateActualisation1= new java.sql.Date(c1.getTimeInMillis());
			financement.setDate_actualisation(dateActualisation1);}
			
			if(financement.getDate_signature()!=null) {
				c2.setTime(financement.getDate_signature());
				c2.add(Calendar.DATE, 1);
				java.sql.Date dateSignature1= new java.sql.Date(c2.getTimeInMillis());
				financement.setDate_signature(dateSignature1);}
				
				if(financement.getDate_debut()!=null) {
				c3.setTime(financement.getDate_debut());
				c3.add(Calendar.DATE, 1);
				java.sql.Date dateDebut1= new java.sql.Date(c3.getTimeInMillis());
				financement.setDate_debut(dateDebut1);}
				
				if(financement.getDate_cloture()!=null) {
				c4.setTime(financement.getDate_cloture());
				c4.add(Calendar.DATE, 1);
				java.sql.Date dateCloture1= new java.sql.Date(c4.getTimeInMillis());
				financement.setDate_cloture(dateCloture1);}
				
				if(financement.getDate_delai()!=null) {
				c5.setTime(financement.getDate_delai());
				c5.add(Calendar.DATE, 1);
				java.sql.Date dateDelai1= new java.sql.Date(c5.getTimeInMillis());
				financement.setDate_delai(dateDelai1);}
				
				this.setPays_geocoordinates(financement);

			return financementEtrangerRepository.save(financement);
		} else {
			throw new ResourceNotFoundException("Record cannot be created");
		}

	}

	@Override
	public void supprimerFinancementEtranger(String code) {
		if (code != null) {
			financementEtrangerRepository.deleteById(code);
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + code);
		}

	}
	
	@Override
	public List<FinancementEtranger> searchFinancementEtranger(String recherche2)
	{List<FinancementEtranger> listFinancementsEtranger = this.findFinancementsEtrangersByProject();
	List<FinancementEtranger> listFinancementsEtranger1 = new ArrayList<>();
	Set<FinancementEtranger> setFinancementsEtranger = new LinkedHashSet<>();
	listFinancementsEtranger.forEach(financementEtranger -> {
		if ((financementEtranger.getMontant_actualise())!=null) {if ((financementEtranger.getMontant_actualise()).toString().equals(recherche2)) {setFinancementsEtranger.add(financementEtranger);}}
		if ((financementEtranger.getDate_actualisation())!=null) {if ((financementEtranger.getDate_actualisation()).toString().equals(recherche2)) {setFinancementsEtranger.add(financementEtranger);}}
		if ((financementEtranger.getCode())!=null) {if ((financementEtranger.getCode()).equals(recherche2)) {setFinancementsEtranger.add(financementEtranger);}}
		if ((financementEtranger.getLibelle())!=null) {if ((financementEtranger.getLibelle()).equals(recherche2)) {setFinancementsEtranger.add(financementEtranger);}}
		if ((financementEtranger.getDevise())!=null) {if ((financementEtranger.getDevise()).toString().equals(recherche2)) {setFinancementsEtranger.add(financementEtranger);}}
		if ((financementEtranger.getPays_financement())!=null) {if ((financementEtranger.getPays_financement()).toString().equals(recherche2)) {setFinancementsEtranger.add(financementEtranger);}}
		if ((financementEtranger.getMontant_dt())!=null) {if ((financementEtranger.getMontant_dt()).toString().equals(recherche2)) {setFinancementsEtranger.add(financementEtranger);}}
		if ((financementEtranger.getFinanceur())!=null) {if ((financementEtranger.getFinanceur()).toString().equals(recherche2)) {setFinancementsEtranger.add(financementEtranger);}}
		if ((financementEtranger.getDate_signature())!=null) {if ((financementEtranger.getDate_signature()).toString().equals(recherche2)) {setFinancementsEtranger.add(financementEtranger);}}
		if ((financementEtranger.getDate_debut())!=null) {if ((financementEtranger.getDate_debut()).toString().equals(recherche2)) {setFinancementsEtranger.add(financementEtranger);}}
		if ((financementEtranger.getDate_cloture())!=null) {if ((financementEtranger.getDate_cloture()).toString().equals(recherche2)) {setFinancementsEtranger.add(financementEtranger);}}
		if ((financementEtranger.getDate_delai())!=null) {if ((financementEtranger.getDate_delai()).toString().equals(recherche2)) {setFinancementsEtranger.add(financementEtranger);}}

	} );
	
	setFinancementsEtranger.forEach(financementEtranger5 -> 
	{listFinancementsEtranger1.add(financementEtranger5);});
	return listFinancementsEtranger1;}
	
	
	public void setPays_geocoordinates(FinancementEtranger financement)
	{
		if (financement.getPays_financement()==Pays.أفغانستان ) financement.setPays_geocoordinates("33.9340384, 67.7034313");
		if (financement.getPays_financement()==Pays. ألبانيا) financement.setPays_geocoordinates("41.1529058, 20.1605717");
		if (financement.getPays_financement()==Pays. الجزائر) financement.setPays_geocoordinates("28.0289837, 1.6666663");
		if (financement.getPays_financement()==Pays. أندورا) financement.setPays_geocoordinates("42.5422699, 1.5976721");
		if (financement.getPays_financement()==Pays. أنغولا ) financement.setPays_geocoordinates("-11.2135241, 17.8770032");
		if (financement.getPays_financement()==Pays.الأرجنتين) financement.setPays_geocoordinates("-38.4192641, -63.5989206");
		if (financement.getPays_financement()==Pays. أرمينيا) financement.setPays_geocoordinates("40.0706185, 45.0407411");
		if (financement.getPays_financement()==Pays. أستراليا) financement.setPays_geocoordinates("-26.4390917, 133.281323");
		if (financement.getPays_financement()==Pays. النمسا) financement.setPays_geocoordinates("47.6964719, 13.3457347");
		if (financement.getPays_financement()==Pays. أذربيجان) financement.setPays_geocoordinates("40.1521651, 47.615563");
		if (financement.getPays_financement()==Pays. البحرين) financement.setPays_geocoordinates("25.9434256, 50.6014985");
		if (financement.getPays_financement()==Pays. بنغلاديش ) financement.setPays_geocoordinates("23.6943117, 90.344352");
		if (financement.getPays_financement()==Pays.بيلاروسيا) financement.setPays_geocoordinates("53.7169415, 27.9775789");
		if (financement.getPays_financement()==Pays. بلجيكا) financement.setPays_geocoordinates("50.5010789, 4.4764595");
		if (financement.getPays_financement()==Pays. بوليفيا) financement.setPays_geocoordinates("-16.2837065, -63.5493965");
		if (financement.getPays_financement()==Pays. بوتسوانا) financement.setPays_geocoordinates("-22.342841, 24.6871044");
		if (financement.getPays_financement()==Pays. البرازيل) financement.setPays_geocoordinates("-14.2400732, -53.1805017");
		if (financement.getPays_financement()==Pays. بروناي) financement.setPays_geocoordinates("4.5242486, 114.7196266");
		if (financement.getPays_financement()==Pays. بلغاريا) financement.setPays_geocoordinates("42.7249925, 25.4833039");
		if (financement.getPays_financement()==Pays. بوروندي ) financement.setPays_geocoordinates("-3.3896077, 29.9255829");
		if (financement.getPays_financement()==Pays.كمبوديا ) financement.setPays_geocoordinates("11.9879665, 104.9806145");
		if (financement.getPays_financement()==Pays.الكاميرون) financement.setPays_geocoordinates("7.3696495, 12.3445856");
		if (financement.getPays_financement()==Pays. كندا) financement.setPays_geocoordinates("56.0, -96.0");
		if (financement.getPays_financement()==Pays. تشاد) financement.setPays_geocoordinates("15.446105, 18.7350005");
		if (financement.getPays_financement()==Pays. تشيلي) financement.setPays_geocoordinates("-36.739055, -71.0574941");
		if (financement.getPays_financement()==Pays. الصين) financement.setPays_geocoordinates("35.8592948, 104.1361118");
		if (financement.getPays_financement()==Pays. كولومبيا) financement.setPays_geocoordinates("4.1156735, -72.9301367");
		if (financement.getPays_financement()==Pays. الكونغو) financement.setPays_geocoordinates("-0.6605788, 14.8965794");
		if (financement.getPays_financement()==Pays. كوستاريكا) financement.setPays_geocoordinates("9.6301892, -84.2541844");
		if (financement.getPays_financement()==Pays. كرواتيا ) financement.setPays_geocoordinates("44.4737849, 16.4688717");
		if (financement.getPays_financement()==Pays.كوبا ) financement.setPays_geocoordinates("21.5513258, -79.6017351");
		if (financement.getPays_financement()==Pays.قبرص) financement.setPays_geocoordinates("35.1697515, 33.4366038");
		if (financement.getPays_financement()==Pays. التشيك) financement.setPays_geocoordinates("49.8037633, 15.4749126");
		if (financement.getPays_financement()==Pays. الدنمارك) financement.setPays_geocoordinates("55.9396761, 9.5155848");
		if (financement.getPays_financement()==Pays. جيبوتي) financement.setPays_geocoordinates("11.8226699, 42.5883476");
		if (financement.getPays_financement()==Pays. إكوادور) financement.setPays_geocoordinates("-1.7929665, -78.1368875");
		if (financement.getPays_financement()==Pays. مصر) financement.setPays_geocoordinates("26.8357675, 30.7956597");
		if (financement.getPays_financement()==Pays. السلفادور ) financement.setPays_geocoordinates("13.8029939, -88.9053364");
		if (financement.getPays_financement()==Pays.إريتريا ) financement.setPays_geocoordinates("15.1879664, 39.7881626");
		if (financement.getPays_financement()==Pays.إستونيا) financement.setPays_geocoordinates("58.5974875, 24.9872555");
		if (financement.getPays_financement()==Pays. إثيوبيا) financement.setPays_geocoordinates("9.149175, 40.498867");
		if (financement.getPays_financement()==Pays. فنلندا) financement.setPays_geocoordinates("64.9146659, 26.0672554");
		if (financement.getPays_financement()==Pays. فرنسا) financement.setPays_geocoordinates("46.71109, 1.7191036");
		if (financement.getPays_financement()==Pays. غامبيا) financement.setPays_geocoordinates("13.4457859, -15.3061209");
		if (financement.getPays_financement()==Pays. جورجيا) financement.setPays_geocoordinates("42.3207845, 43.3713615");
		if (financement.getPays_financement()==Pays. ألمانيا) financement.setPays_geocoordinates("51.1642292, 10.4541194");
		if (financement.getPays_financement()==Pays. غانا) financement.setPays_geocoordinates("7.9527706, -1.0307118");
		if (financement.getPays_financement()==Pays. اليونان) financement.setPays_geocoordinates("38.2749497, 23.8102717");
		if (financement.getPays_financement()==Pays. غينيا ) financement.setPays_geocoordinates("9.9327629, -11.3580296");
		if (financement.getPays_financement()==Pays.هايتي ) financement.setPays_geocoordinates("19.0558462, -73.0513321");
		if (financement.getPays_financement()==Pays.هندوراس ) financement.setPays_geocoordinates("14.7503821, -86.241341");
		if (financement.getPays_financement()==Pays.المجر) financement.setPays_geocoordinates("47.1611615, 19.5057541");
		if (financement.getPays_financement()==Pays. أيسلندا) financement.setPays_geocoordinates("64.9312762, -19.0211697");
		if (financement.getPays_financement()==Pays. الهند ) financement.setPays_geocoordinates("21.1289956, 82.7792201");
		if (financement.getPays_financement()==Pays.إندونيسيا ) financement.setPays_geocoordinates("-2.548926, 118.0148634");
		if (financement.getPays_financement()==Pays.إيران ) financement.setPays_geocoordinates("32.4207423, 53.6830157");
		if (financement.getPays_financement()==Pays.العراق ) financement.setPays_geocoordinates("33.2209265, 43.6847595");
		if (financement.getPays_financement()==Pays. إيطاليا ) financement.setPays_geocoordinates("41.29246, 12.5736108");
		if (financement.getPays_financement()==Pays.جامايكا) financement.setPays_geocoordinates("18.1155174, -77.2760026");
		if (financement.getPays_financement()==Pays. اليابان ) financement.setPays_geocoordinates("37.4900318, 136.4664008");
		if (financement.getPays_financement()==Pays.الأردن ) financement.setPays_geocoordinates("31.279862, 37.1297454");
		if (financement.getPays_financement()==Pays.كازاخستان ) financement.setPays_geocoordinates("48.005284, 66.9045434");
		if (financement.getPays_financement()==Pays.كينيا ) financement.setPays_geocoordinates("0.1768696, 37.9083264");
		if (financement.getPays_financement()==Pays.كوريا_الجنوبية) financement.setPays_geocoordinates("35.8615124, 127.096405");
		if (financement.getPays_financement()==Pays. كوسوفو ) financement.setPays_geocoordinates("42.5833, 21.0001");
		if (financement.getPays_financement()==Pays.الكويت) financement.setPays_geocoordinates("29.3140762, 47.491749");
		if (financement.getPays_financement()==Pays. لاتفيا) financement.setPays_geocoordinates("56.8801729, 24.6057484");
		if (financement.getPays_financement()==Pays. لبنان ) financement.setPays_geocoordinates("33.8735578, 35.863749");
		if (financement.getPays_financement()==Pays.ليبيا ) financement.setPays_geocoordinates("26.3347113, 17.2692101");
		if (financement.getPays_financement()==Pays.ليتوانيا) financement.setPays_geocoordinates("55.1735998, 23.8948016");
		if (financement.getPays_financement()==Pays. لوكسمبورغ ) financement.setPays_geocoordinates("49.8152995, 6.13332");
		if (financement.getPays_financement()==Pays.مقدونيا ) financement.setPays_geocoordinates("41.6137143, 21.743258");
		if (financement.getPays_financement()==Pays.مدغشقر ) financement.setPays_geocoordinates("-18.7792678, 46.8344597");
		if (financement.getPays_financement()==Pays.ماليزيا ) financement.setPays_geocoordinates("4.140634, 109.6181485");
		if (financement.getPays_financement()==Pays.مالي) financement.setPays_geocoordinates("17.5739347, -3.9861092");
		if (financement.getPays_financement()==Pays. مالطا ) financement.setPays_geocoordinates("35.9440174, 14.3795242");
		if (financement.getPays_financement()==Pays.موريتانيا ) financement.setPays_geocoordinates("21.0078589, -10.951734");
		if (financement.getPays_financement()==Pays.المكسيك ) financement.setPays_geocoordinates("23.6260333, -102.5375005");
		if (financement.getPays_financement()==Pays.موناكو) financement.setPays_geocoordinates("43.7383229, 7.4244581");
		if (financement.getPays_financement()==Pays. منغوليا) financement.setPays_geocoordinates("46.8651082, 103.8347844");
		if (financement.getPays_financement()==Pays. المغرب) financement.setPays_geocoordinates("31.794525, -7.0849336");
		if (financement.getPays_financement()==Pays. موزمبيق) financement.setPays_geocoordinates("-18.6696553, 35.5273354");
		if (financement.getPays_financement()==Pays. ميانمار ) financement.setPays_geocoordinates("19.0734647, 96.6710399");
		if (financement.getPays_financement()==Pays.ناميبيا ) financement.setPays_geocoordinates("-22.967062, 18.4929993");
		if (financement.getPays_financement()==Pays.نيبال ) financement.setPays_geocoordinates("28.3973623, 84.12576");
		if (financement.getPays_financement()==Pays.هولندا ) financement.setPays_geocoordinates("52.2129919, 5.2793703");
		if (financement.getPays_financement()==Pays.نيوزيلندا ) financement.setPays_geocoordinates("-43.3744881, 172.4662705");
		if (financement.getPays_financement()==Pays.نيجيريا ) financement.setPays_geocoordinates("9.077751, 8.6774567");
		if (financement.getPays_financement()==Pays.النرويج ) financement.setPays_geocoordinates("64.5783089, 17.888237");
		if (financement.getPays_financement()==Pays.عمان ) financement.setPays_geocoordinates("21.5278654, 55.9196996");
		if (financement.getPays_financement()==Pays.باكستان ) financement.setPays_geocoordinates("30.3894007, 69.3532207");
		if (financement.getPays_financement()==Pays.بنما ) financement.setPays_geocoordinates("8.4255193, -80.1053645");
		if (financement.getPays_financement()==Pays.باراغواي ) financement.setPays_geocoordinates("-23.4380203, -58.4483065");
		if (financement.getPays_financement()==Pays.بيرو) financement.setPays_geocoordinates("-9.1951786, -74.9904165");
		if (financement.getPays_financement()==Pays. الفلبين ) financement.setPays_geocoordinates("11.6978352, 122.6217542");
		if (financement.getPays_financement()==Pays.بولندا ) financement.setPays_geocoordinates("51.9189046, 19.1343786");
		if (financement.getPays_financement()==Pays.البرتغال ) financement.setPays_geocoordinates("39.557191, -7.8536599");
		if (financement.getPays_financement()==Pays.قطر ) financement.setPays_geocoordinates("25.3271054, 51.1966577");
		if (financement.getPays_financement()==Pays.رومانيا ) financement.setPays_geocoordinates("45.9442858, 25.0094303");
		if (financement.getPays_financement()==Pays.روسيا ) financement.setPays_geocoordinates("55.0, 103.0");
		if (financement.getPays_financement()==Pays.فلسطين) financement.setPays_geocoordinates("31.947351, 35.227163");
		if (financement.getPays_financement()==Pays. رواندا ) financement.setPays_geocoordinates("-1.9437057, 29.8805778");
		if (financement.getPays_financement()==Pays.السعودية ) financement.setPays_geocoordinates("24.266906, 45.107849");
		if (financement.getPays_financement()==Pays.السنغال ) financement.setPays_geocoordinates("14.5001717, -14.4392276");
		if (financement.getPays_financement()==Pays.صربيا ) financement.setPays_geocoordinates("44.2107675, 20.9224158");
		if (financement.getPays_financement()==Pays.سيشيل ) financement.setPays_geocoordinates("-4.6838871, 55.4494781");
		if (financement.getPays_financement()==Pays.سيراليون ) financement.setPays_geocoordinates("8.4494988, -11.7868289");
		if (financement.getPays_financement()==Pays.سنغافورة ) financement.setPays_geocoordinates("1.3146631, 103.8454093");
		if (financement.getPays_financement()==Pays.سلوفاكيا ) financement.setPays_geocoordinates("48.6737532, 19.696058");
		if (financement.getPays_financement()==Pays.سلوفينيا ) financement.setPays_geocoordinates("46.1491664, 14.9860106");
		if (financement.getPays_financement()==Pays.الصومال ) financement.setPays_geocoordinates("5.1632866, 46.2037008");
		if (financement.getPays_financement()==Pays.جنوب_إفريقيا ) financement.setPays_geocoordinates("-28.4792625, 24.6727135");
		if (financement.getPays_financement()==Pays.إسبانيا) financement.setPays_geocoordinates("40.2085, -3.713");
		if (financement.getPays_financement()==Pays. سريلانكا ) financement.setPays_geocoordinates("7.8774222, 80.7003428");
		if (financement.getPays_financement()==Pays.السودان ) financement.setPays_geocoordinates("15.7860696, 30.1995791");
		if (financement.getPays_financement()==Pays.سوازيلاند ) financement.setPays_geocoordinates("-26.5179414, 31.4629694");
		if (financement.getPays_financement()==Pays.السويد ) financement.setPays_geocoordinates("62.1983366, 17.5671981");
		if (financement.getPays_financement()==Pays.سويسرا) financement.setPays_geocoordinates("46.8131873, 8.22421");
		if (financement.getPays_financement()==Pays. سوريا) financement.setPays_geocoordinates("34.8149145, 39.0464523");
		if (financement.getPays_financement()==Pays. تايوان ) financement.setPays_geocoordinates("23.553118, 121.0211024");
		if (financement.getPays_financement()==Pays.طاجيكستان ) financement.setPays_geocoordinates("38.8581784, 71.2479841");
		if (financement.getPays_financement()==Pays.تنزانيا ) financement.setPays_geocoordinates("-6.3728253, 34.8924826");
		if (financement.getPays_financement()==Pays.تايلاند ) financement.setPays_geocoordinates("13.03887, 101.490104");
		if (financement.getPays_financement()==Pays.توغو) financement.setPays_geocoordinates("8.6259267, 0.8325041");
		if (financement.getPays_financement()==Pays. تونس) financement.setPays_geocoordinates("33.7931605, 9.5607653");
		if (financement.getPays_financement()==Pays. تركيا) financement.setPays_geocoordinates("38.9573415, 35.240741");
		if (financement.getPays_financement()==Pays. تركمانستان ) financement.setPays_geocoordinates("38.963802, 59.5775989");
		if (financement.getPays_financement()==Pays.أوغندا ) financement.setPays_geocoordinates("1.3707295, 32.3032414");
		if (financement.getPays_financement()==Pays.أوكرانيا) financement.setPays_geocoordinates("48.383022, 31.1828699");
		if (financement.getPays_financement()==Pays. الإمارات) financement.setPays_geocoordinates("24.3505839, 53.9396418");
		if (financement.getPays_financement()==Pays. بريطانيا) financement.setPays_geocoordinates("55.3617609, -3.4433238");
		if (financement.getPays_financement()==Pays. الولايات_المتحدة_الأمريكية ) financement.setPays_geocoordinates("37.6, -95.665");
		if (financement.getPays_financement()==Pays.أوروغواي ) financement.setPays_geocoordinates("-32.5583168, -55.811697");
		if (financement.getPays_financement()==Pays.أوزبكستان) financement.setPays_geocoordinates("41.381166, 64.5735819");
		if (financement.getPays_financement()==Pays. فنزويلا ) financement.setPays_geocoordinates("5.1632955, -69.4146705");
		if (financement.getPays_financement()==Pays.فيتنام ) financement.setPays_geocoordinates("15.9030623, 105.8066925");
		if (financement.getPays_financement()==Pays.اليمن) financement.setPays_geocoordinates("15.5539046, 48.1748476");

	}

}
