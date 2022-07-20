import { User2Service } from './user2.service';

import { User } from '../../livros/model/Login';
import { Component, OnInit } from '@angular/core';
import { FormControl, Validators, FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-login2',
  templateUrl: './login2.component.html',
  styleUrls: ['./login2.component.css']
})

export class LoginComponent {


  form = this.fb.group({
    email: [
      { value: 'admin@admin.com', disabled: true },
      [Validators.email, Validators.required],
    ],
    password: ['', [Validators.required, Validators.minLength(10)]],
  });

  constructor(private authService: User2Service, private fb: FormBuilder) {}

  onSubmit(): void {
    if (this.form.valid) {
      //this.authService.login(this.form.value);
    }
  }
}
