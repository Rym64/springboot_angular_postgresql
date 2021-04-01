import { Projet } from './projet.model';

export class AutreFinancement {
    code : string;
    libelle : string;
    date_autre_financement : Date;
    montant : number;
    montant_actualise : number;
    date_actualisation : Date;
    projet : Projet;
    
}