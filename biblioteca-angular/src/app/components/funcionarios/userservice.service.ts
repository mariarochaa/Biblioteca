import { HttpClient } from '@angular/common/http';
import { User } from 'src/app/livros/model/Login';
import { Router } from '@angular/router';
import { EventEmitter, Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserserviceService {

  private readonly API = 'api/users';
  private loggedIn = new BehaviorSubject<boolean>(false);

  // final com $ seguinifica Observable
  isLoggedIn$ = this.loggedIn.asObservable();

  private usuarioAutenticado: boolean = false;

  mostrarMenuEmitter = new EventEmitter<boolean>();


  constructor(private httpClient: HttpClient, private router: Router) { }

  // // Quando for realizar a chamada pro back, tirar o void
  // login(user: User): void {
  //   this.API.setItem('token', user.password);
  //   this.loggedIn.next(true);
  //   this.router.navigate(['/admin']);
  //   // trocar dashbord por pagina de tabale de livros
  // }

  getAll(): Observable<User> {
    return this.httpClient.get<User>(this.API);
   }

   fazerLogin(usuario: User){

    if (usuario.email === 'usuario@email.com' &&
      usuario.password === '123456') {

      this.usuarioAutenticado = true;

      this.mostrarMenuEmitter.emit(true);

      this.router.navigate(['/admin']);

    } else {
      this.usuarioAutenticado = false;


    }
  }

  usuarioEstaAutenticado(){
    return this.usuarioAutenticado;
  }


}
