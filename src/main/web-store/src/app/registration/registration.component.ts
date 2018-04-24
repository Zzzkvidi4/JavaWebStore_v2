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
    this.userService.register(this.user).subscribe(resp => console.log(resp));
  }
}
