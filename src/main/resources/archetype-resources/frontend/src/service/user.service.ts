import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { UserDTO } from '../dto/user-dto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from '../dto/login-dto';
import { Observable } from 'rxjs';
import { AuthToken } from '../dto/auth-token';
/**
 * I service sono decorati da @Injectable.
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 *
 * @author Vittorio Valent
 *
 * @see AbstractService
 */
@Injectable({
  providedIn: 'root'
})
export class UserService extends AbstractService<UserDTO> {
  constructor(http: HttpClient) {
    super(http);
    this.type = 'user';
  }
  login(loginDTO: LoginDTO): Observable<AuthToken> {
    return this._http.post<AuthToken>('http://localhost:8081/authentication/public/authenticate', loginDTO);
  }
}
