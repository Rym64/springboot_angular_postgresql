import { Marche } from './marche.model';

export class Facture {
    code : string;
    
    date_facture : Date;
    montant : number;
    montant_paye : number;
    date_payement : Date;
    marche : Marche;
    
}