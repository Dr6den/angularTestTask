import { Component } from "@angular/core";
import { Model, Tasklist } from "./model/tasklist.model";

@Component({
    selector: "index",
    templateUrl: "./tasklist.component.html"
})
export class TasklistComponent {
    model = new Model();

    getName() {
        return this.model.user;
    }

    getTasklist() {
        return this.model.items.filter(item => !item.done);
    }

    addItem(newItem) {
        if (newItem != "") {
            this.model.items.push(new Tasklist(newItem, newItem, newItem, newItem));
        }
    }
}
