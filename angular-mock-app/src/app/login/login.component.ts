import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MockService } from '../services/mock.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;
  unauthorised: string = "";

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private service: MockService
  ) {}

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.pattern(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/)]],
      password: ['', Validators.required]
    });
  }

  onSubmit(loginForm: FormGroup) {
    if (this.loginForm.valid) {
      const nav: boolean = this.service.validateUser(
        this.loginForm.value.email,
        this.loginForm.value.password
      );

      if (nav) {
        this.router.navigate(['/home']);
      } else {
        this.unauthorised = "unauthorised";
      }
    }
  }
}
