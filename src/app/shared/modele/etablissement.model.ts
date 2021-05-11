import { EnumGouvernorat } from './enumGouvernorat.model';
import { Projet } from './projet.model';
import { User } from './user.model';

export class Etablissement {
    code : string;
    nom : string;
    adresse : EnumGouvernorat;
    num_tel : string;
    projets : Array<Projet>;
    users : Array<User>

}