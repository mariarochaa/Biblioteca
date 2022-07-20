import { Categoria } from './../model/categoria';
import { ILivro} from './../model/livros';
import { Injectable } from '@angular/core';
import { tap, first, catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LivrosService {

  private readonly API = 'api/livros';
  private readonly APICategoria = ' api/livros/categorias';
  private livros: Observable<ILivro[]> | undefined;


  constructor(private httpClient: HttpClient) {
}

  list() {

    return this.httpClient.get<ILivro[]>(this.API)
    .pipe(

      first(),
      tap(livros => console.log(livros))
    );
  }

  getAll(): Observable<ILivro> {
    return this.httpClient.get<ILivro>(this.API);
   }
  save(record: ILivro){
    return this.httpClient.post<ILivro>(this.API, record).pipe(first());
  }

  /** GET livro by id. Will 404 if id not found */
  readById(id: number): Observable<ILivro> {
  const url = `${this.API}/${id}`;
  return this.httpClient.get<ILivro>(url);

}

getProductCategories(): Observable<Categoria> {
  return this.httpClient.get<Categoria>(this.APICategoria);
 }

 readByIdCat(codigo: string): Observable<Categoria> {
  const url = `${this.APICategoria}/${codigo}`;
  return this.httpClient.get<Categoria>(url);
}

getAlll() {
  return this.livros;
}

}
