import { EnumEtatAppelOffre } from './enumEtatAppelOffre.model';
import { Projet } from './projet.model';

export class AppelOffre {
    code : string;
    libelle : string;
    date_appel_offre : Date;
    montant_estime : number;
    montant_actualise : number;
    date_actualisation : Date;
    etat : EnumEtatAppelOffre;
    projet : Projet;

    
}