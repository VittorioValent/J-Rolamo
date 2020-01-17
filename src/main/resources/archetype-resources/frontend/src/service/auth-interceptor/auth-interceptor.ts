import { Injectable } from "@angular/core";
import {
  HttpInterceptor,
  HttpHandler,
  HttpRequest,
  HttpEvent
} from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor() {}

  intercept(
    request: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    const authToken = JSON.parse(localStorage.getItem('authToken'));

    if (!authToken == undefined && !authToken == null) {
      const authRequest = request.clone({
        headers: request.headers.set(
          'Authorization',
          'Bearer ' + authToken.token
        )
      });
      return next.handle(authRequest);
    }
    return next.handle(request);
  }
}
