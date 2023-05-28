import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { MockService } from '../services/mock.service';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  constructor(private router: Router, private service: MockService){}

  email : string = '';
  password : string = '';
  number: string = '';

  formClicked(fm: NgForm){
    // console.log(`${this.email} + ${this.password}`);
    this.service.addUser(this.email, this.password);
    this.router.navigate(['/login']);
  }

}
