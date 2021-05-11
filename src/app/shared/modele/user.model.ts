import { EnumGouvernorat } from './enumGouvernorat.model';
import { EnumRole } from './enumRole.model';
import { EnumSexe } from './enumSexe.model';
import { Etablissement } from './etablissement.model';
import { UserProfilProjet } from './userProfilProjet.model';



export class User {
    username: string;
    name: string;
    last_name: string;
    email: string;
    password: string;
    sexe : EnumSexe;
    date_naissance : Date;
    adresse : EnumGouvernorat;
    role: EnumRole ;
    fileName: any;
    etablissement : Etablissement;
    utilisateursProfilsProjets : Array<UserProfilProjet>;
}