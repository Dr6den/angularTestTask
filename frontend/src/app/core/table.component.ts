import { Component, Inject } from "@angular/core";
import { Tasklist } from "../model/tasklist.model";
import { Task } from "../model/task.model";
import { Model } from "../model/repository.model";

@Component({
    selector: "paTable",
    templateUrl: "table.component.html"
})
export class TableComponent {

    constructor(private model: Model) { }

    getTasklist(): Array<Task> {
        return this.model.getTasklist();
    }

    deleteItem(item: Task) {
        console.log(item.name);
	window.location.reload();
    }

    editItem(item: Task) {
        console.log(item.name);
    }
}
