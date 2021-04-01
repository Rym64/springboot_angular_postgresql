import { Objectif } from './objectif.model';

export class Indicateur {
    code : string;
    libelle : string;
    description : string;
    type_indicateur : string;
    objectif : Objectif;
}