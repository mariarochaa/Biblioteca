import { User } from '../../livros/model/Login';

import { Router } from '@angular/router';
import { EventEmitter, Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class User2Service {

  private loggedIn = new BehaviorSubject<boolean>(false);

  isLoggedIn$ = this.loggedIn.asObservable();

  constructor(private router: Router) {}

  login(user: User): void {
    localStorage.setItem('token', user.password);
    this.updateLoggedIn();
    this.router.navigate(['/admin']);
  }

  logout(): void {
    localStorage.clear();
    this.updateLoggedIn();
    this.router.navigate(['/login']);
  }

  updateLoggedIn(): void {
    const token = localStorage.getItem('token');
    if (token) {
      this.loggedIn.next(true);
    } else {
      this.loggedIn.next(false);
    }
  }
}
