import { LivrosService } from 'src/app/livros/services/livros.service';
import { ILivro } from 'src/app/livros/model/livros';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-todoslivros',
  templateUrl: './todoslivros.component.html',
  styleUrls: ['./todoslivros.component.css']
})
export class TodoslivrosComponent implements OnInit {

  livros$: Observable<ILivro[]>;

  displayedColumns = ['isbn', 'nome', 'categoria', 'autor', 'editora', 'actions'];

  constructor( private livrosService: LivrosService,
    private router: Router,
    private route: ActivatedRoute) {

    this.livros$ = this.livrosService.list()
    // .pipe(
    //   catchError(error => {
    //     this.onError('Erro ao cerregar livros$.');
    //     return of([])
    //   })
    // );
  }

  // onError(errorMgs: string) {
  //   this.dialog.open(ErrorDialogComponent, {
  //     data: errorMgs
  //   });
  // }

  ngOnInit(): void {
  }

  onAdd() {
    this.router.navigate(['/admin/new'], {relativeTo: this.route});
  }
}
