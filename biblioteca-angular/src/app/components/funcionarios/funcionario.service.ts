
import { Injectable } from '@angular/core';

import { tap, first, catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class FuncionarioService {

  private readonly API = 'api/livros';



  constructor(private httpClient: HttpClient) {
}

  public upload(formData: any){
    return this.httpClient.post<any>(this.API, formData, {
      reportProgress: true,
      observe: 'events'
    });
  }
}
