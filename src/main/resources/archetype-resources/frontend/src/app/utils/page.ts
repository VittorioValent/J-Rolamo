import { Pageable } from './pageable';
import { Sort } from './sort';

export class Page<DTO> {

    content: DTO[];

    pageable: Pageable;

    sort: Sort;

    totalElements: number;

    totalPages: number;

    last: number;

    first: number;

    numberOfElements: number;

    size: number;

    number: number;
    
    empty: boolean;
}