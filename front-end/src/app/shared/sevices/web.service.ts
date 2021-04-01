import { Observable } from 'rxjs';
import { Projet } from '../modele/projet.model';
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { User } from '../modele/user.model';
import { Decomposition } from '../modele/decomposition.model';
import { FinancementEtranger } from '../../shared/modele/financementEtranger.model';
import { AutreFinancement } from '../../shared/modele/autreFinancement.model';
import { AppelOffre } from '../../shared/modele/appelOffre.model';
import { LotAppelOffre } from '../../shared/modele/lotAppelOffre.model';
import { Marche } from '../modele/marche.model';
import { Facture } from '../modele/facture.model';
import { FormGroup } from '@angular/forms';
import { Objectif } from '../modele/objectif.model';
import { Indicateur } from '../modele/indicateur.model';
import { UserProfilProjet } from '../modele/userProfilProjet.model';



@Injectable()
export class WebService {



  constructor(private httpClient: HttpClient) { }



  private financementEtranger = new FinancementEtranger();
  private autreFinancement = new AutreFinancement();
  private projet = new Projet();
  private user = new User();
  private decomposition = new Decomposition();
  private appelOffre = new AppelOffre();
  private lotAppelOffre = new LotAppelOffre();
  private marche = new Marche();
  private facture = new Facture();
  private objectif = new Objectif();
  private indicateur = new Indicateur();
  private userProfilProjet = new UserProfilProjet();
  public dataForm:  FormGroup; 

  serverUrl: string = "http://localhost:8080/"


  
  get(url: string): Observable<any> {
    return this.httpClient.get(this.serverUrl + url);
  }

  getProfil(url: string,project:string): Observable<any> {
    return this.httpClient.get(`${this.serverUrl + url}/${project}`);
  }

  createProjet(url: string, data: Projet): Observable<any> {
    return this.httpClient.post(this.serverUrl + url, data);
  }

  createUser(url: string, formData: FormData): Observable<any> {
    return this.httpClient.post(this.serverUrl + url, formData);
  }



  createFinancementEtranger(url: string, data: FinancementEtranger): Observable<any> {
    return this.httpClient.post(this.serverUrl + url, data);
  }

  createAutreFinancement(url: string, data: AutreFinancement): Observable<any> {
    return this.httpClient.post(this.serverUrl + url, data);
  }

  createDecomposition(url: string, data: Decomposition): Observable<any> {
    return this.httpClient.post(this.serverUrl + url, data);
  }

  createAppelOffre(url: string, data: AppelOffre): Observable<any> {
    return this.httpClient.post(this.serverUrl + url, data);
  }

  createLotAppelOffre(url: string, data: LotAppelOffre): Observable<any> {
    return this.httpClient.post(this.serverUrl + url, data);
  }

  createMarche(url: string, data: Marche): Observable<any> {
    return this.httpClient.post(this.serverUrl + url, data);
  }

  createFacture(url: string, data: Facture): Observable<any> {
    return this.httpClient.post(this.serverUrl + url, data);
  }

  createObjectif(url: string, data: Objectif): Observable<any> {
    return this.httpClient.post(this.serverUrl + url, data);
  }

  createIndicateur(url: string, data: Indicateur): Observable<any> {
    return this.httpClient.post(this.serverUrl + url, data);
  }
  createUserProfilProjet(url: string, data: UserProfilProjet): Observable<any> {
    return this.httpClient.post(this.serverUrl + url, data);
  }

  update(url: string, value: any): Observable<Object> {
    return this.httpClient.post(this.serverUrl + url, value);
  }

 

  deleteProjet(url: string, data: Projet): Observable<any> {
    return this.httpClient.delete(this.serverUrl + url, { params: { code: data.code + "" } });
  }

  deleteUser(url: string, data: User): Observable<any> {
    return this.httpClient.delete(this.serverUrl + url, { params: { username: data.username + "" } });
  }
 


  deleteFinancementEtranger(url: string, data: FinancementEtranger): Observable<any> {
    return this.httpClient.delete(this.serverUrl + url, { params: { code: data.code + "" } });
  }

  deleteAutreFinancement(url: string, data: AutreFinancement): Observable<any> {
    return this.httpClient.delete(this.serverUrl + url, { params: { code: data.code + "" } });
  }

  deleteDecomposition(url: string, data: Decomposition): Observable<any> {
    return this.httpClient.delete(this.serverUrl + url, { params: { id: data.id + "" } });
  }

  deleteAppelOffre(url: string, data: AppelOffre): Observable<any> {
    return this.httpClient.delete(this.serverUrl + url, { params: { code: data.code + "" } });
  }

  deleteLotAppelOffre(url: string, data: LotAppelOffre): Observable<any> {
    return this.httpClient.delete(this.serverUrl + url, { params: { code: data.code + "" } });
  }

  deleteMarche(url: string, data: Marche): Observable<any> {
    return this.httpClient.delete(this.serverUrl + url, { params: { code: data.code + "" } });
  }

  deleteFacture(url: string, data: Facture): Observable<any> {
    return this.httpClient.delete(this.serverUrl + url, { params: { code: data.code + "" } });
  }

  deleteObjectif(url: string, data: Objectif): Observable<any> {
    return this.httpClient.delete(this.serverUrl + url, { params: { code: data.code + "" } });
  }

  deleteIndicateur(url: string, data: Indicateur): Observable<any> {
    return this.httpClient.delete(this.serverUrl + url, { params: { code: data.code + "" } });
  }

  deleteUserProfilProjet(url: string, data: UserProfilProjet): Observable<any> {
    return this.httpClient.delete(this.serverUrl + url, { params: { id: data.id + "" } });
  }


  loginUser(url: string, data: User): Observable<number> {

    return this.httpClient.post<number>(this.serverUrl + url, data);
  }

  loginAdmin(url: string, data: User): Observable<any> {

    return this.httpClient.post(this.serverUrl + url, data);
  }

  loginAdminCni(url: string, data: User): Observable<any> {

    return this.httpClient.post(this.serverUrl + url, data);
  }

  loggedOut(url: string): Observable<any> {
    return this.httpClient.get(this.serverUrl + url);
  }

 

  setterProjet(projet: Projet) {
    this.projet = projet;
  }
  getterProjet() {
    return this.projet;
  }

  setterUser(user: User) {
    this.user = user;
  }
  getterUser() {
    return this.user;
  }



  setterFinancementEtranger(financementEtranger: FinancementEtranger) {
    this.financementEtranger = financementEtranger;
  }
  getterFinancementEtranger() {
    return this.financementEtranger;
  }

  setterAutreFinancement(autreFinancement: AutreFinancement) {
    this.autreFinancement = autreFinancement;
  }
  getterAutreFinancement() {
    return this.autreFinancement;
  }

  setterDecomposition(decomposition: Decomposition) {
    this.decomposition = decomposition;
  }
  getterDecomposition() {
    return this.decomposition;
  }


  setterAppelOffre(appelOffre: AppelOffre) {
    this.appelOffre = appelOffre;
  }
  getterAppelOffre() {
    return this.appelOffre;
  }

  setterLotAppelOffre(lotAppelOffre: LotAppelOffre) {
    this.lotAppelOffre = lotAppelOffre;
  }
  getterLotAppelOffre() {
    return this.lotAppelOffre;
  }

  
  setterMarche(marche: Marche) {
    this.marche = marche;
  }
  getterMarche() {
    return this.marche;
  }

   
  setterFacture(facture: Facture) {
    this.facture = facture;
  }
  getterFacture() {
    return this.facture;
  }

  setterObjectif(objectif: Objectif) {
    this.objectif = objectif;
  }
  getterObjectif() {
    return this.objectif;
  }

  setterIndicateur(indicateur: Indicateur) {
    this.indicateur = indicateur;
  }
  getterIndicateur() {
    return this.indicateur;
  }

  setterUserProfilProjet(userProfilProjet: UserProfilProjet) {
    this.userProfilProjet = userProfilProjet;
  }
  getterUserProfilProjet() {
    return this.userProfilProjet;
  }
  

  rechercher(url: string,recherche: string): Observable<any> {
 
    return this.httpClient.get(`${this.serverUrl + url}/${recherche}`);}




}