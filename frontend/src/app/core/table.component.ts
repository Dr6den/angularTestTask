import { Component, Inject } from "@angular/core";
import { Tasklist } from "../model/tasklist.model";
import { Model } from "../model/repository.model";

@Component({
    selector: "paTable",
    templateUrl: "table.component.html"
})
export class TableComponent {

    constructor(private model: Model) { }

    /*getProduct(key: number): Product {
        return this.model.getProduct(key);
    }

    getProducts(): Product[] {
        return this.model.getProducts();
    }*/

    getTasklist(): Tasklist {
        return this.model.items.filter(item => !item.done);
    }

    /*deleteProduct(key: number) {
        this.model.deleteProduct(key);
    }*/

    //editProduct(key: number) {
    //    this.observer.next(new SharedState(MODES.EDIT, key));
    //}

    //createProduct() {
    //    this.observer.next(new SharedState(MODES.CREATE));
    //}
}
