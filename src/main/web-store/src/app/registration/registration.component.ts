import {Component, OnInit} from '@angular/core';
import {User} from "../models/user";
import {UserService} from "../services/user-service/user.service";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  user: User;
  passwordConfirmation: string = "";
  messages: string[];

  constructor(private userService: UserService) {}

  ngOnInit() {
    this.user = new User();
    this.user.name = "";
    this.user.surname = "";
    this.user.login = "";
    this.user.password = "";
    this.user.email = "";
  }

  register() {
    if (this.isUserValid()) {
      this.userService.register(this.user).subscribe(
        resp => {
          console.log(resp);
          if (resp.body.errors.length != 0) {
            this.messages = resp.body.errors;
          }
        }, error => {

        }
      );
    }
  }

  isUserValid() {
    this.messages = [];
    if (this.user.email.length <= 5) {
      this.messages.push("Email is too short!");
    }
    if (this.user.login.length <= 5) {
      this.messages.push("Login is too short!");
    }
    if (this.user.password.length <= 5) {
      this.messages.push("Password is too short!");
    }
    if (this.user.password != this.passwordConfirmation) {
      this.messages.push("Password and confirmation not equals!")
    }
    return this.messages.length == 0;
  }
}
