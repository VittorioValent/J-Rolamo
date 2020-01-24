import { Direction } from './direction';

export class Pageable {

    sortField: string;

    pageNumber: number;

    pageSize: number;

    totalPages: number;

    direction: Direction;
}