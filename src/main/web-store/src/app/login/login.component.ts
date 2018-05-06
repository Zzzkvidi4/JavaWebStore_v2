import {Component, OnInit} from '@angular/core';
import {UserService} from "../services/user-service/user.service";
import {Router} from "@angular/router";
import {AppComponent} from "../app.component";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username: string;
  password: string;
  messages: string[];

  constructor(
    private userService: UserService,
    private router: Router,
    private app: AppComponent
  ) { }

  ngOnInit() {
  }

  login(){
    this.userService.login(this.username, this.password).subscribe(
      resp => {
        console.log(resp);
        this.messages = resp.body.errors;
        if (this.messages.length == 0) {
          this.router.navigate(["/product_types"]);
        }
      },
      error => {
        console.log(error);
        this.messages = [];
        this.messages.push("Wrong username/password!");
      }
    );
  }

}
