import { Injectable, OnInit} from '@angular/core';
import { users } from '../user';

@Injectable({
  providedIn: 'root'
})
export class MockService {
  validateUser(email: string, password: string) {
    console.log(this.userDB.find(user => user.email === email && user.password === password));
    if(this.userDB.find(user => user.email === email && user.password === password) != null){
      return true;
    }
    return false;
  }
  userDB: users[] = [{email: 'admin@mail.com', password: 'password'}];
  constructor() { }

  addUser(em: string, pass: string) {
    this.userDB.push({ email: em, password: pass });
    console.log(this.userDB);
  }

  getUserDB(){
    return this.userDB;
  }
}
