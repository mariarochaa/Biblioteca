import { catchError } from 'rxjs/operators';
import { Observable, of } from 'rxjs';

import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CategoriasService } from '../../categorias.service';
import { Categoria } from 'src/app/livros/model/categoria';

@Component({
  selector: 'app-categoria-read',
  templateUrl: './categoria-read.component.html',
  styleUrls: ['./categoria-read.component.css']
})
export class CategoriaReadComponent implements OnInit {

  categorias$: Observable<Categoria[]>;
  displayedColumns: string[] = ["codigo", "nomeCategoria", "livros"];

  constructor(private categoriaservice: CategoriasService,
  private router: Router,
  private route: ActivatedRoute) {

    this.categorias$ = this.categoriaservice.list()
    // .pipe(
    //   catchError(error => {
    //     this.onError('Erro ao carregar cursos.');
    //     return of([])
    //   })
    // );
   }




  ngOnInit(): void {
    //this.findAll();
  }

  // findAll() {
  //   this.categoriaservice.findAll().subscribe((resposta) => {
  //     console.log(resposta);
  //     this.categorias$ = resposta;
  //   });
  // }

}
