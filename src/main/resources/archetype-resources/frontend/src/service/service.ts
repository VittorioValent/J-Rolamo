import { Observable } from 'rxjs';
import { Page } from 'src/app/utils/page';
import { Direction } from 'src/app/utils/direction';
import { Filter } from 'src/app/utils/filter';

/**
 * Interfaccia che firma i metodi per le CRUD. Per dettagli sul pattern Observer far riferimento alla guida
 * o cercare online (raccomando la seconda, siate autonomi!).
 * 
 * @author Vittorio Valent
 * 
 * @see AbstractService
 */
export interface Service<DTO> {

    read(id: number): Observable<DTO>;

    delete(id: number): Observable<any>;

    update(dto: DTO): Observable<any>;

    insert(dto: DTO): Observable<any>;

    getAll(pageSize: number, pageIndex:number, sortField:string, direction:Direction, filter?:Filter[]): Observable<Page<DTO>>
}
