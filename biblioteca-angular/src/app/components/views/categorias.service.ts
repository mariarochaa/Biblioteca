import { first, tap } from 'rxjs/operators';
import { Categoria } from 'src/app/livros/model/categoria';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CategoriasService {

  private readonly API = ' api/livros/categorias';

  constructor(private httpClient: HttpClient) { }

  // findAll(): Observable<Categoria[]> {
  //   const url = `${this.API}/categorias`
  //   return this.httpClient.get<Categoria[]>(url)
  // }

list() {
  return this.httpClient.get<Categoria[]>(this.API)
  .pipe(
    first(),
    tap(categorias => console.log(categorias))
  );
}
}
