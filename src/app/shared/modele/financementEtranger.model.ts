import { EnumFinanceur } from './enumFinanceur.model';
import { EnumPays } from './enumPays.model';
import { Projet } from './projet.model';

export class FinancementEtranger {
code : string;                          
libelle : string;
devise :string;
pays_financement : EnumPays;      
montant_dt :number;        
montant_actualise :number;
date_actualisation : Date;          
financeur : EnumFinanceur;
date_signature : Date;         
date_debut : Date;
date_cloture : Date;          
date_delai : Date;
projet : Projet;
 }