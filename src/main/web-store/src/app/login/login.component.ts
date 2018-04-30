import {Component, OnInit} from '@angular/core';
import {UserService} from "../services/user-service/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username: string;
  password: string;

  constructor(
    private userService: UserService,
    private router: Router
  ) { }

  ngOnInit() {
  }

  login(){
    this.userService.login(this.username, this.password).subscribe(
      resp => {
        console.log(resp);
        this.router.navigate(["/product_types"]);
      }
    );
  }

}
