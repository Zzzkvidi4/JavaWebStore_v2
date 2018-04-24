import {Injectable} from '@angular/core';
import {User} from "../../models/user";
import {Observable} from "rxjs/Observable";
import {HttpClient, HttpResponse} from "@angular/common/http";
import {url} from "../../configs"
import {JsonHttpResponse} from "../../models/json-http-response";
import {of} from "rxjs/observable/of";
import {catchError} from "rxjs/operators";

@Injectable()
export class UserService {

  constructor(private http: HttpClient) { }

  getUserInfo(id: number): Observable<HttpResponse<JsonHttpResponse<User>>> {
    return this.http.get<JsonHttpResponse<User>>(url + "/users/" + id, { withCredentials: true, observe: "response"});
  }

  login(username: string, password: string): Observable<HttpResponse<any>> {
    return this.http.post<any>(url + "/login?username=" + username + "&password=" + password, null, { withCredentials: true, observe: "response"})
  }

  register(user: User): Observable<HttpResponse<any>> {
    return this.http.post<any>(url + "/register", user, {withCredentials: true, observe: "response"}).pipe(catchError(this.handleError('registration', new HttpResponse())));
  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
