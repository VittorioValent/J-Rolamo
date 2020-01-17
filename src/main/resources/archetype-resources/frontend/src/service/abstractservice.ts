import { Service } from './service';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

/**
 * Service astratto, implementa tutti i metodi CRUD inviando request al server di SpringBoot. 
 * @param port il port del backend
 * @param type la mappatura del controller di ciascuna entità.
 * 
 * @see Service
 * 
 * @author Vittorio Valent
 */
export abstract class AbstractService<DTO> implements Service<DTO> {

    type: string;
    port: string = '8081';

    

    constructor(protected _http: HttpClient) {
    }

 
    getAll(): Observable<any> {
        const headers = new HttpHeaders()
        .append('Access-Control-Allow-Origin', '*')
        .append('Authorization', 'Bearer' + JSON.parse(localStorage.getItem('authToken')).token);;
    
        return this._http.get<any>('http://localhost:' + this.port + '/api/' + this.type + '/all', {headers});
    }

    read(id: number): Observable<DTO> {
        const headers = new HttpHeaders()
        .append('Access-Control-Allow-Origin', '*')
        .append('Authorization', 'Bearer' + JSON.parse(localStorage.getItem('authToken')).token);;
    
        return this._http.get<DTO>('http://localhost:' + this.port + '/api/' + this.type + '/read?id=' + id, {headers});
    }

    delete(id: number): Observable<any> {
        const headers = new HttpHeaders()
        .append('Access-Control-Allow-Origin', '*')
        .append('Authorization', 'Bearer' + JSON.parse(localStorage.getItem('authToken')).token);;
    
        return this._http.delete('http://localhost:' + this.port + '/api/' + this.type + '/delete?id=' + id, {headers});
    }

    insert(dto: DTO): Observable<any> {
        const headers = new HttpHeaders()
        .append('Access-Control-Allow-Origin', '*')
        .append('Authorization', 'Bearer' + JSON.parse(localStorage.getItem('authToken')).token);;
    
        return this._http.post('http://localhost:' + this.port + '/api/' + this.type + '/insert', dto, {headers});
    }

    update(dto: DTO): Observable<DTO> {
        const headers = new HttpHeaders()
        .append('Access-Control-Allow-Origin', '*')
        .append('Authorization', 'Bearer' + JSON.parse(localStorage.getItem('authToken')).token);;
    
        return this._http.put<DTO>('http://localhost:' + this.port + '/api/' + this.type + '/update', dto, {headers});

    }

}