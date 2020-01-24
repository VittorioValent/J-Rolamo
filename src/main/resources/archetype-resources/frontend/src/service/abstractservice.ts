import { Service } from './service';
import { Observable, from } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Page } from '../app/utils/page';
import { Direction } from 'src/app/utils/direction';
import { Pageable } from 'src/app/utils/pageable';
import { Filter } from 'src/app/utils/filter';
import { filter } from 'rxjs/operators';
import { FieldInfoDTO } from 'src/dto/field-info-dto';

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

    getDisplayedColumns(): Observable<FieldInfoDTO[]> {
        let params = new HttpParams()
            .set('entityName', this.type.toString());
        return this._http.get<FieldInfoDTO[]>('http://localhost:' + this.port + '/api/public/entity/displayedColumns', { headers: this.getAuthHeaders(), params: params });
    }

    getDisplayedFilters(): Observable<FieldInfoDTO[]> {
        let params = new HttpParams()
            .set('entityName', this.type.toString());
        return this._http.get<FieldInfoDTO[]>('http://localhost:' + this.port + '/api/public/entity/displayedFilters', { headers: this.getAuthHeaders(), params: params });

    }

    getAll(pageSize: number, pageIndex: number, sortField: string, direction: Direction, filters?: Filter[]): Observable<Page<DTO>> {
        let params = new HttpParams()
            .set('pageSize', pageSize.toString())
            .set('pageNumber', pageIndex.toString())
            .set('sortField', sortField.toString())
            .set('direction', direction.toString());

        if (filters != undefined) {
            filters.forEach(filter => {
                params = params.set(filter.filterKey, filter.filterValue);
            });
        }
        return this._http.get<Page<DTO>>('http://localhost:' + this.port + '/api/' + this.type + '/all', { headers: this.getAuthHeaders(), params: params });
    }

    read(id: number): Observable<DTO> {
        return this._http.get<DTO>('http://localhost:' + this.port + '/api/' + this.type + '/read?id=' + id, { headers: this.getAuthHeaders() });
    }

    delete(id: number): Observable<any> {
        return this._http.delete('http://localhost:' + this.port + '/api/' + this.type + '/delete?id=' + id, { headers: this.getAuthHeaders() });
    }

    insert(dto: DTO): Observable<any> {
        return this._http.post('http://localhost:' + this.port + '/api/' + this.type + '/create', dto, { headers: this.getAuthHeaders() });
    }

    update(dto: DTO): Observable<DTO> {
        return this._http.put<DTO>('http://localhost:' + this.port + '/api/' + this.type + '/update', dto, { headers: this.getAuthHeaders() });
    }

    merge(dto: DTO): Observable<DTO> {
        return this._http.patch<DTO>('http://localhost:' + this.port + '/api/' + this.type + '/update', dto, { headers: this.getAuthHeaders() });
    }

    getAuthHeaders(): HttpHeaders {
        const headers = new HttpHeaders()
        .append('Access-Control-Allow-Origin', '*')
        .append('Authorization', 'Bearer ' + JSON.parse(localStorage.getItem('authToken')).token);
        return headers;
    }

}