import {Component, OnInit} from '@angular/core';
import {UserService} from "../services/user-service/user.service";
import {ActivatedRoute} from "@angular/router";
import {Location} from '@angular/common';
import {User} from "../models/user";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  user: User = null;

  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private userService: UserService) { }

  ngOnInit() {
    this.getUserInfo();
  }

  getUserInfo() {
    const id = +this.route.snapshot.paramMap.get('userId');
    this.userService.getUserInfo(id).subscribe(resp => {
        console.log(resp);
        if (resp.status != 200) {
          this.location.go("/login")
        } else {
          this.user = resp.body.data;
        }
      }
    );
  }
}
