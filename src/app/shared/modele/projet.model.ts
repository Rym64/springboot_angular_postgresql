import { Secteur } from './secteur.model';
import { EnumGouvernorat } from './enumGouvernorat.model';
import { Etablissement } from './etablissement.model';
import { Decomposition } from './decomposition.model';
import { FinancementEtranger } from './financementEtranger.model';
import { AutreFinancement } from './autreFinancement.model';
import { AppelOffre } from './appelOffre.model';
import { Objectif } from './objectif.model';
import { UserProfilProjet } from './userProfilProjet.model';


export class Projet {
    code: string;
    libelle: string;
    description: string;
    date_debut: Date;
    date_debut_actualisee: Date;
    date_fin: Date;
    date_fin_actualisee: Date;
    cout: number;
    cout_actualise:number;
    secteur: Secteur;
    lieu_projet: EnumGouvernorat;
    stade: string;
    flag: string;
    code_financement_public: string;
    libelle_financement_public: string;
    date_financement_public : Date;
    montant_financement_public : string;
    montant_financement_public_actualise : string;
    date_actualisation_financement_public : Date;
    etablissement : Etablissement;
    decompositions : Array<Decomposition>;
    financementsEtrangers : Array<FinancementEtranger>;
    autresFinancements : Array<AutreFinancement>;
    appelsOffres : Array<AppelOffre>;
    objectifs : Array<Objectif>;
    utilisateursProfilsProjets : Array<UserProfilProjet>;
    



}