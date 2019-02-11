import { Injectable } from "@angular/core";
import { Tasklist } from "./tasklist.model";
import { Task } from "./task.model";
import { Observable } from "rxjs";
import { RestDataSource } from "./rest.datasource";

@Injectable()
export class Model {
    tasklist;
    executors = [];

    getTasklist(): Array<Task> {
	let newTL = new Tasklist(this.tasklist);
	return newTL.getItems();
    }

    constructor(private dataSource: RestDataSource) {
        this.tasklist = this.dataSource.getTasklist().subscribe(data => this.tasklist = data);
    }

    getExecutors(): Array<string> {
	return this.dataSource.getExecutors();
    }

    /*saveProduct(product: Product) {
        if (product.id == 0 || product.id == null) {
            this.dataSource.saveProduct(product)
                .subscribe(p => this.products.push(p));
        } else {
            this.dataSource.updateProduct(product).subscribe(p => {
                let index = this.products
                    .findIndex(item => this.locator(item, p.id));
                this.products.splice(index, 1, p);
            });
        }
    }

    deleteProduct(id: number) {
        this.dataSource.deleteProduct(id).subscribe(() => {
            let index = this.products.findIndex(p => this.locator(p, id));
            if (index > -1) {
                this.products.splice(index, 1);
            }
        });
    }*/
}
