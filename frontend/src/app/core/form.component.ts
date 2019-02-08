import { Component, Inject } from "@angular/core";
import { NgForm } from "@angular/forms";
import { Product } from "../model/product.model";
import { Task } from "../model/task.model";
import { Model } from "../model/repository.model";
import { ActivatedRoute, Router } from "@angular/router";

@Component({
    selector: "paForm",
    templateUrl: "form.component.html",
    styleUrls: ["form.component.css"]
})
export class FormComponent {
    task = new Task();
    executorsMap = new Map();

    constructor(private model: Model, activeRoute: ActivatedRoute,
                private router: Router) {

this.task.name="nadia";
this.task.startDate="12.12.2012";
this.task.endDate="12.12.2012";
this.task.executors=['sto','dfjk','ddk'];

this.task.executors.map(obj => this.executorsMap.set(obj, false));

console.log("##############################eeeeee" + this.executorsMap.get('ddk'));
        /*this.editing = activeRoute.snapshot.params["mode"] == "edit";

        let id = activeRoute.snapshot.params["id"];
        if (id != null) {
            let name = activeRoute.snapshot.params["name"];
            let category = activeRoute.snapshot.params["category"];
            let price = activeRoute.snapshot.params["price"];

            if (name != null && category != null && price != null) {
                this.product.id = id;
                this.product.name = name;
                this.product.category = category;
                this.product.price = Number.parseFloat(price);
            } else {
                Object.assign(this.product, model.getProduct(id) || new Product());
            }
        }*/
    }

    editing: boolean = false;

    submitForm(form: NgForm) {console.log("#############################submit"+this.task.startDate);
        if (form.valid) {
            //this.model.saveProduct(this.product);
            //this.product = new Product();
            //form.reset();
            this.router.navigateByUrl("/");
        }
    }

    resetForm() {console.log("#############################reset");
        //this.product = new Product();
    }
}
