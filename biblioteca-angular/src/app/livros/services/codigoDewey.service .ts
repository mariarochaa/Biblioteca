import { CodigoDewey} from '../model/livros';
import { Injectable } from '@angular/core';
// import { HttpClient } from '@angular/common/http';
import { tap, first, catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CodigoDeweyService {

  private readonly API = ' /api/CodigoDeweys';

  constructor(private httpClient: HttpClient) { }

  list() {

    return this.httpClient.get<CodigoDewey[]>(this.API)
    .pipe(
      first(),
      tap(cd => console.log(cd))
    );
  }


  save(record: CodigoDewey){
    return this.httpClient.post<CodigoDewey>(this.API, record).pipe(first());
  }

  /** GET livro by id. Will 404 if id not found */
  readById(id: number): Observable<CodigoDewey> {
  const url = `${this.API}/${id}`;
  return this.httpClient.get<CodigoDewey>(url);
  //  .pipe(
  //   tap(_ => this.log(`fetched hero id=${id}`)),
  //   catchError(this.handleError<Hero>(`getHero id=${id}`))
 // );
}

getCodigoDewey(): Observable<CodigoDewey> {
  return this.httpClient.get<CodigoDewey>(this.API);
 }

 readByIdCat(codigo: string): Observable<CodigoDewey> {
  const url = `${this.API}/${codigo}`;
  return this.httpClient.get<CodigoDewey>(url);
}
}
