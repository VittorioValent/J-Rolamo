import { AbstractService } from "src/service/abstractservice";
import { Direction } from "./direction";
import { PageEvent } from "@angular/material/paginator";
import { ViewChild } from "@angular/core";
import { MatSort, MatTableDataSource } from "@angular/material";
import { Filter } from "./filter";

/**
 * @author Vittorio Valent
 *
 * @param DTO
 *
 */
export abstract class TableComponent<DTO> {
  pageSize: number = 10;
  pageIndex: number = 0;
  totalPages: number;
  totalElements: number;
  @ViewChild(MatSort, { static: true }) sort: MatSort;
  sortField: string = "id";

  dto: DTO;
  selected: DTO;
  displayedColumns: string[] = [];
  displayedFilters: string[] = [];
  dataSource: MatTableDataSource<DTO>;
  filters: Filter[] = [];


  constructor(protected service: AbstractService<DTO>) {}

  initTable(){
    this.getDisplayedColumns();
    this.getDisplayedFilters()
    this.getAll();
  }


  getAll() {
    this.service
      .getAll(
        this.pageSize,
        this.pageIndex,
        this.getSortField(),
        this.getDirection(),
        this.filters
      )
      .subscribe(page => {
        this.totalElements = page.totalElements;
        this.dataSource = new MatTableDataSource(page.content);
      });
  }

  getDisplayedColumns() {
    this.service
      .getDisplayedColumns()
      .subscribe(displayedColumns =>
        displayedColumns.forEach(fieldInfo =>
          this.displayedColumns.push(fieldInfo.name)
        )
      );
  }

  getDisplayedFilters() {
    this.service
      .getDisplayedFilters()
      .subscribe(displayedFilters =>
        displayedFilters.forEach(fieldInfo =>
          this.displayedFilters.push(fieldInfo.name)
        )
      );
  }

  delete(id: number) {
    this.service.delete(id).subscribe(() => this.getAll());
  }

  update(dto: DTO) {
    console.log(dto);
    this.service.update(dto).subscribe(() => this.getAll());
  }

  insert(dto: DTO) {
    this.service.insert(dto).subscribe(() => this.getAll());
  }

  select(dto: DTO) {
    this.selected = dto;
  }

  reloadTable(pageEvent: PageEvent) {
    this.pageSize = pageEvent.pageSize;
    this.pageIndex = pageEvent.pageIndex;
    this.getAll();
  }

  sortTable(_event: any) {
    this.getAll();
  }

  applyFilter(filterKey: string, filterValue: string) {
    const filters = [
      ...this.filters.filter(filter => {
        return filter.filterKey !== filterKey && filter.filterValue !== "";
      })
    ];
    if (filterValue !== "") {
      filters.push(new Filter(filterKey, filterValue));
    }
    this.filters = filters;
    this.getAll();
  }

  resetFilters() {
    this.filters = [];
  }

  getField(element: DTO, column: string) {
    const res = element[column];
    if (res instanceof Object) {
      return res.id;
    }
    return res;
  }

  getDirection(): Direction {
    return this.sort.direction === "desc" ? Direction.DESC : Direction.ASC;
  }

  getSortField(): string {
    if (
      this.sort.active !== "" &&
      this.sort.active !== null &&
      this.sort.active !== undefined
    ) {
      this.sortField = this.sort.active;
      return this.sortField;
    }
    return "id";
  }
}
