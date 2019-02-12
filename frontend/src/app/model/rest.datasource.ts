import { Injectable, Inject, InjectionToken } from "@angular/core";
import { HttpClient, HttpHeaders, HttpErrorResponse } from "@angular/common/http";
import { Observable, throwError } from "rxjs";
import { catchError } from "rxjs/operators";
import { Task } from "./task.model";
import { Tasklist } from "../model/tasklist.model";

export const REST_URL = new InjectionToken("rest_url");

@Injectable()
export class RestDataSource {
    constructor(private http: HttpClient,
        @Inject(REST_URL) private url: string) { }

    getTasklist(): Observable<Task[]> {
        let url = this.url + "/getTasklist";
        return this.sendRequest<Task[]>("GET", url);
    }

    getExecutors(): Observable<string[]> {
        let url = this.url + "/getExecutors";
        return this.sendRequest<string[]>("GET", url);
    }


    /*saveProduct(product: Product): Observable<Product> {
        return this.sendRequest<Product>("POST", this.url, product);
    }

    deleteProduct(id: number): Observable<Product> {
        return this.sendRequest<Product>("DELETE", `${this.url}/${id}`);
    }*/

    private sendRequest<T>(verb: string, url: string, body?: Task)
        : Observable<T> {

        let myHeaders = new HttpHeaders();

        return this.http.request<T>(verb, url, {
            body: body,
            headers: myHeaders
        }).pipe(catchError((error: Response) => 
            throwError(`Network Error: ${error.statusText} (${error.status})`)));
    }

}
