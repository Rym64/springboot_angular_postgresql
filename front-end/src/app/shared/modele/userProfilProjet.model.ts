import { Profil } from './profil.model';
import { Projet } from './projet.model';
import { User } from './user.model';

export class UserProfilProjet {
    id : number;
    user : User;
    profil : Profil;
    projet : Projet;
}