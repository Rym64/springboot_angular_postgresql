import { Component, OnInit } from '@angular/core';
import { Decomposition } from '../../../shared/modele/decomposition.model';
import { ActivatedRoute, Router } from '@angular/router';
import pdfMake from 'pdfmake/build/pdfmake';
import pdfFonts from 'pdfmake/build/vfs_fonts';
pdfMake.vfs = pdfFonts.pdfMake.vfs;
import { WebService } from '../../../shared/sevices/web.service';


@Component({
  selector: 'app-rechercher-decomposition',
  templateUrl: './rechercher-decomposition.component.html',
  styleUrls: ['./rechercher-decomposition.component.css']
})



export class RechercherDecompositionComponent implements OnInit {
  
  decomposition: Decomposition = undefined
  recherche: string
  decompositionsList: Array<Decomposition>


  constructor(private route: ActivatedRoute,private webService: WebService, private router: Router) { }


  ngOnInit() {
    this.recherche = this.route.snapshot.params['recherche'];
    this.webService.rechercher("rechercherDecomposition",this.recherche).subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.decompositionsList = response; })
  }


  downloadPdf(){

  }


  
  rechercherDecomposition(recherche){
    this.router.navigate(['rechercherDecomposition', recherche]); 
  }

}

