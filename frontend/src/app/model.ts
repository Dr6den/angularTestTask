export class Model {
    user;
    items;
    
    constructor() {
        this.user = "Andrew";
        let executorsTwony = ['helen', 'hope', 'lussi'];
	let executorsTwonyZero = ['maria', 'hope', 'marta'];
	let executorsTwonyFirst = ['helen', 'andrew'];
        this.items = [new TodoItem("10.10.1920", "1.1.1921", "hanging", executorsTwony),
                      new TodoItem("1.5.1920", "11.1.1921", "calculating", executorsTwony),
                      new TodoItem("10.10.1920", "1.5.1922", "tabulating", executorsTwonyZero),
                      new TodoItem("1.8.1920", "1.6.1923", "punch cards collecting", executorsTwonyFirst)]
    }
}

export class TodoItem {
    startDate;
    endDate;
    activity;
    executors;

    constructor(startDate, endDate, activity, executors) {
        this.startDate = startDate;
        this.endDate = endDate;
	this.activity = activity;
        this.executors = executors;
    }
}
