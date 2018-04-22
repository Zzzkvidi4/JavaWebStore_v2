import {Injectable} from '@angular/core';
import {User} from "../../models/user";
import {Observable} from "rxjs/Observable";
import {HttpClient, HttpResponse} from "@angular/common/http";
import {url} from "../../configs"

@Injectable()
export class UserService {

  constructor(private http: HttpClient) { }

  getUserInfo(id: number): Observable<HttpResponse<User>> {
    return this.http.get<User>(url + "/users/" + id, { withCredentials: true, observe: "response"});
  }

  login(username: string, password: string): Observable<HttpResponse<any>> {
    return this.http.post<any>(url + "/login?username=" + username + "&password=" + password, null, { withCredentials: true, observe: "response"})
  }

  register(user: User): Observable<HttpResponse<any>> {
    return this.http.post<any>(url + "/register", user, { withCredentials: true, observe: "response"})
  }
}
