import { Injectable } from "@angular/core";
import { Product } from "./product.model";
import { Tasklist } from "./tasklist.model";
import { Observable } from "rxjs";
import { RestDataSource } from "./rest.datasource";

@Injectable()
export class Model {
	user;
    items;
    
    constructor() {
        this.user = "Andrew";
        let executorsTwony = ['helen', 'hope', 'lussi'];
	let executorsTwonyZero = ['maria', 'hope', 'marta'];
	let executorsTwonyFirst = ['helen', 'andrew'];
        this.items = [new Tasklist("10.10.1920", "1.1.1921", "hanging", executorsTwony),
                      new Tasklist("1.5.1920", "11.1.1921", "calculating", executorsTwony),
                      new Tasklist("10.10.1920", "1.5.1922", "tabulating", executorsTwonyZero),
                      new Tasklist("1.8.1920", "1.6.1923", "punch cards collecting", executorsTwonyFirst)]
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
