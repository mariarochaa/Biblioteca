
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ILivro } from 'src/app/livros/model/livros';

@Injectable({
  providedIn: 'root'
})
export class LivroService {

  private readonly API = ' api';

  constructor(private httpClient: HttpClient) { }

  findAllByCategoria(codigo: String): Observable<ILivro[]> {
    const url = `${this.API}/livros?categorias=${codigo}`
    return this.httpClient.get<ILivro[]>(url)
  }
}
