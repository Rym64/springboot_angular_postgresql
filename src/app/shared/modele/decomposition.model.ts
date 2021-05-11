import { EnumTypeDecomposition } from './enumTypeDecomposition.model';
import { Projet } from './projet.model';

export class Decomposition {
    id : number;
	code : string;
	libelle : string;
    montant : number;
	date_debut : Date ;
	date_debut_actualisee : Date;
	date_fin : Date;
	date_fin_actualisee : Date;
	type_decomposition : EnumTypeDecomposition;
	decomposition_mere : string;
	niveau_decomposition : number;
	degres_decomposition : number;
	projet : Projet;
	}