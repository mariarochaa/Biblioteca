import { UserserviceService } from '../../funcionarios/userservice.service';

import { Component, OnInit } from '@angular/core';
import { FormControl, Validators, FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent {

  hide = true;
  email = new FormControl('', [Validators.required, Validators.email]);

  getErrorMessage() {
    if (this.email.hasError('required')) {
      return 'You must enter a value';
    }

    return this.email.hasError('email') ? 'Not a valid email' : '';
  }


  // fazerlogin(){
  //     console.log(this.email);
  //     console.log(this.password);
  //     // this.userserviceService.fazerLogin(this.form);
  // }

  // onSubmit(): void {
  //   if (this.email.valid) {
  //     this.userserviceService.getAll().subscribe;
  //   }
  // }
}
