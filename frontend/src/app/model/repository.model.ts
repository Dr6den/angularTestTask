import { Injectable } from "@angular/core";
import { Tasklist } from "./tasklist.model";
import { Task } from "./task.model";
import { Observable } from "rxjs";
import { RestDataSource } from "./rest.datasource";

@Injectable()
export class Model {
    tasklist;
    
    constructor() {
        let executorsTwony = ['helen', 'hope', 'lussi'];
	let executorsTwonyZero = ['maria', 'hope', 'marta'];
	let executorsTwonyFirst = ['helen', 'andrew'];
	let tasksArray = [new Task("hanging", new Date(1920, 10, 10), new Date(1921, 1, 1), executorsTwony),
                      new Task("calculating", new Date(1920, 1, 5), new Date(1921, 11, 1), executorsTwony),
                      new Task("tabulating", new Date(1920, 10, 17), new Date(1922, 5, 11), executorsTwonyZero),
                      new Task("punch cards collecting", new Date(1920, 8, 12), new Date(1923, 7, 21), executorsTwonyFirst)];
        this.tasklist = new Tasklist(tasksArray);
    }

    getTasklist(): Array<Task> {
	return this.tasklist.getItems();
    }

    /*private products: Product[] = new Array<Product>();
    private locator = (p: Product, id: number) => p.id == id;

    constructor(private dataSource: RestDataSource) {
        this.dataSource.getData().subscribe(data => this.products = data);
    }

    getProducts(): Product[] {
        return this.products;
    }

    getProduct(id: number): Product {
        return this.products.find(p => this.locator(p, id));
    }

    saveProduct(product: Product) {
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
