import { EnumTypeObjectif } from './enumTypeObjectif.model';
import { Indicateur } from './indicateur.model';
import { Projet } from './projet.model';

export class Objectif {
    code : string;
    libelle : string;
    type_objectif : EnumTypeObjectif;
    description : string;
    projet : Projet;
    indicateurs : Array<Indicateur>;
}