import { Component, Inject } from "@angular/core";
import { NgForm } from "@angular/forms";
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
	
	if(activeRoute.snapshot.params["name"] === undefined) {
		this.task.name = "";
		this.task.startDate = new Date();
		this.task.endDate = new Date();
		this.task.executors = [];
	} else {
		this.task.name = activeRoute.snapshot.params["name"];
		this.task.startDate = activeRoute.snapshot.params["startDate"];
		this.task.endDate = activeRoute.snapshot.params["endDate"];
		this.task.executors = activeRoute.snapshot.params["executors"].split(',');;
	}
	this.task.executors.map(obj => this.executorsMap.set(obj, false));
console.log("##############################" );
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
