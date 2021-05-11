import { EnumPays } from './enumPays.model';
import { Facture } from './facture.model';
import { LotAppelOffre } from './lotAppelOffre.model';

export class Marche {
	code : string;
	libelle : string;
	fournisseur : string;
	devise : string;
	pays_marche : EnumPays;
	montant_dt : number;
	montant_actualise : number;
	date_signature : Date;
	periode_travail : number;
	date_fin_travaux_estimee : Date;
	date_fin_travaux_reelle : Date;
	niveau : number;
	lotAppelOffre: LotAppelOffre;
	factures : Array<Facture>;
    
}